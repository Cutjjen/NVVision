/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: bootstrap/java/nvvisionboost/vulkanbridge/bootstrap/BridgeEnvironment.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.bootstrap;

/** Process-local environment setup before Mesa/GLFW loads. Never touches registry or user settings. */
final class BridgeEnvironment {
  private BridgeEnvironment() {}
  static native boolean prepare(String cacheDirectory, String descriptors);
}
