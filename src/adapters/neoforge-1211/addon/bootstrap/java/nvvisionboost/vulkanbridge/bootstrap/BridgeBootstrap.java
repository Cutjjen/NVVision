/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: bootstrap/java/nvvisionboost/vulkanbridge/bootstrap/BridgeBootstrap.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost.vulkanbridge.bootstrap;

import java.io.*;
import java.lang.instrument.Instrumentation;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;

/** Runs before Minecraft/GLFW. Never replaces an already active context. */
public final class BridgeBootstrap {
  public static void premain(String arguments, Instrumentation instrumentation) {
    boolean nativeLoadStarted = false;
    try {
      Path home =
          Path.of(System.getProperty("nvvisionbridge.home", ".")).toAbsolutePath().normalize();
      Properties profile = new Properties();
      Path settings = home.resolve("bridge.properties");
      if (Files.isRegularFile(settings) && Files.size(settings) <= 8192)
        try (InputStream stream = Files.newInputStream(settings)) {
          profile.load(stream);
        }
      String backend =
          System.getProperty("nvvisionbridge.backend", profile.getProperty("backend", "opengl"));
      if (!backend.equals("zink")) {
        System.setProperty("nvvisionbridge.bootstrap", "native");
        return;
      }
      if (!System.getProperty("os.name", "").startsWith("Windows")
          || !System.getProperty("os.arch", "").equals("amd64"))
        throw new IOException("Only Windows x64 is packaged.");
      Path nativeDir = home.resolve("runtime/mesa/x64");
      Properties hashes = new Properties();
      try (InputStream in =
          Files.newInputStream(home.resolve("runtime/mesa/native-sha256.properties"))) {
        hashes.load(in);
      }
      for (String name : List.of("libgallium_wgl.dll", "opengl32.dll")) {
        Path library = nativeDir.resolve(name);
        if (!Files.isRegularFile(library, LinkOption.NOFOLLOW_LINKS))
          throw new IOException("Native library missing: " + name);
        String actual;
        try (InputStream in = Files.newInputStream(library)) {
          MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] bytes = new byte[65536];
          int size;
          while ((size = in.read(bytes)) != -1) digest.update(bytes, 0, size);
          actual = HexFormat.of().formatHex(digest.digest());
        }
        if (!actual.equals(hashes.getProperty(name)))
          throw new IOException("Native library checksum mismatch: " + name);
      }
      if (Boolean.getBoolean("nvvisionbridge.prepareEnvironment")) {
        String mode = System.getProperty("nvvisionbridge.descriptors", profile.getProperty("descriptors", "auto"));
        if (!Set.of("auto", "lazy").contains(mode)) throw new IOException("Invalid descriptor mode.");
        Path helper = home.resolve("runtime/bootstrap/nvvision-bridge-env.dll");
        String expected = Files.readString(home.resolve("runtime/bootstrap/environment.sha256")).trim();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (InputStream in = Files.newInputStream(helper)) {
          byte[] bytes = new byte[65536]; int size;
          while ((size = in.read(bytes)) != -1) digest.update(bytes, 0, size);
        }
        if (!expected.equals(HexFormat.of().formatHex(digest.digest()))) throw new IOException("Environment helper checksum mismatch.");
        Path cache = home.resolve("cache/mesa/" + hashes.getProperty("libgallium_wgl.dll").substring(0,16));
        Files.createDirectories(cache);
        System.load(helper.toString());
        if (!BridgeEnvironment.prepare(cache.toString(), mode)) throw new IOException("Cannot prepare process environment.");
        System.setProperty("nvvisionbridge.environment", "process-local");
        System.setProperty("nvvisionbridge.descriptors", mode);
      } else if (!"zink".equals(System.getenv("GALLIUM_DRIVER"))) {
        throw new IOException("Use process-local bootstrap or start via INICIAR-COM-BRIDGE.ps1.");
      }
      if (!Boolean.getBoolean("nvvisionbridge.preflightChild")) {
        Path log = home.resolve("logs/startup-preflight.log");
        Files.createDirectories(log.getParent());
        Path javaExecutable = Path.of(System.getProperty("java.home")).resolve("bin/java.exe");
        Path agent = home.resolve("dist/nvvision-vulkan-bootstrap.jar");
        String classpath = home.resolve("dist/nvvision-vulkan-preflight.jar") + ";" + (home.resolve("runtime/preflight") + "/*");
        Process child = new ProcessBuilder(javaExecutable.toString(), "-javaagent:" + agent,
            "-Dnvvisionbridge.home=" + home, "-Dnvvisionbridge.backend=zink",
            "-Dnvvisionbridge.prepareEnvironment=true", "-Dnvvisionbridge.preflightChild=true",
            "-Dnvvisionbridge.descriptors=" + System.getProperty("nvvisionbridge.descriptors", "auto"),
            "-Dorg.lwjgl.librarypath=" + home.resolve("runtime/preflight"),
            "-cp", classpath, "nvvisionboost.vulkanbridge.BridgePreflight")
            .redirectErrorStream(true).redirectOutput(log.toFile()).start();
        if (!child.waitFor(60, java.util.concurrent.TimeUnit.SECONDS)) {
          child.destroyForcibly();
          throw new IOException("Vulkan preflight timed out; native OpenGL retained.");
        }
        if (child.exitValue() != 0 || Files.size(log) > 262144 || !Files.readString(log).contains("PASS ZINK:"))
          throw new IOException("Vulkan preflight failed; see " + log);
      }
      // Loading dependencies first also makes the same WGL implementation visible to GLFW.
      nativeLoadStarted = true;
      System.load(nativeDir.resolve("libgallium_wgl.dll").toString());
      System.load(nativeDir.resolve("opengl32.dll").toString());
      System.setProperty("org.lwjgl.opengl.libname", nativeDir.resolve("opengl32.dll").toString());
      System.setProperty("nvvisionbridge.bootstrap", "zink-requested");
      System.err.println(
          "[NVVision Vulkan Bridge] Mesa/Zink preloaded; GPU validation is still required.");
    } catch (Exception | LinkageError error) {
      System.err.println(
          "[NVVision Vulkan Bridge] Bootstrap refused: "
              + error.getClass().getSimpleName()
              + ": "
              + error.getMessage());
      if (!nativeLoadStarted) {
        System.setProperty("nvvisionbridge.bootstrap", "native-rejected");
        System.err.println(
            "[NVVision Vulkan Bridge] No native driver was loaded; continuing with normal OpenGL.");
        return;
      }
      // Do not continue with a partially loaded graphics driver in the same JVM.
      System.exit(78);
    }
  }
}


