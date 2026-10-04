package nvvisionboost.mixin;

import java.util.Arrays;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import nvvisionboost.NVVisionBoostClient;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
public abstract class NVVisionBoostOptionsMixin {
  @Shadow @Final @Mutable public KeyMapping[] keyMappings;

  @Inject(
      method = "<init>",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;load()V"))
  private void nvvb$key(CallbackInfo ci) {
    keyMappings = Arrays.copyOf(keyMappings, keyMappings.length + 1);
    keyMappings[keyMappings.length - 1] = NVVisionBoostClient.OPEN_CONFIG;
  }
}
