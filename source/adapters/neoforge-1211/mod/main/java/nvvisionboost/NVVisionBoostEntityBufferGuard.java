package nvvisionboost;

import com.mojang.blaze3d.vertex.BufferBuilder;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import nvvisionboost.mixin.NVVisionBoostBufferBuilderAccessor;
import nvvisionboost.mixin.NVVisionBoostBufferSourceAccessor;

/** Reclaims orphaned CPU offsets only after Oculus has emptied its per-frame queues. */
public final class NVVisionBoostEntityBufferGuard {
  private static long nextCheck, nextLog;
  private static boolean failed;
  private static Class<?> ownerType, segmentType;
  private static Field sourceField, readyField, typesField, orderField, buildersField;
  private static Field currentField, pendingField, bufferField;
  private static long resets, reclaimedOffsets;

  private NVVisionBoostEntityBufferGuard() {}

  static boolean reclaimable(
      boolean building,
      int outstanding,
      long used,
      boolean ready,
      boolean ownerEmpty,
      boolean segmentEmpty) {
    return !building
        && outstanding > 0
        && used >= 32L * 1024 * 1024
        && !ready
        && ownerEmpty
        && segmentEmpty;
  }

  private static Field field(Class<?> type, String name) throws NoSuchFieldException {
    for (Class<?> current = type; current != null; current = current.getSuperclass()) {
      try {
        var result = current.getDeclaredField(name);
        result.setAccessible(true);
        return result;
      } catch (NoSuchFieldException ignored) {
      }
    }
    throw new NoSuchFieldException(name);
  }

  public static void afterFrame() {
    var config = NVVisionBoostCore.cfg;
    long now = System.nanoTime();
    if (config == null
        || !config.enabled
        || !config.memoryGuard
        || now < nextCheck
        || !NVVisionBoostCompatibility.oculus()) return;
    nextCheck = now + 1_000_000_000L;
    Minecraft mc = Minecraft.getInstance();
    if (mc == null || mc.level == null || mc.getOverlay() != null) return;
    var ordinary = mc.renderBuffers().bufferSource();
    // Only the standard game-owned source. Custom subclasses may cache their own batches.
    if (ordinary.getClass() == MultiBufferSource.BufferSource.class) inspectVanilla(ordinary);
    if (failed) return;
    try {
      Object buffers = mc.renderBuffers();
      if (sourceField == null) sourceField = field(buffers.getClass(), "buffered");
      inspect(sourceField.get(buffers));
    } catch (ReflectiveOperationException | RuntimeException | LinkageError unavailable) {
      failed = true;
      NVVisionBoostCore.log(
          "[NVVB Buffers] Integração indisponível; buffers preservados: "
              + unavailable.getClass().getSimpleName());
    }
  }

  static void inspectVanilla(MultiBufferSource.BufferSource source) {
    if (!(source instanceof NVVisionBoostBufferSourceAccessor owner)) return;
    if (!owner.nvvb$getStartedBuffers().isEmpty() || owner.nvvb$getLastState().isPresent()) return;
    var candidates =
        java.util.Collections.newSetFromMap(
            new java.util.IdentityHashMap<BufferBuilder, Boolean>());
    candidates.add(owner.nvvb$getBuilder());
    candidates.addAll(owner.nvvb$getFixedBuffers().values());
    for (BufferBuilder buffer : candidates) reclaim(buffer, true);
  }

  private static void reclaim(BufferBuilder buffer, boolean empty) {
    if (!(buffer instanceof NVVisionBoostBufferBuilderAccessor accounting)) return;
    long used = Math.max(accounting.nvvb$getRenderedPointer(), accounting.nvvb$getWritePointer());
    if (!reclaimable(
        accounting.nvvb$isBuilding(), accounting.nvvb$getRenderedCount(), used, false, empty, true))
      return;
    // Owner queues are empty: discard orphaned accounting through Minecraft's API.
    // Legacy Oculus accounting is not applied to the 1.21.1 buffer architecture.
    resets++;
    reclaimedOffsets += used;
    long now = System.nanoTime();
    if (now >= nextLog) {
      nextLog = now + 60_000_000_000L;
      NVVisionBoostCore.log(
          "[NVVB Buffers] Offset órfão recuperado após o quadro: "
              + used / 1048576
              + " MiB; filas vazias confirmadas.");
    }
  }

  static void inspect(Object source) throws ReflectiveOperationException {
    if (source == null || !source.getClass().getName().endsWith("FullyBufferedMultiBufferSource"))
      return;
    if (ownerType != source.getClass()) {
      ownerType = source.getClass();
      readyField = field(ownerType, "isReady");
      typesField = field(ownerType, "typeToSegment");
      orderField = field(ownerType, "renderOrder");
      buildersField = field(ownerType, "builders");
    }
    boolean ready = readyField.getBoolean(source);
    boolean empty =
        ((Map<?, ?>) typesField.get(source)).isEmpty()
            && ((Collection<?>) orderField.get(source)).isEmpty();
    if (ready || !empty) return;
    for (Object segment : (Object[]) buildersField.get(source)) {
      if (segmentType != segment.getClass()) {
        segmentType = segment.getClass();
        currentField = field(segmentType, "currentType");
        pendingField = field(segmentType, "buffers");
        bufferField = field(segmentType, "buffer");
      }
      boolean segmentEmpty =
          currentField.get(segment) == null
              && ((Collection<?>) pendingField.get(segment)).isEmpty();
      Object value = bufferField.get(segment);
      if (value instanceof BufferBuilder buffer) reclaim(buffer, segmentEmpty);
    }
  }

  public static String status() {
    return "offsets recuperados="
        + resets
        + " | bytes acumulados="
        + reclaimedOffsets
        + (failed ? " | integração indisponível" : "");
  }
}
