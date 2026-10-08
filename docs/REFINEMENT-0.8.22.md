# Refinement release 0.8.22

All 13 maintained targets use the same numeric mod/addon version and the shared Java 8-compatible renderer identity adapter. This shares discovery policy, not Minecraft rendering implementations. Version-specific framebuffer and shader hooks remain isolated.

## Confirmed corrections

- NeoForge 26.1.2 now marks bridge inspection complete. Previously it inspected, formatted, logged and wrote its report on every frame; the supplied session contained 15,728 Client bridge messages.
- Addon report headers derive their version from manifest metadata instead of stale historical literals.
- No-op post-frame event subscriptions were removed from the three direct NeoForge event bridges. They had no presentation behavior.
- Identical registered Java implementations were rebound to one source. Obsolete files outside every maintained compilation registry were removed only after a source backup. The audit records exact removed paths and hashes.
- Renderer metadata no longer fixes an unnecessary Sodium/Embeddium patch. Required game/loader versions and external shader dependencies remain distinct.
- Mixin packaging validation now reads Fabric and NeoForge metadata in addition to manifest headers; this detects configurations declared outside the manifest too.

## Safety boundaries

No renderer-private classes are added, no shader pipeline is replaced and no server synchronization is introduced. Forge 1.12.2 keeps native rendering without upscaling. Rubidium detection remains specific to the legacy target where it was validated. No license text, user installation, world or runtime preference was intentionally changed.

Two unregistered legacy source paths could not be read/deleted due to filesystem access restrictions and remain preserved. They do not participate in any maintained build; no runtime compatibility claim is made for them.

## Review entry points

Start with EXECUTION-STAGES.md, ARCHITECTURE.md, RENDERER-IDENTITY-ADAPTER.md and SOURCE-MAP.md. FUNCOES.md links methods to their implementations. REFINEMENT-0.8.22-SOURCE-AUDIT.json records consolidation. Release validation records distinguish automated verification from user in-world approval.
