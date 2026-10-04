/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostGpuTheme.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Shared palette for both client screens, selected from the active renderer only. */
public record NVVisionBoostGpuTheme(String title, int accent, int header, int background) {
  public int surface() {
    return blend(background, 0xFF273344, 0.46f);
  }

  public int raised() {
    return blend(surface(), accent, 0.09f);
  }

  public int hover() {
    return blend(surface(), accent, 0.18f);
  }

  public int border() {
    return blend(surface(), accent, 0.30f);
  }

  public int muted() {
    return 0xFFADBCCB;
  }

  private static int blend(int a, int b, float mix) {
    int r = Math.round(((a >>> 16) & 255) * (1 - mix) + ((b >>> 16) & 255) * mix);
    int g = Math.round(((a >>> 8) & 255) * (1 - mix) + ((b >>> 8) & 255) * mix);
    int blue = Math.round((a & 255) * (1 - mix) + (b & 255) * mix);
    return 0xFF000000 | (r << 16) | (g << 8) | blue;
  }

  public static NVVisionBoostGpuTheme forBrand(NVVisionBoostGpuCatalog.Brand brand) {
    return switch (brand) {
      case NVIDIA -> new NVVisionBoostGpuTheme("NVIDIA", 0xFF9BD43C, 0xFF142016, 0xFF080E0A);
      case AMD -> new NVVisionBoostGpuTheme("AMD RADEON", 0xFFFF7279, 0xFF27151B, 0xFF10090D);
      case INTEL -> new NVVisionBoostGpuTheme("INTEL GRAPHICS", 0xFF62C9FF, 0xFF102331, 0xFF070D14);
      default -> new NVVisionBoostGpuTheme("OPENGL", 0xFF7FDDD0, 0xFF152329, 0xFF090F14);
    };
  }
}
