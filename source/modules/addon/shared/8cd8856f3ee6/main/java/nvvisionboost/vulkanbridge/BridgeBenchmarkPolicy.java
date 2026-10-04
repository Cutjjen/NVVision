package nvvisionboost.vulkanbridge;

/** A failed Vulkan bootstrap or interrupted session must not be reported as a valid comparison. */
final class BridgeBenchmarkPolicy {
  private BridgeBenchmarkPolicy() {}

  static boolean valid(
      int frames,
      int capacity,
      double sampledMs,
      double requiredMs,
      String requested,
      String actual) {
    return frames >= 120
        && frames < capacity
        && Double.isFinite(sampledMs)
        && Double.isFinite(requiredMs)
        && requiredMs > 0
        && sampledMs >= requiredMs * .95
        && ("opengl".equals(actual) || "zink".equals(actual))
        && ("auto".equals(requested) || actual.equals(requested));
  }
}
