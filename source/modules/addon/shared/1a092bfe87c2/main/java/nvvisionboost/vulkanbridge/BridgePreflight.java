package nvvisionboost.vulkanbridge;

import java.nio.*;
import java.nio.file.*;
import java.util.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

/** Isolated child JVM test. A failure cannot contaminate the Minecraft JVM. */
public final class BridgePreflight {
  private static int compile(int type, String source) {
    int shader = GL20.glCreateShader(type);
    GL20.glShaderSource(shader, source);
    GL20.glCompileShader(shader);
    if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0) {
      String error = GL20.glGetShaderInfoLog(shader);
      GL20.glDeleteShader(shader);
      throw new AssertionError(error);
    }
    return shader;
  }

  public static void main(String[] args) throws Exception {
    long window = 0;
    GLFWErrorCallback callback = GLFWErrorCallback.createPrint(System.err);
    callback.set();
    try {
      if (!GLFW.glfwInit()) throw new IllegalStateException("GLFW init failed");
      GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
      GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
      GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
      GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
      GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
      window = GLFW.glfwCreateWindow(64, 64, "NVVision bridge preflight", 0, 0);
      if (window == 0) throw new IllegalStateException("OpenGL 3.2 context unavailable");
      GLFW.glfwMakeContextCurrent(window);
      GL.createCapabilities();
      BridgeApi.inspect();
      System.out.println(BridgeApi.snapshot());
      if (!"active".equals(BridgeApi.snapshot().get("state")))
        throw new IllegalStateException("Not accelerated Zink");
      int texture = GL11.glGenTextures();
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture);
      GL11.glTexImage2D(
          GL11.GL_TEXTURE_2D,
          0,
          GL11.GL_RGBA8,
          64,
          64,
          0,
          GL11.GL_RGBA,
          GL11.GL_UNSIGNED_BYTE,
          (ByteBuffer) null);
      int fbo = GL30.glGenFramebuffers();
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);
      GL30.glFramebufferTexture2D(
          GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL11.GL_TEXTURE_2D, texture, 0);
      if (GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) != GL30.GL_FRAMEBUFFER_COMPLETE)
        throw new AssertionError("Incomplete framebuffer");
      GL11.glClearColor(.25f, .5f, .75f, 1f);
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
      ByteBuffer pixel = BufferUtils.createByteBuffer(4);
      GL11.glReadPixels(0, 0, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
      if (Math.abs(Byte.toUnsignedInt(pixel.get(0)) - 64) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(1)) - 128) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(2)) - 191) > 1)
        throw new AssertionError("Pixel mismatch");
      int depthStencil = GL30.glGenRenderbuffers();
      GL30.glBindRenderbuffer(GL30.GL_RENDERBUFFER, depthStencil);
      GL30.glRenderbufferStorage(GL30.GL_RENDERBUFFER, GL30.GL_DEPTH24_STENCIL8, 64, 64);
      GL30.glFramebufferRenderbuffer(
          GL30.GL_FRAMEBUFFER,
          GL30.GL_DEPTH_STENCIL_ATTACHMENT,
          GL30.GL_RENDERBUFFER,
          depthStencil);
      if (GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) != GL30.GL_FRAMEBUFFER_COMPLETE)
        throw new AssertionError("Packed depth/stencil framebuffer rejected");
      int vertex =
          compile(
              GL20.GL_VERTEX_SHADER,
              "#version 150\n"
                  + " out vec2 UV; void main(){vec2 p=vec2((gl_VertexID<<1)&2,gl_VertexID&2); UV=p;"
                  + " gl_Position=vec4(p*2.0-1.0,0,1);}");
      int fragment =
          compile(
              GL20.GL_FRAGMENT_SHADER,
              "#version 150\n"
                  + " uniform sampler2D Source; in vec2 UV; out vec4 Color; void"
                  + " main(){Color=texture(Source,UV);}");
      int program = GL20.glCreateProgram();
      GL20.glAttachShader(program, vertex);
      GL20.glAttachShader(program, fragment);
      GL20.glLinkProgram(program);
      if (GL20.glGetProgrami(program, GL20.GL_LINK_STATUS) == 0)
        throw new AssertionError(GL20.glGetProgramInfoLog(program));
      GL20.glDeleteShader(vertex);
      GL20.glDeleteShader(fragment);
      int source = GL11.glGenTextures();
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, source);
      ByteBuffer color =
          BufferUtils.createByteBuffer(4)
              .put((byte) 191)
              .put((byte) 64)
              .put((byte) 128)
              .put((byte) 255);
      color.flip();
      GL11.glTexImage2D(
          GL11.GL_TEXTURE_2D,
          0,
          GL11.GL_RGBA8,
          1,
          1,
          0,
          GL11.GL_RGBA,
          GL11.GL_UNSIGNED_BYTE,
          color);
      GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
      GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
      int vao = GL30.glGenVertexArrays();
      GL30.glBindVertexArray(vao);
      GL20.glUseProgram(program);
      GL20.glUniform1i(GL20.glGetUniformLocation(program, "Source"), 0);
      GL11.glViewport(0, 0, 64, 64);
      GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
      pixel.clear();
      GL11.glReadPixels(32, 32, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
      if (Math.abs(Byte.toUnsignedInt(pixel.get(0)) - 191) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(1)) - 64) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(2)) - 128) > 1)
        throw new AssertionError("GLSL sampler/draw mismatch");
      GL20.glUseProgram(0);
      GL30.glBindVertexArray(0);
      GL30.glDeleteVertexArrays(vao);
      GL20.glDeleteProgram(program);
      GL11.glDeleteTextures(source);
      GL30.glDeleteRenderbuffers(depthStencil);
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
      GL30.glDeleteFramebuffers(fbo);
      GL11.glDeleteTextures(texture);
      // A compositor must not blend the rendered game with another desktop window.
      int opacityTexture = GL11.glGenTextures();
      GL11.glBindTexture(GL11.GL_TEXTURE_2D, opacityTexture);
      GL11.glTexImage2D(
          GL11.GL_TEXTURE_2D,
          0,
          GL11.GL_RGBA8,
          64,
          64,
          0,
          GL11.GL_RGBA,
          GL11.GL_UNSIGNED_BYTE,
          (ByteBuffer) null);
      int opacityFbo = GL30.glGenFramebuffers();
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, opacityFbo);
      GL30.glFramebufferTexture2D(
          GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL11.GL_TEXTURE_2D, opacityTexture, 0);
      GL11.glClearColor(.25f, .5f, .75f, .25f);
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
      GL11.glColorMask(true, false, true, false);
      GL11.glEnable(GL11.GL_SCISSOR_TEST);
      GL11.glScissor(0, 0, 1, 1);
      GL30.glColorMaski(1, false, true, false, true);
      BridgeOpaquePresent.normalize(opacityFbo);
      if (GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) != opacityFbo
          || !GL11.glIsEnabled(GL11.GL_SCISSOR_TEST))
        throw new AssertionError("Presentation state changed");
      ByteBuffer restoredMask = BufferUtils.createByteBuffer(4);
      GL11.glGetBooleanv(GL11.GL_COLOR_WRITEMASK, restoredMask);
      if (restoredMask.get(0) == 0
          || restoredMask.get(1) != 0
          || restoredMask.get(2) == 0
          || restoredMask.get(3) != 0) throw new AssertionError("Presentation color mask changed");
      ByteBuffer otherMask = BufferUtils.createByteBuffer(4);
      GL30.glGetBooleani_v(GL11.GL_COLOR_WRITEMASK, 1, otherMask);
      if (otherMask.get(0) != 0
          || otherMask.get(1) == 0
          || otherMask.get(2) != 0
          || otherMask.get(3) == 0)
        throw new AssertionError("Presentation changed another MRT color mask");
      pixel.clear();
      GL11.glReadPixels(32, 32, 1, 1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixel);
      if (Math.abs(Byte.toUnsignedInt(pixel.get(0)) - 64) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(1)) - 128) > 1
          || Math.abs(Byte.toUnsignedInt(pixel.get(2)) - 191) > 1
          || Byte.toUnsignedInt(pixel.get(3)) != 255)
        throw new AssertionError("Opaque presentation RGB/alpha mismatch");
      GL11.glColorMask(true, true, true, true);
      GL11.glDisable(GL11.GL_SCISSOR_TEST);
      GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, 0);
      GL30.glDeleteFramebuffers(opacityFbo);
      GL11.glDeleteTextures(opacityTexture);
      if (GL11.glGetError() != GL11.GL_NO_ERROR) throw new AssertionError("OpenGL error");
      if (args.length > 0) BridgeApi.report(Path.of(args[0]));
      System.out.println(
          "PASS ZINK: hardware context, framebuffer, GLSL shaders, texture sampling, packed"
              + " depth/stencil, rendered pixels, opaque presentation and restored state,"
              + " error-free cleanup.");
    } finally {
      if (window != 0) {
        GLFW.glfwMakeContextCurrent(0);
        GLFW.glfwDestroyWindow(window);
      }
      GLFW.glfwTerminate();
      callback.free();
    }
  }
}
