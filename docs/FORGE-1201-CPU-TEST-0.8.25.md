# NVVision CPU test — Forge 1.20.1 / 0.8.25

Author: Cutjjen. Java 17. Mod and addon must be installed together. This is an opt-in test release; previously validated builds remain unchanged. Existing renderer requirements and optional Oculus integration remain in place. No DLSS or frame generation is implemented.

## Controls

Open F8, Integrations, Addon CPU controls. Existing profiles remain available. Individual choices select the custom profile. The new budgets start disabled, preserve unrelated configuration keys and are stored in config/nvvisionboost/vulkan-bridge/cpu-test.properties.

| Control | Choices | Actual scope |
|---|---|---|
| Entities | off, 75%, 50% | Existing native visual distance; entity AI and server ticks continue. |
| Particle amount | off, decreased, minimal | Existing vanilla density option; custom mod engines may ignore it. |
| Local simulation | off, 10, 6 chunks | Caps the player's simulation option only with an integrated server. Can reduce active farms/machines beyond the active area. Never edits remote servers. |
| Animated block models | off, 64, 32 blocks | Limits standard block-entity drawing for Minecraft, Iron Chests, Sophisticated Storage and Storage Drawers namespaces. Does not simplify baked block meshes. |
| Particle range | off, 32, 16 blocks | Rejects distant particles entering Minecraft ParticleEngine before their tick/render queues. Distant visual cues may disappear; independent mod particle engines are not covered. |

## Adapters and protections

CpuTestPolicy is a pure policy adapter with explicit namespace scope. CpuTestBudgets owns persistence, client-tick application and reversible simulation ownership. NVVisionBoostCpuTestAdapter bridges the optional addon using cached budgets and batched counters. The mod uses standard ParticleEngine and BlockEntityRenderDispatcher hooks; private mod rendering internals are not rewritten.

Model filtering is suspended when shaders are enabled, or Create, Flywheel or Distant Horizons is present. Off-screen/long-distance block-entity renderers are preserved. Namespace scope is an implementation boundary, not proof that every release of those mods has been tested. No model filtering is attempted for unknown namespaces. The CPU addon retains shader-safe option transition coordination. Remote server AI, random ticks, block ticks and machine processing are not throttled or disabled.

## Logs and comparison

The main Minecraft latest.log contains [CPU test] lines approximately every 30 seconds while new budgets are active. Fields distinguish localServer, client simulation choice, requested simulation, applied model radius, compatibility protection and rejected particle/skipped model counts. There is no per-particle log spam; counts are transferred in batches.

Compare the same scene and shader with the same FPS cap. Warm up for 60 seconds, observe for 180 seconds, then change one control at a time. First test with new budgets disabled; then particle range; then entity distance; then models with shaders off; finally local simulation. Do not treat a change in scene, generated terrain or shader compilation as an optimization measurement. On a remote server simulation should remain unchanged. Send latest.log and nvvisionboost.log after testing.

## Verification

Java 17 compilation and applicable regressions passed: shader pipeline, tracked OpenGL state, 66 target ownership checks, 108 real OpenGL checks, 2172 layout checks, 389 language checks, CPU policy/ownership/configuration and new opt-in budget boundaries. Configuration tests include default-off controls, button routing and unknown-key preservation. Production validation passed 32 Mixin checks and 750 Minecraft references, plus packaged Mixin resource and metadata checks.

No new in-world Minecraft/modpack benchmark has been performed. FPS improvements and compatibility with actual installed third-party mod versions remain to be validated. The addon dependency requires the 0.8.25 main mod to avoid silently mixing this test with an older hook implementation. No installed user game, modpack, world or configuration was modified by this task.

## Simulation ownership correction

The main performance controller now respects the explicit local simulation budget during normal option application and snapshot restoration. Ownership is part of the option signature, so enabling or releasing the addon budget updates the main controller. The addon still yields to genuine external option changes instead of repeatedly overriding another mod. Simulation changes no longer request a graphics reset. Remote servers remain unchanged.

Verification: Java compilation, CPU ownership/configuration regressions, 108 real-context OpenGL checks, 31 named mixin checks and 753 production Minecraft references passed. Source wiring checks cover both restoration paths. In-world validation of this correction is pending; no FPS gain is claimed.

Retest with simulation set to 6 chunks: close the menu, change another NVVision option, and wait at least 60 seconds. The [CPU test] log should retain simulation=6 requestedSimulation=6 unless another owner changes the option. Disable the budget and verify normal restoration.
