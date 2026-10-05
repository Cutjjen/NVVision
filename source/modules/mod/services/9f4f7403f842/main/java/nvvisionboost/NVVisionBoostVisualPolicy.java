package nvvisionboost;

<<<<<<< HEAD
/** Compose options so one feature cannot undo another selected reduction. */
=======
/** Composição de opções: nenhum recurso pode desfazer a redução escolhida em outro. */
>>>>>>> origin/master
final class NVVisionBoostVisualPolicy {
  private NVVisionBoostVisualPolicy() {}

  static double screenEffectScale(NVVisionBoostCore.Config config, double original) {
    double result = original;
    if (config.transparencyOptimization && config.transparencyLevel <= 1)
      result = Math.min(result, config.transparencyLevel == 0 ? 0.40 : 0.55);
    if (config.reduceShaderEffects) result = Math.min(result, 0.70);
    return result;
  }

  static int simulationDistance(NVVisionBoostCore.Config config, int original) {
    return config.simulationOptimization ? Math.min(original, config.simulationDistance) : original;
  }
}
