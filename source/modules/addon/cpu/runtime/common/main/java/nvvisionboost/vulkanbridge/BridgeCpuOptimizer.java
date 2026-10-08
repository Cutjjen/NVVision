package nvvisionboost.vulkanbridge;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Cutjjen: persistence, client-thread application and reversible option ownership. */
public final class BridgeCpuOptimizer {
  private static final Logger LOG = LoggerFactory.getLogger("NVVisionCPU");
  private static final CpuOptionLease<Double> DISTANCE = new CpuOptionLease<>();
  private static final CpuOptionLease<Integer> PARTICLES = new CpuOptionLease<>();
  private static String profile = "off", customDistance = "off", customParticles = "off";
  private static boolean initialized, active;
  private static long nextCheck;
  private static Path config;
  private static Runnable pendingChange;

  private BridgeCpuOptimizer() {}

  /** Report whether the addon has read its local configuration. */
  public static boolean initialized() {
    return initialized;
  }

  /** Return the active in-memory CPU profile for the configuration screen. */
  public static String mode() {
    return profile;
  }

  /** Read an individual saved control; unknown controls are unavailable. */
  public static String control(String key) {
    if (CpuTestBudgets.owns(key)) return CpuTestBudgets.control(key);
    return switch (key) {
      case "distance" -> customDistance;
      case "particles" -> customParticles;
      default -> "unavailable";
    };
  }

  /** Load local controls once; unreadable configuration leaves optimization disabled. */
  public static void initialize(Path directory) {
    if (initialized) return;
    config = directory.resolve("cpu.properties");
    CpuTestBudgets.initialize(directory);
    try {
      Properties saved = read();
      String candidate = saved.getProperty("profile", "off");
      profile = CpuPolicy.validProfile(candidate) ? candidate : "off";
      customDistance = CpuPolicy.distance(saved.getProperty("distance", "off"));
      customParticles = CpuPolicy.particles(saved.getProperty("particles", "off"));
    } catch (IOException | IllegalArgumentException error) {
      profile = "off";
      LOG.warn("CPU configuration unavailable; controls disabled until readable.", error);
    }
    initialized = true;
  }

  /** Read all properties, including unknown user keys that must be preserved. */
  private static Properties read() throws IOException {
    Properties saved = new Properties();
    if (Files.exists(config))
      try (var input = Files.newInputStream(config)) {
        saved.load(input);
      }
    return saved;
  }

  /** Atomically persist CPU choices while retaining unrelated properties. */
  private static void save(String mode, String distance, String particles) throws IOException {
    Properties saved = read(); // Preserve unknown user keys.
    saved.setProperty("profile", mode);
    saved.setProperty("distance", distance);
    saved.setProperty("particles", particles);
    StringWriter output = new StringWriter();
    saved.store(output, "Cutjjen - reversible client visual budgets");
    BridgeFiles.atomic(config, output.toString());
  }

  /** Request a known profile; change state only after successful persistence. */
  public static String request(String value) {
    if (config == null || !CpuPolicy.validProfile(value)) return "Perfil CPU indisponível.";
    return change(value, customDistance, customParticles);
  }

  /** Cycle an individual control and select the custom profile. */
  public static String cycleControl(String key) {
    if (config == null) return "Addon CPU indisponível.";
    if (CpuTestBudgets.owns(key)) return CpuTestBudgets.cycle(key);
    return switch (key) {
      case "distance" -> change("custom", CpuPolicy.nextDistance(customDistance), customParticles);
      case "particles" ->
          change("custom", customDistance, CpuPolicy.nextParticles(customParticles));
      default -> "Controle inválido.";
    };
  }

