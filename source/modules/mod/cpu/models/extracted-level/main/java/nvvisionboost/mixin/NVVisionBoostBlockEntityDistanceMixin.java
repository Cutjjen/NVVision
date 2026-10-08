package nvvisionboost.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.registries.BuiltInRegistries;
import nvvisionboost.NVVisionBoostCpuTestAdapter;
import nvvisionboost.NVVisionBoostPerformance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Extracted-state adapter: use the same camera state as the native submission, never the live
 * camera or an immediate-render coordinate space.
 */
@Mixin(BlockEntityRenderDispatcher.class)
public abstract class NVVisionBoostBlockEntityDistanceMixin {
  @Inject(method = "submit", at = @At("HEAD"), cancellable = true, require = 1)
  private void nvvb$distance(
      BlockEntityRenderState state,
      PoseStack stack,
      SubmitNodeCollector collector,
      CameraRenderState camera,
      CallbackInfo ci) {
    int extra = NVVisionBoostCpuTestAdapter.modelRadius();
    boolean basic = NVVisionBoostPerformance.limitBlockEntities();
    if ((!basic && extra <= 0)
        || state == null
        || camera == null
        || camera.pos == null
        || state.blockPos == null
        || state.blockEntityType == null) return;
    var id = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(state.blockEntityType);
    if (id == null
        || (extra > 0
            ? !NVVisionBoostCpuTestAdapter.supportsModel(id.getNamespace())
            : !"minecraft".equals(id.getNamespace()))) return;
    var renderer = ((BlockEntityRenderDispatcher) (Object) this).getRenderer(state);
    if (renderer == null || renderer.shouldRenderOffScreen()) return;
    int radius = extra > 0 ? extra : NVVisionBoostPerformance.blockEntityDistance();
    var pos = state.blockPos;
    double dx = pos.getX() + 0.5 - camera.pos.x;
    double dy = pos.getY() + 0.5 - camera.pos.y;
    double dz = pos.getZ() + 0.5 - camera.pos.z;
    double distance = dx * dx + dy * dy + dz * dz;
    if (Double.isFinite(distance) && distance > (double) radius * radius) {
      if (extra > 0) NVVisionBoostCpuTestAdapter.modelSkipped();
      ci.cancel();
    }
  }
}
