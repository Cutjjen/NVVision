# Architecture and responsibility map

## Startup and platform boundary

Loader entry points load local configuration, register client events and connect the menu. PlatformAdapter isolates mod detection and directories. Minecraft adapters isolate changing game APIs. Only registered targets and sources participate in builds.

## World rendering

The resolution controller chooses an internal pixel budget. Menus, reloads and incompatible pipeline states retain native resolution. RenderTargetAdapter captures and applies attachment state. WorldTargetLease exchanges ownership while preserving main-target identity. Restore ownership after the world pass and before final presentation/GUI rendering.

MinecraftGlStateAdapter reconciles actual OpenGL bindings with Minecraft's tracked state. NVVisionBoostDepthTransfer transfers depth/stencil with NEAREST filtering and restores bindings/scissor state. Each version retains its specific hooks, resource types and backend constraints. See RENDERING-ADAPTERS.md.

Iris/Oculus own shader execution. Preparation services read/index resources rather than replacing the backend. Create/Flywheel and Distant Horizons detection restricts unsafe interventions. Optional integrations must fail conservatively when supported APIs or schemas are absent.

## UI and persistence

Screens present localized controls and tooltips. Shared layout policies calculate usable bounds; Options placement respects other mods' widgets. Empty background overrides intentionally prevent native blur from obscuring text.

Configuration services preserve preferences and unknown properties. Cache refreshes invalidate generated resources rather than deleting preferences. Hardware catalogs guide presets; GPU identification does not establish support for unimplemented vendor technologies.

## CPU addon

- CpuPolicy: validate profiles, normalize values, calculate ceilings and cycle choices without game-state access.
- BridgeCpuOptimizer: load/save choices, schedule client-thread application and reevaluate at most once per second.
- CpuOptionLease: track temporary ownership; external edits stop overriding until release.
- CpuMinecraftAdapter: isolate changes such as particle-option enum packages.
- Loader bridge classes: register lifecycle callbacks and expose local integration state.

Presets affect visual entity distance and native particles, not server ticks or machine simulation. Workload-dependent savings require measurement.

## Maintenance

Share identical behavior through the registry; retain real API differences in adapters. Preserve entry points, reflection targets, mixin accessors and intentional no-op overrides unless reachability analysis proves them unnecessary.

For a port, verify actual signatures, adapt affected boundaries, register dependencies and sources, run regressions and production-mapping checks, then test visually. The generated method index identifies source locations; it is not proof of an individual audit of every method.
