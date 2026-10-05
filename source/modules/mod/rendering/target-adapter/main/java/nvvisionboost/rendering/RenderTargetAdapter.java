package nvvisionboost.rendering;

/**
 * Minecraft-specific access to complete target state. Implementations validate immutable target
 * capabilities and capture/apply all attachment ownership, dimensions and views. apply must perform
 * field assignments only: no GPU allocation, disposal, resize or main-target pointer replacement.
 */
public interface RenderTargetAdapter<T, S> {
  void validate(T main, T internal);

  S capture(T target);

  void apply(T target, S state);
}
