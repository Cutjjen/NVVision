package nvvisionboost.mixin;

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
}
