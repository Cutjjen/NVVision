package nvvisionboost.rendering;

import com.mojang.blaze3d.opengl.GlStateManager;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Uses Minecraft's binding entry points so Iris/Oculus and driver state caches see every change. An
 * authoritative driver bind followed by the tracked entry point also repairs caches when another
 * mod used raw OpenGL.
 */
public final class MinecraftGlStateAdapter {
  private MinecraftGlStateAdapter() {}

  public static void bindFramebuffer(int target, int framebuffer) {
    GL30.glBindFramebuffer(target, framebuffer);
    GlStateManager._glBindFramebuffer(target, framebuffer);
  }

  public static void deleteFramebuffer(int framebuffer) {
    GlStateManager._glDeleteFramebuffers(framebuffer);
  }

  public static void useProgram(int program) {
    GL20.glUseProgram(program);
    GlStateManager._glUseProgram(program);
  }

  public static void activeTexture(int unit) {
    GL13.glActiveTexture(unit);
    GlStateManager._activeTexture(unit);
  }

  public static void bindTexture(int target, int texture) {
    if (target != GL11.GL_TEXTURE_2D)
      throw new IllegalArgumentException("Unsupported texture binding");
    GL11.glBindTexture(target, texture);
    GlStateManager._bindTexture(texture);
  }

  public static void deleteTexture(int texture) {
    GlStateManager._deleteTexture(texture);
  }
}
