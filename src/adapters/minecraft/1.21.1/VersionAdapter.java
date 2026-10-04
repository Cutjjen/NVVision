/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Adaptador das APIs do Minecraft.
 * Arquivo lógico: main/java/nvvisionboost/minecraft/VersionAdapter.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.minecraft;
import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;
final class VersionAdapter implements MinecraftVersionAdapter {
 public RenderTarget mainRenderTarget() { var mc=Minecraft.getInstance(); return mc.getMainRenderTarget(); }
 public void accessNotice(Component title, Component description) { var mc=Minecraft.getInstance(); mc.getToasts().addToast(SystemToast.multiline(mc, SystemToast.SystemToastId.PERIODIC_NOTIFICATION,title,description)); }
}
