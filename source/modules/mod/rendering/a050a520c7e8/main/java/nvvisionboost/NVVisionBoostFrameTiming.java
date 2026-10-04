package nvvisionboost;

import java.util.Locale;
import net.minecraft.client.Minecraft;

/** Telemetria na thread de renderização e escala temporária; não regrava preferências por frame. */
public final class NVVisionBoostFrameTiming {
  private static final NVVisionBoostGpuTimer GPU = new NVVisionBoostGpuTimer();
  private static final NVVisionBoostFrameStatistics FRAMES = new NVVisionBoostFrameStatistics();
  private static final NVVisionBoostResolutionPolicy RESOLUTION =
      new NVVisionBoostResolutionPolicy();
  private static Object world;
  private static long previousFrame, nextPolicy;
  private static boolean timingEnabled;
  private static boolean wasAdaptive;
  private static long nextStatus;
  private static String cachedStatus = "Aguardando medições.";
  private static int budgetTarget = 60, requestedTarget;
  private static long nextBudget;
  private static long nextPipelineCheck;
  private static Object observedPipeline;

  private NVVisionBoostFrameTiming() {}

  public static void frameStart() {
    GPU.end(); // Fecha uma coleta interrompida por exceção de outro renderer.
    var mc = Minecraft.getInstance();
    var config = NVVisionBoostCore.cfg;
    long now = System.nanoTime(), milliseconds = now / 1_000_000;
    if (mc == null || mc.level == null || config == null || !config.enabled) {
      if (world != null || timingEnabled) {
        GPU.close();
        FRAMES.reset();
        RESOLUTION.reset(milliseconds);
        NVVisionBoostSpatialUpscaler.close();
      }
      world = null;
      previousFrame = 0;
      timingEnabled = false;
      wasAdaptive = false;
      observedPipeline = null;
      nextPipelineCheck = 0;
      return;
    }
    RESOLUTION.configure(
        config.renderScalePercent,
        config.dynamicMinScalePercent,
        performanceTarget(config),
        milliseconds);
    boolean adaptiveNow =
        adaptive(config) && NVVisionBoostNativeRenderer.framebufferScalingAllowed();
    if (adaptiveNow != wasAdaptive) {
      RESOLUTION.reset(milliseconds);
      wasAdaptive = adaptiveNow;
    }
    if (world != mc.level) {
      world = mc.level;
      GPU.invalidate();
      FRAMES.reset();
      previousFrame = 0;
      RESOLUTION.reset(milliseconds);
      observedPipeline = null;
      nextPipelineCheck = 0;
    }
    if (now >= nextPipelineCheck) {
      nextPipelineCheck = now + 1_000_000_000L;
      try {
        Object pipeline = NVVisionBoostCompatibility.shaderPipeline();
        if (pipeline != observedPipeline) {
          observedPipeline = pipeline;
          GPU.invalidate();
          FRAMES.reset();
          RESOLUTION.reset(milliseconds);
          previousFrame = 0;
          NVVisionBoostCore.log("Pipeline Iris alterado; recalibrando resolução dinâmica.");
        }
      } catch (ReflectiveOperationException | RuntimeException error) {
        RESOLUTION.suspend(milliseconds);
      }
    }
    if (config.gpuTiming != timingEnabled) {
      GPU.close();
      timingEnabled = config.gpuTiming;
    }
    boolean gameplay = mc.isWindowActive() && mc.gui.screen() == null && mc.gui.overlay() == null;
    if (gameplay && previousFrame != 0) FRAMES.add((now - previousFrame) / 1_000_000.0);
    previousFrame = gameplay ? now : 0;
    if (timingEnabled) GPU.poll();
    if (!gameplay
        || !adaptive(config)
        || !NVVisionBoostNativeRenderer.framebufferScalingAllowed()
        || !NVVisionBoostRenderController.adaptationAllowed()
        || NVVisionBoostTextureOptimizer.isBusy()
        || NVVisionBoostShaderEngine.isPreparing()
        || NVVisionBoostMemoryMonitor.underPressure()
        || mc.gameRenderer.currentPostEffect() != null
        || !NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()
        || NVVisionBoostNativeRenderer.isProcessingBlocked()) {
      RESOLUTION.suspend(milliseconds);
      return;
    }
    if (milliseconds < nextPolicy) return;
    nextPolicy = milliseconds + 1_000;
    if (!gpuSampleFresh() || FRAMES.count() < 30) return;
    int previous = RESOLUTION.scale();
    int current =
        RESOLUTION.observe(
            new NVVisionBoostResolutionPolicy.Sample(
                frameMs(), GPU.gpuMs(), GPU.cpuMs(), FRAMES.percentile95Ms()),
            milliseconds);
    if (previous != current) {
      NVVisionBoostCore.log(
          "Escala GPU: " + previous + "% -> " + current + "%; " + RESOLUTION.reason());
    }
  }

