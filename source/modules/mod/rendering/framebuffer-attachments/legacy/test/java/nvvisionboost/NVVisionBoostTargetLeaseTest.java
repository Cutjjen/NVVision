package nvvisionboost;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import nvvisionboost.mixin.NVVisionBoostRenderTargetAccessor;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/** Regression for retained target references and native-resolution world occlusion. */
public final class NVVisionBoostTargetLeaseTest {
  private static int checks;

  private static void check(boolean condition, String message) {
    if (!condition) throw new AssertionError(message);
    checks++;
  }

  public static void main(String[] args) {
    if (!GLFW.glfwInit()) throw new IllegalStateException("GLFW unavailable");
    GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
    GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
    long window = GLFW.glfwCreateWindow(80, 60, "NVVision target regression", 0, 0);
    if (window == 0) throw new IllegalStateException("OpenGL context unavailable");
    try {
      GLFW.glfwMakeContextCurrent(window);
      GL.createCapabilities();
      RenderSystem.initRenderThread();
      runOwnership();
      for (int percent : new int[] {85, 75, 50, 35, 25, 10}) runDepth(percent);
      check(GL11.glGetError() == GL11.GL_NO_ERROR, "No OpenGL errors");
      System.out.println("PASS target identity and scaled depth/stencil: " + checks + " checks");
    } finally {
      GLFW.glfwMakeContextCurrent(0);
      GLFW.glfwDestroyWindow(window);
      GLFW.glfwTerminate();
    }
  }

  private static void runOwnership() {
    var nativeTarget = new FixtureTarget(80, 60, 101, 102, 103);
    var internal = new FixtureTarget(28, 21, 201, 202, 203);
    var cachedByMod = nativeTarget;
    var lease = new NVVisionBoostTargetLease();
    lease.begin(nativeTarget, internal);
    check(cachedByMod == nativeTarget, "Cached target identity remains intact");
    check(
        cachedByMod.viewWidth == 28 && cachedByMod.viewHeight == 21,
        "Cached dimensions match world");
    check(
        cachedByMod.frameBufferId == 201
            && cachedByMod.getColorTextureId() == 202
            && cachedByMod.getDepthTextureId() == 203,
        "Cached target sees world attachments");
    try {
      lease.begin(nativeTarget, internal);
      throw new AssertionError("Nested lease accepted");
    } catch (IllegalStateException expected) {
      checks++;
    }
    // Simulate another mod recreating borrowed attachments and enabling stencil.
    cachedByMod.frameBufferId = 301;
    cachedByMod.nvvb$setColorTexture(302);
    cachedByMod.nvvb$setDepthTexture(303);
    cachedByMod.nvvb$setStencilEnabled(true);
    lease.restore();
    check(!lease.active(), "Lease released");
    check(nativeTarget.viewWidth == 80 && nativeTarget.viewHeight == 60, "Native size restored");
    check(
        nativeTarget.frameBufferId == 101
            && nativeTarget.getColorTextureId() == 102
            && nativeTarget.getDepthTextureId() == 103,
        "Native ownership restored");
    check(
        internal.frameBufferId == 301
            && internal.getColorTextureId() == 302
            && internal.getDepthTextureId() == 303,
        "Mod replacement buffers remain owned by internal target");
    check(
        internal.nvvb$getStencilEnabled() && !nativeTarget.nvvb$getStencilEnabled(),
        "Stencil ownership follows attachments");
    lease.restore();
    check(nativeTarget.frameBufferId == 101, "Restoration is idempotent");
    try {
      lease.begin(nativeTarget, nativeTarget);
      throw new AssertionError("Aliased targets accepted");
    } catch (IllegalArgumentException expected) {
      checks++;
    }
  }

