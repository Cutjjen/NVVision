package nvvisionboost.vulkanbridge.mixin;

import nvvisionboost.vulkanbridge.BridgeCpuOptimizer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.Minecraft.class)
public abstract class BridgeShutdownMixin {
  @Inject(method = "close", at = @At("HEAD"))
  private void nvvision$restoreOptions(CallbackInfo ci) {
    BridgeCpuOptimizer.shutdown();
  }
}
