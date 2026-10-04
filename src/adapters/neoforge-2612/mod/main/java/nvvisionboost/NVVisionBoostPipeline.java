/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostPipeline.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/** Read-only analysis of shader pipeline stages used by the native runtime. */
public final class NVVisionBoostPipeline {
  public static final class Report {
    public final String name;
    public final int shaderFiles;
    public final int postPasses;
    public final boolean hasGbuffers;
    public final boolean hasShadow;
    public final List<String> stages;

    private Report(
        String name,
        int shaderFiles,
        int postPasses,
        boolean hasGbuffers,
        boolean hasShadow,
        List<String> stages) {
      this.name = name;
      this.shaderFiles = shaderFiles;
      this.postPasses = postPasses;
      this.hasGbuffers = hasGbuffers;
      this.hasShadow = hasShadow;
      this.stages = Collections.unmodifiableList(new ArrayList<>(stages));
    }
  }

  private NVVisionBoostPipeline() {}

  public static String status() {
    return "NVIDIA performance pipeline; native post-processing analysis enabled";
  }

  public static Report analyze(Path source) throws IOException {
    if (source == null || !Files.exists(source))
      throw new IOException("Shaderpack não encontrado.");
    int files = 0, post = 0;
    boolean gb = false, shadow = false;
    List<String> stages = new ArrayList<>();

    if (Files.isDirectory(source)) {
      Path root = Files.isDirectory(source.resolve("shaders")) ? source : findNestedRoot(source);
      Path shaders = root == null ? source.resolve("shaders") : root.resolve("shaders");
      if (Files.isDirectory(shaders)) {
        try (var stream = Files.walk(shaders)) {
          for (Path f : (Iterable<Path>) stream::iterator) {
            if (!Files.isRegularFile(f)) continue;
            String n = shaders.relativize(f).toString().replace('\\', '/');
            if (!isShader(n)) continue;
            files++;
            classify(n, stages);
            String l = n.toLowerCase(Locale.ROOT);
            gb |= l.contains("gbuffers");
            shadow |= l.contains("shadow");
            if (isPostPass(l)) post++;
          }
        }
      }
    } else {
      try (ZipFile zip = new ZipFile(source.toFile())) {
        var entries = zip.entries();
        while (entries.hasMoreElements()) {
          ZipEntry e = entries.nextElement();
          if (e.isDirectory()) continue;
          String n = e.getName().replace('\\', '/');
          if (!isShader(n) || (!n.startsWith("shaders/") && !n.contains("/shaders/"))) continue;
          String l = n.toLowerCase(Locale.ROOT);
          files++;
          classify(n, stages);
          gb |= l.contains("gbuffers");
          shadow |= l.contains("shadow");
          if (isPostPass(l)) post++;
        }
      }
    }
    return new Report(source.getFileName().toString(), files, post, gb, shadow, stages);
  }

  public static void write(Path target, Report report) throws IOException {
    if (target == null || report == null) return;
    Files.createDirectories(target.getParent());
    StringBuilder out = new StringBuilder();
    out.append("Shader: ").append(report.name).append('\n');
    out.append("Shader files: ").append(report.shaderFiles).append('\n');
    out.append("Post passes: ").append(report.postPasses).append('\n');
    out.append("Gbuffers: ").append(report.hasGbuffers).append('\n');
    out.append("Shadow: ").append(report.hasShadow).append('\n');
    out.append("Stages:\n");
    for (String stage : report.stages) out.append(" - ").append(stage).append('\n');
    Files.writeString(
        target,
        out.toString(),
        StandardCharsets.UTF_8,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING);
  }

  private static boolean isShader(String n) {
    String l = n.toLowerCase(Locale.ROOT);
    return l.endsWith(".fsh")
        || l.endsWith(".frag")
        || l.endsWith(".glsl")
        || l.endsWith(".vsh")
        || l.endsWith(".vert")
        || l.endsWith(".gsh")
        || l.endsWith(".csh");
  }

  private static boolean isPostPass(String n) {
    return n.contains("composite") || n.contains("final") || n.contains("post");
  }

  private static void classify(String n, List<String> stages) {
    String l = n.toLowerCase(Locale.ROOT);
    String stage;
    if (l.contains("gbuffers")) stage = "gbuffers";
    else if (l.contains("shadow")) stage = "shadow";
    else if (l.contains("composite")) stage = "composite";
    else if (l.contains("final")) stage = "final";
    else stage = "other";
    if (!stages.contains(stage)) stages.add(stage);
  }

  private static Path findNestedRoot(Path source) throws IOException {
    try (var stream = Files.list(source)) {
      for (Path child : (Iterable<Path>) stream::iterator)
        if (Files.isDirectory(child) && Files.isDirectory(child.resolve("shaders"))) return child;
    }
    return null;
  }
}

