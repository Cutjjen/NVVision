package nvvisionboost;

/** Validates the local alternative renderer gate without starting Minecraft. */
public final class NVVisionBoostRubidiumDependencyTest {
  public static void main(String[] args) {
    if (!NVVisionBoostDependencies.accepts(false, true))
      throw new AssertionError("Rubidium alone must start");
    if (!NVVisionBoostDependencies.accepts(true, false))
      throw new AssertionError("Embeddium alternative must start");
    if (NVVisionBoostDependencies.accepts(false, false))
      throw new AssertionError("Missing renderer must block");
    if (!NVVisionBoostDependencies.accepts(true, true))
      throw new AssertionError("Renderer aliases must not block the gate");
    System.out.println("PASS Rubidium dependency gate: 4 cases");
  }
}
