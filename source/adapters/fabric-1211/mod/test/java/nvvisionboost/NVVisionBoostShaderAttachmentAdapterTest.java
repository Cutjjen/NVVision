package nvvisionboost;

/** Reallocation regression: recycled texture handles must not preserve stale Iris attachments. */
public final class NVVisionBoostShaderAttachmentAdapterTest {
  private static class Targets {
    private int cachedDepthBufferVersion = 7;
  }

  private static class FinalPass {
    private int lastColorTextureId = 47;
  }

  private static class Pipeline {
    private final Targets renderTargets = new Targets();
    private final FinalPass finalPassRenderer = new FinalPass();
  }

  private static final class DerivedPipeline extends Pipeline {}

  private static final class Unsupported {
    private final Targets renderTargets = new Targets();
    private final Object finalPassRenderer = new Object();
  }

  private static int checks;

  private static void check(boolean valid) {
    checks++;
    if (!valid) throw new AssertionError("Attachment regression " + checks);
  }

  public static void main(String[] args) throws Exception {
    Pipeline pipeline = new Pipeline();
    NVVisionBoostShaderAttachmentAdapter.invalidate(pipeline, 7);
    check(pipeline.renderTargets.cachedDepthBufferVersion != 7);
    check(pipeline.finalPassRenderer.lastColorTextureId == -1);
    // Simulate Iris consuming the invalidation, then OpenGL reusing handle 47 at another size.
    pipeline.renderTargets.cachedDepthBufferVersion = 7;
    pipeline.finalPassRenderer.lastColorTextureId = 47;
    NVVisionBoostShaderAttachmentAdapter.invalidate(pipeline, 7);
    check(pipeline.renderTargets.cachedDepthBufferVersion != 7);
    check(pipeline.finalPassRenderer.lastColorTextureId != 47);
    Pipeline derived = new DerivedPipeline();
    NVVisionBoostShaderAttachmentAdapter.invalidate(derived, Integer.MIN_VALUE);
    check(derived.renderTargets.cachedDepthBufferVersion != Integer.MIN_VALUE);
    check(derived.finalPassRenderer.lastColorTextureId == -1);
    Unsupported unsupported = new Unsupported();
    try {
      NVVisionBoostShaderAttachmentAdapter.invalidate(unsupported, 7);
      throw new AssertionError("Unsupported capability accepted");
    } catch (NoSuchFieldException expected) {
      check(unsupported.renderTargets.cachedDepthBufferVersion == 7);
    }
    System.out.println("PASS shader attachment generations: " + checks + " checks");
  }
}
