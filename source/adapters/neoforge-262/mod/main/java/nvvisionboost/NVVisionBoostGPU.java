package nvvisionboost;

import com.mojang.blaze3d.systems.RenderSystem;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/** Active OpenGL GPU detection and curated multi-vendor starting presets. */
public final class NVVisionBoostGPU {
  public static final class Info {
    public String vendor = "Unknown", name = "Unknown GPU", driver = "Unknown";
    public long totalMemoryMB = -1, freeMemoryMB = -1;
    public String cpu = System.getProperty("os.arch", "unknown");
    public int cores, threads = Runtime.getRuntime().availableProcessors();
    public long allocatedRamMB, systemRamMB;
    public boolean nvidia, rtx;
    public NVVisionBoostGpuCatalog.Brand brand = NVVisionBoostGpuCatalog.Brand.UNKNOWN;
    public NVVisionBoostGpuCatalog.Type type = NVVisionBoostGpuCatalog.Type.UNKNOWN;
    public boolean fsr1Supported, timerSupported, nativeMemorySupported;

    public String technologySummary() {
      return "FSR 1: "
          + (fsr1Supported ? "compatível" : "fallback bicúbico")
          + " | GPU timer: "
          + (timerSupported ? "compatível" : "fallback FPS");
    }

    public int rtxGeneration;
    public boolean dlssSR, frameGeneration, multiFrameGeneration;
    public String backendNote = "";
  }

  public static final class Preset {
    public final String name, architecture, family;
    public final int generation, vramGB, targetFps, renderDistance, entityDistance, renderScale;
    public final int animationLevel, transparencyLevel;
    public final boolean particles, cloudsOff, entityShadowsOff, shaderEffects, dynamicResolution;
    public final String profile;

    public Preset(
        String n,
        String a,
        String f,
        int g,
        int v,
        int fps,
        int rd,
        int ed,
        int rs,
        int al,
        int tl,
        boolean part,
        boolean clouds,
        boolean shadows,
        boolean effects,
        boolean dyn,
        String p) {
      name = n;
      architecture = a;
      family = f;
      generation = g;
      vramGB = v;
      targetFps = fps;
      renderDistance = rd;
      entityDistance = ed;
      renderScale = rs;
      animationLevel = al;
      transparencyLevel = tl;
      particles = part;
      cloudsOff = clouds;
      entityShadowsOff = shadows;
      shaderEffects = effects;
      dynamicResolution = dyn;
      profile = p;
    }

    public String summary() {
      return profile + " | " + renderScale + "% | RD " + renderDistance + " | FPS " + targetFps;
    }
  }

  private static volatile List<Preset> PRESETS;
  private static volatile Info DETECTED;

  private NVVisionBoostGPU() {}

  public static Info detect() {
    Info cached = DETECTED;
    if (cached != null) return cached;

    Info i = new Info();
    if (!RenderSystem.isOnRenderThread()) {
      i.backendNote = "Detecção adiada até o contexto gráfico do cliente estar pronto.";
      return i;
    }
    if (detectNonOpenGL(i)) return i;
    try {
      GL.getCapabilities();
    } catch (IllegalStateException unavailable) {
      i.backendNote = "Contexto OpenGL ainda indisponível; detecção adiada.";
      return i;
    }
    var hardware = NVVisionBoostHardwareBudget.detect();
    i.cpu = hardware.cpu();
    i.cores = hardware.physicalCores();
    i.threads = hardware.logicalThreads();
    i.allocatedRamMB = hardware.allocatedRamMB();
    i.systemRamMB = hardware.systemRamMB();
    // A GPU do contexto OpenGL é a que efetivamente desenha o Minecraft.
    detectFromOpenGL(i);
    String[] o = i.nvidia ? run(i.name) : null;
    if (o != null && o.length > 0 && norm(o[0]).equals(norm(i.name.replace("/PCIe/SSE2", "")))) {
      i.nvidia = true;
      i.vendor = "NVIDIA";
      if (o.length > 0) i.name = o[0].trim();
      if (o.length > 1) i.driver = o[1].trim();
      if (o.length > 2) i.totalMemoryMB = pl(o[2]);
      if (o.length > 3) i.freeMemoryMB = pl(o[3]);
      NVVisionBoostLogger.logSuccess("Detecção de GPU via nvidia-smi: " + i.name);
    } else if (i.nvidia) {
      NVVisionBoostLogger.logFailure(
          "Detecção de GPU via nvidia-smi",
          "Ferramenta indisponível ou falha na consulta. Tentando via OpenGL.");
      detectFromOpenGL(i);
    }

    String normalized = norm(i.name);
    Matcher m = Pattern.compile("rtx(20|30|40|50)").matcher(normalized);
    if (i.nvidia && m.find()) {
      i.rtx = true;
      i.rtxGeneration = Integer.parseInt(m.group(1));
    }
    // Hardware eligibility never advertises an SDK that this OpenGL mod does not implement.
    i.dlssSR = i.frameGeneration = i.multiFrameGeneration = false;
    var caps = GL.getCapabilities();
    i.fsr1Supported = NVVisionBoostFsr1Upscaler.supported();
    i.timerSupported = caps.OpenGL33 || caps.GL_ARB_timer_query;
    i.nativeMemorySupported =
        memoryExtensionAllowed(i.brand, caps.GL_NVX_gpu_memory_info, caps.GL_ATI_meminfo);
    i.backendNote =
        i.brand
            + " | "
            + i.type.label
            + " (identificação do renderizador) | "
            + i.technologySummary();
    NVVisionBoostLogger.logSuccess("GPU ativa: " + i.name + " | " + i.backendNote);

    if (!i.name.equals("Unknown GPU") && !i.name.isBlank()) DETECTED = i;
    return i;
  }

