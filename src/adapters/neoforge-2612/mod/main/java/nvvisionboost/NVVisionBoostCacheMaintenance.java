/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostCacheMaintenance.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Versioned, allow-listed generated resources only. Never touches user preferences or shaderpacks.
 */
public final class NVVisionBoostCacheMaintenance {
  private NVVisionBoostCacheMaintenance() {}

  public static boolean update(Path directory, String version) throws IOException {
    Path root = directory.toAbsolutePath().normalize();
    Files.createDirectories(root);
    if (Files.isSymbolicLink(root)
        || Files.readAttributes(root, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS)
            .isOther()) throw new IOException("Config root is a linked/reparse directory");
    Path stamp = root.resolve("generated-cache-version.txt");
    if (Files.isRegularFile(stamp, LinkOption.NOFOLLOW_LINKS)
        && Files.readString(stamp).trim().equals(version)) return false;
    for (String name :
        List.of(
            "shader-cache",
            "shader-analysis.txt",
            "resource-analysis.txt",
            "shader-pipeline.txt",
            "status.txt",
            "README.txt",
            "gpu-presets.json",
            "gpu-presets-nvidia.json",
            "gpu-presets-amd.json",
            "gpu-presets-intel.json")) {
      Path target = root.resolve(name).normalize();
      if (!target.getParent().equals(root)) throw new IOException("Cache path escaped root");
      if (!Files.exists(target, LinkOption.NOFOLLOW_LINKS)) continue;
      Files.walkFileTree(
          target,
          new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path folder, BasicFileAttributes attributes)
                throws IOException {
              if (Files.isSymbolicLink(folder) || attributes.isOther())
                throw new IOException("Linked/reparse cache directories are not traversed");
              return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
                throws IOException {
              Files.delete(file);
              return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path folder, IOException error)
                throws IOException {
              if (error != null) throw error;
              Files.delete(folder);
              return FileVisitResult.CONTINUE;
            }
          });
    }
    if (Files.isSymbolicLink(stamp)) throw new IOException("Version marker is a symbolic link");
    NVVisionBoostIO.writeUtf8(stamp, version + "\n");
    return true;
  }
}

