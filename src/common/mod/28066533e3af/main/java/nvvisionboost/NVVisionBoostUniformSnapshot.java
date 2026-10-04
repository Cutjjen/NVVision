/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostUniformSnapshot.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import net.minecraft.client.DeltaTracker;
import net.minecraft.world.phys.Vec3;

/** Native frame uniforms restored after the world pass and before GUI rendering. */
public record NVVisionBoostUniformSnapshot(
    int width,
    int height,
    double value,
    long time,
    DeltaTracker delta,
    int scale) {}
