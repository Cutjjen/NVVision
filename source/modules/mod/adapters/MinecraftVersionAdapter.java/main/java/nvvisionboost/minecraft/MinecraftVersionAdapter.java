package nvvisionboost.minecraft;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.network.chat.Component;

/** Version boundary: framebuffer ownership and native UI notifications. */
public interface MinecraftVersionAdapter {
  RenderTarget mainRenderTarget();

  void accessNotice(Component title, Component description);

  void openScreen(net.minecraft.client.gui.screens.Screen screen);

  net.minecraft.client.gui.screens.Screen currentScreen();

  net.minecraft.world.phys.Vec3 cameraPosition();
}
