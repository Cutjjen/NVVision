package nvvisionboost.vulkanbridge;

import java.io.StringWriter;
import java.nio.file.*;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import nvvisionboost.vulkanbridge.platform.Platform;
import org.slf4j.LoggerFactory;

/**
 * Shared client CPU budgets for supported modern Minecraft backends. Particle admission and model
 * distance affect presentation only. Simulation leases apply exclusively to the integrated server;
 * remote server ticks remain untouched. The historical class and properties-file names preserve
 * existing player settings.
 */
public final class CpuTestBudgets {
  private static final CpuOptionLease<Integer> SIMULATION = new CpuOptionLease<>();
  private static Path file;
  private static int simulation, models, particleRange;
  private static long nextLog, discardedParticles, skippedModels;
  private static boolean modelSafe;
  private static int effectiveModels;

  private CpuTestBudgets() {}

  public static void initialize(Path directory) {
    if (file != null) return;
    file = directory.resolve("cpu-test.properties");
    try {
      Properties p = read();
      simulation = parse(p, "simulation");
      models = parse(p, "models");
      particleRange = parse(p, "particleRange");
    } catch (Exception e) {
      LoggerFactory.getLogger("NVVisionCPU").warn("Test budgets unavailable; disabled.", e);
    }
    // Instanced and distant world renderers retain ownership of their models.
    try {
      var mods = Platform.get();
      modelSafe =
          mods != null
              && !mods.modLoaded("flywheel")
              && !mods.modLoaded("create")
              && !mods.modLoaded("distanthorizons");
    } catch (RuntimeException | LinkageError unavailable) {
      modelSafe = false;
    }
  }

  private static int parse(Properties p, String key) {
    try {
      return CpuTestPolicy.normalize(key, Integer.parseInt(p.getProperty(key, "0")));
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  private static Properties read() throws java.io.IOException {
    Properties p = new Properties();
    if (Files.exists(file))
      try (var input = Files.newInputStream(file)) {
        p.load(input);
      }
    return p;
  }

  public static boolean owns(String key) {
    return key.equals("simulation") || key.equals("models") || key.equals("particleRange");
  }

  public static String control(String key) {
    int value =
        switch (key) {
          case "simulation" -> simulation;
          case "models" -> models;
          case "particleRange" -> particleRange;
          default -> 0;
        };
    return value == 0
        ? "Desligado"
        : value + (key.equals("simulation") ? " chunks (mundo local)" : " blocos");
  }

  public static String cycle(String key) {
    if (file == null || !owns(key)) return "Controle indisponível.";
    try {
      Properties p = read();
      int old =
          switch (key) {
            case "simulation" -> simulation;
            case "models" -> models;
            default -> particleRange;
          };
      int value = CpuTestPolicy.next(key, old);
      p.setProperty(key, Integer.toString(value));
      StringWriter text = new StringWriter();
      p.store(text, "Cutjjen - opt-in local CPU test budgets");
      BridgeFiles.atomic(file, text.toString());
      switch (key) {
        case "simulation" -> simulation = value;
        case "models" -> models = value;
        default -> particleRange = value;
      }
      nextLog = 0;
      return BridgeCpuOptimizer.request("custom") + "; " + key + "=" + control(key);
    } catch (Exception e) {
      LoggerFactory.getLogger("NVVisionCPU").warn("Test choice not saved.", e);
      return "Falha ao salvar controle.";
    }
  }

  private static boolean enabled() {
    return !BridgeCpuOptimizer.mode().equals("off");
  }

  /**
   * Shared ownership contract: the main controller must not restore this option while the
   * explicitly enabled local simulation budget owns it. Remote worlds never acquire ownership;
   * external option edits still use the lease policy.
   */
  public static boolean ownsSimulation() {
    Minecraft mc = Minecraft.getInstance();
    return enabled()
        && simulation > 0
        && mc != null
        && mc.level != null
        && mc.getSingleplayerServer() != null;
  }

  /** Applies a CPU-only option at client-tick end; no shader reset is required. */
  public static void tick() {
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || mc.options == null) return;
    int current = mc.options.simulationDistance().get();
    boolean local = mc.level != null && mc.getSingleplayerServer() != null;
    int desired =
        enabled() && simulation > 0 && local
            ? SIMULATION.update(current, CpuTestPolicy.simulation(current, simulation, true))
            : SIMULATION.release(current);
    if (desired != current) {
      mc.options.simulationDistance().set(desired);
    }
    long now = System.nanoTime();
    if (mc.level != null
        && enabled()
        && now >= nextLog
        && (simulation > 0 || models > 0 || particleRange > 0)) {
      nextLog = now + 30_000_000_000L;
      LoggerFactory.getLogger("NVVisionCPU")
          .info(
              "[CPU test] localServer={} simulation={} requestedSimulation={} modelsApplied={}"
                  + " modelAdapterSafe={} particles={} rejectedParticles={} skippedModels={}",
              local,
              desired,
              simulation,
              effectiveModels,
              modelSafe,
              particleRange,
              discardedParticles,
              skippedModels);
      discardedParticles = skippedModels = 0;
    }
  }

  public static int particleRadius() {
    return enabled() ? particleRange : 0;
  }

  public static int modelRadius() {
    return enabled() && modelSafe ? models : 0;
  }

  public static java.util.Set<String> modelNamespaces() {
    return CpuTestPolicy.MODEL_NAMESPACES;
  }

  /** Called at most four times per second, never once per discarded visual. */
  public static void recordCounters(long particles, long models, int effective) {
    discardedParticles += particles;
    skippedModels += models;
    effectiveModels = effective;
  }

  public static void shutdown() {
    Minecraft mc = Minecraft.getInstance();
    if (mc != null && mc.options != null) {
      int v = mc.options.simulationDistance().get();
      mc.options.simulationDistance().set(SIMULATION.release(v));
    }
  }
}
