package nvvisionboost;

import java.io.IOException;
import java.nio.file.*;

/** Manages shaderpacks and resource packs without modifying their contents. */
public final class NVVisionBoostContentManager {
  private NVVisionBoostContentManager() {}

  public static Path shaderpacksDir() {
    return NVVisionBoostForge.gameRoot().resolve("shaderpacks");
  }

  public static Path resourcepacksDir() {
    return NVVisionBoostForge.gameRoot().resolve("resourcepacks");
  }

  public static void ensureFolders(Path game) {
    if (game == null) return;
    try {
      Files.createDirectories(game.resolve("shaderpacks"));
      Files.createDirectories(game.resolve("resourcepacks"));
    } catch (IOException e) {
      NVVisionBoostForge.log("folders: " + e);
    }
  }

  public static boolean openFolder(Path p) {
    return p != null && NVVisionBoostIO.openFolder(p);
  }

  /**
   * Installs a shaderpack file or directory into .minecraft/shaderpacks. ZIP/JAR shaderpacks are
   * copied as-is; directories are copied recursively.
   */
  public static String importShader(Path source) throws IOException {
    Path installed = importContent(source, shaderpacksDir(), "shaderpack");
    return installed.getFileName().toString();
  }

  /** Installs a resource pack file or directory into .minecraft/resourcepacks. */
  public static String importResourcePack(Path source) throws IOException {
    Path installed = importContent(source, resourcepacksDir(), "resource pack");
    return installed.getFileName().toString();
  }

  /**
   * Activates a resource pack through Minecraft's native repository. This method only changes the
   * selected pack list; it never edits pack data.
   */
  public static boolean activateResourcePack(String name) {
    if (name == null || name.isBlank()) return false;
    try {
      net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
      if (mc == null || mc.getResourcePackRepository() == null) return false;
      var repository = mc.getResourcePackRepository();
      repository.reload();
      String target = null;
      for (String available : repository.getAvailableIds()) {
        if (available.equals(name)
            || available.equalsIgnoreCase("file/" + name)
            || available.equalsIgnoreCase(name)
            || available.equalsIgnoreCase(stripExtension(name))) {
          target = available;
          break;
        }
      }
      if (target == null) return false;
      java.util.List<String> previous = new java.util.ArrayList<>(repository.getSelectedIds());
      java.util.List<String> previousOptions = new java.util.ArrayList<>(mc.options.resourcePacks);
      java.util.List<String> next = mergeSelection(previous, target);
      repository.setSelected(next);
      mc.options.resourcePacks.clear();
      mc.options.resourcePacks.addAll(
          repository.getSelectedIds().stream()
              .filter(id -> !id.equals("vanilla") && !id.equals("mod_resources"))
              .toList());
      mc.options.save();
      mc.reloadResourcePacks()
          .whenComplete(
              (unused, error) -> {
                if (error != null)
                  mc.execute(
                      () -> {
                        repository.setSelected(previous);
                        mc.options.resourcePacks.clear();
                        mc.options.resourcePacks.addAll(previousOptions);
                        mc.options.save();
                        NVVisionBoostForge.log(
                            "Pacote de recursos rejeitado; seleção anterior restaurada: " + error);
                        mc.reloadResourcePacks();
                      });
              });
      return repository.getSelectedIds().contains(target);
    } catch (Throwable t) {
      NVVisionBoostForge.log("resource pack activation: " + t);
      return false;
    }
  }

  static java.util.List<String> mergeSelection(java.util.List<String> previous, String target) {
    java.util.List<String> next = new java.util.ArrayList<>(previous);
    if (!next.contains(target)) next.add(target);
    return next;
  }

  private static Path importContent(Path source, Path destination, String label)
      throws IOException {
    if (source == null || !Files.exists(source)) throw new IOException(label + " não encontrado.");
    source = source.toAbsolutePath().normalize();
    destination = destination.toAbsolutePath().normalize();
    Files.createDirectories(destination);

    String fileName = source.getFileName().toString();
    Path target = destination.resolve(fileName).normalize();
    if (source.equals(target)) return target;
    if (Files.isDirectory(source) && target.startsWith(source))
      throw new IOException("A pasta de destino está dentro da origem.");
    if (!target.getParent().equals(destination.toAbsolutePath().normalize())
        && !target.getParent().equals(destination.normalize())) {
      throw new IOException("Destino inválido.");
    }

    if (Files.isDirectory(source)) {
      if (target.equals(source.toAbsolutePath().normalize())) return target;
      copyDirectory(source, target);
    } else {
      Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
    return target;
  }

  private static void copyDirectory(Path source, Path target) throws IOException {
    Files.createDirectories(target);
    try (var stream = Files.walk(source)) {
      for (Path p : (Iterable<Path>) stream::iterator) {
        Path rel = source.relativize(p);
        Path out = target.resolve(rel);
        if (Files.isDirectory(p)) Files.createDirectories(out);
        else Files.copy(p, out, StandardCopyOption.REPLACE_EXISTING);
      }
    }
  }

  private static String stripExtension(String value) {
    int dot = value.lastIndexOf('.');
    return dot > 0 ? value.substring(0, dot) : value;
  }
}
