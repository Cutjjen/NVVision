package nvvisionboost;

import net.minecraft.client.Minecraft;

/** Prepara o pack ativo uma vez por mundo/pack, sem reload por frame ou escala. */
public final class NVVisionBoostShaderLifecycle {
  private static Object world;
  private static String observed = "", attempted = "";
  private static int stableSamples;
  private static long nextCheck;

  private NVVisionBoostShaderLifecycle() {}

  public static void tick(NVVisionBoostCore.Config cfg) {
    Minecraft mc = Minecraft.getInstance();
    if (cfg == null
        || !cfg.enabled
        || !cfg.irisIntegration
        || (!cfg.shaderCache && !cfg.shaderWarmup && !cfg.shaderAutoProfile)
        || mc == null) {
      world = null;
      observed = attempted = "";
      stableSamples = 0;
      nextCheck = 0;
      return;
    }
    long now = System.nanoTime();
    if (now < nextCheck || mc.getOverlay() != null) return;
    nextCheck = now + 1_000_000_000L;
    if (world != mc.level) {
      world = mc.level;
      // A pack already read in the menu need not restart analysis on entry.
    }
    if (!NVVisionBoostCompatibility.externalShadersEnabled()) {
      observed = "";
      stableSamples = 0;
      return; // Não liga shaders que o usuário desativou no Oculus.
    }
    String pack = NVVisionBoostCompatibility.externalShaderPackName();
    if (pack == null || pack.isBlank()) return;
    if (!pack.equals(observed)) {
      observed = pack;
      stableSamples = 1;
      return;
    }
    stableSamples = Math.min(2, stableSamples + 1);
    if (stableSamples < 2 || pack.equals(attempted)) return;
    if (NVVisionBoostMemoryMonitor.underPressure()) return;
    if (NVVisionBoostShaderEngine.prepareAsync(NVVisionBoostCore.gameRoot(), pack, false)) {
      attempted = pack;
      NVVisionBoostRenderController.pauseAdaptation(15_000L);
    }
  }

  /** O botão manual também satisfaz a preparação desta sessão. */
  public static void markPrepared(String pack) {
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || pack == null) return;
    world = mc.level;
    observed = attempted = pack;
    stableSamples = 2;
  }
}
