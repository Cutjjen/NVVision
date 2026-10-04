package nvvisionboost;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * NVVisionBoost shader analysis / preparation coordinator.
 *
 * <p>Iris remains responsible for actual shader rendering.
 */
public final class NVVisionBoostShaderEngine {
  private static final java.util.concurrent.ExecutorService PREPARATION =
      java.util.concurrent.Executors.newSingleThreadExecutor(
          runnable -> {
            Thread thread = new Thread(runnable, "NVVisionBoost-shader-analysis");
            thread.setDaemon(true);
            return thread;
          });
  private static final java.util.concurrent.atomic.AtomicBoolean PREPARING =
      new java.util.concurrent.atomic.AtomicBoolean();

  public static boolean isPreparing() {
    return PREPARING.get();
  }

  /** Leitura em worker; alterações no perfil e no pipeline apenas na thread cliente. */
  public static boolean prepareAsync(Path game, String name, boolean activate) {
    var config = NVVisionBoostCore.cfg;
    if (game == null
        || name == null
        || name.isBlank()
        || config == null
        || !PREPARING.compareAndSet(false, true)) return false;
    boolean cacheEnabled = config.shaderCache;
    loadStatus = "Lendo shaderpack em segundo plano: " + name;
    java.util.concurrent.CompletableFuture.supplyAsync(
            () -> {
              NVVisionBoostShader.Pack pack = findByName(name);
              if (pack == null)
                throw new IllegalArgumentException("Shaderpack não encontrado: " + name);
              var result =
                  cacheEnabled
                      ? NVVisionBoostIrisShaderCache.compileSelected(game, pack.path)
                      : new NVVisionBoostIrisShaderCache.Result(
                          true,
                          pack.name,
                          "",
                          null,
                          pack.shaderFiles,
                          0,
                          0,
                          0,
                          "Cache de preparação desativado.");
              if (!result.success) throw new IllegalStateException(result.message);
              return new Preparation(pack, result);
            },
            PREPARATION)
        .whenComplete(
            (prepared, error) -> {
              net.minecraft.client.Minecraft.getInstance()
                  .execute(
                      () -> {
                        try {
                          if (error != null) {
                            loadStatus = "Falha no preparo: " + error.getMessage();
                            NVVisionBoostCore.log(loadStatus);
                            return;
                          }
                          if (NVVisionBoostCore.cfg != config) return;
                          if (!activate
                              && (!config.enabled
                                  || !NVVisionBoostCompatibility.externalShadersEnabled()
                                  || !name.equals(
                                      NVVisionBoostCompatibility.externalShaderPackName()))) return;
                          selected = prepared.pack();
                          lastCompile = prepared.result();
                          NVVisionBoostShader.select(NVVisionBoostCore.root, selected.name);
                          if (config.enabled) applyRecommended(config, selected);
                          if (activate) loadShaderPipeline(name);
                          else {
                            loadStatus = "Preparação concluída: " + name + "; pipeline preservado.";
                            NVVisionBoostShaderLifecycle.markPrepared(name);
                          }
                          NVVisionBoostRenderController.applyNow(config);
                        } finally {
                          PREPARING.set(false);
                        }
                      });
            });
    return true;
  }

  private record Preparation(
      NVVisionBoostShader.Pack pack, NVVisionBoostIrisShaderCache.Result result) {}

  /** Somente ação manual da interface solicita desligar o backend. */
  public static boolean disableExternal() {
    if (!com.mojang.blaze3d.systems.RenderSystem.isOnRenderThread()) return false;
    for (String name : new String[] {"net.irisshaders.iris.Iris", "net.coderbot.iris.Iris"}) {
      try {
        Class<?> backend = Class.forName(name);
        Object config = backend.getMethod("getIrisConfig").invoke(null);
        config.getClass().getMethod("setShadersEnabled", boolean.class).invoke(config, false);
        config.getClass().getMethod("save").invoke(config);
        NVVisionBoostNativeRenderer.reset();
        backend.getMethod("reload").invoke(null);
        loadStatus = "Shaders desativados pelo backend.";
        return true;
      } catch (ClassNotFoundException ignored) {
      } catch (ReflectiveOperationException | RuntimeException error) {
        loadStatus = "Falha ao desativar shaders: " + error.getMessage();
        NVVisionBoostCore.log(loadStatus);
        return false;
      }
    }
    loadStatus = "Backend de shaders não encontrado.";
    return false;
  }

