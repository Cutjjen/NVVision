/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostOptionButton.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

/** Botão temático com foco visível, texto ajustado em pixels e ciclo reverso opcional. */
public final class NVVisionBoostOptionButton extends Button {
  private final OnPress leftPress;
  private final OnPress rightPress;
  private boolean selectedStyle;
  private final NVVisionBoostGpuTheme theme =
      NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);

  public NVVisionBoostOptionButton(
      int x,
      int y,
      int width,
      int height,
      Component message,
      OnPress leftPress,
      OnPress rightPress) {
    super(x, y, width, height, NVVisionBoostUi.component(message.getString()), leftPress, DEFAULT_NARRATION);
    this.leftPress = leftPress;
    this.rightPress = rightPress;
    setTooltip(net.minecraft.client.gui.components.Tooltip.create(
        NVVisionBoostUi.component(NVVisionBoostUi.help(message.getString(), rightPress != null))));
  }

  @Override
  public void setMessage(Component message) {
    super.setMessage(NVVisionBoostUi.component(message.getString()));
    setTooltip(net.minecraft.client.gui.components.Tooltip.create(
        NVVisionBoostUi.component(NVVisionBoostUi.help(message.getString(), rightPress != null))));
  }

  public void setSelectedStyle(boolean selected) {
    this.selectedStyle = selected;
  }

  @Override
  protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
    boolean highlighted = isHovered() || isFocused();
    int background =
        !active
            ? theme.background()
            : highlighted ? theme.hover() : selectedStyle ? theme.raised() : theme.surface();
    int border = active && (selectedStyle || highlighted) ? theme.accent() : theme.border();
    graphics.fill(getX() + 2, getY(), getX() + width - 2, getY() + height, border);
    graphics.fill(getX(), getY() + 2, getX() + width, getY() + height - 2, border);
    graphics.fill(getX() + 1, getY() + 2, getX() + width - 1, getY() + height - 2, background);
    if (selectedStyle)
      graphics.fill(getX() + 3, getY() + 4, getX() + 5, getY() + height - 4, theme.accent());
    var font = Minecraft.getInstance().font;
    boolean language = getMessage().getString().equals("BR") || getMessage().getString().equals("EN");
    if(language) NVVisionBoostUi.flag(graphics, getX()+3, getY(), getMessage().getString().equals("EN"));
    int available = Math.max(1, width - 18 - (language?14:0));
    String text = getMessage().getString();
    if (font.width(text) > available)
      text = font.plainSubstrByWidth(text, Math.max(1, available - font.width("…"))) + "…";
    graphics.drawCenteredString(
        font,
        text,
        getX() + width / 2 + (language?7:0),
        getY() + (height - 8) / 2,
        !active ? theme.muted() : selectedStyle ? theme.accent() : 0xFFEAF1F7);
  }

  @Override
  public boolean mouseClicked(double mouseX, double mouseY, int button) {
    if (!this.active || !this.visible || !this.isMouseOver(mouseX, mouseY)) return false;
    if (button == 1 && rightPress != null) {
      this.playDownSound(Minecraft.getInstance().getSoundManager());
      this.rightPress.onPress(this);
      return true;
    }
    if (button == 0) {
      this.playDownSound(Minecraft.getInstance().getSoundManager());
      this.leftPress.onPress(this);
      return true;
    }
    return false;
  }
}



