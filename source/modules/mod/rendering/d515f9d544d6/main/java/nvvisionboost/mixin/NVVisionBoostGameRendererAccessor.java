package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.GlobalSettingsUniform;
import net.minecraft.client.renderer.state.GameRenderState;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GameRenderer.class)
public interface NVVisionBoostGameRendererAccessor {
  @Accessor("globalSettingsUniform")
  GlobalSettingsUniform nvvb$getGlobalSettingsUniform();

  @Accessor("gameRenderState")
  GameRenderState nvvb$getGameRenderState();

  @Accessor("mainRenderTarget")
  RenderTarget nvvb$getMainRenderTarget();

  @Mutable
  @Accessor("mainRenderTarget")
  void nvvb$setMainRenderTarget(RenderTarget target);
}
