package nvvisionboost;

/** Query VRAM; the reported budget does not allocate driver memory. */
public final class NVVisionVramManager {
  private static volatile long manualVramMb = -1;

  private NVVisionVramManager() {}

  public static long getDetectedVramMb() {
    return NVVisionBoostGPU.detect().totalMemoryMB;
  }

  /** Legacy advisory budget API without VRAM reservation; -1 means unknown. */
  public static long getAllocatedVramMb() {
    long detected = getDetectedVramMb();
    if (manualVramMb > 0) return detected > 0 ? Math.min(manualVramMb, detected) : manualVramMb;
    return detected > 0 ? Math.min(detected, 4096) : -1;
  }

  public static void setManualVramAllocation(long value) {
    manualVramMb = value > 0 ? value : -1;
  }

  public static void analyzeAndAllocateVram() {
    NVVisionBoostGPU.detect();
  }
}
