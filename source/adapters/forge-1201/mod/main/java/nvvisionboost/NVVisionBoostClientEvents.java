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
    // Executa apenas no final do tick para garantir estabilidade do cliente
    if (NVVisionBoostDependencies.blocked()) return;
    if (event.phase == TickEvent.Phase.END) {
      // Coordenador central: aplicação real das opções, métricas e
      // preparação automática de shaders. Deve rodar também no menu
      // para limpar o estado da sessão ao sair do mundo.
      NVVisionBoostForge.tickClient();
      Minecraft mc = Minecraft.getInstance();
      if (mc == null || mc.player == null || mc.level == null) {
        tickCounter = 0;
        NVVisionDynamicController.resetTracking();
        NVVisionBoostRenderController.resetWorldTracking();
        return;
      }

      // Executa a verificação dinâmica de FPS a cada 20 ticks (~1 segundo) para evitar sobrecarga
      tickCounter++;
      if (tickCounter >= 20) {
        tickCounter = 0;

        // Aciona a sincronização dinâmica baseada em FPS e o controlo do Oculus/Embeddium
        NVVisionDynamicController.tickDynamicPerformance();
      }
    }
  }
}
