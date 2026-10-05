package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Access to owned attachments; never changes the identity of the main Minecraft target. */
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

  @Accessor("stencilEnabled")
  boolean nvvb$getStencilEnabled();

  @Accessor("stencilEnabled")
  void nvvb$setStencilEnabled(boolean value);
}
