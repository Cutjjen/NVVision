/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/FabricBridge.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.opengl.GlTexture;
import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.slf4j.LoggerFactory;

/** Runs on the render thread only. No networking, world mutations or driver switching. */
public final class FabricBridge implements ClientModInitializer {
  private static boolean registered, inspected, presentationFailed;
  public void onInitializeClient() { registered = true; }
  public static void beforeFrame() {
    if (registered) {
      if (!BridgeCpuOptimizer.initialized()) BridgeCpuOptimizer.initialize(nvvisionboost.vulkanbridge.platform.Platform.get().configDirectory().resolve("nvvisionboost/vulkan-bridge"));
      BridgeCpuOptimizer.tick();
    }
    if (!registered || inspected) return;
    inspected = true;
    try {
      if (Minecraft.getInstance().getMainRenderTarget().getColorTexture() instanceof GlTexture) BridgeApi.inspect();
      else BridgeApi.nativeBackend();
      BridgeApi.report(nvvisionboost.vulkanbridge.platform.Platform.get().configDirectory().resolve("nvvisionboost/vulkan-bridge"));
      LoggerFactory.getLogger("NVVisionVulkanBridge").info("Client bridge: {}", BridgeApi.snapshot());
    } catch (Exception | LinkageError error) {
      presentationFailed = true;
      LoggerFactory.getLogger("NVVisionVulkanBridge").warn("Bridge disabled; existing renderer preserved", error);
    }
  }
  public static void afterFrame() {
    // Public build preserves the renderer presentation state.
  }
}



