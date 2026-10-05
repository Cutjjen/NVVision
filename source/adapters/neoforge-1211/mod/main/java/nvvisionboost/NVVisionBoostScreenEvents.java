package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

/**
 * NeoForge client screen events. Add the configuration button only to Options; EventBusSubscriber
 * owns registration.
 */
@net.neoforged.fml.common.EventBusSubscriber(
    modid = NVVisionBoostCore.ID,
    value = Dist.CLIENT,
    bus = net.neoforged.fml.common.EventBusSubscriber.Bus.GAME)
public final class NVVisionBoostScreenEvents {
  private static Screen owner;
  private static Button entry;

  private NVVisionBoostScreenEvents() {}

  @SubscribeEvent(priority = net.neoforged.bus.api.EventPriority.LOWEST)
  public static void onScreenOpening(ScreenEvent.Opening event) {
    if (NVVisionBoostDependencies.blocked()
        && !(event.getNewScreen() instanceof NVVisionBoostDependencyScreen)) {
      event.setNewScreen(new NVVisionBoostDependencyScreen());
    }
  }

  @SubscribeEvent(priority = net.neoforged.bus.api.EventPriority.LOWEST)
  public static void onScreenInit(ScreenEvent.Init.Post event) {
    if (NVVisionBoostDependencies.blocked()) return;
    Screen screen = event.getScreen();

    /* Add this button only to Options. */
    if (!(screen instanceof OptionsScreen)) {
      return;
    }

    /* Avoid duplicate buttons if the same screen initializes again. */
    for (var widget : event.getListenersList()) {
      if (widget instanceof Button button) {
        String text = button.getMessage().getString();

        if (text != null && text.toLowerCase().contains("nvvision")) {
          return;
        }
      }
    }

    int width = 100, height = 20, x = 8, y = 8;

    Button button =
        NVVisionBoostMenuButton.builder(
                net.minecraft.network.chat.Component.literal("NVVisionBoost"),
                pressed -> {
                  Minecraft mc = Minecraft.getInstance();

                  if (mc != null) {
                    mc.setScreen(new NVVisionBoostConfigScreen(screen));
                  }
                })
            .bounds(x, y, width, height)
            .build();

    event.addListener(button);
    owner = screen;
    entry = button;
    placeEntry(screen);
  }

  @SubscribeEvent(priority = net.neoforged.bus.api.EventPriority.LOWEST)
  public static void beforeScreenRender(ScreenEvent.Render.Pre event) {
    if (event.getScreen() == owner && entry != null) placeEntry(owner);
  }

  private static void placeEntry(Screen screen) {
    NVVisionBoostOptionsScreenAdapter.place(screen, entry);
  }

  /** F8. */
  @SubscribeEvent
  public static void onClientTick(ClientTickEvent.Post event) {

    Minecraft mc = Minecraft.getInstance();

    if (mc == null) {
      return;
    }

    if (NVVisionBoostDependencies.blocked()) {
      while (NVVisionBoostClient.OPEN_CONFIG.consumeClick()) {}
      if (mc.getOverlay() == null && !(mc.screen instanceof NVVisionBoostDependencyScreen))
        mc.setScreen(new NVVisionBoostDependencyScreen());
      return;
    }

    while (NVVisionBoostClient.OPEN_CONFIG.consumeClick()) {
      /* Do not open another configuration screen over this one. */
      if (mc.screen instanceof NVVisionBoostConfigScreen) {
        continue;
      }

      mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
    }
  }
}
