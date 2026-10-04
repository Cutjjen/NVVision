/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do loader.
 * Arquivo lógico: main/java/nvvisionboost/platform/LoaderAdapter.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.platform;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader; import net.fabricmc.api.EnvType;
final class LoaderAdapter implements PlatformAdapter {
  public String loader() { return "Fabric"; }
  public Path gameDirectory() { return FabricLoader.getInstance().getGameDir(); }
  public Path configDirectory() { return FabricLoader.getInstance().getConfigDir(); }
  public boolean client() { return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT; }
  public boolean modLoaded(String id) { if(id == null || id.isBlank()) return false; return FabricLoader.getInstance().isModLoaded(id); }
}
