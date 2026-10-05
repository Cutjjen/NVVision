package nvvisionboost;

/** World pixel contract preserves shadow buffers and partial viewports. */
public final class NVVisionBoostPixelAdapter {
  private NVVisionBoostPixelAdapter() {}

  public static boolean nativeViewportOnReducedTarget(
      int x,
      int y,
      int width,
      int height,
      int nativeWidth,
      int nativeHeight,
      int targetWidth,
      int targetHeight) {
    return x == 0
        && y == 0
        && width == nativeWidth
        && height == nativeHeight
        && targetWidth > 0
        && targetHeight > 0
        && (targetWidth != nativeWidth || targetHeight != nativeHeight);
  }
}
