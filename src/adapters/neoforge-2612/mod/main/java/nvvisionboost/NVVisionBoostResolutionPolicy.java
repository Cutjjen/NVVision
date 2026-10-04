/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostResolutionPolicy.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/**
 * Controlador puro: orçamento de pixels, histerese, teste de benefício e recuperação de qualidade.
 */
final class NVVisionBoostResolutionPolicy {
  record Sample(double frameMs, double gpuMs, double cpuWorldMs, double p95Ms) {
    boolean valid() {
      return Double.isFinite(frameMs)
          && Double.isFinite(gpuMs)
          && Double.isFinite(cpuWorldMs)
          && Double.isFinite(p95Ms)
          && frameMs >= .1
          && frameMs <= 1000
          && gpuMs > 0
          && gpuMs <= 1000
          && cpuWorldMs >= 0
          && p95Ms >= .1;
    }

    boolean gpuLikely() {
      return valid() && gpuMs >= frameMs * .62 && gpuMs >= cpuWorldMs * .8;
    }
  }

  private int scale = 100, ceiling = 100, minimum = 50, target = 60;
  private int low, headroom, previous = -1, trialCount;
  private double baselineFrame, baselineGpu, baselineP95, sumFrame, sumGpu, sumP95;
  private long nextDecision, trialStart, lowerBlocked, raiseBlocked;
  private boolean lowering;
  private String reason = "Aguardando medições GPU.";

  static int targetFps(int requested, int gameLimit, boolean vsync, int refreshRate) {
    int target = Math.max(20, Math.min(360, requested));
    // Minecraft 1.20.1 trata 260 como ilimitado.
    if (gameLimit > 0 && gameLimit < 260) target = Math.min(target, gameLimit);
    if (vsync && refreshRate > 0) target = Math.min(target, refreshRate);
    return Math.max(1, target);
  }

  void configure(int requestedCeiling, int requestedMinimum, int fps, long now) {
    int top = Math.max(10, Math.min(100, requestedCeiling));
    int bottom = Math.max(10, Math.min(top, requestedMinimum));
    int goal = Math.max(1, Math.min(360, fps));
    if (ceiling == top && minimum == bottom && target == goal) return;
    ceiling = top;
    minimum = bottom;
    target = goal;
    scale = top;
    low = headroom = 0;
    previous = -1;
    lowerBlocked = raiseBlocked = 0;
    nextDecision = now + 15_000;
    reason = "Aquecimento após mudança de configuração.";
  }

  void reset(long now) {
    scale = ceiling;
    low = headroom = 0;
    previous = -1;
    lowerBlocked = raiseBlocked = 0;
    nextDecision = now + 15_000;
    reason = "Aquecimento do mundo/pipeline.";
  }

  void suspend(long now) {
    low = headroom = 0;
    // Uma recarga torna a comparação do teste inválida; não penaliza a nova cena.
    if (previous >= 0) scale = previous;
    previous = -1;
    nextDecision = Math.max(nextDecision, now + 3_000);
  }

  int scale() {
    return scale;
  }

  String reason() {
    return reason;
  }

  int observe(Sample sample, long now) {
    if (!sample.valid()) {
      reason = "GPU sem amostra válida; escala preservada.";
      return scale;
    }
    double budget = 1000.0 / target;
    if (previous >= 0) {
      if (now - trialStart < 3_000) return scale;
      sumFrame += sample.frameMs();
      sumGpu += sample.gpuMs();
      sumP95 += sample.p95Ms();
      if (++trialCount < 6) return scale;
      double frame = sumFrame / trialCount, gpu = sumGpu / trialCount, p95 = sumP95 / trialCount;
      boolean reject =
          lowering
              ? (frame >= baselineFrame * .97 && gpu >= baselineGpu * .97)
                  || frame > baselineFrame * 1.08
                  || p95 > baselineP95 * 1.20
              : frame > Math.max(budget * 1.08, baselineFrame * 1.12);
      if (reject) {
        scale = previous;
        if (lowering) lowerBlocked = now + 120_000;
        else raiseBlocked = now + 60_000;
        reason = "Teste revertido: ganho insuficiente ou piora da fluidez.";
      } else
        reason =
            lowering ? "Redução com benefício observado." : "Qualidade recuperada com margem GPU.";
      previous = -1;
      nextDecision = now + 8_000;
      low = headroom = 0;
      return scale;
    }
    if (now < nextDecision) return scale;
    nextDecision = now + 1_000;
    boolean slow = sample.frameMs() > budget * 1.12;
    boolean gpuBound = sample.gpuLikely() && sample.gpuMs() > budget * .82;
    low = slow && gpuBound ? Math.min(4, low + 1) : 0;
    boolean room = sample.gpuMs() < budget * .55 && sample.frameMs() <= budget * 1.03;
    headroom = room ? Math.min(8, headroom + 1) : 0;
    if (low >= 4 && scale > minimum && now >= lowerBlocked) {
      double desiredGpu = Math.min(budget * .80, sample.gpuMs() * budget / sample.frameMs());
      int wanted = (int) Math.floor(scale * Math.sqrt(desiredGpu / sample.gpuMs()));
      wanted = Math.max(minimum, Math.max(scale - 8, wanted));
      wanted = Math.max(Math.max(minimum, scale - 8), (wanted / 2) * 2);
      if (wanted < scale) startTrial(wanted, true, sample, now);
    } else if (headroom >= 8 && scale < ceiling && now >= raiseBlocked) {
      startTrial(Math.min(ceiling, scale + 4), false, sample, now);
    } else {
      reason =
          slow && !gpuBound
              ? "Limite de CPU, sincronização ou custo fixo; escala preservada."
              : "Escala estável dentro dos limites escolhidos.";
    }
    return scale;
  }

  private void startTrial(int wanted, boolean decrease, Sample sample, long now) {
    previous = scale;
    scale = wanted;
    lowering = decrease;
    baselineFrame = sample.frameMs();
    baselineGpu = sample.gpuMs();
    baselineP95 = sample.p95Ms();
    sumFrame = sumGpu = sumP95 = 0;
    trialCount = 0;
    trialStart = now;
    low = headroom = 0;
    reason = decrease ? "Testando redução do custo GPU." : "Testando recuperação de qualidade.";
  }
}

