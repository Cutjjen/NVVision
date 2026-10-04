/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Controles paginados: cada opção explica seu custo visual e sua proteção. */
public final class NVVisionBoostPerformanceScreen extends Screen {
  private final Screen parent;
  private final List<Control> controls = new ArrayList<>();
  private int page;
  private int category;
  private String pageStatus = "";

  private record Control(int category, Supplier<String> label, Runnable action, String help) {}

  public NVVisionBoostPerformanceScreen(Screen parent) {
    super(Component.literal("Ajustes adicionais de desempenho"));
    this.parent = parent;
  }

  private NVVisionBoostCore.Config cfg() {
    return NVVisionBoostCore.cfg;
  }

  private String on(boolean enabled) {
    return enabled ? NVVisionBoostUi.text("Ligado") : NVVisionBoostUi.text("Desligado");
  }

  private void add(int category, Supplier<String> label, Runnable action, String help) {
    controls.add(new Control(category, label, action, help));
  }

  @Override
  protected void init() {
    clearWidgets();
    NVVisionBoostUi.languages(width, this::init, b -> addRenderableWidget(b));
    controls.clear();
    add(
        0,
        () -> NVVisionBoostUi.text("Preset de imagem: ") + NVVisionBoostImageQuality.label(cfg()),
        () -> NVVisionBoostImageQuality.cycle(cfg()),
        NVVisionBoostUi.text("Nativo 100%, Qualidade 85%, Balanceado 75% ou Desempenho 67%. Usa FSR 1")
            + NVVisionBoostUi.text(" espacial com fallback bicúbico. A interface mantém a resolução nativa.")
            + NVVisionBoostUi.text(" Define o piso de qualidade sem ativar a adaptação automática.")
            + NVVisionBoostUi.text(" Sombras, reflexos e TAA permanecem nas opções próprias do shaderpack no Iris."));
    add(
        2,
        () -> NVVisionBoostUi.text("Create: ") + NVVisionBoostCreatePresets.modeName(cfg().createPerformancePreset),
        () -> cfg().createPerformancePreset = (cfg().createPerformancePreset + 1) % 4,
        NVVisionBoostUi.text("Detecta Create e complementa Create Better FPS. Reduz partículas de ventiladores e")
            + NVVisionBoostUi.text(" distância dos itens em filtros. Original restaura os valores anteriores,")
            + NVVisionBoostUi.text(" preservando alterações posteriores feitas na configuração do Create. Não muda")
            + NVVisionBoostUi.text(" máquinas ou ticks. Detectados: ")
            + NVVisionBoostCreatePresets.integrations());
    add(
        0,
        () -> NVVisionBoostUi.text("Filtro: ") + NVVisionBoostSpatialUpscaler.modeName(cfg().upscalerMode),
        () -> cfg().upscalerMode = (cfg().upscalerMode + 1) % 5,
        NVVisionBoostUi.text("Linear preserva o caminho anterior. Nitidez usa 5 amostras; bicúbico usa reconstrução")
            + NVVisionBoostUi.text(" Catmull-Rom com nitidez. Automático reduz custo; FSR 1 usa EASU e RCAS oficiais da")
            + NVVisionBoostUi.text(" AMD, também em GPUs NVIDIA/Intel com as extensões necessárias."));
    add(
        0,
        () -> NVVisionBoostUi.text("Nitidez espacial: ") + cfg().upscalerSharpnessPercent + "%",
        () ->
            cfg().upscalerSharpnessPercent =
                cycle(cfg().upscalerSharpnessPercent, 0, 20, 40, 55, 70, 85, 100),
        NVVisionBoostUi.text("Efeito real nos filtros com nitidez; limitado pelo contraste local para conter halos.")
            + NVVisionBoostUi.text(" Não tem efeito no modo Linear compatível ou em resolução nativa."));
    add(
        0,
        () -> NVVisionBoostUi.text("Resolução dinâmica por GPU: ") + on(cfg().gpuAwareResolution),
        () -> cfg().gpuAwareResolution = !cfg().gpuAwareResolution,
        NVVisionBoostUi.text("Requer otimização automática, resolução dinâmica, upscaling e medição GPU.")
            + NVVisionBoostUi.text(" Testa reduções sustentadas, reverte testes ruins e recupera qualidade com margem.")
            + NVVisionBoostUi.text(" Desligado usa o controlador anterior por FPS."));
    add(
        0,
        () -> NVVisionBoostUi.text("Piso da escala dinâmica: ") + cfg().dynamicMinScalePercent + "%",
        () ->
            cfg().dynamicMinScalePercent =
                cycle(cfg().dynamicMinScalePercent, 40, 50, 58, 66, 75, 85),
        NVVisionBoostUi.text("A escala interna escolhida na tela principal é o teto. O piso nunca supera esse teto.")
            + NVVisionBoostUi.text(" Mudanças automáticas não regravam a escala manual no arquivo."));
    add(
        0,
        () -> NVVisionBoostUi.text("Medição GPU assíncrona: ") + on(cfg().gpuTiming),
        () -> cfg().gpuTiming = !cfg().gpuTiming,
        NVVisionBoostUi.text("Timestamps OpenGL sem esperar pela GPU e sem ocupar queries dos outros mods.")
            + NVVisionBoostUi.text(" Necessária para a resolução dinâmica por GPU; não mede utilização em porcentagem."));
    add(
        1,
        () -> NVVisionBoostUi.text("FPS em segundo plano: ") + on(cfg().backgroundFpsLimit),
        () -> cfg().backgroundFpsLimit = !cfg().backgroundFpsLimit,
        NVVisionBoostUi.text("Limita FPS somente com a janela sem foco. Reduz uso de GPU/CPU em segundo plano."));
    add(
        1,
        () -> NVVisionBoostUi.text("Limite em segundo plano: ") + cfg().backgroundFps,
        () -> cfg().backgroundFps = cycle(cfg().backgroundFps, 15, 30, 60, 120),
        NVVisionBoostUi.text("Respeita também um limite menor definido pelo jogador ou por outro mod."));
    add(
        1,
        () -> NVVisionBoostUi.text("Respingos de chuva reduzidos: ") + on(cfg().reduceWeatherParticles),
        () -> cfg().reduceWeatherParticles = !cfg().reduceWeatherParticles,
        NVVisionBoostUi.text("Cria 25% dos respingos vanilla. Mantém clima, sons e partículas de outros efeitos."));
    add(
        1,
        () -> NVVisionBoostUi.text("Distância de blocos animados: ") + on(cfg().blockEntityDistanceLimit),
        () -> cfg().blockEntityDistanceLimit = !cfg().blockEntityDistanceLimit,
        NVVisionBoostUi.text("Limita desenho de blocos vanilla como baús e placas. Não altera ticks. Suspenso com")
            + NVVisionBoostUi.text(" Iris ou Create/Flywheel carregados."));
    add(
        1,
        () -> NVVisionBoostUi.text("Alcance de blocos animados: ") + cfg().blockEntityDistance + NVVisionBoostUi.text(" blocos"),
        () ->
            cfg().blockEntityDistance =
                cycle(cfg().blockEntityDistance, 16, 32, 48, 64, 96, 128, 256),
        NVVisionBoostUi.text("Pode ocultar detalhes distantes. Beacons e renderizadores que pedem desenho fora da tela")
            + NVVisionBoostUi.text(" são preservados."));
    add(
        1,
        () -> NVVisionBoostUi.text("Limitar distância de simulação: ") + on(cfg().simulationOptimization),
        () -> cfg().simulationOptimization = !cfg().simulationOptimization,
        NVVisionBoostUi.text("Opção independente da escala de imagem. Pode reduzir alcance de ticks no mundo local.")
            + NVVisionBoostUi.text(" Suspensa com Create/Flywheel."));
    add(
        1,
        () -> NVVisionBoostUi.text("Distância de simulação: ") + cfg().simulationDistance + " chunks",
        () -> cfg().simulationDistance = cycle(cfg().simulationDistance, 4, 6, 8, 10, 12, 16),
        NVVisionBoostUi.text("Nunca aumenta a distância original do jogador; o servidor mantém suas próprias regras."));
    add(
        1,
        () -> NVVisionBoostUi.text("Distância automática: ") + on(cfg().adaptiveRenderDistance),
        () -> cfg().adaptiveRenderDistance = !cfg().adaptiveRenderDistance,
        NVVisionBoostUi.text("Exige otimização automática e queda sustentada de FPS. Suspensa quando Distant Horizons")
            + NVVisionBoostUi.text(" está carregado."));
    add(
        2,
        () -> NVVisionBoostUi.text("Proteção de memória: ") + on(cfg().memoryGuard),
        () -> cfg().memoryGuard = !cfg().memoryGuard,
        NVVisionBoostUi.text("Pausa adaptação e preparo automático com heap acima de 85%. Não força coleta de lixo nem")
            + NVVisionBoostUi.text(" reserva VRAM."));
    List<Control> shown =
        controls.stream().filter(control -> control.category() == category).toList();
    int capacity = Math.max(1, (height - 148) / 27);
    int pages = Math.max(1, (shown.size() + capacity - 1) / capacity);
    page = Math.min(page, pages - 1);
    int buttonWidth = Math.max(80, Math.min(480, width - 32));
    int left = (width - buttonWidth) / 2;
    String[] groups = {NVVisionBoostUi.text("Imagem"), NVVisionBoostUi.text("Mundo"), NVVisionBoostUi.text("Integrações")};
    int groupWidth = (buttonWidth - 12) / 3;
    for (int i = 0; i < groups.length; i++) {
      final int nextCategory = i;
      var group =
          new NVVisionBoostOptionButton(
              left + i * (groupWidth + 6),
              36,
              groupWidth,
              22,
              NVVisionBoostUi.component(groups[i]),
              button -> {
                category = nextCategory;
                page = 0;
                init();
              },
              null);
      group.setSelectedStyle(category == i);
      addRenderableWidget(group);
    }
    pageStatus = groups[category] + NVVisionBoostUi.text(" • Página ") + (page + 1) + "/" + pages;
    for (int index = page * capacity;
        index < Math.min(shown.size(), (page + 1) * capacity);
        index++) {
      Control control = shown.get(index);
      addRenderableWidget(
          NVVisionBoostMenuButton.builder(
                  NVVisionBoostUi.component(control.label().get()),
                  button -> {
                    control.action().run();
                    if (Minecraft.getInstance().gui.screen() != this) return;
                    NVVisionBoostCore.saveConfig();
                    NVVisionBoostRenderController.applyNow(cfg());
                    NVVisionBoostPerformance.tick(cfg());
                    init();
                  })
              .bounds(left, 66 + (index % capacity) * 27, buttonWidth, 22)
              .tooltip(NVVisionBoostUi.tooltip(NVVisionBoostUi.component(control.help())))
              .build());
    }
    int footerWidth = Math.min(90, (width - 32) / 3);
    int footerLeft = (width - footerWidth * 3 - 12) / 2;
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Anterior")),
                button -> {
                  page = Math.floorMod(page - 1, pages);
                  init();
                })
            .bounds(footerLeft, height - 28, footerWidth, 20)
            .build());
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(NVVisionBoostUi.component(NVVisionBoostUi.text("Voltar")), button -> onClose())
            .bounds(footerLeft + footerWidth + 6, height - 28, footerWidth, 20)
            .build());
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Próxima")),
                button -> {
                  page = (page + 1) % pages;
                  init();
                })
            .bounds(footerLeft + 2 * (footerWidth + 6), height - 28, footerWidth, 20)
            .build());
  }

  private static int cycle(int value, int... values) {
    for (int index = 0; index < values.length; index++)
      if (values[index] == value) return values[(index + 1) % values.length];
    return values[0];
  }

  @Override
  public void onClose() {
    Minecraft.getInstance().gui.setScreen(parent);
  }

  @Override
  public void extractRenderState(GuiGraphicsExtractor graphics, int x, int y, float partialTick) {
    var theme = NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);
    graphics.fillGradient(0, 0, width, height, theme.background(), theme.header());
    graphics.fill(12, 8, 15, height - 8, theme.accent());
    graphics.centeredText(font, NVVisionBoostUi.component(title.getString()), width / 2, 20, theme.accent());
    graphics.centeredText(font, pageStatus, width / 2, height - 86, theme.muted());
    if (height >= 180) {
      String metrics = NVVisionBoostFrameTiming.status();
      String resolution = NVVisionBoostFrameTiming.resolutionStatus();
      graphics.centeredText(
          font,
          font.plainSubstrByWidth(metrics, Math.max(20, width - 20)),
          width / 2,
          height - 70,
          0xB5C4D8);
      graphics.centeredText(
          font,
          font.plainSubstrByWidth(resolution, Math.max(20, width - 20)),
          width / 2,
          height - 57,
          0xB5C4D8);
    }
    super.extractRenderState(graphics, x, y, partialTick);
  }
}
