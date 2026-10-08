package nvvisionboost;

/** Keep native rendering while a pipeline is created, removed or replaced. */
final class NVVisionBoostPipelineGate {
  private Object pipeline;
  private int stableFrames;

  boolean ready(boolean selected, Object current) {
    if (!selected) {
      reset();
      return true;
    }
    if (current == null) {
      reset();
      return false;
    }
    if (pipeline != current) {
      pipeline = current;
      stableFrames = 1;
      return false;
    }
    stableFrames = Math.min(3, stableFrames + 1);
    return stableFrames >= 3;
  }

  void reset() {
    pipeline = null;
    stableFrames = 0;
  }
}
