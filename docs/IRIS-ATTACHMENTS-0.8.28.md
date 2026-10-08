# Fabric 1.21.1 — Iris attachment reallocation

Author: Cutjjen. Release: mod and addon 0.8.28.

## Trigger and boundary

The user reported disappearing world textures after changing internal scale with Iris shaders enabled. Native rendering and upscaling without a shader remained functional. Linear reconstruction reproduced the symptom, excluding sharpening as a necessary trigger.

## Correction

TextureTarget.resize destroys and reallocates internal attachments. OpenGL names may be reused, so comparing only texture integers cannot establish allocation identity. Iris caches both its final color texture identity and depth buffer version. The previous NVVision implementation invalidated depth only when texture integers differed and did not invalidate final color after allocation.

NVVisionBoostShaderAttachmentAdapter resolves the required Iris capabilities and invalidates both caches once after reallocation, before Iris begins its normal world pass. Iris retains ownership of framebuffer reattachment, pack sizes, shader execution and resource creation. Capability lookup includes superclasses and validates field types before writes. Unsupported layouts enter the existing native recovery path rather than continuing with unsafe attachments.

## Source wiring

The Fabric 1.21.1 renderer marks allocations dirty in recreateTarget. synchronizeShaderDepthTarget consumes that marker only after obtaining the real shader pipeline and completing invalidation. Both canonical catalogs register the adapter and its standalone regression test. Other loader targets are untouched.

## Validation and limits

Compilation of mod and addon, seven generation/cache regression checks, 102 real OpenGL checks, UI/CPU regressions, 32 production Mixin checks and 640 Minecraft symbol references passed. These checks verify the correction and binaries; they do not reproduce the complete Iris shaderpack inside Minecraft. The user subsequently confirmed that this release works perfectly in Minecraft with Iris shader upscaling. No FPS gain is claimed and no user installation was modified.
