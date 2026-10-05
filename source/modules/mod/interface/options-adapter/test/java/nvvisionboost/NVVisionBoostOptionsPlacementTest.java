package nvvisionboost;

import java.util.*;

public final class NVVisionBoostOptionsPlacementTest {
  public static void main(String[] args) {
    var boxes = new ArrayList<NVVisionBoostOptionsPlacement.Rect>();
    for (int y : new int[] {80, 104, 128, 152}) {
      boxes.add(new NVVisionBoostOptionsPlacement.Rect(270, y, 150, 20));
      boxes.add(new NVVisionBoostOptionsPlacement.Rect(428, y, 150, 20));
    }
    boxes.add(new NVVisionBoostOptionsPlacement.Rect(270, 176, 150, 20));
    boxes.add(new NVVisionBoostOptionsPlacement.Rect(350, 470, 150, 20));
    var snapshot = List.copyOf(boxes);
    var result = NVVisionBoostOptionsPlacement.place(820, 500, boxes).orElseThrow();
    if (result.x() != 428 || result.y() != 176 || !boxes.equals(snapshot))
      throw new AssertionError("Customized options row/vanilla widgets changed");
    boxes.add(result);
    var fallback = NVVisionBoostOptionsPlacement.place(820, 500, boxes).orElseThrow();
    if (boxes.stream().anyMatch(fallback::overlaps)) throw new AssertionError("Fallback overlap");
    if (NVVisionBoostOptionsPlacement.place(20, 20, List.of()).isPresent())
      throw new AssertionError("Tiny screen overflow");
    for (int width : new int[] {320, 480, 640}) {
      int left = width / 2 - 155, right = left + 160;
      var vanilla = new ArrayList<NVVisionBoostOptionsPlacement.Rect>();
      vanilla.add(new NVVisionBoostOptionsPlacement.Rect(left, 24, 150, 20));
      vanilla.add(new NVVisionBoostOptionsPlacement.Rect(right, 24, 150, 20));
      for (int y : new int[] {80, 104, 128, 152, 176}) {
        vanilla.add(new NVVisionBoostOptionsPlacement.Rect(left, y, 150, 20));
        vanilla.add(new NVVisionBoostOptionsPlacement.Rect(right, y, 150, 20));
      }
      vanilla.add(new NVVisionBoostOptionsPlacement.Rect(width / 2 - 100, 212, 200, 20));
      var original = List.copyOf(vanilla);
      var centered = NVVisionBoostOptionsPlacement.place(width, 240, vanilla).orElseThrow();
      if (centered.x() != left || centered.y() != 52 || centered.width() != 310)
        throw new AssertionError("Full vanilla grid must use centered reserved row");
      if (!vanilla.equals(original) || vanilla.stream().anyMatch(centered::overlaps))
        throw new AssertionError("Existing controls changed or overlapped");
      if (!centered.equals(NVVisionBoostOptionsPlacement.place(width, 240, vanilla).orElseThrow()))
        throw new AssertionError("Repeated placement moved a stable layout");
      vanilla.add(centered);
      var occupiedGap = NVVisionBoostOptionsPlacement.place(width, 240, vanilla);
      if (occupiedGap.isPresent() && vanilla.stream().anyMatch(occupiedGap.get()::overlaps))
        throw new AssertionError("Another mod's reserved-row button overlapped");
    }
    System.out.println(
        "PASS options placement: full vanilla grid, real column gap, stable placement, customized"
            + " grid, occupied row and tiny screen");
  }
}
