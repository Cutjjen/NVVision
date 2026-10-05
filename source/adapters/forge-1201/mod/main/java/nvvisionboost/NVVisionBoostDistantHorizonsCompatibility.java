package nvvisionboost;

<<<<<<< HEAD
/** Optional cooperation without a compile-time dependency on a specific API version. */
=======
/** Cooperação opcional sem dependência de classes/API de uma versão específica. */
>>>>>>> origin/master
public final class NVVisionBoostDistantHorizonsCompatibility {
  private static Boolean reported;

  private NVVisionBoostDistantHorizonsCompatibility() {}

  public static boolean loaded() {
    return NVVisionBoostCompatibility.loaded("distanthorizons");
  }

  public static boolean allowsAutomaticDistanceChanges() {
    return !loaded();
  }

  public static boolean allowsFramebufferScaling() {
    return !loaded();
  }

  public static void report() {
    boolean present = loaded();
    if (reported == null || reported != present) {
      reported = present;
      NVVisionBoostForge.log(
          "Distant Horizons="
              + present
              + (present
                  ? " | LODs e threads pertencem ao DH; distância automática suspensa; framebuffer"
                      + " nativo até validar integração de passes"
                  : " | política padrão do NVVision"));
    }
  }
}
