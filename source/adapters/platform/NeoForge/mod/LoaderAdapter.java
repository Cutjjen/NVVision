package nvvisionboost.platform;

import java.nio.file.Path;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;

final class LoaderAdapter implements PlatformAdapter {
  public String loader() {
    return "NeoForge";
  }

  public Path gameDirectory() {
    return FMLPaths.GAMEDIR.get();
  }

  public Path configDirectory() {
    return FMLPaths.CONFIGDIR.get();
  }

  public boolean client() {
    return FMLEnvironment.getDist() == Dist.CLIENT;
  }

  public boolean modLoaded(String id) {
    if (id == null || id.isBlank()) return false;
    ModList mods = ModList.get();
    return mods != null && mods.isLoaded(id);
  }
}
