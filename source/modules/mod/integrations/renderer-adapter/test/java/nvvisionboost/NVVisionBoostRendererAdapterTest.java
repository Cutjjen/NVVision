package nvvisionboost;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Tests identity aliases and legacy opt-in without loading a renderer or Minecraft. */
public final class NVVisionBoostRendererAdapterTest {
  public static void main(String[] args) {
    check("Vanilla", false);
    check("Sodium", true, "sodium");
    check("Embeddium", true, "embeddium");
    check("Embeddium", true, "sodium", "embeddium");
    check("Vanilla", false, "iris");
    check("Vanilla", false, "rubidium");
    if (NVVisionBoostRendererAdapter.resolve("rubidium"::equals, true)
        != NVVisionBoostRendererAdapter.Renderer.RUBIDIUM)
      throw new AssertionError("Legacy opt-in");
    System.out.println("PASS renderer adapter: 7 identity, alias and legacy cases");
  }

  private static void check(String expected, boolean available, String... ids) {
    Set<String> installed = new HashSet<String>(Arrays.asList(ids));
    NVVisionBoostRendererAdapter.Renderer renderer =
        NVVisionBoostRendererAdapter.resolve(installed::contains);
    if (!renderer.label().equals(expected) || renderer.available() != available)
      throw new AssertionError(installed.toString());
  }
}
