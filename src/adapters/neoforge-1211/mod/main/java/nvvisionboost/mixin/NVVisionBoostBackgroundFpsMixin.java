/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostBackgroundFpsMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import net.minecraft.client.Minecraft;
import nvvisionboost.NVVisionBoostPerformance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public abstract class NVVisionBoostBackgroundFpsMixin {
  @Inject(method = "getFramerateLimit", at = @At("RETURN"), cancellable = true)
  private void nvvb$backgroundLimit(CallbackInfoReturnable<Integer> ci) {
    ci.setReturnValue(NVVisionBoostPerformance.framerateLimit(ci.getReturnValue()));
  }
}



