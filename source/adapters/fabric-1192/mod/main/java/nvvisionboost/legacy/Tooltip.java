package nvvisionboost.legacy;

import net.minecraft.network.chat.Component;

/** Local tooltip value for the pre-1.19.3 widget API. */
public record Tooltip(Component message) {
  public static Tooltip create(Component message) {
    return new Tooltip(message);
  }
}
