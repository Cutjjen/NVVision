package nvvisionboost.vulkanbridge;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

final class BridgeFiles {
  private BridgeFiles() {}

  static void atomic(Path file, String value) throws IOException {
    Files.createDirectories(file.toAbsolutePath().getParent());
    Path temporary = Files.createTempFile(file.toAbsolutePath().getParent(), "bridge-", ".tmp");
    try {
      Files.writeString(temporary, value, StandardCharsets.UTF_8);
      try {
        Files.move(
            temporary, file, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
      } catch (AtomicMoveNotSupportedException ignored) {
        Files.move(temporary, file, StandardCopyOption.REPLACE_EXISTING);
      }
    } finally {
      Files.deleteIfExists(temporary);
    }
  }

  static Properties profile(Path home) throws IOException {
    Properties p = new Properties();
    Path file = home.resolve("bridge.properties");
    if (Files.isRegularFile(file)) {
      if (Files.size(file) > 8192) throw new IOException("Profile is too large");
      try (InputStream in = Files.newInputStream(file)) {
        p.load(in);
      }
    }
    return p;
  }

  static void descriptors(Path home, String value) throws IOException {
    if (!Set.of("auto", "lazy").contains(value))
      throw new IllegalArgumentException("Unknown descriptor mode");
    Properties p = profile(home);
    p.setProperty("descriptors", value);
    StringWriter text = new StringWriter();
    p.store(text, "NVVision Vulkan Bridge - next startup only");
    atomic(home.resolve("bridge.properties"), text.toString());
  }

  static void backend(Path home, String backend) throws IOException {
    if (!Set.of("opengl", "zink").contains(backend))
      throw new IllegalArgumentException("Unknown backend");
    Properties p = profile(home);
    p.setProperty("backend", backend);
    StringWriter text = new StringWriter();
    p.store(text, "NVVision Vulkan Bridge - next startup only");
    atomic(home.resolve("bridge.properties"), text.toString());
  }
}
