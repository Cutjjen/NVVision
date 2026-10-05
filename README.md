# NVVision — Cutjjen

Client-side graphics optimization controls and a companion addon for CPU-related visual budgets. Shared policies, configuration and UI connect to Minecraft through version-specific loader and rendering adapters.

Press **F8** or use **Options → NVVisionBoost** to open settings. The menu supports Brazilian Portuguese and English, hardware-oriented presets, individual controls and explanatory tooltips. The addon limits local visual entity distance and native particles; it does not change server simulation or rewrite the mod loader.

## Project map

- `source/modules/mod`: shared configuration, UI, rendering policies and integration services.
- `source/modules/addon`: CPU policies, option ownership and configuration services.
- `source/adapters`: loader entry points, events and Minecraft API differences.
- `config/sources.json`: source-to-target registry with SHA-256 checksums.
- `config/versions.json`: supported targets, Java versions and dependencies.
- `gradle/target.gradle`: platform preparation, source staging and packaging rules.
- `docs/ARCHITECTURE.md`: responsibilities and maintenance guide.
- `docs/FUNCOES.md`: generated class/method index with source locations and available contracts.
- `docs/SOURCE-MAP.md`: generated implementation, test and resource inventory for every target.
- `docs/CURSEFORGE.md`: publication description and metadata guide.
- `COPYRIGHT.md`: authorship and existing licensing boundaries.

Identical registered sources can serve multiple targets. API differences remain explicit; an adapter does not make an artifact compatible with arbitrary game versions or different loaders.

## Build and verification

Use a full JDK to run the Gradle Wrapper. Java toolchains select the required compiler for each registered target.

```powershell
./gradlew.bat "-Ploader=forge" build
./gradlew.bat "-Ploader=neoforge" "-Pminecraft=1.21.1" build
./gradlew.bat "-Ploader=fabric" "-Pminecraft=26.2" build
```

Forge requires production remapping. Older Fabric targets use Loom remapping; unobfuscated targets do not. NeoForge uses ModDevGradle. Complete Gradle platform builds currently encounter a documented cache-access limitation in this environment; delivered artifacts use the validated compiler/remapper workflow. See `docs/VALIDACAO.md` for the historical record.

Run formatting, registry checks, adapter checks, policy regressions and production-link verification before publishing. Automated checks do not replace visual testing in the target modpack.

## Compatibility and limits

Iris/Oculus own shader execution. Optional integrations detect installed mods and restrict unsupported interventions. Other mods' particle renderers may not follow native settings. Empty UI background overrides intentionally prevent extra blur and are required.

The addon preserves player choices and releases an option when another component changes it. Generated-cache refreshes retain configuration. DLSS and frame generation are not implemented. Performance requires in-game measurement. The user associated the NeoForge 1.21.1 visual issue with All the Mods 10 and requested retaining the renderer unchanged.

The settings footer provides compatibility troubleshooting guidance in both languages. Its information button explains how to test advanced optimizer options one at a time, without automatically editing other mods' settings. See `docs/COMPATIBILITY-NOTICE.md`.

## Releases

This is the canonical source directory. Compiled pairs belong under `Modloaders/<loader>/<Minecraft>/<release>`. Both components receive the same numeric version on updates; prior releases remain available. `Modloaders/ATUAIS.json` identifies current pairs. Do not generate additional ZIP archives.

Current source contracts and public maintenance documentation use English. Historical investigation/release records retain their original language; player-facing Brazilian Portuguese remains available.

## Release numbering

All thirteen maintained sets use version 0.8.16 for both NVVision and its addon. Each artifact retains its loader and Minecraft target. See [PORTS-0.8.16.md](docs/PORTS-0.8.16.md) for the target matrix, legacy capability limits and adapter maintenance policy.
