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
<<<<<<< HEAD
 * Wrap the complete world pass without replacing its call. Preserve other mods' Redirect hooks; HUD
 * and menus remain outside the internal-resolution pass.
=======
 * Escala o passe completo do mundo sem substituir sua chamada. Preserva o Redirect usado pelo
 * ChaosCrafts Security Essentials. HUD e menus continuam fora do passe de resolução interna.
>>>>>>> origin/master
 */
@Mixin(value = GameRenderer.class, priority = 1100)
public abstract class NVVisionBoostGameRendererMixin {

<<<<<<< HEAD
  // Outside renderLevel: preserve the pipeline already selected by Oculus.
=======
  // Fora de renderLevel: não invalida o pipeline que Oculus já selecionou.
>>>>>>> origin/master
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

<<<<<<< HEAD
  // The call and Oculus TAIL callbacks have completed.
  // Inject preserves other mods' Redirect hooks without replacing the call.
=======
  // A chamada já terminou, incluindo todos os callbacks TAIL do Oculus.
  // Inject preserva o Redirect de outros mods; não substitui a chamada.
>>>>>>> origin/master
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
