package nvvisionboost;

import java.util.function.Predicate;

/**
 * Loader-neutral renderer identity adapter. Rendering uses Minecraft/OpenGL contracts, never
 * private Sodium or Embeddium options classes whose layouts vary by release.
 */
public final class NVVisionBoostRendererAdapter {
  public enum Renderer {
    EMBEDDIUM("Embeddium"),
    SODIUM("Sodium"),
    RUBIDIUM("Rubidium"),
    VANILLA("Vanilla");
    private final String label;

    Renderer(String label) {
      this.label = label;
    }

    public String label() {
      return label;
    }

    public boolean available() {
      return this != VANILLA;
    }
  }

  private NVVisionBoostRendererAdapter() {}

  public static Renderer resolve(Predicate<String> loaded) {
    return resolve(loaded, false);
  }

  /** Legacy forks are opt-in: only targets with an audited Rubidium contract enable this. */
  public static Renderer resolve(Predicate<String> loaded, boolean legacyRubidium) {
    // Prefer the explicit fork ID when a loader exposes compatibility aliases.
    if (loaded.test("embeddium")) return Renderer.EMBEDDIUM;
    if (loaded.test("sodium")) return Renderer.SODIUM;
    if (legacyRubidium && loaded.test("rubidium")) return Renderer.RUBIDIUM;
    return Renderer.VANILLA;
  }
}
