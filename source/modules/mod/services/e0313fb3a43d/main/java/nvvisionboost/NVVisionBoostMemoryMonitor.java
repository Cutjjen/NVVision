package nvvisionboost;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

<<<<<<< HEAD
/** Heap telemetry never forces garbage collection or deletes other mods' resources. */
=======
/** Telemetria de heap; nunca força coleta nem elimina recursos de outros mods. */
>>>>>>> origin/master
public final class NVVisionBoostMemoryMonitor {
  private static long nextSample, nextLog, lastGcCount, lastGcMs;
  private static boolean pressure;

  private NVVisionBoostMemoryMonitor() {}

  public static boolean underPressure() {
    return pressure;
  }

  public static void tick(NVVisionBoostCore.Config cfg) {
    if (cfg == null || !cfg.enabled || !cfg.memoryGuard) {
      pressure = false;
      nextSample = 0;
      return;
    }
    long now = System.nanoTime();
    if (now < nextSample) return;
    nextSample = now + 5_000_000_000L;
    Runtime runtime = Runtime.getRuntime();
    long used = runtime.totalMemory() - runtime.freeMemory();
    long max = runtime.maxMemory();
    pressure = cfg.memoryGuard && max > 0 && used / (double) max >= 0.85;
    if (pressure) NVVisionBoostRenderController.pauseAdaptation(10_000L);
    if (now < nextLog) return;
    nextLog = now + 60_000_000_000L;
    long count = 0, time = 0;
    for (GarbageCollectorMXBean collector : ManagementFactory.getGarbageCollectorMXBeans()) {
      count += Math.max(0, collector.getCollectionCount());
      time += Math.max(0, collector.getCollectionTime());
    }
    NVVisionBoostCore.log(
        "Memória Java: heap="
            + used / 1048576
            + "/"
            + max / 1048576
            + " MiB | GC desde última amostra="
            + Math.max(0, count - lastGcCount)
            + " coletas / "
            + Math.max(0, time - lastGcMs)
            + " ms | pressão="
            + pressure);
    lastGcCount = count;
    lastGcMs = time;
  }
}
