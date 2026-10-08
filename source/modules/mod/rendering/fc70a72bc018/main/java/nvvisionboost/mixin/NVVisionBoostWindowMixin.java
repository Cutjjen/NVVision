package nvvisionboost.mixin;

import com.mojang.blaze3d.platform.Window;
import nvvisionboost.NVVisionBoostNativeRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Only getters used inside the 3D pass expose internal dimensions. */
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
