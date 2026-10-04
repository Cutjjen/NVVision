/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostFileFingerprint.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/** Identifica mudanças sem reler fontes e texturas inteiras. */
final class NVVisionBoostFileFingerprint {
  private NVVisionBoostFileFingerprint() {}

  static long stamp(Path source) throws IOException {
    if (!Files.isDirectory(source)) {
      var attrs = Files.readAttributes(source, BasicFileAttributes.class);
      return 31 * attrs.size() + attrs.lastModifiedTime().hashCode();
    }
    long value = 1;
    int count = 0;
    try (var files = Files.walk(source)) {
      var iterator = files.filter(Files::isRegularFile).limit(100_001).sorted().iterator();
      while (iterator.hasNext()) {
        if (++count > 100_000) throw new IOException("Shaderpack possui arquivos demais.");
        Path file = iterator.next();
        var attrs = Files.readAttributes(file, BasicFileAttributes.class);
        value = 31 * value + source.relativize(file).toString().hashCode();
        value = 31 * value + attrs.size();
        value = 31 * value + attrs.lastModifiedTime().hashCode();
      }
    }
    return value;
  }
}

