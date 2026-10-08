package nvvisionboost;

/** Regression for the previously unconditional no-shader message. */
public final class NVVisionBoostShaderStatusAdapterTest {
  public static void main(String[] args) {
    check(NVVisionBoostShaderStatusAdapter.describe(true, true, true).contains("shaders ativos"));
    check(NVVisionBoostShaderStatusAdapter.describe(true, false, true).contains("shaders ativos"));
    check(NVVisionBoostShaderStatusAdapter.describe(true, true, false).contains("aguardando"));
    check(NVVisionBoostShaderStatusAdapter.describe(true, false, false).contains("sem shaders"));
    check(NVVisionBoostShaderStatusAdapter.describe(false, false, false).contains("sem shaders"));
    System.out.println("PASS shader status adapter: 5 active, disabled, transition and absent cases");
  }
  private static void check(boolean result) {
    if (!result) throw new AssertionError("Incorrect shader pipeline status");
  }
}
