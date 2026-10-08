package nvvisionboost.legacy;

import java.util.Map;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

/** Forge 1.12.2 client lifecycle; no server packets or remote installation requirement. */
@Mod(
    modid = "nvvisionboost",
    name = "NV Vision Boost",
    version = "0.8.27",
    clientSideOnly = true,
    acceptableRemoteVersions = "*")
public final class NVVisionLegacy {
  @Mod.EventHandler
  public void initialize(FMLInitializationEvent event) {
    if (event.getSide().isClient()) LegacyClient.initialize();
  }

  @NetworkCheckHandler
  public boolean remoteCompatible(Map<String, String> mods, Side side) {
    return true;
  }
}
