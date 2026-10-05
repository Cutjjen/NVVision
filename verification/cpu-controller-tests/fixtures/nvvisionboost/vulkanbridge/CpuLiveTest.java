package nvvisionboost.vulkanbridge;

import java.nio.file.*;
import net.minecraft.client.*;

public final class CpuLiveTest {
  static int checks;

  static void check(boolean v, String m) {
    if (!v) throw new AssertionError(m);
    checks++;
  }

  public static void main(String[] args) throws Exception {
    Path dir = Files.createTempDirectory("nvvision-cpu-live-");
    BridgeCpuOptimizer.initialize(dir);
    var mc = Minecraft.getInstance();
    BridgeCpuOptimizer.request("balanced");
    check(mc.options.entityDistanceScaling().get() == .75, "Balanced distance immediate");
    check(mc.options.particles().get() == ParticleStatus.DECREASED, "Balanced particles immediate");
    BridgeCpuOptimizer.request("economy");
    check(mc.options.entityDistanceScaling().get() == .5, "Economy distance immediate");
    check(mc.options.particles().get() == ParticleStatus.MINIMAL, "Economy particles immediate");
    BridgeCpuOptimizer.request("off");
    check(mc.options.entityDistanceScaling().get() == 1.0, "Off restores distance immediately");
    check(mc.options.particles().get() == ParticleStatus.ALL, "Off restores particles immediately");
    BridgeCpuOptimizer.cycleControl("distance");
    check(mc.options.entityDistanceScaling().get() == .75, "Individual distance immediate");
    BridgeCpuOptimizer.cycleControl("particles");
    check(
        mc.options.particles().get() == ParticleStatus.DECREASED, "Individual particles immediate");
    mc.options.entityDistanceScaling().set(1.25);
    BridgeCpuOptimizer.request("off");
    check(mc.options.entityDistanceScaling().get() == 1.25, "Later user change preserved");
    BridgeCpuOptimizer.cycleControl("distance");
    check(mc.options.entityDistanceScaling().get() == .5, "Lowest valid entity distance");
    BridgeCpuOptimizer.cycleControl("distance");
    check(
        BridgeCpuOptimizer.control("distance").equals("off"),
        "Distance cycle has no unsupported 25 percent");
    mc.sameThread = false;
    double before = mc.options.entityDistanceScaling().get();
    BridgeCpuOptimizer.request("economy");
    check(
        mc.options.entityDistanceScaling().get() == before, "No option writes on a foreign thread");
    check(mc.pending != null, "Client application scheduled");
    mc.drain();
    check(mc.options.entityDistanceScaling().get() == .5, "Scheduled client application");
    BridgeCpuOptimizer.request("off");
    check(
        mc.options.entityDistanceScaling().get() == before, "Scheduled profile restores original");
    System.out.println("PASS CPU LIVE: " + checks + " checks; no tick or restart between requests");
  }
}
