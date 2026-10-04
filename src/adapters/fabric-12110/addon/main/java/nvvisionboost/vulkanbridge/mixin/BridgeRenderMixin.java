/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/mixin/BridgeRenderMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.mixin;
import nvvisionboost.vulkanbridge.FabricBridge;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.renderer.GameRenderer.class)
public abstract class BridgeRenderMixin {
  @Inject(method = "render", at = @At("HEAD"))
  private void nvvbridge$before(CallbackInfo ci) { FabricBridge.beforeFrame(); }
  @Inject(method = "render", at = @At("TAIL"))
  private void nvvbridge$after(CallbackInfo ci) { FabricBridge.afterFrame(); }
}

