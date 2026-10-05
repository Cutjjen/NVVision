package nvvisionboost.rendering;

import java.util.Objects;

/**
 * Loader-independent attachment exchange and recovery shared by every Minecraft renderer adapter.
 */
public final class WorldTargetLease<T, S> {
  private final RenderTargetAdapter<T, S> adapter;
  private T main, internal;

  public WorldTargetLease(RenderTargetAdapter<T, S> adapter) {
    this.adapter = Objects.requireNonNull(adapter);
  }

  public void begin(T main, T internal) {
    if (active()) throw new IllegalStateException("Target lease already active");
    Objects.requireNonNull(main);
    Objects.requireNonNull(internal);
    if (main == internal) throw new IllegalArgumentException("Aliased render targets");
    adapter.validate(main, internal);
    S nativeState = adapter.capture(main), worldState = adapter.capture(internal);
    adapter.apply(main, worldState);
    adapter.apply(internal, nativeState);
    this.main = main;
    this.internal = internal;
  }

  /**
   * Uses the current states so replacement attachments created by another mod retain correct
   * ownership.
   */
  public void restore() {
    if (!active()) return;
    S renderedState = adapter.capture(main), nativeState = adapter.capture(internal);
    adapter.apply(main, nativeState);
    adapter.apply(internal, renderedState);
    main = internal = null;
  }

  public boolean active() {
    return main != null;
  }
}
