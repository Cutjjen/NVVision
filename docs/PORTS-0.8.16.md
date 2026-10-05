# Paired ports and adapter boundaries

Created by Cutjjen. Both components use numeric release 0.8.16. Historical releases and user installations remain untouched.

| Loader | Minecraft | Java | Rendering backend |
| --- | --- | --- | --- |
| Forge | 1.12.2 | 8 | Native legacy renderer; optional third-party renderers remain responsible for their pipelines |
| Forge | 1.19.2 | 17 | Embeddium 0.3.18.1; Oculus 1.6.9 optional |
| Forge | 1.20.1 | 17 | Existing Embeddium/Oculus base |
| Fabric | 1.19.2 | 17 | Sodium 0.4.4 + Iris 1.6.11 |
| Fabric | 1.20.1 | 17 | Sodium 0.5.13 + Iris 1.7.6 |
| Fabric | 1.21.1 | 21 | Sodium 0.6.13 + Iris 1.8.8 |
| Fabric | 1.21.10 | 21 | Existing pinned Sodium/Iris pair |
| Fabric | 26.2 | 25 | Existing pinned Sodium/Iris pair |
| NeoForge | 1.20.1 | 17 | Legacy NeoForge 47.1.106 API; Embeddium/Oculus backend |
| NeoForge | 1.21.1 | 21 | Existing pinned Sodium/Iris pair |
| NeoForge | 1.21.10 | 21 | Existing pinned Sodium/Iris pair |
| NeoForge | 26.1.2 | 25 | Existing pinned Sodium/Iris pair |
| NeoForge | 26.2 | 25 | Existing pinned Sodium/Iris pair |

Exact platform coordinates and renderer versions are in `config/versions.json`. Do not substitute the latest Sodium for a pinned Iris/Sodium pair without checking Iris's declared dependency range. Fabric 26.1 remains discontinued; unsupported historical loader combinations are not generated.

## Minecraft and loader boundaries

Modern shared policies retain version-specific loader entry points, key registration, world boundaries, render-target leases and tracked OpenGL bindings. Fabric does not expose Forge's stencil methods or its private stencil flag. The Fabric stencil adapter inspects the actual attachment and requests an optional real extension only when present. Unsupported stencil ownership falls back safely instead of pretending that a packed target exists.

The 1.19.2 UI boundary forwards graphics operations to the original PoseStack. Its local widget and tooltip types supply modern conveniences without defining replacement classes inside Minecraft packages. The option snapshot preserves the native AmbientOcclusionStatus enum; registry, projection and FPS access use their actual legacy APIs. The FPS accessor is mapped into each production namespace.

NeoForge 1.20.1 uses `net.minecraftforge` lifecycle APIs and `mods.toml`. Its platform adapter identifies this as legacy NeoForge. The Gradle Legacy Forge extension uses its explicit `neoForgeVersion` setting; modern NeoForge entry points are not mixed into this target.

## Forge 1.12.2 capability boundary

The Java 8/LWJGL 2 port provides local graphics presets, particle reduction, CPU presets, independent particle/entity controls, reversible option ownership, GPU themes, F8, an Options entry when space permits, bilingual help and language flags. Entity reduction preserves players, bosses and mod entities and changes client rendering only. Configuration lives under the instance's own `config/nvvisionboost` directory. Shader targets and resource atlases are never reloaded when a CPU preset changes.

Spatial upscaling and dynamic resolution are unavailable in this first legacy port. Its menu displays native 100% rendering. No Embeddium, Oculus, Sodium or Iris dependency is declared for this target. OptiFine or other legacy renderers are not translated or modified. This is an explicit capability limit, not evidence of support for every renderer.

The legacy ForgeGradle 3/Java 8 wrapper lives in `tools/forge1122`; the main Gradle build delegates to it. This isolates the older toolchain from modern Gradle and Java. `JAVA8_HOME` is optional; Gradle's toolchain resolver supplies Java 8 when needed. The official MDK's MCP snapshot is used for readable sources and SRG production remapping.

## Validation and distribution

Every pair must pass compilation, applicable policy/UI/OpenGL regressions, exact loader metadata and production Minecraft references. New modern ports additionally verify mixin selectors, accessors and invokers against their runtime namespace. The Java 8 port runs configuration and option-ownership regressions on a real Java 8 runtime. Its production archive excludes regression classes.

The generated `VALIDACAO.json` beside each pair records the actual automated results. In-world visual behavior and FPS measurement remain pending in this round. Automated tests do not establish universal modpack compatibility. DLSS, frame generation and an OpenGL-to-Vulkan translation backend are not implemented.

NightConfig core/TOML are nested runtime libraries in the new Fabric ports. Their license notices and corresponding upstream source archives are preserved under `third-party/nightconfig` and included beside those distributed pairs. Minecraft, Iris and Sodium binaries are development inputs or external dependencies, not redistributed in the mod pair.
