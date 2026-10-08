package nvvisionboost;

/** Client-local alternative renderer gate; Iris compatibility remains owned by Iris. */
public final class NVVisionBoostDependencies {
  private NVVisionBoostDependencies() {}

  public static boolean blocked() {
    return !NVVisionBoostRendererAdapter.resolve(NVVisionBoostCompatibility::loaded).available();
  }
}
