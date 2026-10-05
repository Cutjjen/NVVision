package nvvisionboost;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import nvvisionboost.mixin.NVVisionBoostRenderTargetAccessor;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/** Checks retained target references, complete view ownership and scaled depth on the real API. */
public final class NVVisionBoostTargetLeaseTest {
  private static int checks;

  private static void check(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  public static void main(String[] args) {
    if (!GLFW.glfwInit()) throw new IllegalStateException("GLFW unavailable");
    GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
    GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
    long window = GLFW.glfwCreateWindow(80, 60, "NVVision adapter regression", 0, 0);
    if (window == 0) throw new IllegalStateException("OpenGL unavailable");
    try {
      GLFW.glfwMakeContextCurrent(window);
      GL.createCapabilities();
      runOwnership();
      for (int percent : new int[] {85, 75, 50, 35, 25, 10}) runDepth(percent);
      check(GL11.glGetError() == GL11.GL_NO_ERROR, "No OpenGL errors");
      System.out.println(
          "PASS target adapter identity, views and scaled depth/stencil: " + checks + " checks");
    } finally {
      GLFW.glfwMakeContextCurrent(0);
      GLFW.glfwDestroyWindow(window);
      GLFW.glfwTerminate();
    }
  }

  private static void runOwnership() {
    var main = new FixtureTarget(80, 60);
    var internal = new FixtureTarget(28, 21);
    var retained = main;
    var nativeColor = main.getColorTexture();
    var nativeDepth = main.getDepthTexture();
    var nativeColorView = main.getColorTextureView();
    var nativeDepthView = main.getDepthTextureView();
    var worldColor = internal.getColorTexture();
    var worldDepth = internal.getDepthTexture();
    var lease = new NVVisionBoostTargetLease();
    lease.begin(main, internal);
    check(
        retained == main && retained.width == 28 && retained.height == 21,
        "Cached target sees world dimensions");
    check(
        main.getColorTexture() == worldColor && main.getDepthTexture() == worldDepth,
        "Borrowed attachments visible");
    check(
        main.getColorTextureView().texture() == worldColor
            && main.getDepthTextureView().texture() == worldDepth,
        "Views match attachments");
    check(
        internal.getColorTextureView() == nativeColorView
            && internal.getDepthTextureView() == nativeDepthView,
        "Native views remain owned");
    try {
      lease.begin(main, internal);
      throw new AssertionError("Nested lease accepted");
    } catch (IllegalStateException expected) {
      checks++;
    }
    // A mod can replace attachments while rendering; restoration must not discard or double-own
    // them.
    main.replace(28, 21);
    var replacementColor = main.getColorTexture();
    var replacementDepth = main.getDepthTexture();
    var replacementView = main.getColorTextureView();
    lease.restore();
    check(!lease.active() && main.width == 80 && main.height == 60, "Native dimensions restored");
    check(
        main.getColorTexture() == nativeColor && main.getDepthTexture() == nativeDepth,
        "Native textures restored");
    check(
        main.getColorTextureView() == nativeColorView
            && main.getDepthTextureView() == nativeDepthView,
        "Native views restored");
    check(
        internal.getColorTexture() == replacementColor
            && internal.getDepthTexture() == replacementDepth,
        "Mod replacement preserved");
    check(
        internal.getColorTextureView() == replacementView
            && replacementView.texture() == replacementColor,
        "Replacement view retained");
    check(
        !nativeColor.isClosed() && !replacementColor.isClosed(),
        "Exchange does not close textures");
    lease.restore();
    check(main.getColorTexture() == nativeColor, "Restore idempotent");
    try {
      lease.begin(main, main);
      throw new AssertionError("Aliased lease accepted");
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

  private static final class FixtureTexture extends GpuTexture {
    private boolean closed;

    FixtureTexture(int width, int height) {
      super(
          USAGE_RENDER_ATTACHMENT,
          "test",
          com.mojang.blaze3d.GpuFormat.RGBA8_UNORM,
          width,
          height,
          1,
          1);
    }

    @Override
    public void close() {
      closed = true;
    }

    @Override
    public boolean isClosed() {
      return closed;
    }
  }

  private static final class FixtureView extends GpuTextureView {
    private boolean closed;

    FixtureView(GpuTexture texture) {
      super(texture, 0, 1);
    }

    @Override
    public void close() {
      closed = true;
    }

    @Override
    public boolean isClosed() {
      return closed;
    }
  }

  private static final class FixtureTarget extends RenderTarget
      implements NVVisionBoostRenderTargetAccessor {
    FixtureTarget(int width, int height) {
      super("test", true, com.mojang.blaze3d.GpuFormat.RGBA8_UNORM);
      replace(width, height);
    }

    void replace(int width, int height) {
      this.width = width;
      this.height = height;
      colorTexture = new FixtureTexture(width, height);
      depthTexture = new FixtureTexture(width, height);
      colorTextureView = new FixtureView(colorTexture);
      depthTextureView = new FixtureView(depthTexture);
    }

    public GpuTexture nvvb$getColorTexture() {
      return colorTexture;
    }

    public void nvvb$setColorTexture(GpuTexture texture) {
      colorTexture = texture;
    }

    public GpuTexture nvvb$getDepthTexture() {
      return depthTexture;
    }

    public void nvvb$setDepthTexture(GpuTexture texture) {
      depthTexture = texture;
    }

    public GpuTextureView nvvb$getColorView() {
      return colorTextureView;
    }

    public void nvvb$setColorView(GpuTextureView view) {
      colorTextureView = view;
    }

    public GpuTextureView nvvb$getDepthView() {
      return depthTextureView;
    }

    public void nvvb$setDepthView(GpuTextureView view) {
      depthTextureView = view;
    }
  }
}
