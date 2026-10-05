package nvvisionboost.vulkanbridge;

import com.mojang.blaze3d.opengl.GlTexture;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.common.Mod;
import org.slf4j.LoggerFactory;

/** Runs on the render thread only. No networking, world mutations or driver switching. */
@Mod(value = "nvvisionvulkanbridge", dist = net.neoforged.api.distmarker.Dist.CLIENT)
public final class NeoForgeBridge {
  private static boolean registered, inspected, presentationFailed;

  public NeoForgeBridge() {
    registered = true;
    net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(
        (net.neoforged.neoforge.event.GameShuttingDownEvent event) ->
            BridgeCpuOptimizer.shutdown());
    net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(
        (net.neoforged.neoforge.client.event.RenderFrameEvent.Pre event) -> beforeFrame());
    net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(
        (net.neoforged.neoforge.client.event.RenderFrameEvent.Post event) -> afterFrame());
    LoggerFactory.getLogger("NVVisionVulkanBridge")
        .info("Client bridge registered with NeoForge render events");
  }

  public static void beforeFrame() {
    if (registered) {
      if (!BridgeCpuOptimizer.initialized())
        BridgeCpuOptimizer.initialize(
            nvvisionboost.vulkanbridge.platform.Platform.get()
                .configDirectory()
                .resolve("nvvisionboost/vulkan-bridge"));
      BridgeCpuOptimizer.tick();
    }
    if (!registered || inspected || presentationFailed) return;
    try {
      if (Minecraft.getInstance().getMainRenderTarget().getColorTexture() instanceof GlTexture)
        BridgeApi.inspect();
      else BridgeApi.nativeBackend();
      BridgeApi.report(
          nvvisionboost.vulkanbridge.platform.Platform.get()
              .configDirectory()
              .resolve("nvvisionboost/vulkan-bridge"));
      LoggerFactory.getLogger("NVVisionVulkanBridge")
          .info("Client bridge: {}", BridgeApi.snapshot());
    } catch (Exception | LinkageError error) {
      presentationFailed = true;
      LoggerFactory.getLogger("NVVisionVulkanBridge")
          .warn("Bridge disabled; existing renderer preserved", error);
    }
  }

  public static void afterFrame() {
    // Public build preserves the renderer presentation state.
  }
}
