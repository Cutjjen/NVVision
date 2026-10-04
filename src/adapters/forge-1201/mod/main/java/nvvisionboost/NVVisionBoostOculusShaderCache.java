/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Integração com shaders e outros mods.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostOculusShaderCache.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * NVVisionBoost - Oculus Shader Preparation Cache
 *
 * <p>IMPORTANTE:
 *
 * <p>Oculus continua sendo responsável por: - carregar shaderpacks; - selecionar shaderpacks; -
 * compilar o pipeline utilizado para renderização; - renderizar os shaders.
 *
 * <p>NVVisionBoost faz somente: - análise; - hashing; - indexação; - cache de preparação; -
 * validação GLSL opcional; - otimizações auxiliares.
 *
 * <p>Nenhum programa OpenGL criado aqui é injetado no Oculus.
 */
public final class NVVisionBoostOculusShaderCache {
  private record Cached(long stamp, Result result) {}

  private static final Map<Path, Cached> PREPARED = new LinkedHashMap<>();
  private static final long MAX_SHADER_FILE = 8L * 1024L * 1024L;

  private static final long MAX_TEXTURE_FILE = 64L * 1024L * 1024L;

  private static final int MAX_FILES = 100_000;

  private NVVisionBoostOculusShaderCache() {}

  public static final class Result {
    public final boolean success;

    public final String shaderName;

    public final String cacheId;

    public final Path cacheDir;

    public final int shaderFiles;

    public final int textures;

    public final int validated;

    public final int validationFailures;

    public final String message;

    Result(
        boolean success,
        String shaderName,
        String cacheId,
        Path cacheDir,
        int shaderFiles,
        int textures,
        int validated,
        int validationFailures,
        String message) {
      this.success = success;

      this.shaderName = shaderName == null ? "" : shaderName;

      this.cacheId = cacheId == null ? "" : cacheId;

      this.cacheDir = cacheDir;

      this.shaderFiles = shaderFiles;

      this.textures = textures;

      this.validated = validated;

      this.validationFailures = validationFailures;

      this.message = message == null ? "" : message;
    }

    public String summary() {
      return message
          + " | GLSL="
          + shaderFiles
          + " | texturas="
          + textures
          + " | validados="
          + validated
          + " | falhas="
          + validationFailures;
    }
  }

  private static final class EntryData {
    final String name;

    final String sourceHash;

    EntryData(String name, byte[] bytes) throws Exception {
      this.name = name;

      this.sourceHash = hex(MessageDigest.getInstance("SHA-256").digest(bytes));
    }
  }

