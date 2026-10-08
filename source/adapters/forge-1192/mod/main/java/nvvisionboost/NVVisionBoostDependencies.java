package nvvisionboost;

/** Forge 1.19.2 renderer adapter: Rubidium or Embeddium, enforced only on this client. */
public final class NVVisionBoostDependencies {
  private static volatile boolean blocked;

  private NVVisionBoostDependencies() {}

  static boolean accepts(boolean embeddium, boolean rubidium) {
    return embeddium || rubidium;
  }

  static boolean verify() {
    blocked =
        !accepts(NVVisionBoostCompatibility.embeddium(), NVVisionBoostCompatibility.rubidium());
    return !blocked;
  }

  public static boolean blocked() {
    return blocked;
  }
}
