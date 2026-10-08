package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

/** Native NeoForge key registration avoids altering another mod's Options array. */
public final class NVVisionBoostClient {
  public static final KeyMapping.Category CATEGORY =
      new KeyMapping.Category(ResourceLocation.fromNamespaceAndPath("nvvisionboost", "controls"));
  public static final KeyMapping OPEN_CONFIG =
      new KeyMapping(
          "key.nvvisionboost.open", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F8, CATEGORY);

  public static void registerKeys(RegisterKeyMappingsEvent event) {
    event.registerCategory(CATEGORY);
    event.register(OPEN_CONFIG);
  }

  private NVVisionBoostClient() {}
}
