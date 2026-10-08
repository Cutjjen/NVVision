package nvvisionboost;

import com.mojang.blaze3d.opengl.GlTexture;
import com.mojang.blaze3d.pipeline.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.state.WindowRenderState;
import nvvisionboost.mixin.NVVisionBoostGameRendererAccessor;
import nvvisionboost.rendering.MinecraftGlStateAdapter;
import org.lwjgl.opengl.*;

/** Minecraft 26.2 world-only target replacement. Never calls OpenGL for a Vulkan target. */
public final class NVVisionBoostNativeRenderer {
  private static final NVVisionBoostTargetLease TARGET_LEASE = new NVVisionBoostTargetLease();
  private static TextureTarget low;
  private static RenderTarget original;
  private static WindowRenderState scaledWindowState;
  private static int originalStateWidth, originalStateHeight;
  private static final int[] originalViewport = new int[4];
  private static boolean active, blocked;
  private static int inputFbo, outputFbo, fullWidth, fullHeight;
  private static long processed, failed;
  private static String error = "", resolution = "Resolução nativa";

  public static boolean isProcessingBlocked() {
    return blocked;
  }

  public static long processedFrames() {
    return processed;
  }

  public static long failedFrames() {
    return failed;
  }

  public static String lastError() {
    return error;
  }

  public static boolean effectActive() {
    return active;
  }

  public static String internalResolution() {
    return resolution;
  }

  public static String measuredResolutionInfo() {
    return resolution;
  }

  public static int worldWidth(int width) {
    return active && original != null ? original.width : width;
  }

  public static int worldHeight(int height) {
    return active && original != null ? original.height : height;
  }

  private static String restriction = "Aguardando renderização.";
  private static String lastReportedStatus = "";

  public static boolean framebufferScalingAllowed() {
    return restriction.isEmpty() && !blocked;
  }

  public static String scalingRestriction() {
    return restriction;
  }

  public static void finishInterruptedPass() {
    if (active) restore();
  }

  private static volatile boolean cpuTransitionPending;

  /** Queue CPU option changes for the next render-thread frame boundary. Never reload shaders. */
  public static void requestCpuTransition() {
    cpuTransitionPending = true;
  }

  public static void prepareFrame() {
    if (active) restore();
    Minecraft mc = Minecraft.getInstance();
    String next;
    if (NVVisionBoostResourceReload.active())
      next = "Recarga nativa em andamento; resolução nativa.";
    else if (mc == null || mc.level == null) next = "Sem mundo; resolução nativa.";
    else if (mc.gui.screen() != null || mc.gui.overlay() != null)
      next = "Interface aberta; resolução nativa.";
    else if (NVVisionBoostTextureOptimizer.isBusy() || NVVisionBoostShaderEngine.isPreparing())
      next = "Recarga de recursos; resolução nativa.";
    else if (mc.gameRenderer.currentPostEffect() != null)
      next = "Pós-processamento ativo; resolução nativa.";
    else if (!(nvvisionboost.minecraft.MinecraftAccess.get().mainRenderTarget().getColorTexture()
        instanceof GlTexture)) next = "Backend não OpenGL; resolução nativa.";
    else next = NVVisionBoostCompatibility.framebufferScalingRestriction();
    restriction = next;
    if (!restriction.isEmpty()) {
      if (low != null || inputFbo != 0 || outputFbo != 0) disposeTargets();
      resolution = restriction;
    }
    String status = next.isEmpty()
        ? NVVisionBoostShaderStatusAdapter.describe(
            NVVisionBoostCompatibility.externalShaderBackendAvailable(),
            NVVisionBoostCompatibility.externalShadersEnabled(),
            NVVisionBoostCompatibility.externalShadersInUse())
        : next;
    // Report live shader changes even if framebuffer scaling restrictions remain unchanged.
    if (!status.equals(lastReportedStatus) && NVVisionBoostCore.cfg != null) {
      lastReportedStatus = status;
      NVVisionBoostCore.log("Estado do upscaling: " + status);
    }
  }

