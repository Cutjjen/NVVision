/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostLanguage.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;
import com.google.gson.*;

/** Localização própria: não altera o idioma ou os recursos do Minecraft. */
public final class NVVisionBoostLanguage {
  private static boolean english;
  private static final Map<String,String> translations = load();
  private static final Pattern phrases = Pattern.compile(translations.keySet().stream()
      .sorted(Comparator.comparingInt(String::length).reversed()).map(NVVisionBoostLanguage::phrase)
      .collect(java.util.stream.Collectors.joining("|")));
  private static final Map<String,String> reverse = reverse();
  private static final Pattern englishPhrases = Pattern.compile(reverse.keySet().stream()
      .sorted(Comparator.comparingInt(String::length).reversed()).map(NVVisionBoostLanguage::phrase)
      .collect(java.util.stream.Collectors.joining("|")));
  private static Map<String,String> reverse() {
    var result=new LinkedHashMap<String,String>();
    translations.forEach((pt,en)->result.putIfAbsent(en,pt)); return result;
  }
  private static String phrase(String value) {
    return (Character.isLetterOrDigit(value.charAt(0))?"(?<![\\p{L}\\p{N}_])":"")+Pattern.quote(value)
        +(Character.isLetterOrDigit(value.charAt(value.length()-1))?"(?![\\p{L}\\p{N}_])":"");
  }
  public static boolean english() { return english; }
  public static void select(boolean value) { english=value; }
  public static void loadPreference(Path file) {
    try { english=Files.readString(file,StandardCharsets.UTF_8).trim().equals("en_us"); }
    catch(java.io.IOException ignored) { english=false; }
  }
  public static boolean savePreference(Path file) {
    try { Files.createDirectories(file.getParent()); Files.writeString(file,english?"en_us":"pt_br",StandardCharsets.UTF_8); return true; }
    catch(java.io.IOException ignored) { return false; }
  }
  private static Map<String,String> load() {
    try(var stream=NVVisionBoostLanguage.class.getResourceAsStream("/assets/nvvisionboost/ui/en_us.json")) {
      if(stream==null)throw new IllegalStateException("Missing NVVision UI language resource");
      var result=new LinkedHashMap<String,String>();
      JsonParser.parseReader(new java.io.InputStreamReader(stream,StandardCharsets.UTF_8)).getAsJsonObject()
          .entrySet().forEach(e->result.put(e.getKey(),e.getValue().getAsString()));
      return Collections.unmodifiableMap(result);
    } catch(java.io.IOException e) { throw new IllegalStateException(e); }
  }
  public static String text(String input) {
    if(input==null)return "";
    String pt=input.replaceAll("\\bON\\b|\\bOn\\b","Ligado").replaceAll("\\bOFF\\b|\\bOff\\b","Desligado")
        .replaceAll("\\blow\\b","baixo").replaceAll("\\bbalanced\\b","equilibrado")
        .replaceAll("\\bquality\\b","qualidade").replaceAll("\\bcustom\\b","personalizado")
        .replaceAll("\\beconomy\\b","econômico").replaceAll("\\boff\\b","desativado")
        .replaceAll("\\bunknown\\b","desconhecido").replace("Frame Generation","Geração de quadros")
        .replace("Shader renderer: ","Renderizador de shaders: ")
        .replace("Renderer reaplicado","Renderizador reaplicado").replace("Renderer: ","Renderizador: ")
        .replace("Backend observado: ","Renderizador observado: ").replace("Backend: ","Renderizador: ")
        .replaceAll("\\babsent\\b","ausente").replaceAll("\\bincompatible\\b","incompatível")
        .replaceAll("\\bunavailable\\b","indisponível").replaceAll("\\bwaiting\\b","aguardando")
        .replaceAll("\\btrue\\b","Ligado").replaceAll("\\bfalse\\b","Desligado")
        .replace("Preset de imagem: ","Predefinição de imagem: ")
        .replace("Preset: ","Predefinição: ").replace("preset da GPU","predefinição da GPU");
    if(!english)return englishPhrases.matcher(pt).replaceAll(m->Matcher.quoteReplacement(reverse.get(m.group())));
    return phrases.matcher(pt).replaceAll(m->Matcher.quoteReplacement(translations.get(m.group())));
  }
  private NVVisionBoostLanguage() {}
}



