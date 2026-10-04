/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod("nvvisionvulkanbridge")
public final class NVVisionVulkanBridge {
  public
  NVVisionVulkanBridge() {} // No GL calls or graphics class initialization on construction/server.

  @Mod.EventBusSubscriber(
      modid = "nvvisionvulkanbridge",
      value = Dist.CLIENT,
      bus = Mod.EventBusSubscriber.Bus.FORGE)
  public static final class Client {
    private static final Logger LOG = LogUtils.getLogger();
    private static boolean inspected;

    @SubscribeEvent
    public static void shutdown(net.minecraftforge.event.GameShuttingDownEvent event) { BridgeCpuOptimizer.shutdown(); }

    @SubscribeEvent
    public static void tick(TickEvent.ClientTickEvent event) {
      if (event.phase != TickEvent.Phase.END || FMLEnvironment.dist != Dist.CLIENT)
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

