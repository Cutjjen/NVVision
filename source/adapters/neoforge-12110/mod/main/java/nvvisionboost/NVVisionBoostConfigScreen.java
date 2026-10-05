package nvvisionboost;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Main configuration screen: navigation, settings and renderer integration. Minecraft 1.21.10
 * NeoForge / Java 21.
 */
public final class NVVisionBoostConfigScreen extends Screen {
  private final Screen parent;

  private int tab;
  private int scrollOffset;
  private int maxScroll;
  private final List<WidgetPosition> bodyWidgets = new ArrayList<>();

  private record WidgetPosition(net.minecraft.client.gui.components.AbstractWidget widget, int y) {}

  private int gpuPage;
  private int shaderPage;

  private EditBox search;
  private String gpuQuery = "";
  private NVVisionBoostMenuLayout.Layout layout;
  private Button statusHelp;
  private String tooltipStatus = "";

  private final List<Button> gpuButtons = new ArrayList<>();

  private List<NVVisionBoostGPU.Preset> filtered = new ArrayList<>();

  private NVVisionBoostGPU.Info detected;
  private NVVisionBoostGPU.Preset selectedGpu;
  private NVVisionBoostShader.Pack pendingShader;

  private NVVisionBoostGpuTheme theme =
      NVVisionBoostGpuTheme.forBrand(NVVisionBoostGpuCatalog.Brand.UNKNOWN);
  private String status = "";
  private String lastEngineStatus = "";

  public NVVisionBoostConfigScreen(Screen parent) {
    super(Component.literal("NV Vision Boost — Configuração detalhada"));

    this.parent = parent;
  }

  @Override
  protected void init() {
    super.init();

    detected = NVVisionBoostGPU.detect();
    theme = NVVisionBoostGpuTheme.forBrand(detected.brand);

    selectedGpu = NVVisionBoostGPU.presetFor(detected.name);

    rebuildInternal();
  }

  // ============================================================
  // LAYOUT
  // ============================================================

  private int panelLeft() {
    return layout.left();
  }

  private int panelRight() {
    return layout.right();
  }

  private int contentLeft() {
    return layout.contentLeft();
  }

  private int contentRight() {
    return layout.contentLeft() + layout.contentWidth();
  }

  private int contentWidth() {
    return layout.contentWidth();
  }

  private int colWidth() {
    return (contentWidth() - 12) / 2;
  }

  private int col2() {
    return contentLeft() + colWidth() + 12;
  }

  // ============================================================
  // REBUILD
  // ============================================================

