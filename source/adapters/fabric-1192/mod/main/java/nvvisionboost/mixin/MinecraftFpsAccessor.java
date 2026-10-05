package nvvisionboost.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Exact legacy FPS field boundary; transformed by Mixin before client code runs. */
@Mixin(Minecraft.class)
public interface MinecraftFpsAccessor {
  @Accessor("fps")
  static int nvvb$getFps() {
    throw new AssertionError("Mixin accessor not transformed");
  }
}
