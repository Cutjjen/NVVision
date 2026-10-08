package nvvisionboost;

/** Covers actual binary names, API discovery without initialization and pipeline return shapes. */
public final class NVVisionBoostIrisApiAdapterTest {
  private static final String MODERN = "net.irisshaders.iris.api.v0.IrisApi";
  private static final String LEGACY = "net.coderbot.iris.api.v0.IrisApi";

  private static ClassLoader exposing(final String available) {
    return new ClassLoader(NVVisionBoostIrisApiAdapterTest.class.getClassLoader()) {
      @Override
      protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if ((name.equals(MODERN) || name.equals(LEGACY)) && !name.equals(available))
          throw new ClassNotFoundException(name);
        return super.loadClass(name, resolve);
      }
    };
  }

  public static final class DirectManager {
    public Object getPipeline() {
      return "pipeline";
    }
  }

  public static final class OptionalManager {
    public java.util.Optional<Object> getPipeline() {
      return java.util.Optional.of("pipeline");
    }
  }

  public static final class EmptyManager {
    public java.util.Optional<Object> getPipeline() {
      return java.util.Optional.empty();
    }
  }

  public static void main(String[] args) throws Exception {
    if (!NVVisionBoostIrisApiAdapter.apiType(exposing(MODERN)).getName().equals(MODERN))
      throw new AssertionError("Split engine/API namespace not supported");
    if (!NVVisionBoostIrisApiAdapter.apiType(exposing(LEGACY)).getName().equals(LEGACY))
      throw new AssertionError("Legacy API fallback missing");
    if (System.getProperty("nvvision.iris.fixture.initialized") != null)
      throw new AssertionError("Discovery must not initialize Iris");
    try {
      NVVisionBoostIrisApiAdapter.apiType(exposing("absent"));
      throw new AssertionError("Missing API must not be treated as active");
    } catch (ClassNotFoundException expected) {
    }
    for (Object manager : new Object[] {new DirectManager(), new OptionalManager()}) {
      if (!"pipeline".equals(NVVisionBoostIrisApiAdapter.currentPipeline(manager)))
        throw new AssertionError("Pipeline shape not supported");
    }
    if (NVVisionBoostIrisApiAdapter.currentPipeline(new EmptyManager()) != null
        || NVVisionBoostIrisApiAdapter.currentPipeline(null) != null)
      throw new AssertionError("Absent pipeline must remain unavailable");
    try {
      NVVisionBoostIrisApiAdapter.currentPipeline(new Object());
      throw new AssertionError("Missing function must not produce a fake pipeline");
    } catch (NoSuchMethodException expected) {
    }
    if (args.length == 1) {
      try (java.net.URLClassLoader loader =
          new java.net.URLClassLoader(
              new java.net.URL[] {new java.io.File(args[0]).toURI().toURL()}, null)) {
        Class<?> actual = NVVisionBoostIrisApiAdapter.apiType(loader);
        actual.getMethod("getInstance");
        actual.getMethod("isShaderPackInUse");
        actual.getMethod("getConfig");
        System.out.println("PASS actual installed Iris API: " + actual.getName());
      }
    }
    System.out.println(
        "PASS Iris API adapter: namespaces, initialization, direct/Optional/absent pipelines");
  }
}