  private void rebuildInternal() {
    String previousStatus = status;
    layout = NVVisionBoostMenuLayout.of(width, height);
    clearWidgets();
    NVVisionBoostUi.languages(width, this::rebuildInternal, b -> addRenderableWidget(b));

    gpuButtons.clear();
    bodyWidgets.clear();

    int l = contentLeft();

    int r = col2();

    int w = colWidth();

    String[] tabs = {
      NVVisionBoostUi.text("Início"),
      "GPU",
      "Shaders",
      "Visual",
      NVVisionBoostUi.text("Integrações"),
      NVVisionBoostUi.text("Avançado")
    };

    for (int i = 0; i < tabs.length; i++) {
      final int page = i;

      var bounds = layout.tab(i);

      NVVisionBoostOptionButton b =
          new NVVisionBoostOptionButton(
              bounds.x(),
              bounds.y(),
              bounds.width(),
              bounds.height(),
              NVVisionBoostUi.component(tabs[i]),
              btn -> {
                tab = page;
                scrollOffset = 0;

                status = "";

                rebuildInternal();
              },
              null);

      b.setSelectedStyle(tab == page);

      addRenderableWidget(b);
    }

    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Voltar")),
                b -> Minecraft.getInstance().setScreen(parent))
            .bounds(panelRight() - 106, height - 34, 90, 22)
            .build());

    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component("↑"),
                b -> {
                  scrollOffset -= 60;
                  applyScroll();
                })
            .bounds(contentLeft(), height - 34, 28, 22)
            .tooltip(
                NVVisionBoostUi.tooltip(
                    NVVisionBoostUi.component(NVVisionBoostUi.text("Rolar para cima"))))
            .build());
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component("↓"),
                b -> {
                  scrollOffset += 60;
                  applyScroll();
                })
            .bounds(contentLeft() + 34, height - 34, 28, 22)
            .tooltip(
                NVVisionBoostUi.tooltip(
                    NVVisionBoostUi.component(NVVisionBoostUi.text("Rolar para baixo"))))
            .build());
    statusHelp =
        addRenderableWidget(
            NVVisionBoostMenuButton.builder(NVVisionBoostUi.component("i"), b -> {})
                .bounds(contentLeft() + 68, height - 34, 24, 22)
                .build());
    tooltipStatus = null;
    int bodyStart = children().size();
    switch (tab) {
      case 0 -> buildGeneral(l, r, w);

      case 1 -> buildGpu(l, r, w);

      case 2 -> buildShaders(l, r, w);

      case 3 -> buildPerformance(l, r, w);

      case 4 -> buildCompatibility(l, r, w);

      default -> buildAdvanced(l, r, w);
    }
    var widgets = new ArrayList<net.minecraft.client.gui.components.AbstractWidget>();
    var original = new ArrayList<NVVisionBoostMenuLayout.Rect>();
    for (var child : children().subList(bodyStart, children().size())) {
      if (child instanceof net.minecraft.client.gui.components.AbstractWidget widget) {
        widgets.add(widget);
        original.add(
            new NVVisionBoostMenuLayout.Rect(
                widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight()));
      }
    }
    var arranged = NVVisionBoostMenuLayout.arrange(layout, original);
    for (int i = 0; i < widgets.size(); i++) {
      var widget = widgets.get(i);
      var bounds = arranged.get(i);
      widget.setX(bounds.x());
      widget.setWidth(bounds.width());
      bodyWidgets.add(new WidgetPosition(widget, bounds.y()));
    }
    maxScroll = NVVisionBoostMenuLayout.maxScroll(layout, arranged);
    if (!previousStatus.isBlank()) status = previousStatus;
    applyScroll();
  }

  private void applyScroll() {
    scrollOffset = NVVisionBoostMenuLayout.clampScroll(scrollOffset, maxScroll);
    for (var position : bodyWidgets) {
      var widget = position.widget();
      int y = position.y() - scrollOffset;
      widget.setY(y);
      widget.visible =
          y >= layout.bodyTop()
              && y + widget.getHeight() <= layout.bodyBottom()
              && (!gpuButtons.contains(widget) || widget.active);
      if (!widget.visible && getFocused() == widget) setFocused(null);
    }
  }

  @Override
  public boolean mouseScrolled(double x, double y, double horizontal, double delta) {
    if (y >= layout.bodyTop() && y < layout.bodyBottom() && maxScroll > 0) {
      scrollOffset -= (int) Math.round(delta * 30);
      applyScroll();
      return true;
    }
    return super.mouseScrolled(x, y, horizontal, delta);
  }

  @Override
  public void onClose() {
    Minecraft.getInstance().setScreen(parent);
  }

  // ============================================================
  // GENERAL
  // ============================================================

  private void buildGeneral(int l, int r, int w) {
    addButton(
        NVVisionBoostUi.text("NV Vision Boost: ") + on(cfg().enabled),
        l,
        94,
        w,
        () -> toggle("enabled"));

    addButton(
        NVVisionBoostUi.text("Otimização automática: ") + on(cfg().autoOptimize),
        r,
        94,
        w,
        () -> toggle("autoOptimize"));

    addCycle(
        NVVisionBoostUi.text("Escala interna: ") + cfg().renderScalePercent + "%",
        l,
        124,
        w,
        this::cycleScaleNext,
        this::cycleScalePrev);

    addButton(
        NVVisionBoostUi.text("Imagem, mundo e integrações..."),
        r,
        124,
        w,
        () -> Minecraft.getInstance().setScreen(new NVVisionBoostPerformanceScreen(this)));

    addCycle(
        NVVisionBoostUi.text("FPS alvo: ") + cfg().targetFps,
        l,
        154,
        w,
        this::cycleFpsNext,
        this::cycleFpsPrev);

    addCycle(
        NVVisionBoostUi.text("Perfil: ") + cfg().profile,
        r,
        154,
        w,
        this::cycleProfileNext,
        this::cycleProfilePrev);

    addButton(
        NVVisionBoostUi.text("Upscaling: ") + on(cfg().upscalingEnabled),
        l,
        194,
        w,
        this::toggleUpscaling);

    addButton(
        NVVisionBoostUi.text("Recursos da GPU ativa"),
        r,
        194,
        w,
        () -> status = detected.technologySummary());

    addButton(
        NVVisionBoostUi.text("Resolução dinâmica: ") + on(cfg().dynamicResolution),
        l,
        224,
        w,
        () -> toggle("dynamicResolution"));

    addButton(
        NVVisionBoostUi.text("Aplicar preset da GPU detectada"), r, 224, w, this::applyDetected);

    addButton(
        NVVisionBoostUi.text("Aplicar todas as configurações agora"),
        l,
        264,
        w * 2 + 12,
        () -> {
          NVVisionBoostNativeRenderer.reset();

          NVVisionBoostRenderController.applyNow(cfg());

          status = NVVisionBoostUi.text("Configurações reaplicadas ao Minecraft.");
        });

    addButton(
        NVVisionBoostUi.text("Restaurar padrões do NVVisionBoost"),
        l,
        296,
        w * 2 + 12,
        this::restoreDefaults);

    status = NVVisionBoostUi.text("Upscaling: ") + NVVisionBoostNativeRenderer.internalResolution();
  }

  // ============================================================
  // GPU
  // ============================================================

  private void buildGpu(int l, int r, int w) {
    search =
        new EditBox(
            font,
            l,
            94,
            Math.max(60, w - 8),
            20,
            NVVisionBoostUi.component(NVVisionBoostUi.text("Pesquisar GPU")));

    search.setMaxLength(80);
    search.setSuggestion(NVVisionBoostUi.text("Pesquisar ") + theme.title() + "...");
    search.setValue(gpuQuery);

    search.setResponder(
        q -> {
          gpuQuery = q;
          gpuPage = 0;

          filterGpu(q);

          refreshGpuButtons();
        });

    addRenderableWidget(search);

    addButton(NVVisionBoostUi.text("Aplicar preset da GPU ativa"), r, 94, w, this::applyDetected);

    filterGpu(search.getValue());
    addButton(
        NVVisionBoostUi.text("OpenGL: ") + theme.title(),
        r,
        126,
        w,
        () -> status = detected.technologySummary());
    if (detected.nativeMemorySupported)
      addButton(
          detected.nvidia
              ? NVVisionBoostUi.text("Memória NVIDIA NVX")
              : NVVisionBoostUi.text("Memória AMD ATI"),
          r,
          154,
          w,
          () -> status = NVVisionBoostGPU.memoryDiagnostics());
    addButton(
        detected.type.label,
        r,
        182,
        w,
        () ->
            status =
                NVVisionBoostUi.text(
                    "Tipo pelo nome da GPU ativa. Memória compartilhada não é VRAM dedicada."));
    addButton(
        NVVisionBoostUi.text("Sobre as tecnologias"),
        r,
        210,
        w,
        () ->
            status =
                NVVisionBoostUi.text(
                        "FSR 1 é multiplataforma. DLSS, XeSS e geração de quadros não estão")
                    + NVVisionBoostUi.text(" implementados."));

    int y = 126;

    for (int i = 0; i < 8; i++) {
      final int local = i;

      Button b =
          NVVisionBoostMenuButton.builder(NVVisionBoostUi.component(""), x -> selectGpu(local))
              .bounds(l, y + i * 28, w, 23)
              .build();

      gpuButtons.add(b);

      addRenderableWidget(b);
    }

    addButton(
        "◀",
        l,
        356,
        60,
        () -> {
          if (gpuPage > 0) {
            gpuPage--;

            refreshGpuButtons();
          }
        });

    addButton(
        "▶",
        l + w - 60,
        356,
        60,
        () -> {
          int max = Math.max(0, (filtered.size() - 1) / 8);

          if (gpuPage < max) {
            gpuPage++;

            refreshGpuButtons();
          }
        });

    addButton(
        NVVisionBoostUi.text("Exportar banco de presets"),
        r,
        356,
        w,
        () -> {
          NVVisionBoostGPU.writePresetDatabase(NVVisionBoostCore.root);

          status = NVVisionBoostUi.text("Banco exportado.");
        });

    refreshGpuButtons();

    status =
        NVVisionBoostUi.text("GPU detectada: ")
            + detected.name
            + " | "
            + NVVisionBoostHardwareBudget.detect().summary();
  }

  // ============================================================
  // SHADERS
  // ============================================================

  private void buildShaders(int l, int r, int w) {
    List<NVVisionBoostShader.Pack> packs =
        NVVisionBoostShader.scan(
            NVVisionBoostContentManager.shaderpacksDir(),
            NVVisionBoostCore.root.resolve("shader-cache"));

    NVVisionBoostShader.Pack active = NVVisionBoostShaderEngine.selected();

    if (pendingShader == null && active != null) {
      pendingShader = active;
    }

    int pages = Math.max(1, (packs.size() + 5) / 6);

    if (shaderPage >= pages) {
      shaderPage = pages - 1;
    }

    addButton(NVVisionBoostUi.text("Importar shaderpack"), l, 94, w, this::importShader);

    addButton(
        NVVisionBoostUi.text("Importar resource pack / texturas"),
        r,
        94,
        w,
        this::importResourcePack);

    addButton(
        NVVisionBoostUi.text("Preparar shader selecionado"), l, 124, w, this::compilePendingShader);

    addButton(
        NVVisionBoostUi.text("Abrir pasta shaderpacks"),
        r,
        124,
        w,
        () -> openFolder(NVVisionBoostContentManager.shaderpacksDir(), "shaderpacks"));

    addButton(
        NVVisionBoostUi.text("Abrir pasta resourcepacks"),
        l,
        154,
        w,
        () -> openFolder(NVVisionBoostContentManager.resourcepacksDir(), "resourcepacks"));

    addButton(
        NVVisionBoostUi.text("Reanalisar shaderpacks"),
        r,
        154,
        w,
        () -> {
          NVVisionBoostShaderEngine.refresh(NVVisionBoostCore.gameRoot(), cfg());

          status = NVVisionBoostUi.text("Shaderpacks reanalisados.");

          rebuildInternal();
        });

    int start = shaderPage * 6;

    for (int i = 0; i < 6; i++) {
      int index = start + i;

      if (index >= packs.size()) {
        break;
      }

      NVVisionBoostShader.Pack pack = packs.get(index);

      boolean selected = pendingShader != null && pack.name.equals(pendingShader.name);

      boolean activePack = active != null && pack.name.equals(active.name);

      addShaderButton(pack, l, 190 + i * 28, w, selected || activePack);
    }

    addCycle(
        NVVisionBoostUi.text("Página ") + (shaderPage + 1) + "/" + pages,
        r,
        190,
        w,
        () -> {
          shaderPage = (shaderPage + 1) % pages;

          rebuildInternal();
        },
        () -> {
          shaderPage = (shaderPage - 1 + pages) % pages;

          rebuildInternal();
        });

    addButton(
        NVVisionBoostUi.text("Shaders: abrir controles do Iris"),
        r,
        220,
        w,
        () -> {
          NVVisionBoostShaderQuality.openOptions(this);
          status = NVVisionBoostShaderQuality.status();
        });

    addButton(
        NVVisionBoostUi.text("Qualidade do shaderpack..."),
        r,
        250,
        w,
        () -> {
          NVVisionBoostShaderQuality.openOptions(this);
          status = NVVisionBoostShaderQuality.status();
        });

    addButton(
        NVVisionBoostUi.text("Mipmaps seguros de texturas..."),
        r,
        340,
        w,
        () -> Minecraft.getInstance().setScreen(new NVVisionBoostTextureScreen(this)));

    String selectedName =
        pendingShader == null ? NVVisionBoostUi.text("Nenhum") : pendingShader.name;

    addButton(
        NVVisionBoostUi.text("Selecionado: ") + fit(selectedName, 42),
        l,
        368,
        w * 2 + 12,
        () -> {});

    status =
        packs.isEmpty()
            ? NVVisionBoostUi.text("Nenhum shaderpack. Use Importar ou Abrir pasta.")
            : packs.size()
                + NVVisionBoostUi.text(
                    " shaderpack(s). Sombras e reflexos: Qualidade do shaderpack.");
  }

  // ============================================================
  // PERFORMANCE
  // ============================================================

  private void buildPerformance(int l, int r, int w) {
    addButton(
        NVVisionBoostUi.text("Perfil visual: ") + on(cfg().animationOptimization),
        l,
        94,
        w,
        () -> toggle("animationOptimization"));

    addButton(
        NVVisionBoostUi.text("Entidades: ") + on(cfg().entityOptimization),
        r,
        94,
        w,
        () -> toggle("entityOptimization"));

    addButton(
        NVVisionBoostUi.text("Oclusão ambiente: ") + on(cfg().transparencyOptimization),
        l,
        124,
        w,
        () -> toggle("transparencyOptimization"));

    addButton(
        NVVisionBoostUi.text("Partículas reduzidas: ") + on(cfg().reduceParticles),
        r,
        124,
        w,
        () -> toggle("reduceParticles"));

    addButton(
        NVVisionBoostUi.text("Nuvens desligadas: ") + on(cfg().disableClouds),
        l,
        154,
        w,
        () -> toggle("disableClouds"));

    addButton(
        NVVisionBoostUi.text("Desativar sombras de entidades: ") + on(cfg().disableEntityShadows),
        r,
        154,
        w,
        () -> toggle("disableEntityShadows"));

    addButton(
        NVVisionBoostUi.text("Efeitos de câmera: ") + on(cfg().reduceShaderEffects),
        l,
        184,
        w,
        () -> toggle("reduceShaderEffects"));

    addButton(
        NVVisionBoostUi.text("Balanço da câmera: ") + on(cfg().reduceViewBob),
        r,
        184,
        w,
        () -> toggle("reduceViewBob"));

    addCycle(
        NVVisionBoostUi.text("Nível visual: ") + cfg().animationLevel,
        l,
        224,
        w,
        this::cycleAnimationNext,
        this::cycleAnimationPrev);

    addCycle(
        NVVisionBoostUi.text("Nível de oclusão: ") + cfg().transparencyLevel,
        r,
        224,
        w,
        this::cycleTransparencyNext,
        this::cycleTransparencyPrev);

    addCycle(
        NVVisionBoostUi.text("Distância de entidades: ") + cfg().entityDistancePercent + "%",
        l,
        254,
        w,
        this::cycleEntityDistanceNext,
        this::cycleEntityDistancePrev);

    addCycle(
        NVVisionBoostUi.text("Escala interna: ") + cfg().renderScalePercent + "%",
        r,
        254,
        w,
        this::cycleScaleNext,
        this::cycleScalePrev);

    addButton(
        NVVisionBoostUi.text("Imagem, mundo e integrações..."),
        l,
        284,
        w,
        () -> Minecraft.getInstance().setScreen(new NVVisionBoostPerformanceScreen(this)));

    addButton(
        NVVisionBoostUi.text("Recursos da GPU ativa"),
        r,
        284,
        w,
        () -> status = detected.technologySummary());

    addButton(
        NVVisionBoostUi.text("Reaplicar escala e renderização"),
        l,
        324,
        w * 2 + 12,
        () -> {
          NVVisionBoostNativeRenderer.reset();

          NVVisionBoostRenderController.applyNow(cfg());

          status =
              NVVisionBoostUi.text("Renderer reaplicado. Diagnóstico: ")
                  + NVVisionBoostNativeRenderer.internalResolution();
        });
  }

  // ============================================================
  // COMPATIBILITY
  // ============================================================

  private void buildCompatibility(int l, int r, int w) {
    addButton(
        NVVisionBoostVulkanBridge.summary(),
        l,
        270,
        w * 2 + 12,
        () -> status = NVVisionBoostVulkanBridge.status().toString());
    if (NVVisionBoostVulkanBridge.present()) {

      addButton(
          NVVisionBoostUi.text("CPU: ") + NVVisionBoostVulkanBridge.cpuProfile(),
          l,
          300,
          w * 2 + 12,
          () -> {
            status = NVVisionBoostVulkanBridge.cycleCpuProfile();
            rebuildInternal();
          });
      addButton(
          NVVisionBoostUi.text("CPU entidades (custom): ")
              + NVVisionBoostVulkanBridge.cpuControl("distance"),
          l,
          328,
          w * 2 + 12,
          () -> {
            status = NVVisionBoostVulkanBridge.cycleCpuControl("distance");
            rebuildInternal();
          });
      addButton(
          NVVisionBoostUi.text("CPU partículas (custom): ")
              + NVVisionBoostVulkanBridge.cpuControl("particles"),
          l,
          356,
          w * 2 + 12,
          () -> {
            status = NVVisionBoostVulkanBridge.cycleCpuControl("particles");
            rebuildInternal();
          });
    }
    addButton(
        NVVisionBoostUi.text("Backend: ") + NVVisionBoostCompatibility.shaderBackend(),
        l,
        94,
        w,
        () -> status = NVVisionBoostCompatibility.integrationSummary());

    addButton(
        NVVisionBoostUi.text("Iris: ") + detect(NVVisionBoostCompatibility.iris()),
        r,
        94,
        w,
        () -> status = NVVisionBoostUi.text("Iris é responsável pela execução dos shaderpacks."));

    addButton(
        NVVisionBoostUi.text("Análise de recursos: ") + on(cfg().resourceOptimization),
        l,
        124,
        w,
        () -> toggle("resourceOptimization"));

    addButton(
        NVVisionBoostUi.text("Análise multipasse: ") + on(cfg().shaderMultiPass),
        r,
        124,
        w,
        () -> toggle("shaderMultiPass"));

    addButton(
        NVVisionBoostUi.text("Shader renderer: ") + NVVisionBoostCompatibility.shaderBackend(),
        l,
        164,
        w,
        () ->
            status =
                NVVisionBoostCompatibility.iris()
                    ? NVVisionBoostUi.text("Iris detectado e responsável pelos shaders.")
                    : NVVisionBoostUi.text("Iris não detectado."));

    addButton(NVVisionBoostUi.text("NeoForge: Minecraft 1.21.10"), l, 194, w, () -> {});
    addButton(
        NVVisionBoostUi.text("FerriteCore: memória e compatibilidade"),
        l,
        264,
        w * 2 + 12,
        () -> Minecraft.getInstance().setScreen(new NVVisionBoostFerriteScreen(this)));

    addButton(
        NVVisionBoostUi.text("Renderer: ") + fit(NVVisionBoostCompatibility.renderer(), 28),
        r,
        194,
        w,
        () -> {});

    addButton(
        NVVisionBoostUi.text("Integração: ")
            + fit(NVVisionBoostCompatibility.integrationSummary(), 48),
        l,
        234,
        w * 2 + 12,
        () -> status = NVVisionBoostCompatibility.integrationSummary());
  }

  // ============================================================
  // ADVANCED
  // ============================================================

  private void buildAdvanced(int l, int r, int w) {
    addCycle(
        NVVisionBoostUi.text("Distância de renderização: ") + cfg().renderDistance,
        l,
        94,
        w,
        this::cycleRenderDistanceNext,
        this::cycleRenderDistancePrev);

    addCycle(
        NVVisionBoostUi.text("Distância mínima: ") + cfg().minRenderDistance,
        r,
        94,
        w,
        this::cycleMinRenderDistanceNext,
        this::cycleMinRenderDistancePrev);

    addCycle(
        NVVisionBoostUi.text("Distância máxima: ") + cfg().maxRenderDistance,
        l,
        124,
        w,
        this::cycleMaxRenderDistanceNext,
        this::cycleMaxRenderDistancePrev);

    addCycle(
        NVVisionBoostUi.text("Limite de pico: ") + cfg().spikeThresholdMs + " ms",
        r,
        124,
        w,
        this::cycleSpikeNext,
        this::cycleSpikePrev);

    addCycle(
        NVVisionBoostUi.text("Intervalo de adaptação: ")
            + cfg().adaptationCooldownSeconds
            + NVVisionBoostUi.text(" s"),
        l,
        154,
        w,
        this::cycleCooldownNext,
        this::cycleCooldownPrev);

    addButton(
        NVVisionBoostUi.text("Shader cache: ") + on(cfg().shaderCache),
        r,
        154,
        w,
        () -> toggle("shaderCache"));

    addButton(
        NVVisionBoostUi.text("Preparo automático: ") + on(cfg().shaderWarmup),
        l,
        184,
        w,
        () -> toggle("shaderWarmup"));

    addButton(
        NVVisionBoostUi.text("Proteção de memória: ") + on(cfg().memoryGuard),
        r,
        184,
        w,
        () -> toggle("memoryGuard"));

    addButton(
        NVVisionBoostUi.text("Perfil automático de shaders: ") + on(cfg().shaderAutoProfile),
        l,
        214,
        w,
        () -> toggle("shaderAutoProfile"));

    addButton(
        NVVisionBoostUi.text("Restaurar padrões do NVVisionBoost"),
        r,
        214,
        w,
        this::restoreDefaults);

    addButton(
        NVVisionBoostUi.text("Reaplicar agora"),
        l,
        254,
        w * 2 + 12,
        () -> {
          NVVisionBoostNativeRenderer.reset();

          NVVisionBoostRenderController.applyNow(cfg());

          status = NVVisionBoostUi.text("Reaplicado.");
        });
  }

  // ============================================================
  // BUTTON HELPERS
  // ============================================================

  private void addShaderButton(
      NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected) {
    NVVisionBoostOptionButton b =
        new NVVisionBoostOptionButton(
            x,
            y,
            w,
            23,
            NVVisionBoostUi.component(
                (selected ? NVVisionBoostUi.text("● ") : NVVisionBoostUi.text("○ ")) + pack.name),
            btn -> selectShader(pack, 0),
            btn -> selectShader(pack, -1));

    b.setSelectedStyle(selected);

    addRenderableWidget(b);
  }

  private void addButton(String text, int x, int y, int w, Runnable action) {
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(NVVisionBoostUi.component(text), b -> action.run())
            .bounds(x, y, w, 22)
            .build());
  }

  private void addCycle(String text, int x, int y, int w, Runnable next, Runnable previous) {
    addRenderableWidget(
        new NVVisionBoostOptionButton(
            x,
            y,
            w,
            22,
            NVVisionBoostUi.component(text),
            b -> {
              next.run();

              if (!text.startsWith(NVVisionBoostUi.text("Página "))) refreshAfterChange();
            },
            b -> {
              previous.run();

              if (!text.startsWith(NVVisionBoostUi.text("Página "))) refreshAfterChange();
            }));
  }

  // ============================================================
  // CONFIG HELPERS
  // ============================================================

  private NVVisionBoostCore.Config cfg() {
    return NVVisionBoostCore.cfg;
  }

  private void refreshAfterChange() {
    NVVisionBoostCore.saveConfig();

    NVVisionBoostRenderController.applyNow(cfg());

    rebuildInternal();
  }

  private void restoreDefaults() {
    /* Invalidate renderer settings before applying the new configuration. */
    NVVisionBoostNativeRenderer.reset();

    NVVisionBoostRenderController.restorePlayerOptions();
    NVVisionBoostCore.cfg = new NVVisionBoostCore.Config();

    /* Iris owns shader execution. */
    NVVisionBoostCore.cfg.nativeShaderRenderer = false;

    NVVisionBoostCore.cfg.rendererBackend =
        NVVisionBoostCompatibility.iris() ? "iris-compatible" : "auto";

    NVVisionBoostCore.cfg.irisIntegration = NVVisionBoostCompatibility.iris();

    NVVisionBoostCore.saveConfig();

    NVVisionBoostRenderController.applyNow(cfg());

    status = NVVisionBoostUi.text("Configurações restauradas.");

    rebuildInternal();
  }

  private void toggle(String field) {
    if (field.equals("frameGenerationEnabled")) {
      status = NVVisionBoostUi.text("Frame Generation não possui implementação nesta versão.");
      return;
    }

    /* Use the upscaling setter so render-target changes follow the renderer lifecycle. */
    if ("upscalingEnabled".equals(field)) {
      toggleUpscaling();

      return;
    }

    try {
      var f = NVVisionBoostCore.Config.class.getDeclaredField(field);

      f.setAccessible(true);

      f.setBoolean(cfg(), !f.getBoolean(cfg()));

      refreshAfterChange();
    } catch (ReflectiveOperationException e) {
      status = NVVisionBoostUi.text("Falha ao alterar ") + field;

      NVVisionBoostCore.log("config toggle failed: " + e);
    }
  }

  private void toggleUpscaling() {
    NVVisionBoostCore.toggleUpscaling();

    NVVisionBoostRenderController.applyNow(cfg());

    if (cfg().upscalingEnabled) {
      status =
          NVVisionBoostUi.text("Upscaling ATIVO | escala interna ")
              + cfg().renderScalePercent
              + "%";
    } else {
      status = NVVisionBoostUi.text("Upscaling DESATIVADO | resolução nativa");
    }

    rebuildInternal();
  }

  // ============================================================
  // GPU
  // ============================================================

  private void filterGpu(String query) {
    String q = query == null ? "" : query.toLowerCase(Locale.ROOT).trim();

    filtered =
        NVVisionBoostGPU.presets().stream()
            .filter(
                p ->
                    detected.brand == NVVisionBoostGpuCatalog.Brand.UNKNOWN
                        || NVVisionBoostGpuCatalog.classify("", p.name).brand() == detected.brand)
            .filter(
                p ->
                    q.isEmpty()
                        || p.name.toLowerCase(Locale.ROOT).contains(q)
                        || p.family.toLowerCase(Locale.ROOT).contains(q)
                        || p.architecture.toLowerCase(Locale.ROOT).contains(q))
            .collect(Collectors.toList());
  }

  private void refreshGpuButtons() {
    int start = gpuPage * 8;

    for (int i = 0; i < gpuButtons.size(); i++) {
      Button b = gpuButtons.get(i);

      int idx = start + i;

      if (idx < filtered.size()) {
        NVVisionBoostGPU.Preset p = filtered.get(idx);

        b.visible = true;

        b.active = true;

        b.setMessage(
            NVVisionBoostUi.component(
                p.name + " | " + p.architecture + (p.vramGB > 0 ? " | " + p.vramGB + "GB" : "")));
        b.setTooltip(
            net.minecraft.client.gui.components.Tooltip.create(
                NVVisionBoostUi.component(NVVisionBoostUi.help(b.getMessage().getString(), true))));
      } else {
        b.visible = false;

        b.active = false;
      }
    }
    applyScroll();
  }

  private void selectGpu(int localIndex) {
    int idx = gpuPage * 8 + localIndex;

    if (idx >= 0 && idx < filtered.size()) {
      applyPreset(filtered.get(idx));
    }
  }

  private void applyDetected() {
    detected = NVVisionBoostGPU.detect();
    theme = NVVisionBoostGpuTheme.forBrand(detected.brand);

    selectedGpu = NVVisionBoostGPU.presetFor(detected.name);

    if (selectedGpu == null) {
      status = NVVisionBoostUi.text("Nenhum preset específico para ") + detected.name;

      rebuildInternal();

      return;
    }

    applyPreset(selectedGpu);
  }

  private void applyPreset(NVVisionBoostGPU.Preset p) {
    NVVisionBoostGPU.applyPreset(cfg(), p);

    cfg().gpuPresetApplied = true;

    cfg().gpuPreset = p.name;

    /* Iris owns shaders. */
    cfg().nativeShaderRenderer = false;

    cfg().rendererBackend = NVVisionBoostCompatibility.iris() ? "iris-compatible" : "auto";

    cfg().irisIntegration = NVVisionBoostCompatibility.iris();

    NVVisionBoostCore.saveConfig();

    /*
     * Preset pode modificar escala.
     */
    NVVisionBoostNativeRenderer.reset();

    NVVisionBoostRenderController.applyNow(cfg());

    status = NVVisionBoostUi.text("Preset aplicado: ") + p.name;

    rebuildInternal();
  }

  // ============================================================
  // SHADERS
  // ============================================================

  private void selectShader(NVVisionBoostShader.Pack pack, int direction) {
    if (pack == null) {
      return;
    }

    List<NVVisionBoostShader.Pack> packs =
        NVVisionBoostShader.scan(
            NVVisionBoostContentManager.shaderpacksDir(),
            NVVisionBoostCore.root.resolve("shader-cache"));

    if (packs.isEmpty()) {
      return;
    }

    int index = packs.indexOf(pack);

    if (index < 0) {
      index = 0;

      for (int i = 0; i < packs.size(); i++) {
        if (packs.get(i).name.equals(pack.name)) {
          index = i;

          break;
        }
      }
    }

    if (direction != 0) {
      index = (index + direction + packs.size()) % packs.size();
    }

    pendingShader = packs.get(index);

    status =
        NVVisionBoostUi.text("Selecionado para análise: ")
            + pendingShader.name
            + NVVisionBoostUi.text(" | use Preparar shader selecionado");

    rebuildInternal();
  }

  private void compilePendingShader() {
    if (pendingShader == null) {
      status = NVVisionBoostUi.text("Selecione um shaderpack primeiro.");

      rebuildInternal();

      return;
    }

    boolean ok =
        NVVisionBoostShaderEngine.prepareAsync(
            NVVisionBoostCore.gameRoot(), pendingShader.name, true);

    status = NVVisionBoostShaderEngine.loadStatus();

    NVVisionBoostCore.log(status);

    rebuildInternal();
  }

  private void importShader() {
    openChooser(
        NVVisionBoostUi.text("Importar e carregar Shaderpack"),
        path -> {
          try {
            String installed = NVVisionBoostContentManager.importShader(path);

            NVVisionBoostShaderEngine.refresh(NVVisionBoostCore.gameRoot(), cfg());

            pendingShader = NVVisionBoostShaderEngine.findByName(installed);

            if (pendingShader != null) {
              boolean prepared =
                  NVVisionBoostShaderEngine.prepareAsync(
                      NVVisionBoostCore.gameRoot(), pendingShader.name, true);

              status = NVVisionBoostShaderEngine.loadStatus();
            } else {
              status = NVVisionBoostUi.text("Shader instalado para análise: ") + installed;
            }
          } catch (Throwable t) {
            status = NVVisionBoostUi.text("Falha ao preparar shader: ") + t.getMessage();

            NVVisionBoostCore.log("shader compile/import: " + t);
          }

          rebuildInternal();
        });
  }

  // ============================================================
  // RESOURCE PACK
  // ============================================================

  private void importResourcePack() {
    openChooser(
        NVVisionBoostUi.text("Importar Resource Pack / Texturas"),
        path -> {
          try {
            String installed = NVVisionBoostContentManager.importResourcePack(path);

            boolean active = NVVisionBoostContentManager.activateResourcePack(installed);

            status =
                active
                    ? NVVisionBoostUi.text("Texturas importadas e ativadas: ") + installed
                    : NVVisionBoostUi.text("Texturas importadas: ") + installed;
          } catch (Throwable t) {
            status = NVVisionBoostUi.text("Falha ao importar texturas: ") + t.getMessage();

            NVVisionBoostCore.log("resource pack import: " + t);
          }

          rebuildInternal();
        });
  }

  // ============================================================
  // FILE CHOOSER
  // ============================================================

  private void openChooser(String title, Consumer<Path> callback) {
    try {
      SwingUtilities.invokeLater(
          () -> {
            try {
              JFileChooser chooser = new JFileChooser();

              chooser.setDialogTitle(title);

              chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

              if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                Path path = chooser.getSelectedFile().toPath();

                Minecraft.getInstance().execute(() -> callback.accept(path));
              }
            } catch (Throwable t) {
              Minecraft.getInstance()
                  .execute(() -> status = NVVisionBoostUi.text("Seletor: ") + t.getMessage());
            }
          });
    } catch (Throwable t) {
      status = NVVisionBoostUi.text("Não foi possível abrir o seletor: ") + t.getMessage();
    }
  }

  private void openFolder(Path path, String label) {
    status =
        NVVisionBoostContentManager.openFolder(path)
            ? NVVisionBoostUi.text("Pasta ") + label + NVVisionBoostUi.text(" aberta.")
            : NVVisionBoostUi.text("Não foi possível abrir ") + label + ".";

    rebuildInternal();
  }

  // ============================================================
  // UTILITIES
  // ============================================================

  private String detect(boolean present) {
    return present ? NVVisionBoostUi.text("detectado") : NVVisionBoostUi.text("não detectado");
  }

  private String on(boolean value) {
    return value ? NVVisionBoostUi.text("Ligado") : NVVisionBoostUi.text("Desligado");
  }

  private String fit(String text, int max) {
    if (text == null) {
      return "";
    }

    return text.length() <= max ? text : text.substring(0, Math.max(1, max - 3)) + "...";
  }

  private int next(int value, int[] values, int dir) {
    int i = 0;

    for (int n = 0; n < values.length; n++) {
      if (values[n] == value) {
        i = n;

        break;
      }
    }

    return values[(i + (dir < 0 ? -1 : 1) + values.length) % values.length];
  }

  private String next(String value, String[] values, int dir) {
    int i = 0;

    for (int n = 0; n < values.length; n++) {
      if (values[n].equalsIgnoreCase(value)) {
        i = n;

        break;
      }
    }

    return values[(i + (dir < 0 ? -1 : 1) + values.length) % values.length];
  }

  // ============================================================
  // SCALE
  // ============================================================

  private void cycleScaleNext() {
    int value =
        next(cfg().renderScalePercent, new int[] {100, 90, 85, 80, 75, 67, 50, 35, 25, 10}, 1);

    NVVisionBoostCore.setRenderScalePercent(value);

    status = NVVisionBoostUi.text("Escala interna: ") + value + "%";
  }

  private void cycleScalePrev() {
    int value =
        next(cfg().renderScalePercent, new int[] {100, 90, 85, 80, 75, 67, 50, 35, 25, 10}, -1);

    NVVisionBoostCore.setRenderScalePercent(value);

    status = NVVisionBoostUi.text("Escala interna: ") + value + "%";
  }

  // ============================================================
  // OTHER CYCLES
  // ============================================================

  private void cycleFpsNext() {
    cfg().targetFps = next(cfg().targetFps, new int[] {30, 45, 60, 75, 90, 120}, 1);
  }

  private void cycleFpsPrev() {
    cfg().targetFps = next(cfg().targetFps, new int[] {30, 45, 60, 75, 90, 120}, -1);
  }

  private void cycleAnimationNext() {
    cfg().animationLevel = next(cfg().animationLevel, new int[] {0, 1, 2, 3}, 1);
  }

  private void cycleAnimationPrev() {
    cfg().animationLevel = next(cfg().animationLevel, new int[] {0, 1, 2, 3}, -1);
  }

  private void cycleTransparencyNext() {
    cfg().transparencyLevel = next(cfg().transparencyLevel, new int[] {0, 1, 2, 3}, 1);
  }

  private void cycleTransparencyPrev() {
    cfg().transparencyLevel = next(cfg().transparencyLevel, new int[] {0, 1, 2, 3}, -1);
  }

  private void cycleEntityDistanceNext() {
    cfg().entityDistancePercent =
        next(cfg().entityDistancePercent, new int[] {50, 65, 80, 90, 100}, 1);
  }

  private void cycleEntityDistancePrev() {
    cfg().entityDistancePercent =
        next(cfg().entityDistancePercent, new int[] {50, 65, 80, 90, 100}, -1);
  }

  private void cycleProfileNext() {
    cfg().profile = next(cfg().profile, new String[] {"low", "balanced", "quality"}, 1);
  }

  private void cycleProfilePrev() {
    cfg().profile = next(cfg().profile, new String[] {"low", "balanced", "quality"}, -1);
  }

  private void cycleRenderDistanceNext() {
    cfg().renderDistance =
        next(cfg().renderDistance, new int[] {6, 8, 10, 12, 14, 16, 20, 24, 32}, 1);

    cfg().renderDistance =
        Math.max(cfg().minRenderDistance, Math.min(cfg().renderDistance, cfg().maxRenderDistance));
  }

  private void cycleRenderDistancePrev() {
    cfg().renderDistance =
        next(cfg().renderDistance, new int[] {6, 8, 10, 12, 14, 16, 20, 24, 32}, -1);

    cfg().renderDistance =
        Math.max(cfg().minRenderDistance, Math.min(cfg().renderDistance, cfg().maxRenderDistance));
  }

  private void cycleMinRenderDistanceNext() {
    cfg().minRenderDistance = next(cfg().minRenderDistance, new int[] {2, 4, 6, 8, 10, 12, 16}, 1);
  }

  private void cycleMinRenderDistancePrev() {
    cfg().minRenderDistance = next(cfg().minRenderDistance, new int[] {2, 4, 6, 8, 10, 12, 16}, -1);
  }

  private void cycleMaxRenderDistanceNext() {
    cfg().maxRenderDistance = next(cfg().maxRenderDistance, new int[] {8, 12, 16, 20, 24, 32}, 1);
  }

  private void cycleMaxRenderDistancePrev() {
    cfg().maxRenderDistance = next(cfg().maxRenderDistance, new int[] {8, 12, 16, 20, 24, 32}, -1);
  }

  private void cycleSpikeNext() {
    cfg().spikeThresholdMs =
        next(cfg().spikeThresholdMs, new int[] {20, 25, 30, 35, 40, 50, 60, 80}, 1);
  }

  private void cycleSpikePrev() {
    cfg().spikeThresholdMs =
        next(cfg().spikeThresholdMs, new int[] {20, 25, 30, 35, 40, 50, 60, 80}, -1);
  }

  private void cycleCooldownNext() {
    cfg().adaptationCooldownSeconds =
        next(cfg().adaptationCooldownSeconds, new int[] {2, 4, 6, 8, 12, 20, 30, 60}, 1);
  }

  private void cycleCooldownPrev() {
    cfg().adaptationCooldownSeconds =
        next(cfg().adaptationCooldownSeconds, new int[] {2, 4, 6, 8, 12, 20, 30, 60}, -1);
  }

  // ============================================================
  // RENDER
  // ============================================================

  @Override
  public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
    if (tab == 2) {
      String current = NVVisionBoostShaderEngine.loadStatus();
      if (!current.equals(lastEngineStatus)) {
        lastEngineStatus = current;
        status = current;
      }
    }
    graphics.fillGradient(0, 0, width, height, theme.background(), theme.header());
    graphics.fill(panelLeft(), 12, panelRight(), height - 10, theme.surface());
    graphics.fillGradient(
        panelLeft(), 12, panelRight(), layout.bodyTop() - 8, theme.header(), theme.surface());
    graphics.fill(panelLeft(), 12, panelLeft() + 3, height - 10, theme.accent());
    graphics.fill(
        contentLeft() - 4,
        layout.bodyTop() - 4,
        contentRight() + 4,
        layout.bodyBottom() + 4,
        theme.background());
    graphics.drawString(
        font, NVVisionBoostUi.text("NV VISION BOOST"), contentLeft(), 20, 0xFFEAF1F7);
    String brand = theme.title();
    if (contentWidth() > 340)
      graphics.drawString(font, brand, contentRight() - font.width(brand), 20, theme.accent());
    String gpu =
        detected == null
            ? NVVisionBoostUi.text("Detectando GPU...")
            : detected.name + " • " + detected.type.label;
    graphics.drawString(
        font,
        font.plainSubstrByWidth(NVVisionBoostUi.text(gpu), contentWidth()),
        contentLeft(),
        36,
        theme.muted());
    graphics.drawString(
        font,
        font.plainSubstrByWidth(NVVisionBoostUi.text(status), Math.max(20, contentWidth())),
        contentLeft(),
        height - 57,
        theme.accent());
    // Reserve a readable advisory footer outside the scrolling control area.
    String[] compatibilityLines = NVVisionBoostCompatibilityNotice.lines();
    for (int line = 0; line < compatibilityLines.length; line++) {
      graphics.drawString(
          font,
          font.plainSubstrByWidth(NVVisionBoostUi.text(compatibilityLines[line]), contentWidth()),
          contentLeft(),
          height - 95 + line * 11,
          0xFFFFCF70);
    }
    if (!status.equals(tooltipStatus)) {
      tooltipStatus = status;
      statusHelp.setTooltip(
          NVVisionBoostUi.infoTooltip(
              NVVisionBoostUi.component(
                  (status.isBlank()
                          ? NVVisionBoostUi.text("As opções são salvas quando alteradas.")
                          : status)
                      + "\n\n"
                      + NVVisionBoostUi.text(NVVisionBoostCompatibilityNotice.MESSAGE))));
    }
    if (maxScroll > 0) {
      int track = layout.bodyBottom() - layout.bodyTop();
      int thumb = Math.max(12, track * track / (track + maxScroll));
      int y = layout.bodyTop() + (track - thumb) * scrollOffset / maxScroll;
      graphics.fill(
          panelRight() - 9,
          layout.bodyTop(),
          panelRight() - 6,
          layout.bodyBottom(),
          theme.border());
      graphics.fill(panelRight() - 9, y, panelRight() - 6, y + thumb, theme.accent());
    }
    if (contentWidth() > 560)
      graphics.drawString(
          font,
          NVVisionBoostUi.text("Roda: rolar • Clique direito: anterior"),
          contentLeft() + 106,
          height - 27,
          theme.muted());

    super.render(graphics, mouseX, mouseY, partialTick);
  }

  // The themed screen owns its background; avoid blurring text a second time.
  @Override
  public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {}
}
