package nvvisionboost.vulkanbridge;

import java.util.Set;

/** Cutjjen: shared CPU policy, independent of Minecraft and every loader. */
public final class CpuPolicy {
  private CpuPolicy() {}

<<<<<<< HEAD
  /** Accept only known profiles; missing or invalid configuration cannot enable features. */
=======
  /** Aceita somente perfis conhecidos; configurações ausentes ou inválidas não ativam recursos. */
>>>>>>> origin/master
  public static boolean validProfile(String value) {
    return value != null && Set.of("off", "balanced", "economy", "custom").contains(value);
  }

<<<<<<< HEAD
  /** Normalize distance and migrate unsupported 25% values to Minecraft's valid 50% minimum. */
=======
  /** Normaliza a distância e migra 25%, rejeitado pelo Minecraft, para o mínimo válido de 50%. */
>>>>>>> origin/master
  public static String distance(String value) {
    if ("25%".equals(value)) return "50%"; // Migrate the unsupported legacy choice.
    return value != null && Set.of("off", "75%", "50%").contains(value) ? value : "off";
  }

<<<<<<< HEAD
  /** Normalize particle policy without changing game state. */
=======
  /** Normaliza a política de partículas sem modificar o estado do jogo. */
>>>>>>> origin/master
  public static String particles(String value) {
    return value != null && Set.of("off", "decreased", "minimal").contains(value) ? value : "off";
  }

<<<<<<< HEAD
  /** Cycle supported distance-control choices. */
=======
  /** Percorre as opções de distância que o controle individual pode aplicar. */
>>>>>>> origin/master
  public static String nextDistance(String value) {
    return switch (distance(value)) {
      case "off" -> "75%";
      case "75%" -> "50%";
      default -> "off";
    };
  }

<<<<<<< HEAD
  /** Cycle supported particle-control choices. */
=======
  /** Percorre as opções de partículas que o controle individual pode aplicar. */
>>>>>>> origin/master
  public static String nextParticles(String value) {
    return switch (particles(value)) {
      case "off" -> "decreased";
      case "decreased" -> "minimal";
      default -> "off";
    };
  }

<<<<<<< HEAD
  /** Return the profile's distance ceiling; -1 means the addon does not own this option. */
=======
  /** Retorna o teto de distância do perfil; -1 indica que o addon não controla essa opção. */
>>>>>>> origin/master
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

<<<<<<< HEAD
  /** Resolve the particle limit; off preserves the original choice. */
=======
  /** Resolve o limite de partículas; off indica que a escolha original deve ser preservada. */
>>>>>>> origin/master
  public static String particleLimit(String profile, String custom) {
    if (!validProfile(profile)) return "off";
    return switch (profile) {
      case "balanced" -> "decreased";
      case "economy" -> "minimal";
      case "custom" -> particles(custom);
      default -> "off";
    };
  }

<<<<<<< HEAD
  /**
   * Apply a ceiling without increasing an already valid distance, respecting the game's minimum.
   */
=======
  /** Aplica um teto sem elevar uma distância já válida e respeita o mínimo aceito pelo jogo. */
>>>>>>> origin/master
  public static double validDistance(double current, double ceiling) {
    return Math.max(.5, Math.min(current, ceiling));
  }
}
