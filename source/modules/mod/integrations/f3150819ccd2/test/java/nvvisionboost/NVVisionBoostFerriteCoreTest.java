package nvvisionboost;

import java.nio.file.*;
import java.util.*;

public final class NVVisionBoostFerriteCoreTest {
  private static int count;

  private static void check(boolean value, String text) {
    if (!value) throw new AssertionError(text);
    count++;
  }

  private static void rejected(RunnableIO action, String text) throws Exception {
    boolean failed = false;
    try {
      action.run();
    } catch (java.io.IOException | IllegalArgumentException e) {
      failed = true;
    }
    check(failed, text);
  }

  private interface RunnableIO {
    void run() throws Exception;
  }

  public static int run(Path root) throws Exception {
    count = 0;
    Path dir = Files.createTempDirectory(root, "ferrite-tests-");
    for (int i = 0; i < 4; i++) {
      var p = NVVisionBoostFerriteOptions.preset(i);
      NVVisionBoostFerriteOptions.validate(p);
      check(!p.get("useSmallThreadingDetector"), "preset não habilita opção experimental");
    }
    var values = NVVisionBoostFerriteOptions.preset(0);
    NVVisionBoostFerriteOptions.toggle(values, NVVisionBoostFerriteOptions.ALL.get(0));
    check(!values.get("replacePropertyMap"), "desabilitar pai desabilita dependente");
    NVVisionBoostFerriteOptions.toggle(values, NVVisionBoostFerriteOptions.ALL.get(1));
    check(values.get("replaceNeighborLookup"), "habilitar dependente habilita pai");
    String original =
        "\ufeff# meu comentário\r\n"
            + "replaceNeighborLookup = true # preservar\r\n"
            + "custom = 42\r\n"
            + "[other]\r\n"
            + "compactFastMap = false\r\n";
    Path file = dir.resolve("ferritecore-mixin.toml"), backup = dir.resolve("backup");
    Files.writeString(file, original);
    var config = new NVVisionBoostFerriteConfig(file, backup);
    var expected = config.load();
    var memory = NVVisionBoostFerriteOptions.preset(2);
    config.apply(memory, expected);
    String edited = Files.readString(file);
    check(edited.startsWith("\ufeff# meu comentário\r\n"), "BOM e CRLF preservados");
    check(edited.contains("custom = 42"), "chave desconhecida preservada");
    check(edited.contains("true # preservar"), "comentário preservado");
    check(
        edited.endsWith("[other]\r\ncompactFastMap = false\r\n"), "seção desconhecida preservada");
    check(config.load().equals(memory), "onze controles persistidos na raiz");
    config.apply(NVVisionBoostFerriteOptions.preset(1), memory);
    config.restore();
    check(Files.readString(file).equals(original), "segundo preset não substitui backup original");
    config.apply(memory, expected);
    Files.writeString(file, Files.readString(file) + "# alteração externa\r\n");
    String external = Files.readString(file);
    rejected(config::restore, "restauração preserva alteração externa");
    check(Files.readString(file).equals(external), "nenhuma escrita após bloqueio");
    var changed = NVVisionBoostFerriteOptions.preset(0);
    changed.put("replaceNeighborLookup", false);
    rejected(() -> config.apply(changed, config.load()), "dependência inválida rejeitada");
    rejected(
        () -> NVVisionBoostFerriteConfig.parse("compactFastMap = 1"), "tipo inválido rejeitado");
    rejected(
        () -> NVVisionBoostFerriteConfig.parse("compactFastMap = true\ncompactFastMap = false"),
        "chave duplicada rejeitada");
    rejected(() -> NVVisionBoostFerriteConfig.parse("[broken"), "TOML quebrado rejeitado");
    Files.writeString(backup.resolve("original.toml"), "corrompido");
    rejected(() -> config.apply(memory, config.load()), "backup corrompido bloqueia escrita");
    check(Files.readString(file).equals(external), "backup corrompido não altera arquivo");
    Path absent = dir.resolve("missing.toml");
    var fresh = new NVVisionBoostFerriteConfig(absent, dir.resolve("fresh-backup"));
    fresh.apply(memory, fresh.load());
    check(Files.exists(absent), "arquivo criado quando ausente");
    fresh.restore();
    check(!Files.exists(absent), "restauração remove apenas arquivo criado pelo controle");
    Path concurrent = dir.resolve("concurrent.toml");
    Files.writeString(concurrent, "compactFastMap = false\n");
    var concurrency = new NVVisionBoostFerriteConfig(concurrent, dir.resolve("concurrent-backup"));
    var before = concurrency.load();
    Files.writeString(concurrent, "compactFastMap = true\n");
    rejected(
        () -> concurrency.apply(memory, before),
        "edição externa entre leitura e aplicação detectada");
    check(
        !Files.exists(dir.resolve("concurrent-backup/state.properties")),
        "conflito não cria journal");
    return count;
  }
}
