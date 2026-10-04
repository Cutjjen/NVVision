/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostCreatePresets.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.LinkedHashMap;
import java.util.Properties;

/** Optional visual-only adapter to Create's real client config; no rendering mixins. */
public final class NVVisionBoostCreatePresets {
  private static int lastMode = -1;
  private static Object lastClient;
  private static long nextCheck;
  private static String status = "Presets Create desligados.";

  private NVVisionBoostCreatePresets() {}

  public static String modeName(int mode) {
    return switch (mode) {
      case 1 -> "Equilibrado";
      case 2 -> "Desempenho";
      case 3 -> "Mínimo visual";
      default -> "Original / restaurar";
    };
  }

  public static String integrations() {
    StringBuilder result =
        new StringBuilder(
            NVVisionBoostCompatibility.loaded("create") ? "Create" : "Create ausente");
    for (String id :
        new String[] {
          "createbetterfps", "embeddium", "sodium", "ocuwheel", "modernfix", "entityculling"
        }) if (NVVisionBoostCompatibility.loaded(id)) result.append(" + ").append(id);
    return result.toString();
  }

  public static void tick(NVVisionBoostCore.Config cfg) {
    long now = System.nanoTime();
    if (now < nextCheck || cfg == null) return;
    nextCheck = now + 1_000_000_000L;
    if (!NVVisionBoostCompatibility.loaded("create")) return;
    int mode = cfg.enabled ? cfg.createPerformancePreset : 0;
    try {
      Object client = null;
      for (String name :
          new String[] {
            "com.simibubi.create.infrastructure.config.AllConfigs",
            "com.simibubi.create.foundation.config.AllConfigs"
          }) {
        try {
          client = Class.forName(name).getMethod("client").invoke(null);
          break;
        } catch (ClassNotFoundException ignored) {
        }
      }
      if (client == null || (lastMode == mode && lastClient == client)) return;
      lastMode = mode;
      lastClient = client;
      apply(client, mode, NVVisionBoostCore.root.resolve("create-preset-backup.properties"));
      status = "Create: " + modeName(mode) + "; " + integrations();
      NVVisionBoostCore.log("[NVVB Create] " + status);
    } catch (ReflectiveOperationException | java.io.IOException | RuntimeException | LinkageError error) {
      String failure = "Preset Create não aplicado: " + error.getClass().getSimpleName();
      if (!failure.equals(status)) NVVisionBoostCore.log("[NVVB Create] " + failure);
      status = failure;
      nextCheck = now + 30_000_000_000L;
    }
  }

  /** Also used with config fixtures to test backup/recovery across application sessions. */
  static void apply(Object client, int mode, Path backup)
      throws ReflectiveOperationException, java.io.IOException {
    if (mode == 0 && !Files.exists(backup)) return;
    String[] names = {"fanParticleDensity", "filterItemRenderDistance"};
    var values = new LinkedHashMap<String, Object>();
    var current = new LinkedHashMap<String, Double>();
    for (String name : names) {
      Object value = client.getClass().getField(name).get(client);
      values.put(name, value);
      double number = ((Number) value.getClass().getMethod("get").invoke(value)).doubleValue();
      if (!Double.isFinite(number))
        throw new IllegalStateException("Valor Create inválido: " + name);
      current.put(name, number);
    }
    Properties saved = new Properties();
    if (Files.exists(backup)) {
      try (var reader = Files.newBufferedReader(backup)) {
        saved.load(reader);
      }
    }
    if (mode == 0) {
      if (saved.isEmpty()) return;
      for (String name : names) {
        double previous = Double.parseDouble(saved.getProperty(name));
        double applied = Double.parseDouble(saved.getProperty(name + ".applied"));
        // Preserve edits subsequently made through Create or another config mod.
        if (Double.compare(current.get(name), applied) == 0) set(values.get(name), previous);
      }
      Files.deleteIfExists(backup);
      return;
    }
    for (String name : names)
      if (!saved.containsKey(name)) saved.setProperty(name, current.get(name).toString());
    double[] caps =
        switch (mode) {
          case 1 -> new double[] {.25, 8};
          case 2 -> new double[] {.10, 6};
          case 3 -> new double[] {0, 4};
          default -> throw new IllegalArgumentException("Preset inválido");
        };
    double[] targets = new double[2];
    for (int i = 0; i < names.length; i++) {
      targets[i] = Math.min(Double.parseDouble(saved.getProperty(names[i])), caps[i]);
      saved.setProperty(names[i] + ".applied", Double.toString(targets[i]));
    }
    // Durable snapshot precedes mutation: restart/crash must not lose original preferences.
    writeBackup(saved, backup);
    try {
      for (int i = 0; i < names.length; i++) set(values.get(names[i]), targets[i]);
    } catch (ReflectiveOperationException failure) {
      // Record what actually changed so a failed setter never loses recovery data.
      for (String name : names) {
        Object actual = values.get(name).getClass().getMethod("get").invoke(values.get(name));
        saved.setProperty(name + ".applied", actual.toString());
      }
      writeBackup(saved, backup);
      throw failure;
    }
  }

  private static void writeBackup(Properties saved, Path backup) throws java.io.IOException {
    Files.createDirectories(backup.toAbsolutePath().getParent());
    StringWriter text = new StringWriter();
    saved.store(text, "NVVisionBoost: originais e último preset Create aplicado");
    Path temp = backup.resolveSibling(backup.getFileName() + ".tmp");
    Files.writeString(temp, text.toString());
    try {
      Files.move(temp, backup, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
    } catch (AtomicMoveNotSupportedException ignored) {
      Files.move(temp, backup, StandardCopyOption.REPLACE_EXISTING);
    }
  }

  private static void set(Object configValue, double number) throws ReflectiveOperationException {
    Method setter = configValue.getClass().getMethod("set", Object.class);
    setter.invoke(configValue, number);
  }

  public static String status() {
    return status;
  }
}
