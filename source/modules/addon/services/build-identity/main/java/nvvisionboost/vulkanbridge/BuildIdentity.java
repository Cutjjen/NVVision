package nvvisionboost.vulkanbridge;

/** Reads reproducible build metadata. Development class directories have no release version. */
public final class BuildIdentity {
  private BuildIdentity() {}

  public static String version() {
    Package metadata = BuildIdentity.class.getPackage();
    String version = metadata == null ? null : metadata.getImplementationVersion();
    return version == null || version.trim().isEmpty() ? "development" : version;
  }
}
