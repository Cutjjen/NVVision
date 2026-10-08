package nvvisionboost;

import java.util.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class NVVisionBoostVulkanBridgeScreen extends Screen {
  private final Screen parent;
  private String message =
      NVVisionBoostLanguage.english()
          ? "Change CPU controls in the Processor tab. Model budgets are suspended with protected"
              + " renderers."
          : "Ajuste os controles na aba Processador. Modelos ficam suspensos com renderizadores"
              + " protegidos.";
  private int offset;

  public NVVisionBoostVulkanBridgeScreen(Screen parent) {
    super(
        Component.literal(
            NVVisionBoostLanguage.english()
                ? "NVVision Addon — Diagnostics"
                : "NVVision Addon — Diagnóstico"));
    this.parent = parent;
  }

  @Override
  protected void init() {
    clearWidgets();
    NVVisionBoostUi.languages(width, this::init, b -> addRenderableWidget(b));
    int w = Math.max(100, Math.min(440, width - 24)), left = (width - w) / 2;
    addRenderableWidget(
        NVVisionBoostMenuButton.builder(
                NVVisionBoostUi.component(NVVisionBoostUi.text("Voltar")), ignored -> onClose())
            .bounds(left, height - 34, w, 20)
            .build());
  }

  private List<String> lines() {
    var s = NVVisionBoostVulkanBridge.status();
    List<String> lines = new ArrayList<>();
    lines.add(NVVisionBoostUi.text("Addon: ") + s.getOrDefault("state", "unknown"));
    lines.add(NVVisionBoostUi.text("Backend observado: ") + s.getOrDefault("backend", "unknown"));
    lines.add(
        NVVisionBoostUi.text("GPU: ")
            + s.getOrDefault("renderer", NVVisionBoostUi.text("Aguardando detecção")));
    lines.add(NVVisionBoostUi.text("API: ") + s.getOrDefault("version", "—"));
    lines.add(NVVisionBoostUi.text("CPU: ") + NVVisionBoostVulkanBridge.cpuProfile());
    lines.add(
        NVVisionBoostUi.text("Entidades: ") + NVVisionBoostVulkanBridge.cpuControl("distance"));
    lines.add(
        NVVisionBoostUi.text("Partículas: ") + NVVisionBoostVulkanBridge.cpuControl("particles"));
    lines.add(
        "Modelos: alcance aplicado="
            + NVVisionBoostCpuTestAdapter.modelRadius()
            + " blocos (0 = desligado ou protegido).");
    lines.add(message);
    return lines;
  }

  @Override
  public boolean mouseScrolled(double x, double y, double horizontal, double delta) {
    offset = Math.max(0, offset + (delta < 0 ? 1 : -1));
    return true;
  }

  @Override
  public void render(GuiGraphics g, int x, int y, float tick) {
    var theme = NVVisionBoostGpuTheme.forBrand(NVVisionBoostGPU.detect().brand);
    g.fillGradient(0, 0, width, height, theme.background(), theme.header());
    g.drawCenteredString(
        font, NVVisionBoostUi.component(title.getString()), width / 2, 20, theme.accent());
    List<net.minecraft.util.FormattedCharSequence> rows = new ArrayList<>();
    for (String line : lines())
      for (var part : font.split(NVVisionBoostUi.component(line), Math.max(60, width - 32)))
        rows.add(part);
    int capacity = Math.max(1, (height - 146) / 13);
    offset = Math.min(offset, Math.max(0, rows.size() - capacity));
    for (int i = 0; i < capacity && i + offset < rows.size(); i++)
      g.drawString(font, rows.get(i + offset), 16, 34 + i * 13, 0xDDDDDD, false);
    super.render(g, x, y, tick);
  }

  @Override
  public void onClose() {
    nvvisionboost.minecraft.MinecraftAccess.get().openScreen(parent);
  }
}
