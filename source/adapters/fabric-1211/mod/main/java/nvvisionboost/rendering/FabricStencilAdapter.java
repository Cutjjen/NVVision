package nvvisionboost.rendering;

import com.mojang.blaze3d.pipeline.RenderTarget;
import java.lang.reflect.InvocationTargetException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

/**
 * Fabric has no Forge stencil extension. Query actual attachments and use an optional extension
 * only when supplied by the target implementation. Unsupported packed targets retain native scale.
 */
public final class FabricStencilAdapter {
  public static boolean enabled(RenderTarget target) {
    if (target == null || target.frameBufferId < 0) return false;
    int read = GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING);
    int draw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    try {
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, target.frameBufferId);
      return GL30.glGetFramebufferAttachmentParameteri(
              GL30.GL_DRAW_FRAMEBUFFER,
              GL30.GL_STENCIL_ATTACHMENT,
              GL30.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE)
          != GL11.GL_NONE;
    } finally {
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, read);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, draw);
    }
  }

  public static void request(RenderTarget target) {
    if (enabled(target)) return;
    try {
      target.getClass().getMethod("enableStencil").invoke(target);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException error) {
      throw new UnsupportedOperationException(
          "Packed stencil extension unavailable; preserve native rendering", error);
    }
    if (!enabled(target))
      throw new IllegalStateException("Stencil extension did not attach a stencil image");
  }

  private FabricStencilAdapter() {}
}
