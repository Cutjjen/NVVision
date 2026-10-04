/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostGpuCatalogTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import com.google.gson.JsonParser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public final class NVVisionBoostGpuCatalogTest {
  private static int checks;

  private static void check(boolean value, String message) {
    if (!value) throw new AssertionError(message);
    checks++;
  }

  private static void identity(
      String vendor,
      String name,
      NVVisionBoostGpuCatalog.Brand brand,
      NVVisionBoostGpuCatalog.Type type) {
    var result = NVVisionBoostGpuCatalog.classify(vendor, name);
    check(result.brand() == brand && result.type() == type, vendor + " / " + name);
  }

  public static int run(Path root) throws Exception {
    checks = 0;
    check(
        NVVisionBoostGpuCatalog.hardwareRenderer(
                "zink Vulkan 1.4(NVIDIA GeForce RTX 5060 Ti (NVIDIA_PROPRIETARY))")
            .equals("NVIDIA GeForce RTX 5060 Ti"),
        "Zink NVIDIA identity");
    check(
        NVVisionBoostGpuCatalog.hardwareRenderer(
                "zink Vulkan 1.3(AMD Radeon RX 7800 XT (RADV NAVI32))")
            .equals("AMD Radeon RX 7800 XT"),
        "Zink AMD identity");
    check(
        NVVisionBoostGpuCatalog.hardwareRenderer("zink Vulkan 1.3(Intel Arc A770 Graphics (ANV))")
            .equals("Intel Arc A770 Graphics"),
        "Zink Intel identity");
    check(
        NVVisionBoostGpuCatalog.hardwareRenderer("Intel UHD Graphics 770")
            .equals("Intel UHD Graphics 770"),
        "ordinary identity preserved");
    check(NVVisionBoostGpuCatalog.hardwareRenderer(null).isEmpty(), "null identity");
    check(
        NVVisionBoostGpuCatalog.hardwareRenderer("zink malformed").equals("zink malformed"),
        "unknown Zink label preserved");
    var nv = NVVisionBoostGpuCatalog.Brand.NVIDIA;
    var amd = NVVisionBoostGpuCatalog.Brand.AMD;
    var intel = NVVisionBoostGpuCatalog.Brand.INTEL;
    var integrated = NVVisionBoostGpuCatalog.Type.INTEGRATED;
    var discrete = NVVisionBoostGpuCatalog.Type.DISCRETE;
    var unknown = NVVisionBoostGpuCatalog.Type.UNKNOWN;
    identity("NVIDIA Corporation", "NVIDIA GeForce RTX 5060 Ti/PCIe/SSE2", nv, discrete);
    identity("Intel", "Intel UHD Graphics 770", intel, integrated);
    identity("Intel", "Intel Arc(TM) A770 Graphics", intel, discrete);
    identity("Intel", "Intel Arc B580 Graphics", intel, discrete);
    identity("Intel", "Intel Arc 140V Graphics", intel, integrated);
    identity("Intel", "Intel Iris Xe MAX Graphics", intel, discrete);
    identity("Intel", "Intel Iris Xe Graphics", intel, integrated);
    identity("Intel", "Intel Arc Graphics", intel, unknown);
    identity("ATI Technologies Inc.", "AMD Radeon RX 7800 XT", amd, discrete);
    identity("AMD", "AMD Radeon(TM) 780M Graphics", amd, integrated);
    identity("AMD", "AMD Radeon Vega 8 Graphics", amd, integrated);
    identity("AMD", "AMD Radeon Graphics", amd, unknown);
    identity("Mesa", "AMD Radeon RX 6800 (radeonsi)", amd, discrete);
    identity("Intel", "RTX compatibility translation", intel, unknown);
    identity(null, null, NVVisionBoostGpuCatalog.Brand.UNKNOWN, unknown);
    identity("", "GT 1030", nv, discrete);
    identity("", "RX 9070 XT", amd, discrete);
    identity("ATI", "AMD Radeon HD 8670D", amd, unknown);
    check(
        NVVisionBoostGPU.presets().stream()
            .allMatch(
                p ->
                    NVVisionBoostGpuCatalog.classify("", p.name).brand()
                        != NVVisionBoostGpuCatalog.Brand.UNKNOWN),
        "all catalogue entries have a brand");
    check(
        NVVisionBoostGPU.presetFor("AMD Radeon RX 7900 XTX").name.endsWith("RX 7900 XTX"),
        "longest AMD model");
    check(
        NVVisionBoostGPU.presetFor("AMD Radeon RX 7800M")
            .architecture
            .equals("Modelo não catalogado"),
        "mobile does not get desktop preset");
    check(
        NVVisionBoostGPU.presetFor("Intel Arc(TM) A770 Graphics").name.endsWith("Arc A770"),
        "Intel aliases");
    check(
        NVVisionBoostGPU.presetFor("AMD Radeon(TM) 780M Graphics").family.equals("AMD integrada"),
        "integrated AMD preset");
    check(
        NVVisionBoostGPU.presetFor("AMD Radeon RX 7600 XT").name.endsWith("7600 XT"),
        "XT distinct from base");
    check(
        NVVisionBoostGPU.presetFor("Intel Arc A7700").architecture.equals("Modelo não catalogado"),
        "no prefix false positive");
    check(
        NVVisionBoostGPU.genericPreset("Intel Arc Graphics")
            .family
            .contains("Tipo não determinado"),
        "ambiguous Intel not iGPU");
    var names = new HashSet<String>();
    for (var preset : NVVisionBoostGPU.presets()) {
      check(names.add(preset.name), "unique model " + preset.name);
      check(
          preset.renderScale >= 10 && preset.renderScale <= 100 && preset.renderDistance >= 2,
          "valid tuning bounds " + preset.name);
    }
    check(NVVisionBoostGPU.memoryExtensionAllowed(nv, true, false), "NVX on NVIDIA");
    check(NVVisionBoostGPU.memoryExtensionAllowed(amd, false, true), "ATI on AMD");
    check(
        !NVVisionBoostGPU.memoryExtensionAllowed(intel, true, true),
        "no foreign exclusive API on Intel");
    check(!NVVisionBoostGPU.memoryExtensionAllowed(amd, true, false), "no NVIDIA API on AMD");
    check(!NVVisionBoostGPU.memoryExtensionAllowed(nv, false, true), "no AMD API on NVIDIA");
    check(!NVVisionBoostGPU.memoryExtensionAllowed(nv, false, false), "extension is required");
    check(
        NVVisionBoostGpuTheme.forBrand(nv).accent() != NVVisionBoostGpuTheme.forBrand(amd).accent()
            && NVVisionBoostGpuTheme.forBrand(intel).title().equals("INTEL GRAPHICS"),
        "automatic themes");
    Path export = root.resolve("multi-gpu-export");
    Files.createDirectories(export);
    Files.writeString(export.resolve("gpu-presets.json"), "{\"databaseVersion\": 4}");
    NVVisionBoostGPU.writePresetDatabase(export);
    var database =
        JsonParser.parseString(Files.readString(export.resolve("gpu-presets.json")))
            .getAsJsonObject();
    check(database.get("databaseVersion").getAsInt() == 5, "old DB migration");
    check(database.getAsJsonArray("presets").size() == names.size(), "all brands exported");
    var brands = new HashSet<String>();
    database
        .getAsJsonArray("presets")
        .forEach(item -> brands.add(item.getAsJsonObject().get("brand").getAsString()));
    check(brands.containsAll(java.util.List.of("NVIDIA", "AMD", "INTEL")), "all exported brands");
    for (var brand : java.util.List.of("nvidia", "amd", "intel")) {
      var subset =
          JsonParser.parseString(Files.readString(export.resolve("gpu-presets-" + brand + ".json")))
              .getAsJsonObject();
      check(subset.getAsJsonArray("presets").size() > 0, "separate " + brand + " DB");
      for (var item : subset.getAsJsonArray("presets"))
        check(
            item.getAsJsonObject().get("brand").getAsString().equalsIgnoreCase(brand),
            "no foreign models in " + brand);
    }
    return checks;
  }
}
