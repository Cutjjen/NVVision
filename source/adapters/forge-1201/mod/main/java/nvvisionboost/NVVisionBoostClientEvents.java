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
<<<<<<< HEAD
    // Run at the end of the client tick.
    if (NVVisionBoostDependencies.blocked()) return;
    if (event.phase == TickEvent.Phase.END) {
      // The central coordinator applies options, collects metrics and
      // prepares shaders. It also runs in menus to
      // clear session state after leaving a world.
=======
    // Executa apenas no final do tick para garantir estabilidade do cliente
    if (NVVisionBoostDependencies.blocked()) return;
    if (event.phase == TickEvent.Phase.END) {
      // Coordenador central: aplicação real das opções, métricas e
      // preparação automática de shaders. Deve rodar também no menu
      // para limpar o estado da sessão ao sair do mundo.
>>>>>>> origin/master
      NVVisionBoostForge.tickClient();
      Minecraft mc = Minecraft.getInstance();
      if (mc == null || mc.player == null || mc.level == null) {
        tickCounter = 0;
        NVVisionDynamicController.resetTracking();
        NVVisionBoostRenderController.resetWorldTracking();
        return;
      }

<<<<<<< HEAD
      // Check dynamic FPS every 20 ticks, approximately once per second.
=======
      // Executa a verificação dinâmica de FPS a cada 20 ticks (~1 segundo) para evitar sobrecarga
>>>>>>> origin/master
      tickCounter++;
      if (tickCounter >= 20) {
        tickCounter = 0;

<<<<<<< HEAD
        // Update FPS-based adaptation and Oculus/Embeddium coordination.
=======
        // Aciona a sincronização dinâmica baseada em FPS e o controlo do Oculus/Embeddium
>>>>>>> origin/master
        NVVisionDynamicController.tickDynamicPerformance();
      }
    }
  }
}