  private static volatile NVVisionBoostShader.Pack selected;
  private static volatile List<NVVisionBoostShader.Pack> discovered = List.of();
  private static volatile String loadStatus = "Nenhum carregamento solicitado.";

  public static String loadStatus() {
    return loadStatus;
  }

  private static volatile NVVisionBoostIrisShaderCache.Result lastCompile;

  private NVVisionBoostShaderEngine() {}

  /**
   * Re-scans shaderpacks and updates analysis/cache.
   *
   * <p>This method never activates a shaderpack.
   */
  public static void refresh(Path game, NVVisionBoostCore.Config cfg) {
    if (game == null || cfg == null) {
      return;
    }

    try {
      Path shaderDir = game.resolve("shaderpacks");

      Path cache = game.resolve("config/nvvisionboost/shader-cache");

      List<NVVisionBoostShader.Pack> packs = NVVisionBoostShader.scan(shaderDir, cache);
      discovered = List.copyOf(packs);

      String selection = NVVisionBoostShader.selected(game.resolve("config/nvvisionboost"));

      /*
       * Prefer the shader currently selected in Iris.
       */
      Optional<Path> oculusActive = NVVisionBoostIrisShaderCache.detectIrisShaderPack(game);

      if (oculusActive.isPresent()) {
        selection = oculusActive.get().getFileName().toString();
      }

      selected = null;

      for (NVVisionBoostShader.Pack pack : packs) {
        if (samePack(pack, selection)) {
          selected = pack;

          break;
        }
      }

      /*
       * Never allow an old config/preset to
       * reactivate the obsolete native shader runtime.
       */
      forceIrisArchitecture(cfg);

      if (selected != null) {
        writeReport(game, selected);

        /*
         * Automatically prepare cache only when
         * shaderCache is enabled.
         */
        if (cfg.shaderCache) {
          lastCompile = NVVisionBoostIrisShaderCache.compileSelected(game, selected.path);
        }

        /*
         * Existing NVVisionBoost pipeline analysis
         * remains useful as static analysis only.
         */
        if (cfg.shaderMultiPass) {
          try {
            NVVisionBoostPipeline.Report report = NVVisionBoostPipeline.analyze(selected.path);

            NVVisionBoostPipeline.write(
                game.resolve("config/nvvisionboost/" + "shader-pipeline.txt"), report);
          } catch (Throwable t) {
            NVVisionBoostCore.log("pipeline analysis: " + t);
          }
        }
      }

      /*
       * Existing resource analysis remains independent
       * from Iris.
       */
      if (cfg.resourceOptimization) {
        try {
          NVVisionBoostAssetAnalyzer.Report report =
              NVVisionBoostAssetAnalyzer.analyze(game.resolve("resourcepacks"));

          Path configDir = game.resolve("config/nvvisionboost");

          Files.createDirectories(configDir);

          Files.writeString(
              configDir.resolve("resource-analysis.txt"), report.summary(), StandardCharsets.UTF_8);
        } catch (Throwable t) {
          NVVisionBoostCore.log("resource analysis: " + t);
        }
      }
    } catch (Throwable t) {
      NVVisionBoostCore.log("shader engine: " + t);
    }
  }

  public static NVVisionBoostShader.Pack selected() {
    return selected;
  }

  public static void setSelected(NVVisionBoostShader.Pack pack) {
    selected = pack;
  }

  public static NVVisionBoostIrisShaderCache.Result lastCompile() {
    return lastCompile;
  }

  public static NVVisionBoostShader.Pack findByName(String name) {
    for (var known : discovered) if (samePack(known, name)) return known;

    if (name == null || name.isBlank()) {
      return null;
    }

    List<NVVisionBoostShader.Pack> packs =
        NVVisionBoostShader.scan(
            NVVisionBoostCore.gameRoot().resolve("shaderpacks"),
            NVVisionBoostCore.root.resolve("shader-cache"));

    for (NVVisionBoostShader.Pack pack : packs) {
      if (samePack(pack, name)) {
        return pack;
      }
    }

    return null;
  }

