/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostFerriteConfig.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import com.electronwill.nightconfig.toml.TomlParser;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

/** Edição limitada às chaves raiz, com backup original e proteção contra alterações externas. */
public final class NVVisionBoostFerriteConfig {
  private final Path file, backup, journal;
  private static final int LIMIT = 262144;

  public NVVisionBoostFerriteConfig(Path file, Path directory) {
    this.file = file.toAbsolutePath();
    this.backup = directory.resolve("original.toml").toAbsolutePath();
    this.journal = directory.resolve("state.properties").toAbsolutePath();
  }

  private static void safe(Path path) throws IOException {
    for (Path p = path; p != null; p = p.getParent())
      if (Files.isSymbolicLink(p)
          || Files.exists(p, LinkOption.NOFOLLOW_LINKS)
              && Files.getAttribute(p, "basic:isOther", LinkOption.NOFOLLOW_LINKS).equals(true))
        throw new IOException("Link ou arquivo especial: " + p);
    if (Files.exists(path)
        && (!Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS) || Files.size(path) > LIMIT))
      throw new IOException("Arquivo inválido ou muito grande: " + path);
  }

  private static String read(Path p) throws IOException {
    safe(p);
    return Files.exists(p) ? Files.readString(p) : "";
  }

  private static String hash(String text) {
    try {
      return java.util.HexFormat.of()
          .formatHex(
              java.security.MessageDigest.getInstance("SHA-256")
                  .digest(text.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
    } catch (java.security.NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  public static Map<String, Boolean> parse(String text) throws IOException {
    try {
      var config = new TomlParser().parse(text.startsWith("\ufeff") ? text.substring(1) : text);
      Map<String, Boolean> result = NVVisionBoostFerriteOptions.preset(0);
      for (var o : NVVisionBoostFerriteOptions.ALL) {
        Object v = config.get(o.key());
        if (v != null) {
          if (!(v instanceof Boolean))
            throw new IOException("Vale booleano obrigatório: " + o.key());
          result.put(o.key(), (Boolean) v);
        }
      }
      NVVisionBoostFerriteOptions.validate(result);
      return result;
    } catch (RuntimeException e) {
      throw new IOException("TOML inválido: " + e.getMessage(), e);
    }
  }

  public Map<String, Boolean> load() throws IOException {
    return parse(read(file));
  }

  static String rewrite(String text, Map<String, Boolean> values) throws IOException {
    parse(text);
    NVVisionBoostFerriteOptions.validate(values);
    String newline = text.contains("\r\n") ? "\r\n" : "\n";
    String bom = text.startsWith("\ufeff") ? "\ufeff" : "";
    if (!bom.isEmpty()) text = text.substring(1);
    List<String> lines = new ArrayList<>(Arrays.asList(text.split("\r?\n", -1)));
    Set<String> seen = new HashSet<>();
    int insert = lines.size();
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      if (line.stripLeading().startsWith("[")) {
        insert = i;
        break;
      }
      for (var o : NVVisionBoostFerriteOptions.ALL) {
        Pattern p =
            Pattern.compile(
                "^(\\s*(?:"
                    + o.key()
                    + "|\""
                    + o.key()
                    + "\"|'"
                    + o.key()
                    + "')\\s*=\\s*)(true|false)(\\s*(?:#.*)?)$");
        Matcher m = p.matcher(line);
        if (m.matches()) {
          seen.add(o.key());
          lines.set(i, m.group(1) + values.get(o.key()) + m.group(3));
          break;
        }
      }
    }
    for (var o : NVVisionBoostFerriteOptions.ALL)
      if (!seen.contains(o.key())) lines.add(insert++, o.key() + " = " + values.get(o.key()));
    String result = bom + String.join(newline, lines);
    if (!parse(result).equals(values))
      throw new IOException("Estrutura TOML não suportada; arquivo preservado.");
    return result;
  }

  public void apply(Map<String, Boolean> values, Map<String, Boolean> expected) throws IOException {
    String current = read(file);
    if (!parse(current).equals(expected))
      throw new IOException("Configuração mudou externamente. Atualize antes de aplicar.");
    String next = rewrite(current, values);
    safe(backup);
    safe(journal);
    Properties state = new Properties();
    if (Files.exists(journal)) {
      try (var reader = new StringReader(read(journal))) {
        state.load(reader);
      }
      verify(state);
    } else {
      state.setProperty("originalExists", Boolean.toString(Files.exists(file)));
      state.setProperty("originalHash", hash(current));
      NVVisionBoostIO.writeUtf8(backup, current);
    }
    state.setProperty("lastHash", hash(next));
    StringWriter out = new StringWriter();
    state.store(out, "NVVisionBoost FerriteCore backup");
    NVVisionBoostIO.writeUtf8(journal, out.toString());
    NVVisionBoostIO.writeUtf8(file, next);
  }

  private String verify(Properties state) throws IOException {
    String original = read(backup);
    if (!Files.exists(backup)
        || !hash(original).equals(state.getProperty("originalHash"))
        || !Set.of("true", "false").contains(state.getProperty("originalExists", "")))
      throw new IOException("Backup inválido; arquivo preservado.");
    return original;
  }

  public void restore() throws IOException {
    if (!Files.exists(journal)) throw new IOException("Nenhum backup disponível.");
    Properties state = new Properties();
    try (var reader = new StringReader(read(journal))) {
      state.load(reader);
    }
    String original = verify(state);
    if (!hash(read(file)).equals(state.getProperty("lastHash")))
      throw new IOException(
          "Alteração externa detectada. Restauração bloqueada para preservar seu arquivo.");
    if (Boolean.parseBoolean(state.getProperty("originalExists")))
      NVVisionBoostIO.writeUtf8(file, original);
    else Files.deleteIfExists(file);
    Files.delete(journal);
    Files.delete(backup);
  }
}
