/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Controles e aplicação reversível de otimizações.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/BridgeCpuOptimizer.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;
import java.nio.file.*;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.ParticleStatus;

/** Reversible client visual budgets. Does not alter simulation or graphics state. */
public final class BridgeCpuOptimizer {
 private static final CpuOptionLease<Double> distance=new CpuOptionLease<>();
 private static final CpuOptionLease<ParticleStatus> particles=new CpuOptionLease<>();
 private static String mode="off", customDistance="off", customParticles="off";
 private static boolean initialized,active;
 private static long next;
 private static Path config;
 private BridgeCpuOptimizer() {}
 public static boolean initialized(){return initialized;}
 public static String mode(){return mode;}
 public static String control(String key){return switch(key){case "distance" -> customDistance; case "particles" -> customParticles; default -> "unavailable";};}
 public static void initialize(Path directory){
  if(initialized)return;
  initialized=true; config=directory.resolve("cpu.properties");
  try{
   Properties p=read(); String saved=p.getProperty("profile","off");
   if(valid(saved))mode=saved;
   String d=p.getProperty("distance","off"),v=p.getProperty("particles","off");
   if(java.util.Set.of("off","75%","50%","25%").contains(d))customDistance=d;
   if(java.util.Set.of("off","decreased","minimal").contains(v))customParticles=v;
  }catch(Exception error){org.slf4j.LoggerFactory.getLogger("NVVisionCPU").warn("CPU config unavailable; disabled.",error);mode="off";}
 }
 private static Properties read() throws java.io.IOException{
  Properties p=new Properties();if(Files.exists(config))try(var in=Files.newInputStream(config)){p.load(in);}return p;
 }
 private static boolean valid(String v){return java.util.Set.of("off","balanced","economy","custom").contains(v);}
 private static void save(String profile,String d,String v)throws java.io.IOException{
  Properties p=read();p.setProperty("profile",profile);p.setProperty("distance",d);p.setProperty("particles",v);
  var writer=new java.io.StringWriter();p.store(writer,"Cutjjen - reversible client visual budgets");BridgeFiles.atomic(config,writer.toString());
 }
 public static String request(String value){
  if(!valid(value)||config==null)return "Perfil CPU indisponível.";
  try{save(value,customDistance,customParticles);release(Minecraft.getInstance());mode=value;next=0;return "Perfil CPU: "+mode;}
  catch(Exception error){return "Perfil não alterado: "+error.getMessage();}
 }
 public static String cycleControl(String key){
  if(config==null)return "Addon CPU indisponível.";
  String d=customDistance,v=customParticles;
  if("distance".equals(key))d=switch(d){case "off" -> "75%";case "75%" -> "50%";case "50%" -> "25%";default -> "off";};
  else if("particles".equals(key))v=switch(v){case "off" -> "decreased";case "decreased" -> "minimal";default -> "off";};
  else return "Controle inválido.";
  try{save("custom",d,v);release(Minecraft.getInstance());mode="custom";customDistance=d;customParticles=v;next=0;return "CPU personalizado: entidades="+d+", partículas="+v;}
  catch(Exception error){return "Controle não alterado: "+error.getMessage();}
 }
 public static void tick(){
  if(!initialized||"off".equals(mode)&&!active)return;
  long now=System.nanoTime();if(now<next)return;next=now+1_000_000_000L;
  var mc=Minecraft.getInstance();if(mc.level==null||"off".equals(mode)){release(mc);return;}
  double ceiling=switch(mode){case "balanced" -> .75;case "economy" -> .5;default -> switch(customDistance){case "75%" -> .75;case "50%" -> .5;case "25%" -> .25;default -> -1;};};
  ParticleStatus limit=switch(mode){case "balanced" -> ParticleStatus.DECREASED;case "economy" -> ParticleStatus.MINIMAL;default -> switch(customParticles){case "decreased" -> ParticleStatus.DECREASED;case "minimal" -> ParticleStatus.MINIMAL;default -> null;};};
  var current=mc.options.entityDistanceScaling().get();
  var target=ceiling<0?distance.release(current):distance.update(current,Math.min(current,ceiling));
  if(!target.equals(current))mc.options.entityDistanceScaling().set(target);
  var existing=mc.options.particles().get();
  var wanted=limit==null?particles.release(existing):particles.update(existing,existing.ordinal()>=limit.ordinal()?existing:limit);
  if(wanted!=existing)mc.options.particles().set(wanted);
  active=ceiling>=0||limit!=null;
 }
 public static void shutdown(){var mc=Minecraft.getInstance();if(!active||mc.options==null)return;release(mc);mc.options.save();}
 private static void release(Minecraft mc){
  if(!active)return;
  var current=mc.options.entityDistanceScaling().get();var target=distance.release(current);
  if(!target.equals(current))mc.options.entityDistanceScaling().set(target);
  var existing=mc.options.particles().get();var wanted=particles.release(existing);
  if(wanted!=existing)mc.options.particles().set(wanted);active=false;
 }
}

