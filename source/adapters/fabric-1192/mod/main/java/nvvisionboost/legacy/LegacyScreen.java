package nvvisionboost.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;

/** Screen bridge preserves the native widget rendering and narration lifecycle. */
public abstract class LegacyScreen extends net.minecraft.client.gui.screens.Screen {
  protected LegacyScreen(Component title) {
    super(title);
  }

  @Override
  public final void render(PoseStack pose, int x, int y, float dt) {
    render(new GuiGraphics(pose), x, y, dt);
  }

  public void render(GuiGraphics g, int x, int y, float dt) {
    super.render(g.pose, x, y, dt);
  }

  protected void renderBackground(GuiGraphics g) {
    super.renderBackground(g.pose);
  }
}
