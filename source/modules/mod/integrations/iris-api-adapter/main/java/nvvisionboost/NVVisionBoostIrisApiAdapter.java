package nvvisionboost;

/**
 * Resolves the public Iris API independently from the backend implementation namespace. Iris 1.6.x
 * exposes net.irisshaders API types while its engine still uses net.coderbot. Class discovery does
 * not initialize a backend or trigger shader compilation.
 */
public final class NVVisionBoostIrisApiAdapter {
  private NVVisionBoostIrisApiAdapter() {}

  private static final java.util.concurrent.ConcurrentMap<Class<?>, java.lang.reflect.Method>
      PIPELINE_METHODS = new java.util.concurrent.ConcurrentHashMap<>();

  /** Read either the legacy direct pipeline or the Optional returned by newer managers. */
  public static Object currentPipeline(Object manager) throws ReflectiveOperationException {
    if (manager == null) return null;
    Class<?> owner = manager.getClass();
    java.lang.reflect.Method method = PIPELINE_METHODS.get(owner);
    if (method == null) {
      method = owner.getMethod("getPipeline");
      PIPELINE_METHODS.putIfAbsent(owner, method);
    }
    Object pipeline = method.invoke(manager);
    return pipeline instanceof java.util.Optional<?>
        ? ((java.util.Optional<?>) pipeline).orElse(null)
        : pipeline;
  }

  public static Class<?> apiType(ClassLoader loader) throws ClassNotFoundException {
    ClassNotFoundException missing = null;
    for (String name :
        new String[] {"net.irisshaders.iris.api.v0.IrisApi", "net.coderbot.iris.api.v0.IrisApi"}) {
      try {
        return Class.forName(name, false, loader);
      } catch (ClassNotFoundException absent) {
        missing = absent;
      }
    }
    throw missing;
  }
}
