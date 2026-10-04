package nvvisionboost;

import net.neoforged.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class VisionOptimizer {
  private static final Logger LOGGER = LogManager.getLogger("NVVision-Optimizer");

  public static final int PROFILE_QUALITY = 1;
  public static final int PROFILE_BALANCED = 2;
  public static final int PROFILE_PERFORMANCE = 3;

  private static boolean enabled = true;
  private static int performanceProfile = PROFILE_BALANCED;

  private VisionOptimizer() {}

  public static void applySettings(int profile, boolean status) {
    performanceProfile = normalizeProfile(profile);
    enabled = status;

    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

    if (cfg == null) {
      LOGGER.warn(
          "[NVVisionBoost] Configuração indisponível. " + "Estado solicitado: {} | perfil: {}.",
          status,
          profileName(performanceProfile));
      return;
    }

    // O botão mestre controla o mod. Desligar o upscaling,
    // separadamente, não desliga as demais otimizações.
    cfg.enabled = status;

    if (!status) {
      disableOptimizations(cfg);
      return;
    }

    try {
      configurePerformanceProfile(cfg);
      NVVisionBoostHardwareBudget.constrain(cfg);

      analyzeHardwareResources();

      if (isModLoaded("embeddium") || isModLoaded("sodium")) {
        optimizeSodiumEmbeddiumPipeline();
      }

      if (isModLoaded("oculus") || isModLoaded("iris")) {
        forceIrisPerformanceState();
      }

      configureCreateCompatibility();

      // Aplica opções reais do Minecraft uma única vez.
      // Não troca o backend do Flywheel ou do shaderpack.
      NVVisionBoostRenderController.applyNow(cfg);

      NVVisionBoostCore.saveConfig();

      // A preparação do próximo frame trata as mudanças.
      // Não recarregue shaders diretamente neste método.
      NVVisionBoostNativeRenderer.invalidate();

      LOGGER.info(
          "[NVVisionBoost] Otimizador ativado. " + "Perfil: {} | escala preservada: {}% | {}.",
          profileName(performanceProfile),
          cfg.renderScalePercent,
          NVVisionBoostCreateCompatibility.summary());
    } catch (Exception error) {
      LOGGER.error("[NVVisionBoost] Falha ao aplicar o perfil de otimização.", error);
    }
  }

  private static void configurePerformanceProfile(NVVisionBoostCore.Config cfg) {
    switch (performanceProfile) {
      case PROFILE_QUALITY -> {
        cfg.profile = "quality";

        cfg.animationLevel = 3;
        cfg.transparencyLevel = 3;

        if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
          cfg.entityDistancePercent = 100;
        }
      }

      case PROFILE_PERFORMANCE -> {
        cfg.profile = "low";

        cfg.animationOptimization = true;
        cfg.transparencyOptimization = true;

        cfg.animationLevel = 1;
        cfg.transparencyLevel = 1;

        cfg.reduceParticles = true;
        cfg.disableClouds = true;

        if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
          cfg.entityOptimization = true;
          cfg.entityDistancePercent = 80;
        }
      }

      default -> {
        cfg.profile = "balanced";

        cfg.animationOptimization = true;
        cfg.transparencyOptimization = true;

        cfg.animationLevel = 2;
        cfg.transparencyLevel = 2;

        cfg.reduceParticles = true;

        if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
          cfg.entityOptimization = true;
          cfg.entityDistancePercent = 90;
        }
      }
    }

    // Não modifica:
    // - renderScalePercent;
    // - upscalingEnabled;
    // - dynamicResolution;
    // - autoOptimize;
    // - seleção ou opções internas do shaderpack.
  }

  private static void analyzeHardwareResources() {
    try {
      // Preserva a chamada ao gerenciador existente.
      // As capacidades efetivas dependem da implementação dele.
      NVVisionVramManager.analyzeAndAllocateVram();
    } catch (Exception error) {
      LOGGER.warn("[NVVisionBoost] Falha na análise de recursos da GPU.", error);
    }
  }

  private static void optimizeSodiumEmbeddiumPipeline() {
    if (!isEnabled()) {
      return;
    }

    try {
      NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

      if (cfg == null) {
        return;
      }

      // O perfil configura opções públicas do Minecraft.
      // Embeddium/Sodium continuam controlando chunks, buffers
      // e seus mecanismos internos de renderização.
      if (performanceProfile != PROFILE_QUALITY) {
        cfg.animationOptimization = true;
        cfg.transparencyOptimization = true;
      }

      LOGGER.info(
          "[NVVisionBoost] Cooperação com Embeddium/Sodium: "
              + "perfil {} preparado; opções serão aplicadas "
              + "pelo controlador do NVVision.",
          profileName(performanceProfile));
    } catch (Exception error) {
      LOGGER.warn("[NVVisionBoost] Falha ao preparar opções " + "para Embeddium/Sodium.", error);
    }
  }

  private static void forceIrisPerformanceState() {
    if (!isEnabled()) {
      return;
    }

    try {
      NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

      if (cfg == null) {
        return;
      }

      // Mantém o nome da rotina por continuidade.
      // A preparação é genérica para qualquer shaderpack,
      // sem trocar sua seleção ou forçar opções internas.
      if (performanceProfile != PROFILE_QUALITY) {
        cfg.shaderCache = true;
        cfg.shaderWarmup = true;
      }

      String shaderName = NVVisionBoostCompatibility.externalShaderPackName();

      if (shaderName == null || shaderName.isBlank()) {
        shaderName = "nenhum identificado";
      }

      LOGGER.info(
          "[NVVisionBoost] Preparação de shaders: "
              + "perfil {} | pack {} | cache={} | warmup={}. "
              + "Compilação GPU permanece com o backend.",
          profileName(performanceProfile),
          shaderName,
          cfg.shaderCache,
          cfg.shaderWarmup);
    } catch (Exception error) {
      LOGGER.warn(
          "[NVVisionBoost] Falha ao preparar a cooperação " + "com o backend de shaders.", error);
    }
  }

  private static void configureCreateCompatibility() {
    if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
      return;
    }

    // O RenderController preserva a distância de simulação
    // e de entidades quando Create/Flywheel estão presentes.
    //
    // O DynamicController respeita a proteção contra mudanças
    // automáticas de escala. A escala manual continua disponível.
    //
    // Não modifica ticks das máquinas, contraptions, instancing,
    // batching nem a configuração dos addons do Flywheel.
    LOGGER.info(
        "[NVVisionBoost] Proteção de compatibilidade: {}.",
        NVVisionBoostCreateCompatibility.summary());
  }

  private static void disableOptimizations(NVVisionBoostCore.Config cfg) {
    try {
      // cfg.enabled=false faz o controlador restaurar
      // as opções do jogador capturadas anteriormente.
      NVVisionBoostRenderController.applyNow(cfg);

      NVVisionBoostCore.saveConfig();

      // O renderer observa o estado mestre no próximo frame
      // e retorna ao passe nativo, preservando a configuração
      // de escala para uma futura reativação.
      NVVisionBoostNativeRenderer.invalidate();

      LOGGER.info(
          "[NVVisionBoost] Otimizador desativado. "
              + "Opções capturadas restauradas; "
              + "seleção de shader e escala configurada preservadas.");
    } catch (Exception error) {
      LOGGER.error("[NVVisionBoost] Falha ao desativar as otimizações.", error);
    }
  }

  private static boolean isModLoaded(String modId) {
    try {
      return ModList.get().isLoaded(modId);
    } catch (Exception error) {
      LOGGER.debug("[NVVisionBoost] Não foi possível consultar o mod {}.", modId, error);
      return false;
    }
  }

  private static int normalizeProfile(int profile) {
    return Math.max(PROFILE_QUALITY, Math.min(PROFILE_PERFORMANCE, profile));
  }

  private static String profileName(int profile) {
    return switch (normalizeProfile(profile)) {
      case PROFILE_QUALITY -> "Qualidade";
      case PROFILE_PERFORMANCE -> "Desempenho";
      default -> "Balanceado";
    };
  }

  public static int getPerformanceProfile() {
    return performanceProfile;
  }

  public static boolean isEnabled() {
    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

    // A configuração é a referência principal, inclusive quando
    // o botão mestre é alterado diretamente na interface.
    return cfg != null ? cfg.enabled : enabled;
  }
}
