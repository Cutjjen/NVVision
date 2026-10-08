# Legacy GUI mapping contract

Fabric 1.19.2 patch 0.8.18 fixes two independent failures: OptionsScreenMixin inherited a local adapter outside the target hierarchy, and Mojang-to-Tiny mapping composition left inherited methods with official obfuscated names (Screen.children became i instead of method_25396).

Mixin classes must extend an actual superclass of their Minecraft target. LegacyScreen is for NVVision screens only; OptionsScreenMixin extends the native Screen.

BuildPortMappings now resolves Tiny methods and fields against the original Minecraft class hierarchy, including interfaces. This reusable mapping boundary applies to future manual Fabric ports with the same inherited-member layout. Normal Fabric Loom builds use Loom remapping.

CheckGuiInheritance inspects project calls inherited through adapter classes and validates Mixin superclass ancestry. The production validator runs this check along with selector and Minecraft linkage checks. An independent fixture was generated directly from the official client and Fabric intermediary Tiny mapping. The 0.8.17 build is rejected with the same missing i() call reported in the user log; 0.8.18 passes 2737 calls and eight mixin superclass checks.

Automated OpenGL, UI, language, CPU and bridge regressions pass. No full Minecraft startup/menu/world test was performed in this patch; user validation remains necessary.
