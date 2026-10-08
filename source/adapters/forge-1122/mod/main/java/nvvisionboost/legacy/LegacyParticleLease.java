package nvvisionboost.legacy;

/** Reversible integer option lease. Respect edits made by the player or another optimizer. */
public final class LegacyParticleLease {
  private Object owner;
  private int original;
  private int last;
  private boolean leased;

  public int apply(Object optionOwner, int current, int reduction) {
    if (owner != optionOwner) {
      owner = optionOwner;
      leased = false;
    }
    if (reduction == 0) {
      int restored = leased && current == last ? original : current;
      leased = false;
      return restored;
    }
    if (!leased || current != last) original = current;
    leased = true;
    last = Math.max(original, Math.max(0, Math.min(2, reduction)));
    return last;
  }
}
