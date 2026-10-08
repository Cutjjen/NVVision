# Hardware-grouped interface — Forge 1.20.1 / 0.8.26

Author: Cutjjen. Canonical sources remain in this repository. This release changes only Forge 1.20.1.

## Navigation and option ownership

GPU owns the preset browser, graphical quality, internal scale, dynamic resolution and the nested shader/texture page. Processor owns visual entity distance, particle controls, local simulation budgets, block-entity model budgets, world distances, Create presets and background limits. RAM owns the Java memory guard, FerriteCore controls and on-demand heap diagnostics. Integrations and Help retain diagnostic navigation.

The optional addon selects one CPU control surface. When absent, saved basic controls are exposed and applied. When present, the addon controls replace equivalent basic controls regardless of the selected addon profile. Disabled addon controls remain disabled; saved base values are neither deleted nor silently applied. Main-controller application and restoration paths skip addon-owned entity, particle and simulation options. The base block-entity limit also yields. Weather particles, Create controls and background limits remain separate capabilities.

The addon diagnostics screen no longer repeats profile or individual setting buttons. Secondary CPU controls use explicit basic-control tags, independent of translated labels. Existing configuration files and renderer protections are retained. Buffer recovery remains enabled; this release does not claim to resolve the previously observed rendering crash.

## Verification and manual acceptance

Automated Java, CPU ownership/configuration, layout, language and real-context OpenGL regressions passed. Production references were checked. Source-wiring checks cover both addon-present and addon-absent branches. These checks do not replace launching Minecraft and inspecting the menu.

Test once with the addon and once without it. Confirm equivalent basic controls disappear only in the addon case. Adjust each addon option, close/reopen F8 and confirm persistence and actual logged values. With the addon profile off, confirm hidden base CPU settings do not reactivate. Verify GPU shader navigation, RAM controls, scrolling and both languages. No FPS improvement is claimed for this interface reorganization.

Validation update — 2026-10-07: the user confirmed successful functional tests and consolidated this Forge 1.20.1 pair. GPU/RAM/CPU navigation and addon control replacement are accepted for this tested environment. Previous pending-test statements describe the pre-validation state. No quantitative FPS gain is claimed. The previous crash cause remains unresolved; buffer recovery remains active by user instruction.
