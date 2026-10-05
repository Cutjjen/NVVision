package nvvisionboost.legacy.addon;

import java.util.Map;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

/** Optional local CPU addon; both peers may use different client installations. */
@Mod(
    modid = "nvvisionvulkanbridge",
    name = "NVVision Addon",
    version = "0.8.16",
    clientSideOnly = true,
    acceptableRemoteVersions = "*",
    dependencies = "required-after:nvvisionboost@[0.8.16,)")
public final class NVVisionLegacyAddon {
  @Mod.EventHandler
  public void initialize(FMLInitializationEvent event) {
    if (event.getSide().isClient()) LegacyCpuAdapter.initialize();
  }

  @NetworkCheckHandler
  public boolean remoteCompatible(Map<String, String> mods, Side side) {
    return true;
  }
}
