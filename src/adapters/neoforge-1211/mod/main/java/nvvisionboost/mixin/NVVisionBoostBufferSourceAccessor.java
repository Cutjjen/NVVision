/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostBufferSourceAccessor.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import com.mojang.blaze3d.vertex.BufferBuilder;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MultiBufferSource.BufferSource.class)
public interface NVVisionBoostBufferSourceAccessor {
  @Accessor("builder")
  BufferBuilder nvvb$getBuilder();

  @Accessor("fixedBuffers")
  Map<RenderType, BufferBuilder> nvvb$getFixedBuffers();

  @Accessor("lastState")
  Optional<RenderType> nvvb$getLastState();

  @Accessor("startedBuffers")
  Set<BufferBuilder> nvvb$getStartedBuffers();
}



