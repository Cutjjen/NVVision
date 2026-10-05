package nvvisionboost.legacy.addon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import nvvisionboost.legacy.LegacyConfig;

/**
 * Immediate client-only controls. No simulation changes, shader reloads, GL calls or worker pools.
 */
public final class LegacyCpuAdapter {
  private final LegacyIntegerLease particles = new LegacyIntegerLease();

  public static void initialize() {
    MinecraftForge.EVENT_BUS.register(new LegacyCpuAdapter());
  }

  @SubscribeEvent
  public void tick(TickEvent.ClientTickEvent event) {
    if (event.phase != TickEvent.Phase.END) return;
    GameSettings options = Minecraft.getMinecraft().gameSettings;
    options.particleSetting =
        particles.apply(
            options, options.particleSetting, LegacyConfig.enabled ? LegacyConfig.particles : 0);
  }

  @SubscribeEvent
  public void render(RenderLivingEvent.Pre<?> event) {
    if (!LegacyConfig.enabled
        || LegacyConfig.entities == 0
        || event.getEntity() instanceof EntityPlayer
        || !event.getEntity().isNonBoss()) return;
    Minecraft mc = Minecraft.getMinecraft();
    if (mc.player == null) return;
    net.minecraft.util.ResourceLocation id = EntityList.getKey(event.getEntity());
    if (id == null || !"minecraft".equals(id.getResourceDomain())) return;
    int range = LegacyConfig.entities == 1 ? 128 : 64;
    if (event.getEntity().getDistanceSq(mc.player) > range * range) event.setCanceled(true);
  }
}
