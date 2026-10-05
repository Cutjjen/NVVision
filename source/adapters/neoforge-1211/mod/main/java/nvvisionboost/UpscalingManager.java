package nvvisionboost;

/**
<<<<<<< HEAD
 * Manage internal world resolution without changing physical window dimensions, fullscreen mode or
 * monitor size. The renderer reconstructs the reduced world into the native framebuffer.
=======
 * Gerencia a escala de renderização INTERNA do NV Vision Boost.
 *
 * <p>Importante: este componente nunca altera a resolução da janela, modo fullscreen, tamanho do
 * monitor ou dimensões do Minecraft. A janela continua 100% do tamanho original; somente o
 * framebuffer usado pelo passe 3D do mundo é reduzido e depois reconstruído para o framebuffer
 * original.
>>>>>>> origin/master
 */
public final class UpscalingManager {
  public enum UpscalePreset {
    ULTRA_LOW("Ultra Performance (50% Res)", 0.50f),
    HD("HD Balanceado (75% Res)", 0.75f),
    FULL_HD("Full HD Nativo (100%)", 1.00f),
    ULTRA_QUALITY("Qualidade Máxima (100% Nativo)", 1.00f);

    private final String displayName;
    private final float scaleFactor;

    UpscalePreset(String displayName, float scaleFactor) {
      this.displayName = displayName;
      this.scaleFactor = scaleFactor;
    }

    public String getDisplayName() {
      return displayName;
    }

    public float getScaleFactor() {
      return scaleFactor;
    }
  }

  private static UpscalePreset currentPreset = UpscalePreset.HD;

  private UpscalingManager() {}

  public static void setPreset(UpscalePreset preset) {
    if (preset == null) {
      NVVisionBoostLogger.logFailure(
          "Definição de Preset de Upscaling", "O preset fornecido é nulo.");
      return;
    }

    currentPreset = preset;
    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;
    if (cfg != null) {
      int percent = Math.round(preset.getScaleFactor() * 100.0f);
      cfg.renderScalePercent = clamp(percent, 10, 100);
      cfg.upscalingEnabled = cfg.renderScalePercent < 100;
      NVVisionBoostCore.saveConfig();
    }
    applyCurrentResolution();
    NVVisionBoostLogger.logSuccess("Preset de Upscaling alterado para: " + preset.getDisplayName());
  }

  public static UpscalePreset getCurrentPreset() {
    syncPresetFromConfig();
    return currentPreset;
  }

<<<<<<< HEAD
  /** Return calculated internal dimensions without modifying the window. */
=======
  /** Retorna a resolução interna calculada sem modificar a janela. */
>>>>>>> origin/master
  public static String getActiveResolutionInfo() {
    if (NVVisionBoostNativeRenderer.isProcessingBlocked())
      return "Upscaling suspenso: " + NVVisionBoostNativeRenderer.lastError();
    if (!NVVisionBoostCreateCompatibility.allowsFramebufferScaling())
      return NVVisionBoostCreateCompatibility.scalingReason();
    if (getScalePercent() >= 100) return "100% nativo (upscaling inativo)";
    return NVVisionBoostNativeRenderer.measuredResolutionInfo();
  }

  /**
<<<<<<< HEAD
   * Apply logical upscaler state without resizeDisplay or window changes; the renderer prepares the
   * internal target at world-pass entry.
=======
   * Aplica somente o estado lógico do upscaler. Não chama resizeDisplay() e não altera
   * Minecraft.getWindow(). O framebuffer interno é criado pelo renderer no início do passe de
   * LevelRenderer.
>>>>>>> origin/master
   */
  public static void applyCurrentResolution() {
    try {
      syncPresetFromConfig();
      NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;
      boolean active =
          !NVVisionBoostNativeRenderer.isProcessingBlocked()
              && cfg != null
              && cfg.isEnabled()
              && cfg.upscalingEnabled
              && NVVisionBoostCreateCompatibility.allowsFramebufferScaling();
      int percent = active && cfg != null ? clamp(cfg.renderScalePercent, 10, 100) : 100;
      float sharpness = cfg != null ? clamp(cfg.upscalerSharpnessPercent, 0, 100) / 100.0f : 0.0f;

<<<<<<< HEAD
      // Legacy compatibility fields are informational only.
      // These values do not resize the window.
      System.setProperty("nvvision.upscale.sharpness", Float.toString(sharpness));
      System.setProperty("nvvision.render.scale", Float.toString(percent / 100.0f));

      // Effective scale may be 100% while the mod is disabled.
      // Preserve the selected scale and toggle for the next activation.
=======
      // Compatibilidade com componentes antigos: são apenas valores informativos.
      // Nenhum deles é usado para redimensionar a janela.
      System.setProperty("nvvision.upscale.sharpness", Float.toString(sharpness));
      System.setProperty("nvvision.render.scale", Float.toString(percent / 100.0f));

      // A escala efetiva pode ser 100% enquanto o mod está desligado.
      // Preserve a escala e o toggle escolhidos para a próxima ativação.
>>>>>>> origin/master

      NVVisionBoostLogger.logSuccess(
          "Upscaling interno: "
              + (active ? percent + "%" : "100% nativo")
              + " | Janela preservada | "
              + getActiveResolutionInfo());
    } catch (Throwable e) {
      NVVisionBoostLogger.logError("Erro ao aplicar escala interna e nitidez", e);
    }
  }

  public static int getScalePercent() {
    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;
    if (NVVisionBoostNativeRenderer.isProcessingBlocked()
        || cfg == null
        || !cfg.isEnabled()
        || !cfg.upscalingEnabled
        || !NVVisionBoostCreateCompatibility.allowsFramebufferScaling()) return 100;
    return clamp(cfg.renderScalePercent, 10, 100);
  }

  public static float getScaleFactor() {
    return getScalePercent() / 100.0f;
  }

  public static int getInternalWidth(int windowWidth) {
    return scaledDimension(windowWidth, getScalePercent(), 1);
  }

  public static int getInternalHeight(int windowHeight) {
    return scaledDimension(windowHeight, getScalePercent(), 1);
  }

  private static void syncPresetFromConfig() {
    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;
    if (cfg == null) return;
    int p = clamp(cfg.renderScalePercent, 10, 100);
    if (p <= 50) currentPreset = UpscalePreset.ULTRA_LOW;
    else if (p < 100) currentPreset = UpscalePreset.HD;
    else currentPreset = UpscalePreset.FULL_HD;
  }

  private static int scaledDimension(int original, int percent, int minimum) {
    if (original <= 0) return minimum;
    return Math.max(minimum, Math.round(original * (percent / 100.0f)));
  }

  private static int clamp(int value, int min, int max) {
    return Math.max(min, Math.min(max, value));
  }
}
