package nvvisionboost.mixin;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.ShaderInstance;
import nvvisionboost.NVVisionBoostNativeRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Pixel uniforms follow the active target, including projection extensions. */
@Mixin(ShaderInstance.class)
public abstract class NVVisionBoostScreenSizeMixin {
  @Inject(method = "setDefaultUniforms", at = @At("TAIL"))
  private void nvvision$screenSize(
      VertexFormat.Mode mode, Matrix4f view, Matrix4f projection, Window window, CallbackInfo ci) {
    ShaderInstance shader = (ShaderInstance) (Object) this;
    if (shader.SCREEN_SIZE != null && NVVisionBoostNativeRenderer.isReducedMainBound()) {
      shader.SCREEN_SIZE.set(
          (float) NVVisionBoostNativeRenderer.internalWidth(),
          (float) NVVisionBoostNativeRenderer.internalHeight());
    }
  }
}
