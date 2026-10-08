# Shared shader status adapter — 0.8.28

Author: Cutjjen.

All thirteen maintained renderer source bindings were audited. Fabric 26.2 contained an unconditional no-shader message. NeoForge 1.21.10, 26.1.2 and 26.2 formatted shader state conditionally but logged only when framebuffer restrictions changed, potentially retaining outdated diagnostics after shader activation.

Five modern targets now bind the same NVVisionBoostShaderStatusAdapter and regression test under modules/mod/integrations/shader-status. It distinguishes unavailable/disabled shaders, an enabled backend waiting for a live pipeline, and active Iris shaders. The complete diagnostic string is compared independently from scaling restrictions. Duplicated NeoForge formatting was removed. Older targets do not contain the faulty fixed diagnostic and retain their existing behavior.

New 0.8.28 pairs: Fabric 26.2; NeoForge 1.21.10, 26.1.2 and 26.2. Fabric 1.21.10 and 1.21.1 0.8.28 remain the exact user-validated binaries. Historical release folders are preserved.

Each new pair passed five shader-status cases, 51 real OpenGL checks, CPU/UI regressions, named Mixin verification and production Minecraft reference verification. Source hygiene passed for 460 registered files. Complete coverage and results: verification/SHADER-STATUS-ALL-0.8.28.json. Visual acceptance of the four new pairs remains pending. No user installation, shader pack, world or configuration was modified. No FPS gain is claimed.

User acceptance update: Fabric 26.2 mod/addon 0.8.28 confirmed fully functional. NeoForge acceptance remains pending. Tested binaries were not modified.

User acceptance update: NeoForge 1.21.10 mod/addon 0.8.28 confirmed fully functional; tested binaries unchanged. NeoForge 26.1.2 and 26.2 acceptance remains pending.
