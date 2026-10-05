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
<<<<<<< HEAD
 * Forge client screen events. Add the configuration button only to Options; EventBusSubscriber owns
 * registration.
=======
 * Forge client events.
 *
 * <p>Botão NVVisionBoost aparece somente dentro de Options.
 *
 * <p>Nenhum registro manual no MinecraftForge.EVENT_BUS é necessário porque @Mod.EventBusSubscriber
 * faz isso.
>>>>>>> origin/master
 */
@Mod.EventBusSubscriber(
    modid = NVVisionBoostForge.ID,
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class NVVisionBoostScreenEvents {
<<<<<<< HEAD
  private static Screen owner;
  private static Button entry;

=======
>>>>>>> origin/master
  private NVVisionBoostScreenEvents() {}

  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
  public static void onScreenOpening(ScreenEvent.Opening event) {
    if (NVVisionBoostDependencies.blocked()
        && !(event.getNewScreen() instanceof NVVisionBoostDependencyScreen)) {
      event.setNewScreen(new NVVisionBoostDependencyScreen());
    }
  }

<<<<<<< HEAD
  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
=======
  @SubscribeEvent
>>>>>>> origin/master
  public static void onScreenInit(ScreenEvent.Init.Post event) {
    if (NVVisionBoostDependencies.blocked()) return;
    Screen screen = event.getScreen();

<<<<<<< HEAD
    /* Add this button only to Options. */
=======
    /*
     * Botão deve existir somente em Options.
     */
>>>>>>> origin/master
    if (!(screen instanceof OptionsScreen)) {
      return;
    }

<<<<<<< HEAD
    /* Avoid duplicate buttons if the same screen initializes again. */
=======
    /*
     * Evita duplicar o botão caso Forge dispare nova
     * inicialização da mesma tela.
     */
>>>>>>> origin/master
    for (var widget : event.getListenersList()) {
      if (widget instanceof Button button) {
        String text = button.getMessage().getString();

        if (text != null && text.toLowerCase().contains("nvvision")) {
          return;
        }
      }
    }

<<<<<<< HEAD
    int width = 100, height = 20, x = 8, y = 8;
=======
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
>>>>>>> origin/master

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
<<<<<<< HEAD
    owner = screen;
    entry = button;
    NVVisionBoostOptionsScreenAdapter.place(screen, entry);
  }

  /** Refresh after other mods change the Options layout; never move their widgets. */
  @SubscribeEvent(priority = net.minecraftforge.eventbus.api.EventPriority.LOWEST)
  public static void beforeScreenRender(ScreenEvent.Render.Pre event) {
    if (event.getScreen() == owner && entry != null)
      NVVisionBoostOptionsScreenAdapter.place(owner, entry);
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
      /* Do not open another configuration screen over this one. */
=======
      /*
       * Evita abrir outra tela sobre a própria
       * configuração do NVVisionBoost.
       */
>>>>>>> origin/master
      if (mc.screen instanceof NVVisionBoostConfigScreen) {
        continue;
      }

      mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
    }
  }
}
