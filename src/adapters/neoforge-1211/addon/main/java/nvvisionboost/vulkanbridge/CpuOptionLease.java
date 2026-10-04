/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Controles e aplicação reversível de otimizações.
 * Arquivo lógico: main/java/nvvisionboost/vulkanbridge/CpuOptionLease.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge;

/** Restores only values still owned by this addon; respects user and mod changes. */
public final class CpuOptionLease<T> {
  private T original, applied;
  private boolean acquired, contested;
  public T update(T current, T desired) {
    if (contested) return current;
    if (!acquired) { original = current; acquired = true; }
    else if (!java.util.Objects.equals(current, applied)) { contested = true; return current; }
    applied = desired;
    return desired;
  }
  public T release(T current) {
    T result = acquired && !contested && java.util.Objects.equals(current, applied) ? original : current;
    acquired = contested = false;
    original = applied = null;
    return result;
  }
}

