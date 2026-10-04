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
      int right = left.x + left.width + 8;
      boolean pairedColumn =
          occupied.stream()
              .anyMatch(
                  a ->
                      a.x == left.x
                          && a.y != left.y
                          && occupied.stream()
                              .anyMatch(b -> Math.abs(b.x - right) <= 2 && b.y == a.y));
      Rect candidate = new Rect(right, left.y, left.width, 20);
      if (pairedColumn
          && free(candidate, width, height, occupied)
          && (best == null || candidate.y > best.y)) best = candidate;
    }
    if (best != null) return Optional.of(best);
    int buttonWidth = Math.min(100, width - 16);
    if (buttonWidth < 40) return Optional.empty();
    for (int y = 8; y + 20 <= height - 4; y += 24) {
      Rect candidate = new Rect(width - buttonWidth - 8, y, buttonWidth, 20);
      if (free(candidate, width, height, occupied)) return Optional.of(candidate);
    }
    return Optional.empty(); // F8 remains available when a customized screen has no free space.
  }

  private NVVisionBoostOptionsPlacement() {}
}
