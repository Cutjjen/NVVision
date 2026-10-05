package nvvisionboost;

import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.server.level.ParticleStatus;

/** Applies NV settings to real Minecraft 1.20.1 options immediately. */
public final class NVVisionBoostRenderController {
  private static long lastApplyMs;
  private static long lastAdaptMs;
  private static long manualOverrideUntilMs;
  private static int lowFpsSamples;
  private static int stableFpsSamples;
  private static long lastSignature = Long.MIN_VALUE;
  private static Options snapshotOptions;
  private static Snapshot snapshot;
  private static Object observedWorld;
  private static double fpsAverage;
  private static int sustainedLowSamples;
  private static int trialPreviousScale = -1, trialScale = -1, trialSamples;
  private static double trialBaseline, trialFpsSum;
  private static long scaleBlockedUntilMs;

  public static boolean adaptationAllowed() {
    return System.currentTimeMillis() >= manualOverrideUntilMs;
  }

  public static void resetWorldTracking() {
    observedWorld = null;
    fpsAverage = 0;
    sustainedLowSamples = lowFpsSamples = stableFpsSamples = 0;
    trialScale = trialPreviousScale = -1;
  }

  public static void pauseAdaptation(long durationMs) {
    manualOverrideUntilMs =
        Math.max(manualOverrideUntilMs, System.currentTimeMillis() + Math.max(0L, durationMs));
    trialScale = trialPreviousScale = -1;
    sustainedLowSamples = 0;
  }

<<<<<<< HEAD
  /** Called by the central monitor once per second, never every frame. */
=======
  /** Chamado uma vez por segundo pelo monitor central, nunca por frame. */
>>>>>>> origin/master
  public static void observePerformance(NVVisionBoostCore.Config config, int fps) {
    Minecraft mc = Minecraft.getInstance();
    if (mc == null
        || mc.level == null
        || mc.player == null
        || mc.screen != null
        || mc.getOverlay() != null
        || NVVisionBoostTextureOptimizer.isBusy()
        || NVVisionBoostShaderEngine.isPreparing()
        || config == null
        || !config.enabled
        || fps <= 0) {
      sustainedLowSamples = 0;
      lowFpsSamples = 0;
      return;
    }
    if (observedWorld != mc.level) {
      observedWorld = mc.level;
      fpsAverage = fps;
      trialScale = trialPreviousScale = -1;
      pauseAdaptation(15000L);
    }
    if (trialScale >= 0) {
      if (!config.autoOptimize
          || !config.dynamicResolution
          || !config.upscalingEnabled
          || config.renderScalePercent != trialScale) {
        trialScale = trialPreviousScale = -1;
        fpsAverage = fps;
        return;
      }
      trialSamples++;
      if (trialSamples > 3) trialFpsSum += fps; // descarta aquecimento/resize
      if (trialSamples >= 11) {
        double result = trialFpsSum / 8.0;
        if (result < trialBaseline * 0.90) {
          config.renderScalePercent = trialPreviousScale;
          scaleBlockedUntilMs = System.currentTimeMillis() + 120000L;
          pauseAdaptation(15000L);
          apply(config, true);
          NVVisionBoostNativeRenderer.invalidate();
          NVVisionBoostCore.saveConfig();
          NVVisionBoostCore.log(
              "Escala automática revertida: FPS médio "
                  + Math.round(trialBaseline)
                  + " -> "
                  + Math.round(result));
        }
        trialScale = trialPreviousScale = -1;
        fpsAverage = result;
      }
      return;
    }
    fpsAverage = fpsAverage == 0 ? fps : fpsAverage * 0.8 + fps * 0.2;
    double threshold = NVVisionBoostFrameTiming.performanceTarget(config) * 0.80;
    sustainedLowSamples =
        fps < threshold && fpsAverage < threshold ? Math.min(8, sustainedLowSamples + 1) : 0;
  }

  private NVVisionBoostRenderController() {}

  public static void tick(NVVisionBoostCore.Config config) {
    if (config == null) return;
    long now = System.currentTimeMillis();
    if (now - lastApplyMs < 350L) return;
    long signature = signature(config);
    if (signature != lastSignature) apply(config, true);
    lastApplyMs = now;
  }

  /** Immediate application used by every UI mutation. */
  public static void applyNow(NVVisionBoostCore.Config config) {
    pauseAdaptation(15000L);
    lowFpsSamples = 0;
    stableFpsSamples = 0;
    apply(config, false);
  }

