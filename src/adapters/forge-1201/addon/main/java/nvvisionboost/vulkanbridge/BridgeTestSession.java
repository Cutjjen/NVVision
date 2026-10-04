/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/BridgeTestSession.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;

import com.mojang.logging.LogUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Explicit laboratory option; normal gameplay never opens a world automatically. */
@Mod.EventBusSubscriber(modid = "nvvisionvulkanbridge", value = Dist.CLIENT)
public final class BridgeTestSession {
  private static boolean attempted;
  private BridgeTestSession() {}
  @SubscribeEvent
  public static void tick(TickEvent.ClientTickEvent event) {
    if (attempted || event.phase != TickEvent.Phase.END || !Boolean.getBoolean("nvvisionbridge.benchmark")) return;
    String name = System.getProperty("nvvisionbridge.testWorld", "");
    if (name.isBlank()) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc.level != null || mc.getOverlay() != null || !(mc.screen instanceof TitleScreen)) return;
    attempted = true;
    try {
      Path saves = mc.gameDirectory.toPath().resolve("saves").toAbsolutePath().normalize();
      Path world = saves.resolve(name).normalize();
      if (name.length() > 80 || !saves.equals(world.getParent()) || !Files.isRegularFile(world.resolve("level.dat")))
        throw new IllegalArgumentException("Test world must be an existing direct child of saves.");
      LogUtils.getLogger().info("[NVVision Benchmark] Opening explicit laboratory world: {}", name);
      mc.createWorldOpenFlows().loadLevel(mc.screen, name);
    } catch (Exception error) {
      LogUtils.getLogger().error("[NVVision Benchmark] Laboratory world not opened", error);
    }
  }
}
