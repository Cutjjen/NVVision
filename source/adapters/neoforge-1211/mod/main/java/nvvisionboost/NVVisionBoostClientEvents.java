package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@net.neoforged.fml.common.EventBusSubscriber(modid = "nvvisionboost", value = Dist.CLIENT)
public class NVVisionBoostClientEvents {
  private static int tickCounter = 0;

  @SubscribeEvent
  public static void onClientTick(ClientTickEvent.Post event) {
<<<<<<< HEAD
    // Run at the end of the client tick.
    if (NVVisionBoostCore.cfg == null) new NVVisionBoostCore();
    if (NVVisionBoostDependencies.blocked()) return;
    {
      // The central coordinator applies options, collects metrics and
      // prepares shaders. It also runs in menus to
      // clear session state after leaving a world.
=======
    // Executa apenas no final do tick para garantir estabilidade do cliente
    if (NVVisionBoostCore.cfg == null) new NVVisionBoostCore();
    if (NVVisionBoostDependencies.blocked()) return;
    {
      // Coordenador central: aplicação real das opções, métricas e
      // preparação automática de shaders. Deve rodar também no menu
      // para limpar o estado da sessão ao sair do mundo.
>>>>>>> origin/master
      NVVisionBoostCore.tickClient();
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
