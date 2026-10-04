/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostQualityAndCreateTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;
import java.nio.file.*;
public final class NVVisionBoostQualityAndCreateTest {
  static int checks;
  static void check(boolean value){if(!value)throw new AssertionError("Check "+checks);checks++;}
  public static final class Value {
    double value;
    Value(double value){this.value=value;}
    public Double get(){return value;}
    public void set(Object input){value=((Number)input).doubleValue();}
  }
  public static final class Client {
    public Value fanParticleDensity=new Value(1);
    public Value filterItemRenderDistance=new Value(16);
  }
  public static void main(String[] args)throws Exception {
    var config=new NVVisionBoostCore.Config();config.autoOptimize=false;
    for(int scale:new int[]{85,75,67,100}) {
      NVVisionBoostImageQuality.configure(config,scale);
      check(config.renderScalePercent==scale);
      check(config.dynamicMinScalePercent<=scale);
      check(!config.autoOptimize);
      check(config.upscalingEnabled==(scale<100));
    }
    Path root=Files.createTempDirectory(Path.of(args[0]),"create-");
    Path backup=root.resolve("backup.properties");var client=new Client();
    NVVisionBoostCreatePresets.apply(client,2,backup);
    check(client.fanParticleDensity.get()==.1);check(client.filterItemRenderDistance.get()==6);
    check(Files.exists(backup));
    NVVisionBoostCreatePresets.apply(client,0,backup);
    check(client.fanParticleDensity.get()==1);check(client.filterItemRenderDistance.get()==16);
    check(!Files.exists(backup));
    NVVisionBoostCreatePresets.apply(client,3,backup);
    client.filterItemRenderDistance.set(12d);
    NVVisionBoostCreatePresets.apply(client,0,backup);
    check(client.fanParticleDensity.get()==1);check(client.filterItemRenderDistance.get()==12);
    check(!Files.exists(backup));
    System.out.println("PASS QUALITY/CREATE: "+checks+" checks.");
  }
}
