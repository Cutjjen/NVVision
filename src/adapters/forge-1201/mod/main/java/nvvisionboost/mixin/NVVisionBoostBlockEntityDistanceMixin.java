/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Ponto de integração com a versão do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/mixin/NVVisionBoostBlockEntityDistanceMixin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import nvvisionboost.NVVisionBoostPerformance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityRenderDispatcher.class)
public abstract class NVVisionBoostBlockEntityDistanceMixin {
  @Shadow public Camera camera;

  @Inject(method = "render", at = @At("HEAD"), cancellable = true)
  private <E extends BlockEntity> void nvvb$distance(
      E entity,
      float partialTick,
      PoseStack poseStack,
      MultiBufferSource buffers,
      CallbackInfo ci) {
    if (!NVVisionBoostPerformance.limitBlockEntities() || camera == null) return;
    var id = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(entity.getType());
    if (id == null || !id.getNamespace().equals("minecraft")) return;
    var renderer = ((BlockEntityRenderDispatcher) (Object) this).getRenderer(entity);
    // Beacons e outros renderizadores de longo alcance mantêm sua geometria.
    if (renderer == null || renderer.shouldRenderOffScreen(entity)) return;
    int distance = NVVisionBoostPerformance.blockEntityDistance();
    var position = entity.getBlockPos();
    var view = camera.getPosition();
    double dx = position.getX() + 0.5 - view.x;
    double dy = position.getY() + 0.5 - view.y;
    double dz = position.getZ() + 0.5 - view.z;
    if (dx * dx + dy * dy + dz * dz > (double) distance * distance) ci.cancel();
  }
}
