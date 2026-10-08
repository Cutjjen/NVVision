package nvvisionboost;

import java.lang.reflect.Field;

/**
 * Invalidates Iris attachment caches after internal textures have been reallocated. Texture names
 * are reusable OpenGL handles, not allocation identities: an unchanged integer cannot prove that a
 * framebuffer still refers to the current image. This adapter asks Iris to reattach both depth and
 * final color during its next normal world pass, without reloading the shader pack, allocating Iris
 * resources, or changing its render dimensions directly.
 */
final class NVVisionBoostShaderAttachmentAdapter {
  private NVVisionBoostShaderAttachmentAdapter() {}

  static void invalidate(Object pipeline, int depthVersion) throws ReflectiveOperationException {
    Object targets = field(pipeline.getClass(), "renderTargets").get(pipeline);
    Object finalPass = field(pipeline.getClass(), "finalPassRenderer").get(pipeline);
    if (targets == null || finalPass == null)
      throw new IllegalStateException("Shader attachment owners are not ready");
    // Resolve every capability before mutation. Unknown backends use native rendering recovery.
    Field depth = field(targets.getClass(), "cachedDepthBufferVersion");
    Field color = field(finalPass.getClass(), "lastColorTextureId");
    if (depth.getType() != int.class || color.getType() != int.class)
      throw new IllegalStateException("Unsupported shader attachment cache types");
    depth.setInt(targets, ~depthVersion);
    color.setInt(finalPass, -1);
  }

  private static Field field(Class<?> type, String name) throws NoSuchFieldException {
    for (Class<?> current = type; current != null; current = current.getSuperclass()) {
      try {
        Field field = current.getDeclaredField(name);
        field.setAccessible(true);
        return field;
      } catch (NoSuchFieldException missing) {
        // Older or derived pipelines may declare the capability on their superclass.
      }
    }
    throw new NoSuchFieldException(type.getName() + "." + name);
  }
}
