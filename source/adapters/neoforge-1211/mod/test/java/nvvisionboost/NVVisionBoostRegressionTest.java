package nvvisionboost;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/** Regressões de políticas e I/O real; não exige contexto OpenGL ou inicialização do jogo. */
public final class NVVisionBoostRegressionTest {
  private static int checks;

  private static void check(boolean result, String name) {
    if (!result) throw new AssertionError(name);
    checks++;
  }

  public static void main(String[] args) throws Exception {
    Path root = Path.of(args[0]).toAbsolutePath();
    Files.createDirectories(root);
    NVVisionBoostCore.root = root.resolve("config/nvvisionboost");
    Files.createDirectories(NVVisionBoostCore.root);
    testConfig(root);
    testVisualPolicies();
    testResourceSelection();
    testPacks(root);
    testImport(root);
    testAtomicWrites(root);
    testResources(root);
    testLegacyZip(root);
    testBridgeApi();
    checks += NVVisionBoostRenderingPolicyTest.run();
    checks += NVVisionBoostShaderStartupPolicyTest.run();
    checks += NVVisionBoostCreatePresetTest.run(root);
    checks += NVVisionBoostGpuCatalogTest.run(root);
    checks += NVVisionBoostStabilityTest.run(root);
    checks += NVVisionBoostFerriteCoreTest.run(root);
    checks += NVVisionBoostMenuLayoutTest.run();
    System.out.println("PASS: " + checks + " verificações de regressão.");
  }

  private static void testBridgeApi() {
    check(
        !NVVisionBoostGpuTimer.timestampRendererReliable("zink Vulkan NVIDIA"),
        "translated GPU clock safely gated");
    check(
        NVVisionBoostGpuTimer.timestampRendererReliable("NVIDIA RTX 5060 Ti"),
        "native GPU clock preserved");
    check(!NVVisionBoostGpuTimer.timestampRendererReliable(null), "unknown GPU clock not trusted");
    check(
        NVVisionBoostVulkanBridge.decode(null).get("state").equals("incompatible"),
        "missing bridge API rejected");
    check(
        NVVisionBoostVulkanBridge.decode(java.util.Map.of("protocol", "9"))
            .get("state")
            .equals("incompatible"),
        "unknown bridge protocol rejected");
    var status =
        NVVisionBoostVulkanBridge.decode(
            java.util.Map.of(
                "protocol",
                "1",
                "backend",
                "zink",
                "state",
                "active",
                "renderer",
                "R".repeat(2048),
                "dlss",
                "active"));
    check(status.get("renderer").length() == 512, "bridge text bounded");
    check(status.get("backend").equals("zink"), "bridge backend recognized");
    check(status.get("dlss").equals("unavailable"), "unimplemented DLSS cannot be advertised");
    check(
        status.get("framegen").equals("unavailable"),
        "unimplemented framegen cannot be advertised");
  }

  private static void testLegacyZip(Path root) throws Exception {
    Path legacy = root.resolve("legacy-cp437.zip");
    try (var zip =
        new ZipOutputStream(
            Files.newOutputStream(legacy), java.nio.charset.Charset.forName("IBM437"))) {
      zip.putNextEntry(new ZipEntry("textures/café.png"));
      zip.write(new byte[] {1, 2, 3});
      zip.closeEntry();
    }
    byte[] before = Files.readAllBytes(legacy);
    try (var zip = NVVisionBoostAssetAnalyzer.openResourceZip(legacy)) {
      check(zip.getEntry("textures/café.png") != null, "legacy resource names decoded");
    }
    check(
        java.util.Arrays.equals(before, Files.readAllBytes(legacy)),
        "resource pack never rewritten");
    Path broken = root.resolve("broken.zip");
    Files.writeString(broken, "not a ZIP");
    boolean rejected = false;
    try (var ignored = NVVisionBoostAssetAnalyzer.openResourceZip(broken)) {
    } catch (java.io.IOException expected) {
      rejected = true;
    }
    check(rejected, "corrupt archives still rejected");
  }

