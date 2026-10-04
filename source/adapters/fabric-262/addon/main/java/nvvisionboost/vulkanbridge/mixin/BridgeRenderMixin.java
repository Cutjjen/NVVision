package nvvisionboost.vulkanbridge.mixin;

import nvvisionboost.vulkanbridge.FabricBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.renderer.GameRenderer")
public abstract class BridgeRenderMixin {
  @Inject(method = "render", at = @At("HEAD"))
  private void nvvbridge$before(CallbackInfo ci) {
    FabricBridge.beforeFrame();
  }

  @Inject(method = "render", at = @At("TAIL"))
  private void nvvbridge$after(CallbackInfo ci) {
    FabricBridge.afterFrame();
  }
}
