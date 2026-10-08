package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "nvvisionboost", value = Dist.CLIENT)
public class NVVisionBoostClientEvents {
  private static int tickCounter = 0;

  @SubscribeEvent
  public static void onClientTick(TickEvent.ClientTickEvent event) {
    // Run at the end of the client tick.
    if (NVVisionBoostDependencies.blocked()) return;
    if (event.phase == TickEvent.Phase.END) {
      // The central coordinator applies options, collects metrics and
      // prepares shaders. It also runs in menus to
      // clear session state after leaving a world.
      NVVisionBoostForge.tickClient();
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
