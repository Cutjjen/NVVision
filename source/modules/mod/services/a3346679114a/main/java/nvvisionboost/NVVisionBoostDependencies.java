package nvvisionboost;

/** Fabric Loader enforces the mandatory client dependencies before launch. */
public final class NVVisionBoostDependencies {
  private NVVisionBoostDependencies() {}

  public static boolean blocked() {
    return !NVVisionBoostCompatibility.sodium() || !NVVisionBoostCompatibility.iris();
  }
}
