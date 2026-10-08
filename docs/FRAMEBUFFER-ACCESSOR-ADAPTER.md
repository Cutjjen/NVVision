# Framebuffer accessor adapter

A Mixin interface targeting a Minecraft class must contain only accessor/invoker declarations (static accessor stubs are supported). Default behavior methods change Mixin subtype classification and can fail during preLaunch.

NVVisionBoostRenderTargetAccessor reads/writes the actual color and depth attachment fields. The shared framebuffer-attachments module exchanges framebuffer IDs, textures, dimensions and filtering while preserving the main target object identity. Stencil is owned by the actual framebuffer image, not a synthetic vanilla flag. FabricStencilAdapter queries the GL attachment and requests a real optional extension only when present.

Targets using this contract: Fabric 1.19.2, 1.20.1, 1.21.1; Forge 1.19.2; legacy NeoForge 1.20.1. New ports should bind these source modules when their RenderTarget field layout matches, then validate mappings and run the OpenGL ownership tests.

Gradle checkRendererAdapters rejects default methods in RenderTarget accessor mixins. tools/CheckAccessorMixins.java inspects production bytecode for pure accessor contracts. This does not replace a full game startup/in-world test.

Merge conflicts were resolved in favor of the newer local framebuffer ownership, tracked OpenGL state, English source contracts and release metadata. Conflict inputs were preserved under .local/merge-backup-0.8.17; no installed game or historical release was changed.
