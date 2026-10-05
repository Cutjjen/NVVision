package nvvisionboost;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

/** Themed button factory preserves Minecraft events and narration. */
public final class NVVisionBoostMenuButton {
  public static Builder builder(Component message, Button.OnPress press) {
    return new Builder(message, press);
  }

  public static final class Builder {
    private final Component message;
    private final Button.OnPress press;
    private int x, y, width = 150, height = 20;
    private Tooltip tooltip;

    private Builder(Component message, Button.OnPress press) {
      this.message = message;
      this.press = press;
    }

    public Builder bounds(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      return this;
    }

    public Builder tooltip(Tooltip tooltip) {
      this.tooltip = tooltip;
      return this;
    }

    public Button build() {
      var button = new NVVisionBoostOptionButton(x, y, width, height, message, press, null);
      if (tooltip != null) button.setTooltip(NVVisionBoostUi.enrich(tooltip, message.getString()));
      return button;
    }
  }

  private NVVisionBoostMenuButton() {}
}
