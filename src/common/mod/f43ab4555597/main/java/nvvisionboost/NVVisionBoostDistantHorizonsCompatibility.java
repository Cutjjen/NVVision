/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostDistantHorizonsCompatibility.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Cooperação opcional sem dependência de classes/API de uma versão específica. */
public final class NVVisionBoostDistantHorizonsCompatibility {
  private static Boolean reported;

  private NVVisionBoostDistantHorizonsCompatibility() {}

  public static boolean loaded() {
    return NVVisionBoostCompatibility.loaded("distanthorizons");
  }

  public static boolean allowsAutomaticDistanceChanges() {
    return !loaded();
  }

  public static boolean allowsFramebufferScaling() {
    return !loaded();
  }

  public static void report() {
    boolean present = loaded();
    if (reported == null || reported != present) {
      reported = present;
      NVVisionBoostCore.log(
          "Distant Horizons="
              + present
              + (present
                  ? " | LODs e threads pertencem ao DH; distância automática suspensa; framebuffer"
                      + " nativo até validar integração de passes"
                  : " | política padrão do NVVision"));
    }
  }
}
