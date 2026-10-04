package nvvisionboost.vulkanbridge.platform;

/** Compile-time binding: exactly one loader implementation in each artifact. */
public final class Platform {
  private static final PlatformAdapter ADAPTER = new LoaderAdapter();

  private Platform() {}

  public static PlatformAdapter get() {
    return ADAPTER;
  }
}
