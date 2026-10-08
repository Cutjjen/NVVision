package nvvisionboost.vulkanbridge;

import java.nio.file.Files;
import net.minecraft.client.Minecraft;
import net.minecraft.client.ParticleStatus;

/** Verifies restoration and persistence at shutdown without overwriting external changes. */
public final class CpuShutdownTest {
  public static void main(String[] args) throws Exception {
    BridgeCpuOptimizer.initialize(Files.createTempDirectory("nvvision-cpu-shutdown-"));
    var client = Minecraft.getInstance();
    BridgeCpuOptimizer.request("economy");
    BridgeCpuOptimizer.shutdown();
    if (client.options.entityDistanceScaling().get() != 1.0
        || client.options.particles().get() != ParticleStatus.ALL
        || client.options.saves != 1)
      throw new AssertionError("Shutdown must restore and save owned options");
    BridgeCpuOptimizer.shutdown();
    if (client.options.saves != 1)
      throw new AssertionError("Shutdown with no owned options must not save again");
    BridgeCpuOptimizer.request("economy");
    client.options.entityDistanceScaling().set(1.25);
    BridgeCpuOptimizer.shutdown();
    if (client.options.entityDistanceScaling().get() != 1.25)
      throw new AssertionError("Shutdown must preserve a later external change");
    System.out.println(
        "PASS CPU shutdown: restoration, persistence, idempotence and external changes");
  }
}
