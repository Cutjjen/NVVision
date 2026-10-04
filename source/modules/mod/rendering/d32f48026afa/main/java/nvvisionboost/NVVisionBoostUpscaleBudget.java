package nvvisionboost;

/** Seleciona custo do filtro automático; os modos manuais não são alterados. */
final class NVVisionBoostUpscaleBudget {
  private int mode = 1, expensive;
  private long nextSample, nextUpgrade;

  int mode() {
    return mode;
  }

  int observe(double filterMs, double gpuMs, double frameMs, int targetFps, long now) {
    if (!Double.isFinite(filterMs)
        || !Double.isFinite(gpuMs)
        || !Double.isFinite(frameMs)
        || filterMs < 0
        || gpuMs <= 0
        || frameMs <= 0
        || now < nextSample) return mode;
    nextSample = now + 1_000;
    double frameBudget = 1000.0 / Math.max(1, targetFps);
    double allowed = Math.max(.25, Math.min(1.5, frameBudget * .08));
    boolean cpuLimited = frameMs > frameBudget * 1.12 && gpuMs < frameMs * .50;
    expensive = filterMs > allowed ? expensive + 1 : 0;
    if (cpuLimited || expensive >= 3) {
      mode = Math.max(0, mode - 1);
      expensive = 0;
      nextUpgrade = now + 30_000;
    } else if (now >= nextUpgrade
        && mode < 2
        && filterMs < allowed * .35
        && gpuMs < frameBudget * .70
        && frameMs <= frameBudget * 1.03) {
      mode++;
      nextUpgrade = now + 30_000;
    }
    return mode;
  }

  void reset() {
    mode = 1;
    expensive = 0;
    nextSample = 0;
    nextUpgrade = 30_000;
  }
}
