package nvvisionboost.mixin;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import nvvisionboost.NVVisionBoostFrameTiming;
import nvvisionboost.NVVisionBoostNativeRenderer;
import nvvisionboost.NVVisionBoostShaderStartup;
import nvvisionboost.NVVisionBoostUniformSnapshot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = GameRenderer.class, priority = 1100)
public abstract class NVVisionBoostGameRendererMixin {
  @Unique private NVVisionBoostUniformSnapshot nvvb$nativeUniforms;

  @Inject(method = "render", at = @At("HEAD"))
  private void nvvb$start(CallbackInfo ci) {
    NVVisionBoostNativeRenderer.finishInterruptedPass();
    nvvb$nativeUniforms = null;
    NVVisionBoostShaderStartup.beforeRender();
    NVVisionBoostNativeRenderer.prepareFrame();
    NVVisionBoostFrameTiming.frameStart();
  }

  @ModifyArgs(
      method = "render",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GlobalSettingsUniform;update(IIDJLnet/minecraft/client/DeltaTracker;ILnet/minecraft/world/phys/Vec3;Z)V"))
  private void nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel) {
    if (!renderLevel) return;
    NVVisionBoostNativeRenderer.beginLevelRender();
    if (!NVVisionBoostNativeRenderer.effectActive()) return;
    nvvb$nativeUniforms =
        new NVVisionBoostUniformSnapshot(
            args.get(0),
            args.get(1),
            args.get(2),
            args.get(3),
            args.get(4),
            args.get(5),
            args.get(6),
            args.get(7));
    args.set(0, NVVisionBoostNativeRenderer.worldWidth(args.get(0)));
    args.set(1, NVVisionBoostNativeRenderer.worldHeight(args.get(1)));
  }

  @Redirect(
      method = "render",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/renderer/GameRenderer;renderLevel(Lnet/minecraft/client/DeltaTracker;)V"))
  private void nvvb$worldPass(GameRenderer renderer, DeltaTracker delta) {
    NVVisionBoostFrameTiming.beginWorld();
    boolean completed = false;
    try {
      renderer.renderLevel(delta);
      completed = true;
    } finally {
      try {
        if (completed) NVVisionBoostNativeRenderer.endLevelRender();
        else NVVisionBoostNativeRenderer.finishInterruptedPass();
      } finally {
        NVVisionBoostFrameTiming.endWorld();
        nvvb$restoreNativeUniforms();
      }
    }
  }

  @Inject(
      method = "render",
      at =
          @At(
              value = "INVOKE",
              target = "Lnet/minecraft/client/gui/render/GuiRenderer;render()V",
              shift = At.Shift.BEFORE))
  private void nvvb$restoreGuiUniforms(CallbackInfo ci) {
    NVVisionBoostNativeRenderer.finishInterruptedPass();
    nvvb$restoreNativeUniforms();
  }

  @Unique
  private void nvvb$restoreNativeUniforms() {
    NVVisionBoostUniformSnapshot snapshot = nvvb$nativeUniforms;
    nvvb$nativeUniforms = null;
    if (snapshot == null) return;
    ((NVVisionBoostGameRendererAccessor) this)
        .nvvb$getGlobalSettingsUniform()
        .update(
            snapshot.width(),
            snapshot.height(),
            snapshot.value(),
            snapshot.time(),
            snapshot.delta(),
            snapshot.scale(),
            snapshot.camera(),
            snapshot.filtering());
  }
}
