package nvvisionboost;

import java.util.concurrent.CompletableFuture;
import net.minecraft.client.Minecraft;

/** Preserves native font/atlas reload; owns only NVVision render resources. */
public final class NVVisionBoostResourceReload {
  private static int pending;

  private NVVisionBoostResourceReload() {}

  public static boolean active() {
    return pending > 0;
  }

  public static void begin() {
    pending++;
    NVVisionBoostNativeRenderer.reset();
    NVVisionBoostRenderController.pauseAdaptation(15000L);
  }

  public static void track(CompletableFuture<Void> future) {
    if (future == null) {
      finish(null);
      return;
    }
    future.whenComplete((value, error) -> Minecraft.getInstance().execute(() -> finish(error)));
  }

  private static void finish(Throwable error) {
    pending = Math.max(0, pending - 1);
    NVVisionBoostNativeRenderer.reset();
    NVVisionBoostRenderController.pauseAdaptation(15000L);
    if (NVVisionBoostCore.cfg != null)
      NVVisionBoostCore.log(
          error == null
              ? "Recarga nativa concluída; recursos NVVision invalidados; fontes e pipeline Iris"
                  + " preservados."
              : "Recarga nativa falhou: " + error);
  }
}
