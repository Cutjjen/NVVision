package nvvisionboost.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.particles.ParticleOptions;
import nvvisionboost.NVVisionBoostPerformance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

<<<<<<< HEAD
/** Reduce only tickRain splashes while preserving rain, sounds and mod particles. */
=======
/** Reduz apenas respingos criados por tickRain; preserva chuva, sons e partículas de mods. */
>>>>>>> origin/master
@Mixin(value = LevelRenderer.class, priority = 900)
public abstract class NVVisionBoostWeatherParticlesMixin {
  @Unique private int nvvb$rainParticleCounter;

  @Redirect(
      method = "tickRain",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/client/multiplayer/ClientLevel;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"),
      require = 0)
  private void nvvb$rainParticle(
      ClientLevel level,
      ParticleOptions type,
      double x,
      double y,
      double z,
      double dx,
      double dy,
      double dz) {
    if (!NVVisionBoostPerformance.reduceWeatherParticles() || (++nvvb$rainParticleCounter & 3) == 0)
      level.addParticle(type, x, y, z, dx, dy, dz);
  }
}
