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
 * Wrap the complete world pass without replacing its call. Preserve other mods' Redirect hooks; HUD
 * and menus remain outside the internal-resolution pass.
 */
@Mixin(value = GameRenderer.class, priority = 1100)
public abstract class NVVisionBoostGameRendererMixin {

  // Outside renderLevel: preserve the pipeline already selected by Oculus.
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

  // The call and Oculus TAIL callbacks have completed.
  // Inject preserves other mods' Redirect hooks without replacing the call.
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
