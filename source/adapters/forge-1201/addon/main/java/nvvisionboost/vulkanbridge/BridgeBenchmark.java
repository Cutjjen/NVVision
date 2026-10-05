package nvvisionboost.vulkanbridge;

import com.mojang.logging.LogUtils;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Opt-in test session. No telemetry, disk writes or timers during normal gameplay. */
@Mod.EventBusSubscriber(modid = "nvvisionvulkanbridge", value = Dist.CLIENT)
public final class BridgeBenchmark {
  private static final boolean FIXED_CAMERA = Boolean.getBoolean("nvvisionbridge.fixedTestCamera");
  private static final boolean ENABLED = Boolean.getBoolean("nvvisionbridge.benchmark");
  private static final long WARMUP = seconds("nvvisionbridge.warmupSeconds", 60);
  private static final long DURATION = seconds("nvvisionbridge.measureSeconds", 180);
  private static final double[] FRAMES = ENABLED ? new double[300_000] : null;
  private static int count;
  private static long started, previous;
  private static Object world;
  private static boolean finished;

  private static long seconds(String property, int fallback) {
    return Math.max(1, Math.min(3600, Integer.getInteger(property, fallback))) * 1_000_000_000L;
  }

  @SubscribeEvent
  public static void frame(TickEvent.RenderTickEvent event) {
    if (!ENABLED || finished || event.phase != TickEvent.Phase.START) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc.level == null || mc.player == null) {
      previous = 0;
      return;
    }
    if (FIXED_CAMERA) {
      mc.player.setYRot(0);
      mc.player.setXRot(0);
      mc.player.yRotO = 0;
      mc.player.xRotO = 0;
    }
    long now = System.nanoTime();
    if (world != mc.level) {
      world = mc.level;
      started = now;
      previous = 0;
      count = 0;
      LogUtils.getLogger()
          .info(
              "[NVVision Benchmark] World ready; warmup={}s measurement={}s",
              WARMUP / 1_000_000_000L,
              DURATION / 1_000_000_000L);
    }
    if (now - started >= WARMUP + DURATION) {
      finished = true;
      save(mc);
      if (Boolean.getBoolean("nvvisionbridge.closeAfterBenchmark")) mc.stop();
      return;
    }
    if (now - started < WARMUP
        || mc.screen != null
        || mc.getOverlay() != null
        || !mc.isWindowActive()
        || mc.isPaused()) {
      previous = 0;
      return;
    }
    if (previous != 0 && count < FRAMES.length) FRAMES[count++] = (now - previous) / 1_000_000.0;
    previous = now;
  }

  private static void save(Minecraft mc) {
    double[] samples = Arrays.copyOf(FRAMES, count);
    double total = Arrays.stream(samples).sum();
    Arrays.sort(samples);
    String label =
        System.getProperty("nvvisionbridge.scenario", "unnamed").replaceAll("[^a-zA-Z0-9_-]", "_");
    String report =
        String.format(
            Locale.ROOT,
            "scenario=%s\n"
                + "valid=%s\n"
                + "frames=%d\n"
                + "sampledSeconds=%.3f\n"
                + "averageFps=%.3f\n"
                + "p95Ms=%.3f\n"
                + "p99Ms=%.3f\n"
                + "truncated=%s\n"
                + "backend=%s\n"
                + "configuredFpsLimit=%d\n"
                + "vsync=%s\n"
                + "outputWidth=%d\n"
                + "outputHeight=%d\n"
                + "refreshRate=%d\n"
                + "temporalReady=%s\n",
            label,
            BridgeBenchmarkPolicy.valid(
                count,
                FRAMES.length,
                total,
                DURATION / 1_000_000.0,
                System.getProperty("nvvisionbridge.backend", "auto"),
                BridgeApi.snapshot().getOrDefault("backend", "unknown")),
            count,
            total / 1000,
            total > 0 ? count * 1000.0 / total : 0,
            percentile(samples, .95),
            percentile(samples, .99),
            count == FRAMES.length,
            BridgeApi.snapshot().getOrDefault("backend", "unknown"),
            mc.options.framerateLimit().get(),
            mc.options.enableVsync().get(),
            mc.getWindow().getWidth(),
            mc.getWindow().getHeight(),
            mc.getWindow().getRefreshRate(),
            BridgeApi.snapshot().getOrDefault("temporalReady", "false"));
    try {
      Path root = mc.gameDirectory.toPath().resolve("config/nvvisionboost/benchmarks");
      BridgeFiles.atomic(root.resolve(label + "-" + System.currentTimeMillis() + ".txt"), report);
      LogUtils.getLogger().info("[NVVision Benchmark] {}", report.replace('\n', ' '));
    } catch (Exception error) {
      LogUtils.getLogger().error("[NVVision Benchmark] Cannot save results", error);
    }
  }

  private static double percentile(double[] sorted, double fraction) {
    return sorted.length == 0 ? 0 : sorted[(int) Math.ceil(sorted.length * fraction) - 1];
  }
}
