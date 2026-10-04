/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostScreenEvents.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

/**
 * Forge client events.
 *
 * <p>Botão NVVisionBoost aparece somente dentro de Options.
 *
 * <p>Nenhum registro manual no MinecraftForge.EVENT_BUS é necessário porque @net.neoforged.fml.common.EventBusSubscriber
 * faz isso.
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

    /*
     * Botão deve existir somente em Options.
     */
    if (!(screen instanceof OptionsScreen)) {
      return;
    }

    /*
     * Evita duplicar o botão caso Forge dispare nova
     * inicialização da mesma tela.
     */
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
    owner=screen; entry=button;
    placeEntry(screen);
  }

  @SubscribeEvent(priority = net.neoforged.bus.api.EventPriority.LOWEST)
  public static void beforeScreenRender(ScreenEvent.Render.Pre event) {
    if(event.getScreen()==owner && entry!=null) placeEntry(owner);
  }
  private static void placeEntry(Screen screen) {
    var occupied=new java.util.ArrayList<NVVisionBoostOptionsPlacement.Rect>();
    for(var child:screen.children()) {
      if(child instanceof net.minecraft.client.gui.components.AbstractWidget widget && widget!=entry && widget.visible)
        occupied.add(new NVVisionBoostOptionsPlacement.Rect(widget.getX(),widget.getY(),widget.getWidth(),widget.getHeight()));
    }
    var position=NVVisionBoostOptionsPlacement.place(screen.width,screen.height,occupied);
    entry.visible=position.isPresent();
    position.ifPresent(rect->{entry.setX(rect.x());entry.setY(rect.y());entry.setWidth(rect.width());});
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
      /*
       * Evita abrir outra tela sobre a própria
       * configuração do NVVisionBoost.
       */
      if (mc.screen instanceof NVVisionBoostConfigScreen) {
        continue;
      }

      mc.setScreen(new NVVisionBoostConfigScreen(mc.screen));
    }
  }
}




