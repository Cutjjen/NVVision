package nvvisionboost;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/** Transfers world depth to the native output so later mod passes use current world occlusion. */
final class NVVisionBoostDepthTransfer {
  private NVVisionBoostDepthTransfer() {}

  /**
   * Depth/stencil scaling requires NEAREST; preserves the caller's FBO bindings and scissor state.
   */
  static void copy(
      int source,
      int destination,
      int width,
      int height,
      int outputWidth,
      int outputHeight,
      boolean stencil) {
    int read = GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING);
    int draw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    boolean scissor = GL11.glIsEnabled(GL11.GL_SCISSOR_TEST);
    try {
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, source);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, destination);
      int mask = GL11.GL_DEPTH_BUFFER_BIT | (stencil ? GL11.GL_STENCIL_BUFFER_BIT : 0);
      GL30.glBlitFramebuffer(
          0, 0, width, height, 0, 0, outputWidth, outputHeight, mask, GL11.GL_NEAREST);
    } finally {
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, read);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, draw);
      if (scissor) GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }
  }
}
