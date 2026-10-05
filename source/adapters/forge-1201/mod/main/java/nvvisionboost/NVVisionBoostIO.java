package nvvisionboost;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Locale;

/** Small, dependency-free I/O helpers shared by the client-side subsystems. */
public final class NVVisionBoostIO {
  private static final java.util.concurrent.ThreadPoolExecutor LOG_WRITER =
      new java.util.concurrent.ThreadPoolExecutor(
          1,
          1,
          30L,
          java.util.concurrent.TimeUnit.SECONDS,
          new java.util.concurrent.ArrayBlockingQueue<>(128),
          runnable -> {
            Thread thread = new Thread(runnable, "NVVisionBoost-log");
            thread.setDaemon(true);
            return thread;
          },
          new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());

  public static void appendLog(Path target, String message) {
    LOG_WRITER.execute(
        () -> {
          try {
            Files.createDirectories(target.toAbsolutePath().getParent());
            if (Files.exists(target) && Files.size(target) > 2L * 1024 * 1024)
              Files.move(
                  target,
                  target.resolveSibling(target.getFileName() + ".previous"),
                  StandardCopyOption.REPLACE_EXISTING);
            Files.writeString(
                target,
                message + System.lineSeparator(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
          } catch (IOException ignored) {
          }
        });
  }

  private NVVisionBoostIO() {}

  public static void writeUtf8(Path target, String content) throws IOException {
    if (target == null) throw new IOException("Target path is null");
    Path parent = target.toAbsolutePath().getParent();
    if (parent != null) Files.createDirectories(parent);

    Path tmp = Files.createTempFile(parent, "nvb-" + target.getFileName() + "-", ".tmp");
    try {
      Files.writeString(
          tmp,
          content,
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING,
          StandardOpenOption.WRITE);
      try {
        Files.move(
            tmp, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
      } catch (AtomicMoveNotSupportedException e) {
        Files.move(tmp, target, StandardCopyOption.REPLACE_EXISTING);
      }
    } finally {
      Files.deleteIfExists(tmp);
    }
  }

  public static String readUtf8(Path file, String fallback) {
    try {
      return Files.exists(file) ? Files.readString(file, StandardCharsets.UTF_8) : fallback;
    } catch (IOException e) {
      return fallback;
    }
  }

  public static String jsonString(String value) {
    if (value == null) return "";
    return value
        .replace("\\", "\\\\")
        .replace("\"", "\\\"")
        .replace("\t", "\\t")
        .replace("\b", "\\b")
        .replace("\f", "\\f")
        .replace("\r", "\\r")
        .replace("\n", "\\n");
  }

  public static String normalizeToken(String value) {
    return value == null ? "" : value.toLowerCase(Locale.ROOT).trim();
  }

  public static int clamp(int value, int min, int max) {
    return Math.max(min, Math.min(max, value));
  }

  public static double clamp(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }

  public static boolean openFolder(Path folder) {
    if (folder == null) return false;
    try {
      Files.createDirectories(folder);
      Path p = folder.toAbsolutePath().normalize();
      String os = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);

      if (os.contains("win")) {
        new ProcessBuilder("explorer.exe", p.toString()).start();
        return true;
      }
      if (os.contains("mac")) {
        new ProcessBuilder("open", p.toString()).start();
        return true;
      }
      new ProcessBuilder("xdg-open", p.toString()).start();
      return true;
    } catch (Throwable t) {
      NVVisionBoostForge.log("open folder: " + t);
      return false;
    }
  }
}
