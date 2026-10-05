package nvvisionboost.minecraft;

/** Explicit version binding selected at build time; no runtime version guessing. */
public final class MinecraftAccess {
  private static final MinecraftVersionAdapter ADAPTER = new VersionAdapter();

  private MinecraftAccess() {}

  public static MinecraftVersionAdapter get() {
    return ADAPTER;
  }
}
