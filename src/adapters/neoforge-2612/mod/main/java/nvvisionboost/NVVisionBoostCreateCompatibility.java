/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostCreateCompatibility.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

/** Integração opcional: Create/Flywheel conservam o controle de suas máquinas. */
public final class NVVisionBoostCreateCompatibility {
  private NVVisionBoostCreateCompatibility() {}

  public static boolean createLoaded() {
    return NVVisionBoostCompatibility.loaded("create");
  }

  public static boolean flywheelLoaded() {
    return NVVisionBoostCompatibility.loaded("flywheel");
  }

  public static boolean protectsMachineRendering() {
    return createLoaded() || flywheelLoaded();
  }

  /** A escala manual é permitida; não altera o backend ou culling do Flywheel. */
  public static boolean allowsFramebufferScaling() {
    return NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling();
  }

  public static String scalingReason() {
    return NVVisionBoostDistantHorizonsCompatibility.loaded()
        ? "Resolução nativa: passes Distant Horizons ainda não validados"
        : "";
  }

  public static boolean allowsAutomaticScaleChanges() {
    return !protectsMachineRendering() && allowsFramebufferScaling();
  }

  public static String summary() {
    return "Create="
        + createLoaded()
        + " | Flywheel="
        + flywheelLoaded()
        + (protectsMachineRendering()
            ? " | simulação e entidades preservadas; escala manual permitida; escala automática"
                + " suspensa"
            : " | perfil padrão");
  }
}

