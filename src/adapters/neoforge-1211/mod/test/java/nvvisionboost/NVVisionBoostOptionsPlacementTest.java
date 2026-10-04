/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Interface, localização e posicionamento.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostOptionsPlacementTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;
import java.util.*;
public final class NVVisionBoostOptionsPlacementTest {
 public static void main(String[] args) {
  var boxes=new ArrayList<NVVisionBoostOptionsPlacement.Rect>();
  for(int y:new int[]{80,104,128,152}){boxes.add(new NVVisionBoostOptionsPlacement.Rect(270,y,150,20));boxes.add(new NVVisionBoostOptionsPlacement.Rect(428,y,150,20));}
  boxes.add(new NVVisionBoostOptionsPlacement.Rect(270,176,150,20));
  boxes.add(new NVVisionBoostOptionsPlacement.Rect(350,470,150,20));
  var snapshot=List.copyOf(boxes);
  var result=NVVisionBoostOptionsPlacement.place(820,500,boxes).orElseThrow();
  if(result.x()!=428||result.y()!=176||!boxes.equals(snapshot))throw new AssertionError("Customized options row/vanilla widgets changed");
  boxes.add(result);
  var fallback=NVVisionBoostOptionsPlacement.place(820,500,boxes).orElseThrow();
  if(boxes.stream().anyMatch(fallback::overlaps))throw new AssertionError("Fallback overlap");
  if(NVVisionBoostOptionsPlacement.place(20,20,List.of()).isPresent())throw new AssertionError("Tiny screen overflow");
  System.out.println("PASS options placement: customized grid, occupied row, unchanged widgets and tiny screen");
 }
}
