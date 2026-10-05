package nvvisionboost;

import java.nio.file.Path;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

/** Local UI help preserves rendering, fonts and other mods' options. */
public final class NVVisionBoostUi {
  private static boolean loaded;
  private static final java.util.Map<Tooltip, String> tooltipText = new java.util.WeakHashMap<>();
  private static boolean joined;

  private static Path preference() {
    return Minecraft.getInstance()
        .gameDirectory
        .toPath()
        .resolve("config/nvvisionboost/ui-language.txt");
  }

  private static void ensure() {
    if (!loaded) {
      NVVisionBoostLanguage.loadPreference(preference());
      loaded = true;
    }
  }

  public static String text(String value) {
    ensure();
    return NVVisionBoostLanguage.text(value);
  }

  public static Component component(String value) {
    return Component.literal(text(value));
  }

  public static Tooltip tooltip(Component message) {
    var result =
        Tooltip.create(component(message.getString() + "\n" + impact(message.getString())));
    tooltipText.put(result, message.getString());
    return result;
  }

  public static Tooltip infoTooltip(Component message) {
    return Tooltip.create(component(message.getString() + "\nImpacto: nenhum; apenas navegação."));
  }

  public static Tooltip enrich(Tooltip original, String label) {
    String description = tooltipText.get(original);
    return description == null
        ? original
        : Tooltip.create(component(description + "\n" + impact(label)));
  }

  public static String help(String label, boolean reverse) {
    ensure();
    return NVVisionBoostHelp.help(label, reverse);
  }

  public static String impact(String label) {
    return NVVisionBoostHelp.impact(label);
  }

  public static void languages(int width, Runnable rebuild, Consumer<Button> add) {
    ensure();
    for (int i = 0; i < 2; i++) {
      final boolean en = i == 1;
      var b =
          NVVisionBoostMenuButton.builder(
                  Component.literal(en ? "EN" : "BR"),
                  ignored -> {
                    NVVisionBoostLanguage.select(en);
                    if (!NVVisionBoostLanguage.savePreference(preference()))
                      System.err.println("NVVision: unable to save UI language preference");
                    rebuild.run();
                  })
              .bounds(Math.max(0, width - 96) + i * 48, 2, 44, 14)
              .build();
      ((NVVisionBoostOptionButton) b).setSelectedStyle(en == NVVisionBoostLanguage.english());
      add.accept(b);
    }
  }

  public static void flag(GuiGraphicsExtractor g, int x, int y, boolean us) {
    if (us) {
      for (int i = 0; i < 7; i++)
        g.fill(x, y + i * 2, x + 14, y + i * 2 + 2, i % 2 == 0 ? 0xFFB22234 : 0xFFFFFFFF);
      g.fill(x, y, x + 7, y + 8, 0xFF3C3B6E);
      for (int row = 0; row < 3; row++)
        for (int col = 0; col < 3; col++)
          g.fill(x + 1 + col * 2, y + 1 + row * 2, x + 2 + col * 2, y + 2 + row * 2, 0xFFFFFFFF);
    } else {
      g.fill(x, y, x + 14, y + 14, 0xFF009C3B);
      for (int row = 0; row < 11; row++) {
        int half = 5 - Math.abs(5 - row);
        g.fill(x + 7 - half, y + 2 + row, x + 8 + half, y + 3 + row, 0xFFFFDF00);
      }
      g.fill(x + 5, y + 5, x + 10, y + 10, 0xFF002776);
      g.fill(x + 5, y + 7, x + 10, y + 8, 0xFFFFFFFF);
    }
  }

  public static void tick() {
    var mc = Minecraft.getInstance();
    boolean now = mc.player != null && mc.level != null;
    if (!now) {
      joined = false;
      return;
    }
    if (joined) return;
    joined = true;
    ensure();
    nvvisionboost.minecraft.MinecraftAccess.get()
        .accessNotice(
            component("NVVision — Configurações"),
            component(
                "Aperte F8 para configurar o mod, ou abra Opções do Minecraft e escolha"
                    + " NVVision."));
  }

  private NVVisionBoostUi() {}
}
