package nvvisionboost;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

/** Loader entrypoint is client-only; GPU initialization waits for the first client tick. */
public final class NVVisionBoostFabric implements ClientModInitializer {
  private static boolean registered, initialized;

  public void onInitializeClient() {
    registered = true;
  }

  public static void tick() {
    if (!registered) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || mc.gui == null) return;
    if (!initialized) {
      new NVVisionBoostCore();
      initialized = true;
    }
    if (NVVisionBoostCore.cfg == null) return;
    NVVisionBoostCore.tickClient();
    if (mc.level != null) NVVisionDynamicController.tickDynamicPerformance();
    while (NVVisionBoostClient.OPEN_CONFIG.consumeClick())
      mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
  }
}
