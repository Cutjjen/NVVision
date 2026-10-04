/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostClientEvents.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@net.neoforged.fml.common.EventBusSubscriber(modid = "nvvisionboost", value = Dist.CLIENT)
public class NVVisionBoostClientEvents {
  private static int tickCounter = 0;

  @SubscribeEvent
  public static void onClientTick(ClientTickEvent.Post event) {
    // Executa apenas no final do tick para garantir estabilidade do cliente
    if (NVVisionBoostCore.cfg == null) new NVVisionBoostCore();
    if (NVVisionBoostDependencies.blocked()) return;
    {
      // Coordenador central: aplicação real das opções, métricas e
      // preparação automática de shaders. Deve rodar também no menu
      // para limpar o estado da sessão ao sair do mundo.
      NVVisionBoostCore.tickClient();
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




