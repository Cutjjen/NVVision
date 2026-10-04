package nvvisionboost.minecraft;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

final class VersionAdapter implements MinecraftVersionAdapter {
  public RenderTarget mainRenderTarget() {
    var mc = Minecraft.getInstance();
    return mc.getMainRenderTarget();
  }

  public void accessNotice(Component title, Component description) {
    var mc = Minecraft.getInstance();
    mc.getToastManager()
        .addToast(
            SystemToast.multiline(mc, new SystemToast.SystemToastId(8000), title, description));
  }
}
