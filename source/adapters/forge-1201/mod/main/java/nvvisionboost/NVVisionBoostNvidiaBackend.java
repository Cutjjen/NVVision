package nvvisionboost;

import java.nio.file.*;

/** Reports native NVIDIA runtime availability without loading untrusted DLLs. */
public final class NVVisionBoostNvidiaBackend {
  private NVVisionBoostNvidiaBackend() {}

  public static boolean dlssLibraryPresent() {
    String[] names = {"nvngx_dlss.dll", "sl.interposer.dll"};
    Path[] roots = {
      NVVisionBoostForge.gameRoot(),
      NVVisionBoostForge.gameRoot().resolve("nvvisionboost"),
      Paths.get(System.getenv().getOrDefault("ProgramFiles", "C:\\Program Files"))
          .resolve("NVIDIA Corporation")
    };
    for (Path r : roots)
      if (r != null)
        for (String n : names)
          try {
            if (Files.isRegularFile(r.resolve(n))) return true;
          } catch (Throwable ignored) {
          }
    return false;
  }

  public static boolean frameGenerationAvailable() {
    return false;
  }

  public static String status() {
    NVVisionBoostGPU.Info g = NVVisionBoostGPU.detect();
    if (!g.nvidia) return "GPU NVIDIA não detectada";
    if (dlssLibraryPresent())
      return "DLL NVIDIA encontrada; bridge native não ativado nesta build OpenGL";
    return "NVIDIA safe backend | DLSS bridge opcional indisponível no OpenGL";
  }
}
