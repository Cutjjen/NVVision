package nvvisionboost.vulkanbridge;

/** Restores only values still owned by this addon; respects user and mod changes. */
public final class CpuOptionLease<T> {
  private T original, applied;
  private boolean acquired, contested;

<<<<<<< HEAD
  /** Acquire an option and propose a value; external edits end ownership until release. */
=======
  /**
   * Adquire a opção e propõe um valor; uma alteração externa encerra o controle até a liberação.
   */
>>>>>>> origin/master
  public T update(T current, T desired) {
    if (contested) return current;
    if (!acquired) {
      original = current;
      acquired = true;
    } else if (!java.util.Objects.equals(current, applied)) {
      contested = true;
      return current;
    }
    applied = desired;
    return desired;
  }

<<<<<<< HEAD
  /**
   * Restore the original value only if the current value still matches the addon's applied value.
   */
=======
  /** Devolve o valor original somente se o valor atual ainda for aquele aplicado pelo addon. */
>>>>>>> origin/master
  public T release(T current) {
    T result =
        acquired && !contested && java.util.Objects.equals(current, applied) ? original : current;
    acquired = contested = false;
    original = applied = null;
    return result;
  }
}
