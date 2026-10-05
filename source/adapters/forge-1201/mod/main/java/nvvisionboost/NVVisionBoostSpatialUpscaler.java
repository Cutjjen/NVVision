package nvvisionboost;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import nvvisionboost.rendering.MinecraftGlStateAdapter;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

/**
 * Spatial reconstruction without history: Catmull-Rom bicubic filtering and contrast-limited
 * sharpening.
 */
public final class NVVisionBoostSpatialUpscaler {
  private static final NVVisionBoostUpscaleBudget BUDGET = new NVVisionBoostUpscaleBudget();
  private static final State STATE = new State();
  private static int program, vao, sampler, sizeUniform, sharpnessUniform, modeUniform;
  private static boolean failed;
  private static int actualMode;
  private static String diagnostic = "Filtro linear compatível.";

  private NVVisionBoostSpatialUpscaler() {}

  public static String modeName(int mode) {
    return switch (mode) {
      case 1 -> "Linear + nitidez";
      case 2 -> "Bicúbico + nitidez";
      case 3 -> "Automático por custo GPU";
      case 4 -> "FSR 1: EASU + RCAS";
      default -> "Linear compatível";
    };
  }

  public static String status() {
    return modeName(actualMode) + " | " + diagnostic;
  }

  static boolean render(
      int texture,
      int framebuffer,
      int inputWidth,
      int inputHeight,
      int outputWidth,
      int outputHeight,
      int requestedMode,
      int sharpnessPercent,
      int targetFps) {
    int mode = Math.max(0, Math.min(4, requestedMode));
    if (mode == 3) {
      if (NVVisionBoostFrameTiming.gpuSampleFresh()) {
        BUDGET.observe(
            NVVisionBoostFrameTiming.upscaleMs(),
            NVVisionBoostFrameTiming.gpuMs(),
            NVVisionBoostFrameTiming.frameMs(),
            targetFps,
            System.nanoTime() / 1_000_000);
      }
      mode = BUDGET.mode();
    }
    actualMode = 0;
    if (mode != 4) NVVisionBoostFsr1Upscaler.releaseTarget();
    if (mode == 0) {
      diagnostic = "Blit sem passe adicional.";
      return false;
    }
    if (failed) return false;
    if (!GL.getCapabilities().OpenGL33 && !GL.getCapabilities().GL_ARB_sampler_objects) {
      diagnostic = "Sampler objects indisponíveis; fallback linear.";
      return false;
    }
    STATE.capture();
    try {
      initialize();
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, framebuffer);
      GL11.glViewport(0, 0, outputWidth, outputHeight);
      GL11.glDisable(GL11.GL_DEPTH_TEST);
      GL11.glDepthMask(false);
      GL11.glDisable(GL11.GL_BLEND);
      GL11.glDisable(GL11.GL_CULL_FACE);
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL11.glDisable(GL11.GL_STENCIL_TEST);
      GL11.glDisable(GL11.GL_COLOR_LOGIC_OP);
      GL11.glDisable(GL30.GL_RASTERIZER_DISCARD);
      STATE.disableClipPlanes();
      STATE.disablePixelUnpack();
      GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
      GL11.glColorMask(true, true, true, true);
      MinecraftGlStateAdapter.useProgram(program);
      GL30.glBindVertexArray(vao);
      MinecraftGlStateAdapter.activeTexture(GL13.GL_TEXTURE0);
      MinecraftGlStateAdapter.bindTexture(
          GL11.GL_TEXTURE_2D, texture == 0 || GL11.glIsTexture(texture) ? texture : 0);
      GL33.glBindSampler(0, sampler);
      String fallback = "";
      if (mode == 4) {
        if (NVVisionBoostFsr1Upscaler.render(
            texture,
            framebuffer,
            inputWidth,
            inputHeight,
            outputWidth,
            outputHeight,
            sharpnessPercent)) {
          actualMode = 4;
          diagnostic = NVVisionBoostFsr1Upscaler.status();
          return true;
        }
        fallback = NVVisionBoostFsr1Upscaler.status() + " | ";
        mode = 2;
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, framebuffer);
        MinecraftGlStateAdapter.useProgram(program);
        MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, texture);
      }
      GL20.glUniform2f(sizeUniform, inputWidth, inputHeight);
      GL20.glUniform1f(sharpnessUniform, Math.max(0, Math.min(100, sharpnessPercent)) / 100.0f);
      GL20.glUniform1i(modeUniform, mode);
      GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
      actualMode = mode;
      diagnostic = fallback + "Passe espacial ativo; HUD em resolução nativa.";
      return true;
    } catch (IOException | RuntimeException error) {
      failed = true;
      diagnostic = "Fallback linear: " + error.getMessage();
      NVVisionBoostForge.log("Upscaler: " + diagnostic);
      return false;
    } finally {
      STATE.restore();
    }
  }

  private static void initialize() throws IOException {
    if (program != 0) return;
    int vertex = 0, fragment = 0, linked = 0;
    try {
      vertex = compile(GL20.GL_VERTEX_SHADER, "upscale.vert");
      fragment = compile(GL20.GL_FRAGMENT_SHADER, "upscale.frag");
      linked = GL20.glCreateProgram();
      GL20.glAttachShader(linked, vertex);
      GL20.glAttachShader(linked, fragment);
      GL30.glBindFragDataLocation(linked, 0, "FragColor");
      GL20.glLinkProgram(linked);
      if (GL20.glGetProgrami(linked, GL20.GL_LINK_STATUS) == GL11.GL_FALSE)
        throw new IOException(GL20.glGetProgramInfoLog(linked));
      sizeUniform = GL20.glGetUniformLocation(linked, "SourceSize");
      sharpnessUniform = GL20.glGetUniformLocation(linked, "Sharpness");
      modeUniform = GL20.glGetUniformLocation(linked, "Mode");
      MinecraftGlStateAdapter.useProgram(linked);
      GL20.glUniform1i(GL20.glGetUniformLocation(linked, "Source"), 0);
      vao = GL30.glGenVertexArrays();
      sampler = GL33.glGenSamplers();
      if (vao == 0 || sampler == 0) throw new IOException("Falha ao alocar objetos GPU do filtro.");
      GL33.glSamplerParameteri(sampler, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
      GL33.glSamplerParameteri(sampler, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
      GL33.glSamplerParameteri(sampler, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
      GL33.glSamplerParameteri(sampler, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
      GL33.glSamplerParameterf(sampler, GL12.GL_TEXTURE_MIN_LOD, 0);
      GL33.glSamplerParameterf(sampler, GL12.GL_TEXTURE_MAX_LOD, 0);
      program = linked;
      linked = 0;
    } finally {
      if (vertex != 0) GL20.glDeleteShader(vertex);
      if (fragment != 0) GL20.glDeleteShader(fragment);
      if (linked != 0) GL20.glDeleteProgram(linked);
    }
  }

  static String shaderSource(String name) throws IOException {
    String source;
    try (var stream =
        NVVisionBoostSpatialUpscaler.class.getResourceAsStream(
            "/assets/nvvisionboost/shaders/" + name)) {
      if (stream == null) throw new IOException("Shader interno ausente: " + name);
      source = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    }
    return source;
  }

  private static int compile(int type, String name) throws IOException {
    return compileSource(type, shaderSource(name));
  }

  static int compileSource(int type, String source) throws IOException {
    int shader = GL20.glCreateShader(type);
    GL20.glShaderSource(shader, source);
    GL20.glCompileShader(shader);
    if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
      String log = GL20.glGetShaderInfoLog(shader);
      GL20.glDeleteShader(shader);
      throw new IOException(log);
    }
    return shader;
  }

  public static void close() {
    NVVisionBoostFsr1Upscaler.close();
    if (program != 0) GL20.glDeleteProgram(program);
    if (vao != 0) GL30.glDeleteVertexArrays(vao);
    if (sampler != 0) GL33.glDeleteSamplers(sampler);
    program = vao = sampler = actualMode = 0;
    failed = false;
    BUDGET.reset();
    diagnostic = "Filtro linear compatível.";
  }

  /** Restore actual bindings and states without modifying RenderSystem caches. */
  private static final class State {
    private final int[] viewport = new int[4], polygon = new int[2];
    private final ByteBuffer colorMask = BufferUtils.createByteBuffer(4);
    private int drawFramebuffer, activeTexture, texture, sampler, program, vao, pixelUnpack;
    private boolean depth, depthWrite, blend, cull, scissor, stencil, logic, discard;
    private boolean[] clip;

    void capture() {
      drawFramebuffer = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
      activeTexture = GL11.glGetInteger(GL13.GL_ACTIVE_TEXTURE);
      program = GL11.glGetInteger(GL20.GL_CURRENT_PROGRAM);
      vao = GL11.glGetInteger(GL30.GL_VERTEX_ARRAY_BINDING);
      pixelUnpack = GL11.glGetInteger(GL21.GL_PIXEL_UNPACK_BUFFER_BINDING);
      GL11.glGetIntegerv(GL11.GL_VIEWPORT, viewport);
      GL11.glGetIntegerv(GL11.GL_POLYGON_MODE, polygon);
      colorMask.clear();
      GL11.glGetBooleanv(GL11.GL_COLOR_WRITEMASK, colorMask);
      depth = GL11.glIsEnabled(GL11.GL_DEPTH_TEST);
      depthWrite = GL11.glGetBoolean(GL11.GL_DEPTH_WRITEMASK);
      blend = GL11.glIsEnabled(GL11.GL_BLEND);
      cull = GL11.glIsEnabled(GL11.GL_CULL_FACE);
      scissor = GL11.glIsEnabled(GL11.GL_SCISSOR_TEST);
      stencil = GL11.glIsEnabled(GL11.GL_STENCIL_TEST);
      logic = GL11.glIsEnabled(GL11.GL_COLOR_LOGIC_OP);
      discard = GL11.glIsEnabled(GL30.GL_RASTERIZER_DISCARD);
      if (clip == null) clip = new boolean[GL11.glGetInteger(GL30.GL_MAX_CLIP_DISTANCES)];
      for (int i = 0; i < clip.length; i++) clip[i] = GL11.glIsEnabled(GL30.GL_CLIP_DISTANCE0 + i);
      MinecraftGlStateAdapter.activeTexture(GL13.GL_TEXTURE0);
      texture = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
      sampler = GL11.glGetInteger(GL33.GL_SAMPLER_BINDING);
      MinecraftGlStateAdapter.activeTexture(activeTexture);
    }

    void restore() {
      MinecraftGlStateAdapter.useProgram(program);
      GL30.glBindVertexArray(vao);
      MinecraftGlStateAdapter.activeTexture(GL13.GL_TEXTURE0);
      MinecraftGlStateAdapter.bindTexture(
          GL11.GL_TEXTURE_2D, texture == 0 || GL11.glIsTexture(texture) ? texture : 0);
      GL33.glBindSampler(0, sampler);
      if (pixelUnpack != 0) GL15.glBindBuffer(GL21.GL_PIXEL_UNPACK_BUFFER, pixelUnpack);
      MinecraftGlStateAdapter.activeTexture(activeTexture);
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, drawFramebuffer);
      GL11.glViewport(viewport[0], viewport[1], viewport[2], viewport[3]);
      if (polygon[0] != GL11.GL_FILL) GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, polygon[0]);
      GL11.glColorMask(
          colorMask.get(0) != 0,
          colorMask.get(1) != 0,
          colorMask.get(2) != 0,
          colorMask.get(3) != 0);
      if (depthWrite) GL11.glDepthMask(true);
      set(GL11.GL_DEPTH_TEST, depth);
      set(GL11.GL_BLEND, blend);
      set(GL11.GL_CULL_FACE, cull);
      set(GL11.GL_SCISSOR_TEST, scissor);
      set(GL11.GL_STENCIL_TEST, stencil);
      set(GL11.GL_COLOR_LOGIC_OP, logic);
      set(GL30.GL_RASTERIZER_DISCARD, discard);
      for (int i = 0; i < clip.length; i++) set(GL30.GL_CLIP_DISTANCE0 + i, clip[i]);
    }

    void disableClipPlanes() {
      for (int i = 0; i < clip.length; i++) if (clip[i]) GL11.glDisable(GL30.GL_CLIP_DISTANCE0 + i);
    }

    void disablePixelUnpack() {
      if (pixelUnpack != 0) GL15.glBindBuffer(GL21.GL_PIXEL_UNPACK_BUFFER, 0);
    }

    private static void set(int flag, boolean enabled) {
      if (enabled) GL11.glEnable(flag);
    }
  }
}
