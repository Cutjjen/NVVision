package nvvisionboost.vulkanbridge;

import java.nio.file.*;
import java.util.*;
import org.lwjgl.opengl.*;

/** Versioned optional API. It never exposes an internal Vulkan device owned by Mesa. */
public final class BridgeApi {
  private static volatile Map<String, String> current =
      Map.of(
          "protocol",
          "1",
          "state",
          "waiting",
          "backend",
          "unknown",
          "dlss",
          "unavailable",
          "framegen",
          "unavailable");

  private BridgeApi() {}

  public static Map<String, String> snapshot() {
    return current;
  }

  public static String cpuControl(String key) {
    return BridgeCpuOptimizer.control(key);
  }

  public static String cycleCpuControl(String key) {
    return BridgeCpuOptimizer.cycleControl(key);
  }

  public static String cpuProfile() {
    return BridgeCpuOptimizer.mode();
  }

  public static String requestCpuProfile(String value) {
    return BridgeCpuOptimizer.request(value);
  }

  static void inspect() {
    Map<String, String> values = new LinkedHashMap<>();
    values.put("protocol", "1");
    String renderer = GL11.glGetString(GL11.GL_RENDERER),
        version = GL11.glGetString(GL11.GL_VERSION);
    var caps = GL.getCapabilities();
    boolean translated = BridgePolicy.translated(renderer, version, caps.OpenGL30, caps.OpenGL20);
    String backend = BridgePolicy.classify(renderer, version);
    values.put("backend", backend);
    values.put("renderer", String.valueOf(renderer));
    values.put("version", String.valueOf(version));
    values.put("vendor", String.valueOf(GL11.glGetString(GL11.GL_VENDOR)));
    values.put(
        "state",
        translated ? "active" : backend.equals("software-rejected") ? "rejected" : "native");
    values.put(
        "descriptors",
        System.getProperty(
            "nvvisionbridge.descriptors",
            System.getenv().getOrDefault("ZINK_DESCRIPTORS", "auto")));
    values.put("bootstrap", System.getProperty("nvvisionbridge.bootstrap", "absent"));
    values.put(
        "externalMemory",
        Boolean.toString(caps.GL_EXT_memory_object && caps.GL_EXT_memory_object_win32));
    values.put(
        "externalSemaphore",
        Boolean.toString(caps.GL_EXT_semaphore && caps.GL_EXT_semaphore_win32));
    values.put("ownedVulkanDevice", "false");
    values.put("motionVectors", "not-integrated");
    values.put("temporalDepth", "not-integrated");
    values.put("hudlessColor", "not-integrated");
    values.put("temporalSdk", "not-integrated");
    values.put("vulkanPresentation", "mesa-owned");
    values.put("temporalReady", "false");
    values.put("dlss", "unavailable");
    values.put("framegen", "unavailable");
    values.put(
        "temporalReason",
        "SDK, motion vectors, frame resources and Vulkan presentation are not integrated.");
    current = Map.copyOf(values);
  }

  public static String requestBackend(String backend) {
    String home = System.getProperty("nvvisionbridge.home", "");
    if (home.isBlank())
      return "Iniciador ausente. Configure o pacote Bridge antes de selecionar Vulkan.";
    try {
      BridgeFiles.backend(Path.of(home).toAbsolutePath().normalize(), backend);
      return "Perfil salvo: "
          + backend
          + ". Feche o jogo e use o iniciador Bridge; requer nova JVM.";
    } catch (Exception error) {
      return "Perfil não alterado: " + error.getMessage();
    }
  }

  public static String requestDescriptors(String value) {
    String home = System.getProperty("nvvisionbridge.home", "");
    if (home.isBlank()) return "Iniciador ausente.";
    try {
      BridgeFiles.descriptors(Path.of(home).toAbsolutePath().normalize(), value);
      return "Descritores " + value + ": salvo para próximo início. Requer nova JVM.";
    } catch (Exception error) {
      return "Perfil não alterado: " + error.getMessage();
    }
  }

  static void report(Path root) throws java.io.IOException {
    StringBuilder report = new StringBuilder("NVVision Addon 0.2.5-neoforge.4\n");
    current.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(e -> report.append(e.getKey()).append('=').append(e.getValue()).append('\n'));
    BridgeFiles.atomic(root.resolve("bridge-status.txt"), report.toString());
  }
}
