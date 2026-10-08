package nvvisionboost;

import java.nio.file.Path;

/**
 * Compatibility facade retained because older NVVisionBoost classes may still reference this class.
 *
 * <p>IMPORTANT:
 *
 * <p>NVVisionBoost no longer owns shaderpack rendering.
 *
 * <p>Oculus is the only component responsible for: - shaderpack activation; - shader program
 * creation; - shader pipeline; - world shader rendering.
 */
public final class NVVisionBoostNativeShaderPackRuntime {
  private NVVisionBoostNativeShaderPackRuntime() {}

  /**
   * Kept for binary/source compatibility.
   *
   * <p>This method MUST NOT manipulate Oculus.
   */
  public static synchronized void clear() {
    /*
     * Intentionally empty.
     *
     * Older versions destroyed the native runtime here.
     * There is no native shader runtime anymore.
     */
  }

  /**
   * Legacy compatibility method.
   *
   * <p>It deliberately does not activate anything.
   */
  public static synchronized String activate(Path pack) {
    if (pack == null) {
      return "Nenhum shaderpack informado.";
    }

    return "Renderer nativo de shader desativado. "
        + "Oculus é responsável por carregar e renderizar shaders.";
  }

  /** NVVisionBoost must never report its old shader renderer as active. */
  public static synchronized boolean isActive() {
    return false;
  }

  /**
   * The active shader belongs to Oculus.
   *
   * <p>Do not maintain a second active shader state here.
   */
  public static synchronized String activeName() {
    return "";
  }

  public static synchronized String status() {
    if (NVVisionBoostCompatibility.externalShaderBackendAvailable()) {
      return NVVisionBoostCompatibility.shaderBackend()
          + " carregado; shader ativo="
          + NVVisionBoostCompatibility.externalShadersInUse()
          + ". O backend renderiza o shaderpack.";
    }

    return "Backend de shaders não detectado; NVVisionBoost não aplica shaderpacks.";
  }

  public static synchronized String capabilitySummary() {
    return status();
  }

  /**
   * Legacy renderer hook.
   *
   * <p>Returning false prevents the NVVisionBoost render pipeline from treating this class as an
   * active shaderpack renderer.
   */
  public static synchronized boolean render(
      int inputTexture, int depthTexture, int width, int height) {
    return false;
  }

  /** No native shader output texture exists anymore. */
  public static synchronized int resultTexture() {
    return 0;
  }
}
