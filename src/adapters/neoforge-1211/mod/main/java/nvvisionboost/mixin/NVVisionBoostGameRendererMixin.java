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
  @Inject(method = "render(Lnet/minecraft/client/DeltaTracker;Z)V", at = @At("RETURN"))
  private void nvvb$guardBuffers(
      net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci) {

  }

  // Fora de renderLevel: não invalida o pipeline que Oculus já selecionou.
  @Inject(method = "render(Lnet/minecraft/client/DeltaTracker;Z)V", at = @At("HEAD"))
  private void nvvb$prepareWorld(
      net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostShaderStartup.beforeRender();
    NVVisionBoostFrameTiming.frameStart();
    NVVisionBoostNativeRenderer.prepareFrame();
  }

  // Antes da chamada: todos os HEADs de renderLevel veem o mesmo target,
  // independentemente da prioridade dos mixins do backend de shaders.
  @Inject(
      method = "render(Lnet/minecraft/client/DeltaTracker;Z)V",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GameRenderer;renderLevel(Lnet/minecraft/client/DeltaTracker;)V",
              shift = At.Shift.BEFORE))
  private void nvvb$beginWorld(
      net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostNativeRenderer.beginLevelRender();
    NVVisionBoostFrameTiming.beginWorld();
  }

  // A chamada já terminou, incluindo todos os callbacks TAIL do Oculus.
  // Inject preserva o Redirect de outros mods; não substitui a chamada.
  @Inject(
      method = "render(Lnet/minecraft/client/DeltaTracker;Z)V",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GameRenderer;renderLevel(Lnet/minecraft/client/DeltaTracker;)V",
              shift = At.Shift.AFTER))
  private void nvvb$endWorld(
      net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci) {
    NVVisionBoostNativeRenderer.endLevelRender();
    NVVisionBoostFrameTiming.endWorld();
  }
}



