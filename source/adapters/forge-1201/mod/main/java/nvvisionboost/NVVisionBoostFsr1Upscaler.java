package nvvisionboost;

import java.io.IOException;
import java.nio.ByteBuffer;
import nvvisionboost.rendering.MinecraftGlStateAdapter;
import org.lwjgl.opengl.*;

/** Integrate official FSR 1.0.2 FP32 kernels; SpatialUpscaler owns the external-state guard. */
final class NVVisionBoostFsr1Upscaler {
  private static int easu,
      rcas,
      intermediateTexture,
      intermediateFbo,
      allocatedWidth,
      allocatedHeight;
  private static int con0, con1, con2, con3, sharpness, sourceSize;
  private static int lastInputWidth, lastInputHeight, lastOutputWidth, lastOutputHeight;
  private static boolean failed;
  private static String status = "FSR 1 ainda não preparado.";

  private NVVisionBoostFsr1Upscaler() {}

  static String status() {
    return status;
  }

  static boolean supported() {
    var c = GL.getCapabilities();
    return (c.OpenGL40
            || (c.GL_ARB_texture_gather && c.GL_ARB_gpu_shader5 && c.GL_ARB_shader_bit_encoding))
        && (c.OpenGL42 || c.GL_ARB_shading_language_packing);
  }

