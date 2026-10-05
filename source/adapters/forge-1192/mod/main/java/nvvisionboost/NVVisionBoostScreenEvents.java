package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nvvisionboost.legacy.Button;

/**
 * Forge client screen events. Add the configuration button only to Options; EventBusSubscriber owns
 * registration.
 */
@Mod.EventBusSubscriber(
    modid = NVVisionBoostForge.ID,
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class NVVisionBoostScreenEvents {
  private static Screen owner;
  private static Button entry;

  private NVVisionBoostScreenEvents() {}

  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
  public static void onScreenOpening(ScreenEvent.Opening event) {
    if (NVVisionBoostDependencies.blocked()
        && !(event.getNewScreen() instanceof NVVisionBoostDependencyScreen)) {
      event.setNewScreen(new NVVisionBoostDependencyScreen());
    }
  }

  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
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
    NVVisionBoostOptionsScreenAdapter.place(screen, entry);
  }

  /** Refresh after other mods change the Options layout; never move their widgets. */
  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
  public static void beforeScreenRender(ScreenEvent.Render.Pre event) {
    if (event.getScreen() == owner && entry != null)
      NVVisionBoostOptionsScreenAdapter.place(owner, entry);
  }

  /** F8. */
  @SubscribeEvent
  public static void onClientTick(TickEvent.ClientTickEvent event) {
    if (event.phase != TickEvent.Phase.END) {
      return;
    }

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