  /** Forces the next detection call to query the current GPU again. */
  public static Info detectFresh() {
    DETECTED = null;
    NVVisionBoostLogger.logSuccess("Forçada nova varredura/detecção de GPU (detectFresh)");
    return detect();
  }

  /** Native Minecraft device metadata; never call OpenGL for a non-GL render target. */
  private static boolean detectNonOpenGL(Info i) {
    try {
      var target = net.minecraft.client.Minecraft.getInstance().gameRenderer.mainRenderTarget();
      if (target == null
          || target.getColorTexture() == null
          || target.getColorTexture() instanceof com.mojang.blaze3d.opengl.GlTexture) return false;
      var device = RenderSystem.getDevice().getDeviceInfo();
      i.vendor = device.vendorName();
      i.name = device.name();
      i.driver = device.driverInfo();
      String backend = device.backendName();
      var identity = NVVisionBoostGpuCatalog.classify(i.vendor, i.name);
      i.brand = identity.brand();
      i.type = identity.type();
      if (device.type() == com.mojang.blaze3d.systems.DeviceType.INTEGRATED)
        i.type = NVVisionBoostGpuCatalog.Type.INTEGRATED;
      if (device.type() == com.mojang.blaze3d.systems.DeviceType.DISCRETE)
        i.type = NVVisionBoostGpuCatalog.Type.DISCRETE;
      i.nvidia = i.brand == NVVisionBoostGpuCatalog.Brand.NVIDIA;
      var hardware = NVVisionBoostHardwareBudget.detect();
      i.cpu = hardware.cpu();
      i.cores = hardware.physicalCores();
      i.threads = hardware.logicalThreads();
      i.allocatedRamMB = hardware.allocatedRamMB();
      i.systemRamMB = hardware.systemRamMB();
      i.backendNote = backend + " | renderizador nativo preservado; filtros OpenGL suspensos.";
      DETECTED = i;
      return true;
    } catch (RuntimeException | LinkageError unavailable) {
      i.backendNote = "Dispositivo gráfico indisponível; detecção adiada.";
      return true;
    }
  }

  private static void detectFromOpenGL(Info i) {
    try {
      String vendor = GL11.glGetString(GL11.GL_VENDOR);
      String renderer = GL11.glGetString(GL11.GL_RENDERER);
      if (vendor != null && !vendor.isBlank()) i.vendor = vendor.trim();
      if (renderer != null && !renderer.isBlank()) i.name = renderer.trim();
      String version = GL11.glGetString(GL11.GL_VERSION);
      if (version != null) i.driver = version;
      var identity = NVVisionBoostGpuCatalog.classify(i.vendor, i.name);
      i.brand = identity.brand();
      i.type = identity.type();
      var kind = RenderSystem.getDevice().getDeviceInfo().type();
      if (kind == com.mojang.blaze3d.systems.DeviceType.INTEGRATED)
        i.type = NVVisionBoostGpuCatalog.Type.INTEGRATED;
      if (kind == com.mojang.blaze3d.systems.DeviceType.DISCRETE)
        i.type = NVVisionBoostGpuCatalog.Type.DISCRETE;
      i.nvidia = i.brand == NVVisionBoostGpuCatalog.Brand.NVIDIA;
      NVVisionBoostLogger.logSuccess("Detecção via OpenGL: " + i.brand + " / " + i.name);
    } catch (Throwable t) {
      NVVisionBoostLogger.logError("Detecção de GPU via OpenGL", t);
    }
  }

  public static Preset presetFor(String gpuName) {
    if (gpuName == null) {
      NVVisionBoostLogger.logFailure("Seleção de Preset de GPU", "Nome da GPU fornecido é nulo.");
      return null;
    }
    String n = norm(gpuName);
    var identity = NVVisionBoostGpuCatalog.classify("", gpuName);
    // Laptop clocks, thermal limits and memory differ from desktop equivalents.
    if (identity.brand() != NVVisionBoostGpuCatalog.Brand.NVIDIA
        && gpuName
            .toLowerCase(Locale.ROOT)
            .matches(".*(laptop|mobile|notebook|rx\\s*[0-9]{4}m|arc\\s*a[0-9]{3}m).*"))
      return NVVisionBoostGpuCatalog.fallback(gpuName, identity);
    Info detected = DETECTED;
    if (detected != null
        && norm(detected.name).equals(n)
        && detected.totalMemoryMB > 0
        && !n.contains("gb")) {
      n +=
          detected.totalMemoryMB >= 14000
              ? "16gb"
              : detected.totalMemoryMB >= 10000 ? "12gb" : "8gb";
    }
    List<Preset> all = new ArrayList<>(presets());
    all.sort(
        Comparator.comparingInt(
                (Preset preset) -> norm(preset.name).replaceAll("[0-9]+gb$", "").length())
            .reversed()
            .thenComparingInt(preset -> preset.vramGB));
    boolean memorySpecified = n.matches(".*[0-9]+gb$");
    for (Preset preset : all) {
      if (identity.brand() != NVVisionBoostGpuCatalog.Brand.UNKNOWN
          && NVVisionBoostGpuCatalog.classify("", preset.name).brand() != identity.brand())
        continue;
      String key =
          memorySpecified ? norm(preset.name) : norm(preset.name).replaceAll("[0-9]+gb$", "");
      if (identity.brand() == NVVisionBoostGpuCatalog.Brand.NVIDIA
          ? n.contains(key)
          : java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(key) + "(?![a-z0-9])")
              .matcher(n)
              .find()) return preset;
    }

