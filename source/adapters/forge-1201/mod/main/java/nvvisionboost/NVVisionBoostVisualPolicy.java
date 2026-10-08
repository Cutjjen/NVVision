package nvvisionboost;

/** Compose options so one feature cannot undo another selected reduction. */
final class NVVisionBoostVisualPolicy {
  private NVVisionBoostVisualPolicy() {}

  static double screenEffectScale(NVVisionBoostForge.Config config, double original) {
    double result = original;
    if (config.transparencyOptimization && config.transparencyLevel <= 1)
      result = Math.min(result, config.transparencyLevel == 0 ? 0.40 : 0.55);
    if (config.reduceShaderEffects) result = Math.min(result, 0.70);
    return result;
  }

  static int simulationDistance(NVVisionBoostForge.Config config, int original) {
    return config.simulationOptimization ? Math.min(original, config.simulationDistance) : original;
  }
}
