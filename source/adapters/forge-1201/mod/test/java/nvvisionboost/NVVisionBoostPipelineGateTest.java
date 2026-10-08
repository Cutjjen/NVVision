package nvvisionboost;

/** Exercise reload, pipeline replacement, temporary absence and return without shaders. */
public final class NVVisionBoostPipelineGateTest {
  public static void main(String[] args) {
    var gate = new NVVisionBoostPipelineGate();
    Object first = new Object(), second = new Object();
    check(!gate.ready(true, null));
    check(!gate.ready(true, first));
    check(!gate.ready(true, first));
    check(gate.ready(true, first));
    check(gate.ready(true, first));
    check(!gate.ready(true, second));
    check(!gate.ready(true, null));
    check(!gate.ready(true, second));
    check(!gate.ready(true, second));
    check(gate.ready(true, second));
    check(gate.ready(false, null));
    check(!gate.ready(true, second));
    gate.reset();
    check(!gate.ready(true, second));
    System.out.println("PASS shader pipeline lifecycle: 13 checks");
  }

  private static void check(boolean value) {
    if (!value) throw new AssertionError("Unsafe pipeline transition");
  }
}
