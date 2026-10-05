package nvvisionboost.mixin;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.GlobalSettingsUniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GameRenderer.class)
public interface NVVisionBoostGameRendererAccessor {
  @Accessor("globalSettingsUniform")
  GlobalSettingsUniform nvvb$getGlobalSettingsUniform();
}
