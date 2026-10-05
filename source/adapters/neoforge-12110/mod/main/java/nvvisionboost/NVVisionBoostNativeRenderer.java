package nvvisionboost;

import com.mojang.blaze3d.opengl.GlTexture;
import com.mojang.blaze3d.pipeline.*;
import net.minecraft.client.Minecraft;
<<<<<<< HEAD
import nvvisionboost.rendering.MinecraftGlStateAdapter;
=======
>>>>>>> origin/master
import org.lwjgl.opengl.*;

/** Minecraft 1.21.10 world-only target replacement. Never calls OpenGL for a Vulkan target. */
public final class NVVisionBoostNativeRenderer {
<<<<<<< HEAD
  private static final NVVisionBoostTargetLease TARGET_LEASE = new NVVisionBoostTargetLease();
=======
>>>>>>> origin/master
  private static TextureTarget low;
  private static RenderTarget original;
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
<<<<<<< HEAD
    return active && original != null ? original.width : width;
  }

  public static int worldHeight(int height) {
    return active && original != null ? original.height : height;
=======
    return active && low != null ? low.width : width;
  }

  public static int worldHeight(int height) {
    return active && low != null ? low.height : height;
>>>>>>> origin/master
  }

  private static String restriction = "Aguardando renderização.";

  public static boolean framebufferScalingAllowed() {
    return restriction.isEmpty() && !blocked;
  }

  public static String scalingRestriction() {
    return restriction;
  }

  public static void finishInterruptedPass() {
    if (active) restore();
  }

  static String availablePassStatus() {
    return NVVisionBoostCompatibility.externalShadersInUse()
        ? "OpenGL com shaders Iris; passe disponível."
        : NVVisionBoostCompatibility.externalShadersEnabled()
            ? "OpenGL; shaders habilitados no Iris; passe disponível."
            : "OpenGL sem shaders; passe disponível.";
  }

  public static void prepareFrame() {
    if (active) restore();
    Minecraft mc = Minecraft.getInstance();
    String next;
    if (NVVisionBoostResourceReload.active())
      next = "Recarga nativa em andamento; resolução nativa.";
    else if (mc == null || mc.level == null) next = "Sem mundo; resolução nativa.";
    else if (mc.screen != null || mc.getOverlay() != null)
      next = "Interface aberta; resolução nativa.";
    else if (NVVisionBoostTextureOptimizer.isBusy() || NVVisionBoostShaderEngine.isPreparing())
      next = "Recarga de recursos; resolução nativa.";
    else if (mc.gameRenderer.currentPostEffect() != null)
      next = "Pós-processamento ativo; resolução nativa.";
    else if (!(nvvisionboost.minecraft.MinecraftAccess.get().mainRenderTarget().getColorTexture()
        instanceof GlTexture)) next = "Backend não OpenGL; resolução nativa.";
    else next = NVVisionBoostCompatibility.framebufferScalingRestriction();
    boolean changed = !next.equals(restriction);
    restriction = next;
    if (!restriction.isEmpty()) {
      if (low != null || inputFbo != 0 || outputFbo != 0) disposeTargets();
      resolution = restriction;
    }
    if (changed && NVVisionBoostCore.cfg != null)
      NVVisionBoostCore.log(
          "Estado do upscaling: " + (next.isEmpty() ? availablePassStatus() : next));
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
<<<<<<< HEAD
      if (low == null
          || low.width != width
          || low.height != height
          || low.getColorTexture().getFormat() != target.getColorTexture().getFormat()) {
=======
      if (low == null || low.width != width || low.height != height) {
>>>>>>> origin/master
        disposeTargets();
        low = new TextureTarget("NVVisionBoost NeoForge world", width, height, true);
      }
      if (low.getDepthTexture().getFormat() != target.getDepthTexture().getFormat())
        throw new IllegalStateException(
            "Formato de profundidade incompatível com o target interno");
      original = target;
      GL11.glGetIntegerv(GL11.GL_VIEWPORT, originalViewport);
<<<<<<< HEAD
      TARGET_LEASE.begin(original, low);
=======
      ((nvvisionboost.mixin.NVVisionBoostMinecraftTargetAccessor) mc).nvvb$setMainRenderTarget(low);
>>>>>>> origin/master
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
<<<<<<< HEAD
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, inputFbo);
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, outputFbo);
=======
        GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, inputFbo);
        GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, outputFbo);
>>>>>>> origin/master
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
<<<<<<< HEAD
      NVVisionBoostDepthTransfer.copy(
          inputFbo, outputFbo, low.width, low.height, fullWidth, fullHeight, false);
=======
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, inputFbo);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, outputFbo);
      GL30.glBlitFramebuffer(
          0,
          0,
          low.width,
          low.height,
          0,
          0,
          fullWidth,
          fullHeight,
          GL11.GL_DEPTH_BUFFER_BIT,
          GL11.GL_NEAREST);
>>>>>>> origin/master
      processed++;
    } catch (RuntimeException e) {
      fail(e);
    } finally {
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, read);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, draw);
=======
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, read);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, draw);
>>>>>>> origin/master
      GL11.glViewport(
          originalViewport[0], originalViewport[1], originalViewport[2], originalViewport[3]);
      if (scissor) GL11.glEnable(GL11.GL_SCISSOR_TEST);
      else GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }
  }

  private static void attach(int fbo, RenderTarget target) {
<<<<<<< HEAD
    MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
=======
    GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
>>>>>>> origin/master
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
<<<<<<< HEAD
    TARGET_LEASE.restore();
=======
    Minecraft mc = Minecraft.getInstance();
    if (original != null && mc != null)
      ((nvvisionboost.mixin.NVVisionBoostMinecraftTargetAccessor) mc)
          .nvvb$setMainRenderTarget(original);
>>>>>>> origin/master
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
<<<<<<< HEAD
      MinecraftGlStateAdapter.deleteFramebuffer(inputFbo);
      inputFbo = 0;
    }
    if (outputFbo != 0) {
      MinecraftGlStateAdapter.deleteFramebuffer(outputFbo);
=======
      GL30.glDeleteFramebuffers(inputFbo);
      inputFbo = 0;
    }
    if (outputFbo != 0) {
      GL30.glDeleteFramebuffers(outputFbo);
>>>>>>> origin/master
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
