# Hardware controls and version adapters — 0.8.27

Author: Cutjjen. This update ports the user-validated Forge 1.20.1 0.8.26 control design to every maintained target. Previous release folders remain intact.

## Shared stages

1. Loader entry initializes its typed PlatformAdapter and preserves client-only operation. No new network protocol or requirement on other players is introduced.
2. RendererAdapter identifies Sodium, Embeddium or supported Rubidium. Shader adapters preserve the external Iris/Oculus pipeline. Their own dependency constraints remain authoritative.
3. BridgeCpuOptimizer loads the existing CPU profile and independent visual choices. CpuTestBudgets loads the historical cpu-test.properties name to retain preferences. Both files use atomic writes and preserve independent controls.
4. A client tick applies queued entity and particle-density changes through reversible option leases. Simulation distance is capped only when an integrated server exists. Remote simulation is never changed.
5. Main-mod controllers yield equivalent CPU options whenever the addon is present, even when its profile is off. Without the addon, saved basic controls become available again. Equivalent controls are not applied twice.
6. The particle admission hook filters only newly added particles beyond the selected camera radius. It does not cancel particle simulation globally. The model hook skips only supported block-entity presentations outside their radius, protecting off-screen renderers and unknown namespaces.
7. GPU controls remain separate from CPU changes. Renderer transitions are queued for a render-thread frame boundary; CPU buttons never recompile shaderpacks or resize GPU buffers from an input callback.
8. GPU, Processor and RAM pages expose their own controls. Addon diagnostics are read-only and do not duplicate controls. Heap diagnostics are on demand and never force garbage collection. FerriteCore configuration is offered only in backends already providing its configuration service.

## Adapter boundaries

| Boundary | Maintained implementations | Responsibility |
|---|---|---|
| Loader | Forge, Fabric, NeoForge | Events, mod identity and directories |
| MinecraftVersionAdapter | 1.19.2/1.20.1, 1.21.1, 1.21.10, 26.1.2, 26.2 | Main target, notifications, screen navigation and camera position |
| Immediate model hook | 1.19.2, 1.20.1, 1.21.1 | Registry differences and immediate camera coordinates |
| Extracted model hook | 1.21.10; 26.1.2/26.2 | Native submission state and its CameraRenderState coordinate space |
| Particle hook | Modern maintained targets | Particle admission and shared CPU policy |
| Legacy Java 8 | Forge 1.12.2 | Native pages, reversible graphic settings, particles and vanilla living-entity visual distance |

The extracted model adapters use the camera supplied to the native submission, avoiding a live-camera/extracted-state mismatch. Typed source bindings select APIs at build time rather than guessing methods each frame. A new Minecraft port must bind its actual API family, compile and pass production-link/Mixin checks. Adapters reduce duplication; they do not guarantee compatibility with arbitrary future releases.

## Controls and protections

Modern addon CPU controls: entity distance, particle density, local simulation (off/10/6 chunks), block-entity model radius (off/64/32 blocks), particle radius (off/32/16 blocks). Model namespaces are deliberately limited to minecraft, ironchest, sophisticatedstorage and storagedrawers. Models yield to Create, Flywheel, Distant Horizons and active external shaders. Entities and particles remain visual controls; no mob AI or machine tick suspension is added.

Forge 1.12.2 retains its verified legacy capabilities: GPU presets, addon particle density and visual vanilla living-entity distance, plus a basic particle fallback without the addon. Its RAM page is diagnostic. Independent simulation distance, modern model budgets and spatial upscaling are unavailable there and are not represented as working options.

Main-mod buffer recovery remains enabled. The previously observed Forge rendering failure was not reproduced in the user-validated 0.8.26 session; its root cause is not claimed resolved here. Existing shaders, textures, worlds and configuration files are not deleted.

## Validation

All 13 target pairs are compiled and checked against their version-specific production Minecraft API. Modern targets run CPU policy, ownership, configuration, layout, localization and real-context OpenGL regressions. Legacy targets are remapped to their production namespace; Java 8 tests run on Java 8. tools/check_hardware_menu.py checks every target's callback and ownership wiring.

The shared behavior is based on the user's validated Forge 1.20.1 implementation. New 0.8.27 ports still require visual in-world acceptance in each modpack; automated tests do not establish a measured FPS gain. DLSS and frame generation remain unavailable. No full platform Gradle assemble is claimed for this cached-tool compilation run.

Manual acceptance: test with and without the addon; verify CPU basics disappear with it, profile off remains off, each choice persists after reopening F8, local simulation changes while remote simulation stays untouched, and the GPU/shader/HUD path remains aligned below 100% scale. Use the same scene and shader for performance comparisons.
