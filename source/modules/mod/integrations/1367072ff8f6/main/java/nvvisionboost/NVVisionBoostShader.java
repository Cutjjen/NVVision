package nvvisionboost;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Read-only shaderpack discovery and analysis.
 *
 * <p>This class does not execute or modify shaderpacks. Execution is handled by o backend opcional
 * selecionado pelo NVVisionBoostShaderEngine.
 */
public final class NVVisionBoostShader {
  public static final class Pack {
    public final String name;
    public final Path path;
    public final boolean derivative;
    public final int score;
    public final int shaderFiles;
    public final int sourceLines;
    public final int animationCost;
    public final int transparencyCost;
    public final int shadowCost;
    public final int volumetricCost;
    public final int postCost;
    public final String recommendedProfile;
    public final List<String> issues;

    public Pack(String name, Path path) {
      this(name, path, false, 0, 0, 0, 0, 0, 0, 0, 0, "balanced", List.of());
    }

    private Pack(
        String name,
        Path path,
        boolean derivative,
        int score,
        int shaderFiles,
        int sourceLines,
        int animationCost,
        int transparencyCost,
        int shadowCost,
        int volumetricCost,
        int postCost,
        String recommendedProfile,
        List<String> issues) {
      this.name = name;
      this.path = path;
      this.derivative = derivative;
      this.score = score;
      this.shaderFiles = shaderFiles;
      this.sourceLines = sourceLines;
      this.animationCost = animationCost;
      this.transparencyCost = transparencyCost;
      this.shadowCost = shadowCost;
      this.volumetricCost = volumetricCost;
      this.postCost = postCost;
      this.recommendedProfile = recommendedProfile;
      this.issues = Collections.unmodifiableList(new ArrayList<>(issues));
    }
  }

  private record AnalysisEntry(long fingerprint, Pack pack) {}

  private static final Map<Path, AnalysisEntry> analysisCache = new LinkedHashMap<>();

  private static synchronized Pack cachedAnalysis(Path source) throws IOException {
    Path key = source.toAbsolutePath().normalize();
    long fingerprint = NVVisionBoostFileFingerprint.stamp(source);
    AnalysisEntry entry = analysisCache.get(key);
    if (entry != null && entry.fingerprint() == fingerprint) return entry.pack();
    Pack pack = analyzePack(source);
    if (analysisCache.size() >= 64) analysisCache.remove(analysisCache.keySet().iterator().next());
    analysisCache.put(key, new AnalysisEntry(fingerprint, pack));
    return pack;
  }

  public static synchronized void invalidateAnalysisCache() {
    analysisCache.clear();
  }

  private NVVisionBoostShader() {}

  public static List<Pack> scan(Path dir, Path cache) {
    if (dir == null || !Files.isDirectory(dir)) return List.of();
    List<Pack> out = new ArrayList<>();
    try (var stream = Files.list(dir)) {
      for (Path p : (Iterable<Path>) stream::iterator) {
        if (isPack(p)) {
          try {
            out.add(cachedAnalysis(p));
          } catch (Throwable t) {
            NVVisionBoostCore.log("shader analyze " + p + ": " + t);
          }
        }
      }
    } catch (IOException e) {
      NVVisionBoostCore.log("shader scan: " + e);
    }
    out.sort(Comparator.comparing(p -> p.name.toLowerCase(Locale.ROOT)));
    return out;
  }

  public static String selected(Path root) {
    if (root == null) return "";
    Path file = root.resolve("selected-shader.txt");
    try {
      return Files.isRegularFile(file) ? Files.readString(file, StandardCharsets.UTF_8).trim() : "";
    } catch (IOException e) {
      return "";
    }
  }

