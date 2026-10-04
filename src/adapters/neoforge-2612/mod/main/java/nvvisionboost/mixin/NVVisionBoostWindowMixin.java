/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostWindowMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import com.mojang.blaze3d.platform.Window;
import nvvisionboost.NVVisionBoostNativeRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Somente os getters usados no passe 3D enxergam as dimensões internas. */
@Mixin(Window.class)
public abstract class NVVisionBoostWindowMixin {
  @Inject(method = "getWidth", at = @At("RETURN"), cancellable = true)
  private void nvvb$worldWidth(CallbackInfoReturnable<Integer> ci) {
    ci.setReturnValue(NVVisionBoostNativeRenderer.worldWidth(ci.getReturnValue()));
  }

  @Inject(method = "getHeight", at = @At("RETURN"), cancellable = true)
  private void nvvb$worldHeight(CallbackInfoReturnable<Integer> ci) {
    ci.setReturnValue(NVVisionBoostNativeRenderer.worldHeight(ci.getReturnValue()));
  }
}

