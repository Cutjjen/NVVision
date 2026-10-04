/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod("nvvisionvulkanbridge")
public final class NVVisionVulkanBridge {
  public
  NVVisionVulkanBridge() {} // No GL calls or graphics class initialization on construction/server.

  @net.neoforged.fml.common.EventBusSubscriber(
      modid = "nvvisionvulkanbridge",
      value = Dist.CLIENT,
      bus = net.neoforged.fml.common.EventBusSubscriber.Bus.GAME)
  public static final class Client {
    private static final Logger LOG = LogUtils.getLogger();
    private static boolean inspected;

    @SubscribeEvent
    public static void shutdown(net.neoforged.neoforge.event.GameShuttingDownEvent event) { BridgeCpuOptimizer.shutdown(); }

    @SubscribeEvent
    public static void tick(ClientTickEvent.Post event) {
      if (FMLEnvironment.dist != Dist.CLIENT)
        return;
      if (!BridgeCpuOptimizer.initialized()) BridgeCpuOptimizer.initialize(nvvisionboost.vulkanbridge.platform.Platform.get().configDirectory().resolve("nvvisionboost/vulkan-bridge"));
      BridgeCpuOptimizer.tick();
      if (inspected) return;
      inspected = true;
      try {
        BridgeApi.inspect();
        var status = BridgeApi.snapshot();
        LOG.info("[NVVision Vulkan Bridge] {}", status);
        BridgeApi.report(
            Minecraft.getInstance()
                .gameDirectory
                .toPath()
                .resolve("config/nvvisionboost/vulkan-bridge"));
      } catch (Exception | LinkageError error) {
        LOG.warn(
            "[NVVision Vulkan Bridge] Detection failed; no renderer state was changed.", error);
      }
    }
  }
}


