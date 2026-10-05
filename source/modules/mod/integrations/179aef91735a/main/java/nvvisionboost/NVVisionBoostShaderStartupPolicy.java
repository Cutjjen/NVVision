package nvvisionboost;

/** Attempts once per pack/world/pipeline identity, including failed attempts. */
final class NVVisionBoostShaderStartupPolicy {
  private Object world, pipeline;
  private String pack = "";
  private boolean attempted;

  boolean begin(Object currentWorld, String currentPack, Object currentPipeline) {
    if (attempted
        && world == currentWorld
        && pipeline == currentPipeline
        && pack.equals(currentPack)) return false;
    world = currentWorld;
    pack = currentPack;
    pipeline = currentPipeline;
    attempted = true;
    return true;
  }

  void complete(Object preparedPipeline) {
    pipeline = preparedPipeline;
  }

  void reset() {
    world = pipeline = null;
    pack = "";
    attempted = false;
  }
}
