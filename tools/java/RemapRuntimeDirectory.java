import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import net.fabricmc.tinyremapper.*;

/**
 * Uses official Tiny Remapper with directory input and Jar streams on hosts where ZipFS is
 * unavailable.
 */
public final class RemapRuntimeDirectory {
  public static void main(String[] args) throws Exception {
    Path input = Path.of(args[0]), output = Path.of(args[1]), mapping = Path.of(args[2]);
    Path expanded = output.toAbsolutePath().getParent().resolve("expanded-" + UUID.randomUUID());
    Files.createDirectories(expanded);
    try (var jar = new JarFile(input.toFile())) {
      for (var entry : Collections.list(jar.entries())) {
        if (!entry.getName().endsWith(".class")) continue;
        Path file = expanded.resolve(entry.getName()).normalize();
        if (!file.startsWith(expanded)) throw new IOException("Unsafe class path");
        Files.createDirectories(file.getParent());
        try (var stream = jar.getInputStream(entry)) {
          Files.copy(stream, file);
        }
      }
    }
    var remapper =
        TinyRemapper.newRemapper()
            .withMappings(TinyUtils.createTinyMappingProvider(mapping, args[3], args[4]))
            .build();
    try {
      remapper.readInputs(expanded);
      Map<String, byte[]> classes = new TreeMap<>();
      remapper.apply(
          (name, bytes) -> {
            synchronized (classes) {
              classes.put(name, bytes);
            }
          });
      try (var jar = new JarOutputStream(Files.newOutputStream(output))) {
        for (var entry : classes.entrySet()) {
          jar.putNextEntry(new JarEntry(entry.getKey() + ".class"));
          jar.write(entry.getValue());
          jar.closeEntry();
        }
      }
      System.out.println(
          "PASS official Tiny Remapper runtime fixture: " + classes.size() + " classes");
    } finally {
      remapper.finish();
    }
  }
}
