package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.neoforged.fml.common.Mod;

/** Loader entrypoint is client-only; GPU initialization waits for the first client tick. */
@Mod(value = "nvvisionboost", dist = net.neoforged.api.distmarker.Dist.CLIENT)
public final class NVVisionBoostNeoForge {
  private static boolean registered, initialized;

  public NVVisionBoostNeoForge(net.neoforged.fml.ModContainer container) {
    container.registerExtensionPoint(
        net.neoforged.neoforge.client.gui.IConfigScreenFactory.class,
        (owner, parent) -> new NVVisionBoostConfigScreen(parent));
    container.getEventBus().addListener(NVVisionBoostClient::registerKeys);
    registered = true;
  }

  public static void tick() {
    if (!registered) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || mc.gui == null) return;
    if (!initialized) {
      new NVVisionBoostCore();
      initialized = true;
      NVVisionBoostNeoForgeIntegrations.report();
    }
    if (NVVisionBoostCore.cfg == null) return;
    NVVisionBoostCore.tickClient();
    if (mc.level != null) NVVisionDynamicController.tickDynamicPerformance();
    while (NVVisionBoostClient.OPEN_CONFIG.consumeClick())
      mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
  }
}
