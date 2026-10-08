package nvvisionboost.vulkanbridge;

import net.fabricmc.api.ClientModInitializer;

/** Local CPU lifecycle adapter; no networking or replacement of the game's renderer. */
public final class FabricBridge implements ClientModInitializer {
  private static boolean registered, inspected;

  public void onInitializeClient() {
    registered = true;
  }

  public static void tick() {
    if (!registered) return;
    var folder =
        nvvisionboost.vulkanbridge.platform.Platform.get()
            .configDirectory()
            .resolve("nvvisionboost/vulkan-bridge");
    if (!BridgeCpuOptimizer.initialized()) BridgeCpuOptimizer.initialize(folder);
    BridgeCpuOptimizer.tick();
    if (inspected) return;
    inspected = true;
    try {
      BridgeApi.inspect();
      BridgeApi.report(folder);
    } catch (Exception | LinkageError error) {
      org.slf4j.LoggerFactory.getLogger("NVVisionAddon")
          .warn("Bridge inspection failed; CPU controls and native renderer preserved", error);
    }
  }

  public static void shutdown() {
    BridgeCpuOptimizer.shutdown();
  }
}
