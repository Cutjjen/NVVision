package nvvisionboost.legacy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java 8 regression: independent controls, persisted language and unrelated configuration safety.
 */
public final class LegacyConfigTest {
  public static void main(String[] args) throws Exception {
    Path root = Paths.get(args[0]);
    Files.createDirectories(root);
    Path marker = root.resolve("options.txt");
    Files.write(marker, "unchanged".getBytes("UTF-8"));
    LegacyConfig.load(root);
    LegacyConfig.cpuPreset(2);
    if (LegacyConfig.particles != 2 || LegacyConfig.entities != 2)
      throw new AssertionError("preset");
    LegacyConfig.particles = 1;
    LegacyConfig.entities = 0;
    LegacyConfig.english = true;
    LegacyConfig.save();
    LegacyConfig.particles = 0;
    LegacyConfig.english = false;
    LegacyConfig.load(root);
    if (LegacyConfig.particles != 1 || LegacyConfig.entities != 0 || !LegacyConfig.english)
      throw new AssertionError("persistence");
    if (!"unchanged".equals(new String(Files.readAllBytes(marker), "UTF-8")))
      throw new AssertionError("external configuration changed");
    System.out.println(
        "PASS legacy Java 8 settings, independent controls and configuration isolation");
  }
}