    NVVisionBoostLogger.logFailure(
        "Busca de Preset Específico",
        "Nenhum preset exato para '" + gpuName + "'. Utilizando preset genérico.");
    return genericPreset(gpuName);
  }

  public static Preset genericPreset(String name) {
    var identity = NVVisionBoostGpuCatalog.classify("", name);
    if (identity.brand() != NVVisionBoostGpuCatalog.Brand.NVIDIA)
      return NVVisionBoostGpuCatalog.fallback(name, identity);
    String n = norm(name);
    int gen = 0;
    if (n.contains("rtx50")) gen = 50;
    else if (n.contains("rtx40")) gen = 40;
    else if (n.contains("rtx30")) gen = 30;
    else if (n.contains("rtx20")) gen = 20;

    Preset p;
    if (gen >= 50)
      p =
          new Preset(
              name,
              "Blackwell",
              "RTX 50",
              50,
              12,
              90,
              24,
              100,
              90,
              3,
              3,
              true,
              false,
              false,
              true,
              true,
              "quality");
    else if (gen >= 40)
      p =
          new Preset(
              name,
              "Ada Lovelace",
              "RTX 40",
              40,
              8,
              75,
              20,
              95,
              85,
              3,
              2,
              true,
              false,
              false,
              true,
              true,
              "quality");
    else if (gen >= 30)
      p =
          new Preset(
              name,
              "Ampere",
              "RTX 30",
              30,
              8,
              70,
              18,
              90,
              85,
              2,
              2,
              true,
              false,
              true,
              true,
              true,
              "balanced");
    else if (gen >= 20)
      p =
          new Preset(
              name,
              "Turing",
              "RTX 20",
              20,
              8,
              60,
              16,
              85,
              80,
              2,
              1,
              true,
              true,
              true,
              true,
              true,
              "balanced");
    else
      p =
          new Preset(
              name,
              "Generic",
              "Unknown / integrated",
              0,
              0,
              60,
              10,
              75,
              80,
              1,
              1,
              true,
              true,
              true,
              false,
              false,
              "low");

    NVVisionBoostLogger.logSuccess("Preset genérico gerado com sucesso para: " + name);
    return p;
  }

  public static List<Preset> presets() {
    List<Preset> cached = PRESETS;
    if (cached != null) return cached;
    List<Preset> p = new ArrayList<>();

    // GTX 400 / Fermi — conservative legacy presets
    add(
        p, "GTX 460", "Fermi", "GTX 400", 4, 1, 30, 6, 45, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p,
        "GTX 460 SE",
        "Fermi",
        "GTX 400",
        4,
        1,
        30,
        6,
        40,
        50,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 465", "Fermi", "GTX 400", 4, 1, 30, 6, 45, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p, "GTX 470", "Fermi", "GTX 400", 4, 1, 35, 7, 50, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p, "GTX 480", "Fermi", "GTX 400", 4, 1, 40, 8, 55, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p, "GTX 580", "Fermi", "GTX 500", 5, 1, 40, 8, 55, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p,
        "GTX 580 3GB",
        "Fermi",
        "GTX 500",
        5,
        3,
        40,
        8,
        60,
        55,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 570", "Fermi", "GTX 500", 5, 1, 40, 8, 55, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p, "GTX 560", "Fermi", "GTX 500", 5, 1, 40, 7, 50, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p,
        "GTX 560 Ti",
        "Fermi",
        "GTX 500",
        5,
        1,
        45,
        8,
        55,
        55,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 550 Ti",
        "Fermi",
        "GTX 500",
        5,
        1,
        35,
        6,
        45,
        50,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 590", "Fermi", "GTX 500", 5, 3, 45, 8, 60, 55, 0, 0, true, true, true, false, true,
        "low");

    // GTX 600 / Kepler
    add(
        p, "GTX 650", "Kepler", "GTX 600", 6, 1, 40, 7, 50, 50, 0, 0, true, true, true, false, true,
        "low");
    add(
        p,
        "GTX 650 Ti",
        "Kepler",
        "GTX 600",
        6,
        1,
        45,
        8,
        55,
        50,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 650 Ti BOOST",
        "Kepler",
        "GTX 600",
        6,
        2,
        50,
        9,
        60,
        55,
        0,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 660", "Kepler", "GTX 600", 6, 2, 50, 10, 65, 60, 1, 1, true, true, true, false,
        true, "low");
    add(
        p,
        "GTX 660 Ti",
        "Kepler",
        "GTX 600",
        6,
        2,
        55,
        10,
        70,
        60,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 670", "Kepler", "GTX 600", 6, 2, 55, 11, 75, 67, 1, 1, true, true, true, false,
        true, "low");
    add(
        p, "GTX 680", "Kepler", "GTX 600", 6, 2, 60, 12, 80, 67, 1, 1, true, true, true, true, true,
        "low");
    add(
        p, "GTX 690", "Kepler", "GTX 600", 6, 4, 60, 12, 85, 67, 1, 1, true, true, true, true, true,
        "low");

    // GTX 700 / Kepler and Maxwell
    add(
        p, "GTX 750", "Maxwell", "GTX 700", 7, 1, 45, 8, 55, 55, 0, 0, true, true, true, false,
        true, "low");
    add(
        p, "GTX 760", "Kepler", "GTX 700", 7, 2, 50, 10, 65, 60, 1, 1, true, true, true, false,
        true, "low");
    add(
        p,
        "GTX 760 4GB",
        "Kepler",
        "GTX 700",
        7,
        4,
        50,
        10,
        70,
        60,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p, "GTX 770", "Kepler", "GTX 700", 7, 2, 55, 12, 75, 67, 1, 1, true, true, true, true, true,
        "low");
    add(
        p,
        "GTX 770 4GB",
        "Kepler",
        "GTX 700",
        7,
        4,
        55,
        12,
        80,
        67,
        1,
        1,
        true,
        true,
        true,
        true,
        true,
        "low");
    add(
        p,
        "GTX 780",
        "Kepler",
        "GTX 700",
        7,
        3,
        60,
        14,
        80,
        67,
        1,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 780 Ti",
        "Kepler",
        "GTX 700",
        7,
        3,
        60,
        14,
        85,
        75,
        1,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX Titan",
        "Kepler",
        "Titan",
        7,
        6,
        60,
        16,
        90,
        75,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX Titan Black",
        "Kepler",
        "Titan",
        7,
        6,
        60,
        16,
        90,
        75,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX Titan Z",
        "Kepler",
        "Titan",
        7,
        12,
        60,
        16,
        95,
        75,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");

    // GTX 900 / Maxwell
    add(
        p, "GTX 950", "Maxwell", "GTX 900", 9, 2, 45, 8, 55, 50, 0, 0, true, true, true, false,
        true, "low");
    add(
        p, "GTX 960", "Maxwell", "GTX 900", 9, 4, 50, 10, 60, 60, 1, 0, true, true, true, false,
        true, "low");
    add(
        p, "GTX 970", "Maxwell", "GTX 900", 9, 4, 55, 10, 65, 67, 1, 1, true, true, true, false,
        true, "low");
    add(
        p, "GTX 980", "Maxwell", "GTX 900", 9, 4, 60, 12, 75, 67, 1, 1, true, true, true, true,
        true, "low");
    add(
        p,
        "GTX 980 Ti",
        "Maxwell",
        "GTX 900",
        9,
        6,
        60,
        14,
        80,
        75,
        1,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX Titan X",
        "Maxwell",
        "Titan",
        9,
        12,
        60,
        16,
        90,
        75,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "Titan Xp",
        "Pascal",
        "Titan",
        10,
        12,
        60,
        18,
        95,
        80,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p, "Titan V", "Volta", "Titan", 12, 12, 75, 20, 100, 85, 3, 2, true, false, false, true,
        true, "quality");
    add(
        p,
        "Titan RTX",
        "Turing",
        "Titan",
        20,
        24,
        90,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "GTX 1050",
        "Pascal",
        "GTX 10",
        10,
        2,
        60,
        8,
        55,
        67,
        1,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1050 Ti",
        "Pascal",
        "GTX 10",
        10,
        4,
        60,
        10,
        65,
        75,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1060 3GB",
        "Pascal",
        "GTX 10",
        10,
        3,
        60,
        10,
        65,
        67,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1060 6GB",
        "Pascal",
        "GTX 10",
        10,
        6,
        60,
        12,
        75,
        75,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1070",
        "Pascal",
        "GTX 10",
        10,
        8,
        60,
        14,
        80,
        80,
        1,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 1070 Ti",
        "Pascal",
        "GTX 10",
        10,
        8,
        60,
        14,
        85,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 1080",
        "Pascal",
        "GTX 10",
        10,
        8,
        60,
        16,
        90,
        80,
        2,
        2,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 1080 Ti",
        "Pascal",
        "GTX 10",
        10,
        11,
        60,
        18,
        95,
        85,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 1630",
        "Turing",
        "GTX 16",
        16,
        4,
        45,
        8,
        60,
        60,
        0,
        0,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1650",
        "Turing",
        "GTX 16",
        16,
        4,
        60,
        10,
        65,
        75,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1650 GDDR6",
        "Turing",
        "GTX 16",
        16,
        4,
        60,
        11,
        70,
        75,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1650 SUPER",
        "Turing",
        "GTX 16",
        16,
        4,
        60,
        12,
        70,
        75,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1660",
        "Turing",
        "GTX 16",
        16,
        6,
        60,
        12,
        80,
        80,
        1,
        1,
        true,
        true,
        true,
        false,
        true,
        "low");
    add(
        p,
        "GTX 1660 SUPER",
        "Turing",
        "GTX 16",
        16,
        6,
        60,
        14,
        85,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "GTX 1660 Ti",
        "Turing",
        "GTX 16",
        16,
        6,
        60,
        14,
        85,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2060",
        "Turing",
        "RTX 20",
        20,
        6,
        60,
        14,
        85,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2060 SUPER",
        "Turing",
        "RTX 20",
        20,
        8,
        60,
        16,
        90,
        80,
        2,
        2,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2070",
        "Turing",
        "RTX 20",
        20,
        8,
        60,
        16,
        90,
        85,
        2,
        2,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2070 SUPER",
        "Turing",
        "RTX 20",
        20,
        8,
        60,
        18,
        90,
        85,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2080",
        "Turing",
        "RTX 20",
        20,
        8,
        70,
        18,
        95,
        90,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2080 SUPER",
        "Turing",
        "RTX 20",
        20,
        8,
        70,
        20,
        95,
        90,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 2080 Ti",
        "Turing",
        "RTX 20",
        20,
        11,
        75,
        20,
        100,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3050",
        "Ampere",
        "RTX 30",
        30,
        8,
        60,
        14,
        85,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 3060 8GB",
        "Ampere",
        "RTX 30",
        30,
        8,
        60,
        16,
        90,
        85,
        2,
        2,
        true,
        true,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 3060 12GB",
        "Ampere",
        "RTX 30",
        30,
        12,
        60,
        18,
        95,
        85,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 3060 Ti",
        "Ampere",
        "RTX 30",
        30,
        8,
        70,
        18,
        95,
        90,
        2,
        2,
        true,
        false,
        true,
        true,
        true,
        "balanced");
    add(
        p,
        "RTX 3070",
        "Ampere",
        "RTX 30",
        30,
        8,
        75,
        20,
        95,
        90,
        3,
        2,
        true,
        false,
        true,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3070 Ti",
        "Ampere",
        "RTX 30",
        30,
        8,
        75,
        20,
        100,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3080 10GB",
        "Ampere",
        "RTX 30",
        30,
        10,
        75,
        22,
        100,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3080 12GB",
        "Ampere",
        "RTX 30",
        30,
        12,
        75,
        22,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3080 Ti",
        "Ampere",
        "RTX 30",
        30,
        12,
        75,
        22,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3090",
        "Ampere",
        "RTX 30",
        30,
        24,
        90,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 3090 Ti",
        "Ampere",
        "RTX 30",
        30,
        24,
        90,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4060",
        "Ada Lovelace",
        "RTX 40",
        40,
        8,
        75,
        18,
        95,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4060 Ti 8GB",
        "Ada Lovelace",
        "RTX 40",
        40,
        8,
        75,
        20,
        100,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4060 Ti 16GB",
        "Ada Lovelace",
        "RTX 40",
        40,
        16,
        90,
        22,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4070",
        "Ada Lovelace",
        "RTX 40",
        40,
        12,
        90,
        22,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4070 SUPER",
        "Ada Lovelace",
        "RTX 40",
        40,
        12,
        90,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4070 Ti",
        "Ada Lovelace",
        "RTX 40",
        40,
        12,
        90,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4070 Ti SUPER",
        "Ada Lovelace",
        "RTX 40",
        40,
        16,
        100,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4080",
        "Ada Lovelace",
        "RTX 40",
        40,
        16,
        100,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4080 SUPER",
        "Ada Lovelace",
        "RTX 40",
        40,
        16,
        100,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 4090",
        "Ada Lovelace",
        "RTX 40",
        40,
        24,
        120,
        32,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5050",
        "Blackwell",
        "RTX 50",
        50,
        8,
        75,
        18,
        95,
        90,
        3,
        2,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5060",
        "Blackwell",
        "RTX 50",
        50,
        8,
        90,
        20,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5060 Ti 8GB",
        "Blackwell",
        "RTX 50",
        50,
        8,
        90,
        22,
        100,
        95,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5060 Ti 16GB",
        "Blackwell",
        "RTX 50",
        50,
        16,
        100,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5070",
        "Blackwell",
        "RTX 50",
        50,
        12,
        100,
        24,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5070 Ti",
        "Blackwell",
        "RTX 50",
        50,
        16,
        100,
        28,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5080",
        "Blackwell",
        "RTX 50",
        50,
        16,
        120,
        32,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");
    add(
        p,
        "RTX 5090",
        "Blackwell",
        "RTX 50",
        50,
        32,
        120,
        32,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        true,
        "quality");

    add(
        p,
        "RX 9070 XT",
        "RDNA 4",
        "Radeon RX 9000",
        9,
        16,
        90,
        22,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        false,
        "quality");
    add(
        p,
        "RX 9070",
        "RDNA 4",
        "Radeon RX 9000",
        9,
        16,
        90,
        20,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        false,
        "quality");
    add(
        p,
        "RX 9060 XT 8GB",
        "RDNA 4",
        "Radeon RX 9000",
        9,
        8,
        75,
        16,
        90,
        90,
        2,
        2,
        true,
        false,
        false,
        true,
        false,
        "balanced");
    add(
        p,
        "RX 9060 XT 16GB",
        "RDNA 4",
        "Radeon RX 9000",
        9,
        16,
        75,
        18,
        90,
        95,
        2,
        2,
        true,
        false,
        false,
        true,
        false,
        "balanced");
    add(
        p,
        "RX 7900 XTX",
        "RDNA 3",
        "Radeon RX 7000",
        7,
        24,
        90,
        22,
        100,
        100,
        3,
        3,
        true,
        false,
        false,
        true,
        false,
        "quality");
    add(
        p,
        "RX 7800 XT",
        "RDNA 3",
        "Radeon RX 7000",
        7,
        16,
        75,
        18,
        90,
        95,
        2,
        2,
        true,
        false,
        false,
        true,
        false,
        "balanced");
    add(
        p,
        "RX 7600",
        "RDNA 3",
        "Radeon RX 7000",
        7,
        8,
        60,
        14,
        80,
        85,
        2,
        2,
        true,
        true,
        true,
        true,
        false,
        "balanced");
    add(
        p,
        "RX 6600",
        "RDNA 2",
        "Radeon RX 6000",
        6,
        8,
        60,
        12,
        80,
        80,
        2,
        1,
        true,
        true,
        true,
        true,
        false,
        "balanced");
    add(
        p,
        "Arc B580",
        "Xe2",
        "Intel Arc B",
        2,
        12,
        75,
        16,
        90,
        90,
        2,
        2,
        true,
        false,
        false,
        true,
        false,
        "balanced");
    add(
        p,
        "Arc B570",
        "Xe2",
        "Intel Arc B",
        2,
        10,
        60,
        14,
        85,
        85,
        2,
        2,
        true,
        true,
        true,
        true,
        false,
        "balanced");
    add(
        p,
        "Arc A770",
        "Xe HPG",
        "Intel Arc A",
        1,
        8,
        60,
        14,
        85,
        85,
        2,
        2,
        true,
        true,
        true,
        true,
        false,
        "balanced");
    add(
        p,
        "Arc A750",
        "Xe HPG",
        "Intel Arc A",
        1,
        8,
        60,
        12,
        80,
        80,
        2,
        2,
        true,
        true,
        true,
        true,
        false,
        "balanced");

    for (Preset extra : NVVisionBoostGpuCatalog.additionalPresets()) {
      String model = norm(extra.name).replaceAll("[0-9]+gb$", "");
      // Retain existing model/VRAM variants; do not add duplicate vendor-prefix aliases.
      if (p.stream()
          .noneMatch(existing -> norm(existing.name).replaceAll("[0-9]+gb$", "").equals(model)))
        p.add(extra);
    }
    List<Preset> immutable = Collections.unmodifiableList(p);
    PRESETS = immutable;
    NVVisionBoostLogger.logSuccess(
        "Banco de dados de presets de GPU carregado (" + immutable.size() + " modelos).");
    return immutable;
  }

  private static void add(
      List<Preset> p,
      String n,
      String a,
      String f,
      int g,
      int v,
      int fps,
      int rd,
      int ed,
      int rs,
      int al,
      int tl,
      boolean part,
      boolean clouds,
      boolean shadows,
      boolean effects,
      boolean dyn,
      String prof) {
    p.add(
        new Preset(
            n, a, f, g, v, fps, rd, ed, rs, al, tl, part, clouds, shadows, effects, dyn, prof));
  }

  public static void applyPresetSafe(NVVisionBoostCore.Config c, Preset p) {
    if (c == null || p == null) {
      NVVisionBoostLogger.logFailure(
          "Aplicar Preset Seguro", "Configuração ou Preset nulo fornecido.");
      return;
    }
    c.gpuPreset = p.name;
    c.gpuPresetApplied = true;
    c.profile = "low".equalsIgnoreCase(p.profile) ? "low" : "balanced";
    c.targetFps = Math.min(90, Math.max(60, p.targetFps));
    c.minRenderDistance = 6;
    c.maxRenderDistance = 16;
    c.renderDistance = Math.min(14, Math.max(c.minRenderDistance, p.renderDistance));
    c.entityDistancePercent = Math.min(90, Math.max(70, p.entityDistance));
    c.renderScalePercent = NVVisionBoostIO.clamp(p.renderScale, 10, 100);
    c.upscalingEnabled = c.renderScalePercent < 100;
    c.animationLevel = Math.min(2, Math.max(1, p.animationLevel));
    c.transparencyLevel = Math.min(2, Math.max(1, p.transparencyLevel));
    c.reduceParticles = true;
    c.disableClouds = true;
    c.disableEntityShadows = true;
    c.reduceShaderEffects = false;
    c.dynamicResolution = false;
    c.nativeShaderRenderer = false;
    tailor(c, p);
    NVVisionBoostLogger.logSuccess("Preset seguro aplicado com sucesso para: " + p.name);
  }

  public static void applyPreset(NVVisionBoostCore.Config c, Preset p) {
    if (c == null || p == null) {
      NVVisionBoostLogger.logFailure("Aplicar Preset", "Configuração ou Preset nulo fornecido.");
      return;
    }
    c.gpuPreset = p.name;
    c.gpuPresetApplied = true;
    c.profile = p.profile;
    c.targetFps = p.targetFps;
    c.renderDistance = p.renderDistance;
    c.maxRenderDistance = Math.max(c.maxRenderDistance, p.renderDistance);
    c.entityDistancePercent = p.entityDistance;
    c.renderScalePercent = p.renderScale;
    c.animationLevel = p.animationLevel;
    c.transparencyLevel = p.transparencyLevel;
    c.reduceParticles = p.particles;
    c.disableClouds = p.cloudsOff;
    c.disableEntityShadows = p.entityShadowsOff;
    c.reduceShaderEffects = p.shaderEffects;
    c.dynamicResolution = p.dynamicResolution;
    c.upscalingEnabled = p.renderScale < 100;
    tailor(c, p);
    NVVisionBoostLogger.logSuccess("Preset padrão aplicado com sucesso para: " + p.name);
  }

  private static void tailor(NVVisionBoostCore.Config config, Preset preset) {
    NVVisionBoostHardwareBudget.constrain(config);
    long memory = preset.vramGB * 1024L;
    Info info = DETECTED;
    if (info != null
        && info.totalMemoryMB > 0
        && norm(info.name).contains(norm(preset.name).replaceAll("[0-9]+gb$", "")))
      memory = info.totalMemoryMB;
    if (memory > 0 && memory < 6144) {
      config.renderDistance = Math.min(config.renderDistance, 10);
      config.renderScalePercent = Math.min(config.renderScalePercent, 80);
      config.upscalingEnabled = config.renderScalePercent < 100;
    }
    // Recomendações pendentes: só alteram shaders quando o usuário aplica.
    config.shaderShadowQuality =
        memory <= 0
            ? (preset.profile.equals("low") ? 1 : 2)
            : memory < 6144 ? 1 : memory < 12288 ? 2 : 3;
    config.shaderReflectionQuality =
        memory <= 0 ? (preset.profile.equals("low") ? 1 : 2) : memory < 8192 ? 1 : 2;
    NVVisionBoostCore.log(
        "Preset personalizado: "
            + preset.name
            + " | "
            + NVVisionBoostHardwareBudget.detect().summary()
            + " | RD "
            + config.renderDistance);
  }

  public static void writePresetDatabase(Path root) {
    if (root == null) {
      NVVisionBoostLogger.logFailure("Escrever Base de Presets", "Caminho raiz nulo.");
      return;
    }
    try {
      Path out = root.resolve("gpu-presets.json");
      if (Files.isRegularFile(out)) {
        String old = Files.readString(out, StandardCharsets.UTF_8);
        if (old.contains("\"databaseVersion\": 5")
            && Files.isRegularFile(root.resolve("gpu-presets-nvidia.json"))
            && Files.isRegularFile(root.resolve("gpu-presets-amd.json"))
            && Files.isRegularFile(root.resolve("gpu-presets-intel.json"))) {
          NVVisionBoostLogger.logSuccess("Base de dados de presets já está atualizada (versão 5).");
          return;
        }
      }
      StringBuilder json = new StringBuilder();
      json.append("{\n")
          .append("  \"databaseVersion\": 5,\n")
          .append("  \"database\": \"NV Vision Boost GPU + CPU + Java RAM presets\",\n")
          .append(
              "  \"note\": \"Suggested starting points; target FPS is not a benchmark; vramGB=0"
                  + " means unknown or shared\",\n")
          .append("  \"presets\": [\n");
      List<Preset> presetList = presets();
      for (int i = 0; i < presetList.size(); i++) {
        Preset preset = presetList.get(i);
        json.append("    {\"name\":\"")
            .append(NVVisionBoostIO.jsonString(preset.name))
            .append("\",\"brand\":\"")
            .append(NVVisionBoostGpuCatalog.classify("", preset.name).brand())
            .append("\",\"type\":\"")
            .append(NVVisionBoostGpuCatalog.classify("", preset.name).type())
            .append("\",\"architecture\":\"")
            .append(NVVisionBoostIO.jsonString(preset.architecture))
            .append("\",\"family\":\"")
            .append(NVVisionBoostIO.jsonString(preset.family))
            .append("\",\"vramGB\":")
            .append(preset.vramGB)
            .append(",\"targetFps\":")
            .append(preset.targetFps)
            .append(",\"renderDistance\":")
            .append(preset.renderDistance)
            .append(",\"entityDistance\":")
            .append(preset.entityDistance)
            .append(",\"renderScale\":")
            .append(preset.renderScale)
            .append(",\"animationLevel\":")
            .append(preset.animationLevel)
            .append(",\"transparencyLevel\":")
            .append(preset.transparencyLevel)
            .append(",\"profile\":\"")
            .append(NVVisionBoostIO.jsonString(preset.profile))
            .append("\"}");
        if (i + 1 < presetList.size()) json.append(',');
        json.append('\n');
      }
      json.append("  ]\n}\n");
      NVVisionBoostIO.writeUtf8(out, json.toString());
      var combined = com.google.gson.JsonParser.parseString(json.toString()).getAsJsonObject();
      for (var brand : NVVisionBoostGpuCatalog.Brand.values()) {
        if (brand == NVVisionBoostGpuCatalog.Brand.UNKNOWN) continue;
        var subset = new com.google.gson.JsonArray();
        for (var entry : combined.getAsJsonArray("presets"))
          if (entry.getAsJsonObject().get("brand").getAsString().equals(brand.name()))
            subset.add(entry);
        var database = new com.google.gson.JsonObject();
        database.addProperty("databaseVersion", 5);
        database.addProperty("brand", brand.name());
        database.add("note", combined.get("note"));
        database.add("presets", subset);
        NVVisionBoostIO.writeUtf8(
            root.resolve("gpu-presets-" + brand.name().toLowerCase(Locale.ROOT) + ".json"),
            new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(database) + "\n");
      }
      NVVisionBoostLogger.logSuccess("Arquivo 'gpu-presets.json' gerado e salvo com sucesso.");
    } catch (IOException e) {
      NVVisionBoostLogger.logError("Escrever Base de Presets (gpu-presets.json)", e);
    }
  }

  static boolean memoryExtensionAllowed(
      NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati) {
    return (brand == NVVisionBoostGpuCatalog.Brand.NVIDIA && nvx)
        || (brand == NVVisionBoostGpuCatalog.Brand.AMD && ati);
  }

  /** User-requested diagnostics; no polling, allocations or driver calls in the frame loop. */
  public static String memoryDiagnostics() {
    if (!RenderSystem.isOnRenderThread())
      return "Diagnóstico disponível somente na thread gráfica.";
    Info info = detect();
    if (!info.nativeMemorySupported)
      return "Driver sem extensão de memória compatível; capacidade não estimada.";
    if (info.brand == NVVisionBoostGpuCatalog.Brand.NVIDIA) {
      long total = GL11.glGetInteger(0x9047) / 1024L;
      long available = GL11.glGetInteger(0x9049) / 1024L;
      return "NVIDIA NVX: dedicada " + total + " MiB | livre aprox. " + available + " MiB";
    }
    try (var stack = org.lwjgl.system.MemoryStack.stackPush()) {
      var values = stack.mallocInt(4);
      GL11.glGetIntegerv(0x87FB, values);
      return "AMD ATI_meminfo: pool VBO livre aprox. "
          + values.get(0) / 1024L
          + " MiB | não representa VRAM total";
    }
  }

  private static String[] run(String activeName) {
    Process process = null;
    try {
      process =
          new ProcessBuilder(
                  "nvidia-smi",
                  "--query-gpu=name,driver_version,memory.total,memory.free",
                  "--format=csv,noheader,nounits")
              .redirectErrorStream(true)
              .start();
      if (!process.waitFor(2, TimeUnit.SECONDS)) {
        process.destroyForcibly();
        NVVisionBoostLogger.logFailure(
            "Execução nvidia-smi", "Tempo limite esgotado (timeout) ao consultar o driver NVIDIA.");
        return null;
      }
      String output =
          new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
      if (output.isEmpty() || output.toLowerCase(Locale.ROOT).contains("failed")) {
        NVVisionBoostLogger.logFailure(
            "Execução nvidia-smi", "A saída retornou vazia ou com falha de comando.");
        return null;
      }
      for (String line : output.split("\\R")) {
        String[] parts = line.split(",\\s*");
        if (parts.length >= 4 && norm(parts[0]).equals(norm(activeName))) return parts;
      }
      return null;
    } catch (IOException e) {
      NVVisionBoostLogger.logFailure(
          "Execução nvidia-smi",
          "Comando não encontrado ou sem permissão de execução (IOException).");
      return null;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      NVVisionBoostLogger.logFailure("Execução nvidia-smi", "Processo interrompido.");
      return null;
    } finally {
      if (process != null && process.isAlive()) process.destroyForcibly();
    }
  }

  private static long pl(String s) {
    try {
      return Long.parseLong(s.replaceAll("[^0-9]", ""));
    } catch (Throwable t) {
      NVVisionBoostLogger.logError("Conversão numérica de VRAM (pl)", t);
      return -1;
    }
  }

  private static String norm(String s) {
    return s == null
        ? ""
        : s.toLowerCase(Locale.ROOT)
            .replace("/pcie/sse2", "")
            .replace("/sse2", "")
            .replace("nvidia", "")
            .replace("geforce", "")
            .replace("amd", "")
            .replace("radeon", "")
            .replace("intel", "")
            .replace("laptopgpu", "")
            .replace("laptop", "")
            .replace("mobile", "")
            .replace("notebook", "")
            .replace("graphics", "")
            .replace("(tm)", "")
            .replace("(r)", "")
            .replace(" ", "")
            .replace("-", "")
            .replace("_", "");
  }
}
