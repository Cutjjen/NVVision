package nvvisionboost;

import java.util.ArrayList;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import nvvisionboost.legacy.Button;

/**
 * Minecraft widget boundary for the Options entry. Reuse on ports only after verifying widget and
 * lifecycle APIs; placement policy remains independent of Minecraft and the loader.
 */
public final class NVVisionBoostOptionsScreenAdapter {
  /** Align only NVVision's button to the current visible layout after other mods initialize it. */
  public static void place(Screen screen, Button entry) {
    var occupied = new ArrayList<NVVisionBoostOptionsPlacement.Rect>();
    for (var child : screen.children()) {
      if (child instanceof AbstractWidget widget && widget != entry && widget.visible)
        occupied.add(
            new NVVisionBoostOptionsPlacement.Rect(
                widget.x, widget.y, widget.getWidth(), widget.getHeight()));
    }
    var position = NVVisionBoostOptionsPlacement.place(screen.width, screen.height, occupied);
    entry.visible = position.isPresent();
    position.ifPresent(
        rect -> {
          entry.setX(rect.x());
          entry.setY(rect.y());
          entry.setWidth(rect.width());
        });
  }

  private NVVisionBoostOptionsScreenAdapter() {}
}
