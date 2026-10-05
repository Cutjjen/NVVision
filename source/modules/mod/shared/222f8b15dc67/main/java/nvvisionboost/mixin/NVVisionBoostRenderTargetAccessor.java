package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Exchanges owned texture/view pairs without replacing the main target identity. */
@Mixin(RenderTarget.class)
public interface NVVisionBoostRenderTargetAccessor {
  @Accessor("colorTexture")
  GpuTexture nvvb$getColorTexture();

  @Accessor("colorTexture")
  void nvvb$setColorTexture(GpuTexture texture);

  @Accessor("depthTexture")
  GpuTexture nvvb$getDepthTexture();

  @Accessor("depthTexture")
  void nvvb$setDepthTexture(GpuTexture texture);

  @Accessor("colorTextureView")
  GpuTextureView nvvb$getColorView();

  @Accessor("colorTextureView")
  void nvvb$setColorView(GpuTextureView view);

  @Accessor("depthTextureView")
  GpuTextureView nvvb$getDepthView();

  @Accessor("depthTextureView")
  void nvvb$setDepthView(GpuTextureView view);
}
