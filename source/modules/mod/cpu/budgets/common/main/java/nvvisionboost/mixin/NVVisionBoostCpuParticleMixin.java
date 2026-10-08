package nvvisionboost.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import nvvisionboost.NVVisionBoostCpuTestAdapter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Opt-in rejection before standard-engine particles enter ticking/render queues. */
@Mixin(value = ParticleEngine.class, priority = 900)
public abstract class NVVisionBoostCpuParticleMixin {
  @Inject(method = "add", at = @At("HEAD"), cancellable = true, require = 1)
  private void nvvision$particleBudget(Particle particle, CallbackInfo ci) {
    if (NVVisionBoostCpuTestAdapter.discardParticle(particle)) ci.cancel();
  }
}