  /** Save the choice and schedule application on the client thread when required. */
  private static String change(String mode, String distance, String particles) {
    try {
      save(mode, distance, particles);
    } catch (IOException | IllegalArgumentException error) {
      LOG.warn("CPU choice was not saved.", error);
      return "Controle não alterado: " + error.getMessage();
    }
    profile = mode;
    customDistance = distance;
    customParticles = particles;
    Minecraft client = Minecraft.getInstance();
    Runnable apply =
        () -> {
          notifyRenderer();
          release(client); // Release and writes belong to the client thread.
          nextCheck = 0;
          applyOptions(client);
          logApplied(client);
        };
    // Never change graphics options inside a Screen button/render callback.
    if (client == null) apply.run();
    else if (client.isSameThread()) pendingChange = apply;
    else client.execute(() -> pendingChange = apply);
    return "Perfil CPU: " + mode + "; entidades=" + distance + "; partículas=" + particles;
  }

  /** Reevaluate limits at most once per second, without rewriting options every frame. */
  static void notifyRenderer() {
    try {
      Class.forName("nvvisionboost.NVVisionBoostNativeRenderer")
          .getMethod("requestCpuTransition")
          .invoke(null);
    } catch (ReflectiveOperationException | LinkageError error) {
      LOG.warn("CPU renderer coordination unavailable; applying native visual options.", error);
    }
  }

  public static void tick() {
    CpuTestBudgets.tick();
    if (pendingChange != null) {
      Runnable change = pendingChange;
      pendingChange = null;
      change.run();
    }
    if (!initialized || ("off".equals(profile) && !active)) return;
    long now = System.nanoTime();
    if (now < nextCheck) return;
    nextCheck = now + 1_000_000_000L;
    applyOptions(Minecraft.getInstance());
  }

  /** Apply reversible limits in a world and respect changes made by the user or other mods. */
  private static void applyOptions(Minecraft client) {
    if (client == null || client.options == null) return;
    if (client.level == null || "off".equals(profile)) {
      release(client);
      return;
    }
    double ceiling = CpuPolicy.distanceCeiling(profile, customDistance);
    double current = client.options.entityDistanceScaling().get();
    double desired =
        ceiling < 0
            ? DISTANCE.release(current)
            : DISTANCE.update(current, CpuPolicy.validDistance(current, ceiling));
    if (desired != current) client.options.entityDistanceScaling().set(desired);

    int currentParticles = CpuMinecraftAdapter.particles(client);
    int limit =
        switch (CpuPolicy.particleLimit(profile, customParticles)) {
          case "decreased" -> 1;
          case "minimal" -> 2;
          default -> -1;
        };
    int desiredParticles =
        limit < 0
            ? PARTICLES.release(currentParticles)
            : PARTICLES.update(
                currentParticles, currentParticles >= limit ? currentParticles : limit);
    if (desiredParticles != currentParticles)
      CpuMinecraftAdapter.particles(client, desiredParticles);
    active = ceiling >= 0 || limit >= 0;
  }

  /** Log effective settings after a choice, rather than every frame. */
  private static void logApplied(Minecraft client) {
    if (client == null || client.options == null) return;
    LOG.info(
        "[NVVision CPU] profile={} world={} entityDistance={} particles={}",
        profile,
        client.level != null,
        client.options.entityDistanceScaling().get(),
        CpuMinecraftAdapter.particles(client));
  }

  /** Restore only values still owned by the addon. */
  private static void release(Minecraft client) {
    if (!active || client == null || client.options == null) return;
    double current = client.options.entityDistanceScaling().get();
    double restored = DISTANCE.release(current);
    if (restored != current) client.options.entityDistanceScaling().set(restored);
    int particles = CpuMinecraftAdapter.particles(client);
    int restoredParticles = PARTICLES.release(particles);
    if (restoredParticles != particles) CpuMinecraftAdapter.particles(client, restoredParticles);
    active = false;
  }

  /** Release temporary values and save restored settings before client shutdown. */
  public static void shutdown() {
    CpuTestBudgets.shutdown();
    Minecraft client = Minecraft.getInstance();
    if (client == null || client.options == null) return;
    boolean owned = active;
    release(client);
    if (owned) client.options.save();
  }
}
