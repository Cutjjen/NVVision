package nvvisionboost.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import nvvisionboost.NVVisionBoostConfigScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Adds the client configuration entry after vanilla builds the options widgets. */
@Mixin(OptionsScreen.class)
public abstract class NVVisionBoostOptionsScreenMixin extends Screen {
  @Unique private Button nvvb$menu;
  @Unique private Button nvvb$done;

  protected NVVisionBoostOptionsScreenMixin(Component title) {
    super(title);
  }

  @Inject(method = "init()V", at = @At("TAIL"))
  private void nvvb$addMenu(CallbackInfo ci) {
    // Vanilla clears widgets on rebuild; never retain a button from the previous layout.
    nvvb$done = null;
    String doneLabel = Component.translatable("gui.done").getString();
    for (var child : children()) {
      if (child instanceof Button button && button.getMessage().getString().equals(doneLabel)) {
        nvvb$done = button;
        break;
      }
    }
    nvvb$menu =
        addRenderableWidget(
            nvvisionboost.NVVisionBoostMenuButton.builder(
                    Component.literal("NVVisionBoost"),
                    button -> minecraft.setScreen(new NVVisionBoostConfigScreen(this)))
                .bounds(0, 0, 150, 20)
                .build());
    nvvb$placeMenu();
  }

  @Inject(method = "repositionElements()V", at = @At("TAIL"))
  private void nvvb$resizeMenu(CallbackInfo ci) {
    nvvb$placeMenu();
  }

  @Unique
  private void nvvb$placeMenu() {
    if (nvvb$menu == null) return;
    int buttonWidth = Math.min(150, Math.max(1, (width - 18) / 2));
    int left = (width - buttonWidth * 2 - 8) / 2;
    int y = nvvb$done != null ? nvvb$done.getY() : Math.max(0, height - 28);
    if (nvvb$done != null) {
      nvvb$done.setWidth(buttonWidth);
      nvvb$done.setX(left);
    }
    nvvb$menu.setWidth(buttonWidth);
    nvvb$menu.setX(left + buttonWidth + 8);
    nvvb$menu.setY(y);
  }
}
