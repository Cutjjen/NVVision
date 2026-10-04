/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Controles e aplicação reversível de otimizações.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostPerformance.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;

/** Regras opcionais de custo visual. Nenhuma altera ticks ou dados do mundo. */
public final class NVVisionBoostPerformance {
  private static boolean blockEntityCullingAllowed;
  private static long nextCheck;

  private NVVisionBoostPerformance() {}

  public static void tick(NVVisionBoostCore.Config config) {
    if (config == null || !config.enabled || !config.blockEntityDistanceLimit) {
      blockEntityCullingAllowed = false;
      nextCheck = 0L;
      return;
    }
    long now = System.nanoTime();
    if (now < nextCheck) return;
    nextCheck = now + 250_000_000L;
    // Não remova geometria dos passes de sombras ou dos renderizadores de máquinas.
    blockEntityCullingAllowed =
        !NVVisionBoostCompatibility.externalShaderBackendAvailable()
            && !NVVisionBoostCreateCompatibility.protectsMachineRendering();
  }

  public static boolean limitBlockEntities() {
    var config = NVVisionBoostCore.cfg;
    return config != null
        && config.enabled
        && config.blockEntityDistanceLimit
        && blockEntityCullingAllowed;
  }

  public static int blockEntityDistance() {
    var config = NVVisionBoostCore.cfg;
    return config == null ? 64 : config.blockEntityDistance;
  }

  public static boolean reduceWeatherParticles() {
    var config = NVVisionBoostCore.cfg;
    return config != null && config.enabled && config.reduceWeatherParticles;
  }

  public static int framerateLimit(int currentLimit) {
    var config = NVVisionBoostCore.cfg;
    if (config == null
        || !config.enabled
        || !config.backgroundFpsLimit
        || Minecraft.getInstance().isWindowActive()) return currentLimit;
    return Math.min(currentLimit, config.backgroundFps);
  }
}



