package nvvisionboost;

import net.minecraft.client.DeltaTracker;

/** Native frame uniforms restored after the world pass and before GUI rendering. */
public record NVVisionBoostUniformSnapshot(
    int width, int height, double value, long time, DeltaTracker delta, int scale) {}
