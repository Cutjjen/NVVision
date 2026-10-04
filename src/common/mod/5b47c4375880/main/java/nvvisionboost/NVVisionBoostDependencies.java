/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostDependencies.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost; /** NeoForge enforces Sodium on the client; Iris remains optional for shaderpacks. */ public final class NVVisionBoostDependencies { private NVVisionBoostDependencies() {} public static boolean blocked() { return !NVVisionBoostCompatibility.sodium(); } }