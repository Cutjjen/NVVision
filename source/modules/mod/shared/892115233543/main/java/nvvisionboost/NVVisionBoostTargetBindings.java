package nvvisionboost;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/** Validate only during target recreation; add no queries to ordinary frames. */
final class NVVisionBoostTargetBindings {
  private NVVisionBoostTargetBindings() {}

  static int texture(int bound, int oldColor, int oldDepth, int newColor, int newDepth) {
    int next =
        bound > 0 && bound == oldColor
            ? newColor
            : bound > 0 && bound == oldDepth ? newDepth : bound;
    return next > 0 && GL11.glIsTexture(next) ? next : 0;
  }

  static int framebuffer(int bound, int oldTarget, int newTarget) {
    int next = bound > 0 && bound == oldTarget ? newTarget : bound;
    return next > 0 && GL30.glIsFramebuffer(next) ? next : 0;
  }
}
