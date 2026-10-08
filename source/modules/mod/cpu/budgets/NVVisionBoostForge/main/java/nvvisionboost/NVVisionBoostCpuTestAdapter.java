package nvvisionboost;

import java.lang.reflect.Method;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;

/** Optional-addon contract cached outside per-particle reflection paths. */
public final class NVVisionBoostCpuTestAdapter {
  private static long nextCheck;
  private static int particles, models;
  private static Method counters;
  private static long discarded, skipped;
  private static java.util.Set<?> namespaces = java.util.Set.of();

  private NVVisionBoostCpuTestAdapter() {}

  private static void refresh() {
    long now = System.nanoTime();
    if (now < nextCheck) return;
    nextCheck = now + 250_000_000L;
    particles = models = 0;
    if (NVVisionBoostForge.cfg == null || !NVVisionBoostForge.cfg.enabled) return;
    try {
      Class<?> api = Class.forName("nvvisionboost.vulkanbridge.CpuTestBudgets");
      particles = (Integer) api.getMethod("particleRadius").invoke(null);
      // Shadows, machine instancing and distant renderers must retain their geometry.
      if (!NVVisionBoostCompatibility.externalShadersEnabled())
        models = (Integer) api.getMethod("modelRadius").invoke(null);
      namespaces = (java.util.Set<?>) api.getMethod("modelNamespaces").invoke(null);
      counters = api.getMethod("recordCounters", long.class, long.class, int.class);
      counters.invoke(null, discarded, skipped, models);
      discarded = skipped = 0;
    } catch (ReflectiveOperationException | LinkageError unavailable) {
      particles = models = 0;
    }
  }

  /**
   * Queried on option updates, not cached with particle budgets: ownership must change immediately
   * when the player disables the budget or leaves a world. Missing addons retain the original
   * main-controller behavior.
   */
  public static boolean ownsSimulation() {
    try {
      Class<?> api = Class.forName("nvvisionboost.vulkanbridge.CpuTestBudgets");
      return Boolean.TRUE.equals(api.getMethod("ownsSimulation").invoke(null));
    } catch (ReflectiveOperationException | LinkageError unavailable) {
      return false;
    }
  }

  public static int modelRadius() {
    refresh();
    return models;
  }

  public static boolean supportsModel(String namespace) {
    return namespaces.contains(namespace);
  }

  public static void modelSkipped() {
    skipped++;
  }

  public static boolean discardParticle(Particle particle) {
    refresh();
    Minecraft mc = Minecraft.getInstance();
    if (particles <= 0 || mc.level == null || mc.gameRenderer == null || particle == null)
      return false;
    var camera = nvvisionboost.minecraft.MinecraftAccess.get().cameraPosition();
    var center = particle.getBoundingBox().getCenter();
    double squared = center.distanceToSqr(camera);
    if (!Double.isFinite(squared) || squared <= (double) particles * particles) return false;
    discarded++;
    return true;
  }
}
