package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;

public final class NVVisionBoostClient {
  public static final KeyMapping OPEN_CONFIG =
      new KeyMapping(
          "key.nvvisionboost.open",
          InputConstants.Type.KEYSYM,
          GLFW.GLFW_KEY_F8,
          KeyMapping.Category.register(
              ResourceLocation.fromNamespaceAndPath("nvvisionboost", "controls")));

  private NVVisionBoostClient() {}
}