  public static void select(Path root, String name) {
    if (root == null) return;
    try {
      Files.createDirectories(root);
      Files.writeString(
          root.resolve("selected-shader.txt"),
          name == null ? "" : name,
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      NVVisionBoostCore.log("shader selection: " + e);
    }
  }

  private static boolean isPack(Path p) {
    if (Files.isDirectory(p))
      return Files.isDirectory(p.resolve("shaders")) || containsShaderDirectory(p);
    String n = p.getFileName().toString().toLowerCase(Locale.ROOT);
    return Files.isRegularFile(p) && (n.endsWith(".zip") || n.endsWith(".jar"));
  }

  private static boolean containsShaderDirectory(Path p) {
    try (var s = Files.list(p)) {
      for (Path child : (Iterable<Path>) s::iterator)
        if (Files.isDirectory(child) && Files.isDirectory(child.resolve("shaders"))) return true;
    } catch (IOException ignored) {
    }
    return false;
  }

  private static String readLimitedSource(java.io.InputStream input) throws IOException {
    final int max = 8 * 1024 * 1024;
    byte[] data = input.readNBytes(max + 1);
    if (data.length > max) throw new IOException("Fonte GLSL excede 8 MiB.");
    return new String(data, StandardCharsets.UTF_8);
  }

  private static Pack analyzePack(Path pack) throws IOException {
    int files = 0, lines = 0, animation = 0, transparency = 0;
    int shadow = 0, volumetric = 0, post = 0;
    boolean derivative = false;
    long analyzedChars = 0;
    List<String> issues = new ArrayList<>();

    if (Files.isDirectory(pack)) {
      Path root = Files.isDirectory(pack.resolve("shaders")) ? pack : findNestedRoot(pack);
      Path shaderRoot = root == null ? pack.resolve("shaders") : root.resolve("shaders");
      if (Files.isDirectory(shaderRoot)) {
        try (var stream = Files.walk(shaderRoot)) {
          for (Path f : (Iterable<Path>) stream::iterator) {
            if (!Files.isRegularFile(f) || !isShaderFile(f)) continue;
            String source;
            try (var input = Files.newInputStream(f)) {
              source = readLimitedSource(input);
            }
            analyzedChars += source.length();
            if (analyzedChars > 64L * 1024 * 1024)
              throw new IOException("Limite total da análise GLSL excedido.");
            Metrics m = metrics(f.toString(), source);
            files++;
            lines += countLines(source);
            animation += m.animation;
            transparency += m.transparency;
            shadow += m.shadow;
            volumetric += m.volumetric;
            post += m.post;
            derivative |= m.derivative;
          }
        }
      }
    } else {
      try (ZipFile zip = new ZipFile(pack.toFile())) {
        var entries = zip.entries();
        while (entries.hasMoreElements()) {
          ZipEntry e = entries.nextElement();
          String n = e.getName().replace('\\', '/');
          if (e.isDirectory()
              || !n.toLowerCase(Locale.ROOT).contains("/shaders/")
                  && !n.toLowerCase(Locale.ROOT).startsWith("shaders/")) continue;
          if (!isShaderFile(Paths.get(n))) continue;
          try (var in = zip.getInputStream(e)) {
            String source = readLimitedSource(in);
            analyzedChars += source.length();
            if (analyzedChars > 64L * 1024 * 1024)
              throw new IOException("Limite total da análise GLSL excedido.");
            Metrics m = metrics(n, source);
            files++;
            lines += countLines(source);
            animation += m.animation;
            transparency += m.transparency;
            shadow += m.shadow;
            volumetric += m.volumetric;
            post += m.post;
            derivative |= m.derivative;
          }
        }
      }
    }

    int score =
        Math.min(
            100,
            (files * 2) + (lines / 500) + animation + transparency + shadow + volumetric + post);
    if (animation >= 20) issues.add("animações intensivas");
    if (transparency >= 20) issues.add("transparência intensa");
    if (shadow >= 20) issues.add("sombras complexas");
    if (volumetric >= 20) issues.add("efeitos volumétricos");
    if (post >= 20) issues.add("múltiplos passes pós-processamento");

    String profile = score >= 70 ? "low" : score >= 45 ? "balanced" : "quality";
    return new Pack(
        pack.getFileName().toString(),
        pack,
        derivative,
        score,
        files,
        lines,
        animation,
        transparency,
        shadow,
        volumetric,
        post,
        profile,
        issues);
  }

  private static Path findNestedRoot(Path pack) throws IOException {
    try (var stream = Files.list(pack)) {
      for (Path child : (Iterable<Path>) stream::iterator)
        if (Files.isDirectory(child) && Files.isDirectory(child.resolve("shaders"))) return child;
    }
    return null;
  }

  private static boolean isShaderFile(Path p) {
    String n = p.getFileName().toString().toLowerCase(Locale.ROOT);
    return n.endsWith(".fsh")
        || n.endsWith(".frag")
        || n.endsWith(".glsl")
        || n.endsWith(".vsh")
        || n.endsWith(".vert")
        || n.endsWith(".gsh")
        || n.endsWith(".csh");
  }

  private static int countLines(String source) {
    if (source == null || source.isEmpty()) return 0;
    int count = 1;
    for (int i = 0; i < source.length(); i++) if (source.charAt(i) == '\n') count++;
    return count;
  }

  private static Metrics metrics(String path, String source) {
    String s = source == null ? "" : source.toLowerCase(Locale.ROOT);
    String p = path.toLowerCase(Locale.ROOT);
    int animation = count(s, "time") + count(s, "framecounter") + count(s, "frametimecounter");
    int transparency = count(s, "transparency") + count(s, "blend") + count(s, "alpha");
    int shadow = count(s, "shadow") + count(s, "shadowtex");
    int volumetric = count(s, "volumetric") + count(s, "fog") + count(s, "density");
    int post =
        (p.contains("composite") ? 8 : 0)
            + (p.contains("final") ? 8 : 0)
            + (p.contains("post") ? 5 : 0);
    boolean derivative = s.contains("dfdx") || s.contains("dfdy") || s.contains("fwidth");
    return new Metrics(
        Math.min(30, animation / 2),
        Math.min(30, transparency / 2),
        Math.min(30, shadow / 2),
        Math.min(30, volumetric / 2),
        post,
        derivative);
  }

  private static int count(String source, String token) {
    int count = 0, from = 0;
    while ((from = source.indexOf(token, from)) >= 0) {
      count++;
      from += token.length();
    }
    return count;
  }

  private record Metrics(
      int animation, int transparency, int shadow, int volumetric, int post, boolean derivative) {}
}
