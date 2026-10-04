/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: test/java/nvvisionboost/vulkanbridge/BridgeRegressionTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;

import java.nio.file.*;

public final class BridgeRegressionTest {
  private static int checks;

  private static void check(boolean result) {
    if (!result) throw new AssertionError("Check " + checks);
    checks++;
  }

  public static void main(String[] args) throws Exception {
    check(BridgePolicy.translated("zink Vulkan NVIDIA RTX", "4.6 Mesa", true, true));
    check(!BridgePolicy.translated("NVIDIA RTX", "4.6", true, true));
    check(!BridgePolicy.translated("zink lavapipe", "4.6 Mesa", true, true));
    check(!BridgePolicy.translated("zink llvmpipe", "4.6 Mesa", true, true));
    check(!BridgePolicy.translated("zink AMD", "4.6 Mesa", false, true));
    check(!BridgePolicy.translated("zink Intel", "4.6 Mesa", true, false));
    Path root = Path.of(args[0]);
    Files.createDirectories(root);
    BridgeFiles.atomic(root.resolve("bridge.properties"), "backend=opengl\ncustom=value\n");
    BridgeFiles.backend(root, "zink");
    check(BridgeFiles.profile(root).getProperty("custom").equals("value"));
    check(BridgeFiles.profile(root).getProperty("backend").equals("zink"));
    byte[] before = Files.readAllBytes(root.resolve("bridge.properties"));
    boolean invalid = false;
    try {
      BridgeFiles.backend(root, "invalid");
    } catch (IllegalArgumentException expected) {
      invalid = true;
    }
    check(invalid);
    check(java.util.Arrays.equals(before, Files.readAllBytes(root.resolve("bridge.properties"))));
    BridgeFiles.backend(root, "opengl");
    check(BridgeFiles.profile(root).getProperty("backend").equals("opengl"));
    check(BridgeApi.snapshot().get("dlss").equals("unavailable"));
    check(BridgeApi.snapshot().get("framegen").equals("unavailable"));
    BridgeFiles.descriptors(root, "lazy");
    check(BridgeFiles.profile(root).getProperty("backend").equals("opengl"));
    check(BridgeFiles.profile(root).getProperty("descriptors").equals("lazy"));
    before = Files.readAllBytes(root.resolve("bridge.properties"));
    invalid = false;
    try {
      BridgeFiles.descriptors(root, "unknown");
    } catch (IllegalArgumentException expected) {
      invalid = true;
    }
    check(invalid);
    check(java.util.Arrays.equals(before, Files.readAllBytes(root.resolve("bridge.properties"))));
    check(BridgeBenchmarkPolicy.valid(120, 300000, 171000, 180000, "zink", "zink"));
    check(!BridgeBenchmarkPolicy.valid(120, 300000, 170999, 180000, "zink", "zink"));
    check(!BridgeBenchmarkPolicy.valid(120, 300000, 180000, 180000, "zink", "opengl"));
    check(!BridgeBenchmarkPolicy.valid(120, 300000, 180000, 180000, "auto", "unknown"));
    check(!BridgeBenchmarkPolicy.valid(300000, 300000, 180000, 180000, "auto", "zink"));
    check(!BridgeBenchmarkPolicy.valid(119, 300000, 180000, 180000, "auto", "zink"));
    check(!BridgeBenchmarkPolicy.valid(120, 300000, Double.NaN, 180000, "auto", "zink"));
    check(BridgeBenchmarkPolicy.valid(120, 300000, 180000, 180000, "auto", "opengl"));
    System.out.println("PASS BRIDGE: " + checks + " checks.");
  }
}
