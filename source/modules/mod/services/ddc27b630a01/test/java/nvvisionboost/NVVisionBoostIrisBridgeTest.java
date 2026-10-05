package nvvisionboost;

import com.mojang.blaze3d.opengl.GlTexture;
import com.mojang.blaze3d.textures.GpuTexture;
import java.lang.reflect.Field;
import nvvisionboost.mixin.NVVisionBoostIrisDepthMixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Exercises the actual depth injection without allocating GPU resources. */
public final class NVVisionBoostIrisBridgeTest {
  private static final class Target extends NVVisionBoostIrisDepthMixin {}

  private static int checks;

  private static void require(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  public static void main(String[] args) throws Exception {
    Field singleton = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
    singleton.setAccessible(true);
    sun.misc.Unsafe unsafe = (sun.misc.Unsafe) singleton.get(null);
    GpuTexture original = (GpuTexture) unsafe.allocateInstance(GlTexture.class);
    GpuTexture reduced = (GpuTexture) unsafe.allocateInstance(GlTexture.class);
    Target target = new Target();
    Field depth = NVVisionBoostIrisDepthMixin.class.getDeclaredField("currentDepthTexture");
    Field version = NVVisionBoostIrisDepthMixin.class.getDeclaredField("cachedDepthBufferVersion");
    depth.setAccessible(true);
    version.setAccessible(true);
    var injection =
        java.util.Arrays.stream(NVVisionBoostIrisDepthMixin.class.getDeclaredMethods())
            .filter(m -> m.getName().equals("nvvb$depthIdentity"))
            .findFirst()
            .orElseThrow();
    injection.setAccessible(true);
    depth.set(target, original);
    version.setInt(target, 1);
    injection.invoke(
        target,
        1,
        original,
        1280,
        720,
        null,
        null,
        new CallbackInfoReturnable<Boolean>("resizeIfNeeded", false));
    require(version.getInt(target) == 1, "Same texture must not trigger a resize each frame");
    injection.invoke(
        target,
        1,
        reduced,
        960,
        540,
        null,
        null,
        new CallbackInfoReturnable<Boolean>("resizeIfNeeded", false));
    require(version.getInt(target) != 1, "Different texture with equal version must reattach");
    depth.set(target, reduced);
    version.setInt(target, 1);
    injection.invoke(
        target,
        1,
        original,
        1280,
        720,
        null,
        null,
        new CallbackInfoReturnable<Boolean>("resizeIfNeeded", false));
    require(version.getInt(target) != 1, "Returning to native target must reattach too");
    NVVisionBoostCore.Config config = new NVVisionBoostCore.Config();
    config.autoOptimize = false;
    for (int scale : new int[] {85, 75, 67, 100}) {
      NVVisionBoostImageQuality.configure(config, scale);
      require(config.renderScalePercent == scale, "Preset scale");
      require(config.dynamicMinScalePercent <= scale, "Quality floor below ceiling");
      require(!config.autoOptimize, "Preset must preserve automatic optimization preference");
      require(config.upscalingEnabled == (scale < 100), "Native preset bypasses upscaler");
    }
    System.out.println("Passed " + checks + " Iris depth and quality preset checks.");
  }
}
