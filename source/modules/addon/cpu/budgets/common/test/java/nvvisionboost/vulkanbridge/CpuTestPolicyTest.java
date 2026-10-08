package nvvisionboost.vulkanbridge;

/** Boundaries protect remote simulation, unknown renderers and disabled budgets. */
public final class CpuTestPolicyTest {
  public static void main(String[] args) {
    if (CpuTestPolicy.simulation(12, 6, false) != 12)
      throw new AssertionError("Remote server modified");
    if (CpuTestPolicy.simulation(12, 6, true) != 6)
      throw new AssertionError("Local ceiling missing");
    if (CpuTestPolicy.simulation(5, 10, true) != 5)
      throw new AssertionError("Increased simulation");
    if (CpuTestPolicy.normalize("simulation", -1) != 0)
      throw new AssertionError("Invalid choice enabled");
    if (CpuTestPolicy.next("models", 0) != 64 || CpuTestPolicy.next("models", 32) != 0)
      throw new AssertionError("Cycle");
    if (CpuTestPolicy.supportedModelNamespace("create")
        || CpuTestPolicy.supportedModelNamespace("unknown"))
      throw new AssertionError("Unknown models filtered");
    if (!CpuTestPolicy.supportedModelNamespace("storagedrawers"))
      throw new AssertionError("Standard adapter missing");
    if (CpuTestPolicy.outside(100000, 0)
        || CpuTestPolicy.outside(256, 16)
        || !CpuTestPolicy.outside(257, 16)) throw new AssertionError("Distance boundary");
    System.out.println(
        "PASS CPU test budgets: local/remote simulation, disabled/invalid choices, cycles, mod"
            + " scopes and distance boundaries");
  }
}
