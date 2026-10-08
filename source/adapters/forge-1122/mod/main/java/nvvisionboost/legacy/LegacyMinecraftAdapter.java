package nvvisionboost.legacy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

/**
 * Minecraft boundary: reversible visual options; never reallocates shader targets or reloads
 * textures.
 */
public final class LegacyMinecraftAdapter {
  private static GameSettings owner;
  private static boolean originalFancy, originalShadows, lastFancy, lastShadows;
  private static int originalClouds, lastClouds;
  private static boolean leased;

  public static void applyGraphics() {
    GameSettings options = Minecraft.getMinecraft().gameSettings;
    if (owner != options) {
      owner = options;
      leased = false;
    }
    if (!LegacyConfig.enabled || LegacyConfig.gpuPreset == 0) {
      restore();
      return;
    }
    if (!leased) {
      originalFancy = options.fancyGraphics;
      originalShadows = options.entityShadows;
      originalClouds = options.clouds;
      leased = true;
    } else {
      if (options.fancyGraphics != lastFancy) originalFancy = options.fancyGraphics;
      if (options.entityShadows != lastShadows) originalShadows = options.entityShadows;
      if (options.clouds != lastClouds) originalClouds = options.clouds;
    }
    lastFancy = LegacyConfig.gpuPreset < 2 && originalFancy;
    lastShadows = LegacyConfig.gpuPreset < 2 && originalShadows;
    lastClouds = 0;
    options.fancyGraphics = lastFancy;
    options.entityShadows = lastShadows;
    options.clouds = lastClouds;
  }

  private static void restore() {
    if (!leased || owner == null) return;
    if (owner.fancyGraphics == lastFancy) owner.fancyGraphics = originalFancy;
    if (owner.entityShadows == lastShadows) owner.entityShadows = originalShadows;
    if (owner.clouds == lastClouds) owner.clouds = originalClouds;
    leased = false;
  }

  /** Legacy backend has no verified world/HUD target lease; expose native rendering honestly. */
  public static boolean supportsSpatialUpscaling() {
    return false;
  }

  private LegacyMinecraftAdapter() {}
}