  public static void adapt(NVVisionBoostCore.Config config, int fps) {
    if (config == null || !config.enabled || !config.autoOptimize || fps <= 0) return;
    Minecraft mc = Minecraft.getInstance();
    if (mc == null
        || mc.level == null
        || mc.player == null
        || mc.screen != null
        || mc.getOverlay() != null
        || NVVisionBoostTextureOptimizer.isBusy()
        || NVVisionBoostShaderEngine.isPreparing()
        || trialScale >= 0) return;
    if (System.currentTimeMillis() < manualOverrideUntilMs) return;
    if (config.gpuAwareResolution
        && config.dynamicResolution
        && config.upscalingEnabled
        && config.gpuTiming
        && NVVisionBoostFrameTiming.gpuLikely()
        && NVVisionBoostFrameTiming.effectiveScale(config)
            > Math.min(config.renderScalePercent, config.dynamicMinScalePercent)
        && NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()) return;

    long now = System.currentTimeMillis();
    long cooldown = Math.max(30000L, config.adaptationCooldownSeconds * 1000L);
    if (now - lastAdaptMs < cooldown) return;

    int target = NVVisionBoostFrameTiming.performanceTarget(config);
    boolean low = sustainedLowSamples >= 8 && fps < target * 0.80 && fpsAverage < target * 0.80;
    boolean stable = fps >= target + Math.max(5, target / 10);

    if (low) {
      lowFpsSamples++;
      stableFpsSamples = 0;
    } else if (stable) {
      stableFpsSamples++;
      lowFpsSamples = 0;
    } else {
      lowFpsSamples = 0;
      stableFpsSamples = Math.max(0, stableFpsSamples - 1);
      return;
    }

    if (lowFpsSamples >= 2) {
      boolean changed = false;
      String reason = "";
<<<<<<< HEAD
      // The GPU controller owns scale; preserve distance when pixel cost is the likely bottleneck.
=======
      // O controlador GPU decide escala; preserve distância quando pixels são o provável gargalo.
>>>>>>> origin/master
      if (config.adaptiveRenderDistance
          && !(config.gpuAwareResolution
              && config.dynamicResolution
              && config.upscalingEnabled
              && NVVisionBoostFrameTiming.gpuLikely()
              && NVVisionBoostFrameTiming.effectiveScale(config) > config.dynamicMinScalePercent)
          && config.renderDistance > config.minRenderDistance
          && NVVisionBoostDistantHorizonsCompatibility.allowsAutomaticDistanceChanges()) {
        config.renderDistance--;
        changed = true;
        reason = "render distance";
      } else if (config.dynamicResolution
          && !config.gpuAwareResolution
          && config.upscalingEnabled
          && config.renderScalePercent > 50
          && NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()
          && now >= scaleBlockedUntilMs) {
        trialPreviousScale = config.renderScalePercent;
        config.renderScalePercent = nextLowerScale(config.renderScalePercent);
        trialScale = config.renderScalePercent;
        trialBaseline = fpsAverage > 0 ? fpsAverage : fps;
        trialFpsSum = 0;
        trialSamples = 0;
        changed = true;
        reason = "internal scale";
      } else if (config.animationOptimization && config.animationLevel > 0) {
        config.animationLevel--;
        changed = true;
        reason = "animation level";
      } else if (config.transparencyOptimization && config.transparencyLevel > 0) {
        config.transparencyLevel--;
        changed = true;
        reason = "transparency level";
      }
      if (changed) {
        apply(config, true);
        NVVisionBoostCore.saveConfig();
        lastAdaptMs = now;
        lowFpsSamples = 0;
        sustainedLowSamples = 0;
        manualOverrideUntilMs = Math.max(manualOverrideUntilMs, now + 30000L);
        NVVisionBoostCore.log("adaptive: FPS=" + fps + " -> " + reason);
      }
    }

    if (stableFpsSamples >= 3) {
      lastAdaptMs = now;
      stableFpsSamples = 0;
    }
  }

  public static void restorePlayerOptions() {
    if (snapshotOptions != null && snapshot != null) {
      try {
        snapshot.restore(snapshotOptions);
      } catch (Throwable t) {
        NVVisionBoostCore.log("restore options: " + t);
      }
    }
    manualOverrideUntilMs = 0L;
    lastSignature = Long.MIN_VALUE;
    snapshot = null;
    snapshotOptions = null;
  }

  public static void apply(NVVisionBoostCore.Config config, int ignoredTier) {
    apply(config, false);
  }

