package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

/**
<<<<<<< HEAD
 * NeoForge client MOD events. EventBusSubscriber owns registration; do not register this class
 * manually.
=======
 * Eventos MOD do cliente.
 *
 * <p>Não registrar esta classe manualmente. @net.neoforged.fml.common.EventBusSubscriber já realiza
 * o registro correto.
>>>>>>> origin/master
 */
@net.neoforged.fml.common.EventBusSubscriber(
    modid = NVVisionBoostCore.ID,
    value = Dist.CLIENT,
    bus = net.neoforged.fml.common.EventBusSubscriber.Bus.MOD)
public final class NVVisionBoostClient {
  public static final KeyMapping OPEN_CONFIG =
      new KeyMapping(
          "key.nvvisionboost.open",
          InputConstants.Type.KEYSYM,
          GLFW.GLFW_KEY_F8,
          "key.categories.nvvisionboost");

  private NVVisionBoostClient() {}

  /**
<<<<<<< HEAD
   * Register only the key mapping. Registering a key mapping is not manual EventBus registration.
=======
   * Registra somente o KeyMapping.
   *
   * <p>event.register(OPEN_CONFIG) NÃO é registro manual do EventBus.
>>>>>>> origin/master
   */
  @SubscribeEvent
  public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
    event.register(OPEN_CONFIG);
  }
}
