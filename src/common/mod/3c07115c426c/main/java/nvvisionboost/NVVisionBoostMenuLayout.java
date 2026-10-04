/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostMenuLayout.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.*;

/** Geometria independente da API gráfica, compartilhada pelas duas distribuições. */
public final class NVVisionBoostMenuLayout {
  public record Rect(int x, int y, int width, int height) {}

  public record Layout(
      int left,
      int right,
      int contentLeft,
      int contentWidth,
      int bodyTop,
      int bodyBottom,
      int tabColumns,
      boolean singleColumn) {
    public int tabWidth() {
      return (contentWidth - (tabColumns - 1) * 5) / tabColumns;
    }

    public Rect tab(int index) {
      return new Rect(
          contentLeft + (index % tabColumns) * (tabWidth() + 5),
          54 + (index / tabColumns) * 26,
          tabWidth(),
          22);
    }
  }

  public static Layout of(int width, int height) {
    int panel = Math.min(920, Math.max(160, width - 24)),
        left = (width - panel) / 2,
        content = panel - 32;
    int columns = content < 540 ? 3 : 6, top = columns == 3 ? 114 : 88;
    return new Layout(
        left,
        left + panel,
        left + 16,
        content,
        top,
        Math.max(top + 22, height - 72),
        columns,
        content < 600);
  }

  public static List<Rect> arrange(Layout layout, List<Rect> original) {
    List<Rect> result = new ArrayList<>(Collections.nCopies(original.size(), null));
    if (!layout.singleColumn()) {
      for (int i = 0; i < original.size(); i++) {
        Rect rect = original.get(i);
        result.set(
            i, new Rect(rect.x(), layout.bodyTop() + rect.y() - 94, rect.width(), rect.height()));
      }
    } else {
      List<Integer> order = new ArrayList<>();
      for (int i = 0; i < original.size(); i++) order.add(i);
      order.sort(
          Comparator.comparingInt((Integer i) -> original.get(i).y())
              .thenComparingInt(i -> original.get(i).x()));
      int y = layout.bodyTop();
      for (int i : order) {
        Rect rect = original.get(i);
        result.set(i, new Rect(layout.contentLeft(), y, layout.contentWidth(), rect.height()));
        y += Math.max(26, rect.height() + 5);
      }
    }
    return List.copyOf(result);
  }

  public static int maxScroll(Layout layout, List<Rect> rectangles) {
    return Math.max(
        0,
        rectangles.stream().mapToInt(r -> r.y() + r.height()).max().orElse(layout.bodyTop())
            - layout.bodyBottom());
  }

  public static int clampScroll(int value, int maximum) {
    return Math.max(0, Math.min(Math.max(0, maximum), value));
  }

  public static boolean visible(Layout layout, Rect rect, int scroll) {
    return rect.y() - scroll >= layout.bodyTop()
        && rect.y() - scroll + rect.height() <= layout.bodyBottom();
  }

  private NVVisionBoostMenuLayout() {}
}
