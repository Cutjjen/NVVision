package nvvisionboost.platform;

import java.nio.file.Path;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;

final class LoaderAdapter implements PlatformAdapter {
  public String loader() {
    return "Forge";
  }

  public Path gameDirectory() {
    return FMLPaths.GAMEDIR.get();
  }

  public Path configDirectory() {
    return FMLPaths.CONFIGDIR.get();
  }

  public boolean client() {
    return FMLEnvironment.dist == Dist.CLIENT;
  }

  public boolean modLoaded(String id) {
    if (id == null || id.isBlank()) return false;
    ModList mods = ModList.get();
    return mods != null && mods.isLoaded(id);
  }
}
