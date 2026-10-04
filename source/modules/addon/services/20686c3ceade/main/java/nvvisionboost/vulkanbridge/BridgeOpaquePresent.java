package nvvisionboost.vulkanbridge;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/**
 * Alpha-only final presentation fix. RGB, depth, textures and cached Minecraft state are preserved.
 */
final class BridgeOpaquePresent {
  private static final ByteBuffer MASK = BufferUtils.createByteBuffer(4);
  private static final float[] OPAQUE = {0, 0, 0, 1};

  private BridgeOpaquePresent() {}

  static void normalize(int target) {
    int framebuffer = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    boolean indexedScissor =
        GL.getCapabilities().OpenGL41 || GL.getCapabilities().GL_ARB_viewport_array;
    boolean scissor = GL11.glIsEnabled(GL11.GL_SCISSOR_TEST);
    MASK.clear();
    GL11.glGetBooleanv(GL11.GL_COLOR_WRITEMASK, MASK);
    try {
      if (indexedScissor) GL30.glDisablei(GL11.GL_SCISSOR_TEST, 0);
      else GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL30.glColorMaski(0, false, false, false, true);
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, target);
      GL30.glClearBufferfv(GL11.GL_COLOR, 0, OPAQUE);
      if (target != 0) {
        GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, 0);
        GL30.glClearBufferfv(GL11.GL_COLOR, 0, OPAQUE);
      }
    } finally {
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, framebuffer);
      GL30.glColorMaski(0, MASK.get(0) != 0, MASK.get(1) != 0, MASK.get(2) != 0, MASK.get(3) != 0);
      if (scissor) {
        if (indexedScissor) GL30.glEnablei(GL11.GL_SCISSOR_TEST, 0);
        else GL11.glEnable(GL11.GL_SCISSOR_TEST);
      }
    }
  }
}