  private static void apply(NVVisionBoostCore.Config config, boolean automaticReapply) {
    try {
      Minecraft minecraft = Minecraft.getInstance();
      if (minecraft == null || minecraft.options == null) return;
      Options options = minecraft.options;

      if (config == null || !config.enabled) {
        if (options == snapshotOptions && snapshot != null) snapshot.restore(options);
        snapshot = null;
        snapshotOptions = null;
        lastSignature = signature(config);
        return;
      }
      if (options != snapshotOptions || snapshot == null) {
        snapshotOptions = options;
        snapshot = Snapshot.capture(options);
      }

      config.normalize();
      set(options.renderDistance(), effectiveRenderDistance(config));

      if (NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
<<<<<<< HEAD
        // Do not reduce machine simulation distance because of resolution scale.
=======
        // Não reduza o alcance de simulação das máquinas por causa da escala.
>>>>>>> origin/master
        snapshot.restoreSimulationOnly(options);
      } else if (config.simulationOptimization) {
        int sim = NVVisionBoostVisualPolicy.simulationDistance(config, snapshot.simulationDistance);
        set(options.simulationDistance(), sim);
      } else {
        snapshot.restoreSimulationOnly(options);
      }

      if (config.entityOptimization
          && !NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
        set(
            options.entityDistanceScaling(),
            clamp(config.entityDistancePercent / 100.0D, 0.5D, 1.0D));
      } else {
        snapshot.restoreEntityDistance(options);
      }

      // Each switch is applied independently. The old implementation tied
      // several options to animationOptimization, so changing a single
      // switch often appeared to do nothing.
      if (config.animationOptimization) {
        applyAnimationLevel(options, config);
      } else {
        snapshot.restoreAnimation(options);
        if (config.reduceParticles) set(options.particles(), ParticleStatus.DECREASED);
        if (config.disableClouds) set(options.cloudStatus(), CloudStatus.OFF);
        if (config.disableEntityShadows) set(options.entityShadows(), false);
      }

      set(
          options.ambientOcclusion(),
          config.transparencyOptimization && config.transparencyLevel <= 1
              ? false
              : snapshot.ambientOcclusion);

      if (config.reduceShaderEffects) {
        set(options.fovEffectScale(), Math.min(snapshot.fovEffectScale, 0.50D));
        set(options.darknessEffectScale(), Math.min(snapshot.darknessEffectScale, 0.50D));
      } else {
        set(options.fovEffectScale(), snapshot.fovEffectScale);
        set(options.darknessEffectScale(), snapshot.darknessEffectScale);
      }
      set(
          options.screenEffectScale(),
          NVVisionBoostVisualPolicy.screenEffectScale(config, snapshot.screenEffectScale));

      if (config.reduceViewBob) set(options.bobView(), false);
      else snapshot.restoreViewBob(options);

      // Native shader renderer state belongs to the shader engine. Never
      // overwrite it from the performance controller.
      lastSignature = signature(config);
    } catch (Throwable t) {
      NVVisionBoostCore.log("render controller: " + t);
    }
  }

  private static void applyAnimationLevel(Options options, NVVisionBoostCore.Config config) {
    ParticleStatus particles =
        config.reduceParticles
            ? (config.animationLevel == 0 ? ParticleStatus.MINIMAL : ParticleStatus.DECREASED)
            : snapshot.particles;
    CloudStatus clouds;
    switch (config.animationLevel) {
      case 0 -> clouds = config.disableClouds ? CloudStatus.OFF : CloudStatus.FAST;
      case 1 -> clouds = config.disableClouds ? CloudStatus.OFF : CloudStatus.FAST;
      case 2 -> clouds = config.disableClouds ? CloudStatus.OFF : CloudStatus.FAST;
      default -> clouds = config.disableClouds ? CloudStatus.OFF : snapshot.clouds;
    }
    set(options.particles(), particles);
    set(options.cloudStatus(), clouds);
    if (config.disableEntityShadows) set(options.entityShadows(), false);
    else snapshot.restoreEntityShadows(options);
  }

  private static int effectiveRenderDistance(NVVisionBoostCore.Config config) {
    return clamp(config.renderDistance, config.minRenderDistance, config.maxRenderDistance);
  }

  private static int nextLowerScale(int value) {
    int[] values = {100, 90, 85, 80, 75, 67, 60, 50};
    for (int i = 0; i < values.length; i++) {
      if (value >= values[i]) return i + 1 < values.length ? values[i + 1] : values[i];
    }
    return 50;
  }

