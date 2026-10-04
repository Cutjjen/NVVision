/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostMenuLayoutTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.*;

/** Verifica o layout realmente usado pelos menus em tamanhos e escalas de GUI diferentes. */
public final class NVVisionBoostMenuLayoutTest {
  private static int checks;

  private static void check(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  private static boolean overlap(NVVisionBoostMenuLayout.Rect a, NVVisionBoostMenuLayout.Rect b) {
    return a.x() < b.x() + b.width()
        && b.x() < a.x() + a.width()
        && a.y() < b.y() + b.height()
        && b.y() < a.y() + a.height();
  }

  public static int run() {
    checks = 0;
    for (int width : new int[] {320, 400, 480, 640, 854, 1280, 1920})
      for (int height : new int[] {240, 360, 480, 720}) {
        var layout = NVVisionBoostMenuLayout.of(width, height);
        check(layout.left() >= 0 && layout.right() <= width, "painel dentro da janela");
        check(
            layout.contentWidth() > 0 && layout.bodyBottom() > layout.bodyTop(),
            "área útil positiva");
        for (int i = 0; i < 6; i++) {
          var tab = layout.tab(i);
          check(
              tab.x() >= layout.contentLeft()
                  && tab.x() + tab.width() <= layout.contentLeft() + layout.contentWidth(),
              "aba dentro do painel");
          check(tab.y() + tab.height() < layout.bodyTop(), "aba fora dos controles");
          for (int j = i + 1; j < 6; j++)
            check(!overlap(tab, layout.tab(j)), "abas sem sobreposição");
        }
        int left = layout.contentLeft(),
            column = (layout.contentWidth() - 12) / 2,
            right = left + column + 12;
        List<NVVisionBoostMenuLayout.Rect> source =
            List.of(
                new NVVisionBoostMenuLayout.Rect(right, 124, column, 22),
                new NVVisionBoostMenuLayout.Rect(left, 94, column, 22),
                new NVVisionBoostMenuLayout.Rect(right, 94, column, 22),
                new NVVisionBoostMenuLayout.Rect(left, 124, column, 22),
                new NVVisionBoostMenuLayout.Rect(left, 154, layout.contentWidth(), 22),
                new NVVisionBoostMenuLayout.Rect(left, 194, column, 23),
                new NVVisionBoostMenuLayout.Rect(right, 194, column, 22),
                new NVVisionBoostMenuLayout.Rect(left, 368, layout.contentWidth(), 22));
        var arranged = NVVisionBoostMenuLayout.arrange(layout, source);
        check(arranged.size() == source.size(), "todos os controles preservados");
        int maximum = NVVisionBoostMenuLayout.maxScroll(layout, arranged);
        check(NVVisionBoostMenuLayout.clampScroll(-30, maximum) == 0, "limite superior da rolagem");
        check(
            NVVisionBoostMenuLayout.clampScroll(maximum + 50, maximum) == maximum,
            "limite inferior da rolagem");
        for (int i = 0; i < arranged.size(); i++) {
          var rect = arranged.get(i);
          check(
              rect.x() >= left && rect.x() + rect.width() <= left + layout.contentWidth(),
              "controle dentro do painel");
          boolean reachable = false;
          for (int scroll = 0; scroll <= maximum; scroll++)
            if (NVVisionBoostMenuLayout.visible(layout, rect, scroll)) {
              reachable = true;
              break;
            }
          check(reachable, "controle acessível pela rolagem");
          for (int j = i + 1; j < arranged.size(); j++)
            check(!overlap(rect, arranged.get(j)), "controles sem sobreposição");
        }
        if (layout.singleColumn())
          check(
              arranged.get(1).y() < arranged.get(2).y()
                  && arranged.get(2).y() < arranged.get(3).y(),
              "ordem de leitura consistente na coluna única");
      }
    return checks;
  }

  public static void main(String[] args) {
    System.out.println("PASS: " + run() + " verificações de layout.");
  }
}
