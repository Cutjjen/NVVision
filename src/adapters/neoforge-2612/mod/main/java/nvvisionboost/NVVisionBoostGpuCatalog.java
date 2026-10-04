/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostGpuCatalog.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** Active renderer classification; ambiguous driver names deliberately remain unknown. */
public final class NVVisionBoostGpuCatalog {
  public enum Brand {
    NVIDIA,
    AMD,
    INTEL,
    UNKNOWN
  }

  public enum Type {
    INTEGRATED("Integrada"),
    DISCRETE("Dedicada"),
    UNKNOWN("Tipo não determinado");
    public final String label;

    Type(String label) {
      this.label = label;
    }
  }

  public record Identity(Brand brand, Type type) {}

  private NVVisionBoostGpuCatalog() {}

  public static Identity classify(String vendor, String renderer) {
    String v = lower(vendor), n = lower(renderer);
    Brand brand = brand(v);
    if (brand == Brand.UNKNOWN) brand = brand(n);
    Type type = Type.UNKNOWN;
    switch (brand) {
      case NVIDIA -> {
        if (n.matches(".*(geforce|quadro|titan|rtx|gtx|tesla).*|^(gt|mx)\\s*[0-9].*"))
          type = Type.DISCRETE;
      }
      case AMD -> {
        if (n.matches(".*(radeon\\s*(\\(tm\\)\\s*)?rx|radeon pro).*|^rx\\s*[0-9].*"))
          type = Type.DISCRETE;
        else if (n.matches(
            ".*radeon\\s*(\\(tm\\)\\s*)?(890m|880m|860m|8060s|8050s|780m|760m|740m|680m|660m|610m|vega\\s+[0-9]+\\s+graphics).*"))
          type = Type.INTEGRATED;
      }
      case INTEL -> {
        if (n.matches(".*(arc\\s*(\\(tm\\)\\s*)?[ab][0-9]{3}|iris\\s+xe\\s+max).*"))
          type = Type.DISCRETE;
        else if (n.matches(
            ".*(uhd|hd graphics|iris|arc\\s*(\\(tm\\)\\s*)?(140v|130v|140t|130t)).*"))
          type = Type.INTEGRATED;
      }
      default -> {}
    }
    return new Identity(brand, type);
  }

  private static Brand brand(String text) {
    if (text.matches(".*(nvidia|geforce|quadro|rtx|gtx|titan).*|^(gt|mx)\\s*[0-9].*"))
      return Brand.NVIDIA;
    if (text.matches(".*(advanced micro devices|amd|ati technologies|radeon).*|^rx\\s*[0-9].*")
        || text.equals("ati")) return Brand.AMD;
    if (text.matches(".*(intel|iris|uhd|arc [ab][0-9]{3}).*")) return Brand.INTEL;
    return Brand.UNKNOWN;
  }

  private static String lower(String text) {
    return text == null ? "" : text.toLowerCase(Locale.ROOT);
  }

