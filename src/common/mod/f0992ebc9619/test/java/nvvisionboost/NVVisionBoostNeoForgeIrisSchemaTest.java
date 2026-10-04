/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostNeoForgeIrisSchemaTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.util.jar.JarFile;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import nvvisionboost.compat.NVVisionBoostMixinPlugin;

public final class NVVisionBoostNeoForgeIrisSchemaTest {
  public static void main(String[] args) throws Exception {
    int count=0;
    try(var jar=new JarFile(args[0])) {
      var target=new ClassNode();
      new ClassReader(jar.getInputStream(jar.getJarEntry("net/irisshaders/iris/targets/RenderTargets.class"))).accept(target,0);
      if(!NVVisionBoostMixinPlugin.compatible(target)) throw new AssertionError("Official Iris schema");count++;
      if(NVVisionBoostMixinPlugin.compatible(null)) throw new AssertionError("Absent Iris must fail closed");count++;
      var version=target.fields.stream().filter(f->f.name.equals("cachedDepthBufferVersion")).findFirst().orElseThrow();
      version.desc="J";
      if(NVVisionBoostMixinPlugin.compatible(target)) throw new AssertionError("Changed field must fail closed");count++;
      version.desc="I";
      target.methods.removeIf(m->m.name.equals("resizeIfNeeded"));
      if(NVVisionBoostMixinPlugin.compatible(target)) throw new AssertionError("Absent resize API must fail closed");count++;
      if(!new NVVisionBoostMixinPlugin().shouldApplyMixin("net.minecraft.client.Minecraft","nvvisionboost.mixin.NVVisionBoostMinecraftMixin")) throw new AssertionError("Base mixins preserved");count++;
    }
    System.out.println("PASS OPTIONAL IRIS SCHEMA: "+count+" checks.");
  }
}