  private static void runDepth(int percent) {
    int width = Math.max(2, Math.round(80 * percent / 100f));
    int height = Math.max(2, Math.round(60 * percent / 100f));
    int[] source = target(width, height), output = target(80, 60);
    try {
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, source[0]);
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL11.glDepthMask(true);
      GL11.glStencilMask(255);
      GL11.glClearDepth(.25);
      GL11.glClearStencil(7);
      GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
      GL11.glEnable(GL11.GL_SCISSOR_TEST);
      GL11.glScissor(0, 0, width / 2, height);
      GL11.glClearDepth(.75);
      GL11.glClearStencil(4);
      GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, output[0]);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, source[0]);
      GL11.glScissor(0, 0, 1, 1);
      NVVisionBoostDepthTransfer.copy(source[0], output[0], width, height, 80, 60, true);
      check(GL11.glIsEnabled(GL11.GL_SCISSOR_TEST), "Scissor restored at " + percent);
      check(
          GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING) == output[0]
              && GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == source[0],
          "FBO bindings restored at " + percent);
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, output[0]);
      var depth = BufferUtils.createFloatBuffer(1);
      var stencil = BufferUtils.createByteBuffer(1);
      GL11.glReadPixels(20, 30, 1, 1, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, depth);
      check(Math.abs(depth.get(0) - .75) < .001, "Left depth remains aligned at " + percent);
      GL11.glReadPixels(60, 30, 1, 1, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, depth);
      check(Math.abs(depth.get(0) - .25) < .001, "Right depth remains aligned at " + percent);
      GL11.glReadPixels(20, 30, 1, 1, GL11.GL_STENCIL_INDEX, GL11.GL_UNSIGNED_BYTE, stencil);
      check(stencil.get(0) == 4, "Left stencil remains aligned at " + percent);
      GL11.glReadPixels(60, 30, 1, 1, GL11.GL_STENCIL_INDEX, GL11.GL_UNSIGNED_BYTE, stencil);
      check(stencil.get(0) == 7, "Right stencil remains aligned at " + percent);
      check(GL11.glGetError() == GL11.GL_NO_ERROR, "Scaled copy valid at " + percent);
    } finally {
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
      for (int[] item : new int[][] {source, output}) {
        GL30.glDeleteFramebuffers(item[0]);
        GL11.glDeleteTextures(item[1]);
        GL11.glDeleteTextures(item[2]);
      }
    }
  }

  private static int[] target(int width, int height) {
    int fbo = GL30.glGenFramebuffers();
    GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
    int color = GL11.glGenTextures();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, color);
    GL11.glTexImage2D(
        GL11.GL_TEXTURE_2D,
        0,
        GL11.GL_RGBA8,
        width,
        height,
        0,
        GL11.GL_RGBA,
        GL11.GL_UNSIGNED_BYTE,
        (java.nio.ByteBuffer) null);
    GL30.glFramebufferTexture2D(
        GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL11.GL_TEXTURE_2D, color, 0);
    int depth = GL11.glGenTextures();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, depth);
    GL11.glTexImage2D(
        GL11.GL_TEXTURE_2D,
        0,
        GL30.GL_DEPTH24_STENCIL8,
        width,
        height,
        0,
        GL30.GL_DEPTH_STENCIL,
        GL30.GL_UNSIGNED_INT_24_8,
        (java.nio.ByteBuffer) null);
    GL30.glFramebufferTexture2D(
        GL30.GL_FRAMEBUFFER, GL30.GL_DEPTH_STENCIL_ATTACHMENT, GL11.GL_TEXTURE_2D, depth, 0);
    check(
        GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) == GL30.GL_FRAMEBUFFER_COMPLETE,
        "Test FBO complete");
    return new int[] {fbo, color, depth};
  }

  private static final class FixtureTarget extends RenderTarget
      implements NVVisionBoostRenderTargetAccessor {
    private static final java.util.Map<Integer, Boolean> stencilByFramebuffer =
        new java.util.HashMap<>();

    FixtureTarget(int width, int height, int fbo, int color, int depth) {
      super(true);
      this.width = viewWidth = width;
      this.height = viewHeight = height;
      frameBufferId = fbo;
      colorTextureId = color;
      depthBufferId = depth;
    }

    public int nvvb$getColorTexture() {
      return colorTextureId;
    }

    public void nvvb$setColorTexture(int value) {
      colorTextureId = value;
    }

    public int nvvb$getDepthTexture() {
      return depthBufferId;
    }

    public void nvvb$setDepthTexture(int value) {
      depthBufferId = value;
    }

    public boolean nvvb$getStencilEnabled() {
      return stencilByFramebuffer.getOrDefault(frameBufferId, false);
    }

    public void nvvb$setStencilEnabled(boolean value) {
      stencilByFramebuffer.put(frameBufferId, value);
    }
  }
}