  private static boolean adaptive(NVVisionBoostCore.Config config) {
    return config.enabled
        && config.autoOptimize
        && config.upscalingEnabled
        && config.dynamicResolution
        && config.gpuAwareResolution
        && config.gpuTiming;
  }

  public static int performanceTarget(NVVisionBoostCore.Config config) {
    if (config == null) return 60;
    long now = System.nanoTime();
    if (now < nextBudget && requestedTarget == config.targetFps) return budgetTarget;
    requestedTarget = config.targetFps;
    nextBudget = now + 1_000_000_000L;
    var mc = Minecraft.getInstance();
    int limit = 260, refresh = 0;
    boolean vsync = false;
    if (mc != null && mc.options != null) {
      limit = mc.getFramerateLimitTracker().getFramerateLimit();
      vsync = mc.options.enableVsync().get();
      if (vsync && mc.getWindow() != null) refresh = mc.getWindow().getRefreshRate();
    }
    budgetTarget = NVVisionBoostResolutionPolicy.targetFps(requestedTarget, limit, vsync, refresh);
    return budgetTarget;
  }

  public static int effectiveScale(NVVisionBoostCore.Config config) {
    if (config == null || !NVVisionBoostNativeRenderer.framebufferScalingAllowed()) return 100;
    return adaptive(config)
            && world != null
            && NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()
        ? Math.min(config.renderScalePercent, RESOLUTION.scale())
        : config.renderScalePercent;
  }

  public static void beginWorld() {
    if (timingEnabled && world != null && Minecraft.getInstance().isWindowActive()) GPU.begin();
  }

  public static void markUpscale() {
    GPU.markUpscale();
  }

  public static void endWorld() {
    GPU.end();
  }

  public static void invalidateWorld() {
    GPU.invalidate();
  }

  public static double frameMs() {
    return FRAMES.meanMs();
  }

  public static double p95Ms() {
    return FRAMES.percentile95Ms();
  }

  public static double gpuMs() {
    return GPU.gpuMs();
  }

  public static double upscaleMs() {
    return GPU.upscaleMs();
  }

  public static boolean gpuSampleFresh() {
    return GPU.samples() >= 16 && System.nanoTime() - GPU.lastSampleNanos() < 2_000_000_000L;
  }

  public static boolean gpuLikely() {
    return gpuSampleFresh()
        && new NVVisionBoostResolutionPolicy.Sample(frameMs(), gpuMs(), GPU.cpuMs(), p95Ms())
            .gpuLikely();
  }

  public static String status() {
    long now = System.nanoTime();
    if (now < nextStatus) return cachedStatus;
    nextStatus = now + 500_000_000L;
    cachedStatus =
        String.format(
            Locale.ROOT,
            "Frame %.2f ms | P95 %.2f ms | GPU mundo %.2f ms | upscale %.2f ms",
            frameMs(),
            p95Ms(),
            gpuMs(),
            upscaleMs());
    return cachedStatus;
  }

  public static String resolutionStatus() {
    var config = NVVisionBoostCore.cfg;
    if (world == null || config == null || !config.enabled)
      return "Resolução nativa; telemetria inativa.";
    int actual =
        !config.upscalingEnabled || !NVVisionBoostCreateCompatibility.allowsFramebufferScaling()
            ? 100
            : effectiveScale(config);
    String reason =
        adaptive(config) ? RESOLUTION.reason() : "Escala manual; adaptação GPU inativa.";
    if (!NVVisionBoostNativeRenderer.framebufferScalingAllowed())
      reason = NVVisionBoostNativeRenderer.scalingRestriction();
    if (!NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges())
      reason = "Adaptação suspensa por compatibilidade.";
    return actual + "% | meta " + budgetTarget + " FPS | " + reason;
  }
}
