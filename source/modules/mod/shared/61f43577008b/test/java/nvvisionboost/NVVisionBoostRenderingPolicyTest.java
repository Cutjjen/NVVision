package nvvisionboost;

/** Cenários de gargalo e estabilidade, sem contexto gráfico. */
final class NVVisionBoostRenderingPolicyTest {
  private static int checks;

  private static void check(boolean result, String name) {
    if (!result) throw new AssertionError(name);
    checks++;
  }

  static int run() {
    checks = 0;
    check(
        NVVisionBoostResolutionPolicy.targetFps(144, 260, true, 60) == 60,
        "meta respeita VSync de 60 Hz");
    check(
        NVVisionBoostResolutionPolicy.targetFps(144, 90, false, 144) == 90,
        "meta respeita limitador do jogo");
    check(
        NVVisionBoostResolutionPolicy.targetFps(360, 260, false, 60) == 360,
        "260 significa ilimitado no Minecraft");
    check(
        NVVisionBoostResolutionPolicy.targetFps(60, 260, true, 144) == 60,
        "meta do jogador não aumenta para frequência do monitor");
    check(
        NVVisionBoostResolutionPolicy.targetFps(20, 10, false, 0) == 10,
        "limite abaixo da meta mínima é respeitado");
    check(
        NVVisionBoostResolutionPolicy.targetFps(120, 260, true, 0) == 120,
        "monitor sem frequência informada não produz meta zero");
    var slowGpu = new NVVisionBoostResolutionPolicy.Sample(30, 24, 5, 35);
    var slowCpu = new NVVisionBoostResolutionPolicy.Sample(30, 6, 24, 35);
    check(slowGpu.gpuLikely(), "custo elevado de GPU reconhecido");
    check(!slowCpu.gpuLikely(), "gargalo de CPU não vira redução de pixels");
    check(!new NVVisionBoostResolutionPolicy.Sample(Double.NaN, 5, 4, 12).valid(), "NaN rejeitado");
    check(
        !new NVVisionBoostResolutionPolicy.Sample(12, 0, 4, 14).valid(),
        "tempo GPU zero rejeitado");
    check(
        !new NVVisionBoostResolutionPolicy.Sample(12, 5, -1, 14).valid(),
        "tempo CPU negativo rejeitado");

    var cpu = policy(100, 50);
    var overloaded = policy(100, 50);
    for (long now = 15_000; now <= 18_000; now += 1000)
      overloaded.observe(new NVVisionBoostResolutionPolicy.Sample(500, 450, 15, 520), now);
    check(overloaded.scale() == 92, "GPU extremamente lenta ainda pode iniciar redução segura");
    for (long now = 15_000; now < 40_000; now += 1000) cpu.observe(slowCpu, now);
    check(cpu.scale() == 100, "CPU baixa FPS sem reduzir resolução");
    var capped = policy(100, 50);
    capped.configure(100, 50, 144, 0);
    for (long now = 15_000; now < 40_000; now += 1000)
      capped.observe(new NVVisionBoostResolutionPolicy.Sample(16.67, 4, 3, 17), now);
    check(
        capped.scale() == 100, "VSync/limite de FPS não provoca perda de qualidade sem custo GPU");

    var resolution = policy(75, 50);
    for (long now = 15_000; now <= 18_000; now += 1000) resolution.observe(slowGpu, now);
    check(resolution.scale() == 67, "redução gradual respeita teto e oito pontos por passo");
    for (long now = 21_000; now <= 26_000; now += 1000)
      resolution.observe(new NVVisionBoostResolutionPolicy.Sample(18, 14, 4, 22), now);
    check(
        resolution.scale() == 67 && resolution.reason().contains("benefício"),
        "ganho observado é mantido");
    for (long now = 34_000; now <= 41_000; now += 1000)
      resolution.observe(new NVVisionBoostResolutionPolicy.Sample(16.6, 5, 3, 17), now);
    check(resolution.scale() == 71, "margem sustentada recupera qualidade");
    for (long now = 44_000; now <= 49_000; now += 1000)
      resolution.observe(new NVVisionBoostResolutionPolicy.Sample(24, 17, 4, 30), now);
    check(resolution.scale() == 67, "recuperação cara é revertida");

    var useless = policy(100, 50);
    for (long now = 15_000; now <= 18_000; now += 1000) useless.observe(slowGpu, now);
    check(useless.scale() == 92, "teste GPU iniciado");
    for (long now = 21_000; now <= 26_000; now += 1000) useless.observe(slowGpu, now);
    check(useless.scale() == 100, "custo fixo sem ganho restaura qualidade");
    for (long now = 34_000; now <= 50_000; now += 1000) useless.observe(slowGpu, now);
    check(useless.scale() == 100, "teste ineficaz não se repete durante cooldown");
    for (long now = 150_000; now <= 153_000; now += 1000) useless.observe(slowGpu, now);
    check(useless.scale() == 92, "teste pode ser repetido após mudança de cenário/cooldown");
    useless.suspend(154_000);
    check(useless.scale() == 100, "recarga interrompe teste sem aceitar amostras contaminadas");

    var floor = policy(71, 68);
    for (long now = 15_000; now <= 18_000; now += 1000) floor.observe(slowGpu, now);
    check(floor.scale() == 68, "piso é preservado com teto ímpar");
    var manual = policy(25, 50);
    for (long now = 15_000; now <= 40_000; now += 1000) manual.observe(slowGpu, now);
    check(manual.scale() == 25, "piso maior que escala manual não aumenta resolução");
    floor.configure(85, 50, 60, 19_000);
    check(floor.scale() == 85, "mudança manual redefine teto e cancela teste antigo");
    floor.observe(slowGpu, 20_000);
    check(floor.scale() == 85, "configuração nova tem aquecimento");

    var budget = new NVVisionBoostUpscaleBudget();
    for (long now = 30_000; now <= 32_000; now += 1000) budget.observe(4, 8, 16.6, 60, now);
    check(budget.mode() == 0, "filtro que excede orçamento volta para linear");
    budget.observe(.05, 5, 16.6, 60, 40_000);
    check(budget.mode() == 0, "filtro automático evita oscilação imediata");
    budget.observe(.05, 5, 16.6, 60, 62_000);
    check(budget.mode() == 1, "filtro barato recuperado com margem");
    budget.observe(.05, 5, 16.6, 60, 92_000);
    check(budget.mode() == 2, "qualidade bicúbica recuperada gradualmente");
    budget.observe(.05, 3, 35, 60, 93_000);
    check(budget.mode() == 1, "custo CPU evita filtro de maior trabalho");
    budget.observe(Double.NaN, 5, 16, 60, 94_000);
    check(budget.mode() == 1, "amostras inválidas não promovem o filtro");

    var frames = new NVVisionBoostFrameStatistics();
    frames.add(Double.NaN);
    frames.add(-1);
    frames.add(Double.POSITIVE_INFINITY);
    check(frames.count() == 0, "frametimes inválidos ignorados");
    for (int i = 0; i < 120; i++) frames.add(10);
    check(
        Math.abs(frames.meanMs() - 10) < .001 && frames.percentile95Ms() == 10,
        "média e P95 estáveis");
    for (int i = 0; i < 120; i++) frames.add(12);
    check(
        frames.count() == 120 && frames.percentile95Ms() == 12,
        "janela limitada substitui amostras antigas");
    frames.add(300);
    check(frames.meanMs() > 20, "stutter real de 300 ms entra na telemetria");
    frames.reset();
    check(
        frames.count() == 0 && frames.meanMs() == 0 && frames.percentile95Ms() == 0,
        "troca de mundo limpa estatísticas");
    return checks;
  }

  private static NVVisionBoostResolutionPolicy policy(int ceiling, int floor) {
    var policy = new NVVisionBoostResolutionPolicy();
    policy.configure(ceiling, floor, 60, 0);
    policy.reset(0);
    return policy;
  }
}
