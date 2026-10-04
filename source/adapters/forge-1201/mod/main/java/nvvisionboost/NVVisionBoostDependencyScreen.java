package nvvisionboost;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Fatal dependency notice: one exit action, no route to a world or configuration. */
public final class NVVisionBoostDependencyScreen extends Screen {
  private static final Component DETAILS =
      NVVisionBoostUi.component(
          NVVisionBoostUi.text(
                  "Falta Embeddium OU Sodium compatível com Forge e Minecraft 1.20.1. Recomendado:")
              + NVVisionBoostUi.text(
                  " Embeddium 0.3.31. Sodium para Fabric não funciona aqui. Oculus é opcional para")
              + NVVisionBoostUi.text(
                  " shaderpacks. A exigência é local: outros jogadores e o servidor não precisam")
              + NVVisionBoostUi.text(
                  " do NVVisionBoost. Feche o jogo, instale a dependência e reinicie."));

  public NVVisionBoostDependencyScreen() {
    super(Component.literal("NVVisionBoost: dependência ausente"));
  }

  @Override
  protected void init() {
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Fechar Minecraft")),
                button -> minecraft.stop())
            .bounds((width - 160) / 2, height - 35, 160, 20)
            .build());
  }

  @Override
  public boolean shouldCloseOnEsc() {
    return false;
  }

  @Override
  public void onClose() {
    // Escape and screen back actions must not bypass the fatal startup notice.
  }

  @Override
  public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
    var theme = NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);
    graphics.fillGradient(0, 0, width, height, theme.background(), theme.header());
    graphics.fill(12, 12, 15, height - 12, theme.accent());
    graphics.drawCenteredString(
        font, NVVisionBoostUi.component(title.getString()), width / 2, 20, 0xFF7777);
    int textWidth = Math.max(100, Math.min(500, width - 32));
    int y = 50;
    for (var line : font.split(DETAILS, textWidth)) {
      graphics.drawString(font, line, (width - textWidth) / 2, y, 0xEEEEEE);
      y += font.lineHeight + 3;
    }
    super.render(graphics, mouseX, mouseY, partialTick);
  }
}
