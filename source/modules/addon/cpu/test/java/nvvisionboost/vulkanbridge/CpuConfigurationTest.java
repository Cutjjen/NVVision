package nvvisionboost.vulkanbridge;

import java.nio.file.*;
import java.util.Properties;

public final class CpuConfigurationTest {
  private static int checks;

  private static void check(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  public static void main(String[] args) throws Exception {
    Path directory = Path.of(args[0]);
    Files.createDirectories(directory);
    Files.writeString(directory.resolve("cpu.properties"), "profile=off\nuser.extra=preserve\n");
    BridgeCpuOptimizer.initialize(directory);
    check(BridgeCpuOptimizer.mode().equals("off"), "Default off");
    check(BridgeCpuOptimizer.control("distance").equals("off"), "Old configuration migration");
    BridgeCpuOptimizer.cycleControl("distance");
    check(BridgeCpuOptimizer.mode().equals("custom"), "Individual control selects custom");
    check(BridgeCpuOptimizer.control("distance").equals("75%"), "Distance only");
    check(BridgeCpuOptimizer.control("particles").equals("off"), "Particles independent");
    BridgeCpuOptimizer.cycleControl("particles");
    check(BridgeCpuOptimizer.control("distance").equals("75%"), "Particle control keeps distance");
    check(BridgeCpuOptimizer.control("particles").equals("decreased"), "Particle control");
    BridgeCpuOptimizer.request("economy");
    check(BridgeCpuOptimizer.control("distance").equals("75%"), "Preset retains custom values");
    BridgeCpuOptimizer.request("custom");
    check(BridgeCpuOptimizer.mode().equals("custom"), "Custom can be restored");
    for (int i = 0; i < 4 && !BridgeCpuOptimizer.control("distance").equals("off"); i++)
      BridgeCpuOptimizer.cycleControl("distance");
    check(
        BridgeCpuOptimizer.control("distance").equals("off"),
        "Distance can be disabled independently");
    check(
        BridgeCpuOptimizer.control("particles").equals("decreased"),
        "Disabling distance retains particles");
    String before = Files.readString(directory.resolve("cpu.properties"));
    BridgeCpuOptimizer.cycleControl("invalid");
    BridgeCpuOptimizer.request("invalid");
    check(
        before.equals(Files.readString(directory.resolve("cpu.properties"))),
        "Invalid requests cannot change saved config");
    Properties p = new Properties();
    try (var in = Files.newInputStream(directory.resolve("cpu.properties"))) {
      p.load(in);
    }
    check(p.getProperty("user.extra").equals("preserve"), "Unknown user keys preserved");
    check(
        p.getProperty("profile").equals("custom")
            && p.getProperty("particles").equals("decreased")
            && p.getProperty("distance").equals("off"),
        "Independent settings persisted");
    System.out.println("PASS CPU configuration: " + checks + " checks");
  }
}
