package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@net.neoforged.fml.common.EventBusSubscriber(modid = "nvvisionboost", value = Dist.CLIENT)
public class NVVisionBoostClientEvents {
  private static int tickCounter = 0;

  @SubscribeEvent
  public static void onClientTick(ClientTickEvent.Post event) {
    // Run at the end of the client tick.
    if (NVVisionBoostCore.cfg == null) new NVVisionBoostCore();
    if (NVVisionBoostDependencies.blocked()) return;
    {
      // The central coordinator applies options, collects metrics and
      // prepares shaders. It also runs in menus to
      // clear session state after leaving a world.
      NVVisionBoostCore.tickClient();
      Minecraft mc = Minecraft.getInstance();
      if (mc == null || mc.player == null || mc.level == null) {
        tickCounter = 0;
        NVVisionDynamicController.resetTracking();
        NVVisionBoostRenderController.resetWorldTracking();
        return;
      }

      // Check dynamic FPS every 20 ticks, approximately once per second.
      tickCounter++;
      if (tickCounter >= 20) {
        tickCounter = 0;

        // Update FPS-based adaptation and Oculus/Embeddium coordination.
        NVVisionDynamicController.tickDynamicPerformance();
      }
    }
  }
}
