package nvvisionboost;

import com.mojang.blaze3d.vertex.BufferBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import nvvisionboost.mixin.NVVisionBoostBufferBuilderAccessor;
import nvvisionboost.mixin.NVVisionBoostBufferSourceAccessor;

/**
 * Actual native BufferBuilder discard, through the production optional adapter with owner queues.
 */
final class NVVisionBoostEntityBufferSmokeTest {
  private static Field field(String name) {
    try {
      Field f = BufferBuilder.class.getDeclaredField(name);
      f.setAccessible(true);
      return f;
    } catch (ReflectiveOperationException error) {
      throw new AssertionError(error);
    }
  }

  private static final Field READ = field("renderedBufferPointer"),
      WRITE = field("nextElementByte"),
      COUNT = field("renderedBufferCount"),
      BUILDING = field("building");

  private static final class AccountingBuffer extends BufferBuilder
      implements NVVisionBoostBufferBuilderAccessor {
    AccountingBuffer() {
      super(1024);
    }

    private int value(Field f) {
      try {
        return f.getInt(this);
      } catch (IllegalAccessException error) {
        throw new AssertionError(error);
      }
    }

    public int nvvb$getRenderedPointer() {
      return value(READ);
    }

    public int nvvb$getWritePointer() {
      return value(WRITE);
    }

    public int nvvb$getRenderedCount() {
      return value(COUNT);
    }

    public boolean nvvb$isBuilding() {
      try {
        return BUILDING.getBoolean(this);
      } catch (IllegalAccessException error) {
        throw new AssertionError(error);
      }
    }
  }

  private static final class Segment {
    Object currentType;
    List<Object> buffers = new ArrayList<>();
    AccountingBuffer buffer = new AccountingBuffer();
  }

  private static final class FixtureFullyBufferedMultiBufferSource {
    boolean isReady;
    Map<Object, Object> typeToSegment = new HashMap<>();
    List<Object> renderOrder = new ArrayList<>();
    Segment[] builders = {new Segment()};
  }

  private static final class FixtureSource extends MultiBufferSource.BufferSource
      implements NVVisionBoostBufferSourceAccessor {
    FixtureSource(AccountingBuffer buffer) {
      super(buffer, Map.of());
    }

    public BufferBuilder nvvb$getBuilder() {
      return builder;
    }

    public Map<RenderType, BufferBuilder> nvvb$getFixedBuffers() {
      return fixedBuffers;
    }

    public Optional<RenderType> nvvb$getLastState() {
      return lastState;
    }

    public Set<BufferBuilder> nvvb$getStartedBuffers() {
      return startedBuffers;
    }
  }

  static int run() throws Exception {
    var source = new FixtureFullyBufferedMultiBufferSource();
    var segment = source.builders[0];
    var buffer = segment.buffer;
    // Metadata of orphaned, already consumed batches; no vertex writes or GL draws are issued.
    READ.setInt(buffer, 33 * 1024 * 1024);
    WRITE.setInt(buffer, 33 * 1024 * 1024);
    COUNT.setInt(buffer, 2);
    segment.buffers.add(new Object());
    NVVisionBoostEntityBufferGuard.inspect(source);
    if (buffer.nvvb$getRenderedCount() != 2) throw new AssertionError("pending geometry cleared");
    segment.buffers.clear();
    source.isReady = true;
    NVVisionBoostEntityBufferGuard.inspect(source);
    if (buffer.nvvb$getRenderedCount() != 2) throw new AssertionError("ready geometry cleared");
    source.isReady = false;
    NVVisionBoostEntityBufferGuard.inspect(source);
    if (buffer.nvvb$getRenderedCount() != 0
        || buffer.nvvb$getWritePointer() != 0
        || buffer.nvvb$getRenderedPointer() != 0)
      throw new AssertionError("orphaned offsets not reclaimed by real BufferBuilder.clear");
    NVVisionBoostEntityBufferGuard.inspect(source);
    if (buffer.nvvb$getRenderedCount() != 0)
      throw new AssertionError("repeat reset corrupted accounting");
    var ordinary = new FixtureSource(buffer);
    READ.setInt(buffer, 33 * 1024 * 1024);
    WRITE.setInt(buffer, 33 * 1024 * 1024);
    COUNT.setInt(buffer, 2);
    ordinary.nvvb$getStartedBuffers().add(buffer);
    NVVisionBoostEntityBufferGuard.inspectVanilla(ordinary);
    if (buffer.nvvb$getRenderedCount() != 2)
      throw new AssertionError("started vanilla batch cleared");
    ordinary.nvvb$getStartedBuffers().clear();
    NVVisionBoostEntityBufferGuard.inspectVanilla(ordinary);
    if (buffer.nvvb$getRenderedCount() != 0 || buffer.nvvb$getWritePointer() != 0)
      throw new AssertionError("vanilla orphaned offsets not reclaimed");
    return 6;
  }
}
