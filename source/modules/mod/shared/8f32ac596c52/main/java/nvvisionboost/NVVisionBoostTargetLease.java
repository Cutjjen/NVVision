package nvvisionboost;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import nvvisionboost.mixin.NVVisionBoostRenderTargetAccessor;
import nvvisionboost.rendering.RenderTargetAdapter;
import nvvisionboost.rendering.WorldTargetLease;

/** Reversible world attachment ownership; exchange never closes either target's resources. */
final class NVVisionBoostTargetLease
    implements RenderTargetAdapter<RenderTarget, NVVisionBoostTargetLease.State> {
  private final WorldTargetLease<RenderTarget, State> lease = new WorldTargetLease<>(this);

  void begin(RenderTarget main, RenderTarget internal) {
    lease.begin(main, internal);
  }

  void restore() {
    lease.restore();
  }

  boolean active() {
    return lease.active();
  }

  @Override
  public void validate(RenderTarget main, RenderTarget internal) {
    if (main == internal
        || main.useDepth != internal.useDepth
        || main.useStencil != internal.useStencil)
      throw new IllegalArgumentException("Incompatible render targets");
    if (main.getColorTexture().getFormat() != internal.getColorTexture().getFormat()
        || (main.useDepth
            && main.getDepthTexture().getFormat() != internal.getDepthTexture().getFormat()))
      throw new IllegalArgumentException("Incompatible attachment formats");
  }

  @Override
  public State capture(RenderTarget target) {
    return State.read(target);
  }

  @Override
  public void apply(RenderTarget target, State state) {
    state.write(target);
  }

  record State(
      int width,
      int height,
      GpuTexture color,
      GpuTexture depth,
      GpuTextureView colorView,
      GpuTextureView depthView) {
    static State read(RenderTarget target) {
      var access = (NVVisionBoostRenderTargetAccessor) target;
      return new State(
          target.width,
          target.height,
          access.nvvb$getColorTexture(),
          access.nvvb$getDepthTexture(),
          access.nvvb$getColorView(),
          access.nvvb$getDepthView());
    }

    void write(RenderTarget target) {
      var access = (NVVisionBoostRenderTargetAccessor) target;
      target.width = width;
      target.height = height;
      access.nvvb$setColorTexture(color);
      access.nvvb$setDepthTexture(depth);
      access.nvvb$setColorView(colorView);
      access.nvvb$setDepthView(depthView);
    }
  }
}
