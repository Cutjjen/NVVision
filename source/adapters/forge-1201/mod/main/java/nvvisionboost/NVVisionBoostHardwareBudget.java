package nvvisionboost;

import oshi.SystemInfo;

/** Orçamento conservador de recursos; não altera heap nem cria workers. */
public final class NVVisionBoostHardwareBudget {
  public record Snapshot(
      String cpu,
      int physicalCores,
      int logicalThreads,
      int availableThreads,
      long allocatedRamMB,
      long systemRamMB) {
    public String summary() {
      return cpu
          + " | "
          + physicalCores
          + " núcleos / "
          + logicalThreads
          + " threads | Java: "
          + allocatedRamMB
          + " MiB";
    }
  }

  private static volatile Snapshot cached;

  private NVVisionBoostHardwareBudget() {}

  public static synchronized Snapshot detect() {
    if (cached != null) return cached;
    int available = Math.max(1, Runtime.getRuntime().availableProcessors());
    int physical = 0, logical = available;
    String cpu = "CPU (núcleos físicos não informados)";
    long ram = -1;
    try {
      var hardware = new SystemInfo().getHardware();
      var processor = hardware.getProcessor();
      physical = processor.getPhysicalProcessorCount();
      logical = processor.getLogicalProcessorCount();
      cpu = processor.getProcessorIdentifier().getName();
      ram = hardware.getMemory().getTotal() / (1024L * 1024L);
    } catch (RuntimeException | LinkageError ignored) {
    }
    cached =
        new Snapshot(
            cpu,
            physical,
            logical,
            available,
            Runtime.getRuntime().maxMemory() / (1024L * 1024L),
            ram);
    return cached;
  }

  public static void constrain(NVVisionBoostForge.Config config) {
    Snapshot info = detect();
    int physical =
        info.physicalCores() > 0 ? info.physicalCores() : Math.max(1, info.availableThreads() / 2);
    int cpuLimit = Math.min(physical, info.availableThreads());
    int cpuDistance = cpuLimit <= 2 ? 8 : cpuLimit <= 4 ? 12 : cpuLimit <= 6 ? 16 : 20;
    long ram = info.allocatedRamMB();
    int ramDistance = ram < 3072 ? 6 : ram < 5120 ? 10 : ram < 8192 ? 14 : ram < 12288 ? 18 : 22;
    int distance = Math.min(cpuDistance, ramDistance);
    config.minRenderDistance = Math.min(config.minRenderDistance, distance);
    config.renderDistance = Math.max(2, Math.min(config.renderDistance, distance));
    config.maxRenderDistance =
        Math.max(config.minRenderDistance, Math.min(config.maxRenderDistance, distance));
    if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
      config.entityDistancePercent =
          Math.min(
              config.entityDistancePercent,
              cpuLimit <= 2 || ram < 3072 ? 65 : cpuLimit <= 4 ? 80 : 100);
    }
    if (ram < 3072 || cpuLimit <= 2) {
      config.profile = "low";
      config.reduceParticles = true;
    }
  }
}
