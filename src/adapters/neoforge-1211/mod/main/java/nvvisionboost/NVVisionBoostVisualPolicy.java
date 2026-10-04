/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostVisualPolicy.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Composição de opções: nenhum recurso pode desfazer a redução escolhida em outro. */
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



