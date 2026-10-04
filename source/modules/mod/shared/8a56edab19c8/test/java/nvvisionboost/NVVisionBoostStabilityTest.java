package nvvisionboost;

import java.nio.file.Files;
import java.nio.file.Path;

public final class NVVisionBoostStabilityTest {
  private static int checks;

  private static void check(boolean result, String message) {
    if (!result) throw new AssertionError(message);
    checks++;
  }

  public static int run(Path testRoot) throws Exception {
    checks = 0;
    Path root = testRoot.resolve("version-cache");
    Files.createDirectories(root.resolve("shader-cache/nested"));
    Files.writeString(root.resolve("shader-cache/nested/old.bin"), "old compilation");
    for (String name :
        java.util.List.of(
            "nvvisionboost.json",
            "selected-shader.txt",
            "create-preset-backup.properties",
            "machine-profile.json",
            "custom.txt")) Files.writeString(root.resolve(name), "preferência " + name);
    Files.createDirectories(root.resolve("user-resources"));
    Files.writeString(root.resolve("user-resources/file"), "user resource");
    Files.writeString(root.resolve("shader-analysis.txt"), "old report");
    check(NVVisionBoostCacheMaintenance.update(root, "0.7.5"), "first upgrade cleans legacy cache");
    check(
        !Files.exists(root.resolve("shader-cache"))
            && !Files.exists(root.resolve("shader-analysis.txt")),
        "generated files removed");
    for (String name :
        java.util.List.of(
            "nvvisionboost.json",
            "selected-shader.txt",
            "create-preset-backup.properties",
            "machine-profile.json",
            "custom.txt"))
      check(
          Files.readString(root.resolve(name)).equals("preferência " + name), "preserves " + name);
    check(
        Files.readString(root.resolve("user-resources/file")).equals("user resource"),
        "unknown folders preserved");
    Files.createDirectories(root.resolve("shader-cache"));
    Files.writeString(root.resolve("shader-cache/new.bin"), "new compilation");
    check(!NVVisionBoostCacheMaintenance.update(root, "0.7.5"), "same version does not purge");
    check(Files.exists(root.resolve("shader-cache/new.bin")), "current cache retained");
    check(
        NVVisionBoostCacheMaintenance.update(root, "0.7.6")
            && !Files.exists(root.resolve("shader-cache")),
        "next version invalidates once");
    long used = 33L * 1024 * 1024;
    check(
        NVVisionBoostEntityBufferGuard.reclaimable(false, 2, used, false, true, true),
        "orphaned offset is reclaimable");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(true, 2, used, false, true, true),
        "active builder preserved");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(false, 2, used, true, true, true),
        "ready frame preserved");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(false, 2, used, false, false, true),
        "parent queue preserved");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(false, 2, used, false, true, false),
        "segment queue preserved");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(false, 0, used, false, true, true),
        "no outstanding batches no reset");
    check(
        !NVVisionBoostEntityBufferGuard.reclaimable(false, 2, 1024, false, true, true),
        "small buffers preserved");
    check(
        NVVisionBoostShaderEngine.canReusePipeline(true, "pack.zip", "pack.zip", true),
        "active same shader reuses pipeline");
    check(
        !NVVisionBoostShaderEngine.canReusePipeline(false, "pack.zip", "pack.zip", true),
        "disabled shader must activate");
    check(
        !NVVisionBoostShaderEngine.canReusePipeline(true, "old.zip", "new.zip", true),
        "changed shader must reload");
    check(
        !NVVisionBoostShaderEngine.canReusePipeline(true, "pack.zip", "pack.zip", false),
        "missing pack must reload");
    check(NVVisionBoostDependencies.accepts(true, false), "Embeddium alone accepted");
    check(NVVisionBoostDependencies.accepts(false, true), "Sodium alone accepted");
    check(
        !NVVisionBoostDependencies.accepts(false, false),
        "missing alternatives blocked even with optional shaders");
    check(
        NVVisionBoostDependencies.accepts(true, true),
        "presence policy is alternative, not both mandatory");
    return checks;
  }
}