  /**
   * Applies only NVVisionBoost optimization recommendations.
   *
   * <p>It does NOT change the shader selected in Iris.
   */
  /** Perfil genérico por custo estimado, aplicável a qualquer shaderpack. */
  public static void applyRecommended(NVVisionBoostCore.Config cfg, NVVisionBoostShader.Pack pack) {
    if (cfg == null || pack == null || !cfg.shaderAutoProfile) return;
    int score = Math.max(0, Math.min(100, pack.score));
    cfg.profile = score >= 70 ? "low" : score >= 45 ? "balanced" : "quality";
    if (score >= 45) {
      cfg.reduceShaderEffects = true;
      cfg.animationOptimization = true;
      cfg.transparencyOptimization = true;
      int level = score >= 70 ? 1 : 2;
      cfg.animationLevel = Math.min(cfg.animationLevel, level);
      cfg.transparencyLevel = Math.min(cfg.transparencyLevel, level);
      if (!NVVisionBoostCreateCompatibility.protectsMachineRendering()) {
        cfg.entityOptimization = true;
        cfg.entityDistancePercent = Math.min(cfg.entityDistancePercent, score >= 70 ? 80 : 90);
      }
    }
    // Não muda escala, shader options, backend Flywheel ou simulação.
    // Escala manual continua pertencendo ao usuário.
    forceIrisArchitecture(cfg);
    NVVisionBoostCore.saveConfig();
    NVVisionBoostCore.log(
        "Perfil genérico de shader: "
            + pack.name
            + " | custo="
            + score
            + " | "
            + NVVisionBoostCreateCompatibility.summary());
  }

  /**
   * Legacy method kept because older UI/classes may still call it.
   *
   * <p>Prepara recursos e solicita carregamento real ao backend disponível.
   */
  public static boolean activateWithIris(Path game, String shaderName) {
    if (!compileSelectedByName(game, shaderName)) {
      loadStatus = "Falha ao ler os recursos do shaderpack.";
      return false;
    }
    return loadShaderPipeline(shaderName);
  }

  /**
   * Legacy method kept for source compatibility.
   *
   * <p>Alias legado: usa o backend disponível; não cria renderer nativo.
   */
  public static boolean activateNative(Path game, String shaderName) {
    if (!compileSelectedByName(game, shaderName)) {
      loadStatus = "Falha ao ler os recursos do shaderpack.";
      return false;
    }
    return loadShaderPipeline(shaderName);
  }

  static boolean canReusePipeline(
      boolean enabled, String current, String requested, boolean loaded) {
    return enabled && loaded && requested != null && requested.equals(current);
  }

