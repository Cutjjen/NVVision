/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostNeoForgeConfigTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;
import java.nio.file.*;
public final class NVVisionBoostNeoForgeConfigTest {
  public static void main(String[] args) throws Exception {
    Path root=Path.of(args[0]);Files.createDirectories(root);
    System.out.println("PASS FERRITE CONFIG: "+NVVisionBoostFerriteCoreTest.run(root)+" checks.");
  }
}
