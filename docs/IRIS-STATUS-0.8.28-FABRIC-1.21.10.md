# Fabric 1.21.10 shader status correction

Author: Cutjjen. Mod and addon: 0.8.28.

The previous native renderer emitted a fixed no-shader message whenever framebuffer scaling was allowed. This log line did not establish that Iris detection failed. Inspection of the installed Iris 1.9.7 API confirmed that isShaderPackInUse and PipelineManager accessors remain available.

NVVisionBoostShaderStatusAdapter separates availability, enabled configuration and active pipeline. The renderer queries existing compatibility methods and compares the complete status before logging, so shader toggles are reported even when framebuffer restrictions remain unchanged. Actual live pipeline state takes precedence over a transient persisted enabled flag. No reflection fallback or guessed active state is introduced. Rendering restrictions and buffer ownership remain unchanged.

Five adapter checks, 51 real OpenGL checks, CPU/UI regressions, 36 named Mixin checks and 512 production Minecraft reference checks passed. The user confirmed this release works perfectly in Minecraft; no FPS measurement was performed.
