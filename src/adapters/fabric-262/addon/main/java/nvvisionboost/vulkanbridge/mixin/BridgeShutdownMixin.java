/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/mixin/BridgeShutdownMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.mixin;
import nvvisionboost.vulkanbridge.BridgeCpuOptimizer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(targets="net.minecraft.client.Minecraft")
public abstract class BridgeShutdownMixin {
 @Inject(method="close",at=@At("HEAD"))
 private void nvvision$restoreOptions(CallbackInfo ci) { BridgeCpuOptimizer.shutdown(); }
}
