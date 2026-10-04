/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostTextureScreen.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Tela separada: não sobrepõe lista de shaders nem botões de qualidade. */
public final class NVVisionBoostTextureScreen extends Screen {
  private final Screen parent;

  public NVVisionBoostTextureScreen(Screen parent) {
    super(Component.literal("Mipmaps seguros de texturas"));
    this.parent = parent;
  }

  @Override
  protected void init() {
    clearWidgets();
    NVVisionBoostUi.languages(width, this::init, b -> addRenderableWidget(b));
    int buttonWidth = Math.min(320, width - 32);
    int left = (width - buttonWidth) / 2;
    int top = Math.max(30, height / 2 - 70);
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(
                    NVVisionBoostUi.text("Texturas: ")
                        + NVVisionBoostTextureOptimizer.label(
                            NVVisionBoostCore.cfg.textureMipmapLevel)),
                button -> {
                  NVVisionBoostCore.cfg.textureMipmapLevel =
                      NVVisionBoostTextureOptimizer.next(
                          NVVisionBoostCore.cfg.textureMipmapLevel, 1);
                  NVVisionBoostCore.saveConfig();
                  button.setMessage(
                      NVVisionBoostUi.component(
                          NVVisionBoostUi.text("Texturas: ")
                              + NVVisionBoostTextureOptimizer.label(
                                  NVVisionBoostCore.cfg.textureMipmapLevel)));
                })
            .bounds(left, top, buttonWidth, 22)
            .tooltip(
                NVVisionBoostUi.tooltip(
                    NVVisionBoostUi.component(
                        NVVisionBoostUi.text("Salva o nível escolhido. Clique em Aplicar para recarregar as texturas."))))
            .build());
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Aplicar mipmaps")),
                button -> NVVisionBoostTextureOptimizer.apply(NVVisionBoostCore.cfg))
            .bounds(left, top + 28, buttonWidth, 22)
            .build());
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(NVVisionBoostUi.component(NVVisionBoostUi.text("Voltar")), button -> onClose())
            .bounds(left, height - 32, buttonWidth, 22)
            .build());
  }

  @Override
  public void onClose() {
    Minecraft.getInstance().setScreen(parent);
  }

  @Override
  public void render(
      GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
    var theme = NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);
    graphics.fillGradient(0, 0, width, height, theme.background(), theme.header());
    graphics.fill(12, 12, 15, height - 12, theme.accent());
    super.render(graphics, mouseX, mouseY, partialTick);
    graphics.drawCenteredString(font, NVVisionBoostUi.component(title.getString()), width / 2, 20, theme.accent());
    int y = Math.max(30, height / 2 - 70) + 58;
    graphics.drawWordWrap(
        font,
        NVVisionBoostUi.component(
            NVVisionBoostUi.text("Escolha o nível e clique em Aplicar. A recarga pode levar alguns segundos. ")
                + NVVisionBoostTextureOptimizer.status()),
        Math.max(8, width / 2 - 140),
        y,
        Math.min(280, width - 16),
        0xD0D0D0);
  }
}
