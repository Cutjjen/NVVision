/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostShaderStartupPolicyTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

final class NVVisionBoostShaderStartupPolicyTest {
  static int run() {
    var policy = new NVVisionBoostShaderStartupPolicy();
    Object overworld = new Object(),
        nether = new Object(),
        pipeline = new Object(),
        reload = new Object();
    int checks = 0;
    require(policy.begin(null, "pack", null), "preparo inicial no menu");
    checks++;
    require(!policy.begin(null, "pack", null), "falha não dispara loop de compilação por quadro");
    checks++;
    policy.complete(pipeline);
    require(
        !policy.begin(null, "pack", pipeline), "pipeline criado não provoca segunda compilação");
    checks++;
    require(
        policy.begin(overworld, "pack", pipeline),
        "entrada exige sincronização do mundo antes do desenho");
    checks++;
    require(
        !policy.begin(overworld, "pack", pipeline),
        "mesmo mundo não reinicializa máquinas a cada quadro");
    checks++;
    require(policy.begin(nether, "pack", pipeline), "dimensão diferente recebe preparo próprio");
    checks++;
    policy.complete(reload);
    require(!policy.begin(nether, "pack", reload), "identidade após preparo é reconhecida");
    checks++;
    require(
        policy.begin(nether, "pack", pipeline), "reload do backend invalida identidade anterior");
    checks++;
    require(policy.begin(nether, "outro pack", pipeline), "troca de shader invalida preparo");
    checks++;
    policy.reset();
    require(
        policy.begin(nether, "outro pack", pipeline),
        "reativação após desligar shaders permite preparo");
    checks++;
    return checks;
  }

  private static void require(boolean valid, String description) {
    if (!valid) throw new AssertionError(description);
  }
}
