/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import net.minecraft.client.renderer.GameRenderer;
import nvvisionboost.NVVisionBoostFrameTiming;
import nvvisionboost.NVVisionBoostNativeRenderer;
import nvvisionboost.NVVisionBoostShaderStartup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Escala o passe completo do mundo sem substituir sua chamada. Preserva o Redirect usado pelo
 * ChaosCrafts Security Essentials. HUD e menus continuam fora do passe de resolução interna.
 */
@Mixin(value = GameRenderer.class, priority = 1100)
public abstract class NVVisionBoostGameRendererMixin {
  @Inject(method = "render(FJZ)V", at = @At("RETURN"))
  private void nvvb$guardBuffers(
      float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci) {
    nvvisionboost.NVVisionBoostEntityBufferGuard.afterFrame();
  }

  // Fora de renderLevel: não invalida o pipeline que Oculus já selecionou.
  @Inject(method = "render(FJZ)V", at = @At("HEAD"))
  private void nvvb$prepareWorld(
      float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostShaderStartup.beforeRender();
    NVVisionBoostFrameTiming.frameStart();
    NVVisionBoostNativeRenderer.prepareFrame();
  }

  // Antes da chamada: todos os HEADs de renderLevel veem o mesmo target,
  // independentemente da prioridade dos mixins do backend de shaders.
  @Inject(
      method = "render(FJZ)V",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GameRenderer;renderLevel(FJLcom/mojang/blaze3d/vertex/PoseStack;)V",
              shift = At.Shift.BEFORE))
  private void nvvb$beginWorld(
      float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostNativeRenderer.beginLevelRender();
    NVVisionBoostFrameTiming.beginWorld();
  }

  // A chamada já terminou, incluindo todos os callbacks TAIL do Oculus.
  // Inject preserva o Redirect de outros mods; não substitui a chamada.
  @Inject(
      method = "render(FJZ)V",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GameRenderer;renderLevel(FJLcom/mojang/blaze3d/vertex/PoseStack;)V",
              shift = At.Shift.AFTER))
  private void nvvb$endWorld(
      float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostNativeRenderer.endLevelRender();
    NVVisionBoostFrameTiming.endWorld();
  }
}
