package nvvisionboost;

import net.minecraft.client.Minecraft;

/** Optional visual-cost rules do not change world ticks or data. */
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
    // Preserve geometry in shadow passes and machine renderers.
    blockEntityCullingAllowed =
        !NVVisionBoostCompatibility.externalShaderBackendAvailable()
            && !NVVisionBoostCreateCompatibility.protectsMachineRendering();
  }

  public static boolean limitBlockEntities() {
    var config = NVVisionBoostCore.cfg;
    return config != null
        && config.enabled
        && !NVVisionBoostVulkanBridge.present()
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
