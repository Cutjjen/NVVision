/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostCreatePresetTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.nio.file.Files;
import java.nio.file.Path;

public final class NVVisionBoostCreatePresetTest {
  public static final class Value {
    double value;
    boolean fail;

    Value(double value) {
      this.value = value;
    }

    public Double get() {
      return value;
    }

    public void set(Object input) {
      if (fail) throw new IllegalStateException("fixture setter failure");
      value = ((Number) input).doubleValue();
    }
  }

  public static final class Client {
    public Value fanParticleDensity = new Value(.5);
    public Value filterItemRenderDistance = new Value(10);
  }

  static int run(Path root) throws Exception {
    Path backup = root.resolve("create-preset-backup.properties");
    Files.deleteIfExists(backup);
    Client client = new Client();
    int checks = 0;
    NVVisionBoostCreatePresets.apply(client, 1, backup);
    require(
        client.fanParticleDensity.value == .25 && client.filterItemRenderDistance.value == 8,
        "equilibrado");
    checks++;
    require(Files.exists(backup), "backup durável");
    checks++;
    NVVisionBoostCreatePresets.apply(client, 2, backup);
    require(
        client.fanParticleDensity.value == .1 && client.filterItemRenderDistance.value == 6,
        "desempenho");
    checks++;
    NVVisionBoostCreatePresets.apply(client, 3, backup);
    require(
        client.fanParticleDensity.value == 0 && client.filterItemRenderDistance.value == 4,
        "mínimo visual");
    checks++;
    Client restarted = new Client();
    restarted.fanParticleDensity.value = 0;
    restarted.filterItemRenderDistance.value = 4;
    NVVisionBoostCreatePresets.apply(restarted, 0, backup);
    require(
        restarted.fanParticleDensity.value == .5 && restarted.filterItemRenderDistance.value == 10,
        "restaura originais após reinício");
    checks++;
    require(!Files.exists(backup), "remove apenas backup concluído");
    checks++;
    client.fanParticleDensity.value = .05;
    client.filterItemRenderDistance.value = 3;
    NVVisionBoostCreatePresets.apply(client, 1, backup);
    require(
        client.fanParticleDensity.value == .05 && client.filterItemRenderDistance.value == 3,
        "preserva opções mais econômicas");
    checks++;
    client.filterItemRenderDistance.value = 12;
    NVVisionBoostCreatePresets.apply(client, 0, backup);
    require(
        client.filterItemRenderDistance.value == 12,
        "restauração preserva edição externa posterior");
    checks++;
    client = new Client();
    client.filterItemRenderDistance.fail = true;
    try {
      NVVisionBoostCreatePresets.apply(client, 3, backup);
      throw new AssertionError("falha esperada");
    } catch (ReflectiveOperationException expected) {
      require(Files.exists(backup), "falha parcial mantém recuperação");
      checks++;
    }
    client.filterItemRenderDistance.fail = false;
    NVVisionBoostCreatePresets.apply(client, 0, backup);
    require(
        client.fanParticleDensity.value == .5 && client.filterItemRenderDistance.value == 10,
        "recupera mutação parcial");
    checks++;
    return checks;
  }

  private static void require(boolean valid, String name) {
    if (!valid) throw new AssertionError(name);
  }
}

