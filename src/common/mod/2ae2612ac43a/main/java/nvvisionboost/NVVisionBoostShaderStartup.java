/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostShaderStartup.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Fabric leaves shader pipeline creation and reload exclusively to Iris. */
public final class NVVisionBoostShaderStartup {
 private static String status="Iris controla a criação e a recarga do pipeline.";
 private NVVisionBoostShaderStartup() {}
 public static void beforeRender() {
   // No preparePipeline, shader activation or GL state mutation during vanilla resource reload.
 }
 public static String status() { return status; }
}
