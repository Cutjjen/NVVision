# Fabric 1.19.2 — 0.8.23

## Cause of the reported regression

The supplied run uses Fabric 0.19.5, Sodium 0.4.4 and Iris 1.6.6. Iris 1.6.6 exposes its public API under net.irisshaders.iris.api.v0 while its implementation remains under net.coderbot.iris. The previous compatibility facade assumed matching namespaces. As a result, shader activity was reported as false and the renderer pipeline gate stayed at native resolution despite saved scale changes.

## Adapter contract

NVVisionBoostIrisApiAdapter discovers the API independently without initializing backend classes. Pipeline reads accept a direct object or Optional and cache reflective methods by concrete manager type. Missing functions propagate to the existing safe fallback. This adapter can be bound to other targets after checking their loader, Minecraft and shader contracts; it does not promise arbitrary Iris release compatibility.

## Menu review

All six main tabs and the performance, CPU, mipmap, FerriteCore and language screens were reviewed. Seventeen reflective boolean toggles resolve to real configuration fields and runtime consumers. Scale controls use the renderer lifecycle setters. CPU controls reach BridgeApi and apply on the client thread. The supplied log already showed balanced/economy CPU effects being applied.

GPU presets and Restore defaults now preserve Iris integration instead of checking only Oculus. Integration labels identify the current backend and Sodium. Two empty renderer information callbacks now show diagnostics. Mipmap changes require Apply; FerriteCore changes require restart by design. Navigation, information and help controls are not optimization toggles.

## Verification and remaining limits

Java 17 compilation, actual installed Iris API discovery, namespace/initialization/pipeline regressions, real OpenGL tests, layout/language tests, CPU policy/ownership/configuration tests, Mixin declarations and production references passed. No test fixtures are packaged. The new binaries have not yet been tested inside a Minecraft world or benchmarked for FPS.

The provided log also contains shader-pack uniform warnings for BIOME_PALE_GARDEN, BIOME_SULFUR_CAVES and endFlashIntensity, and an NVIDIA external-query timeout followed by successful OpenGL fallback. Those are separate from the namespace bug; this release does not rewrite the shader pack or GPU driver.

Retest with the same world at 100%, 85% and 67%, then disable/re-enable the shader and check CPU custom controls. Report any remaining visual problem with both logs. Other targets remain at their previous published versions.
