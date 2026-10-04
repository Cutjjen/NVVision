/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostIrisDepthMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import com.mojang.blaze3d.textures.GpuTexture;
import net.irisshaders.iris.gl.texture.DepthBufferFormat;
import net.irisshaders.iris.shaderpack.properties.PackDirectives;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Iris must compare texture identity as well as its per-target version counter. */
@Pseudo
@Mixin(targets = "net.irisshaders.iris.targets.RenderTargets", remap = false)
public abstract class NVVisionBoostIrisDepthMixin {
  @Shadow(remap = false)
  private GpuTexture currentDepthTexture;

  @Shadow(remap = false)
  private int cachedDepthBufferVersion;

  @Inject(method = "resizeIfNeeded", at = @At("HEAD"), remap = false)
  private void nvvb$depthIdentity(
      int version,
      GpuTexture incoming,
      int width,
      int height,
      DepthBufferFormat format,
      PackDirectives directives,
      CallbackInfoReturnable<Boolean> ci) {
    if (currentDepthTexture != incoming) cachedDepthBufferVersion = ~version;
  }
}
