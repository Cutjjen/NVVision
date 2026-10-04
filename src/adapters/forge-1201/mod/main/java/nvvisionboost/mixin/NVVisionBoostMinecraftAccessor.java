/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostMinecraftAccessor.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * Accessor utilizado exclusivamente para trocar temporariamente o framebuffer durante a
 * renderização do mundo.
 */
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
