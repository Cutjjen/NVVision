package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

<<<<<<< HEAD
/** Accessor for temporary framebuffer exchange during world rendering. */
=======
/**
 * Accessor utilizado exclusivamente para trocar temporariamente o framebuffer durante a
 * renderização do mundo.
 */
>>>>>>> origin/master
@Mixin(Minecraft.class)
public interface NVVisionBoostMinecraftAccessor {
  @Invoker("getFramerateLimit")
  int nvvb$getFramerateLimit();

  @Accessor("mainRenderTarget")
  RenderTarget nvvb$getMainRenderTarget();

  @Accessor("mainRenderTarget")
  @Mutable
  void nvvb$setMainRenderTarget(RenderTarget target);
}
