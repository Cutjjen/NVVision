/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostDependencies.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Client-local alternative dependency; no network handshake or remote requirements. */
public final class NVVisionBoostDependencies {
  private static volatile boolean blocked;

  private NVVisionBoostDependencies() {}

  static boolean accepts(boolean embeddium, boolean sodium) {
    return embeddium || sodium;
  }

  static boolean verify() {
    blocked = !accepts(NVVisionBoostCompatibility.embeddium(), NVVisionBoostCompatibility.sodium());
    return !blocked;
  }

  public static boolean blocked() {
    return blocked;
  }
}
