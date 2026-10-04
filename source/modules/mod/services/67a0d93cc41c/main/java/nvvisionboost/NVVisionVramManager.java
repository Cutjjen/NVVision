package nvvisionboost;

/** Consulta VRAM real; o orçamento informado não aloca memória no driver. */
public final class NVVisionVramManager {
  private static volatile long manualVramMb = -1;

  private NVVisionVramManager() {}

  public static long getDetectedVramMb() {
    return NVVisionBoostGPU.detect().totalMemoryMB;
  }

  /** API legada: orçamento consultivo, sem reserva de VRAM. -1 significa desconhecido. */
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
