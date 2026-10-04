package nvvisionboost.vulkanbridge;

import java.util.Locale;

/** Pure policy: branding and a Vulkan version alone never enable SDK effects. */
public final class BridgePolicy {
  private BridgePolicy() {}

  public static String classify(String renderer, String version) {
    String text =
        (String.valueOf(renderer) + " " + String.valueOf(version)).toLowerCase(Locale.ROOT);
    if (text.contains("llvmpipe")
        || text.contains("lavapipe")
        || text.contains("softpipe")
        || text.contains("software")) return "software-rejected";
    return text.contains("zink") ? "zink" : "opengl";
  }

  public static boolean translated(
      String renderer, String version, boolean framebuffer, boolean shaders) {
    return classify(renderer, version).equals("zink") && framebuffer && shaders;
  }
}
