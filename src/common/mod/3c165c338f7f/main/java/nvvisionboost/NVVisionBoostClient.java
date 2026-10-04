/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostClient.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

/** Native NeoForge key registration avoids altering another mod's Options array. */
public final class NVVisionBoostClient {
  public static final KeyMapping.Category CATEGORY =
      new KeyMapping.Category(Identifier.fromNamespaceAndPath("nvvisionboost", "controls"));
  public static final KeyMapping OPEN_CONFIG = new KeyMapping(
      "key.nvvisionboost.open", KeyConflictContext.UNIVERSAL,
      InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F8, CATEGORY);

  public static void registerKeys(RegisterKeyMappingsEvent event) {
    event.registerCategory(CATEGORY);
    event.register(OPEN_CONFIG);
  }
  private NVVisionBoostClient() {}
}
