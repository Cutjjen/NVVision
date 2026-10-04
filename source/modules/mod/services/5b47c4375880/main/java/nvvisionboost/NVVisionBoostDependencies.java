package nvvisionboost;

/** NeoForge enforces Sodium on the client; Iris remains optional for shaderpacks. */
public final class NVVisionBoostDependencies {
  private NVVisionBoostDependencies() {}

  public static boolean blocked() {
    return !NVVisionBoostCompatibility.sodium();
  }
}
