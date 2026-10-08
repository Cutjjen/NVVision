package nvvisionboost;

/** Optional capability discovery without a mandatory dependency or configuration changes. */
public final class NVVisionBoostSodiumExtraAdapter {

  private NVVisionBoostSodiumExtraAdapter() {}

  public static String describe() {

    try {

      Class<?> entry =
          Class.forName(
              "me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod",
              false,
              NVVisionBoostSodiumExtraAdapter.class.getClassLoader());

      Object options = entry.getMethod("options").invoke(null);

      Object extra = options.getClass().getField("extraSettings").get(options);

      boolean panini = extra.getClass().getField("paniniProjection").getBoolean(extra);

      return "Sodium Extra: API reconhecida; Panini="
          + panini
          + "; contrato de pixels vinculado ao framebuffer; opções preservadas";

    } catch (ClassNotFoundException absent) {

      return "Sodium Extra: ausente; contrato padrão de pixels";

    } catch (ReflectiveOperationException | LinkageError changedApi) {

      return "Sodium Extra: API diferente; opções preservadas; contrato padrão de pixels";
    }
  }
}