  /** Carrega o pipeline real, com includes/macros/texturas tratados pelo backend. */
  private static boolean loadShaderPipeline(String shaderName) {
    if (!com.mojang.blaze3d.systems.RenderSystem.isOnRenderThread()) {
      loadStatus = "Carregamento precisa ocorrer na thread de renderização.";
      return false;
    }
    Class<?> backend = null;
    for (String name : new String[] {"net.irisshaders.iris.Iris", "net.coderbot.iris.Iris"}) {
      try {
        backend = Class.forName(name);
        break;
      } catch (ClassNotFoundException ignored) {
      }
    }
    if (backend == null) {
      loadStatus =
          "Recursos preparados; sem motor de shaderpacks carregado. "
              + "O renderer nativo deste projeto não executa shaderpacks.";
      NVVisionBoostCore.log(loadStatus);
      return false;
    }
    Object config = null;
    String previousName = null;
    boolean previousEnabled = false;
    boolean modified = false;
    try {
      config = backend.getMethod("getIrisConfig").invoke(null);
      if (config == null) throw new IllegalStateException("Configuração do backend indisponível.");
      Object old = config.getClass().getMethod("getShaderPackName").invoke(config);
      previousName =
          old instanceof Optional<?> optional
              ? optional.map(Object::toString).orElse(null)
              : old == null ? null : old.toString();
      previousEnabled =
          Boolean.TRUE.equals(config.getClass().getMethod("areShadersEnabled").invoke(config));
      Object activePack = backend.getMethod("getCurrentPack").invoke(null);
      boolean packLoaded = activePack instanceof Optional<?> optional && optional.isPresent();
      if (canReusePipeline(previousEnabled, previousName, shaderName, packLoaded)
          && NVVisionBoostCompatibility.externalShadersInUse()) {
        loadStatus = "Shader já ativo: " + shaderName + "; pipeline preservado.";
        NVVisionBoostShaderLifecycle.markPrepared(shaderName);
        NVVisionBoostCore.log(loadStatus);
        return true;
      }
      config.getClass().getMethod("setShaderPackName", String.class).invoke(config, shaderName);
      modified = true;
      config.getClass().getMethod("setShadersEnabled", boolean.class).invoke(config, true);
      // reload pode reler a configuração persistida: grave antes.
      config.getClass().getMethod("save").invoke(config);
      NVVisionBoostNativeRenderer.reset();
      backend.getMethod("reload").invoke(null);
      NVVisionBoostShaderStartup.beforeRender();
      // Warmup prepares the backend default in the menu and the actual dimension on entry.
      Object current = backend.getMethod("getCurrentPack").invoke(null);
      if (current instanceof Optional<?> optional && optional.isEmpty()) {
        throw new IllegalStateException("O backend rejeitou o shaderpack. Veja latest.log.");
      }
      net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
      if (mc.level != null && !NVVisionBoostCompatibility.externalShadersInUse()) {
        throw new IllegalStateException("Pipeline de shaders não ficou ativo. Veja latest.log.");
      }
      config.getClass().getMethod("save").invoke(config);
      loadStatus =
          mc.level == null
              ? "Shader carregado; pré-aquecimento do pipeline solicitado no menu."
              : "Pipeline carregado: " + shaderName + ". Recursos GPU gerenciados pelo backend.";
      NVVisionBoostCore.log(loadStatus);
      NVVisionBoostShaderLifecycle.markPrepared(shaderName);
      return true;
    } catch (Throwable error) {
      Throwable cause = error;
      while (cause.getCause() != null && cause.getCause() != cause) cause = cause.getCause();
      loadStatus =
          "Falha no pipeline: " + cause.getClass().getSimpleName() + ": " + cause.getMessage();
      NVVisionBoostCore.log(loadStatus);
      if (modified && config != null) {
        try {
          config
              .getClass()
              .getMethod("setShaderPackName", String.class)
              .invoke(config, previousName);
          config
              .getClass()
              .getMethod("setShadersEnabled", boolean.class)
              .invoke(config, previousEnabled);
          config.getClass().getMethod("save").invoke(config);
          backend.getMethod("reload").invoke(null);
        } catch (Throwable rollback) {
          NVVisionBoostCore.log("Falha ao restaurar shader anterior: " + rollback);
        }
      }
      return false;
    }
  }

  /**
   * Prepares the selected shaderpack for Iris.
   *
   * <p>Does not activate it.
   */
  public static boolean compileSelectedByName(Path game, String shaderName) {
    if (game == null || shaderName == null || shaderName.isBlank()) {
      return false;
    }

    try {
      NVVisionBoostShader.Pack pack = findByName(shaderName);

      if (pack == null) {
        NVVisionBoostCore.log("Shader não encontrado para cache: " + shaderName);

        return false;
      }

      selected = pack;

      /*
       * Save NVVisionBoost analysis selection.
       *
       * This is NOT Iris activation.
       */
      NVVisionBoostShader.select(NVVisionBoostCore.root, pack.name);

      lastCompile =
          NVVisionBoostCore.cfg != null && NVVisionBoostCore.cfg.shaderCache
              ? NVVisionBoostIrisShaderCache.compileSelected(game, pack.path)
              : new NVVisionBoostIrisShaderCache.Result(
                  true,
                  pack.name,
                  "",
                  null,
                  pack.shaderFiles,
                  0,
                  0,
                  0,
                  "Cache de preparação desativado.");

      if (lastCompile.success) {
        applyRecommended(NVVisionBoostCore.cfg, pack);
      }

      forceIrisArchitecture(NVVisionBoostCore.cfg);

      NVVisionBoostCore.saveConfig();

      writeReport(game, pack);

      NVVisionBoostCore.log(
          "Shader preparado para Iris: " + pack.name + " | " + lastCompile.summary());

      return lastCompile.success;
    } catch (Throwable t) {
      NVVisionBoostCore.log("shader preparation: " + t);

      return false;
    }
  }

