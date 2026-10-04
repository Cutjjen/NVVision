package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * Eventos MOD do cliente.
 *
 * <p>Não registrar esta classe manualmente. @Mod.EventBusSubscriber já realiza o registro correto.
 */
@Mod.EventBusSubscriber(
    modid = NVVisionBoostForge.ID,
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.MOD)
public final class NVVisionBoostClient {
  public static final KeyMapping OPEN_CONFIG =
      new KeyMapping(
          "key.nvvisionboost.open",
          InputConstants.Type.KEYSYM,
          GLFW.GLFW_KEY_F8,
          "key.categories.nvvisionboost");

  private NVVisionBoostClient() {}

  /**
   * Registra somente o KeyMapping.
   *
   * <p>event.register(OPEN_CONFIG) NÃO é registro manual do EventBus.
   */
  @SubscribeEvent
  public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
    event.register(OPEN_CONFIG);
  }
}
