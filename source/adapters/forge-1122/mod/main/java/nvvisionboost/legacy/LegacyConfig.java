package nvvisionboost.legacy;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

/** Own configuration only. Existing game and third-party settings are never written to disk. */
public final class LegacyConfig {
  public static boolean english, enabled = true;
  public static int gpuPreset, cpuPreset, particles, entities;
  private static Path path;

  public static void load(Path game) {
    path = game.resolve("config/nvvisionboost/legacy.properties");
    Properties p = new Properties();
    if (Files.isRegularFile(path))
      try (InputStream in = Files.newInputStream(path)) {
        p.load(in);
      } catch (IOException ex) {
        System.err.println("NVVision: configuration read failed: " + ex.getMessage());
      }
    english = Boolean.parseBoolean(p.getProperty("english", "false"));
    enabled = Boolean.parseBoolean(p.getProperty("enabled", "true"));
    gpuPreset = value(p, "gpuPreset", 2);
    cpuPreset = value(p, "cpuPreset", 2);
    particles = value(p, "particles", 2);
    entities = value(p, "entities", 2);
  }

  private static int value(Properties p, String key, int max) {
    try {
      return Math.max(0, Math.min(max, Integer.parseInt(p.getProperty(key, "0"))));
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  public static void save() {
    if (path == null) return;
    Properties p = new Properties();
    p.setProperty("english", Boolean.toString(english));
    p.setProperty("enabled", Boolean.toString(enabled));
    p.setProperty("gpuPreset", Integer.toString(gpuPreset));
    p.setProperty("cpuPreset", Integer.toString(cpuPreset));
    p.setProperty("particles", Integer.toString(particles));
    p.setProperty("entities", Integer.toString(entities));
    try {
      Files.createDirectories(path.getParent());
      Path temp = path.resolveSibling("legacy.properties.tmp");
      try (OutputStream out = Files.newOutputStream(temp)) {
        p.store(out, "NVVision by Cutjjen");
      }
      try {
        Files.move(temp, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
      } catch (AtomicMoveNotSupportedException ex) {
        Files.move(temp, path, StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException ex) {
      System.err.println("NVVision: configuration save failed: " + ex.getMessage());
    }
  }

  public static String text(String pt, String en) {
    return english ? en : pt;
  }

  public static void cpuPreset(int preset) {
    cpuPreset = preset;
    particles = preset;
    entities = preset;
  }

  private LegacyConfig() {}
}