  private static void testConfig(Path root) throws Exception {
    Path file = root.resolve("preferences.json");
    Files.writeString(
        file,
        "{\"configSchema\":3,\"autoOptimize\":true,\"renderScalePercent\":75,"
            + "\"backgroundFps\":999,\"simulationDistance\":2,\"enabled\":false,"
            + "\"gpuPreset\":\"Linha\\tA\\\"B\",\"frameGenerationEnabled\":true}");
    var config = NVVisionBoostCore.Config.load(file);
    check(
        config.autoOptimize && config.renderScalePercent == 75 && !config.enabled,
        "migração preserva preferências da versão 3");
    check(config.backgroundFps == 120 && config.simulationDistance == 4, "limites de configuração");
    check(config.upscalerMode == 0, "migração mantém filtro linear da versão testada");
    check(
        !config.frameGenerationEnabled && !config.nativeShaderRenderer,
        "backend indisponível não fica ativo");
    check(config.gpuPreset.equals("Linha\tA\"B"), "JSON escapado");
    var roundTrip = NVVisionBoostCore.Config.load(file);
    check(
        roundTrip.gpuPreset.equals(config.gpuPreset) && roundTrip.renderScalePercent == 75,
        "persistência JSON");
    Files.writeString(
        file, "{\"configSchema\":4,\"targetFps\":\"inválido\",\"renderScalePercent\":67}");
    config = NVVisionBoostCore.Config.load(file);
    check(
        config.targetFps == 60 && config.renderScalePercent == 67,
        "campo inválido não apaga preferências válidas");
    Files.writeString(file, "JSON inválido");
    config = NVVisionBoostCore.Config.load(file);
    check(
        Files.readString(file.resolveSibling("preferences.json.invalid")).equals("JSON inválido"),
        "arquivo inválido preservado");
    check(config.renderScalePercent == 100 && !config.autoOptimize, "fallback conservador");
    Files.writeString(file, "{\"configSchema\":2,\"autoOptimize\":true,\"renderScalePercent\":50}");
    config = NVVisionBoostCore.Config.load(file);
    check(
        !config.autoOptimize && config.renderScalePercent == 50, "migração de versões anteriores");
    Files.writeString(
        file,
        "{\"configSchema\":5,\"upscalerMode\":99,\"dynamicMinScalePercent\":999,\"gpuTiming\":false}");
    config = NVVisionBoostCore.Config.load(file);
    check(
        config.upscalerMode == 4 && config.dynamicMinScalePercent == 95 && !config.gpuTiming,
        "novos campos são limitados sem perder desligamento da telemetria");
    Files.writeString(file, "{\"configSchema\":4,\"upscalerMode\":2,\"renderScalePercent\":75}");
    config = NVVisionBoostCore.Config.load(file);
    check(
        config.upscalerMode == 2 && config.renderScalePercent == 75,
        "escolha explícita de filtro e teto manual preservados na migração");
  }

  private static void testVisualPolicies() {
    var config = new NVVisionBoostCore.Config();
    config.transparencyOptimization = true;
    config.transparencyLevel = 0;
    config.reduceShaderEffects = false;
    check(
        NVVisionBoostVisualPolicy.screenEffectScale(config, 1) == .40,
        "oclusão mantém redução independente");
    config.reduceShaderEffects = true;
    check(
        NVVisionBoostVisualPolicy.screenEffectScale(config, 1) == .40,
        "efeitos não desfazem opção mais forte");
    check(
        NVVisionBoostVisualPolicy.screenEffectScale(config, 0) == 0,
        "não reativa efeito desligado pelo jogador");
    config.dynamicResolution = true;
    check(
        NVVisionBoostVisualPolicy.simulationDistance(config, 12) == 12,
        "escala não muda simulação");
    config.simulationOptimization = true;
    config.simulationDistance = 8;
    check(
        NVVisionBoostVisualPolicy.simulationDistance(config, 12) == 8,
        "limite explícito de simulação");
    check(
        NVVisionBoostVisualPolicy.simulationDistance(config, 4) == 4,
        "limite não aumenta simulação original");
  }

  private static void testResourceSelection() {
    var previous = List.of("vanilla", "mod_resources", "file/Textures.zip");
    var merged = NVVisionBoostContentManager.mergeSelection(previous, "file/Extra.zip");
    check(
        merged.equals(List.of("vanilla", "mod_resources", "file/Textures.zip", "file/Extra.zip")),
        "pacotes existentes preservados");
    check(
        previous.size() == 3
            && NVVisionBoostContentManager.mergeSelection(merged, "file/Extra.zip").equals(merged),
        "sem mutação ou duplicação");
  }

