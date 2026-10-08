# Execution stages and ownership contracts

This guide describes the maintained implementation. It does not claim that every renderer release is compatible, that a driver is replaced, or that a performance gain was measured. The source registry is authoritative; each target binds explicit main sources, tests and metadata.

## 1. Loader entry and client isolation

Forge, Fabric and NeoForge entry points connect to their own lifecycle APIs. PlatformAdapter exposes directories, client side and mod identities. Dedicated servers must not initialize GPU objects. Multiplayer compatibility is client-local; the addon introduces no required network channel or shared-world mutation.

## 2. Renderer discovery and dependency gate

NVVisionBoostRendererAdapter accepts a loader-provided mod predicate. It resolves explicit Embeddium identity before Sodium aliases. Rubidium is opt-in only for the audited Forge 1.19.2 path. Missing required renderers show the local dependency screen. Forge 1.12.2 remains native and does not require nonexistent modern renderer ports.

The adapter does not reference SodiumGameOptions, PerformanceSettings or other private renderer classes. Exact renderer patch pins are unnecessary for that boundary and have been removed. Minecraft version, Java level and loader constraints remain target-specific. Iris/Oculus impose their own renderer requirements; NVVision cannot translate their conflicting Mixins.

## 3. Configuration and upgrade boundaries

Load preferences before applying presets. Normalize individual fields while preserving independent values. Update generated caches without deleting user preferences, worlds or resource packs. Numeric mod/addon versions match per release. Runtime core versions, loader metadata and the manifest must agree. BuildIdentity reads the addon report version from the packaged manifest; development class directories report development.

## 4. Render-thread preparation

GPU capability queries and OpenGL inspection run with the rendering context current. Bridge inspection waits for a valid color target, then completes once. A failed inspection preserves the active renderer and prevents continuous retries. CPU initialization remains independent: its tick continues after inspection completes. The NeoForge 26.1.2 correction prevents per-frame reports, allocations and file writes.

## 5. Resolution policy

Select the internal scale under the existing target-specific policy. Menus, resource reloads, shader transitions and unsupported states retain native rendering. GPU timing and frame policies do not constitute a measured benefit without a controlled benchmark. Create/Flywheel and Distant Horizons safety rules remain in place.

## 6. World-target lease

Capture attachment IDs, dimensions, filters and relevant depth/stencil state through the version's RenderTargetAdapter. Preserve the identity of Minecraft's main target. Render only the world portion using the internal budget, then restore the original target before GUI presentation. MinecraftGlStateAdapter reconciles tracked and actual GL bindings. Depth transfers use compatible sizes and NEAREST filtering; restore framebuffer and scissor state on every exit path.

## 7. Shader ownership

Iris/Oculus own shaderpack compilation and execution. NVVision observes pipeline changes and adapts its own resources. It never replaces the external shader renderer or forces unsafe shader recompilation from a CPU menu action. Unsupported contracts fall back conservatively; third-party shader resource errors remain distinguishable from NVVision failures.

## 8. CPU visual policy

CpuPolicy normalizes profiles and calculates local visual ceilings. BridgeCpuOptimizer queues choices for the client thread. CpuOptionLease tracks ownership so external edits are not repeatedly overwritten. Controls affect presentation choices such as particle density and entity distance, not server simulation or thread affinity. The expected tradeoff is lower visual work; a measured CPU/FPS reduction is not assumed.

## 9. Interface and localization

F8 and the Options entry open the same configuration surface. Placement policies avoid occupied widgets and adapt to available GUI bounds. Layout, focus, scroll and tooltips retain their contracts. Player-facing Portuguese/English content remains localized; implementation comments and technical documentation use English. An empty framework override may intentionally suppress background blur or block Escape and must not be removed merely because its body is empty.

## 10. Shutdown and diagnostics

Release temporary CPU option ownership and allow Minecraft to save worlds normally. Do not delete runtime data during shutdown. Diagnostics record transitions instead of repeating identical messages per frame. Reports identify capability state accurately: OpenGL remains the active backend in the public build, while DLSS and frame generation are unavailable.

## Maintenance and verification

Update the source binding and Java adapter when Minecraft APIs change; do not copy a complete target blindly. Run checkSources, checkRendererAdapters, formatCheck, generated function/source inventories, Java compilation, GL/lease/UI/CPU regressions and production reference checks. Inspect loader-declared Mixin resources in each distributable. Preserve historical release folders. A new compiled release still requires in-world visual verification even when prior versions were user-validated.

## Shared CPU budgets and hardware pages (0.8.27)

See [hardware adapters](HARDWARE-ADAPTERS-0.8.27.md). The modern addon also offers integrated-server simulation distance, particle admission radius and protected block-entity model distance. Remote server simulation remains untouched. The legacy Java 8 adapter exposes only verified legacy capabilities.
