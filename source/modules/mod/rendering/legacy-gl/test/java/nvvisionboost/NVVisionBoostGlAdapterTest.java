package nvvisionboost;

import com.mojang.blaze3d.platform.GlStateManager;
import nvvisionboost.rendering.MinecraftGlStateAdapter;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.*;

/** Exercises raw third-party state changes followed by tracked Minecraft adapter operations. */
public final class NVVisionBoostGlAdapterTest {
  private static int checks;

  private static void check(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  public static void main(String[] args) {
    if (!GLFW.glfwInit()) throw new IllegalStateException("GLFW unavailable");
    GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
    GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
    long window = GLFW.glfwCreateWindow(32, 32, "NVVision binding adapter test", 0, 0);
    if (window == 0) throw new IllegalStateException("OpenGL unavailable");
    try {
      GLFW.glfwMakeContextCurrent(window);
      GL.createCapabilities();
      try {
        com.mojang.blaze3d.systems.RenderSystem.class.getMethod("initRenderThread").invoke(null);
      } catch (NoSuchMethodException ignored) {
      } catch (ReflectiveOperationException error) {
        throw new IllegalStateException(error);
      }
      run();
      System.out.println(
          "PASS Minecraft tracked bindings after external OpenGL changes: " + checks + " checks");
    } finally {
      GLFW.glfwMakeContextCurrent(0);
      GLFW.glfwDestroyWindow(window);
      GLFW.glfwTerminate();
    }
  }

  private static void run() {
    int a = GL30.glGenFramebuffers(), b = GL30.glGenFramebuffers(), c = GL30.glGenFramebuffers();
    int textureA = GL11.glGenTextures(), textureB = GL11.glGenTextures();
    try {
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, a);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, b);
      check(
          GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING) == a,
          "Read target tracked independently");
      check(
          GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == b,
          "Draw target tracked independently");
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, c);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, b);
      GlStateManager._glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, b);
      check(
          GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == b,
          "Raw external draw target repaired");
      check(
          GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING) == a,
          "Read target survives draw repair");
      MinecraftGlStateAdapter.activeTexture(GL13.GL_TEXTURE1);
      GL13.glActiveTexture(GL13.GL_TEXTURE2);
      MinecraftGlStateAdapter.activeTexture(GL13.GL_TEXTURE1);
      GlStateManager._activeTexture(GL13.GL_TEXTURE1);
      check(
          GL11.glGetInteger(GL13.GL_ACTIVE_TEXTURE) == GL13.GL_TEXTURE1,
          "Driver and Minecraft active unit agree");
      MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, textureA);
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureB);
      MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, textureA);
      GlStateManager._bindTexture(textureA);
      check(
          GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D) == textureA,
          "Driver and cached texture agree");
      MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, 0);
      check(GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D) == 0, "Zero texture clears binding");
      MinecraftGlStateAdapter.useProgram(0);
      check(GL11.glGetInteger(GL20.GL_CURRENT_PROGRAM) == 0, "Program restoration tracked");
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
      check(
          GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING) == 0
              && GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == 0,
          "Native read and draw bindings restored");
      check(GL11.glGetError() == GL11.GL_NO_ERROR, "No OpenGL error");
    } finally {
      MinecraftGlStateAdapter.deleteFramebuffer(a);
      MinecraftGlStateAdapter.deleteFramebuffer(b);
      MinecraftGlStateAdapter.deleteFramebuffer(c);
      MinecraftGlStateAdapter.deleteTexture(textureA);
      MinecraftGlStateAdapter.deleteTexture(textureB);
    }
  }
}
