package nvvisionboost.vulkanbridge.mixin;

import net.minecraft.client.Minecraft;
import nvvisionboost.vulkanbridge.FabricBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Vanilla tick/shutdown boundary for the independently installed client addon. */
@Mixin(Minecraft.class)
public abstract class FabricCpuLifecycleMixin {
  @Inject(method = "tick()V", at = @At("TAIL"))
  private void nvvision$tick(CallbackInfo ci) {
    FabricBridge.tick();
  }

  @Inject(method = "close()V", at = @At("HEAD"))
  private void nvvision$close(CallbackInfo ci) {
    FabricBridge.shutdown();
  }
}
