package nvvisionboost;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.Minecraft;

/** Client lifecycle adapter; preserves the shared tick coordinator and dependency screen. */
public final class NVVisionBoostFabric implements ClientModInitializer {
  private static boolean registered;

  public void onInitializeClient() {
    KeyBindingHelper.registerKeyBinding(NVVisionBoostClient.OPEN_CONFIG);
    registered = true;
  }

  public static void tick() {
    if (!registered) return;
    NVVisionBoostClientEvents.tick();
    Minecraft mc = Minecraft.getInstance();
    if (NVVisionBoostDependencies.blocked()) {
      while (NVVisionBoostClient.OPEN_CONFIG.consumeClick()) {}
      if (mc.getOverlay() == null && !(mc.screen instanceof NVVisionBoostDependencyScreen))
        mc.setScreen(new NVVisionBoostDependencyScreen());
      return;
    }
    while (NVVisionBoostClient.OPEN_CONFIG.consumeClick())
      if (!(mc.screen instanceof NVVisionBoostConfigScreen))
        mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
  }
}
