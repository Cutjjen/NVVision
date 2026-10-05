package nvvisionboost.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

/** Widget bridge supplies modern local conveniences without changing vanilla widgets. */
public class Button extends net.minecraft.client.gui.components.Button {
  public static final OnTooltip DEFAULT_NARRATION = NO_TOOLTIP;
  private Tooltip tooltip;

  public Button(int x, int y, int w, int h, Component message, OnPress press, OnTooltip narration) {
    super(x, y, w, h, message, press, narration);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int v) {
    x = v;
  }

  public void setY(int v) {
    y = v;
  }

  public void setTooltip(Tooltip value) {
    tooltip = value;
  }

  @Override
  public void renderButton(PoseStack pose, int x, int y, float dt) {
    renderWidget(new GuiGraphics(pose), x, y, dt);
  }

  protected void renderWidget(GuiGraphics g, int x, int y, float dt) {
    super.renderButton(g.pose, x, y, dt);
  }

  @Override
  public void renderToolTip(PoseStack pose, int x, int y) {
    Minecraft mc = Minecraft.getInstance();
    if (tooltip != null && mc.screen != null)
      mc.screen.renderTooltip(pose, tooltip.message(), x, y);
  }
}
