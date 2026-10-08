# NeoForge 1.21.1 — Iris attachment correction

Author: Cutjjen. Mod and addon: 0.8.28.

The user reproduced disappearing textures after changing internal scale with Iris on NeoForge 1.21.1 0.8.27. This renderer retained the allocation-cache gap already corrected and user-validated on Fabric 1.21.1.

Both loaders now bind the identical NVVisionBoostShaderAttachmentAdapter and regression test under modules/mod/integrations/shader-attachments. NeoForge marks internal attachments dirty before reallocation and consumes that marker only after successfully invalidating Iris final-color and depth caches. Integer texture reuse cannot bypass invalidation. Iris retains resource ownership and performs its normal reattachment on the following world pass. Unsupported reflective layouts follow the existing native-resolution recovery path.

Inspection confirmed the expected capabilities in the user's installed Iris NeoForge 1.8.14-beta.1. Compilation, seven allocation checks, 102 real OpenGL checks, CPU/UI regressions, 24 named Mixin checks and 693 production Minecraft references passed. The user confirmed this NeoForge release works perfectly with Iris shader upscaling. Previously validated Fabric binaries and all historical releases are unchanged. No shaderpack, world or user configuration was modified and no FPS gain is claimed.
