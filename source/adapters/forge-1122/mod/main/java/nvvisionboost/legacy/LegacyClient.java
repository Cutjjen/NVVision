package nvvisionboost.legacy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/**
 * Client adapter owns F8, the Options entry and world-entry help without changing other widgets.
 */
public final class LegacyClient {
  private static final int BUTTON = 0x4E5656;
  private static KeyBinding key;
  private static boolean joined;
  private static final LegacyParticleLease BASIC_PARTICLES = new LegacyParticleLease();

  public static boolean addon() {
    return Loader.isModLoaded("nvvisionvulkanbridge");
  }

  public static void initialize() {
    LegacyConfig.load(Minecraft.getMinecraft().mcDataDir.toPath());
    LegacyMinecraftAdapter.applyGraphics();
    org.apache.logging.log4j.LogManager.getLogger("NVVision")
        .info(
            "Renderer identity: {} (native legacy rendering)",
            nvvisionboost.NVVisionBoostRendererAdapter.resolve(Loader::isModLoaded).label());
    key = new KeyBinding("NVVision settings", Keyboard.KEY_F8, "NVVision");
    ClientRegistry.registerKeyBinding(key);
    MinecraftForge.EVENT_BUS.register(new LegacyClient());
  }

  @SubscribeEvent
  public void tick(TickEvent.ClientTickEvent event) {
    if (event.phase != TickEvent.Phase.END) return;
    Minecraft mc = Minecraft.getMinecraft();
    if (!addon() && mc.gameSettings != null)
      mc.gameSettings.particleSetting =
          BASIC_PARTICLES.apply(
              mc.gameSettings,
              mc.gameSettings.particleSetting,
              LegacyConfig.enabled && mc.world != null ? LegacyConfig.particles : 0);
    while (key != null && key.isPressed()) mc.displayGuiScreen(new LegacyMenu(mc.currentScreen));
    boolean world = mc.world != null && mc.player != null;
    if (world && !joined)
      mc.ingameGUI.setOverlayMessage(
          LegacyConfig.text(
              "NVVision: aperte F8 ou abra Opções", "NVVision: press F8 or open Options"),
          false);
    joined = world;
  }

  @SubscribeEvent
  public void options(GuiScreenEvent.InitGuiEvent.Post event) {
    if (!(event.getGui() instanceof GuiOptions)) return;
    GuiScreen screen = event.getGui();
    for (GuiButton button : event.getButtonList()) if (button.id == BUTTON) return;
    int x = (screen.width - 200) / 2;
    // Find an actual free centered row; never place over another mod's controls.
    for (int y = screen.height / 6 + 24; y < screen.height - 28; y += 24) {
      boolean free = true;
      for (GuiButton button : event.getButtonList())
        if (button.visible) {
          int height = height(button);
          if (height < 0) return;
          if (x < button.x + button.getButtonWidth()
              && x + 200 > button.x
              && y < button.y + height
              && y + 20 > button.y) {
            free = false;
            break;
          }
        }
      if (free) {
        event.getButtonList().add(new GuiButton(BUTTON, x, y, 200, 20, "NVVision"));
        return;
      }
    }
  }

  private static int height(GuiButton button) {
    for (String name : new String[] {"height", "field_146121_g"})
      try {
        java.lang.reflect.Field field = GuiButton.class.getDeclaredField(name);
        field.setAccessible(true);
        return field.getInt(button);
      } catch (ReflectiveOperationException ex) {
        /* Try the other namespace. */
      }
    return -1;
  }

  @SubscribeEvent
  public void click(GuiScreenEvent.ActionPerformedEvent.Post event) {
    if (event.getButton().id == BUTTON)
      Minecraft.getMinecraft().displayGuiScreen(new LegacyMenu(event.getGui()));
  }
}