  /** Prepares the shader currently being used by Iris. */
  public static boolean compileIrisActive(Path game) {
    lastCompile = NVVisionBoostIrisShaderCache.compileIrisActive(game);

    forceIrisArchitecture(NVVisionBoostCore.cfg);

    NVVisionBoostCore.saveConfig();

    if (lastCompile.success) {
      refresh(game, NVVisionBoostCore.cfg);
    }

    return lastCompile.success;
  }

  /**
   * Old method retained for compatibility.
   *
   * <p>It only guarantees that NV native shader rendering remains disabled.
   *
   * <p>It MUST NOT disable Iris shaders.
   */
  public static void disableNative() {
    NVVisionBoostNativeShaderPackRuntime.clear();

    if (NVVisionBoostCore.cfg != null) {
      forceIrisArchitecture(NVVisionBoostCore.cfg);

      NVVisionBoostCore.saveConfig();
    }
  }

  private static boolean samePack(NVVisionBoostShader.Pack pack, String name) {
    if (pack == null || name == null || name.isBlank()) {
      return false;
    }

    if (pack.name.equalsIgnoreCase(name)) {
      return true;
    }

    return pack.path.getFileName().toString().equalsIgnoreCase(name);
  }

  /**
   * Central protection against old presets/configurations enabling the removed NV native shader
   * renderer.
   */
  private static void forceIrisArchitecture(NVVisionBoostCore.Config cfg) {
    if (cfg == null) {
      return;
    }

    cfg.nativeShaderRenderer = false;

    if (NVVisionBoostCompatibility.externalShaderBackendAvailable()) {
      cfg.rendererBackend = NVVisionBoostCompatibility.oculus() ? "oculus" : "iris-compatible";

      cfg.irisIntegration = true;
    } else {
      cfg.rendererBackend = "auto";

      cfg.irisIntegration = false;
    }
  }

  private static void writeReport(Path game, NVVisionBoostShader.Pack pack) {
    if (game == null || pack == null) {
      return;
    }

    try {
      Path configDir = game.resolve("config/nvvisionboost");

      Files.createDirectories(configDir);

      StringBuilder report = new StringBuilder();

      report.append("Shader: ").append(pack.name).append('\n');

      report.append("Renderer owner: Iris\n");

      report.append("NVVisionBoost requests backend activation: true\n");

      report.append("Iris detected: ").append(NVVisionBoostCompatibility.oculus()).append('\n');

      report
          .append("Generic automatic shader profile: ")
          .append(NVVisionBoostCore.cfg != null && NVVisionBoostCore.cfg.shaderAutoProfile)
          .append('\n');

      report.append("Complexity: ").append(pack.score).append("/100\n");

      report.append("Shader files: ").append(pack.shaderFiles).append('\n');

      report.append("Source lines: ").append(pack.sourceLines).append('\n');

      report.append("Animation cost: ").append(pack.animationCost).append('\n');

      report.append("Transparency cost: ").append(pack.transparencyCost).append('\n');

      report.append("Shadow cost: ").append(pack.shadowCost).append('\n');

      report.append("Volumetric cost: ").append(pack.volumetricCost).append('\n');

      report.append("Post cost: ").append(pack.postCost).append('\n');

      report.append("Recommended profile: ").append(pack.recommendedProfile).append('\n');

      report.append("Issues: ").append(String.join(", ", pack.issues)).append('\n');

      if (lastCompile != null) {
        report.append("Cache: ").append(lastCompile.summary()).append('\n');

        report.append("Cache ID: ").append(lastCompile.cacheId).append('\n');
      }

      Files.writeString(
          configDir.resolve("shader-analysis.txt"), report.toString(), StandardCharsets.UTF_8);
    } catch (Throwable t) {
      NVVisionBoostCore.log("shader report: " + t);
    }
  }
}
