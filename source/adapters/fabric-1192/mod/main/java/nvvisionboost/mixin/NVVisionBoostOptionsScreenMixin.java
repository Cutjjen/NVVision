package nvvisionboost.mixin;

import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.network.chat.Component;
import nvvisionboost.NVVisionBoostConfigScreen;
import nvvisionboost.legacy.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Adds the client configuration entry after vanilla builds the options widgets. */
@Mixin(OptionsScreen.class)
public abstract class NVVisionBoostOptionsScreenMixin
    extends net.minecraft.client.gui.screens.Screen {
  @Unique private Button nvvb$menu;

  protected NVVisionBoostOptionsScreenMixin(Component title) {
    super(title);
  }

  @Inject(method = "init()V", at = @At("TAIL"))
  private void nvvb$addMenu(CallbackInfo ci) {
    // Vanilla has built its widgets; only the NVVision entry belongs to this mixin.
    nvvb$menu =
        addRenderableWidget(
            nvvisionboost.NVVisionBoostMenuButton.builder(
                    Component.literal("NVVisionBoost"),
                    button -> minecraft.setScreen(new NVVisionBoostConfigScreen(this)))
                .bounds(0, 0, 150, 20)
                .build());
    nvvb$placeMenu();
  }

  @Unique
  private void nvvb$placeMenu() {
    if (nvvb$menu == null) return;
    nvvisionboost.NVVisionBoostOptionsScreenAdapter.place(this, nvvb$menu);
  }
}
