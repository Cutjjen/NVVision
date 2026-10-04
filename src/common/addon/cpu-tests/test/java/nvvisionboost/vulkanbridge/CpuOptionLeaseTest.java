/* NVVision — Cutjjen. Etapa: validação de propriedade e configuração de controles CPU. */
package nvvisionboost.vulkanbridge;

public final class CpuOptionLeaseTest {
  private static int checks;
  private static void check(boolean value) { if(!value) throw new AssertionError("Check "+checks); checks++; }
  public static void main(String[] args) {
    var lease=new CpuOptionLease<Double>();
    check(lease.release(1.0)==1.0);
    check(lease.update(1.0,0.75)==0.75);
    check(lease.update(0.75,0.75)==0.75);
    check(lease.release(0.75)==1.0);
    check(lease.update(0.5,0.5)==0.5);
    check(lease.release(0.5)==0.5);
    check(lease.update(1.0,0.5)==0.5);
    check(lease.update(0.9,0.5)==0.9);
    check(lease.update(0.9,0.5)==0.9);
    check(lease.release(0.9)==0.9);
    check(lease.update(1.0,0.5)==0.5);
    check(lease.release(0.8)==0.8);
    check(lease.update(1.0,0.75)==0.75);
    check(lease.release(0.75)==1.0);
    var particle=new CpuOptionLease<String>();
    check(particle.update("all","decreased").equals("decreased"));
    check(particle.release("decreased").equals("all"));
    check(particle.update("all","minimal").equals("minimal"));
    check(particle.release("decreased").equals("decreased"));
    System.out.println("CPU option ownership: "+checks+" checks passed");
  }
}

