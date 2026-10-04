/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import net.minecraft.client.Minecraft;
import nvvisionboost.NVVisionBoostNeoForge;
import nvvisionboost.NVVisionBoostNativeRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class NVVisionBoostMinecraftMixin {
  @Inject(method = "reloadResourcePacks()Ljava/util/concurrent/CompletableFuture;", at = @At("HEAD"))
  private void nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci) {
    nvvisionboost.NVVisionBoostResourceReload.begin();
  }
  @Inject(method = "reloadResourcePacks()Ljava/util/concurrent/CompletableFuture;", at = @At("RETURN"))
  private void nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci) {
    nvvisionboost.NVVisionBoostResourceReload.track(ci.getReturnValue());
  }
  @Inject(method = "tick", at = @At("TAIL"))
  private void nvvb$tick(CallbackInfo ci) {
    NVVisionBoostNeoForge.tick();
  }

  @Inject(method = "close", at = @At("HEAD"))
  private void nvvb$close(CallbackInfo ci) {
    NVVisionBoostNativeRenderer.reset();
  }
}

