package nvvisionboost.legacy.addon;

/** Java 8 regression: live controls, restoration, foreign edits and changed Minecraft options. */
public final class LegacyLeaseTest {
  private static int checks;

  private static void check(int actual, int expected) {
    checks++;
    if (actual != expected) throw new AssertionError(actual + " != " + expected);
  }

  public static void main(String[] args) {
    Object owner = new Object();
    LegacyIntegerLease lease = new LegacyIntegerLease();
    check(lease.apply(owner, 0, 1), 1);
    check(lease.apply(owner, 1, 2), 2);
    check(lease.apply(owner, 2, 1), 1);
    check(lease.apply(owner, 1, 0), 0);
    check(lease.apply(owner, 2, 1), 2);
    check(lease.apply(owner, 2, 0), 2);
    check(lease.apply(owner, 0, 2), 2);
    check(lease.apply(owner, 1, 0), 1);
    check(lease.apply(owner, 0, 2), 2);
    check(lease.apply(new Object(), 1, 0), 1);
    System.out.println("PASS legacy Java 8 live CPU option ownership: " + checks + " checks");
  }
}
