# Source cleanup and publication preparation — 2026-10-05

Updated the canonical source only. English Java/GLSL comments replace Portuguese technical descriptions; player-facing Brazilian Portuguese and historical investigation records remain available. Corrected obsolete Java versions and descriptions of target lifecycle/shader ownership.

Comment translation was checked against unchanged executable tokens before formatting. Runtime changes are limited to numeric release identification, publication descriptions and removal of an inactive NeoForge 1.21.1 legacy buffer guard. Its only production reference was a status report; its accessors were absent from the target mixin configuration. The active Forge guard and its regression coverage remain intact. NeoForge retains the applicable cache/dependency tests without Forge-only buffer assertions.

Seven byte-identical source groups now share registered implementations, including target leases, modern accessors, a Core variant and target-lease regressions. Genuine API variants remain separate. The registry contains 854 bindings and 300 Java files; the generated index identifies 2,718 methods. SOURCE-MAP.md covers implementations, tests and resources.

## Verified pairs

| Loader | Minecraft | Mod / addon |
| --- | --- | --- |
| Forge | 1.20.1 | 0.7.25 |
| Fabric | 26.2 | 0.8.3 |
| Fabric | 1.21.10 | 0.8.4 |
| NeoForge | 26.1.2 | 0.8.5 |
| NeoForge | 26.2 | 0.8.5 |
| NeoForge | 1.21.10 | 0.8.6 |
| NeoForge | 1.21.1 | 0.8.12 |

Formatting, source checksums, adapter contracts and CPU policies passed. All seven pairs compiled and passed applicable regressions, including real OpenGL-context checks. Production metadata, mixins and Minecraft links passed; published checksums cover all fourteen artifacts. Existing cache/dependency regressions passed 26 checks on Forge and 19 applicable checks on NeoForge 1.21.1.

No new game-launch or FPS measurement was performed. The reported NeoForge 1.21.1 reduced-resolution visual alignment defect remains under investigation. Cleanup and passing automated checks do not establish its resolution or a performance gain.

Previous releases, third-party notices, user installations and configurations are preserved. No new ZIP was generated. The existing MIT/All Rights Reserved declarations were retained; no uniform license or publication approval is asserted.
