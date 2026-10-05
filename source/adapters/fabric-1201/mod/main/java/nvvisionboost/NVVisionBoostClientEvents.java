package nvvisionboost;

import net.minecraft.client.Minecraft;

public class NVVisionBoostClientEvents {
  private static int tickCounter = 0;

  public static void tick() {
    // Run at the end of the client tick.
    if (NVVisionBoostCore.cfg == null) new NVVisionBoostCore();
    if (NVVisionBoostDependencies.blocked()) return;
    {
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
