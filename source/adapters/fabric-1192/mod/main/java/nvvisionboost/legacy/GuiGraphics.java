package nvvisionboost.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;

/** Drawing boundary forwarding every operation to Minecraft's original PoseStack. */
public final class GuiGraphics extends GuiComponent {
  public final PoseStack pose;

  public GuiGraphics(PoseStack pose) {
    this.pose = pose;
  }

  public void fill(int x, int y, int r, int b, int c) {
    GuiComponent.fill(pose, x, y, r, b, c);
  }

  public void fillGradient(int x, int y, int r, int b, int top, int bottom) {
    super.fillGradient(pose, x, y, r, b, top, bottom);
  }

  public void drawString(Font f, String s, int x, int y, int c) {
    GuiComponent.drawString(pose, f, s, x, y, c);
  }

  public void drawString(Font f, Component s, int x, int y, int c) {
    GuiComponent.drawString(pose, f, s, x, y, c);
  }

  public void drawString(Font f, net.minecraft.util.FormattedCharSequence s, int x, int y, int c) {
    GuiComponent.drawString(pose, f, s, x, y, c);
  }

  public void drawString(
      Font f, net.minecraft.util.FormattedCharSequence s, int x, int y, int c, boolean shadow) {
    if (shadow) f.drawShadow(pose, s, x, y, c);
    else f.draw(pose, s, x, y, c);
  }

  public void drawWordWrap(Font f, Component s, int x, int y, int w, int c) {
    for (var line : f.split(s, w)) {
      drawString(f, line, x, y, c);
      y += f.lineHeight;
    }
  }

  public void drawCenteredString(Font f, String s, int x, int y, int c) {
    GuiComponent.drawCenteredString(pose, f, s, x, y, c);
  }

  public void drawCenteredString(Font f, Component s, int x, int y, int c) {
    GuiComponent.drawCenteredString(pose, f, s, x, y, c);
  }
}
