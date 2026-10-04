/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/compat/NVVisionBoostMixinPlugin.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.compat;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.service.MixinService;
import nvvisionboost.NVVisionBoostIrisDepthSafety;

/** Optional shader bridge never loads Iris classes when the shader mod is absent. */
public final class NVVisionBoostMixinPlugin implements IMixinConfigPlugin {
  public static final String RESIZE = "(ILcom/mojang/blaze3d/textures/GpuTexture;IILnet/irisshaders/iris/gl/texture/DepthBufferFormat;Lnet/irisshaders/iris/shaderpack/properties/PackDirectives;)Z";
  public static boolean compatible(ClassNode target) {
    return target != null
        && target.fields.stream().anyMatch(f -> f.name.equals("currentDepthTexture") && f.desc.equals("Lcom/mojang/blaze3d/textures/GpuTexture;"))
        && target.fields.stream().anyMatch(f -> f.name.equals("cachedDepthBufferVersion") && f.desc.equals("I"))
        && target.methods.stream().anyMatch(m -> m.name.equals("resizeIfNeeded") && m.desc.equals(RESIZE));
  }
  public boolean shouldApplyMixin(String targetName, String mixinName) {
    if (!mixinName.endsWith("NVVisionBoostIrisDepthMixin")) return true;
    try {
      var target = MixinService.getService().getBytecodeProvider().getClassNode(targetName);
      NVVisionBoostIrisDepthSafety.validated = compatible(target);
    } catch (Exception | LinkageError unavailable) {
      NVVisionBoostIrisDepthSafety.validated = false;
    }
    return NVVisionBoostIrisDepthSafety.validated;
  }
  public void onLoad(String packageName) {}
  public String getRefMapperConfig() { return null; }
  public void acceptTargets(Set<String> mine, Set<String> other) {}
  public List<String> getMixins() { return null; }
  public void preApply(String name, ClassNode target, String mixin, IMixinInfo info) {}
  public void postApply(String name, ClassNode target, String mixin, IMixinInfo info) {}
}
