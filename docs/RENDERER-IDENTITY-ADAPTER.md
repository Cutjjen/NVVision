# Renderer identity adapter — 0.8.22

The shared Java 8-compatible NVVisionBoostRendererAdapter is bound to all 13 maintained targets. Each loader supplies its own mod-presence predicate. The adapter prefers Embeddium when aliases coexist, then Sodium. Forge 1.19.2 explicitly enables legacy Rubidium detection. Forge 1.12.2 retains its native renderer mode and does not require modern renderer mods.

## Responsibilities and boundaries

Identity detection does not load private renderer options classes. Existing Minecraft framebuffer, shader, loader and presentation adapters retain their version-specific responsibilities. Missing required renderer alternatives are handled by the client dependency gate. Renderer patch pins were removed where appropriate; Minecraft, loader and shader dependencies still apply.

This is not a binary translator between arbitrary renderer versions. Iris/Oculus and renderer releases must be mutually compatible. Unknown renderer internals must be checked before adding integrations. No universal compatibility or measured FPS improvement is claimed.

## Verification

Seven identity cases cover missing renderers, Sodium, Embeddium, aliases, shader-only installation and Rubidium opt-in/out. Compilation, applicable OpenGL/ownership, GUI, localization and CPU regressions passed. Production bytecode references and packaged Mixin declarations were checked separately. New 0.8.22 binaries still require in-world testing.

## Target matrix

| Loader | Minecraft | Java |
|---|---|---|
| forge | 1.20.1 | 17 |
| fabric | 26.2 | 25 |
| neoforge | 26.1.2 | 25 |
| neoforge | 26.2 | 25 |
| fabric | 1.21.10 | 21 |
| neoforge | 1.21.10 | 21 |
| neoforge | 1.21.1 | 21 |
| fabric | 1.21.1 | 21 |
| fabric | 1.20.1 | 17 |
| fabric | 1.19.2 | 17 |
| forge | 1.19.2 | 17 |
| forge | 1.12.2 | 8 |
| neoforge | 1.20.1 | 17 |
