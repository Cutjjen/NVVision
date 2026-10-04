/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Renderização, escala e controle de desempenho.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionDynamicController.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;

/**
 * Monitor legado. A escala pertence exclusivamente ao RenderController. Preserva o ponto de entrada
 * dos eventos e acompanha mudanças de mundo/shader, sem disputar presets, gravar configurações a
 * cada tick ou recarregar shaders.
 */
public final class NVVisionDynamicController {
  private static Object trackedWorld;
  private static long lastSampleNanos;
  private static boolean shaderStateInitialized, lastShaderActive;
  private static String lastShaderName = "";
  private static double averageFps;
  private static int lowSamples, stableSamples;

  private NVVisionDynamicController() {}

  public static double averageFps() {
    return averageFps;
  }

  public static int lowFpsSamples() {
    return lowSamples;
  }

  public static int stableFpsSamples() {
    return stableSamples;
  }

  public static void tickDynamicPerformance() {
    Minecraft mc = Minecraft.getInstance();
    NVVisionBoostCore.Config config = NVVisionBoostCore.cfg;
    if (mc == null || mc.level == null || mc.player == null) {
      resetTracking();
      return;
    }
    if (trackedWorld != mc.level) {
      resetTracking();
      trackedWorld = mc.level;
      NVVisionBoostRenderController.pauseAdaptation(15000L);
    }
    if (config == null
        || !VisionOptimizer.isEnabled()
        || mc.getOverlay() != null
        || NVVisionBoostTextureOptimizer.isBusy()) return;
    long now = System.nanoTime();
    if (lastSampleNanos != 0 && now - lastSampleNanos < 1_000_000_000L) return;
    lastSampleNanos = now;
    checkShaderState();
    int fps = mc.getFps();
    if (fps <= 0) return;
    averageFps = averageFps == 0 ? fps : averageFps * 0.8 + fps * 0.2;
    int target = Math.max(20, config.targetFps);
    if (fps < target * 0.85) {
      lowSamples = Math.min(1000, lowSamples + 1);
      stableSamples = 0;
    } else if (fps > target * 1.10) {
      stableSamples = Math.min(1000, stableSamples + 1);
      lowSamples = 0;
    } else {
      lowSamples = 0;
      stableSamples = 0;
    }
    // Forge registra FPS e chama observePerformance/adapt no controlador central.
  }

  private static void checkShaderState() {
    try {
      boolean active = NVVisionBoostCompatibility.externalShadersInUse();
      String name = NVVisionBoostCompatibility.externalShaderPackName();
      if (name == null) name = "";
      if (shaderStateInitialized && (active != lastShaderActive || !name.equals(lastShaderName))) {
        lowSamples = stableSamples = 0;
        NVVisionBoostRenderController.pauseAdaptation(15000L);
        NVVisionBoostNativeRenderer.invalidate();
        NVVisionBoostCore.log("Shader alterado: " + name + "; aquecimento da adaptação.");
      }
      shaderStateInitialized = true;
      lastShaderActive = active;
      lastShaderName = name;
    } catch (RuntimeException error) {
      // Falhas opcionais não forçam troca de escala ou repetição de reload.
    }
  }

  public static void resetTracking() {
    trackedWorld = null;
    lastSampleNanos = 0;
    shaderStateInitialized = false;
    lastShaderName = "";
    lastShaderActive = false;
    averageFps = 0;
    lowSamples = stableSamples = 0;
  }
}



