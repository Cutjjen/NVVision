/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostCore.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NVVisionBoostCore {
  public static final String ID = "nvvisionboost";
  public static final String VERSION = "0.8.3-neoforge.7";
  public static final int CONFIG_SCHEMA = 5;

  static Path root;
  static Path cfgFile;
  static Path shaderDir;
  static Path cacheDir;
  static Path machineProfileFile;

  static Config cfg;

  static volatile int fps;
  static volatile double emaFrame;
  static volatile long spikes;
  static volatile long samples;

  private static final Pattern JSON_STRING =
      Pattern.compile("\\\"%s\\\"\\s*:\\s*\\\"((?:\\\\.|[^\\\"])*)\\\"");

  private static long lastAdaptSample;
  private static long lastMetricsMs;
  private static boolean clientHardwareChecked;
  private static boolean preservePreferencesOnUpgrade;

  public NVVisionBoostCore() {
    try {
      Path game = nvvisionboost.platform.Platform.get().gameDirectory();

      root = nvvisionboost.platform.Platform.get().configDirectory().resolve(ID);

      cfgFile = root.resolve("nvvisionboost.json");

      machineProfileFile = root.resolve("machine-profile.json");

      shaderDir = game.resolve("shaderpacks");

      cacheDir = root.resolve("shader-cache");

      Files.createDirectories(root);
      try {
        if (NVVisionBoostCacheMaintenance.update(root, VERSION)) {
          preservePreferencesOnUpgrade = Files.isRegularFile(cfgFile);
          log("Caches gerados atualizados para " + VERSION + "; configurações preservadas.");
        }
      } catch (java.io.IOException cacheError) {
        log(
            "Limpeza de cache não concluída; nova tentativa no próximo início: "
                + cacheError.getMessage());
      }
      Files.createDirectories(shaderDir);
      Files.createDirectories(cacheDir);

      cfg = Config.load(cfgFile);

      NVVisionBoostGPU.Info gpu = NVVisionBoostGPU.detect();

      String fingerprint = machineFingerprint(gpu);

      MachineProfile saved = MachineProfile.load(machineProfileFile);

      boolean profileChanged =
          !"Unknown GPU".equals(gpu.name)
              && (saved == null || !fingerprint.equals(saved.fingerprint));

      NVVisionBoostGPU.writePresetDatabase(root);

      if (profileChanged && cfg.enabled && cfg.autoOptimize && !preservePreferencesOnUpgrade) {
        NVVisionBoostGPU.Preset preset = NVVisionBoostGPU.presetFor(gpu.name);

        if (preset != null) {
          NVVisionBoostGPU.applyPreset(cfg, preset);

          cfg.gpuPresetApplied = true;
        } else {
          cfg.gpuPresetApplied = false;
        }

        /*
         * Iris é responsável pela execução dos
         * shaderpacks.
         */
        cfg.nativeShaderRenderer = false;

        cfg.rendererBackend = NVVisionBoostCompatibility.oculus() ? "iris-compatible" : "auto";

        cfg.irisIntegration = NVVisionBoostCompatibility.externalShaderBackendAvailable();

        saveConfig();

        MachineProfile.capture(gpu, fingerprint, cfg).save(machineProfileFile);

        log("Hardware profile refreshed for " + gpu.name);
      }

      NVVisionBoostShaderEngine.refresh(game, cfg);

      writeReadme();

      log("NV Vision Boost " + VERSION + " initialized");

      log("Integration: " + NVVisionBoostCompatibility.integrationSummary());
      log(NVVisionBoostVulkanBridge.summary());
    } catch (Throwable e) {
      log("init: " + e);
    }
  }

  // ============================================================
  // GAME DIRECTORY
  // ============================================================


  // ============================================================
  // MACHINE PROFILE
  // ============================================================

  private static String machineFingerprint(NVVisionBoostGPU.Info gpu) {
    try {
      String raw =
          System.getProperty("os.name", "")
              + '|'
              + System.getProperty("os.arch", "")
              + '|'
              + Runtime.getRuntime().availableProcessors()
              + '|'
              + gpu.vendor
              + '|'
              + gpu.name
              + '|'
              + gpu.driver
              + "|hardware-policy-4|"
              + gpu.cpu
              + "|"
              + gpu.cores
              + "|"
              + gpu.threads
              + "|"
              + gpu.allocatedRamMB
              + "|"
              + gpu.totalMemoryMB;

      byte[] digest =
          MessageDigest.getInstance("SHA-256").digest(raw.getBytes(StandardCharsets.UTF_8));

      StringBuilder out = new StringBuilder(digest.length * 2);

      for (byte b : digest) {
        out.append(String.format(Locale.ROOT, "%02x", b));
      }

      return out.toString();
    } catch (Exception e) {
      return "unknown";
    }
  }

  static final class MachineProfile {
    String fingerprint;
    String optimizationVersion;
    String gpu;
    String driver;
    String profile;
    String timestamp;

    static MachineProfile load(Path path) {
      if (path == null || !Files.isRegularFile(path)) {
        return null;
      }

      try {
        String json = Files.readString(path, StandardCharsets.UTF_8);

        MachineProfile profile = new MachineProfile();

        profile.fingerprint = stringValue(json, "fingerprint", "");

        profile.optimizationVersion = stringValue(json, "optimizationVersion", "");

        profile.gpu = stringValue(json, "gpu", "");

        profile.driver = stringValue(json, "driver", "");

        profile.profile = stringValue(json, "profile", "");

        profile.timestamp = stringValue(json, "timestamp", "");

        return profile;
      } catch (Exception e) {
        return null;
      }
    }

    static MachineProfile capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config) {
      MachineProfile profile = new MachineProfile();

      profile.fingerprint = fingerprint;

      profile.optimizationVersion = VERSION;

      profile.gpu = gpu.name;

      profile.driver = gpu.driver;

      profile.profile = config.profile;

      profile.timestamp = Instant.now().toString();

      return profile;
    }

    void save(Path path) {
      String json =
          "{\n"
              + "  \"optimizationVersion\": \""
              + NVVisionBoostIO.jsonString(optimizationVersion)
              + "\",\n"
              + "  \"fingerprint\": \""
              + NVVisionBoostIO.jsonString(fingerprint)
              + "\",\n"
              + "  \"gpu\": \""
              + NVVisionBoostIO.jsonString(gpu)
              + "\",\n"
              + "  \"driver\": \""
              + NVVisionBoostIO.jsonString(driver)
              + "\",\n"
              + "  \"profile\": \""
              + NVVisionBoostIO.jsonString(profile)
              + "\",\n"
              + "  \"timestamp\": \""
              + NVVisionBoostIO.jsonString(timestamp)
              + "\"\n"
              + "}\n";

      try {
        NVVisionBoostIO.writeUtf8(path, json);
      } catch (Exception e) {
        log("machine profile save: " + e);
      }
    }
  }

  // ============================================================
  // CLIENT TICK
  // ============================================================

  static void tickClient() {
    NVVisionBoostUi.tick();
    Config config = cfg;

    if (config == null) {
      return;
    }

    try {
      if (!clientHardwareChecked) {
        NVVisionBoostGPU.Info gpu = NVVisionBoostGPU.detect();
        if (!"Unknown GPU".equals(gpu.name)) {
          clientHardwareChecked = true;
          String fingerprint = machineFingerprint(gpu);
          MachineProfile previous = MachineProfile.load(machineProfileFile);
          if (config.enabled
              && config.autoOptimize
              && !preservePreferencesOnUpgrade
              && (previous == null || !fingerprint.equals(previous.fingerprint))) {
            NVVisionBoostGPU.applyPreset(config, NVVisionBoostGPU.presetFor(gpu.name));
            saveConfig();
            MachineProfile.capture(gpu, fingerprint, config).save(machineProfileFile);
          }
          if (preservePreferencesOnUpgrade)
            MachineProfile.capture(gpu, fingerprint, config).save(machineProfileFile);
        }
      }

      NVVisionBoostMemoryMonitor.tick(config);
      NVVisionBoostPerformance.tick(config);
      NVVisionBoostShaderLifecycle.tick(config);
      NVVisionBoostCreatePresets.tick(config);

      NVVisionBoostRenderController.tick(config);

      if (config.enabled) {
        updateClientMetrics(config);
      }
    } catch (RuntimeException e) {
      log("client tick: " + e);
    }
  }

  // ============================================================
  // METRICS
  // ============================================================

  private static void updateClientMetrics(Config config) {
    long now = System.currentTimeMillis();

    if (now - lastMetricsMs < 1000L) {
      return;
    }

    lastMetricsMs = now;

    int currentFps = detectFps();

    if (currentFps <= 0) {
      return;
    }

    fps = currentFps;

    double measured = NVVisionBoostFrameTiming.frameMs();
    double frame = measured > 0 ? measured : 1000.0 / currentFps;

    emaFrame = emaFrame == 0.0 ? frame : emaFrame * 0.85 + frame * 0.15;

    if (frame >= config.spikeThresholdMs) {
      spikes++;
    }

    samples++;

    NVVisionBoostRenderController.observePerformance(config, currentFps);

    if (config.autoOptimize
        && samples - lastAdaptSample >= Math.max(1L, config.adaptationCooldownSeconds)) {
      lastAdaptSample = samples;

      NVVisionBoostRenderController.adapt(config, currentFps);
    }

    if (samples % 5 == 0) {
      saveStatus();
    }
  }

  private static int detectFps() {
    net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
    return mc == null ? 0 : Math.max(0, mc.getFps());
  }

  // ============================================================
  // UPSCALER CONFIGURATION
  // ============================================================

  /**
   * Único ponto recomendado para alterar a escala interna.
   *
   * <p>A troca de escala invalida completamente o framebuffer anterior.
   */
  static void setRenderScalePercent(int percent) {
    Config config = cfg;

    if (config == null) {
      return;
    }

    int normalized = NVVisionBoostIO.clamp(percent, 10, 100);

    if (config.renderScalePercent == normalized) {
      return;
    }

    int previous = config.renderScalePercent;

    config.renderScalePercent = normalized;

    saveConfig();

    /*
     * Fundamental:
     *
     * o TextureTarget criado para a resolução anterior
     * não pode continuar sendo reutilizado.
     */
    NVVisionBoostNativeRenderer.reset();

    log("[NVVB Upscaler] Scale changed: " + previous + "% -> " + normalized + "%");
  }

  /** Liga/desliga o upscaling com reset completo do framebuffer interno. */
  static void setUpscalingEnabled(boolean enabled) {
    Config config = cfg;

    if (config == null) {
      return;
    }

    if (config.upscalingEnabled == enabled) {
      return;
    }

    config.upscalingEnabled = enabled;

    /*
     * Se ativado em 100%, escolhemos inicialmente 85%.
     * Depois o usuário pode escolher qualquer escala
     * entre 10 e 100%.
     */
    if (enabled && config.renderScalePercent >= 100) {
      config.renderScalePercent = 85;
    }

    saveConfig();

    NVVisionBoostNativeRenderer.reset();

    log("[NVVB Upscaler] " + (enabled ? "enabled" : "disabled"));
  }

  static void toggleUpscaling() {
    Config config = cfg;

    if (config == null) {
      return;
    }

    setUpscalingEnabled(!config.upscalingEnabled);
  }

  /** Utilizado quando múltiplas opções gráficas mudam de uma vez. */
  static void resetUpscaler() {
    NVVisionBoostNativeRenderer.reset();
  }

  // ============================================================
  // CONFIG SAVE
  // ============================================================

  static void saveConfig() {
    Config config = cfg;

    if (config == null || cfgFile == null) {
      return;
    }

    try {
      config.normalize();

      config.save(cfgFile);
    } catch (Exception e) {
      log("save config: " + e);
    }
  }

  // ============================================================
  // PATHS
  // ============================================================

  static Path gameRoot() {
    if (root == null) {
      return Paths.get(System.getProperty("user.dir", ".")).toAbsolutePath().normalize();
    }

    return root.getParent().getParent();
  }

  // ============================================================
  // STATUS
  // ============================================================

  private static void saveStatus() {
    Config config = cfg;

    try {
      if (config == null || root == null) {
        return;
      }

      NVVisionBoostShader.Pack selected = NVVisionBoostShaderEngine.selected();

      String status =
          "NV Vision Boost "
              + VERSION
              + "\n"
              + "FPS="
              + fps
              + "\n"
              + "EMA_FRAME_MS="
              + String.format(Locale.ROOT, "%.2f", emaFrame)
              + "\n"
              + "SPIKES="
              + spikes
              + "\n"
              + "PROFILE="
              + config.profile
              + "\n"
              + "SHADER="
              + (selected == null ? "none" : selected.name)
              + "\n"
              + "SHADER_COMPLEXITY="
              + (selected == null ? 0 : selected.score)
              + "\n"
              + "ANIMATION_OPT="
              + config.animationOptimization
              + "\n"
              + "ENTITY_OPT="
              + config.entityOptimization
              + "\n"
              + "TRANSPARENCY_OPT="
              + config.transparencyOptimization
              + "\n"
              + "DYNAMIC_RESOLUTION="
              + config.dynamicResolution
              + "\n"
              + "RESOLUTION_SCALE="
              + config.renderScalePercent
              + "\n"
              + "INTERNAL_RESOLUTION="
              + NVVisionBoostNativeRenderer.internalResolution()
              + "\n"
              + "UPSCALING_ENABLED="
              + config.upscalingEnabled
              + "\n"
              + "FRAME_GENERATION_TEMPORAL="
              + config.frameGenerationEnabled
              + "\n"
              + "UPSCALER_SHARPNESS="
              + config.upscalerSharpnessPercent
              + "\nGPU_TIMING="
              + NVVisionBoostFrameTiming.status()
              + "\nDYNAMIC_RUNTIME="
              + NVVisionBoostFrameTiming.resolutionStatus()
              + "\nUPSCALER_RUNTIME="
              + NVVisionBoostSpatialUpscaler.status()
              + "\nSHADER_STARTUP="
              + NVVisionBoostShaderStartup.status()
              + "\nCREATE_PRESET="
              + NVVisionBoostCreatePresets.status()
              + "\nENTITY_BUFFER_GUARD="
              + "Buffer de entidades gerenciado pelo Minecraft 26.2"
              + "\nGPU_ACTIVE="
              + NVVisionBoostGPU.detect().name
              + "\nGPU_CAPABILITIES="
              + NVVisionBoostGPU.detect().backendNote
              + "\n"
              + "RUNTIME_EFFECT_ACTIVE="
              + NVVisionBoostNativeRenderer.effectActive()
              + "\n"
              + "RUNTIME_PROCESSED_FRAMES="
              + NVVisionBoostNativeRenderer.processedFrames()
              + "\n"
              + "RUNTIME_FAILED_FRAMES="
              + NVVisionBoostNativeRenderer.failedFrames()
              + "\n"
              + "RUNTIME_LAST_ERROR="
              + NVVisionBoostIO.jsonString(NVVisionBoostNativeRenderer.lastError())
              + "\n"
              + "SHADER_BACKEND_STATUS="
              + NVVisionBoostIO.jsonString(NVVisionBoostNativeShaderPackRuntime.status())
              + "\n"
              + "INTEGRATION="
              + NVVisionBoostIO.jsonString(NVVisionBoostCompatibility.integrationSummary())
              + "\n";

      NVVisionBoostIO.writeUtf8(root.resolve("status.txt"), status);
    } catch (Exception e) {
      log("save status: " + e.getMessage());
    }
  }

  // ============================================================
  // README
  // ============================================================

  private static void writeReadme() {
    try {
      String text =
          "NV Vision Boost "
              + VERSION
              + "\n\n"
              + "Minecraft 1.20.1 / Forge 47.2.0 / Java 17.\n"
              + "Internal-resolution upscaling uses a dedicated reduced-resolution framebuffer.\n"
              + "The Minecraft window and GUI remain at native resolution.\n"
              + "Changing render scale invalidates and recreates the internal framebuffer.\n"
              + "Iris owns shaderpack activation and rendering when installed.\n"
              + "NVVisionBoost analyzes and caches shader metadata but does not replace Iris"
              + " shader execution.\n";

      NVVisionBoostIO.writeUtf8(root.resolve("README.txt"), text);
    } catch (Exception e) {
      log("write README: " + e.getMessage());
    }
  }

  // ============================================================
  // LOG
  // ============================================================

  static void log(String message) {
    org.apache.logging.log4j.LogManager.getLogger(ID).info("[NVVisionBoost] {}", message);
    Path logRoot = root;
    if (logRoot == null) return;
    NVVisionBoostIO.appendLog(logRoot.resolve("nvvisionboost.log"), message);
  }

  private static String stringValue(String json, String key, String fallback) {
    if (json == null || key == null) {
      return fallback;
    }

    Matcher m =
        Pattern.compile(String.format(Locale.ROOT, JSON_STRING.pattern(), Pattern.quote(key)))
            .matcher(json);

    return m.find() ? unescapeJson(m.group(1)) : fallback;
  }

  private static String unescapeJson(String value) {
    return value
        .replace("\\\"", "\"")
        .replace("\\\\", "\\")
        .replace("\\n", "\n")
        .replace("\\r", "\r");
  }

  // ============================================================
  // CONFIG
  // ============================================================

  public static final class Config {
    /** Estado mestre do mod, independente da escala interna selecionada. */
    public boolean isEnabled() {
      return enabled;
    }

    int configSchema = CONFIG_SCHEMA;

    boolean enabled = true;

    boolean autoOptimize = false;

    boolean adaptiveRenderDistance = true;

    boolean shaderWarmup = true;

    boolean shaderCache = true;

    boolean memoryGuard = true;

    boolean animationOptimization = true;

    boolean entityOptimization = true;

    boolean transparencyOptimization = true;

    boolean dynamicResolution = false;
    // Recursos opcionais: preservam o comportamento anterior por padrão.
    boolean backgroundFpsLimit = false;
    int backgroundFps = 30;
    boolean reduceWeatherParticles = false;
    boolean blockEntityDistanceLimit = false;
    int blockEntityDistance = 64;
    boolean simulationOptimization = false;
    int simulationDistance = 8;
    int createPerformancePreset = 0;

    boolean upscalingEnabled = true;

    boolean frameGenerationEnabled;

    boolean reduceParticles = true;

    boolean disableClouds = true;

    boolean disableEntityShadows = true;

    boolean reduceViewBob;

    boolean reduceShaderEffects = true;

    int textureMipmapLevel = -1;
    int shaderShadowQuality = 0;
    int shaderReflectionQuality = 0;

    boolean shaderAutoProfile = true;

    boolean gpuPresetApplied;

    /*
     * Mantido por compatibilidade com configs antigas.
     * O renderer de shader nativo permanece desligado.
     */
    boolean nativeShaderRenderer = false;

    boolean resourceOptimization = true;

    boolean shaderMultiPass = true;

    boolean irisIntegration = false;

    String gpuPreset = "";

    String rendererBackend = "auto";

    String profile = "balanced";

    int minRenderDistance = 6;

    int maxRenderDistance = 16;

    int renderDistance = 10;

    int targetFps = 60;

    int spikeThresholdMs = 35;

    int adaptationCooldownSeconds = 8;

    int entityDistancePercent = 100;

    /*
     * 10% - 100%.
     */
    int renderScalePercent = 100;

    int upscalerSharpnessPercent = 55;
    int upscalerMode = 3;
    boolean gpuTiming = true;
    boolean gpuAwareResolution = true;
    int dynamicMinScalePercent = 50;

    int animationLevel = 2;

    int transparencyLevel = 2;

    void normalize() {
      configSchema = CONFIG_SCHEMA;
      frameGenerationEnabled = false; // Sem backend temporal nesta versão.
      backgroundFps = NVVisionBoostIO.clamp(backgroundFps, 10, 120);
      blockEntityDistance = NVVisionBoostIO.clamp(blockEntityDistance, 16, 256);
      simulationDistance = NVVisionBoostIO.clamp(simulationDistance, 4, 32);
      createPerformancePreset = NVVisionBoostIO.clamp(createPerformancePreset, 0, 3);
      textureMipmapLevel = NVVisionBoostIO.clamp(textureMipmapLevel, -1, 4);
      shaderShadowQuality = NVVisionBoostIO.clamp(shaderShadowQuality, 0, 3);
      shaderReflectionQuality = NVVisionBoostIO.clamp(shaderReflectionQuality, 0, 3);

      minRenderDistance = NVVisionBoostIO.clamp(minRenderDistance, 2, 32);

      maxRenderDistance = NVVisionBoostIO.clamp(maxRenderDistance, minRenderDistance, 32);

      renderDistance = NVVisionBoostIO.clamp(renderDistance, minRenderDistance, maxRenderDistance);

      targetFps = NVVisionBoostIO.clamp(targetFps, 20, 360);

      spikeThresholdMs = NVVisionBoostIO.clamp(spikeThresholdMs, 16, 200);

      adaptationCooldownSeconds = NVVisionBoostIO.clamp(adaptationCooldownSeconds, 1, 120);

      entityDistancePercent = NVVisionBoostIO.clamp(entityDistancePercent, 50, 100);

      /*
       * CORREÇÃO 0.6.7:
       *
       * antes era 50-100.
       * agora o renderer aceita 10-100.
       */
      renderScalePercent = NVVisionBoostIO.clamp(renderScalePercent, 10, 100);

      upscalerSharpnessPercent = NVVisionBoostIO.clamp(upscalerSharpnessPercent, 0, 100);
      upscalerMode = NVVisionBoostIO.clamp(upscalerMode, 0, 4);
      dynamicMinScalePercent = NVVisionBoostIO.clamp(dynamicMinScalePercent, 30, 95);

      animationLevel = NVVisionBoostIO.clamp(animationLevel, 0, 3);

      transparencyLevel = NVVisionBoostIO.clamp(transparencyLevel, 0, 3);

      if (!"low".equalsIgnoreCase(profile) && !"quality".equalsIgnoreCase(profile)) {
        profile = "balanced";
      }

      /*
       * Backend nativo de shader não é mais permitido.
       */
      if (!"auto".equalsIgnoreCase(rendererBackend)
          && !"iris-compatible".equalsIgnoreCase(rendererBackend)
          && !"oculus".equalsIgnoreCase(rendererBackend)) {
        rendererBackend = "auto";
      }

      /*
       * NVVisionBoost não executa shaderpack.
       */
      nativeShaderRenderer = false;

      irisIntegration = NVVisionBoostCompatibility.externalShaderBackendAvailable();
    }

    private static final com.google.gson.Gson JSON =
        new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    static Config load(Path path) {
      Config config = new Config();
      if (path != null && Files.isRegularFile(path)) {
        try {
          com.google.gson.JsonObject object =
              com.google.gson.JsonParser.parseString(Files.readString(path, StandardCharsets.UTF_8))
                  .getAsJsonObject();
          // Leia por campo: um valor inválido não elimina as outras preferências.
          for (java.lang.reflect.Field field : Config.class.getDeclaredFields()) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) continue;
            com.google.gson.JsonElement value = object.get(field.getName());
            if (value == null && field.getName().equals("shaderAutoProfile"))
              value = object.get("derivativeAutoProfile");
            if (value == null || value.isJsonNull() || !value.isJsonPrimitive()) continue;
            try {
              var primitive = value.getAsJsonPrimitive();
              if (field.getType() == boolean.class && primitive.isBoolean())
                field.setBoolean(config, primitive.getAsBoolean());
              else if (field.getType() == int.class && primitive.isNumber())
                field.setInt(config, primitive.getAsBigDecimal().intValueExact());
              else if (field.getType() == String.class && primitive.isString())
                field.set(config, primitive.getAsString());
            } catch (ReflectiveOperationException | ArithmeticException ignored) {
              log("Configuração inválida: " + field.getName() + "; valor padrão mantido.");
            }
          }
          if (config.configSchema < 3) config.autoOptimize = false;
          if (config.configSchema < 5 && !object.has("upscalerMode")) config.upscalerMode = 0;
        } catch (java.io.IOException | RuntimeException error) {
          log("Configuração inválida; valores padrão usados: " + error.getMessage());
          // Preserve o arquivo defeituoso para o jogador recuperar preferências.
          try {
            Files.copy(
                path,
                path.resolveSibling(path.getFileName() + ".invalid"),
                StandardCopyOption.REPLACE_EXISTING);
          } catch (java.io.IOException ignored) {
          }
        }
      }
      config.normalize();
      if (path != null) {
        try {
          config.save(path);
        } catch (java.io.IOException error) {
          log("config save: " + error.getMessage());
        }
      }
      return config;
    }

    void save(Path path) throws java.io.IOException {
      normalize();
      NVVisionBoostIO.writeUtf8(path, JSON.toJson(this) + "\n");
    }
  }
}




