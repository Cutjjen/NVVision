package nvvisionboost;

/** Client-local alternative dependency; no network handshake or remote requirements. */
public final class NVVisionBoostDependencies {
  private static volatile boolean blocked;

  private NVVisionBoostDependencies() {}

  static boolean accepts(boolean embeddium, boolean sodium) {
    return embeddium || sodium;
  }

  static boolean verify() {
    blocked = !NVVisionBoostRendererAdapter.resolve(NVVisionBoostCompatibility::loaded).available();
    return !blocked;
  }

  public static boolean blocked() {
    return blocked;
  }
}