  private static long signature(NVVisionBoostCore.Config c) {
    if (c == null) return 0L;
    long h = 1125899906842597L;
    h = h * 31 + (c.enabled ? 1 : 0);
    h = h * 31 + (NVVisionBoostCreateCompatibility.protectsMachineRendering() ? 1 : 0);
    h = h * 31 + (c.autoOptimize ? 1 : 0);
    h = h * 31 + (c.adaptiveRenderDistance ? 1 : 0);
    h = h * 31 + (c.entityOptimization ? 1 : 0);
    h = h * 31 + (c.animationOptimization ? 1 : 0);
    h = h * 31 + (c.transparencyOptimization ? 1 : 0);
    h = h * 31 + (c.dynamicResolution ? 1 : 0);
    h = h * 31 + (c.upscalingEnabled ? 1 : 0);
    h = h * 31 + (c.simulationOptimization ? 1 : 0);
    h = h * 31 + c.simulationDistance;
    h = h * 31 + (c.reduceParticles ? 1 : 0);
    h = h * 31 + (c.disableClouds ? 1 : 0);
    h = h * 31 + (c.disableEntityShadows ? 1 : 0);
    h = h * 31 + (c.reduceViewBob ? 1 : 0);
    h = h * 31 + (c.reduceShaderEffects ? 1 : 0);
    h = h * 31 + c.renderDistance;
    h = h * 31 + c.minRenderDistance;
    h = h * 31 + c.maxRenderDistance;
    h = h * 31 + c.entityDistancePercent;
    h = h * 31 + c.renderScalePercent;
    h = h * 31 + c.upscalerSharpnessPercent;
    h = h * 31 + c.targetFps;
    h = h * 31 + c.animationLevel;
    h = h * 31 + c.transparencyLevel;
    return h;
  }

  private static <T> void set(OptionInstance<T> option, T value) {
    if (option != null && value != null && !value.equals(option.get())) option.set(value);
  }

  private static int clamp(int value, int min, int max) {
    return Math.max(min, Math.min(max, value));
  }

  private static double clamp(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }

  private static final class Snapshot {
    final int renderDistance;
    final int simulationDistance;
    final double entityDistanceScaling;
    final ParticleStatus particles;
    final CloudStatus clouds;
    final boolean entityShadows;
    final boolean ambientOcclusion;
    final double screenEffectScale;
    final double fovEffectScale;
    final double darknessEffectScale;
    final boolean bobView;

    private Snapshot(
        int renderDistance,
        int simulationDistance,
        double entityDistanceScaling,
        ParticleStatus particles,
        CloudStatus clouds,
        boolean entityShadows,
        boolean ambientOcclusion,
        double screenEffectScale,
        double fovEffectScale,
        double darknessEffectScale,
        boolean bobView) {
      this.renderDistance = renderDistance;
      this.simulationDistance = simulationDistance;
      this.entityDistanceScaling = entityDistanceScaling;
      this.particles = particles;
      this.clouds = clouds;
      this.entityShadows = entityShadows;
      this.ambientOcclusion = ambientOcclusion;
      this.screenEffectScale = screenEffectScale;
      this.fovEffectScale = fovEffectScale;
      this.darknessEffectScale = darknessEffectScale;
      this.bobView = bobView;
    }

    static Snapshot capture(Options o) {
      return new Snapshot(
          o.renderDistance().get(),
          o.simulationDistance().get(),
          o.entityDistanceScaling().get(),
          o.particles().get(),
          o.cloudStatus().get(),
          o.entityShadows().get(),
          o.ambientOcclusion().get(),
          o.screenEffectScale().get(),
          o.fovEffectScale().get(),
          o.darknessEffectScale().get(),
          o.bobView().get());
    }

    void restore(Options o) {
      set(o.renderDistance(), renderDistance);
      set(o.simulationDistance(), simulationDistance);
      set(o.entityDistanceScaling(), entityDistanceScaling);
      restoreAnimation(o);
      restoreTransparency(o);
      restoreShaderEffects(o);
      restoreViewBob(o);
    }

    void restoreSimulationOnly(Options o) {
      set(o.simulationDistance(), simulationDistance);
    }

    void restoreEntityDistance(Options o) {
      set(o.entityDistanceScaling(), entityDistanceScaling);
    }

    void restoreEntityShadows(Options o) {
      set(o.entityShadows(), entityShadows);
    }

    void restoreAnimation(Options o) {
      set(o.particles(), particles);
      set(o.cloudStatus(), clouds);
      set(o.entityShadows(), entityShadows);
    }

    void restoreTransparency(Options o) {
      set(o.ambientOcclusion(), ambientOcclusion);
      set(o.screenEffectScale(), screenEffectScale);
    }

    void restoreShaderEffects(Options o) {
      set(o.screenEffectScale(), screenEffectScale);
      set(o.fovEffectScale(), fovEffectScale);
      set(o.darknessEffectScale(), darknessEffectScale);
    }

    void restoreViewBob(Options o) {
      set(o.bobView(), bobView);
    }
  }
}
