package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/**
 * NeoForge client MOD events. EventBusSubscriber owns registration; do not register this class
 * manually.
 */
public final class NVVisionBoostClient {
  public static final KeyMapping OPEN_CONFIG =
      new KeyMapping(
          "key.nvvisionboost.open",
          InputConstants.Type.KEYSYM,
          GLFW.GLFW_KEY_F8,
          "key.categories.nvvisionboost");

  private NVVisionBoostClient() {}
}
