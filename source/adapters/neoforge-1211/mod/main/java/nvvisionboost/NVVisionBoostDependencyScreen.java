package nvvisionboost;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Fatal dependency notice: one exit action, no route to a world or configuration. */
public final class NVVisionBoostDependencyScreen extends Screen {
  private static final Component DETAILS =
      Component.literal(
          "Instale Sodium OU Embeddium para NeoForge e Minecraft 1.21.1. "
              + "Use somente um renderizador. Iris é opcional e precisa ser compatível com ele. "
              + "A exigência é local: servidor e outros jogadores não precisam do NVVision. "
              + "Feche o jogo, instale a dependência e reinicie.");

  public NVVisionBoostDependencyScreen() {
    super(Component.literal("NVVisionBoost: dependÃªncia ausente"));
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

  // The themed screen owns its background; avoid blurring text a second time.
  @Override
  public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {}
}
