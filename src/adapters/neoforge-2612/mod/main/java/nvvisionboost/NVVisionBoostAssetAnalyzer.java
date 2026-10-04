/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.zip.ZipFile;

/** Relatório de recursos; nunca altera imagens, atlas ou arquivos do jogador. */
public final class NVVisionBoostAssetAnalyzer {
  public static final class Report {
    public int png, animated, large, mcmeta;
    public long bytes;

    public String summary() {
      return "PNG="
          + png
          + ", animated="
          + animated
          + ", large="
          + large
          + ", mcmeta="
          + mcmeta
          + ", bytes="
          + bytes;
    }
  }

  private NVVisionBoostAssetAnalyzer() {}

  public static Report analyze(Path source) {
    Report report = new Report();
    if (source == null || !Files.exists(source)) return report;
    try {
      if (Files.isDirectory(source)) {
        try (var paths = Files.walk(source)) {
          var files = paths.filter(Files::isRegularFile).iterator();
          while (files.hasNext()) analyzeFile(files.next(), report);
        }
      } else analyzeFile(source, report);
    } catch (IOException error) {
      NVVisionBoostCore.log("asset analysis: " + error);
    }
    return report;
  }

  private static void analyzeFile(Path file, Report report) throws IOException {
    String name = file.getFileName().toString().toLowerCase(Locale.ROOT);
    if (name.endsWith(".zip")) {
      try (ZipFile zip = new ZipFile(file.toFile())) {
        var entries = zip.entries();
        while (entries.hasMoreElements()) {
          var entry = entries.nextElement();
          if (entry.isDirectory()) continue;
          String entryName = entry.getName().toLowerCase(Locale.ROOT);
          count(entryName, entry.getSize(), report);
          if (entryName.endsWith(".png.mcmeta")) {
            try (InputStream input = zip.getInputStream(entry)) {
              if (animated(input)) report.animated++;
            }
          }
        }
      } catch (IOException error) {
        NVVisionBoostCore.log("resource pack analysis: " + file.getFileName() + ": " + error);
      }
    } else {
      count(name, Files.size(file), report);
      if (name.endsWith(".png.mcmeta")) {
        try (InputStream input = Files.newInputStream(file)) {
          if (animated(input)) report.animated++;
        }
      }
    }
  }

  private static void count(String name, long size, Report report) {
    if (name.endsWith(".png")) {
      report.png++;
      report.bytes += Math.max(0L, size);
      if (size > 4L * 1024 * 1024) report.large++;
    } else if (name.endsWith(".mcmeta")) report.mcmeta++;
  }

  private static boolean animated(InputStream input) throws IOException {
    byte[] bytes = input.readNBytes(65_537);
    if (bytes.length > 65_536) return false;
    try {
      var json = JsonParser.parseString(new String(bytes, StandardCharsets.UTF_8));
      return json.isJsonObject() && json.getAsJsonObject().has("animation");
    } catch (RuntimeException invalidMetadata) {
      return false;
    }
  }
}

