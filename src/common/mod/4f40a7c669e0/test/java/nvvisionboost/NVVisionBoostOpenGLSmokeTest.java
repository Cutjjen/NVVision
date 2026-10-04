/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.*;

/** Teste opcional com janela invisível; não inicializa Minecraft nem exige shaderpack. */
public final class NVVisionBoostOpenGLSmokeTest {
  private static int checks;
  private static final int OUTPUT = 64;

  private static void check(boolean condition, String name) {
    if (!condition) throw new AssertionError(name + " | " + NVVisionBoostSpatialUpscaler.status());
    checks++;
  }

  public static void main(String[] args) {
    var callback = GLFWErrorCallback.createPrint(System.err);
    callback.set();
    long window = 0;
    try {
      if (!GLFW.glfwInit()) throw new IllegalStateException("GLFW/contexto gráfico indisponível.");
      GLFW.glfwDefaultWindowHints();
      GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
      GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
      GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
      GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
      GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
      GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
      window = GLFW.glfwCreateWindow(OUTPUT, OUTPUT, "NVVisionBoost smoke test", 0, 0);
      if (window == 0)
        throw new IllegalStateException("Não foi possível criar contexto OpenGL 3.2.");
      GLFW.glfwMakeContextCurrent(window);
      GL.createCapabilities();
      System.out.println(
          "GL: "
              + GL11.glGetString(GL11.GL_VENDOR)
              + " | "
              + GL11.glGetString(GL11.GL_RENDERER)
              + " | "
              + GL11.glGetString(GL11.GL_VERSION));
      runFilters();
      runFsr();
      check(GL11.glGetError() == GL11.GL_NO_ERROR, "nenhum erro OpenGL nos testes");
      System.out.println(
          "PASS GL: " + checks + " verificações com contexto real e janela invisível.");
    } finally {
      if (window != 0) {
        NVVisionBoostSpatialUpscaler.close();
        GLFW.glfwMakeContextCurrent(0);
        GLFW.glfwDestroyWindow(window);
      }
      GLFW.glfwTerminate();
      callback.free();
    }
  }

