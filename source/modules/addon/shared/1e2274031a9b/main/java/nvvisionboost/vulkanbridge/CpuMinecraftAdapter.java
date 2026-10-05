package nvvisionboost.vulkanbridge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.ParticleStatus;

/** Cutjjen: isolates the particle enum package changed by Minecraft versions. */
public final class CpuMinecraftAdapter {
  private CpuMinecraftAdapter() {}

  /** Reads the native particle budget: 0=all, 1=decreased, 2=minimal. */
  public static int particles(Minecraft client) {
    return client.options.particles().get().ordinal();
  }

  /** Writes a valid native particle budget on the client thread. */
  public static void particles(Minecraft client, int budget) {
    client.options.particles().set(ParticleStatus.values()[Math.max(0, Math.min(2, budget))]);
  }
}
