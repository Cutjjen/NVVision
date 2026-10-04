package nvvisionboost.vulkanbridge;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** END runs after the world/HUD and before Minecraft's final framebuffer blit. */
@Mod.EventBusSubscriber(modid = "nvvisionvulkanbridge", value = Dist.CLIENT)
public final class BridgePresentation {
  private static final boolean ENABLED =
      Boolean.parseBoolean(System.getProperty("nvvisionbridge.opaquePresentation", "true"));
  private static boolean announced;

  private BridgePresentation() {}

  @SubscribeEvent
  public static void end(TickEvent.RenderTickEvent event) {
    if (event.phase != TickEvent.Phase.END
        || !"zink".equals(BridgeApi.snapshot().get("backend"))
        || !ENABLED) return;
    Minecraft mc = Minecraft.getInstance();
    BridgeOpaquePresent.normalize(mc.getMainRenderTarget().frameBufferId);
    if (!announced) {
      announced = true;
      LogUtils.getLogger()
          .info(
              "[NVVision Vulkan Bridge] Final presentation alpha normalized; RGB/depth preserved.");
    }
  }
}
