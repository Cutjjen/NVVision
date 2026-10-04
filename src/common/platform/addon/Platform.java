/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do loader.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/platform/Platform.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.platform;
/** Compile-time binding: exactly one loader implementation in each artifact. */
public final class Platform {
  private static final PlatformAdapter ADAPTER = new LoaderAdapter();
  private Platform() {}
  public static PlatformAdapter get() { return ADAPTER; }
}
