/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/minecraft/MinecraftVersionAdapter.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.minecraft;
import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.network.chat.Component;
/** Version boundary: framebuffer ownership and native UI notifications. */
public interface MinecraftVersionAdapter {
  RenderTarget mainRenderTarget();
  void accessNotice(Component title, Component description);
}
