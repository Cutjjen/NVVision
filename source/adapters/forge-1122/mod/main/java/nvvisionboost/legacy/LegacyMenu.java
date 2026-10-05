package nvvisionboost.legacy;

import net.minecraft.client.gui.*;
import org.lwjgl.opengl.GL11;

/**
 * Native Java 8 menu, bilingual help and GPU theme; unavailable rendering capabilities stay
 * disabled.
 */
public final class LegacyMenu extends GuiScreen {
  private final GuiScreen parent;
  private int accent = 0xFF8BCB3F;
  private String gpu = "";

  public LegacyMenu(GuiScreen parent) {
    this.parent = parent;
  }

  private String t(String pt, String en) {
    return LegacyConfig.text(pt, en);
  }

  @Override
  public void initGui() {
    buttonList.clear();
    String vendor = GL11.glGetString(GL11.GL_VENDOR);
    gpu = GL11.glGetString(GL11.GL_RENDERER);
    if (vendor != null) {
      String v = vendor.toLowerCase(java.util.Locale.ROOT);
      accent =
          v.contains("amd") || v.contains("ati")
              ? 0xFFFF5555
              : v.contains("intel") ? 0xFF55AAFF : 0xFF8BCB3F;
    }
    int x = (width - 260) / 2;
    int y = Math.max(48, height / 6);
    addButton(
        new GuiButton(
            1,
            x,
            y,
            260,
            20,
            t("NVVision: ", "NVVision: ")
                + (LegacyConfig.enabled ? t("Ligado", "On") : t("Desligado", "Off"))));
    addButton(
        new GuiButton(
            2,
            x,
            y + 24,
            260,
            20,
            t("Perfil gráfico: ", "Graphics preset: ") + preset(LegacyConfig.gpuPreset)));
    GuiButton cpu =
        addButton(
            new GuiButton(
                3,
                x,
                y + 48,
                260,
                20,
                t("Perfil CPU: ", "CPU preset: ") + preset(LegacyConfig.cpuPreset)));
    cpu.enabled = LegacyClient.addon();
    GuiButton particles =
        addButton(
            new GuiButton(
                4,
                x,
                y + 72,
                260,
                20,
                t("Redução de partículas: ", "Particle reduction: ") + LegacyConfig.particles));
    particles.enabled = cpu.enabled;
    GuiButton entities =
        addButton(
            new GuiButton(
                5,
                x,
                y + 96,
                260,
                20,
                t("Distância de entidades: ", "Entity distance: ") + LegacyConfig.entities));
    entities.enabled = cpu.enabled;
    GuiButton upscale =
        addButton(
            new GuiButton(
                6, x, y + 120, 260, 20, t("Renderização nativa: 100%", "Native rendering: 100%")));
    upscale.enabled = false;
    addButton(new GuiButton(7, Math.max(0, width - 94), 4, 44, 20, "  BR"));
    addButton(new GuiButton(8, Math.max(0, width - 46), 4, 44, 20, "  EN"));
    addButton(new GuiButton(0, x, Math.max(y + 152, height - 28), 260, 20, t("Voltar", "Back")));
  }

  private String preset(int p) {
    return p == 0
        ? t("Original", "Original")
        : p == 1 ? t("Equilibrado", "Balanced") : t("Desempenho", "Performance");
  }

  @Override
  protected void actionPerformed(GuiButton button) {
    switch (button.id) {
      case 0:
        mc.displayGuiScreen(parent);
        return;
      case 1:
        LegacyConfig.enabled = !LegacyConfig.enabled;
        break;
      case 2:
        LegacyConfig.gpuPreset = (LegacyConfig.gpuPreset + 1) % 3;
        break;
      case 3:
        LegacyConfig.cpuPreset((LegacyConfig.cpuPreset + 1) % 3);
        break;
      case 4:
        LegacyConfig.particles = (LegacyConfig.particles + 1) % 3;
        LegacyConfig.cpuPreset = 0;
        break;
      case 5:
        LegacyConfig.entities = (LegacyConfig.entities + 1) % 3;
        LegacyConfig.cpuPreset = 0;
        break;
      case 7:
        LegacyConfig.english = false;
        break;
      case 8:
        LegacyConfig.english = true;
        break;
      default:
        return;
    }
    LegacyConfig.save();
    LegacyMinecraftAdapter.applyGraphics();
    initGui();
  }

  @Override
  public void drawScreen(int x, int y, float dt) {
    drawRect(0, 0, width, height, 0xEE081015);
    drawRect(8, 8, 11, height - 8, accent);
    drawCenteredString(fontRenderer, "NV VISION BOOST", width / 2, 16, accent);
    drawCenteredString(
        fontRenderer,
        fontRenderer.trimStringToWidth(gpu == null ? "" : gpu, Math.max(10, width - 30)),
        width / 2,
        30,
        0xFFBBBBBB);
    super.drawScreen(x, y, dt);
    for (GuiButton button : buttonList)
      if (button.id == 7 || button.id == 8) flag(button.x + 2, button.y + 5, button.id == 8);
    for (GuiButton button : buttonList)
      if (button.isMouseOver()) drawHoveringText(help(button.id), x, y);
  }

  private static void flag(int x, int y, boolean us) {
    if (us) {
      for (int row = 0; row < 7; row++)
        drawRect(x, y + row, x + 12, y + row + 1, row % 2 == 0 ? 0xFFB22234 : 0xFFFFFFFF);
      drawRect(x, y, x + 5, y + 4, 0xFF3C3B6E);
    } else {
      drawRect(x, y, x + 12, y + 8, 0xFF009C3B);
      for (int row = 0; row < 7; row++) {
        int half = 3 - Math.abs(3 - row);
        drawRect(x + 6 - half, y + row, x + 7 + half, y + row + 1, 0xFFFFDF00);
      }
      drawRect(x + 5, y + 2, x + 8, y + 6, 0xFF002776);
    }
  }

  private java.util.List<String> help(int id) {
    String message;
    switch (id) {
      case 1:
        message =
            t(
                "Ativa ou restaura os ajustes locais. Impacto variável.",
                "Enables or restores local changes. Variable hardware impact.");
        break;
      case 2:
        message =
            t(
                "0: original. 1: sem nuvens. 2: sombras e gráficos simples.",
                "0: original. 1: no clouds. 2: simple graphics and no entity shadows.");
        break;
      case 3:
        message =
            t(
                "0: original. 1: redução moderada. 2: redução maior de CPU.",
                "0: original. 1: moderate visual reduction. 2: stronger CPU workload reduction.");
        break;
      case 4:
        message =
            t(
                "0: original. 1: menos partículas. 2: mínimo. Menor carga visual.",
                "0: original. 1: fewer particles. 2: minimal. Lower visual workload.");
        break;
      case 5:
        message =
            t(
                "0: original. 1: 128 blocos. 2: 64. Preserva jogadores e entidades de mods.",
                "0: original. 1: 128 blocks. 2: 64. Preserves players and mod entities.");
        break;
      case 6:
        message =
            t(
                "Este backend antigo usa escala nativa; upscaling não validado.",
                "This legacy backend uses native scale; upscaling is not validated.");
        break;
      default:
        message =
            t(
                "Navegação ou idioma. Sem impacto no hardware.",
                "Navigation or language. No hardware impact.");
    }
    return fontRenderer.listFormattedStringToWidth(
        message, Math.max(80, Math.min(280, width - 20)));
  }
}
