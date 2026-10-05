package nvvisionboost.mixin;

import com.mojang.blaze3d.vertex.BufferBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Read-only accounting; reclaim is performed through BufferBuilder's normal clear API. */
@Mixin(BufferBuilder.class)
public interface NVVisionBoostBufferBuilderAccessor {
  @Accessor("renderedBufferPointer")
  int nvvb$getRenderedPointer();

  @Accessor("nextElementByte")
  int nvvb$getWritePointer();

  @Accessor("renderedBufferCount")
  int nvvb$getRenderedCount();

  @Accessor("building")
  boolean nvvb$isBuilding();
}
