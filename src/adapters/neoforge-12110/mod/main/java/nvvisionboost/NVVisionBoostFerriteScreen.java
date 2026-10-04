/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostFerriteScreen.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Controles independentes do renderizador; alterações são explícitas e exigem reinício. */
public final class NVVisionBoostFerriteScreen extends Screen {
  private final Screen parent;
  private static final java.util.List<NVVisionBoostFerriteOptions.Option> UI_OPTIONS =
      NVVisionBoostFerriteOptions.ALL.stream().filter(o -> !o.key().equals("useSmallThreadingDetector")).toList();
  private NVVisionBoostFerriteCore.Detection detection;
  private Map<String, Boolean> saved = new LinkedHashMap<>(), staged = new LinkedHashMap<>();
  private int page, preset = -1;
  private boolean ready;
  private String message = "";
  private static final String[] PRESETS = {
    NVVisionBoostUi.text("Recomendado"), NVVisionBoostUi.text("Compatibilidade"), NVVisionBoostUi.text("Economia de RAM"), NVVisionBoostUi.text("Desativado")
  };

  public NVVisionBoostFerriteScreen(Screen parent) {
    super(Component.literal("FerriteCore: memória e compatibilidade"));
    this.parent = parent;
    refresh();
  }

  private void refresh() {
    detection = NVVisionBoostFerriteCore.detect();
    ready = false;
    if (detection.supported())
      try {
        saved = NVVisionBoostFerriteCore.configuration().load();
        staged = new LinkedHashMap<>(saved);
        preset = -1;
        ready = true;
        message = NVVisionBoostUi.text("Alterações exigem reinício completo do Minecraft.");
      } catch (Exception e) {
        message = e.getMessage();
      }
  }

  private Button button(
      String text, int x, int y, int w, Runnable action, boolean enabled, String help) {
    Button b =
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(text),
                ignored -> {
                  action.run();
                  init();
                })
            .bounds(x, y, w, 20)
            .tooltip(NVVisionBoostUi.tooltip(NVVisionBoostUi.component(help)))
            .build();
    b.active = enabled;
    return addRenderableWidget(b);
  }

  private void operation(boolean restore) {
    try {
      var config = NVVisionBoostFerriteCore.configuration();
      if (restore) config.restore();
      else config.apply(staged, saved);
      NVVisionBoostLogger.logSuccess(
          NVVisionBoostUi.text("FerriteCore: ") + (restore ? NVVisionBoostUi.text("restauração") : NVVisionBoostUi.text("configuração salva para reinício")));
      refresh();
      message = NVVisionBoostUi.text("Salvo. Reinicie o Minecraft para aplicar.");
    } catch (Exception e) {
      message = e.getMessage();
      NVVisionBoostLogger.logFailure("FerriteCore", message);
    }
  }

  @Override
  protected void init() {
    clearWidgets();
    NVVisionBoostUi.languages(width, this::init, b -> addRenderableWidget(b));
    int w = Math.max(100, Math.min(480, width - 32)), left = (width - w) / 2;
    int capacity = Math.max(1, (height - 154) / 24),
        pages = (UI_OPTIONS.size() + capacity - 1) / capacity;
    page = Math.min(page, pages - 1);
    button(
        NVVisionBoostUi.text("Preset: ") + (preset < 0 ? NVVisionBoostUi.text("Personalizado") : PRESETS[preset]),
        left,
        51,
        w,
        () -> {
          preset = (preset + 1) % PRESETS.length;
          staged = NVVisionBoostFerriteOptions.preset(preset);
        },
        ready,
        NVVisionBoostUi.text("Só prepara os valores. Clique em Aplicar para salvar. Economia de RAM pode custar CPU."));
    for (int i = page * capacity;
        i < Math.min((page + 1) * capacity, UI_OPTIONS.size());
        i++) {
      var option = UI_OPTIONS.get(i);
      String state = staged.getOrDefault(option.key(), option.initial()) ? NVVisionBoostUi.text("Ligado") : NVVisionBoostUi.text("Desligado");
      button(
          option.label() + NVVisionBoostUi.text(": ") + state,
          left,
          77 + (i % capacity) * 24,
          w,
          () -> NVVisionBoostFerriteOptions.toggle(staged, option),
          ready,
          option.help()
              + NVVisionBoostUi.text(" Reinício obrigatório. Valor carregado: ")
              + detection.runtime().getOrDefault(option.key(), option.initial()));
    }
    int half = (w - 6) / 2;
    button(
        NVVisionBoostUi.text("Aplicar (reiniciar)"),
        left,
        height - 70,
        half,
        () -> operation(false),
        ready && !staged.equals(saved),
        NVVisionBoostUi.text("Não altera caches ou mixins no mundo aberto."));
    button(
        NVVisionBoostUi.text("Restaurar originais"),
        left + half + 6,
        height - 70,
        half,
        () -> operation(true),
        ready,
        NVVisionBoostUi.text("Restaura o primeiro backup. Bloqueia se houver alterações externas."));
    int part = (w - 18) / 4;
    button(
        NVVisionBoostUi.text("Anterior"),
        left,
        height - 44,
        part,
        () -> page = Math.floorMod(page - 1, pages),
        true,
        NVVisionBoostUi.text("Página anterior"));
    button(
        NVVisionBoostUi.text("Atualizar"),
        left + part + 6,
        height - 44,
        part,
        () -> refresh(),
        true,
        NVVisionBoostUi.text("Relê o arquivo e descarta alterações não aplicadas."));
    button(
        NVVisionBoostUi.text("Próxima"),
        left + 2 * (part + 6),
        height - 44,
        part,
        () -> page = (page + 1) % pages,
        true,
        NVVisionBoostUi.text("Próxima página"));
    button(
        NVVisionBoostUi.text("Voltar"),
        left + 3 * (part + 6),
        height - 44,
        part,
        this::onClose,
        true,
        NVVisionBoostUi.text("Alterações não aplicadas serão descartadas."));
  }

  @Override
  public void onClose() {
    Minecraft.getInstance().setScreen(parent);
  }

  @Override
  public void render(GuiGraphics g, int x, int y, float tick) {
    var theme = NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);
    g.fillGradient(0, 0, width, height, theme.background(), theme.header());
    g.drawCenteredString(font, NVVisionBoostUi.component(title.getString()), width / 2, 20, theme.accent());
    g.drawCenteredString(font, clip(detection.status()), width / 2, 31, 0xFFDDDDDD);
    String status =
        ready
            ? (!staged.equals(saved)
                ? NVVisionBoostUi.text("Alterações não aplicadas")
                : !saved.equals(detection.runtime())
                    ? NVVisionBoostUi.text("Reinício pendente")
                    : NVVisionBoostUi.text("Valores da inicialização atual"))
            : NVVisionBoostUi.text("Controles indisponíveis");
    g.drawCenteredString(font, clip(status), width / 2, 41, 0xFFFFCC77);
    g.drawCenteredString(font, clip(message), width / 2, height - 16, 0xFFDDDDDD);
    super.render(g, x, y, tick);
  }

  private String clip(String text) {
    return font.plainSubstrByWidth(
        NVVisionBoostUi.text(text == null ? "Erro de configuração" : text), Math.max(20, width - 16));
  }
}
