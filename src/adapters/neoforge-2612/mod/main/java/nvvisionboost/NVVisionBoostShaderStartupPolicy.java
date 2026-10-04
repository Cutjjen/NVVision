/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostShaderStartupPolicy.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Attempts once per pack/world/pipeline identity, including failed attempts. */
final class NVVisionBoostShaderStartupPolicy {
  private Object world, pipeline;
  private String pack = "";
  private boolean attempted;

  boolean begin(Object currentWorld, String currentPack, Object currentPipeline) {
    if (attempted
        && world == currentWorld
        && pipeline == currentPipeline
        && pack.equals(currentPack)) return false;
    world = currentWorld;
    pack = currentPack;
    pipeline = currentPipeline;
    attempted = true;
    return true;
  }

  void complete(Object preparedPipeline) {
    pipeline = preparedPipeline;
  }

  void reset() {
    world = pipeline = null;
    pack = "";
    attempted = false;
  }
}

