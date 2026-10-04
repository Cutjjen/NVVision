package nvvisionboost.vulkanbridge;

import java.util.Set;

/** Cutjjen: shared CPU policy, independent of Minecraft and every loader. */
public final class CpuPolicy {
  private CpuPolicy() {}

  /** Aceita somente perfis conhecidos; configurações ausentes ou inválidas não ativam recursos. */
  public static boolean validProfile(String value) {
    return value != null && Set.of("off", "balanced", "economy", "custom").contains(value);
  }

  /** Normaliza a distância e migra 25%, rejeitado pelo Minecraft, para o mínimo válido de 50%. */
  public static String distance(String value) {
    if ("25%".equals(value)) return "50%"; // Migrate the unsupported legacy choice.
    return value != null && Set.of("off", "75%", "50%").contains(value) ? value : "off";
  }

  /** Normaliza a política de partículas sem modificar o estado do jogo. */
  public static String particles(String value) {
    return value != null && Set.of("off", "decreased", "minimal").contains(value) ? value : "off";
  }

  /** Percorre as opções de distância que o controle individual pode aplicar. */
  public static String nextDistance(String value) {
    return switch (distance(value)) {
      case "off" -> "75%";
      case "75%" -> "50%";
      default -> "off";
    };
  }

  /** Percorre as opções de partículas que o controle individual pode aplicar. */
  public static String nextParticles(String value) {
    return switch (particles(value)) {
      case "off" -> "decreased";
      case "decreased" -> "minimal";
      default -> "off";
    };
  }

  /** Retorna o teto de distância do perfil; -1 indica que o addon não controla essa opção. */
  public static double distanceCeiling(String profile, String custom) {
    if (!validProfile(profile)) return -1;
    return switch (profile) {
      case "balanced" -> .75;
      case "economy" -> .5;
      case "custom" ->
          switch (distance(custom)) {
            case "75%" -> .75;
            case "50%" -> .5;
            default -> -1;
          };
      default -> -1;
    };
  }

  /** Resolve o limite de partículas; off indica que a escolha original deve ser preservada. */
  public static String particleLimit(String profile, String custom) {
    if (!validProfile(profile)) return "off";
    return switch (profile) {
      case "balanced" -> "decreased";
      case "economy" -> "minimal";
      case "custom" -> particles(custom);
      default -> "off";
    };
  }

  /** Aplica um teto sem elevar uma distância já válida e respeita o mínimo aceito pelo jogo. */
  public static double validDistance(double current, double ceiling) {
    return Math.max(.5, Math.min(current, ceiling));
  }
}
