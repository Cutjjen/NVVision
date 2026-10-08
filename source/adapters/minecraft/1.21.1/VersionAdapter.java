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
    mc.getToasts()
        .addToast(
            SystemToast.multiline(
                mc, SystemToast.SystemToastId.PERIODIC_NOTIFICATION, title, description));
  }

  public void openScreen(net.minecraft.client.gui.screens.Screen screen) {
    Minecraft.getInstance().setScreen(screen);
  }

  public net.minecraft.client.gui.screens.Screen currentScreen() {
    return Minecraft.getInstance().screen;
  }

  public net.minecraft.world.phys.Vec3 cameraPosition() {
    return Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
  }
}
