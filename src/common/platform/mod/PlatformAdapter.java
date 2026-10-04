/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do loader.
 * Arquivo lógico: main/java/nvvisionboost/platform/PlatformAdapter.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.platform;
import java.nio.file.Path;
/** Loader contract. No Minecraft/rendering classes or network registration. */
public interface PlatformAdapter {
  String loader();
  Path gameDirectory();
  Path configDirectory();
  boolean client();
  boolean modLoaded(String id);
}
