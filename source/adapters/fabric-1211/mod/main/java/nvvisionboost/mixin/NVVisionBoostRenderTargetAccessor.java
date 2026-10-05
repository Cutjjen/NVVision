package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import nvvisionboost.rendering.FabricStencilAdapter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Vanilla attachment fields; stencil capability belongs to the actual framebuffer image. */
@Mixin(RenderTarget.class)
public interface NVVisionBoostRenderTargetAccessor {
  @Accessor("colorTextureId")
  int nvvb$getColorTexture();

  @Accessor("colorTextureId")
  void nvvb$setColorTexture(int value);

  @Accessor("depthBufferId")
  int nvvb$getDepthTexture();

  @Accessor("depthBufferId")
  void nvvb$setDepthTexture(int value);

  default boolean nvvb$getStencilEnabled() {
    return FabricStencilAdapter.enabled((RenderTarget) (Object) this);
  }

  default void nvvb$setStencilEnabled(boolean value) {
    RenderTarget target = (RenderTarget) (Object) this;
    if (value == FabricStencilAdapter.enabled(target)) return;
    if (value) FabricStencilAdapter.request(target);
    else
      throw new UnsupportedOperationException(
          "Stencil attachment ownership cannot be changed through a vanilla flag");
  }
}
