/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostLanguageTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import com.google.gson.*;
public final class NVVisionBoostLanguageTest {
  static int checks;
  static void check(boolean value,String message) { checks++; if(!value)throw new AssertionError(message); }
  public static void main(String[] args)throws Exception {
    var temp=Files.createTempDirectory("nvvb-language-test-");
    var file=temp.resolve("config/ui-language.txt");
    NVVisionBoostLanguage.loadPreference(file);
    check(!NVVisionBoostLanguage.english(),"Default must be Brazilian Portuguese");
    check(NVVisionBoostLanguage.text("CPU: balanced / Off").equals("CPU: equilibrado / Desligado"),"English internal states must be translated");
    NVVisionBoostLanguage.select(true);
    check(NVVisionBoostLanguage.savePreference(file),"Save locale");
    check(Files.readString(file).equals("en_us"),"Locale file format");
    NVVisionBoostLanguage.select(false);
    NVVisionBoostLanguage.loadPreference(file);
    check(NVVisionBoostLanguage.english(),"Persisted English restored");
    try(var in=NVVisionBoostLanguageTest.class.getResourceAsStream("/assets/nvvisionboost/ui/en_us.json")) {
      var map=JsonParser.parseReader(new java.io.InputStreamReader(in,StandardCharsets.UTF_8)).getAsJsonObject();
      for(var e:map.entrySet()) check(NVVisionBoostLanguage.text(e.getKey()).equals(e.getValue().getAsString()),"Translation: "+e.getKey()+" -> "+NVVisionBoostLanguage.text(e.getKey()));
    }
    check(NVVisionBoostLanguage.text("Escala interna: 75%").equals("Internal scale: 75%"),"Dynamic scale label");
    check(NVVisionBoostHelp.help("CPU: balanced",false).contains("CPU/GPU"),"CPU hardware explanation");
    check(NVVisionBoostHelp.help("Escala interna: 50%",true).contains("Right-click"),"Reverse cycle help");
    check(NVVisionBoostHelp.help("Importar shaderpack",false).startsWith("Opens, imports"),"Import explanation precedes shader quality");
    check(NVVisionBoostHelp.help("Voltar",false).contains("navigation only"),"Navigation has no hardware effect");
    NVVisionBoostLanguage.select(false);
    check(NVVisionBoostLanguage.text("Internal scale: 75%").equals("Escala interna: 75%"),"Already displayed status follows language switching");
    check(NVVisionBoostHelp.help("Texturas: Mipmaps 4",false).contains("VRAM"),"Texture memory explanation");
    check(NVVisionBoostHelp.help("Simulação: 4 chunks",false).contains("ticks"),"Simulation tradeoff");
    check(NVVisionBoostHelp.help("EN",false).contains("Estados Unidos"),"US flag option narration");
    check(NVVisionBoostHelp.help("BR",false).contains("Brasil"),"Brazil flag option narration");
    check(NVVisionBoostLanguage.text("NVIDIA RTX 5060 Ti / AMD Radeon RX 7800 XT / Intel Arc A770").equals("NVIDIA RTX 5060 Ti / AMD Radeon RX 7800 XT / Intel Arc A770"),"Hardware names preserved");
    check(NVVisionBoostLanguage.text("Eclipse_low.zip / FlowShader.zip").equals("Eclipse_low.zip / FlowShader.zip"),"Filename tokens preserved");
    NVVisionBoostLanguage.select(true);
    check(NVVisionBoostHelp.help("CPU: balanced",false).contains("75%"),"Exact balanced CPU budget");
    check(NVVisionBoostHelp.help("CPU particles (custom): minimal",false).contains("minimal"),"Particle levels described");
    check(NVVisionBoostHelp.help("Recursos da GPU ativa",false).startsWith("Shows"),"Information button explanation");
    NVVisionBoostLanguage.select(false);
    check(NVVisionBoostHelp.impact("↑").contains("nenhum"),"Scroll arrow does not change hardware workload");
    check(NVVisionBoostHelp.help("RTX 5060 Ti",false).contains("consulta"),"GPU entry selection explanation");
    var sentinel=temp.resolve("nvvisionboost.json");Files.writeString(sentinel,"user settings");
    check(NVVisionBoostLanguage.savePreference(file),"Save Portuguese");
    check(Files.readString(file).equals("pt_br"),"Portuguese persisted");
    check(Files.readString(sentinel).equals("user settings"),"Performance config untouched");
    Files.writeString(file,"invalid");NVVisionBoostLanguage.loadPreference(file);
    check(!NVVisionBoostLanguage.english(),"Invalid locale falls back safely");
    var blocked=temp.resolve("blocked");Files.writeString(blocked,"not a directory");
    check(!NVVisionBoostLanguage.savePreference(blocked.resolve("language")),"Save failure is reported");
    for(var p:Files.walk(temp).sorted(java.util.Comparator.reverseOrder()).toList())Files.delete(p);
    System.out.println("PASS UI language: "+checks+" checks");
  }
}

