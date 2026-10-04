/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/minecraft/MinecraftAccess.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.minecraft;
/** Explicit version binding selected at build time; no runtime version guessing. */
public final class MinecraftAccess {
  private static final MinecraftVersionAdapter ADAPTER = new VersionAdapter();
  private MinecraftAccess() {}
  public static MinecraftVersionAdapter get() { return ADAPTER; }
}
