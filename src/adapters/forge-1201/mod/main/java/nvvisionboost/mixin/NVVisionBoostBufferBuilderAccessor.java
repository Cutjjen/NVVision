/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostBufferBuilderAccessor.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
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
