package nvvisionboost.vulkanbridge;

/** Restores only values still owned by this addon; respects user and mod changes. */
public final class CpuOptionLease<T> {
  private T original, applied;
  private boolean acquired, contested;

  /** Acquire an option and propose a value; external edits end ownership until release. */
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

  /**
   * Restore the original value only if the current value still matches the addon's applied value.
   */
  public T release(T current) {
    T result =
        acquired && !contested && java.util.Objects.equals(current, applied) ? original : current;
    acquired = contested = false;
    original = applied = null;
    return result;
  }
}
