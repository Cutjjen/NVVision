package nvvisionboost.vulkanbridge.platform;

import java.nio.file.Path;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

final class LoaderAdapter implements PlatformAdapter {
  public String loader() {
    return "Fabric";
  }

  public Path gameDirectory() {
    return FabricLoader.getInstance().getGameDir();
  }

  public Path configDirectory() {
    return FabricLoader.getInstance().getConfigDir();
  }

  public boolean client() {
    return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
  }

  public boolean modLoaded(String id) {
    if (id == null || id.isBlank()) return false;
    return FabricLoader.getInstance().isModLoaded(id);
  }
}
