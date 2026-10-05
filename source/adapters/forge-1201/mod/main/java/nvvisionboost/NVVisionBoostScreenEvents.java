package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Forge client screen events. Add the configuration button only to Options; EventBusSubscriber owns
 * registration.
 */
@Mod.EventBusSubscriber(
    modid = NVVisionBoostForge.ID,
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class NVVisionBoostScreenEvents {
  private NVVisionBoostScreenEvents() {}

  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
  public static void onScreenOpening(ScreenEvent.Opening event) {
    if (NVVisionBoostDependencies.blocked()
        && !(event.getNewScreen() instanceof NVVisionBoostDependencyScreen)) {
      event.setNewScreen(new NVVisionBoostDependencyScreen());
    }
  }

  @SubscribeEvent
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

    Button done = null;
    String doneLabel = net.minecraft.network.chat.Component.translatable("gui.done").getString();
    for (var widget : event.getListenersList()) {
      if (widget instanceof Button candidate
          && candidate.getMessage().getString().equals(doneLabel)) {
        done = candidate;
        break;
      }
    }
    int width = Math.min(150, Math.max(60, (screen.width - 24) / 2));
    int height = 20;
    int x = Math.max(5, screen.width - width - 8);
    int y = Math.max(5, screen.height - height - 8);
    if (done != null) {
      int left = (screen.width - width * 2 - 8) / 2;
      done.setWidth(width);
      done.setX(left);
      x = left + width + 8;
      y = done.getY();
    }

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
