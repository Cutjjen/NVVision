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
    int extra = nvvisionboost.NVVisionBoostCpuTestAdapter.modelRadius();
    boolean original = NVVisionBoostPerformance.limitBlockEntities();
    if ((!original && extra <= 0) || camera == null) return;
    var id = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(entity.getType());
    if (id == null) return;
    if (extra > 0) {
      if (!nvvisionboost.NVVisionBoostCpuTestAdapter.supportsModel(id.getNamespace())) return;
    } else if (!id.getNamespace().equals("minecraft")) return;
    var renderer = ((BlockEntityRenderDispatcher) (Object) this).getRenderer(entity);
    // Preserve geometry from beacons and other long-distance renderers.
    if (renderer == null || renderer.shouldRenderOffScreen(entity)) return;
    int distance =
        extra > 0
            ? (original ? Math.min(extra, NVVisionBoostPerformance.blockEntityDistance()) : extra)
            : NVVisionBoostPerformance.blockEntityDistance();
    var position = entity.getBlockPos();
    var view = camera.getPosition();
    double dx = position.getX() + 0.5 - view.x;
    double dy = position.getY() + 0.5 - view.y;
    double dz = position.getZ() + 0.5 - view.z;
    if (dx * dx + dy * dy + dz * dz > (double) distance * distance) {
      if (extra > 0) nvvisionboost.NVVisionBoostCpuTestAdapter.modelSkipped();
      ci.cancel();
    }
  }
}