  private static void runFilters() {
    int input = texture(16, 16, false), output = texture(OUTPUT, OUTPUT, true);
    int framebuffer = framebuffer(output);
    ByteBuffer flat = BufferUtils.createByteBuffer(16 * 16 * 4);
    for (int i = 0; i < 16 * 16; i++)
      flat.put((byte) 64).put((byte) 128).put((byte) 192).put((byte) 153);
    flat.flip();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, input);
    GL11.glTexSubImage2D(
        GL11.GL_TEXTURE_2D, 0, 0, 0, 16, 16, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, flat);
    for (int mode = 1; mode <= 2; mode++) {
      check(
          NVVisionBoostSpatialUpscaler.render(
              input, framebuffer, 16, 16, OUTPUT, OUTPUT, mode, 100, 60),
          "filtro compila e desenha em modo " + mode);
      var pixels = read(framebuffer);
      boolean preserved = true;
      float[] expected = {64f / 255, 128f / 255, 192f / 255, 153f / 255};
      for (int i = 0; i < pixels.capacity(); i++)
        if (!Float.isFinite(pixels.get(i)) || Math.abs(pixels.get(i) - expected[i % 4]) > .003)
          preserved = false;
      check(preserved, "cor uniforme e alpha preservados com nitidez máxima em modo " + mode);
    }
    ByteBuffer gradient = BufferUtils.createByteBuffer(16 * 16 * 4);
    for (int y = 0; y < 16; y++)
      for (int x = 0; x < 16; x++)
        gradient
            .put((byte) (x * 17))
            .put((byte) (y * 17))
            .put((byte) ((x < 8) ? 0 : 255))
            .put((byte) 255);
    gradient.flip();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, input);
    GL11.glTexSubImage2D(
        GL11.GL_TEXTURE_2D, 0, 0, 0, 16, 16, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, gradient);
    for (int mode = 1; mode <= 2; mode++) {
      NVVisionBoostSpatialUpscaler.render(
          input, framebuffer, 16, 16, OUTPUT, OUTPUT, mode, 100, 60);
      var pixels = read(framebuffer);
      boolean bounded = true;
      for (int i = 0; i < pixels.capacity(); i++)
        if (!Float.isFinite(pixels.get(i)) || pixels.get(i) < -.001 || pixels.get(i) > 1.001)
          bounded = false;
      check(bounded, "gradientes/bordas não produzem NaN ou overshoot em modo " + mode);
      check(
          pixels.get(0) < .05 && pixels.get((OUTPUT - 1) * 4) > .95,
          "orientação horizontal preservada");
      check(
          pixels.get(1) < .05 && pixels.get(((OUTPUT - 1) * OUTPUT) * 4 + 1) > .95,
          "orientação vertical preservada");
    }
    stateIsolation(input, framebuffer, 16, 2);
    check(
        !NVVisionBoostSpatialUpscaler.render(
            input, framebuffer, 16, 16, OUTPUT, OUTPUT, 0, 100, 60),
        "modo linear retorna ao blit compatível");
    NVVisionBoostSpatialUpscaler.close();
    check(
        NVVisionBoostSpatialUpscaler.render(input, framebuffer, 16, 16, OUTPUT, OUTPUT, 2, 40, 60),
        "recursos são recriados corretamente após close");
    GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
    GL30.glDeleteFramebuffers(framebuffer);
    GL11.glDeleteTextures(input);
    GL11.glDeleteTextures(output);
  }

  private static void stateIsolation(int input, int framebuffer, int inputSize, int mode) {
    int foreignVao = GL30.glGenVertexArrays(), foreignTexture = texture(2, 2, false);
    int foreignSampler = GL33.glGenSamplers();
    int foreignProgram = foreignProgram();
    int foreignPbo = GL15.glGenBuffers();
    GL15.glBindBuffer(GL21.GL_PIXEL_UNPACK_BUFFER, foreignPbo);
    GL15.glBufferData(GL21.GL_PIXEL_UNPACK_BUFFER, 16L, GL15.GL_STATIC_DRAW);
    if (mode == 4) NVVisionBoostFsr1Upscaler.releaseTarget();
    GL20.glUseProgram(foreignProgram);
    GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, 0);
    GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, framebuffer);
    GL30.glBindVertexArray(foreignVao);
    GL13.glActiveTexture(GL13.GL_TEXTURE0);
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, foreignTexture);
    GL33.glBindSampler(0, foreignSampler);
    GL13.glActiveTexture(GL13.GL_TEXTURE3);
    GL11.glViewport(3, 5, 17, 19);
    GL11.glEnable(GL11.GL_SCISSOR_TEST);
    GL11.glEnable(GL11.GL_DEPTH_TEST);
    GL11.glDepthMask(true);
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glEnable(GL11.GL_CULL_FACE);
    GL11.glEnable(GL11.GL_STENCIL_TEST);
    GL11.glEnable(GL11.GL_COLOR_LOGIC_OP);
    GL11.glEnable(GL30.GL_RASTERIZER_DISCARD);
    GL11.glEnable(GL30.GL_CLIP_DISTANCE0);
    GL11.glEnable(GL30.GL_FRAMEBUFFER_SRGB);
    GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
    GL11.glColorMask(false, true, false, true);
    check(
        NVVisionBoostSpatialUpscaler.render(
            input, framebuffer, inputSize, inputSize, OUTPUT, OUTPUT, mode, 55, 60),
        "filtro funciona com estados externos adversos");
    check(
        GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == 0
            && GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING) == framebuffer,
        "FBOs externos restaurados");
    check(GL11.glGetInteger(GL30.GL_VERTEX_ARRAY_BINDING) == foreignVao, "VAO externo restaurado");
    check(
        GL11.glGetInteger(GL20.GL_CURRENT_PROGRAM) == foreignProgram,
        "programa externo restaurado sem alterar seu cache");
    check(
        GL11.glGetInteger(GL21.GL_PIXEL_UNPACK_BUFFER_BINDING) == foreignPbo,
        "buffer externo de uploads restaurado após alocação/draw");
    check(
        GL11.glGetInteger(GL13.GL_ACTIVE_TEXTURE) == GL13.GL_TEXTURE3, "unidade ativa restaurada");
    GL13.glActiveTexture(GL13.GL_TEXTURE0);
    check(
        GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D) == foreignTexture
            && GL11.glGetInteger(GL33.GL_SAMPLER_BINDING) == foreignSampler,
        "textura e sampler externos restaurados");
    int[] viewport = new int[4];
    GL11.glGetIntegerv(GL11.GL_VIEWPORT, viewport);
    check(
        java.util.Arrays.equals(viewport, new int[] {3, 5, 17, 19}), "viewport externo restaurado");
    ByteBuffer mask = BufferUtils.createByteBuffer(4);
    GL11.glGetBooleanv(GL11.GL_COLOR_WRITEMASK, mask);
    check(
        mask.get(0) == 0 && mask.get(1) != 0 && mask.get(2) == 0 && mask.get(3) != 0,
        "máscara de cores restaurada");
    check(
        GL11.glIsEnabled(GL11.GL_DEPTH_TEST)
            && GL11.glGetBoolean(GL11.GL_DEPTH_WRITEMASK)
            && GL11.glIsEnabled(GL11.GL_BLEND)
            && GL11.glIsEnabled(GL11.GL_CULL_FACE)
            && GL11.glIsEnabled(GL11.GL_SCISSOR_TEST)
            && GL11.glIsEnabled(GL11.GL_STENCIL_TEST)
            && GL11.glIsEnabled(GL11.GL_COLOR_LOGIC_OP)
            && GL11.glIsEnabled(GL30.GL_RASTERIZER_DISCARD)
            && GL11.glIsEnabled(GL30.GL_CLIP_DISTANCE0)
            && GL11.glIsEnabled(GL30.GL_FRAMEBUFFER_SRGB),
        "estados de passes externos restaurados");
    int[] polygon = new int[2];
    GL11.glGetIntegerv(GL11.GL_POLYGON_MODE, polygon);
    check(polygon[0] == GL11.GL_LINE, "modo de polígonos restaurado");
    GL11.glDisable(GL11.GL_DEPTH_TEST);
    GL11.glDisable(GL11.GL_BLEND);
    GL11.glDisable(GL11.GL_CULL_FACE);
    GL11.glDisable(GL11.GL_SCISSOR_TEST);
    GL11.glDisable(GL11.GL_STENCIL_TEST);
    GL11.glDisable(GL11.GL_COLOR_LOGIC_OP);
    GL11.glDisable(GL30.GL_RASTERIZER_DISCARD);
    GL11.glDisable(GL30.GL_CLIP_DISTANCE0);
    GL11.glDisable(GL30.GL_FRAMEBUFFER_SRGB);
    GL11.glColorMask(true, true, true, true);
    GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
    GL30.glBindVertexArray(0);
    GL33.glBindSampler(0, 0);
    GL30.glDeleteVertexArrays(foreignVao);
    GL20.glUseProgram(0);
    GL20.glDeleteProgram(foreignProgram);
    GL15.glBindBuffer(GL21.GL_PIXEL_UNPACK_BUFFER, 0);
    GL15.glDeleteBuffers(foreignPbo);
    GL33.glDeleteSamplers(foreignSampler);
    GL11.glDeleteTextures(foreignTexture);
  }

  private static int foreignProgram() {
    try {
      int vertex =
          NVVisionBoostSpatialUpscaler.compileSource(
              GL20.GL_VERTEX_SHADER, "#version 150\nvoid main(){gl_Position=vec4(0,0,0,1);}");
      int fragment =
          NVVisionBoostSpatialUpscaler.compileSource(
              GL20.GL_FRAGMENT_SHADER,
              "#version 150\nout vec4 OtherColor; void main(){OtherColor=vec4(1);}");
      int program = GL20.glCreateProgram();
      GL20.glAttachShader(program, vertex);
      GL20.glAttachShader(program, fragment);
      GL30.glBindFragDataLocation(program, 0, "OtherColor");
      GL20.glLinkProgram(program);
      GL20.glDeleteShader(vertex);
      GL20.glDeleteShader(fragment);
      check(
          GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) != 0,
          "programa sentinela externo válido");
      return program;
    } catch (java.io.IOException error) {
      throw new IllegalStateException(error);
    }
  }

  private static void runFsr() {
    int input = texture(32, 32, false), output = texture(OUTPUT, OUTPUT, true);
    int framebuffer = framebuffer(output);
    boolean supported = NVVisionBoostFsr1Upscaler.supported();
    System.out.println("FSR 1 extensões: " + supported);
    for (int sharpness : new int[] {0, 55, 100}) {
      ByteBuffer flat = BufferUtils.createByteBuffer(32 * 32 * 4);
      for (int i = 0; i < 32 * 32; i++)
        flat.put((byte) 64).put((byte) 128).put((byte) 192).put((byte) 153);
      flat.flip();
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, input);
      GL11.glTexSubImage2D(
          GL11.GL_TEXTURE_2D, 0, 0, 0, 32, 32, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, flat);
      check(
          NVVisionBoostSpatialUpscaler.render(
              input, framebuffer, 32, 32, OUTPUT, OUTPUT, 4, sharpness, 60),
          "FSR/fallback desenha com nitidez " + sharpness);
      check(
          !supported || NVVisionBoostSpatialUpscaler.status().startsWith("FSR 1:"),
          "kernels oficiais executados quando há suporte");
      var pixels = read(framebuffer);
      float[] expected = {64f / 255, 128f / 255, 192f / 255, 153f / 255};
      boolean correct = true;
      for (int i = 0; i < pixels.capacity(); i++)
        if (!Float.isFinite(pixels.get(i)) || Math.abs(pixels.get(i) - expected[i % 4]) > .008)
          correct = false;
      check(correct, "FSR preserva cor uniforme e alpha em EASU/RCAS");
    }
    ByteBuffer gradient = BufferUtils.createByteBuffer(32 * 32 * 4);
    for (int y = 0; y < 32; y++)
      for (int x = 0; x < 32; x++)
        gradient
            .put((byte) (x * 255 / 31))
            .put((byte) (y * 255 / 31))
            .put((byte) (x < 16 ? 0 : 255))
            .put((byte) 255);
    gradient.flip();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, input);
    GL11.glTexSubImage2D(
        GL11.GL_TEXTURE_2D, 0, 0, 0, 32, 32, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, gradient);
    NVVisionBoostSpatialUpscaler.render(input, framebuffer, 32, 32, OUTPUT, OUTPUT, 4, 100, 60);
    var pixels = read(framebuffer);
    boolean bounded = true;
    for (int i = 0; i < pixels.capacity(); i++)
      if (!Float.isFinite(pixels.get(i)) || pixels.get(i) < -.001 || pixels.get(i) > 1.001)
        bounded = false;
    check(bounded, "FSR bordas/gradientes finitos e limitados");
    check(
        pixels.get(0) < .05
            && pixels.get((OUTPUT - 1) * 4) > .95
            && pixels.get(1) < .05
            && pixels.get(((OUTPUT - 1) * OUTPUT) * 4 + 1) > .95,
        "FSR preserva orientação e alcance dos gradientes");
    check(
        NVVisionBoostSpatialUpscaler.render(input, framebuffer, 16, 16, OUTPUT, OUTPUT, 4, 55, 60)
            && NVVisionBoostSpatialUpscaler.status().contains("abaixo de 50"),
        "FSR fora de faixa volta ao bicúbico");
    stateIsolation(input, framebuffer, 32, 4);
    GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
    GL30.glDeleteFramebuffers(framebuffer);
    GL11.glDeleteTextures(input);
    GL11.glDeleteTextures(output);
    NVVisionBoostSpatialUpscaler.close();
  }

  /** Reproduces the Oculus packed-stencil -> depth-only transition from the modpack. */
  private static int texture(int width, int height, boolean floating) {
    int texture = GL11.glGenTextures();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
    GL11.glTexImage2D(
        GL11.GL_TEXTURE_2D,
        0,
        floating ? GL30.GL_RGBA32F : GL11.GL_RGBA8,
        width,
        height,
        0,
        GL11.GL_RGBA,
        GL11.GL_UNSIGNED_BYTE,
        (ByteBuffer) null);
    return texture;
  }

  private static int framebuffer(int texture) {
    int fbo = GL30.glGenFramebuffers();
    GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
    GL30.glFramebufferTexture2D(
        GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL11.GL_TEXTURE_2D, texture, 0);
    check(
        GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) == GL30.GL_FRAMEBUFFER_COMPLETE,
        "FBO de teste completo");
    return fbo;
  }

  private static java.nio.FloatBuffer read(int framebuffer) {
    var pixels = BufferUtils.createFloatBuffer(OUTPUT * OUTPUT * 4);
    GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, framebuffer);
    GL11.glReadPixels(0, 0, OUTPUT, OUTPUT, GL11.GL_RGBA, GL11.GL_FLOAT, pixels);
    return pixels;
  }
}
