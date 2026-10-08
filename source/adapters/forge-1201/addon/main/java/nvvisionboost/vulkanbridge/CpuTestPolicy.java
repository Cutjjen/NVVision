package nvvisionboost.vulkanbridge;

/** Pure opt-in budgets. Zero means no ownership and no visual filtering. */
public final class CpuTestPolicy {
  private CpuTestPolicy() {}

  public static final java.util.Set<String> MODEL_NAMESPACES =
      java.util.Set.of("minecraft", "ironchest", "sophisticatedstorage", "storagedrawers");

  public static int normalize(String key, int value) {
    int[] choices = choices(key);
    for (int choice : choices) if (choice == value) return value;
    return 0;
  }

  private static int[] choices(String key) {
    return switch (key) {
      case "simulation" -> new int[] {0, 10, 6};
      case "models" -> new int[] {0, 64, 32};
      case "particleRange" -> new int[] {0, 32, 16};
      default -> new int[] {0};
    };
  }

  public static int next(String key, int value) {
    int[] values = choices(key);
    for (int i = 0; i < values.length; i++)
      if (values[i] == value) return values[(i + 1) % values.length];
    return 0;
  }

  public static int simulation(int current, int ceiling, boolean localServer) {
    return localServer && ceiling > 0 ? Math.max(5, Math.min(current, ceiling)) : current;
  }

  public static boolean supportedModelNamespace(String namespace) {
    return namespace != null && MODEL_NAMESPACES.contains(namespace);
  }

  public static boolean outside(double distanceSquared, int radius) {
    return radius > 0
        && Double.isFinite(distanceSquared)
        && distanceSquared > (double) radius * radius;
  }
}
