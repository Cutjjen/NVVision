package nvvisionboost.mixin;

import com.mojang.blaze3d.platform.GlStateManager;
import nvvisionboost.NVVisionBoostNativeRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Abrange RenderSystem e bindWrite de framebuffers, mantendo o cache de viewport nativo. */
@Mixin(GlStateManager.class)
public abstract class NVVisionBoostViewportMixin {
  private static boolean nvvision$repairingViewport;

  @Inject(method = "_viewport", at = @At("HEAD"), cancellable = true)
  private static void nvvision$viewport(int x, int y, int width, int height, CallbackInfo ci) {
    if (!nvvision$repairingViewport
        && NVVisionBoostNativeRenderer.adaptNativeViewport(x, y, width, height)) {
      nvvision$repairingViewport = true;
      try {
        GlStateManager._viewport(
            0,
            0,
            NVVisionBoostNativeRenderer.internalWidth(),
            NVVisionBoostNativeRenderer.internalHeight());
      } finally {
        nvvision$repairingViewport = false;
      }
      ci.cancel();
    }
  }
}