  private static void testPacks(Path root) throws Exception {
    Files.deleteIfExists(root.resolve("shaderpacks/Imported.zip"));
    Path dir = root.resolve("shaderpacks/Fixture");
    Files.createDirectories(dir.resolve("shaders"));
    Files.writeString(dir.resolve("shaders/gbuffers_terrain.vsh"), "void main() {}\n");
    Files.writeString(dir.resolve("shaders/composite.fsh"), "void main() {}\n");
    Files.writeString(dir.resolve("shaders/final.csh"), "void main() {}\n");
    Path zip = root.resolve("shaderpacks/Fixture.zip");
    try (var out = new ZipOutputStream(Files.newOutputStream(zip))) {
      for (String name : List.of("gbuffers_terrain.vsh", "composite.fsh", "final.csh")) {
        out.putNextEntry(new ZipEntry("shaders/" + name));
        out.write(Files.readAllBytes(dir.resolve("shaders/" + name)));
        out.closeEntry();
      }
    }
    var directoryReport = NVVisionBoostPipeline.analyze(dir);
    var zipReport = NVVisionBoostPipeline.analyze(zip);
    check(
        directoryReport.shaderFiles == 3 && zipReport.shaderFiles == 3,
        "fontes vertex fragment e compute em ZIP e pasta");
    check(
        directoryReport.postPasses == zipReport.postPasses && directoryReport.hasGbuffers,
        "análise consistente dos passes");
    var cached = NVVisionBoostOculusShaderCache.compileSelected(root, zip);
    check(
        cached.success
            && cached.shaderFiles == 3
            && Files.isRegularFile(cached.cacheDir.resolve("READY")),
        "cache de preparação real");
    check(
        cached == NVVisionBoostOculusShaderCache.compileSelected(root, zip),
        "resultado preparado reutilizado");
    var directoryCached = NVVisionBoostOculusShaderCache.compileSelected(root, dir);
    Files.writeString(
        dir.resolve("shaders/composite.fsh"), "void main() { /* fonte alterada */ }\n");
    var changed = NVVisionBoostOculusShaderCache.compileSelected(root, dir);
    check(
        changed.success && !changed.cacheId.equals(directoryCached.cacheId),
        "cache invalidado após mudança de fonte");
    var packs = NVVisionBoostShader.scan(root.resolve("shaderpacks"), root.resolve("cache"));
    check(
        packs.size() == 2 && packs.stream().allMatch(pack -> pack.shaderFiles == 3),
        "descoberta completa sem depender do nome do pack");
  }

  private static void testImport(Path root) throws Exception {
    Path source = root.resolve("incoming/Imported.zip");
    Files.createDirectories(source.getParent());
    try (var zip = new ZipOutputStream(Files.newOutputStream(source))) {
      zip.putNextEntry(new ZipEntry("shaders/final.fsh"));
      zip.write("void main() {}\n".getBytes(StandardCharsets.UTF_8));
      zip.closeEntry();
    }
    String name = NVVisionBoostContentManager.importShader(source);
    Path installed = root.resolve("shaderpacks/" + name);
    check(
        java.util.Arrays.equals(Files.readAllBytes(installed), Files.readAllBytes(source)),
        "importação preserva bytes de ZIP válido");
    check(
        NVVisionBoostContentManager.importShader(installed).equals(name),
        "importar o próprio arquivo não o sobrescreve");
    boolean rejected = false;
    try {
      NVVisionBoostContentManager.importShader(root);
    } catch (java.io.IOException expected) {
      rejected = true;
    }
    check(rejected, "cópia recursiva da pasta ancestral bloqueada");
  }

  private static void testAtomicWrites(Path root) throws Exception {
    Path file = root.resolve("a");
    var executor = java.util.concurrent.Executors.newFixedThreadPool(2);
    try {
      var first =
          executor.submit(
              () -> {
                try {
                  NVVisionBoostIO.writeUtf8(file, "A".repeat(2000));
                } catch (Exception error) {
                  throw new RuntimeException(error);
                }
              });
      var second =
          executor.submit(
              () -> {
                try {
                  NVVisionBoostIO.writeUtf8(file, "B".repeat(2000));
                } catch (Exception error) {
                  throw new RuntimeException(error);
                }
              });
      first.get();
      second.get();
      String content = Files.readString(file, StandardCharsets.UTF_8);
      check(
          content.equals("A".repeat(2000)) || content.equals("B".repeat(2000)),
          "escrita concorrente sem arquivo parcial");
    } finally {
      executor.shutdownNow();
    }
  }

  private static void testResources(Path root) throws Exception {
    Path directory = root.resolve("resource-fixture");
    Files.createDirectories(directory);
    Files.write(directory.resolve("test.png"), new byte[] {1, 2, 3});
    Files.writeString(directory.resolve("test.png.mcmeta"), "{\"animation\":{}}");
    Files.writeString(directory.resolve("pack.mcmeta"), "{}");
    var folder = NVVisionBoostAssetAnalyzer.analyze(directory);
    check(
        folder.png == 1 && folder.bytes == 3 && folder.animated == 1 && folder.mcmeta == 2,
        "recursos em pasta e animações contabilizados");
    Path archive = root.resolve("resources.zip");
    try (var zip = new ZipOutputStream(Files.newOutputStream(archive))) {
      for (String name : List.of("test.png", "test.png.mcmeta", "pack.mcmeta")) {
        zip.putNextEntry(new ZipEntry("assets/test/" + name));
        zip.write(Files.readAllBytes(directory.resolve(name)));
        zip.closeEntry();
      }
    }
    var packed = NVVisionBoostAssetAnalyzer.analyze(archive);
    check(
        packed.summary().equals(folder.summary()),
        "recursos ZIP e pasta produzem análise equivalente");
    Files.writeString(directory.resolve("test.png.mcmeta"), "JSON inválido");
    check(
        NVVisionBoostAssetAnalyzer.analyze(directory).animated == 0,
        "metadado inválido não interrompe a análise");
  }
}
