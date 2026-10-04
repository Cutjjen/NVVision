/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do loader.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/platform/LoaderAdapter.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.platform;
import java.nio.file.Path;
import net.neoforged.fml.ModList; import net.neoforged.fml.loading.FMLPaths; import net.neoforged.fml.loading.FMLEnvironment; import net.neoforged.api.distmarker.Dist;
final class LoaderAdapter implements PlatformAdapter {
  public String loader() { return "NeoForge"; }
  public Path gameDirectory() { return FMLPaths.GAMEDIR.get(); }
  public Path configDirectory() { return FMLPaths.CONFIGDIR.get(); }
  public boolean client() { return FMLEnvironment.getDist() == Dist.CLIENT; }
  public boolean modLoaded(String id) { if(id == null || id.isBlank()) return false; ModList mods = ModList.get(); return mods != null && mods.isLoaded(id); }
}