  static boolean render(
      int texture,
      int destination,
      int width,
      int height,
      int outputWidth,
      int outputHeight,
      int sharpnessPercent) {
    if (width * 2 < outputWidth || height * 2 < outputHeight) {
      releaseTarget();
      status = "Escala abaixo de 50%; fallback bicúbico.";
      return false;
    }
    if (!supported()) {
      status = "Extensões FSR 1 indisponíveis; fallback bicúbico.";
      return false;
    }
    if (failed) return false;
    try {
      initialize();
      boolean sharpen = sharpnessPercent > 0;
      if (sharpen) ensureTarget(outputWidth, outputHeight);
      else releaseTarget();
      MinecraftGlStateAdapter.bindFramebuffer(
          GL30.GL_DRAW_FRAMEBUFFER, sharpen ? intermediateFbo : destination);
      GL11.glViewport(0, 0, outputWidth, outputHeight);
      MinecraftGlStateAdapter.useProgram(easu);
      MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, texture);
      configureEasu(width, height, outputWidth, outputHeight);
      GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
      if (sharpen) {
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, destination);
        MinecraftGlStateAdapter.useProgram(rcas);
        MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, intermediateTexture);
        GL20.glUniform2f(sourceSize, outputWidth, outputHeight);
        float strength = (float) Math.pow(2, -2 * (1 - Math.min(100, sharpnessPercent) / 100.0));
        GL20.glUniform1f(sharpness, strength);
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
      }
      status =
          sharpen ? "EASU + RCAS FP32 oficiais ativos." : "EASU oficial ativo; nitidez desligada.";
      return true;
    } catch (IOException | RuntimeException error) {
      failed = true;
      status = "FSR 1 falhou; fallback bicúbico: " + error.getMessage();
      releaseTarget();
      NVVisionBoostForge.log(status);
      return false;
    }
  }

  private static void initialize() throws IOException {
    if (easu != 0 && rcas != 0) return;
    String common =
        "#version 150\n"
            + "#extension GL_ARB_texture_gather : require\n"
            + "#extension GL_ARB_gpu_shader5 : require\n"
            + "#extension GL_ARB_shader_bit_encoding : require\n"
            + "#extension GL_ARB_shading_language_packing : require\n"
            + "#define A_GPU 1\n#define A_GLSL 1\n";
    String math = NVVisionBoostSpatialUpscaler.shaderSource("fsr1/ffx_a.h");
    String kernel = NVVisionBoostSpatialUpscaler.shaderSource("fsr1/ffx_fsr1.h");
    easu =
        link(
            common
                + "#define FSR_EASU_F 1\n"
                + math
                + "\n"
                + "uniform sampler2D Source;\nin vec2 TexCoord;\nout vec4 FragColor;\n"
                + "uniform uvec4 Con0, Con1, Con2, Con3;\n"
                + "vec4 FsrEasuRF(vec2 p) { return textureGather(Source,p,0); }\n"
                + "vec4 FsrEasuGF(vec2 p) { return textureGather(Source,p,1); }\n"
                + "vec4 FsrEasuBF(vec2 p) { return textureGather(Source,p,2); }\n"
                + kernel
                + "\n"
                + "void main() { vec3 rgb;"
                + " FsrEasuF(rgb,uvec2(gl_FragCoord.xy),Con0,Con1,Con2,Con3);"
                + " if(any(isnan(rgb))||any(isinf(rgb))) rgb=texture(Source,TexCoord).rgb;"
                + " FragColor=vec4(clamp(rgb,0.0,1.0),texture(Source,TexCoord).a); }\n");
    con0 = GL20.glGetUniformLocation(easu, "Con0");
    con1 = GL20.glGetUniformLocation(easu, "Con1");
    con2 = GL20.glGetUniformLocation(easu, "Con2");
    con3 = GL20.glGetUniformLocation(easu, "Con3");
    rcas =
        link(
            common
                + "#define FSR_RCAS_F 1\n"
                + "#define FSR_RCAS_DENOISE 1\n"
                + "#define FSR_RCAS_PASSTHROUGH_ALPHA 1\n"
                + math
                + "\n"
                + "uniform sampler2D Source;\n"
                + "uniform vec2 SourceSize;\n"
                + "uniform float Sharpness;\n"
                + "out vec4 FragColor;\n"
                + "vec4 FsrRcasLoadF(ivec2 p) { return"
                + " texelFetch(Source,clamp(p,ivec2(0),ivec2(SourceSize)-1),0); }\n"
                + "void FsrRcasInputF(inout float r,inout float g,inout float b) {}\n"
                + kernel
                + "\n"
                + "void main() { vec4 value; uvec4 con=uvec4(floatBitsToUint(Sharpness),0u,0u,0u);"
                + " FsrRcasF(value.r,value.g,value.b,value.a,uvec2(gl_FragCoord.xy),con);"
                + " if(any(isnan(value.rgb))||any(isinf(value.rgb)))"
                + " value=FsrRcasLoadF(ivec2(gl_FragCoord.xy));"
                + " FragColor=vec4(clamp(value.rgb,0.0,1.0),value.a); }\n");
    sharpness = GL20.glGetUniformLocation(rcas, "Sharpness");
    sourceSize = GL20.glGetUniformLocation(rcas, "SourceSize");
  }

  private static int link(String fragmentSource) throws IOException {
    int vertex = 0, fragment = 0, linked = 0;
    try {
      vertex =
          NVVisionBoostSpatialUpscaler.compileSource(
              GL20.GL_VERTEX_SHADER, NVVisionBoostSpatialUpscaler.shaderSource("upscale.vert"));
      fragment =
          NVVisionBoostSpatialUpscaler.compileSource(GL20.GL_FRAGMENT_SHADER, fragmentSource);
      linked = GL20.glCreateProgram();
      GL20.glAttachShader(linked, vertex);
      GL20.glAttachShader(linked, fragment);
      GL30.glBindFragDataLocation(linked, 0, "FragColor");
      GL20.glLinkProgram(linked);
      if (GL20.glGetProgrami(linked, GL20.GL_LINK_STATUS) == GL11.GL_FALSE)
        throw new IOException(GL20.glGetProgramInfoLog(linked));
      MinecraftGlStateAdapter.useProgram(linked);
      GL20.glUniform1i(GL20.glGetUniformLocation(linked, "Source"), 0);
      int result = linked;
      linked = 0;
      return result;
    } finally {
      if (vertex != 0) GL20.glDeleteShader(vertex);
      if (fragment != 0) GL20.glDeleteShader(fragment);
      if (linked != 0) GL20.glDeleteProgram(linked);
    }
  }

  /** Compute FsrEasuCon constants on the CPU only when dimensions change. */
  private static void configureEasu(int width, int height, int outputWidth, int outputHeight) {
    if (width == lastInputWidth
        && height == lastInputHeight
        && outputWidth == lastOutputWidth
        && outputHeight == lastOutputHeight) return;
    float ratioX = (float) width / outputWidth, ratioY = (float) height / outputHeight;
    float pixelX = 1f / width, pixelY = 1f / height;
    uniform(con0, ratioX, ratioY, .5f * ratioX - .5f, .5f * ratioY - .5f);
    uniform(con1, pixelX, pixelY, pixelX, -pixelY);
    uniform(con2, -pixelX, 2 * pixelY, pixelX, 2 * pixelY);
    uniform(con3, 0, 4 * pixelY, 0, 0);
    lastInputWidth = width;
    lastInputHeight = height;
    lastOutputWidth = outputWidth;
    lastOutputHeight = outputHeight;
  }

  private static void uniform(int location, float x, float y, float z, float w) {
    GL30.glUniform4ui(
        location,
        Float.floatToRawIntBits(x),
        Float.floatToRawIntBits(y),
        Float.floatToRawIntBits(z),
        Float.floatToRawIntBits(w));
  }

  private static void ensureTarget(int width, int height) {
    if (intermediateFbo != 0 && allocatedWidth == width && allocatedHeight == height) return;
    releaseTarget();
    intermediateTexture = GL11.glGenTextures();
    if (intermediateTexture == 0) throw new IllegalStateException("Sem textura para RCAS.");
    MinecraftGlStateAdapter.bindTexture(GL11.GL_TEXTURE_2D, intermediateTexture);
    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
    GL11.glTexImage2D(
        GL11.GL_TEXTURE_2D,
        0,
        GL11.GL_RGBA8,
        width,
        height,
        0,
        GL11.GL_RGBA,
        GL11.GL_UNSIGNED_BYTE,
        (ByteBuffer) null);
    intermediateFbo = GL30.glGenFramebuffers();
    if (intermediateFbo == 0) throw new IllegalStateException("Sem framebuffer para RCAS.");
    MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, intermediateFbo);
    GL30.glFramebufferTexture2D(
        GL30.GL_DRAW_FRAMEBUFFER,
        GL30.GL_COLOR_ATTACHMENT0,
        GL11.GL_TEXTURE_2D,
        intermediateTexture,
        0);
    if (GL30.glCheckFramebufferStatus(GL30.GL_DRAW_FRAMEBUFFER) != GL30.GL_FRAMEBUFFER_COMPLETE)
      throw new IllegalStateException("Framebuffer RCAS incompleto.");
    allocatedWidth = width;
    allocatedHeight = height;
  }

  static void releaseTarget() {
    if (intermediateFbo != 0) MinecraftGlStateAdapter.deleteFramebuffer(intermediateFbo);
    if (intermediateTexture != 0) MinecraftGlStateAdapter.deleteTexture(intermediateTexture);
    intermediateFbo = intermediateTexture = allocatedWidth = allocatedHeight = 0;
  }

  static void close() {
    releaseTarget();
    if (easu != 0) GL20.glDeleteProgram(easu);
    if (rcas != 0) GL20.glDeleteProgram(rcas);
    easu = rcas = 0;
    lastInputWidth = lastInputHeight = lastOutputWidth = lastOutputHeight = 0;
    failed = false;
    status = "FSR 1 ainda não preparado.";
  }
}