  /** Suggested starting points, not benchmarks or detected memory capacities. */
  public static List<NVVisionBoostGPU.Preset> additionalPresets() {
    List<NVVisionBoostGPU.Preset> presets = new ArrayList<>();
    group(presets, "AMD Radeon ", "Polaris", "AMD RX 500", 0, "RX 550", "RX 560");
    group(presets, "AMD Radeon ", "Polaris", "AMD RX 500", 1, "RX 570", "RX 580", "RX 590");
    group(presets, "AMD Radeon ", "Vega", "AMD RX Vega", 1, "RX Vega 56", "RX Vega 64");
    group(presets, "AMD Radeon ", "RDNA", "AMD RX 5000", 1, "RX 5500 XT", "RX 5600 XT");
    group(presets, "AMD Radeon ", "RDNA", "AMD RX 5000", 2, "RX 5700", "RX 5700 XT");
    group(presets, "AMD Radeon ", "RDNA 2", "AMD RX 6000", 0, "RX 6400", "RX 6500 XT");
    group(
        presets, "AMD Radeon ", "RDNA 2", "AMD RX 6000", 1, "RX 6600", "RX 6600 XT", "RX 6650 XT");
    group(
        presets, "AMD Radeon ", "RDNA 2", "AMD RX 6000", 2, "RX 6700", "RX 6700 XT", "RX 6750 XT");
    group(
        presets,
        "AMD Radeon ",
        "RDNA 2",
        "AMD RX 6000",
        3,
        "RX 6800",
        "RX 6800 XT",
        "RX 6900 XT",
        "RX 6950 XT");
    group(presets, "AMD Radeon ", "RDNA 3", "AMD RX 7000", 1, "RX 7600", "RX 7600 XT");
    group(
        presets,
        "AMD Radeon ",
        "RDNA 3",
        "AMD RX 7000",
        2,
        "RX 7700 XT",
        "RX 7800 XT",
        "RX 7900 GRE");
    group(presets, "AMD Radeon ", "RDNA 3", "AMD RX 7000", 3, "RX 7900 XT", "RX 7900 XTX");
    group(presets, "AMD Radeon ", "RDNA 4", "AMD RX 9000", 2, "RX 9060 XT");
    group(presets, "AMD Radeon ", "RDNA 4", "AMD RX 9000", 3, "RX 9070", "RX 9070 XT");
    group(
        presets,
        "AMD Radeon ",
        "Vega integrada",
        "AMD integrada",
        0,
        "Vega 3 Graphics",
        "Vega 8 Graphics",
        "Vega 11 Graphics");
    group(presets, "AMD Radeon ", "RDNA 2 integrada", "AMD integrada", 0, "610M", "660M", "680M");
    group(presets, "AMD Radeon ", "RDNA 3 integrada", "AMD integrada", 0, "740M", "760M", "780M");
    group(presets, "AMD Radeon ", "RDNA 3.5 integrada", "AMD integrada", 0, "860M", "880M", "890M");
    group(
        presets,
        "Intel ",
        "Gen9 / Gen9.5 integrada",
        "Intel integrada",
        0,
        "HD Graphics 520",
        "HD Graphics 530",
        "HD Graphics 620",
        "HD Graphics 630",
        "UHD Graphics 620",
        "UHD Graphics 630");
    group(
        presets,
        "Intel ",
        "Xe LP integrada",
        "Intel integrada",
        0,
        "UHD Graphics 730",
        "UHD Graphics 770",
        "Iris Xe Graphics");
    group(presets, "Intel ", "Xe2 integrada", "Intel integrada", 0, "Arc 130V", "Arc 140V");
    group(presets, "Intel ", "Xe integrada", "Intel integrada", 0, "Arc 130T", "Arc 140T");
    group(presets, "Intel ", "Xe HPG", "Intel Arc A", 0, "Arc A310", "Arc A380");
    group(presets, "Intel ", "Xe HPG", "Intel Arc A", 1, "Arc A580");
    group(presets, "Intel ", "Xe HPG", "Intel Arc A", 2, "Arc A750", "Arc A770");
    group(presets, "Intel ", "Xe2 HPG", "Intel Arc B", 2, "Arc B570", "Arc B580");
    return List.copyOf(presets);
  }

  private static void group(
      List<NVVisionBoostGPU.Preset> result,
      String prefix,
      String architecture,
      String family,
      int tier,
      String... names) {
    for (String name : names) result.add(recommendation(prefix + name, architecture, family, tier));
  }

  public static NVVisionBoostGPU.Preset fallback(String name, Identity identity) {
    return recommendation(
        name,
        "Modelo não catalogado",
        identity.brand().name() + " / " + identity.type().label,
        identity.type() == Type.INTEGRATED ? 0 : 1);
  }

  private static NVVisionBoostGPU.Preset recommendation(
      String name, String architecture, String family, int tier) {
    // Memory 0 means unknown/shared, never a measurement. Preserve native resolution until
    // selected.
    int[] rd = {8, 12, 16, 20}, scale = {75, 85, 90, 100}, fps = {60, 60, 75, 90};
    return new NVVisionBoostGPU.Preset(
        name,
        architecture,
        family,
        0,
        0,
        fps[tier],
        rd[tier],
        tier == 0 ? 65 : 85,
        scale[tier],
        Math.min(2, tier),
        Math.min(2, tier),
        true,
        true,
        tier < 2,
        false,
        true,
        tier == 0 ? "low" : tier == 3 ? "quality" : "balanced");
  }
}