  public static void beginLevelRender() {
    var cfg = NVVisionBoostCore.cfg;
    Minecraft mc = Minecraft.getInstance();
    if (cfg == null
        || !cfg.enabled
        || !cfg.upscalingEnabled
        || !framebufferScalingAllowed()
        || mc.level == null
        || NVVisionBoostFrameTiming.effectiveScale(cfg) >= 100
        || !NVVisionBoostCreateCompatibility.allowsFramebufferScaling()) return;
    RenderTarget target = nvvisionboost.minecraft.MinecraftAccess.get().mainRenderTarget();
    if (!(target.getColorTexture() instanceof GlTexture)) {
      resolution = "Backend Vulkan: upscaling OpenGL indisponível";
      return;
    }
    try {
      fullWidth = target.width;
      fullHeight = target.height;
      int scale = NVVisionBoostFrameTiming.effectiveScale(cfg);
      int width = Math.min(fullWidth, Math.max(64, fullWidth * scale / 100)),
          height = Math.min(fullHeight, Math.max(64, fullHeight * scale / 100));
      if (low == null
          || low.width != width
          || low.height != height
          || low.getColorTexture().getFormat() != target.getColorTexture().getFormat()) {
        disposeTargets();
        low =
            new TextureTarget(
                "NVVisionBoost Fabric world",
                width,
                height,
                true,
                target.getColorTexture().getFormat());
      }
      if (low.getDepthTexture().getFormat() != target.getDepthTexture().getFormat())
        throw new IllegalStateException(
            "Formato de profundidade incompatível com o target interno");
      original = target;
      GL11.glGetIntegerv(GL11.GL_VIEWPORT, originalViewport);
      var accessor = (NVVisionBoostGameRendererAccessor) mc.gameRenderer;
      scaledWindowState = accessor.nvvb$getGameRenderState().windowRenderState;
      originalStateWidth = scaledWindowState.width;
      originalStateHeight = scaledWindowState.height;
      scaledWindowState.width = width;
      scaledWindowState.height = height;
      TARGET_LEASE.begin(original, low);
      active = true;
      resolution = "Mundo: " + width + "x" + height + " | Saída: " + fullWidth + "x" + fullHeight;
    } catch (RuntimeException e) {
      fail(e);
    }
  }

  public static void endLevelRender() {
    if (!active || low == null || original == null) return;
    RenderTarget destination = original;
    restore();
    int read = GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING),
        draw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    boolean scissor = GL11.glIsEnabled(GL11.GL_SCISSOR_TEST);
    try {
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      if (inputFbo == 0) inputFbo = GL30.glGenFramebuffers();
      if (outputFbo == 0) outputFbo = GL30.glGenFramebuffers();
      attach(inputFbo, low);
      attach(outputFbo, destination);
      var cfg = NVVisionBoostCore.cfg;
      NVVisionBoostFrameTiming.markUpscale();
      boolean rendered =
          NVVisionBoostSpatialUpscaler.render(
              ((GlTexture) low.getColorTexture()).glId(),
              outputFbo,
              low.width,
              low.height,
              fullWidth,
              fullHeight,
              cfg.upscalerMode,
              cfg.upscalerSharpnessPercent,
              cfg.targetFps);
      if (!rendered) {
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, inputFbo);
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, outputFbo);
        GL30.glBlitFramebuffer(
            0,
            0,
            low.width,
            low.height,
            0,
            0,
            fullWidth,
            fullHeight,
            GL11.GL_COLOR_BUFFER_BIT,
            GL11.GL_LINEAR);
      }
      NVVisionBoostDepthTransfer.copy(
          inputFbo, outputFbo, low.width, low.height, fullWidth, fullHeight, false);
      processed++;
    } catch (RuntimeException e) {
      fail(e);
    } finally {
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, read);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, draw);
      GL11.glViewport(
          originalViewport[0], originalViewport[1], originalViewport[2], originalViewport[3]);
      if (scissor) GL11.glEnable(GL11.GL_SCISSOR_TEST);
      else GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }
  }

  private static void attach(int fbo, RenderTarget target) {
    MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
    GL30.glFramebufferTexture2D(
        GL30.GL_FRAMEBUFFER,
        GL30.GL_COLOR_ATTACHMENT0,
        GL11.GL_TEXTURE_2D,
        ((GlTexture) target.getColorTexture()).glId(),
        0);
    if (target.getDepthTexture() instanceof GlTexture depth)
      GL30.glFramebufferTexture2D(
          GL30.GL_FRAMEBUFFER, GL30.GL_DEPTH_ATTACHMENT, GL11.GL_TEXTURE_2D, depth.glId(), 0);
    if (GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) != GL30.GL_FRAMEBUFFER_COMPLETE)
      throw new IllegalStateException("Framebuffer incompleto");
  }

  private static void restore() {
    TARGET_LEASE.restore();
    if (scaledWindowState != null) {
      scaledWindowState.width = originalStateWidth;
      scaledWindowState.height = originalStateHeight;
      scaledWindowState = null;
    }
    active = false;
    original = null;
  }

  private static void fail(RuntimeException e) {
    restore();
    blocked = true;
    failed++;
    error = e.toString();
    NVVisionBoostCore.log("Upscaling desativado por segurança: " + error);
  }

  private static void release() {
    if (low != null) {
      low.destroyBuffers();
      low = null;
    }
  }

  public static void invalidate() {
    reset();
  }

  private static void disposeTargets() {
    if (inputFbo != 0) {
      MinecraftGlStateAdapter.deleteFramebuffer(inputFbo);
      inputFbo = 0;
    }
    if (outputFbo != 0) {
      MinecraftGlStateAdapter.deleteFramebuffer(outputFbo);
      outputFbo = 0;
    }
    release();
  }

  public static void reset() {
    restore();
    disposeTargets();
    NVVisionBoostSpatialUpscaler.close();
    blocked = false;
    error = "";
    resolution = "Resolução nativa";
    restriction = "Aguardando renderização.";
  }
}
