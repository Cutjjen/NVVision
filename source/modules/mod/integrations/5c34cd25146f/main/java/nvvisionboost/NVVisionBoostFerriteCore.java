package nvvisionboost;

import java.lang.reflect.Modifier;
import java.util.*;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;

<<<<<<< HEAD
/** Query the public optional API and configure the next launch. */
=======
/** Integração opcional: apenas consulta API pública e configura a próxima inicialização. */
>>>>>>> origin/master
public final class NVVisionBoostFerriteCore {
  public record Detection(
      boolean installed, boolean supported, String status, Map<String, Boolean> runtime) {}

  public static Detection detect() {
    if (!NVVisionBoostCompatibility.loaded("ferritecore"))
      return new Detection(false, false, "FerriteCore não instalado (opcional)", Map.of());
    String version =
        ModList.get()
            .getModContainerById("ferritecore")
            .orElseThrow()
            .getModInfo()
            .getVersion()
            .toString();
    try {

      Class<?> type = Class.forName("malte0811.ferritecore.mixin.config.FerriteConfig");
      Map<String, Boolean> runtime = new LinkedHashMap<>();
      for (var field : type.getFields())
        if (Modifier.isStatic(field.getModifiers())
            && field.getType().getSimpleName().equals("Option")) {
          Object option = field.get(null);
          Class<?> api = option.getClass();
          String key = (String) api.getMethod("getName").invoke(option);
          runtime.put(key, (Boolean) api.getMethod("isEnabled").invoke(option));
          var known =
              NVVisionBoostFerriteOptions.ALL.stream()
                  .filter(o -> o.key().equals(key))
                  .findFirst()
                  .orElseThrow();
          if (!Boolean.valueOf(known.initial())
              .equals(api.getMethod("getDefaultValue").invoke(option)))
            throw new IllegalStateException("Esquema alterado");
        }
      if (runtime.size() != NVVisionBoostFerriteOptions.ALL.size())
        throw new IllegalStateException("Esquema alterado");
      return new Detection(
          true, true, "FerriteCore " + version, Collections.unmodifiableMap(runtime));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
      return new Detection(true, false, "FerriteCore " + version + ": API não validada", Map.of());
    }
  }

  public static NVVisionBoostFerriteConfig configuration() {
    return new NVVisionBoostFerriteConfig(
        FMLPaths.CONFIGDIR.get().resolve("ferritecore-mixin.toml"),
        NVVisionBoostCore.root.resolve("ferritecore-backup"));
  }

  private NVVisionBoostFerriteCore() {}
}
