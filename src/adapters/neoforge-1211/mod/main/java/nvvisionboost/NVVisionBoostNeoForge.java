/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostNeoForge.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
@Mod(value="nvvisionboost", dist=net.neoforged.api.distmarker.Dist.CLIENT)
public final class NVVisionBoostNeoForge {
 public NVVisionBoostNeoForge(ModContainer container) {
  container.registerExtensionPoint(IConfigScreenFactory.class, (owner,parent)->new NVVisionBoostConfigScreen(parent));
 }
}


