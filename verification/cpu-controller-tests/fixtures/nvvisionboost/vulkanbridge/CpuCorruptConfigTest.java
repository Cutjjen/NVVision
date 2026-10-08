package nvvisionboost.vulkanbridge;

import java.nio.file.Files;

/** Verifies that malformed user configuration cannot crash or partially apply CPU settings. */
public final class CpuCorruptConfigTest {
  public static void main(String[] args) throws Exception {
    var directory = Files.createTempDirectory("nvvision-cpu-invalid-");
    var config = directory.resolve("cpu.properties");
    String invalid = "profile=economy\nuser.value=\\uZZZZ\n";
    Files.writeString(config, invalid);
    BridgeCpuOptimizer.initialize(directory);
    if (!BridgeCpuOptimizer.initialized() || !BridgeCpuOptimizer.mode().equals("off"))
      throw new AssertionError("Malformed configuration must initialize with controls off");
    BridgeCpuOptimizer.request("economy");
    if (!BridgeCpuOptimizer.mode().equals("off") || !Files.readString(config).equals(invalid))
      throw new AssertionError(
          "A failed save cannot apply the profile or overwrite the user's file");
    System.out.println(
        "PASS CPU malformed configuration: safe initialization, no partial application, original"
            + " file preserved");
  }
}
