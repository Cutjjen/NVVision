/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostVulkanBridge.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.lang.reflect.Method;
import java.util.*;

/** Optional versioned addon API; no native driver calls, hooks, or mandatory dependency. */
public final class NVVisionBoostVulkanBridge {
  private static Method snapshot, request, descriptors;
  private static boolean resolved;
  private static Map<String, String> status = Map.of("state", "absent", "backend", "opengl");
  private static long nextRefresh;

  private NVVisionBoostVulkanBridge() {}

  public static boolean present() {
    return NVVisionBoostCompatibility.loaded("nvvisionvulkanbridge");
  }

  private static void resolve() throws ReflectiveOperationException {
    if (resolved || !present()) return;
    Class<?> type = Class.forName("nvvisionboost.vulkanbridge.BridgeApi");
    snapshot = type.getMethod("snapshot");
    request = type.getMethod("requestBackend", String.class);
    descriptors = type.getMethod("requestDescriptors", String.class);
    resolved = true;
  }

  public static Map<String, String> decode(Object value) {
    if (!(value instanceof Map<?, ?> input) || !"1".equals(input.get("protocol")))
      return Map.of("state", "incompatible", "backend", "unknown");
    Map<String, String> result = new LinkedHashMap<>();
    for (String name :
        List.of(
            "state",
            "backend",
            "renderer",
            "vendor",
            "version",
            "bootstrap",
            "descriptors",
            "externalMemory",
            "externalSemaphore",
            "temporalReason")) {
      Object item = input.get(name);
      if (item instanceof String text)
        result.put(name, text.substring(0, Math.min(512, text.length())));
    }
    // Temporal SDKs are not implemented by this version of the parent mod.
    result.put("dlss", "unavailable");
    result.put("framegen", "unavailable");
    return Map.copyOf(result);
  }

  public static Map<String, String> status() {
    long now = System.nanoTime();
    if (now < nextRefresh) return status;
    nextRefresh = now + 1_000_000_000L;
    if (!present()) {
      status = Map.of("state", "absent", "backend", "opengl");
      return status;
    }
    try {
      resolve();
      status = decode(snapshot.invoke(null));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError error) {
      status = Map.of("state", "unavailable", "backend", "unknown");
    }
    return status;
  }

  public static String summary() {
    Map<String, String> s = status();
    return "VulkanBridge="
        + s.getOrDefault("state", "unknown")
        + " / "
        + s.getOrDefault("backend", "unknown");
  }

  public static String requestBackend(String backend) {
    if (!present()) return "Addon não instalado.";
    if (!Set.of("opengl", "zink").contains(backend)) return "Backend inválido.";
    try {
      resolve();
      return String.valueOf(request.invoke(null, backend));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError error) {
      return "Addon indisponível; renderizador atual preservado.";
    }
  }

  public static String requestDescriptors(String mode) {
    if (!present() || !Set.of("auto", "lazy").contains(mode))
      return "Modo de descritores indisponível.";
    try {
      resolve();
      return String.valueOf(descriptors.invoke(null, mode));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError error) {
      return "Addon indisponível; estado atual preservado.";
    }
  }

  public static String cpuControl(String key) {
    if (!present()) return "off";
    try { return String.valueOf(Class.forName("nvvisionboost.vulkanbridge.BridgeApi").getMethod("cpuControl",String.class).invoke(null,key)); }
    catch (ReflectiveOperationException | LinkageError error) { return "off"; }
  }
  public static String cycleCpuControl(String key) {
    if (!present()) return "Addon não instalado.";
    try { return String.valueOf(Class.forName("nvvisionboost.vulkanbridge.BridgeApi").getMethod("cycleCpuControl",String.class).invoke(null,key)); }
    catch (ReflectiveOperationException | LinkageError error) { return "Addon CPU indisponível."; }
  }
  public static String cpuProfile() {
    if (!present()) return "off";
    try { return String.valueOf(Class.forName("nvvisionboost.vulkanbridge.BridgeApi").getMethod("cpuProfile").invoke(null)); }
    catch (ReflectiveOperationException | LinkageError error) { return "off"; }
  }
  public static String cycleCpuProfile() {
    String next = switch(cpuProfile()) { case "off" -> "balanced"; case "balanced" -> "economy"; case "economy" -> "custom"; default -> "off"; };
    try { return String.valueOf(Class.forName("nvvisionboost.vulkanbridge.BridgeApi").getMethod("requestCpuProfile",String.class).invoke(null,next)); }
    catch (ReflectiveOperationException | LinkageError error) { return "Addon CPU indisponível."; }
  }
}
