# Unified release policy

NVVision and its companion addon use the same numeric version in all seven maintained target sets. The current release is 0.8.15; the next release increments the shared patch number. Historical folders keep their original identifiers.

| Loader | Minecraft | Java |
| --- | --- | --- |
| Forge | 1.20.1 | 17 |
| Fabric | 1.21.10 | 21 |
| Fabric | 26.2 | 25 |
| NeoForge | 1.21.1 | 21 |
| NeoForge | 1.21.10 | 21 |
| NeoForge | 26.1.2 | 25 |
| NeoForge | 26.2 | 25 |

Artifacts remain specific to their loader and Minecraft target. Shared numbering does not imply cross-loader binary compatibility. Loader entry points, game API bindings, rendering ownership and CPU policies retain their registered adapters. The Options screen adapter is now shared across all seven targets; lifecycle hooks remain target-specific.

Source checks, compilation, automated regressions, metadata and production reference checks are required before distribution. Visual in-game confirmation and FPS measurements are separate validation steps. No DLSS or frame generation support is provided.
