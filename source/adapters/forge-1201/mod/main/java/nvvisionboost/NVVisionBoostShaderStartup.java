package nvvisionboost;

import com.mojang.blaze3d.systems.RenderSystem;
import java.lang.reflect.Method;
import java.util.Optional;
import net.minecraft.client.Minecraft;

/** Prepare on the GL thread before world rendering, never by reloading every frame. */
public final class NVVisionBoostShaderStartup {
  private static final NVVisionBoostShaderStartupPolicy POLICY =
      new NVVisionBoostShaderStartupPolicy();
  private static Class<?> backend;
  private static Method packMethod, managerMethod, dimensionMethod, prepareMethod;
  private static boolean resolvingFailed;
  private static Object syncedWorld, syncedPipeline;
  private static boolean flywheelSynced, waitingLogged;
  private static long nextSyncCheck;
  private static String status = "Aguardando recursos do backend.";

  private NVVisionBoostShaderStartup() {}

  public static void beforeRender() {
    Minecraft mc = Minecraft.getInstance();
    var cfg = NVVisionBoostForge.cfg;
    if (mc == null
        || cfg == null
        || !cfg.enabled
        || !cfg.irisIntegration
        || !NVVisionBoostCompatibility.externalShaderBackendAvailable()
        || !NVVisionBoostCompatibility.externalShadersEnabled()) {
      POLICY.reset();
      flywheelSynced = false;
      syncedWorld = syncedPipeline = null;
      nextSyncCheck = 0;
      return;
    }
    if (!RenderSystem.isOnRenderThread() || mc.getOverlay() != null) return;
    if (NVVisionBoostMemoryMonitor.underPressure()) return;
    // Warmup is optional; the Create/Flywheel synchronization protects actual worlds.
    if (!cfg.shaderWarmup
        && !(mc.level != null && NVVisionBoostCreateCompatibility.protectsMachineRendering()))
      return;
    if (resolvingFailed) return;
    String pack = NVVisionBoostCompatibility.externalShaderPackName();
    if (pack == null || pack.isBlank()) return;
    try {
      if (backend == null) {
        resolvingFailed = true;
        for (String name : new String[] {"net.irisshaders.iris.Iris", "net.coderbot.iris.Iris"}) {
          try {
            backend = Class.forName(name);
            break;
          } catch (ClassNotFoundException ignored) {
          }
        }
        if (backend == null) {
          resolvingFailed = true;
          return;
        }
        packMethod = backend.getMethod("getCurrentPack");
        managerMethod = backend.getMethod("getPipelineManager");
        dimensionMethod = backend.getMethod("getCurrentDimension");
        resolvingFailed = false;
      }
      Object currentPack = packMethod.invoke(null);
      if (currentPack instanceof Optional<?> optional && optional.isEmpty()) return;
      Object manager = managerMethod.invoke(null);
      if (manager == null) return;
      Object previous = NVVisionBoostCompatibility.shaderPipeline();
      if (!POLICY.begin(mc.level, pack, previous)) {
        if (previous != null && NVVisionBoostCompatibility.externalShadersInUse())
          synchronizeFlywheel(mc, previous);
        return;
      }
      // A user/backend reload already prepared this world's pipeline. Do not prepare it twice.
      if (mc.level == syncedWorld
          && previous != null
          && NVVisionBoostCompatibility.externalShadersInUse()) {
        POLICY.complete(previous);
        synchronizeFlywheel(mc, previous);
        return;
      }
      // The backend supplies its supported default while still in the menu.
      Object dimension = dimensionMethod.invoke(null);
      if (dimension == null) return;
      if (mc.level != null) {
        var id = mc.level.dimension().location();
        dimension =
            dimension
                .getClass()
                .getConstructor(String.class, String.class)
                .newInstance(id.getNamespace(), id.getPath());
      }
      if (prepareMethod == null)
        prepareMethod = manager.getClass().getMethod("preparePipeline", dimension.getClass());
      Object prepared = prepareMethod.invoke(manager, dimension);
      POLICY.complete(prepared);
      if (!NVVisionBoostCompatibility.externalShadersInUse()) {
        status = "Backend não ativou o pipeline selecionado; nenhuma recarga automática repetida.";
        NVVisionBoostForge.log("[NVVB Inicialização] " + status);
        return;
      }
      NVVisionBoostNativeRenderer.reset();
      synchronizeFlywheel(mc, prepared);
      NVVisionBoostRenderController.pauseAdaptation(15_000L);
      status =
          "Pipeline preparado "
              + (mc.level == null ? "no menu" : "antes do primeiro passe da dimensão")
              + ": "
              + pack;
      NVVisionBoostForge.log("[NVVB Inicialização] " + status);
    } catch (ReflectiveOperationException | RuntimeException | LinkageError error) {
      Throwable cause = error;
      while (cause.getCause() != null && cause.getCause() != cause) cause = cause.getCause();
      status =
          "Preparo antecipado não concluído: "
              + cause.getClass().getSimpleName()
              + ": "
              + cause.getMessage();
      NVVisionBoostForge.log("[NVVB Inicialização] " + status);
    }
  }

  private static void synchronizeFlywheel(Minecraft mc, Object pipeline)
      throws ReflectiveOperationException {
    if (!NVVisionBoostCompatibility.loaded("ocuwheel")
        || !NVVisionBoostCreateCompatibility.flywheelLoaded()) return;
    if (syncedWorld != mc.level || syncedPipeline != pipeline) {
      syncedWorld = mc.level;
      syncedPipeline = pipeline;
      flywheelSynced = waitingLogged = false;
      nextSyncCheck = 0;
    }
    if (flywheelSynced || System.nanoTime() < nextSyncCheck) return;
    nextSyncCheck = System.nanoTime() + 1_000_000_000L;
    Class<?> integration = Class.forName("com.chaoscraft.ocuwheel.integration.OcuwheelIntegration");
    if (!Boolean.TRUE.equals(integration.getMethod("isCompatBackendSupported").invoke(null))) {
      if (!waitingLogged)
        NVVisionBoostForge.log(
            "[NVVB Inicialização] Ocuwheel ainda sem programas compatíveis; seleção do backend"
                + " preservada.");
      waitingLogged = true;
      return;
    }
    flywheelSynced = true;
    if (mc.level == null) {
      // Reevaluate only after the menu pipeline exists; keep Flywheel's user preference.
      Class.forName("dev.engine_room.flywheel.impl.BackendManagerImpl")
          .getMethod("onEndClientResourceReload", boolean.class)
          .invoke(null, false);
    } else {
      // Ocuwheel posts its normal reload event and rebuilds existing visualizations.
      integration
          .getMethod("requestBackendReselection", String.class)
          .invoke(null, "NVVisionBoost: pipeline pronto antes do passe do mundo");
    }
    NVVisionBoostForge.log(
        "[NVVB Inicialização] Flywheel sincronizado após o pipeline; preferência preservada.");
  }

  public static String status() {
    return status;
  }
}
