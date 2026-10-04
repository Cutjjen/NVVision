package nvvisionboost.vulkanbridge;

public final class CpuPolicyTest {
  private static int checks;

  private static void check(boolean value, String label) {
    if (!value) throw new AssertionError(label);
    checks++;
  }

  public static void main(String[] args) {
    check(!CpuPolicy.validProfile(null), "Missing profile rejected");
    check(CpuPolicy.distance(null).equals("off"), "Missing distance disabled");
    check(CpuPolicy.particles(null).equals("off"), "Missing particles disabled");
    check(CpuPolicy.distanceCeiling(null, "50%") == -1, "Missing profile cannot control distance");
    check(
        CpuPolicy.particleLimit(null, "minimal").equals("off"),
        "Missing profile cannot control particles");
    check(CpuPolicy.distance("25%").equals("50%"), "Legacy distance migration");
    check(CpuPolicy.distance("invalid").equals("off"), "Invalid distance disabled");
    check(CpuPolicy.particles("invalid").equals("off"), "Invalid particles disabled");
    check(!CpuPolicy.validProfile("invalid"), "Invalid profile rejected");
    check(CpuPolicy.nextDistance("off").equals("75%"), "Distance first step");
    check(CpuPolicy.nextDistance("75%").equals("50%"), "Distance second step");
    check(CpuPolicy.nextDistance("50%").equals("off"), "Distance cycle excludes 25 percent");
    check(CpuPolicy.distanceCeiling("balanced", "off") == .75, "Balanced distance");
    check(CpuPolicy.distanceCeiling("economy", "off") == .5, "Economy distance");
    check(CpuPolicy.distanceCeiling("off", "50%") == -1, "Off cannot apply custom");
    check(
        CpuPolicy.distanceCeiling("custom", "off") == -1, "Custom distance independently disabled");
    check(CpuPolicy.distanceCeiling("custom", "25%") == .5, "Legacy custom valid");
    check(CpuPolicy.validDistance(1, .75) == .75, "Distance ceiling");
    check(CpuPolicy.validDistance(.25, .75) == .5, "Minecraft valid minimum");
    check(CpuPolicy.validDistance(.5, .75) == .5, "Never raises valid user distance");
    check(CpuPolicy.particleLimit("balanced", "off").equals("decreased"), "Balanced particles");
    check(CpuPolicy.particleLimit("economy", "off").equals("minimal"), "Economy particles");
    check(CpuPolicy.particleLimit("off", "minimal").equals("off"), "Off ignores custom particles");
    check(CpuPolicy.particleLimit("custom", "off").equals("off"), "Particle independent disable");
    System.out.println("PASS CPU policy: " + checks + " checks");
  }
}
