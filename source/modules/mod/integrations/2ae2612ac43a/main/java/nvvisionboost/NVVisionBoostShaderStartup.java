package nvvisionboost;

/** Fabric leaves shader pipeline creation and reload exclusively to Iris. */
public final class NVVisionBoostShaderStartup {
  private static String status = "Iris controla a criação e a recarga do pipeline.";

  private NVVisionBoostShaderStartup() {}

  public static void beforeRender() {
    // No preparePipeline, shader activation or GL state mutation during vanilla resource reload.
  }

  public static String status() {
    return status;
  }
}
