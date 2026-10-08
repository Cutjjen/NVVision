package nvvisionboost;

/** Pixel-contract regressions without a GPU dependency. */
public final class NVVisionBoostPixelAdapterTest {
  public static void main(String[] args) {
    check(true, 0, 0, 1920, 1080, 1632, 918);
    check(false, 0, 0, 1632, 918, 1632, 918);
    check(false, 10, 0, 1920, 1080, 1632, 918);
    check(false, 0, 10, 1920, 1080, 1632, 918);
    check(false, 0, 0, 1024, 1024, 1632, 918);
    check(false, 0, 0, 1920, 1080, 1920, 1080);
    check(false, 0, 0, 1920, 1080, 0, 918);
    check(false, 0, 0, 1920, 1080, 1632, 0);
    check(false, 0, 0, 960, 540, 1632, 918);
    System.out.println("Pixel adapter: 9 assertions passed");
  }

  private static void check(boolean expected, int x, int y, int w, int h, int tw, int th) {
    if (NVVisionBoostPixelAdapter.nativeViewportOnReducedTarget(x, y, w, h, 1920, 1080, tw, th)
        != expected) throw new AssertionError("Unexpected viewport adaptation");
  }
}
