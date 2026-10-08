package nvvisionboost;

import java.util.List;
import java.util.Optional;

/** Places only our entry; never resizes or relocates another mod's widgets. */
public final class NVVisionBoostOptionsPlacement {
  public record Rect(int x, int y, int width, int height) {
    boolean overlaps(Rect other) {
      return x < other.x + other.width + 2
          && x + width + 2 > other.x
          && y < other.y + other.height + 2
          && y + height + 2 > other.y;
    }
  }

  private static boolean free(Rect candidate, int width, int height, List<Rect> occupied) {
    return candidate.x >= 4
        && candidate.y >= 4
        && candidate.x + candidate.width <= width - 4
        && candidate.y + candidate.height <= height - 4
        && occupied.stream().noneMatch(candidate::overlaps);
  }

  public static Optional<Rect> place(int width, int height, List<Rect> occupied) {
    Rect best = null;
    for (Rect left : occupied) {
      if (left.width < 80 || left.width > 160 || left.y < 35) continue;
      var partner = columnPartner(left, occupied);
      if (partner.isEmpty()) continue;
      Rect candidate = new Rect(partner.get().x, left.y, left.width, 20);
      if (free(candidate, width, height, occupied) && (best == null || candidate.y > best.y))
        best = candidate;
    }
    if (best != null) return Optional.of(best);

    // A complete two-column grid can still leave a centered row below the top controls.
    // Try those real widget boundaries before the edge fallback; do not move vanilla widgets.
    for (Rect left : occupied) {
      if (left.y < 35) continue;
      var partner = columnPartner(left, occupied);
      if (partner.isEmpty()) continue;
      int rowWidth = partner.get().x + partner.get().width - left.x;
      for (int y :
          occupied.stream()
              .mapToInt(rect -> rect.y + rect.height + 8)
              .sorted()
              .distinct()
              .toArray()) {
        if (y < 35) continue;
        Rect candidate = new Rect(left.x, y, rowWidth, 20);
        if (free(candidate, width, height, occupied)) return Optional.of(candidate);
      }
    }
    int buttonWidth = Math.min(100, width - 16);
    if (buttonWidth < 40) return Optional.empty();
    for (int y = 8; y + 20 <= height - 4; y += 24) {
      Rect candidate = new Rect(width - buttonWidth - 8, y, buttonWidth, 20);
      if (free(candidate, width, height, occupied)) return Optional.of(candidate);
    }
    return Optional.empty(); // F8 remains available when a customized screen has no free space.
  }

  /** Derive column spacing from another actual row, including vanilla's ten-pixel gap. */
  private static Optional<Rect> columnPartner(Rect left, List<Rect> occupied) {
    if (left.width < 80 || left.width > 160) return Optional.empty();
    for (Rect row : occupied) {
      if (row.x != left.x || row.width != left.width || row.y == left.y) continue;
      for (Rect right : occupied) {
        int gap = right.x - row.x - row.width;
        if (right.y == row.y && Math.abs(right.width - left.width) <= 2 && gap >= 6 && gap <= 24)
          return Optional.of(right);
      }
    }
    return Optional.empty();
  }

  private NVVisionBoostOptionsPlacement() {}
}
