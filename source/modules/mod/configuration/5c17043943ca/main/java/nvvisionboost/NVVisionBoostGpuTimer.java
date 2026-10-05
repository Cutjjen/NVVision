package nvvisionboost;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL33;

<<<<<<< HEAD
/**
 * Timestamp queries do not occupy other mods' GL_TIME_ELAPSED queries and never wait for results.
 */
=======
/** Timestamps não ocupam GL_TIME_ELAPSED de outros mods. Nunca espera por resultados. */
>>>>>>> origin/master
final class NVVisionBoostGpuTimer {
  private static final int SLOTS = 4;
  private final int[] queries = new int[SLOTS * 3];
  private final boolean[] pending = new boolean[SLOTS], hasUpscale = new boolean[SLOTS];
  private final int[] generations = new int[SLOTS];
  private final double[] cpuTimes = new double[SLOTS];
  private int write, read, active = -1, generation;
  private boolean initialized, unsupported;
  private long cpuStart, lastSample;
  private double gpuMs, upscaleMs, cpuMs;
  private int samples;

  boolean available() {
    return initialized && !unsupported;
  }

  int samples() {
    return samples;
  }

  long lastSampleNanos() {
    return lastSample;
  }

  double gpuMs() {
    return gpuMs;
  }

  double upscaleMs() {
    return upscaleMs;
  }

  double cpuMs() {
    return cpuMs;
  }

  void begin() {
    if (active >= 0 || unsupported) return;
    if (!(net.minecraft.client.Minecraft.getInstance()
            .gameRenderer
            .mainRenderTarget()
            .getColorTexture()
        instanceof com.mojang.blaze3d.opengl.GlTexture)) {
      unsupported = true;
      return;
    }
    if (!initialized) {
      var caps = GL.getCapabilities();
      if (!caps.OpenGL33 && !caps.GL_ARB_timer_query) {
        unsupported = true;
        return;
      }
      if (GL15.glGetQueryi(GL33.GL_TIMESTAMP, GL15.GL_QUERY_COUNTER_BITS) == 0) {
        unsupported = true;
        return;
      }
      for (int i = 0; i < queries.length; i++) {
        queries[i] = GL15.glGenQueries();
        if (queries[i] == 0) {
          close();
          unsupported = true;
          return;
        }
      }
      initialized = true;
    }
    if (pending[write]) return; // GPU atrasada: pula coleta em vez de bloquear o jogo.
    active = write;
    hasUpscale[active] = false;
    generations[active] = generation;
    cpuStart = System.nanoTime();
    GL33.glQueryCounter(queries[active * 3], GL33.GL_TIMESTAMP);
  }

  void markUpscale() {
    if (active < 0) return;
    hasUpscale[active] = true;
    GL33.glQueryCounter(queries[active * 3 + 1], GL33.GL_TIMESTAMP);
  }

  void end() {
    if (active < 0) return;
    GL33.glQueryCounter(queries[active * 3 + 2], GL33.GL_TIMESTAMP);
    cpuTimes[active] = (System.nanoTime() - cpuStart) / 1_000_000.0;
    pending[active] = true;
    write = (active + 1) % SLOTS;
    active = -1;
  }

  void poll() {
    if (!initialized || !pending[read]) return;
    int endQuery = queries[read * 3 + 2];
    if (GL15.glGetQueryObjecti(endQuery, GL15.GL_QUERY_RESULT_AVAILABLE) == 0) return;
    long end = GL33.glGetQueryObjectui64(endQuery, GL15.GL_QUERY_RESULT);
    long start = GL33.glGetQueryObjectui64(queries[read * 3], GL15.GL_QUERY_RESULT);
    double elapsed = (end - start) / 1_000_000.0;
    if (generations[read] == generation && elapsed > 0 && elapsed < 2000) {
      gpuMs = average(gpuMs, elapsed);
      cpuMs = average(cpuMs, cpuTimes[read]);
      if (hasUpscale[read]) {
        long filter = GL33.glGetQueryObjectui64(queries[read * 3 + 1], GL15.GL_QUERY_RESULT);
        upscaleMs = average(upscaleMs, Math.max(0, (end - filter) / 1_000_000.0));
      } else upscaleMs = 0;
      samples++;
      lastSample = System.nanoTime();
    }
    pending[read] = false;
    read = (read + 1) % SLOTS;
  }

  private static double average(double previous, double current) {
    return previous == 0 ? current : previous * .9 + current * .1;
  }

  void invalidate() {
    generation++;
    samples = 0;
    gpuMs = upscaleMs = cpuMs = 0;
    lastSample = 0;
  }

  void close() {
    if (active >= 0) end();
    for (int i = 0; i < queries.length; i++) {
      if (queries[i] != 0) GL15.glDeleteQueries(queries[i]);
      queries[i] = 0;
    }
    java.util.Arrays.fill(pending, false);
    active = -1;
    write = read = 0;
    initialized = unsupported = false;
    invalidate();
  }
}
