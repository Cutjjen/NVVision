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

  private BridgeCpuOptimizer() {}

  /** Informa se a configuração local já foi lida durante a inicialização do addon. */
  public static boolean initialized() {
    return initialized;
  }

  /** Retorna o perfil ativo em memória para que a interface mostre o estado aplicado. */
  public static String mode() {
    return profile;
  }

  /**
   * Consulta o valor individual salvo; controles desconhecidos são sinalizados como indisponíveis.
   */
  public static String control(String key) {
    return switch (key) {
      case "distance" -> customDistance;
      case "particles" -> customParticles;
      default -> "unavailable";
    };
  }

  /** Lê uma vez os controles locais; uma configuração ilegível mantém a otimização desligada. */
  public static void initialize(Path directory) {
    if (initialized) return;
    config = directory.resolve("cpu.properties");
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

  /** Lê as propriedades completas, incluindo chaves de usuário que precisam ser preservadas. */
  private static Properties read() throws IOException {
    Properties saved = new Properties();
    if (Files.exists(config))
      try (var input = Files.newInputStream(config)) {
        saved.load(input);
      }
    return saved;
  }

  /** Persiste somente as escolhas de CPU por escrita atômica, mantendo as demais propriedades. */
  private static void save(String mode, String distance, String particles) throws IOException {
    Properties saved = read(); // Preserve unknown user keys.
    saved.setProperty("profile", mode);
    saved.setProperty("distance", distance);
    saved.setProperty("particles", particles);
    StringWriter output = new StringWriter();
    saved.store(output, "Cutjjen - reversible client visual budgets");
    BridgeFiles.atomic(config, output.toString());
  }

  /** Solicita um perfil conhecido; a alteração só ocorre se a persistência tiver sucesso. */
  public static String request(String value) {
    if (config == null || !CpuPolicy.validProfile(value)) return "Perfil CPU indisponível.";
    return change(value, customDistance, customParticles);
  }

  /** Avança um controle individual e seleciona o perfil personalizado. */
  public static String cycleControl(String key) {
    if (config == null) return "Addon CPU indisponível.";
    return switch (key) {
      case "distance" -> change("custom", CpuPolicy.nextDistance(customDistance), customParticles);
      case "particles" ->
          change("custom", customDistance, CpuPolicy.nextParticles(customParticles));
      default -> "Controle inválido.";
    };
  }

  /** Salva a escolha e agenda sua aplicação imediata na thread do cliente quando necessário. */
  private static String change(String mode, String distance, String particles) {
    try {
      save(mode, distance, particles);
    } catch (IOException | IllegalArgumentException error) {
      LOG.warn("CPU choice was not saved.", error);
      return "Controle não alterado: " + error.getMessage();
    }
    Minecraft client = Minecraft.getInstance();
    Runnable apply =
        () -> {
          release(client); // Release and writes belong to the client thread.
          profile = mode;
          customDistance = distance;
          customParticles = particles;
          nextCheck = 0;
          applyOptions(client);
          logApplied(client);
        };
    if (client == null || client.isSameThread()) apply.run();
    else client.execute(apply);
    return "Perfil CPU: " + mode + "; entidades=" + distance + "; partículas=" + particles;
  }

  /** Reavalia os limites no máximo uma vez por segundo, sem reescrever opções a cada quadro. */
  public static void tick() {
    if (!initialized || ("off".equals(profile) && !active)) return;
    long now = System.nanoTime();
    if (now < nextCheck) return;
    nextCheck = now + 1_000_000_000L;
    applyOptions(Minecraft.getInstance());
  }

  /** Aplica limites reversíveis somente no mundo e respeita mudanças feitas por usuário ou mods. */
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

  /** Registra o estado efetivo após uma escolha, sem gerar registros a cada quadro. */
  private static void logApplied(Minecraft client) {
    if (client == null || client.options == null) return;
    LOG.info(
        "[NVVision CPU] profile={} world={} entityDistance={} particles={}",
        profile,
        client.level != null,
        client.options.entityDistanceScaling().get(),
        CpuMinecraftAdapter.particles(client));
  }

  /** Restaura apenas os valores que continuam sob controle do addon. */
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

  /** Libera os valores temporários e salva a restauração antes do encerramento do cliente. */
  public static void shutdown() {
    Minecraft client = Minecraft.getInstance();
    if (client == null || client.options == null) return;
    boolean owned = active;
    release(client);
    if (owned) client.options.save();
  }
}
