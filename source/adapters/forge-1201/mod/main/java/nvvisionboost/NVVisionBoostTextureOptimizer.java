package nvvisionboost;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;

/**
 * Mipmaps pelo carregador nativo: preserva fontes, sprites e metadados dos mods. Não intercepta
 * uploads OpenGL, UVs, atlas ou texturas privadas de renderizadores.
 */
public final class NVVisionBoostTextureOptimizer {
  private static volatile boolean busy;
  private static volatile String status = "Mipmaps nativos: alteração somente pelo botão Aplicar.";
  private static Options trackedOptions;
  private static int originalLevel = -1;

  private NVVisionBoostTextureOptimizer() {}

  public static boolean isBusy() {
    return busy;
  }

  public static String status() {
    return status;
  }

  public static String label(int level) {
    return level < 0 ? "Restaurar sessão" : "Mipmaps " + level;
  }

  public static int next(int level, int direction) {
    int[] values = {-1, 2, 3, 4};
    int index = 0;
    for (int i = 0; i < values.length; i++) if (values[i] == level) index = i;
    return values[Math.floorMod(index + direction, values.length)];
  }

  public static void apply(NVVisionBoostForge.Config config) {
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || mc.options == null || config == null) return;
    if (!RenderSystem.isOnRenderThread()) {
      mc.execute(() -> apply(config));
      return;
    }
    if (busy) {
      status = "Recarga em andamento; aguarde.";
      return;
    }
    if (mc.getOverlay() != null) {
      status = "Aguarde a recarga atual de recursos.";
      return;
    }
    Options options = mc.options;
    if (trackedOptions != options) {
      trackedOptions = options;
      originalLevel = options.mipmapLevels().get();
    }
    int previous = options.mipmapLevels().get();
    int requested =
        config.textureMipmapLevel < 0
            ? originalLevel
            : Math.max(0, Math.min(4, config.textureMipmapLevel));
    if (requested == previous) {
      status = "Mipmaps já configurados: " + requested + ".";
      return;
    }
    NVVisionBoostRenderController.pauseAdaptation(15000L);
    busy = true;
    status = "Recarregando atlas com mipmaps nativos; pode ocorrer uma pausa.";
    NVVisionBoostNativeRenderer.reset();
    try {
      options.mipmapLevels().set(requested);
      mc.updateMaxMipLevel(requested);
      mc.reloadResourcePacks()
          .whenComplete(
              (unused, error) ->
                  mc.execute(
                      () -> {
                        if (error == null) {
                          options.save();
                          busy = false;
                          status =
                              "Mipmaps "
                                  + requested
                                  + " aplicados aos atlas compatíveis; texturas-fonte preservadas.";
                          NVVisionBoostNativeRenderer.invalidate();
                          NVVisionBoostForge.log(status);
                        } else {
                          rollback(mc, options, previous, error);
                        }
                      }));
    } catch (RuntimeException error) {
      rollback(mc, options, previous, error);
    }
  }

  private static void rollback(Minecraft mc, Options options, int previous, Throwable error) {
    NVVisionBoostForge.log("texture reload: " + error);
    try {
      options.mipmapLevels().set(previous);
      mc.updateMaxMipLevel(previous);
      // Recrie também os recursos antigos: restaurar apenas a opção não basta.
      mc.reloadResourcePacks()
          .whenComplete(
              (unused, recovery) ->
                  mc.execute(
                      () -> {
                        busy = false;
                        status =
                            recovery == null
                                ? "Recarga falhou; mipmaps anteriores restaurados."
                                : "Falha também na recuperação; recarregue os recursos ou reinicie"
                                    + " o jogo.";
                        NVVisionBoostForge.log(status);
                        NVVisionBoostNativeRenderer.invalidate();
                      }));
    } catch (RuntimeException recovery) {
      busy = false;
      status = "Falha na recuperação de recursos; reinicie o jogo.";
      NVVisionBoostForge.log("texture rollback: " + recovery);
    }
  }
}
