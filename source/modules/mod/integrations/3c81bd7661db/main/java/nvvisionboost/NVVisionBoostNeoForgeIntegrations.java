package nvvisionboost;

import java.nio.file.Files;
import net.neoforged.fml.ModList;

/** One report per launch; optional mods retain control of their renderers and simulation. */
public final class NVVisionBoostNeoForgeIntegrations {
  private NVVisionBoostNeoForgeIntegrations() {}

  public static void report() {
    StringBuilder text = new StringBuilder("NVVision NeoForge compatibility inventory\n");
    for (String id :
        new String[] {
          "neoforge",
          "iris",
          "sodium",
          "distanthorizons",
          "create",
          "flywheel",
          "createbetterfps",
          "ferritecore",
          "modernfix",
          "entityculling",
          "immediatelyfast",
          "sodiumextra",
          "sodium-extra",
          "reeses_sodium_options",
          "nvvisionvulkanbridge"
        }) {
      var container = ModList.get().getModContainerById(id);
      text.append(id)
          .append('=')
          .append(container.map(c -> c.getModInfo().getVersion().toString()).orElse("absent"))
          .append('\n');
    }
    text.append("clientOnly=true\nremoteInstallationRequired=false\n")
        .append("shaderFramebufferResize=requires-validated-Iris-depth-schema\n")
        .append("distantHorizonsScaleProtection=only-when-detected\n")
        .append("ferriteCoreEditing=requires-matching-schema-and-restart\n")
        .append("dlss=unavailable\nframegen=unavailable\n");
    try {
      Files.writeString(NVVisionBoostCore.root.resolve("neoforge-compatibility.txt"), text);
      NVVisionBoostCore.log(
          "NeoForge integrations: " + NVVisionBoostCompatibility.integrationSummary());
    } catch (Exception error) {
      NVVisionBoostCore.log(
          "Compatibility report unavailable: " + error.getClass().getSimpleName());
    }
  }
}