  /**
   * Tenta descobrir o shaderpack atualmente configurado no Oculus.
   *
   * <p>Não existe dependência direta de compilação com Oculus. Reflection é utilizada para evitar
   * que NVVisionBoost deixe de carregar caso Oculus não esteja instalado.
   */
  public static Optional<Path> detectOculusShaderPack(Path gameDir) {
    if (gameDir == null) {
      return Optional.empty();
    }

    if (!NVVisionBoostCompatibility.oculus()) {
      return Optional.empty();
    }

    String shaderName = null;

    /*
     * Primeiro tenta IrisApi.
     *
     * Oculus deriva da arquitetura Iris, mas as APIs disponíveis
     * podem variar conforme a versão.
     */
    try {
      Class<?> apiClass = Class.forName("net.irisshaders.iris.api.v0.IrisApi");

      Object api = apiClass.getMethod("getInstance").invoke(null);

      Boolean active = invokeBoolean(api, "isShaderPackInUse");

      if (Boolean.FALSE.equals(active)) {
        return Optional.empty();
      }

      shaderName = invokeString(api, "getShaderPackName");

      if (shaderName == null || shaderName.isBlank()) {
        shaderName = invokeString(api, "getCurrentShaderPackName");
      }
    } catch (Throwable ignored) {
      /*
       * Não falhar se a API pública mudou.
       */
    }

    /*
     * Segunda tentativa:
     * usar a detecção já existente na camada
     * de compatibilidade.
     */
    if (shaderName == null || shaderName.isBlank()) {
      try {
        shaderName = NVVisionBoostCompatibility.externalShaderPackName();
      } catch (Throwable ignored) {
      }
    }

    /*
     * Fallback:
     * seleção persistida pelo NVVisionBoost.
     *
     * Isso NÃO significa que o NVVisionBoost está ativando
     * o shader. É somente uma referência para análise/cache.
     */
    if (shaderName == null || shaderName.isBlank()) {
      try {
        shaderName = NVVisionBoostShader.selected(gameDir.resolve("config/nvvisionboost"));
      } catch (Throwable ignored) {
      }
    }

    if (shaderName == null || shaderName.isBlank()) {
      return Optional.empty();
    }

    Path shaderpacks = gameDir.resolve("shaderpacks");

    Path direct = shaderpacks.resolve(shaderName).normalize();

    if (Files.exists(direct)) {
      return Optional.of(direct);
    }

    /*
     * Algumas APIs retornam o nome sem .zip.
     */
    if (!shaderName.toLowerCase(Locale.ROOT).endsWith(".zip")) {
      Path zip = shaderpacks.resolve(shaderName + ".zip").normalize();

      if (Files.exists(zip)) {
        return Optional.of(zip);
      }
    }

    /*
     * Comparação case-insensitive.
     */
    try {
      if (Files.isDirectory(shaderpacks)) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(shaderpacks)) {
          for (Path path : stream) {
            if (path.getFileName().toString().equalsIgnoreCase(shaderName)) {
              return Optional.of(path);
            }
          }
        }
      }
    } catch (IOException ignored) {
    }

    return Optional.empty();
  }

  public static Result compileOculusActive(Path gameDir) {
    Optional<Path> active = detectOculusShaderPack(gameDir);

    if (active.isEmpty()) {
      String message;

      if (NVVisionBoostCompatibility.oculus()) {
        message = "Oculus detectado, mas o shaderpack ativo " + "não pôde ser identificado.";
      } else {
        message = "Oculus não está carregado.";
      }

      return new Result(false, "", "", null, 0, 0, 0, 0, message);
    }

    return compileSelected(gameDir, active.get());
  }

  /**
   * Analisa e prepara o cache do shaderpack.
   *
   * <p>NÃO ativa o shader.
   */
  public static synchronized Result compileSelected(Path gameDir, Path shaderPack) {
    if (gameDir == null || shaderPack == null || !Files.exists(shaderPack)) {
      return new Result(false, "", "", null, 0, 0, 0, 0, "Shaderpack não encontrado.");
    }

    try {
      Path key = shaderPack.toAbsolutePath().normalize();
      long stamp = NVVisionBoostFileFingerprint.stamp(key);
      Cached existing = PREPARED.get(key);
      if (existing != null
          && existing.stamp() == stamp
          && existing.result().cacheDir.startsWith(gameDir.toAbsolutePath().normalize())
          && Files.isRegularFile(existing.result().cacheDir.resolve("READY")))
        return existing.result();
      List<EntryData> shaders = new ArrayList<>();

      List<String> textures = new ArrayList<>();

      MessageDigest packDigest = MessageDigest.getInstance("SHA-256");

      if (Files.isDirectory(shaderPack)) {
        readDirectory(shaderPack, shaders, textures, packDigest);
      } else if (shaderPack.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".zip")) {
        readZip(shaderPack, shaders, textures, packDigest);
      } else {
        return new Result(
            false,
            shaderPack.getFileName().toString(),
            "",
            null,
            0,
            0,
            0,
            0,
            "Formato de shaderpack não suportado.");
      }

      if (shaders.stream().noneMatch(e -> isShader(e.name.toLowerCase(Locale.ROOT)))) {
        throw new IOException("Shaderpack sem fontes GLSL reconhecidas.");
      }

      String cacheId = hex(packDigest.digest());

      Path cacheDir =
          gameDir
              .toAbsolutePath()
              .normalize()
              .resolve("config/nvvisionboost/shader-cache")
              .resolve(cacheId);

      Files.createDirectories(cacheDir);

      List<String> sourceHashes = new ArrayList<>();

      int validated = 0;

      int failures = 0;

      for (EntryData entry : shaders) {
        String sourceHash = entry.sourceHash;

        sourceHashes.add(sourceHash + "  " + entry.name);

        // Shaderpacks precisam de includes, macros e opções do backend.
        // Compilar cada arquivo cru gera falhas artificiais e o resultado
        // era destruído. Aqui apenas verificamos/leemos os recursos.
      }

      Collections.sort(sourceHashes);

      Collections.sort(textures);

      String shaderName = shaderPack.getFileName().toString();

      String manifest =
          "NVVisionBoost resource preparation cache v2\n"
              + "shader="
              + shaderName
              + "\n"
              + "sha256="
              + cacheId
              + "\n"
              + "shaderFiles="
              + shaders.size()
              + "\n"
              + "textures="
              + textures.size()
              + "\n"
              + "validated="
              + validated
              + "\n"
              + "validationFailures="
              + failures
              + "\n"
              + "rendererOwner=Oculus\n"
              + "gpuCompilation=backend-only\n"
              + "rawGlslValidation=disabled\n";

      Files.writeString(
          cacheDir.resolve("manifest.txt"),
          manifest,
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);

      Files.write(
          cacheDir.resolve("shader-sources.sha256"),
          sourceHashes,
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);

      Files.write(
          cacheDir.resolve("textures.txt"),
          textures,
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);

      Files.writeString(
          cacheDir.resolve("READY"),
          "ready\n",
          StandardCharsets.UTF_8,
          StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING);

      Result result =
          new Result(
              true,
              shaderName,
              cacheId,
              cacheDir,
              (int) shaders.stream().filter(e -> isShader(e.name.toLowerCase(Locale.ROOT))).count(),
              textures.size(),
              validated,
              failures,
              "Fontes, propriedades e texturas lidas. "
                  + "Compilação e upload GPU são executados pelo pipeline do backend.");
      if (PREPARED.size() >= 64) PREPARED.remove(PREPARED.keySet().iterator().next());
      PREPARED.put(key, new Cached(stamp, result));
      return result;
    } catch (Throwable t) {
      NVVisionBoostForge.log("Oculus shader cache: " + t);

      return new Result(
          false,
          shaderPack.getFileName().toString(),
          "",
          null,
          0,
          0,
          0,
          0,
          "Falha ao preparar cache: " + safeMessage(t));
    }
  }

  private static void readDirectory(
      Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)
      throws Exception {
    int count = 0;

    try (var stream = Files.walk(root)) {
      Iterator<Path> iterator = stream.filter(Files::isRegularFile).sorted().iterator();

      while (iterator.hasNext()) {
        Path path = iterator.next();

        count++;

        if (count > MAX_FILES) {
          throw new IOException("Shaderpack possui arquivos demais.");
        }

        String relative = root.relativize(path).toString().replace('\\', '/');

        String lower = relative.toLowerCase(Locale.ROOT);

        long size = Files.size(path);

        packDigest.update(relative.getBytes(StandardCharsets.UTF_8));

        packDigest.update(longBytes(size));

        if (isShader(lower) || isMetadata(lower)) {
          if (size > MAX_SHADER_FILE) {
            throw new IOException("GLSL excede 8 MB: " + relative);
          }

          byte[] bytes;
          try (InputStream input = Files.newInputStream(path)) {
            bytes = readBounded(input, MAX_SHADER_FILE);
          }

          packDigest.update(bytes);

          shaders.add(new EntryData(relative, bytes));
        } else if (isTexture(lower) && size <= MAX_TEXTURE_FILE) {
          // Leia o conteúdo real e aqueça o cache de arquivos do SO.
          // A criação das texturas GPU pertence ao pipeline carregado.
          try (InputStream input = Files.newInputStream(path)) {
            hashResource(input, MAX_TEXTURE_FILE, packDigest);
          }
          textures.add(relative + "\t" + size);
        }
      }
    }
  }

  private static void readZip(
      Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)
      throws Exception {
    int count = 0;

    try (ZipFile zip = new ZipFile(zipPath.toFile())) {
      List<? extends ZipEntry> ordered = Collections.list(zip.entries());
      ordered.sort(Comparator.comparing(ZipEntry::getName));
      Enumeration<? extends ZipEntry> entries = Collections.enumeration(ordered);

      while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();

        if (entry.isDirectory()) {
          continue;
        }

        count++;

        if (count > MAX_FILES) {
          throw new IOException("Shaderpack possui arquivos demais.");
        }

        String name = entry.getName().replace('\\', '/');

        Path safe = Path.of(name).normalize();

        if (safe.isAbsolute() || safe.startsWith("..")) {
          throw new IOException("Caminho inseguro no ZIP: " + name);
        }

        String lower = name.toLowerCase(Locale.ROOT);

        long size = entry.getSize();

        packDigest.update(name.getBytes(StandardCharsets.UTF_8));

        packDigest.update(longBytes(size));

        if (isShader(lower) || isMetadata(lower)) {
          if (size > MAX_SHADER_FILE) {
            throw new IOException("GLSL excede 8 MB: " + name);
          }

          byte[] bytes;

          try (InputStream input = zip.getInputStream(entry)) {
            bytes = readBounded(input, MAX_SHADER_FILE);
          }

          packDigest.update(bytes);

          shaders.add(new EntryData(name, bytes));
        } else if (isTexture(lower) && (size < 0 || size <= MAX_TEXTURE_FILE)) {
          try (InputStream input = zip.getInputStream(entry)) {
            hashResource(input, MAX_TEXTURE_FILE, packDigest);
          }
          textures.add(name + "\t" + size);
        }
      }
    }
  }

  private static boolean isMetadata(String name) {
    return name.endsWith(".properties") || name.endsWith(".json") || name.endsWith(".lang");
  }

  private static void hashResource(InputStream input, long limit, MessageDigest digest)
      throws IOException {
    byte[] buffer = new byte[32768];
    long total = 0;
    int count;
    while ((count = input.read(buffer)) != -1) {
      total += count;
      if (total > limit) throw new IOException("Textura excede o limite de leitura.");
      digest.update(buffer, 0, count);
    }
  }

  private static byte[] readBounded(InputStream input, long max) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    byte[] buffer = new byte[8192];

    long total = 0;

    int read;

    while ((read = input.read(buffer)) != -1) {
      total += read;

      if (total > max) {
        throw new IOException("Arquivo excede limite de segurança.");
      }

      output.write(buffer, 0, read);
    }

    return output.toByteArray();
  }

  private static boolean isShader(String name) {
    return name.endsWith(".vsh")
        || name.endsWith(".fsh")
        || name.endsWith(".gsh")
        || name.endsWith(".csh")
        || name.endsWith(".glsl")
        || name.endsWith(".vert")
        || name.endsWith(".frag");
  }

  private static boolean isTexture(String name) {
    return name.endsWith(".png")
        || name.endsWith(".jpg")
        || name.endsWith(".jpeg")
        || name.endsWith(".dds")
        || name.endsWith(".tga");
  }

  private static Boolean invokeBoolean(Object target, String methodName) {
    if (target == null) {
      return null;
    }

    try {
      Method method = target.getClass().getMethod(methodName);

      Object result = method.invoke(target);

      if (result instanceof Boolean) {
        return (Boolean) result;
      }
    } catch (Throwable ignored) {
    }

    return null;
  }

  private static String invokeString(Object target, String methodName) {
    if (target == null) {
      return null;
    }

    try {
      Method method = target.getClass().getMethod(methodName);

      Object result = method.invoke(target);

      if (result != null) {
        return result.toString();
      }
    } catch (Throwable ignored) {
    }

    return null;
  }

  private static byte[] longBytes(long value) {
    return new byte[] {
      (byte) (value >>> 56),
      (byte) (value >>> 48),
      (byte) (value >>> 40),
      (byte) (value >>> 32),
      (byte) (value >>> 24),
      (byte) (value >>> 16),
      (byte) (value >>> 8),
      (byte) value
    };
  }

  private static String hex(byte[] bytes) {
    StringBuilder result = new StringBuilder(bytes.length * 2);

    for (byte b : bytes) {
      result.append(String.format(Locale.ROOT, "%02x", b));
    }

    return result.toString();
  }

  private static String safeMessage(Throwable throwable) {
    String message = throwable.getMessage();

    if (message == null || message.isBlank()) {
      return throwable.getClass().getSimpleName();
    }

    return message;
  }
}
