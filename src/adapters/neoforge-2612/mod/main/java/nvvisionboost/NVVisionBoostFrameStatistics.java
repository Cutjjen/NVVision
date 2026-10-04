/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostFrameStatistics.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.Arrays;

/** Intervalos reais entre frames; percentis têm memória fixa e atualização amortizada. */
final class NVVisionBoostFrameStatistics {
  private final double[] samples = new double[120];
  private final double[] scratch = new double[120];
  private int size, cursor, sinceSort;
  private double mean, percentile95;

  void add(double milliseconds) {
    if (!Double.isFinite(milliseconds) || milliseconds < .1 || milliseconds > 5000) return;
    samples[cursor] = milliseconds;
    cursor = (cursor + 1) % samples.length;
    size = Math.min(samples.length, size + 1);
    mean = mean == 0 ? milliseconds : mean * .95 + milliseconds * .05;
    if (++sinceSort >= 30 || size == 1) {
      System.arraycopy(samples, 0, scratch, 0, size);
      Arrays.sort(scratch, 0, size);
      percentile95 = scratch[Math.max(0, (int) Math.ceil(size * .95) - 1)];
      sinceSort = 0;
    }
  }

  int count() {
    return size;
  }

  double meanMs() {
    return mean;
  }

  double percentile95Ms() {
    return percentile95;
  }

  void reset() {
    size = cursor = sinceSort = 0;
    mean = percentile95 = 0;
  }
}

