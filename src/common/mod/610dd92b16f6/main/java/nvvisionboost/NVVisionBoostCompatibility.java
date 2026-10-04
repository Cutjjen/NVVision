/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostCompatibility.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.neoforged.fml.ModList;

/** Detecção centralizada; metadados reflexivos são resolvidos uma vez. */
public final class NVVisionBoostCompatibility {
  private static final ConcurrentHashMap<String, Boolean> MODS = new ConcurrentHashMap<>();
  private static Object api;
  private static Method activeMethod,
      configMethod,
      packMethod,
      enabledMethod,
      managerMethod,
      pipelineMethod;
  private static boolean resolved;
  private static long nextResolve;

  private NVVisionBoostCompatibility() {}

  public static boolean loaded(String id) {
    return nvvisionboost.platform.Platform.get().modLoaded(id);
  }

  public static boolean oculus() {
    return loaded("oculus");
  }

  public static boolean iris() {
    return loaded("iris");
  }

  public static boolean embeddium() {
    return loaded("embeddium");
  }

  public static boolean sodium() {
    return loaded("sodium");
  }

  public static boolean modMenu() {
    return loaded("modmenu");
  }

  public static boolean externalShaderBackendAvailable() {
    return oculus() || iris();
  }

  private static synchronized void resolve() {
    if (resolved || !externalShaderBackendAvailable()) return;
    long now = System.nanoTime();
    if (now < nextResolve) return;
    nextResolve = now + 1_000_000_000L;
    for (String prefix : new String[] {"net.irisshaders.iris", "net.coderbot.iris"}) {
      try {
        Class<?> backend = Class.forName(prefix + ".Iris");
        try {
          Class<?> apiType = Class.forName(prefix + ".api.v0.IrisApi");
          api = apiType.getMethod("getInstance").invoke(null);
          activeMethod = apiType.getMethod("isShaderPackInUse");
        } catch (ReflectiveOperationException ignored) {
        }
        configMethod = backend.getMethod("getIrisConfig");
        Object config = configMethod.invoke(null);
        if (config != null) {
          packMethod = config.getClass().getMethod("getShaderPackName");
          enabledMethod = config.getClass().getMethod("areShadersEnabled");
        }
        managerMethod = backend.getMethod("getPipelineManager");
        Object manager = managerMethod.invoke(null);
        if (manager != null) pipelineMethod = manager.getClass().getMethod("getPipeline");
        resolved =
            api != null && activeMethod != null && configMethod != null && managerMethod != null;
        return;
      } catch (ReflectiveOperationException | LinkageError ignored) {
      }
    }
  }

  static Object shaderPipeline() throws ReflectiveOperationException {
    resolve();
    if (managerMethod == null) return null;
    Object manager = managerMethod.invoke(null);
    if (manager == null) return null;
    if (pipelineMethod == null) pipelineMethod = manager.getClass().getMethod("getPipeline");
    Object value = pipelineMethod.invoke(manager);
    return value instanceof Optional<?> optional ? optional.orElse(null) : value;
  }

  public static boolean externalShadersInUse() {
    resolve();
    try {
      return api != null && activeMethod != null && Boolean.TRUE.equals(activeMethod.invoke(api));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError ignored) {
      return false;
    }
  }

  /** Fail closed if Iris state cannot be read; never guess during a shader reload. */
  public static String framebufferScalingRestriction() {
    if (!externalShaderBackendAvailable()) return "";
    resolve();
    if (api == null || activeMethod == null || configMethod == null || enabledMethod == null)
      return "Estado do Iris indisponível; escala nativa por segurança.";
    try {
      Object config = configMethod.invoke(null);
      if (config == null) return "Iris inicializando; escala nativa por segurança.";
      Object enabled = enabledMethod.invoke(config);
      Object active = activeMethod.invoke(api);
      if (!(enabled instanceof Boolean) || !(active instanceof Boolean))
        return "Estado do Iris indisponível; escala nativa por segurança.";
      if (Boolean.FALSE.equals(enabled) && Boolean.FALSE.equals(active)) return "";
      return NVVisionBoostIrisDepthSafety.validated ? "" : "Resolução nativa: integração de profundidade Iris não validada.";
    } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
      return "Iris recarregando; escala nativa por segurança.";
    }
  }

  /** Persisted choice is available in the menu, before a world pipeline exists. */
  public static boolean externalShadersEnabled() {
    resolve();
    try {
      Object config = configMethod == null ? null : configMethod.invoke(null);
      if (config != null && enabledMethod == null)
        enabledMethod = config.getClass().getMethod("areShadersEnabled");
      return config != null
          && enabledMethod != null
          && Boolean.TRUE.equals(enabledMethod.invoke(config));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError ignored) {
      return false;
    }
  }

  public static String externalShaderPackName() {
    resolve();
    try {
      if (configMethod == null) return "";
      Object config = configMethod.invoke(null);
      if (config == null) return "";
      if (packMethod == null) packMethod = config.getClass().getMethod("getShaderPackName");
      Object value = packMethod.invoke(config);
      if (value instanceof Optional<?> optional) value = optional.orElse(null);
      return value == null ? "" : value.toString();
    } catch (ReflectiveOperationException | RuntimeException | LinkageError ignored) {
      return "";
    }
  }

  @Deprecated
  public static boolean applyExternalShaderPack(String name) {
    return NVVisionBoostShaderEngine.activateWithIris(NVVisionBoostCore.gameRoot(), name);
  }

  @Deprecated
  public static boolean disableExternalShaders() {
    return NVVisionBoostShaderEngine.disableExternal();
  }

  public static String renderer() {
    return embeddium() ? "Embeddium" : sodium() ? "Sodium" : "Vanilla";
  }

  public static String shaderBackend() {
    return oculus() ? "Oculus" : iris() ? "Iris" : "Nenhum";
  }

  public static String summary() {
    return "Renderer="
        + renderer()
        + " | ShaderBackend="
        + shaderBackend()
        + " | ShaderAtivo="
        + externalShadersInUse()
        + " | Pack="
        + externalShaderPackName();
  }

  public static String integrationSummary() {
    return summary() + " | FerriteCore=" + loaded("ferritecore") + " | Create=" + loaded("create") + " | DH=" + loaded("distanthorizons");
  }

  public static boolean isShaderScreen(Object screen) {
    if (screen == null) return false;
    String name = screen.getClass().getName().toLowerCase(Locale.ROOT);
    return name.contains("oculus")
        || name.contains("iris")
        || name.contains("shaderpack")
        || name.contains("shaderoptions")
        || name.contains("shaderscreen");
  }
}

