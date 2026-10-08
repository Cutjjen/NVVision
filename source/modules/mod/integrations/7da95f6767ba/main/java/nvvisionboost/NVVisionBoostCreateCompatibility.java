package nvvisionboost;

/** Optional integration preserves Create/Flywheel ownership of machines. */
public final class NVVisionBoostCreateCompatibility {
  private NVVisionBoostCreateCompatibility() {}

  public static boolean createLoaded() {
    return NVVisionBoostCompatibility.loaded("create");
  }

  public static boolean flywheelLoaded() {
    return NVVisionBoostCompatibility.loaded("flywheel");
  }

  public static boolean protectsMachineRendering() {
    return createLoaded() || flywheelLoaded();
  }

  /** Allow manual scale without changing Flywheel backend or culling. */
  public static boolean allowsFramebufferScaling() {
    return NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling();
  }

  public static String scalingReason() {
    return NVVisionBoostDistantHorizonsCompatibility.loaded()
        ? "Resolução nativa: passes Distant Horizons ainda não validados"
        : "";
  }

  public static boolean allowsAutomaticScaleChanges() {
    return !protectsMachineRendering() && allowsFramebufferScaling();
  }

  public static String summary() {
    return "Create="
        + createLoaded()
        + " | Flywheel="
        + flywheelLoaded()
        + (protectsMachineRendering()
            ? " | simulação e entidades preservadas; escala manual permitida; escala automática"
                + " suspensa"
            : " | perfil padrão");
  }
}
