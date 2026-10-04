/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostImageQuality.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Spatial quality presets leave the shaderpack's own options under Iris control. */
public final class NVVisionBoostImageQuality {
  private NVVisionBoostImageQuality() {}

  public static String label(NVVisionBoostCore.Config config) {
    if (!config.upscalingEnabled || config.renderScalePercent == 100) return "Nativo";
    return switch (config.renderScalePercent) {
      case 85 -> "Qualidade";
      case 75 -> "Balanceado";
      case 67 -> "Desempenho";
      default -> "Manual";
    };
  }

  public static void cycle(NVVisionBoostCore.Config config) {
    int next =
        switch (label(config)) {
          case "Qualidade" -> 75;
          case "Balanceado" -> 67;
          case "Desempenho" -> 100;
          default -> 85;
        };
    configure(config, next);
    NVVisionBoostCore.saveConfig();
    NVVisionBoostNativeRenderer.reset();
  }

  static void configure(NVVisionBoostCore.Config config, int scale) {
    if (scale != 100 && scale != 85 && scale != 75 && scale != 67)
      throw new IllegalArgumentException("Preset de escala inválido");
    config.renderScalePercent = scale;
    config.upscalingEnabled = scale < 100;
    config.upscalerMode = 4;
    config.upscalerSharpnessPercent = scale == 85 ? 30 : scale == 75 ? 45 : 60;
    config.dynamicMinScalePercent = scale == 85 ? 75 : scale == 75 ? 67 : 58;
  }
}
