package nvvisionboost;

import java.nio.file.*;

public final class NVVisionBoostNeoForgeConfigTest {
  public static void main(String[] args) throws Exception {
    Path root = Path.of(args[0]);
    Files.createDirectories(root);
    System.out.println(
        "PASS FERRITE CONFIG: " + NVVisionBoostFerriteCoreTest.run(root) + " checks.");
  }
}
