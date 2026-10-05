package nvvisionboost;

import com.mojang.blaze3d.pipeline.RenderTarget;
import nvvisionboost.mixin.NVVisionBoostRenderTargetAccessor;
import nvvisionboost.rendering.RenderTargetAdapter;
import nvvisionboost.rendering.WorldTargetLease;

/**
 * Exchanges complete attachment ownership while preserving target object identities. A second
 * exchange restores the native target and keeps any allocations made during the world pass on the
 * internal target. Neither object owns the other's textures after restoration.
 */
final class NVVisionBoostTargetLease
    implements RenderTargetAdapter<RenderTarget, NVVisionBoostTargetLease.State> {
  private final WorldTargetLease<RenderTarget, State> lease = new WorldTargetLease<>(this);

  /** Borrows internal attachments without replacing Minecraft's main target reference. */
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
    if (main == internal || main.useDepth != internal.useDepth)
      throw new IllegalArgumentException("Incompatible render targets");
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
      int viewWidth,
      int viewHeight,
      int framebuffer,
      int color,
      int depth,
      int filter,
      boolean stencil) {
    static State read(RenderTarget target) {
      var access = (NVVisionBoostRenderTargetAccessor) target;
      return new State(
          target.width,
          target.height,
          target.viewWidth,
          target.viewHeight,
          target.frameBufferId,
          access.nvvb$getColorTexture(),
          access.nvvb$getDepthTexture(),
          target.filterMode,
          access.nvvb$getStencilEnabled());
    }

    void write(RenderTarget target) {
      var access = (NVVisionBoostRenderTargetAccessor) target;
      target.width = width;
      target.height = height;
      target.viewWidth = viewWidth;
      target.viewHeight = viewHeight;
      target.frameBufferId = framebuffer;
      access.nvvb$setColorTexture(color);
      access.nvvb$setDepthTexture(depth);
      target.filterMode = filter;
      access.nvvb$setStencilEnabled(stencil);
    }
  }
}
