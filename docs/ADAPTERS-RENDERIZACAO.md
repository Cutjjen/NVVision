# Rendering adapters

RenderTargetAdapter validates, captures and applies complete attachment state. WorldTargetLease borrows reduced attachments for the world pass while preserving main-target identity. Restoration returns native attachments and retains allocations made during the pass on the internal target, avoiding double ownership.

NVVisionBoostDepthTransfer transfers depth and available stencil with NEAREST filtering independently of color reconstruction. Restore read/write framebuffer bindings and scissor state. MinecraftGlStateAdapter reconciles authoritative driver bindings with Minecraft's tracked calls.

| Target family | Attachment representation |
| --- | --- |
| Forge 1.20.1 / NeoForge 1.21.1 | OpenGL IDs, framebuffer, viewport dimensions, filter and stencil flag |
| Fabric / NeoForge 1.21.10 | GpuTexture, GpuTextureView, dimensions and filter |
| NeoForge 26.1.2 | Texture/view references and immutable stencil capability |
| Fabric 26.2 | Texture/view references and target color format |
| NeoForge 26.2 | Texture/view references, color format and stencil capability |

Adapters preserve backend-specific hooks. They do not translate OpenGL to Vulkan or implement DLSS/frame generation.

## Porting sequence

1. Register loader, game, Java and dependencies; assign equal numeric mod/addon versions.
2. Verify target fields, accessor signatures and constructors against real platform libraries.
3. Adapt MinecraftAccess and world-entry/exit hooks. Finish all world passes before restoration; GUI remains native.
4. Register sources and mixins. Never replace the main object or close attachments while leased.
5. Run formatting, source, adapter, ownership, binding and filter checks; verify production mappings and test visually.
6. Publish a new paired release directory and preserve previous releases.

checkRendererAdapters checks contracts and paired numbering. Target-lease tests cover identity/ownership; GL adapter tests cover external-state recovery; OpenGL smoke tests exercise filters. Passing does not guarantee visual compatibility with every modpack.
