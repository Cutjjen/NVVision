package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

/** A semântica das opções pertence ao pack. Não altera filas/propriedades/GLSL. */
public final class NVVisionBoostShaderQuality {
  private static String status = "Ajuste sombras e reflexos nas opções do shaderpack.";

  private NVVisionBoostShaderQuality() {}

  public static String label(int value) {
    return "Opções do shaderpack";
  }

  public static String status() {
    return status;
  }

  /** API antiga preservada; não aplica mais mapeamentos genéricos inseguros. */
  public static boolean apply(NVVisionBoostCore.Config config) {
    status = "Aplicação genérica desativada. Use as opções próprias do shaderpack.";
    return false;
  }

  public static boolean openOptions(Screen parent) {
    Minecraft mc = Minecraft.getInstance();
    if (mc == null) return false;
    for (String name :
        new String[] {
          "net.irisshaders.iris.gui.screen.ShaderPackScreen",
          "net.coderbot.iris.gui.screen.ShaderPackScreen"
        }) {
      try {
        Class<?> type = Class.forName(name);
        if (!Screen.class.isAssignableFrom(type)) continue;
        Screen screen = (Screen) type.getConstructor(Screen.class).newInstance(parent);
        mc.setScreen(screen);
        status = "Na tela do backend, abra as configurações do shader selecionado.";
        return true;
      } catch (ClassNotFoundException ignored) {
      } catch (ReflectiveOperationException | LinkageError | RuntimeException error) {
        NVVisionBoostCore.log("Abrir opções do shader: " + error);
      }
    }
    status = "Tela do backend indisponível. Abra Opções > Vídeo > Shaders no Minecraft.";
    return false;
  }
}
