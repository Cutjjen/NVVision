# Índice de funções

Criado a partir da árvore sintática do Java. Os contratos abaixo vêm dos comentários do código; uma entrada sem contrato não constitui uma auditoria individual da função. As variantes de Minecraft conservam suas diferenças de API.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.nativeBackend()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/FabricBridge.java

- `FabricBridge.onInitializeClient()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `FabricBridge.beforeFrame()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `FabricBridge.afterFrame()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeRenderMixin.java

- `BridgeRenderMixin.nvvbridge$before(CallbackInfo ci)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeRenderMixin.nvvbridge$after(CallbackInfo ci)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeShutdownMixin.java

- `BridgeShutdownMixin.nvvision$restoreOptions(CallbackInfo ci)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 758. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 858. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 954. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 972. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 979. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 1003. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 1007. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 1015. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1044. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1077. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1098. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1116. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1146. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1154. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1171. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1205. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1247. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1301. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1328. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1354. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1367. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1371. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1375. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1383. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1397. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1415. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1424. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1437. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1441. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1445. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1449. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1466. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1475. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1479. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1487. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1499. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1503. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1507. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1511. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1516. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1521. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1526. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1535. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1609. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 204. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — linha 222. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.tickClient()` — linha 257. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — linha 304. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.detectFps()` — linha 346. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — linha 360. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — linha 391. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — linha 420. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.resetUpscaler()` — linha 431. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostCore.saveConfig()` — linha 439. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.gameRoot()` — linha 459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.saveStatus()` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.writeReadme()` — linha 575. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.log(String message)` — linha 599. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — linha 606. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.unescapeJson(String value)` — linha 618. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.isEnabled()` — linha 632. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostCore.Config.normalize()` — linha 736. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.load(Path path)` — linha 801. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.save(Path path)` — linha 852. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostFabric.java

- `NVVisionBoostFabric.onInitializeClient()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFabric.tick()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — linha 64. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 68. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 96. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 134. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restore()` — linha 216. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — linha 225. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.release()` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 240. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.disposeTargets()` — linha 244. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 256. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.nativeBackend()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/FabricBridge.java

- `FabricBridge.onInitializeClient()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `FabricBridge.beforeFrame()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `FabricBridge.afterFrame()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeRenderMixin.java

- `BridgeRenderMixin.nvvbridge$before(CallbackInfo ci)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeRenderMixin.nvvbridge$after(CallbackInfo ci)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeShutdownMixin.java

- `BridgeShutdownMixin.nvvision$restoreOptions(CallbackInfo ci)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 758. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 858. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 954. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 972. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 979. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 1003. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 1007. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 1015. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1044. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1077. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1098. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1116. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1146. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1154. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1171. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1205. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1247. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1301. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1328. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1354. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1367. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1371. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1375. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1383. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1397. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1415. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1424. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1437. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1441. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1445. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1449. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1466. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1475. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1479. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1487. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1499. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1503. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1507. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1511. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1516. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1521. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1526. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 1535. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 204. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — linha 222. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.tickClient()` — linha 257. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — linha 304. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.detectFps()` — linha 346. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — linha 360. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — linha 391. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — linha 420. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.resetUpscaler()` — linha 431. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostCore.saveConfig()` — linha 439. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.gameRoot()` — linha 459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.saveStatus()` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.writeReadme()` — linha 575. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.log(String message)` — linha 599. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — linha 606. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.unescapeJson(String value)` — linha 618. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.isEnabled()` — linha 632. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostCore.Config.normalize()` — linha 736. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.load(Path path)` — linha 801. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.save(Path path)` — linha 852. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostFabric.java

- `NVVisionBoostFabric.onInitializeClient()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFabric.tick()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — linha 54. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — linha 64. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — linha 68. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 72. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 150. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — linha 217. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restore()` — linha 232. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — linha 245. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.release()` — linha 253. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 260. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.disposeTargets()` — linha 264. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 276. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 86. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 111. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeBenchmark.java

- `BridgeBenchmark.seconds(String property, int fallback)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeBenchmark.frame(TickEvent.RenderTickEvent event)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeBenchmark.save(Minecraft mc)` — linha 74. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeBenchmark.percentile(double[] sorted, double fraction)` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgePresentation.java

- `BridgePresentation.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgePresentation.end(TickEvent.RenderTickEvent event)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeTestSession.java

- `BridgeTestSession.<init>()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeTestSession.tick(TickEvent.ClientTickEvent event)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java

- `NVVisionVulkanBridge.<init>()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVulkanBridge.Client.shutdown(net.minecraftforge.event.GameShuttingDownEvent event)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVulkanBridge.Client.tick(TickEvent.ClientTickEvent event)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$guardBuffers(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$prepareWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$beginWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$endWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.<init>()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — linha 52. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.openResourceZip(Path file)` — linha 82. ZIPs antigos podem usar CP437 nos nomes sem marcar UTF-8. Só tenta fallback nesse erro.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostClient.registerKeyMappings(RegisterKeyMappingsEvent event)` — linha 35. Registra somente o KeyMapping.  ,<p>,event.register(OPEN_CONFIG) NÃO é registro manual do EventBus.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.onClientTick(TickEvent.ClientTickEvent event)` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.loaded(String id)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.oculus()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.iris()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.embeddium()` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.sodium()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.modMenu()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.resolve()` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderPipeline()` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersInUse()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — linha 100. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — linha 114. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — linha 129. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.disableExternalShaders()` — linha 134. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.renderer()` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderBackend()` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.summary()` — linha 147. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.integrationSummary()` — linha 160. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 636. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 759. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 838. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 934. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 952. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 959. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 983. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 987. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 995. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1024. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1057. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1078. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1096. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1126. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1134. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1151. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1185. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1227. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1247. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1281. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1308. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1334. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1347. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1351. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1355. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1363. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1377. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1395. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1404. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1417. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1421. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1425. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1429. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1433. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1437. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1441. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1446. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1451. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1455. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1467. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1475. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1479. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1483. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1487. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1491. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1496. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1501. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1506. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1515. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostContentManager.java

- `NVVisionBoostContentManager.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.shaderpacksDir()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.resourcepacksDir()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.ensureFolders(Path game)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.openFolder(Path p)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.importShader(Path source)` — linha 36. Installs a shaderpack file or directory into .minecraft/shaderpacks. ZIP/JAR shaderpacks are copied as-is; directories are copied recursively.
- `NVVisionBoostContentManager.importResourcePack(Path source)` — linha 42. Installs a resource pack file or directory into .minecraft/resourcepacks.
- `NVVisionBoostContentManager.activateResourcePack(String name)` — linha 51. Activates a resource pack through Minecraft's native repository. This method only changes the selected pack list; it never edits pack data.
- `NVVisionBoostContentManager.mergeSelection(java.util.List<String> previous, String target)` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.importContent(Path source, Path destination, String label)` — linha 107. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.copyDirectory(Path source, Path target)` — linha 133. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.stripExtension(String value)` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.modeName(int mode)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.integrations()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostForge.Config cfg)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — linha 70. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.status()` — linha 148. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostDependencyScreen.java

- `NVVisionBoostDependencyScreen.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.init()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.shouldCloseOnEsc()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.onClose()` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostDistantHorizonsCompatibility.java

- `NVVisionBoostDistantHorizonsCompatibility.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.loaded()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.allowsAutomaticDistanceChanges()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.report()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostEntityBufferGuard.java

- `NVVisionBoostEntityBufferGuard.<init>()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.reclaimable(boolean building, int outstanding, long used, boolean ready, boolean ownerEmpty, boolean segmentEmpty)` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.field(Class<?> type, String name)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.afterFrame()` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.inspectVanilla(MultiBufferSource.BufferSource source)` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.reclaim(BufferBuilder buffer, boolean empty)` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.inspect(Object source)` — linha 108. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.status()` — linha 138. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.configuration()` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.<init>()` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.refresh()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.init()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.onClose()` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.clip(String text)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostForge.java

- `NVVisionBoostForge.<init>()` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 163. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.MachineProfile.load(Path path)` — linha 211. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.MachineProfile.save(Path path)` — linha 257. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.tickClient()` — linha 292. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.updateClientMetrics(Config config)` — linha 339. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.detectFps()` — linha 381. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.setRenderScalePercent(int percent)` — linha 395. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostForge.setUpscalingEnabled(boolean enabled)` — linha 426. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostForge.toggleUpscaling()` — linha 455. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.resetUpscaler()` — linha 466. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostForge.saveConfig()` — linha 474. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.gameRoot()` — linha 494. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.saveStatus()` — linha 506. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.writeReadme()` — linha 610. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.log(String message)` — linha 634. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.stringValue(String json, String key, String fallback)` — linha 641. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.unescapeJson(String value)` — linha 653. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.Config.isEnabled()` — linha 667. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostForge.Config.normalize()` — linha 771. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.Config.load(Path path)` — linha 836. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostForge.Config.save(Path path)` — linha 887. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameStart()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostForge.Config config)` — linha 94. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostForge.Config config)` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostForge.Config config)` — linha 122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.beginWorld()` — linha 131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.markUpscale()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.endWorld()` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.invalidateWorld()` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameMs()` — linha 147. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.p95Ms()` — linha 151. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuMs()` — linha 155. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.upscaleMs()` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — linha 163. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuLikely()` — linha 167. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.status()` — linha 173. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.resolutionStatus()` — linha 188. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFsr1Upscaler.java

- `NVVisionBoostFsr1Upscaler.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.status()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.supported()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.render(int texture, int destination, int width, int height, int outputWidth, int outputHeight, int sharpnessPercent)` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.initialize()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.link(String fragmentSource)` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.configureEasu(int width, int height, int outputWidth, int outputHeight)` — linha 171. Mesmas constantes de FsrEasuCon, calculadas na CPU apenas quando as dimensões mudam.
- `NVVisionBoostFsr1Upscaler.uniform(int location, float x, float y, float z, float w)` — linha 188. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.ensureTarget(int width, int height)` — linha 197. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.releaseTarget()` — linha 230. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.close()` — linha 236. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.summary()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.<init>()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detect()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detectFresh()` — linha 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presetFor(String gpuName)` — linha 178. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.genericPreset(String name)` — linha 227. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presets()` — linha 344. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — linha 1974. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostForge.Config c, Preset p)` — linha 1998. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostForge.Config c, Preset p)` — linha 2026. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.tailor(NVVisionBoostForge.Config config, Preset preset)` — linha 2051. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — linha 2080. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — linha 2162. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryDiagnostics()` — linha 2169. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — linha 2189. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.pl(String s)` — linha 2231. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.norm(String s)` — linha 2240. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostHardwareBudget.java

- `NVVisionBoostHardwareBudget.Snapshot.summary()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.<init>()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.detect()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.constrain(NVVisionBoostForge.Config config)` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostIO.java

- `NVVisionBoostIO.appendLog(Path target, String message)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.<init>()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.writeUtf8(Path target, String content)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.readUtf8(Path file, String fallback)` — linha 72. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.jsonString(String value)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.normalizeToken(String value)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.clamp(int value, int min, int max)` — linha 96. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.clamp(double value, double min, double max)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.openFolder(Path folder)` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostMemoryMonitor.java

- `NVVisionBoostMemoryMonitor.<init>()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMemoryMonitor.underPressure()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMemoryMonitor.tick(NVVisionBoostForge.Config cfg)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — linha 65. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.<init>()` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.renderWorld(GameRenderer renderer, float partialTick, long finishTimeNano, PoseStack poseStack)` — linha 140. Envolve todo o mundo, incluindo os hooks de shaders e a mão.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — linha 151. Dimensões vistas pelos passes 3D; a janela física permanece intacta.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — linha 155. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — linha 168. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — linha 196. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — linha 202. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 210. Recupera o target se um mod interrompeu o frame anterior com exceção. Não troca framebuffer, não limpa buffers e não recompila shaders aqui.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — linha 243. Diagnóstico de baixa frequência, após o backend terminar seu frame. getCurrentWidth/Height refletem a base dos buffers do pipeline; buffers especiais e mapas de sombras podem ter resoluções próprias.
- `NVVisionBoostNativeRenderer.renderLevel(LevelRenderer renderer, PoseStack poseStack, float partialTick, long finishTimeNano, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projection)` — linha 312. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginFrame()` — linha 346. Compatibilidade com versões anteriores do mixin.
- `NVVisionBoostNativeRenderer.endFrame()` — linha 351. Compatibilidade com versões anteriores.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 357. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — linha 368. Oculus 1.8.0 compara a versão do depth, mas não a identidade da textura. Dois RenderTargets podem ter a mesma versão e IDs diferentes. Invalide somente esse contador antes do beginLevelRendering do backend: ele próprio reanexa o depth e recalcula os tamanhos conforme as diretivas do pack. Também executa ao voltar à resolução nativa, sem recarregar shaders.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — linha 420. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 430. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — linha 438. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — linha 710. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — linha 788. Upscale espacial do framebuffer interno para o framebuffer principal.  ,<p>,GL_LINEAR é utilizado para evitar pixelização extrema.  ,<p>,Não há history buffer. Não há frame generation. Não há shaderpack NV nativo.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — linha 861. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — linha 948. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — linha 972. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 1015. Deve ser chamado quando:  ,<p>,- upscaling é ativado/desativado; - escala muda; - resolução muda; - fullscreen muda; - configuração gráfica é recarregada.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 1048. Solicita novo diagnóstico; buffers só mudam quando suas dimensões mudam.
- `NVVisionBoostNativeRenderer.isActive()` — linha 1059. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 1063. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 1077. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalWidth()` — linha 1089. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalHeight()` — linha 1093. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 1097. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 1101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.skippedFrames()` — linha 1105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 1109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.currentFps()` — linha 1113. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostForge.Config cfg)` — linha 1131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — linha 1153. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — linha 1157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostNvidiaBackend.java

- `NVVisionBoostNvidiaBackend.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.dlssLibraryPresent()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.frameGenerationAvailable()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.status()` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostOculusShaderCache.java

- `NVVisionBoostOculusShaderCache.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.Result.summary()` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.EntryData.<init>(String name, byte[] bytes)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.detectOculusShaderPack(Path gameDir)` — linha 118. Tenta descobrir o shaderpack atualmente configurado no Oculus.  ,<p>,Não existe dependência direta de compilação com Oculus. Reflection é utilizada para evitar que NVVisionBoost deixe de carregar caso Oculus não esteja instalado.
- `NVVisionBoostOculusShaderCache.compileOculusActive(Path gameDir)` — linha 225. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.compileSelected(Path gameDir, Path shaderPack)` — linha 248. Analisa e prepara o cache do shaderpack.  ,<p>,NÃO ativa o shader.
- `NVVisionBoostOculusShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 405. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isMetadata(String name)` — linha 520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — linha 524. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.readBounded(InputStream input, long max)` — linha 536. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isShader(String name)` — linha 558. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isTexture(String name)` — linha 568. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.invokeBoolean(Object target, String methodName)` — linha 576. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.invokeString(Object target, String methodName)` — linha 595. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.longBytes(long value)` — linha 614. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.hex(byte[] bytes)` — linha 627. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.safeMessage(Throwable throwable)` — linha 637. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostPerformance.java

- `NVVisionBoostPerformance.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.tick(NVVisionBoostForge.Config config)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.limitBlockEntities()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.blockEntityDistance()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.reduceWeatherParticles()` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.framerateLimit(int currentLimit)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cfg()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.init()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — linha 277. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.onClose()` — linha 283. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — linha 288. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.resetWorldTracking()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostForge.Config config, int fps)` — linha 45. Chamado uma vez por segundo pelo monitor central, nunca por frame.
- `NVVisionBoostRenderController.<init>()` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.tick(NVVisionBoostForge.Config config)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostForge.Config config)` — linha 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostForge.Config config, int fps)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.restorePlayerOptions()` — linha 219. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, int ignoredTier)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, boolean automaticReapply)` — linha 237. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostForge.Config config)` — linha 317. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostForge.Config config)` — linha 335. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — linha 339. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.signature(NVVisionBoostForge.Config c)` — linha 347. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — linha 378. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — linha 382. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — linha 386. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — linha 403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — linha 428. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — linha 443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — linha 453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — linha 461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — linha 465. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — linha 476. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — linha 482. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostScreenEvents.java

- `NVVisionBoostScreenEvents.<init>()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onScreenOpening(ScreenEvent.Opening event)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onScreenInit(ScreenEvent.Init.Post event)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onClientTick(TickEvent.ClientTickEvent event)` — linha 100. F8.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShader.java

- `NVVisionBoostShader.Pack.<init>(String name, Path path)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.Pack.<init>(String name, Path path, boolean derivative, int score, int shaderFiles, int sourceLines, int animationCost, int transparencyCost, int shadowCost, int volumetricCost, int postCost, String recommendedProfile, List<String> issues)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.cachedAnalysis(Path source)` — linha 70. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.invalidateAnalysisCache()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.<init>()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.scan(Path dir, Path cache)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.selected(Path root)` — linha 107. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.select(Path root, String name)` — linha 117. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.isPack(Path p)` — linha 132. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.containsShaderDirectory(Path p)` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.readLimitedSource(java.io.InputStream input)` — linha 148. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.analyzePack(Path pack)` — linha 155. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.findNestedRoot(Path pack)` — linha 244. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.isShaderFile(Path p)` — linha 252. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.countLines(String source)` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.metrics(String path, String source)` — linha 270. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.count(String source, String token)` — linha 291. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — linha 30. Leitura em worker; alterações no perfil e no pipeline apenas na thread cliente.
- `NVVisionBoostShaderEngine.disableExternal()` — linha 100. Somente ação manual da interface solicita desligar o backend.
- `NVVisionBoostShaderEngine.loadStatus()` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.<init>()` — linha 133. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostForge.Config cfg)` — linha 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — linha 231. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — linha 235. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.lastCompile()` — linha 239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.findByName(String name)` — linha 243. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostForge.Config cfg, NVVisionBoostShader.Pack pack)` — linha 270. Perfil genérico por custo estimado, aplicável a qualquer shaderpack.
- `NVVisionBoostShaderEngine.activateWithOculus(Path game, String shaderName)` — linha 305. Legacy method kept because older UI/classes may still call it.  ,<p>,Prepara recursos e solicita carregamento real ao backend disponível.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — linha 318. Legacy method kept for source compatibility.  ,<p>,Alias legado: usa o backend disponível; não cria renderer nativo.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — linha 326. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — linha 332. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — linha 431. Prepares the selected shaderpack for Oculus.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileOculusActive(Path game)` — linha 490. Prepares the shader currently being used by Oculus.
- `NVVisionBoostShaderEngine.disableNative()` — linha 511. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Oculus shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — linha 521. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.forceOculusArchitecture(NVVisionBoostForge.Config cfg)` — linha 537. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — linha 555. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostForge.Config cfg)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — linha 56. O botão manual também satisfaz a preparação desta sessão.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.label(int value)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.status()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostForge.Config config)` — linha 21. API antiga preservada; não aplica mais mapeamentos genéricos inseguros.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.beforeRender()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.synchronizeFlywheel(Minecraft mc, Object pipeline)` — linha 124. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.status()` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.status()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.initialize()` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — linha 179. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.close()` — linha 191. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.capture()` — linha 210. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.restore()` — linha 236. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — linha 271. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.isBusy()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.status()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.label(int level)` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostForge.Config config)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.init()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.onClose()` — linha 62. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostVisualPolicy.java

- `NVVisionBoostVisualPolicy.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVisualPolicy.screenEffectScale(NVVisionBoostForge.Config config, double original)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVisualPolicy.simulationDistance(NVVisionBoostForge.Config config, int original)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostVulkanBridgeScreen.java

- `NVVisionBoostVulkanBridgeScreen.<init>(Screen parent)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.init()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.lines()` — linha 74. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.mouseScrolled(double x, double y, double delta)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.render(GuiGraphics g, int x, int y, float tick)` — linha 98. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.onClose()` — linha 115. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.averageFps()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.lowFpsSamples()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.stableFpsSamples()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.tickDynamicPerformance()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.checkShaderState()` — linha 69. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.resetTracking()` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getDisplayName()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.setPreset(UpscalePreset preset)` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getCurrentPreset()` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getActiveResolutionInfo()` — linha 64. Retorna a resolução interna calculada sem modificar a janela.
- `UpscalingManager.applyCurrentResolution()` — linha 78. Aplica somente o estado lógico do upscaler. Não chama resizeDisplay() e não altera Minecraft.getWindow(). O framebuffer interno é criado pelo renderer no início do passe de LevelRenderer.
- `UpscalingManager.getScalePercent()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getScaleFactor()` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalWidth(int windowWidth)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalHeight(int windowHeight)` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.syncPresetFromConfig()` — linha 131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — linha 140. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.clamp(int value, int min, int max)` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.applySettings(int profile, boolean status)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostForge.Config cfg)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.analyzeHardwareResources()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.forceOculusPerformanceState()` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configureCreateCompatibility()` — linha 215. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.disableOptimizations(NVVisionBoostForge.Config cfg)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isModLoaded(String modId)` — linha 255. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.normalizeProfile(int profile)` — linha 266. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.profileName(int profile)` — linha 270. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.getPerformanceProfile()` — linha 278. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isEnabled()` — linha 282. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostEntityBufferSmokeTest.java

- `NVVisionBoostEntityBufferSmokeTest.field(String name)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.value(Field f)` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getRenderedPointer()` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getWritePointer()` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getRenderedCount()` — linha 57. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$isBuilding()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.<init>(AccountingBuffer buffer)` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getBuilder()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getFixedBuffers()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getLastState()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getStartedBuffers()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferSmokeTest.run()` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runTargetBindings()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — linha 298. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — linha 323. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runTimers()` — linha 388. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runPackedDepthTransitions()` — linha 452. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.depthTexture(int size, boolean packed)` — linha 533. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — linha 551. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — linha 569. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — linha 580. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostRegressionTest.java

- `NVVisionBoostRegressionTest.check(boolean result, String name)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.main(String[] args)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testBridgeApi()` — linha 43. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testLegacyZip(Path root)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testConfig(Path root)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testVisualPolicies()` — linha 157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testResourceSelection()` — linha 186. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testPacks(Path root)` — linha 198. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testImport(Path root)` — linha 243. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testAtomicWrites(Path root)` — linha 268. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testResources(Path root)` — linha 301. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/minecraft/1.20.1/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VersionAdapter.accessNotice(Component title, Component description)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/minecraft/1.21.1/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VersionAdapter.accessNotice(Component title, Component description)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/minecraft/26.2/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VersionAdapter.accessNotice(Component title, Component description)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.nativeBackend()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.beforeFrame()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.afterFrame()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.registerKeys(RegisterKeyMappingsEvent event)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostClient.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 758. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 864. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 960. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 978. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 985. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 1009. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 1013. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 1021. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1050. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1083. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1152. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1160. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1211. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1253. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1273. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1307. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1334. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1360. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1373. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1377. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1381. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1389. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1421. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1430. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1447. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1451. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1455. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1463. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1467. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1472. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1477. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1481. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1485. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1493. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1501. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1505. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1509. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1513. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1517. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1522. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1527. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1532. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1541. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1615. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 204. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — linha 222. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.tickClient()` — linha 257. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — linha 304. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.detectFps()` — linha 346. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — linha 360. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — linha 391. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — linha 420. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.resetUpscaler()` — linha 431. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostCore.saveConfig()` — linha 439. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.gameRoot()` — linha 459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.saveStatus()` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.writeReadme()` — linha 575. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.log(String message)` — linha 599. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — linha 606. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.unescapeJson(String value)` — linha 618. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.isEnabled()` — linha 632. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostCore.Config.normalize()` — linha 736. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.load(Path path)` — linha 801. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.save(Path path)` — linha 852. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.refresh()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.init()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.onClose()` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.clip(String text)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 208. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — linha 64. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — linha 68. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 76. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 103. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 141. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — linha 208. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restore()` — linha 223. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — linha 232. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.release()` — linha 240. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 247. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.disposeTargets()` — linha 251. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 86. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 111. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/CpuOptionLease.java

- `CpuOptionLease.update(T current, T desired)` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuOptionLease.release(T current)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java

- `NVVisionVulkanBridge.<init>()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVulkanBridge.Client.shutdown(net.neoforged.neoforge.event.GameShuttingDownEvent event)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVulkanBridge.Client.tick(ClientTickEvent.Post event)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$prepareWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$beginWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$endWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.<init>()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — linha 52. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.openResourceZip(Path file)` — linha 82. ZIPs antigos podem usar CP437 nos nomes sem marcar UTF-8. Só tenta fallback nesse erro.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostClient.registerKeyMappings(RegisterKeyMappingsEvent event)` — linha 35. Registra somente o KeyMapping.  ,<p>,event.register(OPEN_CONFIG) NÃO é registro manual do EventBus.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.onClientTick(ClientTickEvent.Post event)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.loaded(String id)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.oculus()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.iris()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.embeddium()` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.sodium()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.modMenu()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.resolve()` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderPipeline()` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersInUse()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — linha 100. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — linha 114. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — linha 129. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.disableExternalShaders()` — linha 134. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.renderer()` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderBackend()` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.summary()` — linha 147. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.integrationSummary()` — linha 160. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 636. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 759. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 838. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 934. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 952. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 959. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 983. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 987. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 995. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1025. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1058. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1079. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1097. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1152. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1187. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1229. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1249. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1283. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1310. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1336. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1349. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1353. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1357. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1365. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1379. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1397. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1406. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1419. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1423. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1427. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1431. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1435. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1439. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1448. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1469. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1477. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1481. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1485. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1489. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1493. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1498. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1503. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1508. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 1523. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — linha 212. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 240. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.tickClient()` — linha 293. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — linha 340. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.detectFps()` — linha 382. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — linha 396. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — linha 427. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — linha 456. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.resetUpscaler()` — linha 467. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostCore.saveConfig()` — linha 475. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.gameRoot()` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.saveStatus()` — linha 507. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.writeReadme()` — linha 611. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.log(String message)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — linha 642. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.unescapeJson(String value)` — linha 654. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.isEnabled()` — linha 668. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostCore.Config.normalize()` — linha 772. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.load(Path path)` — linha 837. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.save(Path path)` — linha 888. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostDependencyScreen.java

- `NVVisionBoostDependencyScreen.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.init()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.shouldCloseOnEsc()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.onClose()` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencyScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostEntityBufferGuard.java

- `NVVisionBoostEntityBufferGuard.<init>()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.reclaimable(boolean building, int outstanding, long used, boolean ready, boolean ownerEmpty, boolean segmentEmpty)` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.field(Class<?> type, String name)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.afterFrame()` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.inspectVanilla(MultiBufferSource.BufferSource source)` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.reclaim(BufferBuilder buffer, boolean empty)` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.inspect(Object source)` — linha 108. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostEntityBufferGuard.status()` — linha 138. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.configuration()` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.<init>()` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.refresh()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.init()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.onClose()` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.clip(String text)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 208. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostForge.java


## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameStart()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — linha 94. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — linha 122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.beginWorld()` — linha 131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.markUpscale()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.endWorld()` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.invalidateWorld()` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameMs()` — linha 147. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.p95Ms()` — linha 151. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuMs()` — linha 155. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.upscaleMs()` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — linha 163. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuLikely()` — linha 167. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.status()` — linha 173. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.resolutionStatus()` — linha 188. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.summary()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.<init>()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detect()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detectFresh()` — linha 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presetFor(String gpuName)` — linha 178. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.genericPreset(String name)` — linha 227. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presets()` — linha 344. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — linha 1974. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — linha 1998. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — linha 2026. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — linha 2051. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — linha 2080. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — linha 2162. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryDiagnostics()` — linha 2169. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — linha 2189. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.pl(String s)` — linha 2231. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.norm(String s)` — linha 2240. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — linha 59. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.<init>()` — linha 122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — linha 135. Dimensões vistas pelos passes 3D; a janela física permanece intacta.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — linha 152. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — linha 180. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — linha 186. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 194. Recupera o target se um mod interrompeu o frame anterior com exceção. Não troca framebuffer, não limpa buffers e não recompila shaders aqui.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 218. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — linha 227. Diagnóstico de baixa frequência, após o backend terminar seu frame. getCurrentWidth/Height refletem a base dos buffers do pipeline; buffers especiais e mapas de sombras podem ter resoluções próprias.
- `NVVisionBoostNativeRenderer.beginFrame()` — linha 301. Compatibilidade com versões anteriores do mixin.
- `NVVisionBoostNativeRenderer.endFrame()` — linha 306. Compatibilidade com versões anteriores.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 312. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — linha 323. Oculus 1.8.0 compara a versão do depth, mas não a identidade da textura. Dois RenderTargets podem ter a mesma versão e IDs diferentes. Invalide somente esse contador antes do beginLevelRendering do backend: ele próprio reanexa o depth e recalcula os tamanhos conforme as diretivas do pack. Também executa ao voltar à resolução nativa, sem recarregar shaders.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — linha 375. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 385. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — linha 393. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — linha 669. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — linha 747. Upscale espacial do framebuffer interno para o framebuffer principal.  ,<p>,GL_LINEAR é utilizado para evitar pixelização extrema.  ,<p>,Não há history buffer. Não há frame generation. Não há shaderpack NV nativo.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — linha 820. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — linha 906. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — linha 930. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 973. Deve ser chamado quando:  ,<p>,- upscaling é ativado/desativado; - escala muda; - resolução muda; - fullscreen muda; - configuração gráfica é recarregada.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 1006. Solicita novo diagnóstico; buffers só mudam quando suas dimensões mudam.
- `NVVisionBoostNativeRenderer.isActive()` — linha 1017. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 1021. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 1035. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalWidth()` — linha 1047. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalHeight()` — linha 1051. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 1055. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 1059. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.skippedFrames()` — linha 1063. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 1067. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.currentFps()` — linha 1071. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostCore.Config cfg)` — linha 1089. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — linha 1111. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — linha 1115. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(ModContainer container)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostOculusShaderCache.java

- `NVVisionBoostOculusShaderCache.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.Result.summary()` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.EntryData.<init>(String name, byte[] bytes)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.detectOculusShaderPack(Path gameDir)` — linha 118. Tenta descobrir o shaderpack atualmente configurado no Oculus.  ,<p>,Não existe dependência direta de compilação com Oculus. Reflection é utilizada para evitar que NVVisionBoost deixe de carregar caso Oculus não esteja instalado.
- `NVVisionBoostOculusShaderCache.compileOculusActive(Path gameDir)` — linha 225. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.compileSelected(Path gameDir, Path shaderPack)` — linha 248. Analisa e prepara o cache do shaderpack.  ,<p>,NÃO ativa o shader.
- `NVVisionBoostOculusShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 405. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isMetadata(String name)` — linha 520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — linha 524. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.readBounded(InputStream input, long max)` — linha 536. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isShader(String name)` — linha 558. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.isTexture(String name)` — linha 568. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.invokeBoolean(Object target, String methodName)` — linha 576. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.invokeString(Object target, String methodName)` — linha 595. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.longBytes(long value)` — linha 614. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.hex(byte[] bytes)` — linha 627. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOculusShaderCache.safeMessage(Throwable throwable)` — linha 637. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostOptionsPlacement.java

- `NVVisionBoostOptionsPlacement.Rect.overlaps(Rect other)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsPlacement.free(Rect candidate, int width, int height, List<Rect> occupied)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsPlacement.place(int width, int height, List<Rect> occupied)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsPlacement.<init>()` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cfg()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.init()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — linha 277. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.onClose()` — linha 283. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — linha 288. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 316. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.resetWorldTracking()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — linha 45. Chamado uma vez por segundo pelo monitor central, nunca por frame.
- `NVVisionBoostRenderController.<init>()` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — linha 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.restorePlayerOptions()` — linha 219. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — linha 237. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — linha 317. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — linha 335. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — linha 339. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — linha 347. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — linha 378. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — linha 382. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — linha 386. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — linha 403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — linha 428. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — linha 443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — linha 453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — linha 461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — linha 465. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — linha 476. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — linha 482. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostScreenEvents.java

- `NVVisionBoostScreenEvents.<init>()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onScreenOpening(ScreenEvent.Opening event)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onScreenInit(ScreenEvent.Init.Post event)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.beforeScreenRender(ScreenEvent.Render.Pre event)` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.placeEntry(Screen screen)` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostScreenEvents.onClientTick(ClientTickEvent.Post event)` — linha 111. F8.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — linha 30. Leitura em worker; alterações no perfil e no pipeline apenas na thread cliente.
- `NVVisionBoostShaderEngine.disableExternal()` — linha 100. Somente ação manual da interface solicita desligar o backend.
- `NVVisionBoostShaderEngine.loadStatus()` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.<init>()` — linha 133. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostCore.Config cfg)` — linha 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — linha 231. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — linha 235. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.lastCompile()` — linha 239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.findByName(String name)` — linha 243. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostCore.Config cfg, NVVisionBoostShader.Pack pack)` — linha 270. Perfil genérico por custo estimado, aplicável a qualquer shaderpack.
- `NVVisionBoostShaderEngine.activateWithOculus(Path game, String shaderName)` — linha 304. Legacy method kept because older UI/classes may still call it.  ,<p>,Prepara recursos e solicita carregamento real ao backend disponível.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — linha 317. Legacy method kept for source compatibility.  ,<p>,Alias legado: usa o backend disponível; não cria renderer nativo.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — linha 325. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — linha 331. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — linha 430. Prepares the selected shaderpack for Oculus.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileOculusActive(Path game)` — linha 489. Prepares the shader currently being used by Oculus.
- `NVVisionBoostShaderEngine.disableNative()` — linha 510. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Oculus shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — linha 520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.forceOculusArchitecture(NVVisionBoostCore.Config cfg)` — linha 536. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — linha 554. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — linha 56. O botão manual também satisfaz a preparação desta sessão.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.label(int value)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.status()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — linha 21. API antiga preservada; não aplica mais mapeamentos genéricos inseguros.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.beforeRender()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.synchronizeFlywheel(Minecraft mc, Object pipeline)` — linha 124. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.status()` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.status()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.initialize()` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — linha 179. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.close()` — linha 191. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.capture()` — linha 210. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.restore()` — linha 236. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — linha 271. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostVulkanBridgeScreen.java

- `NVVisionBoostVulkanBridgeScreen.<init>(Screen parent)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.init()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.lines()` — linha 74. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.render(GuiGraphics g, int x, int y, float tick)` — linha 98. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.onClose()` — linha 115. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridgeScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 121. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getDisplayName()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.setPreset(UpscalePreset preset)` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getCurrentPreset()` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getActiveResolutionInfo()` — linha 64. Retorna a resolução interna calculada sem modificar a janela.
- `UpscalingManager.applyCurrentResolution()` — linha 78. Aplica somente o estado lógico do upscaler. Não chama resizeDisplay() e não altera Minecraft.getWindow(). O framebuffer interno é criado pelo renderer no início do passe de LevelRenderer.
- `UpscalingManager.getScalePercent()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getScaleFactor()` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalWidth(int windowWidth)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalHeight(int windowHeight)` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.syncPresetFromConfig()` — linha 131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — linha 140. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.clamp(int value, int min, int max)` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.applySettings(int profile, boolean status)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.analyzeHardwareResources()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.forceOculusPerformanceState()` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configureCreateCompatibility()` — linha 215. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isModLoaded(String modId)` — linha 255. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.normalizeProfile(int profile)` — linha 266. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.profileName(int profile)` — linha 270. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.getPerformanceProfile()` — linha 278. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isEnabled()` — linha 282. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runTargetBindings()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — linha 136. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — linha 202. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — linha 299. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — linha 324. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runTimers()` — linha 389. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runPackedDepthTransitions()` — linha 453. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.depthTexture(int size, boolean packed)` — linha 534. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — linha 552. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — linha 570. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — linha 581. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostOptionsPlacementTest.java

- `NVVisionBoostOptionsPlacementTest.main(String[] args)` — linha 6. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostRegressionTest.java

- `NVVisionBoostRegressionTest.check(boolean result, String name)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.main(String[] args)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testBridgeApi()` — linha 43. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testLegacyZip(Path root)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testConfig(Path root)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testVisualPolicies()` — linha 157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testResourceSelection()` — linha 186. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testPacks(Path root)` — linha 198. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testImport(Path root)` — linha 243. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testAtomicWrites(Path root)` — linha 268. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRegressionTest.testResources(Path root)` — linha 301. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.beforeFrame()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.afterFrame()` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererAccessor.nvvb$getGameRenderState()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftAccessor.java

- `NVVisionBoostMinecraftAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 758. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 864. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 960. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 978. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 985. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 1009. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 1013. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 1021. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1050. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1083. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1152. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1160. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1211. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1253. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1273. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1307. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1334. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1360. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1373. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1377. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1381. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1389. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1421. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1430. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1447. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1451. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1455. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1463. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1467. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1472. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1477. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1481. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1485. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1493. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1501. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1505. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1509. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1513. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1517. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1522. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1527. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1532. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 1541. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.refresh()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.init()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.onClose()` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.extractRenderState(GuiGraphicsExtractor g, int x, int y, float tick)` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.clip(String text)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 43. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — linha 65. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — linha 69. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — linha 73. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 108. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 152. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — linha 219. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restore()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — linha 247. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.release()` — linha 255. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 262. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.disposeTargets()` — linha 266. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 278. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cfg()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.init()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — linha 280. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.onClose()` — linha 286. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.extractRenderState(GuiGraphicsExtractor graphics, int x, int y, float partialTick)` — linha 291. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.init()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.onClose()` — linha 62. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.beforeFrame()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NeoForgeBridge.afterFrame()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.init()` — linha 61. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelLeft()` — linha 77. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.panelRight()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentLeft()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentRight()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.contentWidth()` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.colWidth()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.col2()` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.rebuildInternal()` — linha 109. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyScroll()` — linha 234. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.onClose()` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — linha 364. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — linha 495. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — linha 635. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — linha 758. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — linha 864. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — linha 960. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — linha 978. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — linha 985. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cfg()` — linha 1009. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — linha 1013. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.restoreDefaults()` — linha 1021. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggle(String field)` — linha 1050. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — linha 1083. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — linha 1104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — linha 1122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — linha 1152. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyDetected()` — linha 1160. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — linha 1177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — linha 1211. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.compilePendingShader()` — linha 1253. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importShader()` — linha 1273. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.importResourcePack()` — linha 1307. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — linha 1334. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — linha 1360. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.detect(boolean present)` — linha 1373. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.on(boolean value)` — linha 1377. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — linha 1381. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — linha 1389. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — linha 1403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — linha 1421. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — linha 1430. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — linha 1443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — linha 1447. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — linha 1451. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — linha 1455. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — linha 1459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — linha 1463. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — linha 1467. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — linha 1472. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — linha 1477. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — linha 1481. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — linha 1485. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — linha 1493. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — linha 1501. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — linha 1505. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — linha 1509. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — linha 1513. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — linha 1517. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — linha 1522. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — linha 1527. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — linha 1532. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 1541. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.refresh()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.init()` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.onClose()` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.extractRenderState(GuiGraphicsExtractor g, int x, int y, float tick)` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteScreen.clip(String text)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.summary()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.<init>()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detect()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detectFresh()` — linha 158. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectNonOpenGL(Info i)` — linha 165. Native Minecraft device metadata; never call OpenGL for a non-GL render target.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — linha 199. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presetFor(String gpuName)` — linha 222. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.genericPreset(String name)` — linha 271. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presets()` — linha 388. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — linha 2018. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — linha 2042. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — linha 2070. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — linha 2095. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — linha 2124. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — linha 2206. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryDiagnostics()` — linha 2213. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — linha 2233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.pl(String s)` — linha 2275. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.norm(String s)` — linha 2284. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.processedFrames()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.failedFrames()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.lastError()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.effectActive()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.internalResolution()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — linha 54. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — linha 64. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — linha 68. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — linha 72. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.prepareFrame()` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — linha 107. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.endLevelRender()` — linha 157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — linha 224. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.restore()` — linha 239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — linha 252. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.release()` — linha 260. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.invalidate()` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.disposeTargets()` — linha 271. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeRenderer.reset()` — linha 283. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(net.neoforged.fml.ModContainer container)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNeoForge.tick()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/Fabric/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/Fabric/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/Forge/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/Forge/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/NeoForge/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## adapters/platform/NeoForge/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.gameDirectory()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.configDirectory()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.client()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `LoaderAdapter.modLoaded(String id)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/adapters/addon/main/java/nvvisionboost/vulkanbridge/platform/Platform.java

- `Platform.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `Platform.get()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/adapters/addon/main/java/nvvisionboost/vulkanbridge/platform/PlatformAdapter.java

- `PlatformAdapter.loader()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.gameDirectory()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.configDirectory()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.client()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.modLoaded(String id)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/cpu/main/java/nvvisionboost/vulkanbridge/CpuPolicy.java

- `CpuPolicy.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuPolicy.validProfile(String value)` — linha 10. Aceita somente perfis conhecidos; configurações ausentes ou inválidas não ativam recursos.
- `CpuPolicy.distance(String value)` — linha 15. Normaliza a distância e migra 25%, rejeitado pelo Minecraft, para o mínimo válido de 50%.
- `CpuPolicy.particles(String value)` — linha 21. Normaliza a política de partículas sem modificar o estado do jogo.
- `CpuPolicy.nextDistance(String value)` — linha 26. Percorre as opções de distância que o controle individual pode aplicar.
- `CpuPolicy.nextParticles(String value)` — linha 35. Percorre as opções de partículas que o controle individual pode aplicar.
- `CpuPolicy.distanceCeiling(String profile, String custom)` — linha 44. Retorna o teto de distância do perfil; -1 indica que o addon não controla essa opção.
- `CpuPolicy.particleLimit(String profile, String custom)` — linha 60. Resolve o limite de partículas; off indica que a escolha original deve ser preservada.
- `CpuPolicy.validDistance(double current, double ceiling)` — linha 71. Aplica um teto sem elevar uma distância já válida e respeita o mínimo aceito pelo jogo.

## modules/addon/cpu/runtime/common/main/java/nvvisionboost/vulkanbridge/BridgeCpuOptimizer.java

- `BridgeCpuOptimizer.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeCpuOptimizer.initialized()` — linha 25. Informa se a configuração local já foi lida durante a inicialização do addon.
- `BridgeCpuOptimizer.mode()` — linha 30. Retorna o perfil ativo em memória para que a interface mostre o estado aplicado.
- `BridgeCpuOptimizer.control(String key)` — linha 37. Consulta o valor individual salvo; controles desconhecidos são sinalizados como indisponíveis.
- `BridgeCpuOptimizer.initialize(Path directory)` — linha 46. Lê uma vez os controles locais; uma configuração ilegível mantém a otimização desligada.
- `BridgeCpuOptimizer.read()` — linha 63. Lê as propriedades completas, incluindo chaves de usuário que precisam ser preservadas.
- `BridgeCpuOptimizer.save(String mode, String distance, String particles)` — linha 73. Persiste somente as escolhas de CPU por escrita atômica, mantendo as demais propriedades.
- `BridgeCpuOptimizer.request(String value)` — linha 84. Solicita um perfil conhecido; a alteração só ocorre se a persistência tiver sucesso.
- `BridgeCpuOptimizer.cycleControl(String key)` — linha 90. Avança um controle individual e seleciona o perfil personalizado.
- `BridgeCpuOptimizer.change(String mode, String distance, String particles)` — linha 101. Salva a escolha e agenda sua aplicação imediata na thread do cliente quando necessário.
- `BridgeCpuOptimizer.tick()` — linha 125. Reavalia os limites no máximo uma vez por segundo, sem reescrever opções a cada quadro.
- `BridgeCpuOptimizer.applyOptions(Minecraft client)` — linha 134. Aplica limites reversíveis somente no mundo e respeita mudanças feitas por usuário ou mods.
- `BridgeCpuOptimizer.logApplied(Minecraft client)` — linha 166. Registra o estado efetivo após uma escolha, sem gerar registros a cada quadro.
- `BridgeCpuOptimizer.release(Minecraft client)` — linha 177. Restaura apenas os valores que continuam sob controle do addon.
- `BridgeCpuOptimizer.shutdown()` — linha 189. Libera os valores temporários e salva a restauração antes do encerramento do cliente.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuConfigurationTest.java

- `CpuConfigurationTest.check(boolean value, String message)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuConfigurationTest.main(String[] args)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuOptionLeaseTest.java

- `CpuOptionLeaseTest.check(boolean value)` — linha 6. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuOptionLeaseTest.main(String[] args)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuPolicyTest.java

- `CpuPolicyTest.check(boolean value, String label)` — linha 6. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuPolicyTest.main(String[] args)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/performance/08a14d4bdd78/main/java/nvvisionboost/vulkanbridge/CpuOptionLease.java

- `CpuOptionLease.update(T current, T desired)` — linha 11. Adquire a opção e propõe um valor; uma alteração externa encerra o controle até a liberação.
- `CpuOptionLease.release(T current)` — linha 25. Devolve o valor original somente se o valor atual ainda for aquele aplicado pelo addon.

## modules/addon/services/20686c3ceade/main/java/nvvisionboost/vulkanbridge/BridgeOpaquePresent.java

- `BridgeOpaquePresent.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeOpaquePresent.normalize(int target)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/services/41f5167213b6/main/java/nvvisionboost/vulkanbridge/BridgeFiles.java

- `BridgeFiles.<init>()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeFiles.atomic(Path file, String value)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeFiles.profile(Path home)` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeFiles.descriptors(Path home, String value)` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeFiles.backend(Path home, String backend)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/services/8fbf9c2bdb2a/main/java/nvvisionboost/vulkanbridge/BridgePolicy.java

- `BridgePolicy.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgePolicy.classify(String renderer, String version)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgePolicy.translated(String renderer, String version, boolean framebuffer, boolean shaders)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/services/b1e163f5cbfe/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.snapshot()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.nativeBackend()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuControl(String key)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cycleCpuControl(String key)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.cpuProfile()` — linha 55. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestCpuProfile(String value)` — linha 59. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.inspect()` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestBackend(String backend)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.requestDescriptors(String value)` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeApi.report(Path root)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/services/f90459b3561e/test/java/nvvisionboost/vulkanbridge/BridgeRegressionTest.java

- `BridgeRegressionTest.check(boolean result)` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeRegressionTest.main(String[] args)` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/shared/1a092bfe87c2/main/java/nvvisionboost/vulkanbridge/BridgePreflight.java

- `BridgePreflight.compile(int type, String source)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgePreflight.main(String[] args)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/shared/1e2274031a9b/main/java/nvvisionboost/vulkanbridge/CpuMinecraftAdapter.java

- `CpuMinecraftAdapter.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuMinecraftAdapter.particles(Minecraft client)` — linha 11. Reads the native particle budget: 0=all, 1=decreased, 2=minimal.
- `CpuMinecraftAdapter.particles(Minecraft client, int budget)` — linha 16. Writes a valid native particle budget on the client thread.

## modules/addon/shared/2c8eaf364f2f/test/java/nvvisionboost/vulkanbridge/BridgeRegressionTest.java

- `BridgeRegressionTest.check(boolean result)` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeRegressionTest.main(String[] args)` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/shared/8cd8856f3ee6/main/java/nvvisionboost/vulkanbridge/BridgeBenchmarkPolicy.java

- `BridgeBenchmarkPolicy.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `BridgeBenchmarkPolicy.valid(int frames, int capacity, double sampledMs, double requiredMs, String requested, String actual)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/addon/shared/907bc6d9773f/main/java/nvvisionboost/vulkanbridge/CpuMinecraftAdapter.java

- `CpuMinecraftAdapter.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `CpuMinecraftAdapter.particles(Minecraft client)` — linha 11. Reads the native particle budget: 0=all, 1=decreased, 2=minimal.
- `CpuMinecraftAdapter.particles(Minecraft client, int budget)` — linha 16. Writes a valid native particle budget on the client thread.

## modules/mod/adapters/MinecraftAccess.java/main/java/nvvisionboost/minecraft/MinecraftAccess.java

- `MinecraftAccess.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `MinecraftAccess.get()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/adapters/MinecraftVersionAdapter.java/main/java/nvvisionboost/minecraft/MinecraftVersionAdapter.java

- `MinecraftVersionAdapter.mainRenderTarget()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `MinecraftVersionAdapter.accessNotice(Component title, Component description)` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/adapters/mod/main/java/nvvisionboost/platform/Platform.java

- `Platform.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `Platform.get()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/adapters/mod/main/java/nvvisionboost/platform/PlatformAdapter.java

- `PlatformAdapter.loader()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.gameDirectory()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.configDirectory()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.client()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `PlatformAdapter.modLoaded(String id)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/configuration/25d7d409d61f/test/java/nvvisionboost/NVVisionBoostNeoForgeConfigTest.java

- `NVVisionBoostNeoForgeConfigTest.main(String[] args)` — linha 6. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/configuration/5c17043943ca/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.available()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.samples()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.gpuMs()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.upscaleMs()` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.cpuMs()` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.begin()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.markUpscale()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.end()` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.poll()` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — linha 118. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.invalidate()` — linha 122. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.close()` — linha 129. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/configuration/5fcbaf1fef14/main/java/nvvisionboost/NVVisionBoostGpuCatalog.java

- `NVVisionBoostGpuCatalog.Type.<init>(String label)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.<init>()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.classify(String vendor, String renderer)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.brand(String text)` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.lower(String text)` — linha 69. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.additionalPresets()` — linha 74. Suggested starting points, not benchmarks or detected memory capacities.
- `NVVisionBoostGpuCatalog.group(List<NVVisionBoostGPU.Preset> result, String prefix, String architecture, String family, int tier, String[] names)` — linha 151. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.fallback(String name, Identity identity)` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.recommendation(String name, String architecture, String family, int tier)` — linha 169. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/configuration/71b50cf51d28/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.available()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.samples()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.gpuMs()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.upscaleMs()` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.cpuMs()` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.begin()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.markUpscale()` — linha 79. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.end()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.poll()` — linha 94. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — linha 115. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.invalidate()` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.close()` — linha 126. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/configuration/8bbd7b8ceece/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.summary()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.<init>()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detect()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detectFresh()` — linha 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presetFor(String gpuName)` — linha 177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.genericPreset(String name)` — linha 226. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presets()` — linha 343. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — linha 1973. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — linha 1997. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — linha 2025. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — linha 2050. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — linha 2079. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — linha 2161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryDiagnostics()` — linha 2168. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — linha 2188. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.pl(String s)` — linha 2230. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.norm(String s)` — linha 2239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/0386b2d3638f/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — linha 56. O botão manual também satisfaz a preparação desta sessão.

## modules/mod/integrations/1367072ff8f6/main/java/nvvisionboost/NVVisionBoostShader.java

- `NVVisionBoostShader.Pack.<init>(String name, Path path)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.Pack.<init>(String name, Path path, boolean derivative, int score, int shaderFiles, int sourceLines, int animationCost, int transparencyCost, int shadowCost, int volumetricCost, int postCost, String recommendedProfile, List<String> issues)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.cachedAnalysis(Path source)` — linha 70. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.invalidateAnalysisCache()` — linha 81. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.<init>()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.scan(Path dir, Path cache)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.selected(Path root)` — linha 107. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.select(Path root, String name)` — linha 117. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.isPack(Path p)` — linha 132. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.containsShaderDirectory(Path p)` — linha 139. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.readLimitedSource(java.io.InputStream input)` — linha 148. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.analyzePack(Path pack)` — linha 155. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.findNestedRoot(Path pack)` — linha 244. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.isShaderFile(Path p)` — linha 252. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.countLines(String source)` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.metrics(String path, String source)` — linha 270. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShader.count(String source, String token)` — linha 291. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/179aef91735a/main/java/nvvisionboost/NVVisionBoostShaderStartupPolicy.java

- `NVVisionBoostShaderStartupPolicy.begin(Object currentWorld, String currentPack, Object currentPipeline)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartupPolicy.complete(Object preparedPipeline)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartupPolicy.reset()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/27cdd1e1aa69/main/java/nvvisionboost/NVVisionBoostFerriteConfig.java

- `NVVisionBoostFerriteConfig.<init>(Path file, Path directory)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.safe(Path path)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.read(Path p)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.hash(String text)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.parse(String text)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.load()` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.rewrite(String text, Map<String, Boolean> values)` — linha 70. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.apply(Map<String, Boolean> values, Map<String, Boolean> expected)` — linha 111. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.verify(Properties state)` — linha 136. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteConfig.restore()` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/2ae2612ac43a/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.beforeRender()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartup.status()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/3c81bd7661db/main/java/nvvisionboost/NVVisionBoostNeoForgeIntegrations.java

- `NVVisionBoostNeoForgeIntegrations.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNeoForgeIntegrations.report()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/42fc1bc9f4f5/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — linha 30. Leitura em worker; alterações no perfil e no pipeline apenas na thread cliente.
- `NVVisionBoostShaderEngine.disableExternal()` — linha 100. Somente ação manual da interface solicita desligar o backend.
- `NVVisionBoostShaderEngine.loadStatus()` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.<init>()` — linha 133. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostCore.Config cfg)` — linha 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — linha 231. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — linha 235. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.lastCompile()` — linha 239. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.findByName(String name)` — linha 243. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostCore.Config cfg, NVVisionBoostShader.Pack pack)` — linha 270. Perfil genérico por custo estimado, aplicável a qualquer shaderpack.
- `NVVisionBoostShaderEngine.activateWithIris(Path game, String shaderName)` — linha 304. Legacy method kept because older UI/classes may still call it.  ,<p>,Prepara recursos e solicita carregamento real ao backend disponível.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — linha 317. Legacy method kept for source compatibility.  ,<p>,Alias legado: usa o backend disponível; não cria renderer nativo.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — linha 325. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — linha 331. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — linha 430. Prepares the selected shaderpack for Iris.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileIrisActive(Path game)` — linha 489. Prepares the shader currently being used by Iris.
- `NVVisionBoostShaderEngine.disableNative()` — linha 510. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Iris shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — linha 520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderEngine.forceIrisArchitecture(NVVisionBoostCore.Config cfg)` — linha 536. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — linha 554. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/5c34cd25146f/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.configuration()` — linha 52. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCore.<init>()` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/610dd92b16f6/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.loaded(String id)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.oculus()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.iris()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.embeddium()` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.sodium()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.modMenu()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.resolve()` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderPipeline()` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersInUse()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.framebufferScalingRestriction()` — linha 100. Fail closed if Iris state cannot be read; never guess during a shader reload.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — linha 122. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — linha 136. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — linha 151. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.disableExternalShaders()` — linha 156. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.renderer()` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderBackend()` — linha 165. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.summary()` — linha 169. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.integrationSummary()` — linha 180. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — linha 190. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/633ea0eedd8e/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.label(int value)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.status()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — linha 21. API antiga preservada; não aplica mais mapeamentos genéricos inseguros.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/6bc5adbbfe2f/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.loaded(String id)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.oculus()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.iris()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.embeddium()` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.sodium()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.modMenu()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.resolve()` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderPipeline()` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.externalShadersInUse()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.framebufferScalingRestriction()` — linha 100. Fail closed if Iris state cannot be read; never guess during a shader reload.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — linha 120. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — linha 134. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — linha 149. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.disableExternalShaders()` — linha 154. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.renderer()` — linha 159. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.shaderBackend()` — linha 163. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.summary()` — linha 167. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.integrationSummary()` — linha 178. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — linha 182. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/6f829c69dce9/main/java/nvvisionboost/NVVisionBoostFerriteOptions.java

- `NVVisionBoostFerriteOptions.preset(int preset)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteOptions.toggle(Map<String, Boolean> values, Option option)` — linha 86. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteOptions.validate(Map<String, Boolean> values)` — linha 94. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteOptions.<init>()` — linha 103. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/7da95f6767ba/main/java/nvvisionboost/NVVisionBoostCreateCompatibility.java

- `NVVisionBoostCreateCompatibility.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.createLoaded()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.flywheelLoaded()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.protectsMachineRendering()` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.allowsFramebufferScaling()` — linha 20. A escala manual é permitida; não altera o backend ou culling do Flywheel.
- `NVVisionBoostCreateCompatibility.scalingReason()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreateCompatibility.summary()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/a486f5165257/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.modeName(int mode)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.integrations()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostCore.Config cfg)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — linha 75. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — linha 148. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.status()` — linha 153. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/a805fda9a17e/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — linha 56. O botão manual também satisfaz a preparação desta sessão.

## modules/mod/integrations/ab92d061ca7e/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.label(int value)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.status()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — linha 21. API antiga preservada; não aplica mais mapeamentos genéricos inseguros.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/cf33e4ddf816/main/java/nvvisionboost/NVVisionBoostNativeShaderPackRuntime.java

- `NVVisionBoostNativeShaderPackRuntime.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.clear()` — linha 23. Kept for binary/source compatibility.  ,<p>,This method MUST NOT manipulate Iris.
- `NVVisionBoostNativeShaderPackRuntime.activate(Path pack)` — linha 37. Legacy compatibility method.  ,<p>,It deliberately does not activate anything.
- `NVVisionBoostNativeShaderPackRuntime.isActive()` — linha 47. NVVisionBoost must never report its old shader renderer as active.
- `NVVisionBoostNativeShaderPackRuntime.activeName()` — linha 56. The active shader belongs to Iris.  ,<p>,Do not maintain a second active shader state here.
- `NVVisionBoostNativeShaderPackRuntime.status()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.capabilitySummary()` — linha 71. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.render(int inputTexture, int depthTexture, int width, int height)` — linha 81. Legacy renderer hook.  ,<p>,Returning false prevents the NVVisionBoost render pipeline from treating this class as an active shaderpack renderer.
- `NVVisionBoostNativeShaderPackRuntime.resultTexture()` — linha 87. No native shader output texture exists anymore.

## modules/mod/integrations/d33931712eb1/main/java/nvvisionboost/NVVisionBoostIrisShaderCache.java

- `NVVisionBoostIrisShaderCache.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.Result.summary()` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.EntryData.<init>(String name, byte[] bytes)` — linha 105. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.detectIrisShaderPack(Path gameDir)` — linha 118. Tenta descobrir o shaderpack atualmente configurado no Iris.  ,<p>,Não existe dependência direta de compilação com Iris. Reflection é utilizada para evitar que NVVisionBoost deixe de carregar caso Iris não esteja instalado.
- `NVVisionBoostIrisShaderCache.compileIrisActive(Path gameDir)` — linha 225. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.compileSelected(Path gameDir, Path shaderPack)` — linha 248. Analisa e prepara o cache do shaderpack.  ,<p>,NÃO ativa o shader.
- `NVVisionBoostIrisShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 405. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.isMetadata(String name)` — linha 520. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — linha 524. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.readBounded(InputStream input, long max)` — linha 536. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.isShader(String name)` — linha 558. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.isTexture(String name)` — linha 568. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.invokeBoolean(Object target, String methodName)` — linha 576. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.invokeString(Object target, String methodName)` — linha 595. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.longBytes(long value)` — linha 614. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.hex(byte[] bytes)` — linha 627. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisShaderCache.safeMessage(Throwable throwable)` — linha 637. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/e34cb0886619/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.modeName(int mode)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.integrations()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostCore.Config cfg)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — linha 70. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresets.status()` — linha 148. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/f3150819ccd2/test/java/nvvisionboost/NVVisionBoostFerriteCoreTest.java

- `NVVisionBoostFerriteCoreTest.check(boolean value, String text)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCoreTest.rejected(RunnableIO action, String text)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCoreTest.RunnableIO.run()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFerriteCoreTest.run(Path root)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/f32c6ecb467b/test/java/nvvisionboost/NVVisionBoostQualityAndCreateTest.java

- `NVVisionBoostQualityAndCreateTest.check(boolean value)` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostQualityAndCreateTest.Value.<init>(double value)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostQualityAndCreateTest.Value.get()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostQualityAndCreateTest.Value.set(Object input)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostQualityAndCreateTest.main(String[] args)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/integrations/f43ab4555597/main/java/nvvisionboost/NVVisionBoostDistantHorizonsCompatibility.java

- `NVVisionBoostDistantHorizonsCompatibility.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.loaded()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.allowsAutomaticDistanceChanges()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDistantHorizonsCompatibility.report()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/286ded9c089b/test/java/nvvisionboost/NVVisionBoostMenuLayoutTest.java

- `NVVisionBoostMenuLayoutTest.check(boolean value, String message)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayoutTest.overlap(NVVisionBoostMenuLayout.Rect a, NVVisionBoostMenuLayout.Rect b)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayoutTest.run()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayoutTest.main(String[] args)` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/3c07115c426c/main/java/nvvisionboost/NVVisionBoostMenuLayout.java

- `NVVisionBoostMenuLayout.Layout.tabWidth()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.Layout.tab(int index)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.of(int width, int height)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.arrange(Layout layout, List<Rect> original)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.maxScroll(Layout layout, List<Rect> rectangles)` — linha 71. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.clampScroll(int value, int maximum)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.visible(Layout layout, Rect rect, int scroll)` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuLayout.<init>()` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/5d14756fbc7a/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cfg()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.init()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — linha 280. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.onClose()` — linha 286. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.extractRenderState(GuiGraphicsExtractor graphics, int x, int y, float partialTick)` — linha 291. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/5e5c78cdae96/main/java/nvvisionboost/NVVisionBoostGpuTheme.java

- `NVVisionBoostGpuTheme.surface()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.raised()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.hover()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.border()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.muted()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.blend(int a, int b, float mix)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTheme.forBrand(NVVisionBoostGpuCatalog.Brand brand)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/638cc0f9fe13/main/java/nvvisionboost/NVVisionBoostMenuButton.java

- `NVVisionBoostMenuButton.builder(Component message, Button.OnPress press)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuButton.Builder.<init>(Component message, Button.OnPress press)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuButton.Builder.bounds(int x, int y, int width, int height)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuButton.Builder.tooltip(Tooltip tooltip)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuButton.Builder.build()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMenuButton.<init>()` — linha 44. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/6d742ff587f3/main/java/nvvisionboost/NVVisionBoostLanguage.java

- `NVVisionBoostLanguage.reverse()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.phrase(String value)` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.english()` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.select(boolean value)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.loadPreference(Path file)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.savePreference(Path file)` — linha 57. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.load()` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.text(String input)` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguage.<init>()` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/783fda83db15/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.init()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.onClose()` — linha 62. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/898099464d7a/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$resizeMenu(CallbackInfo ci)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/a709e778ccff/main/java/nvvisionboost/NVVisionBoostUi.java

- `NVVisionBoostUi.preference()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.ensure()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.text(String value)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.component(String value)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.tooltip(Component message)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.infoTooltip(Component message)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.enrich(Tooltip original, String label)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.help(String label, boolean reverse)` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.impact(String label)` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.languages(int width, Runnable rebuild, Consumer<Button> add)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.flag(GuiGraphicsExtractor g, int x, int y, boolean us)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.tick()` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.<init>()` — linha 124. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/b85e37d6f61d/test/java/nvvisionboost/NVVisionBoostLanguageTest.java

- `NVVisionBoostLanguageTest.check(boolean value, String message)` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostLanguageTest.main(String[] args)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/c65ef44b1af0/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$resizeMenu(CallbackInfo ci)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/dee3a934c82f/main/java/nvvisionboost/NVVisionBoostUi.java

- `NVVisionBoostUi.preference()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.ensure()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.text(String value)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.component(String value)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.tooltip(Component message)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.infoTooltip(Component message)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.enrich(Tooltip original, String label)` — linha 51. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.help(String label, boolean reverse)` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.impact(String label)` — linha 63. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.languages(int width, Runnable rebuild, Consumer<Button> add)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.flag(GuiGraphics g, int x, int y, boolean us)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.tick()` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUi.<init>()` — linha 124. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/e737801cd808/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cfg()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.init()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — linha 280. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.onClose()` — linha 286. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — linha 291. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformanceScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 319. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/f0c13a90ead4/main/java/nvvisionboost/NVVisionBoostHelp.java

- `NVVisionBoostHelp.help(String label, boolean reverse)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHelp.impact(String label)` — linha 201. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHelp.text(String value)` — linha 258. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHelp.<init>()` — linha 262. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/interface/f40aa5f947ca/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.init()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.onClose()` — linha 62. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 67. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/performance/418fb7ce0be4/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.applySettings(int profile, boolean status)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.analyzeHardwareResources()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.forceIrisPerformanceState()` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configureCreateCompatibility()` — linha 215. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isModLoaded(String modId)` — linha 255. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.normalizeProfile(int profile)` — linha 264. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.profileName(int profile)` — linha 268. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.getPerformanceProfile()` — linha 276. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isEnabled()` — linha 280. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/performance/57c2f34dc94f/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.isBusy()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.status()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.label(int level)` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostCore.Config config)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/performance/5bd31cc25eed/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.isBusy()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.status()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.label(int level)` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostCore.Config config)` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — linha 97. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/performance/c9979b6fdbd1/main/java/nvvisionboost/NVVisionBoostPerformance.java

- `NVVisionBoostPerformance.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.tick(NVVisionBoostCore.Config config)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.limitBlockEntities()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.blockEntityDistance()` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.reduceWeatherParticles()` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPerformance.framerateLimit(int currentLimit)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/performance/f7207da07d7e/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.applySettings(int profile, boolean status)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.analyzeHardwareResources()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.forceIrisPerformanceState()` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.configureCreateCompatibility()` — linha 215. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isModLoaded(String modId)` — linha 255. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.normalizeProfile(int profile)` — linha 264. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.profileName(int profile)` — linha 268. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.getPerformanceProfile()` — linha 276. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VisionOptimizer.isEnabled()` — linha 280. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/028dc9d06bce/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java

- `NVVisionBoostMinecraftMixin.nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$tick(CallbackInfo ci)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$close(CallbackInfo ci)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/39f070837386/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameStart()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — linha 117. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — linha 126. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — linha 144. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.beginWorld()` — linha 153. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.markUpscale()` — linha 157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.endWorld()` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.invalidateWorld()` — linha 165. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameMs()` — linha 169. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.p95Ms()` — linha 173. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuMs()` — linha 177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.upscaleMs()` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — linha 185. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuLikely()` — linha 189. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.status()` — linha 195. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.resolutionStatus()` — linha 210. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/5e9eda0afbdc/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.status()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.initialize()` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — linha 164. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — linha 175. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — linha 179. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.close()` — linha 191. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.capture()` — linha 210. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.restore()` — linha 236. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — linha 263. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — linha 267. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — linha 271. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/69c601071211/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.averageFps()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.lowFpsSamples()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.stableFpsSamples()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.tickDynamicPerformance()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.checkShaderState()` — linha 69. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.resetTracking()` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/88fa452490e1/main/java/nvvisionboost/mixin/NVVisionBoostIrisDepthMixin.java

- `NVVisionBoostIrisDepthMixin.nvvb$depthIdentity(int version, GpuTexture incoming, int width, int height, DepthBufferFormat format, PackDirectives directives, CallbackInfoReturnable<Boolean> ci)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/92912aedf880/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftTargetAccessor.java

- `NVVisionBoostMinecraftTargetAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/9306a63f710b/main/java/nvvisionboost/mixin/NVVisionBoostOptionsMixin.java

- `NVVisionBoostOptionsMixin.nvvb$key(CallbackInfo ci)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/93f1dd3f9862/main/java/nvvisionboost/mixin/NVVisionBoostIrisDepthMixin.java

- `NVVisionBoostIrisDepthMixin.nvvb$depthIdentity(int version, GpuTexture incoming, int width, int height, DepthBufferFormat format, PackDirectives directives, CallbackInfoReturnable<Boolean> ci)` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/9909ab575c1e/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.averageFps()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.lowFpsSamples()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.stableFpsSamples()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.tickDynamicPerformance()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.checkShaderState()` — linha 69. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionDynamicController.resetTracking()` — linha 88. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/a050a520c7e8/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameStart()` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — linha 117. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — linha 126. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — linha 144. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.beginWorld()` — linha 153. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.markUpscale()` — linha 157. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.endWorld()` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.invalidateWorld()` — linha 165. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.frameMs()` — linha 169. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.p95Ms()` — linha 173. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuMs()` — linha 177. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.upscaleMs()` — linha 181. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — linha 185. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.gpuLikely()` — linha 189. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.status()` — linha 195. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameTiming.resolutionStatus()` — linha 210. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/a31c4f4f0988/main/java/nvvisionboost/NVVisionBoostFsr1Upscaler.java

- `NVVisionBoostFsr1Upscaler.<init>()` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.status()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.supported()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.render(int texture, int destination, int width, int height, int outputWidth, int outputHeight, int sharpnessPercent)` — linha 35. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.initialize()` — linha 85. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.link(String fragmentSource)` — linha 143. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.configureEasu(int width, int height, int outputWidth, int outputHeight)` — linha 171. Mesmas constantes de FsrEasuCon, calculadas na CPU apenas quando as dimensões mudam.
- `NVVisionBoostFsr1Upscaler.uniform(int location, float x, float y, float z, float w)` — linha 188. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.ensureTarget(int width, int height)` — linha 197. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.releaseTarget()` — linha 230. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFsr1Upscaler.close()` — linha 236. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/b4c250accbc1/main/java/nvvisionboost/compat/NVVisionBoostMixinPlugin.java

- `NVVisionBoostMixinPlugin.compatible(ClassNode target)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.shouldApplyMixin(String targetName, String mixinName)` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.onLoad(String packageName)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.getRefMapperConfig()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.acceptTargets(Set<String> mine, Set<String> other)` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.getMixins()` — linha 48. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.preApply(String name, ClassNode target, String mixin, IMixinInfo info)` — linha 52. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMixinPlugin.postApply(String name, ClassNode target, String mixin, IMixinInfo info)` — linha 54. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/bf59c94e0a6d/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java

- `NVVisionBoostMinecraftMixin.nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$tick(CallbackInfo ci)` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftMixin.nvvb$close(CallbackInfo ci)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/d32f48026afa/main/java/nvvisionboost/NVVisionBoostUpscaleBudget.java

- `NVVisionBoostUpscaleBudget.mode()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUpscaleBudget.observe(double filterMs, double gpuMs, double frameMs, int targetFps, long now)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostUpscaleBudget.reset()` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/d515f9d544d6/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererAccessor.nvvb$getGameRenderState()` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererAccessor.nvvb$getMainRenderTarget()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/fa5a22498ede/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — linha 73. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — linha 86. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/fc70a72bc018/main/java/nvvisionboost/mixin/NVVisionBoostWindowMixin.java

- `NVVisionBoostWindowMixin.nvvb$worldWidth(CallbackInfoReturnable<Integer> ci)` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostWindowMixin.nvvb$worldHeight(CallbackInfoReturnable<Integer> ci)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/ff198b08c0c0/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getDisplayName()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.setPreset(UpscalePreset preset)` — linha 39. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getCurrentPreset()` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getActiveResolutionInfo()` — linha 64. Retorna a resolução interna calculada sem modificar a janela.
- `UpscalingManager.applyCurrentResolution()` — linha 80. Aplica somente o estado lógico do upscaler. Não chama resizeDisplay() e não altera Minecraft.getWindow(). O framebuffer interno é criado pelo renderer no início do passe de LevelRenderer.
- `UpscalingManager.getScalePercent()` — linha 112. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getScaleFactor()` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalWidth(int windowWidth)` — linha 127. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.getInternalHeight(int windowHeight)` — linha 131. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.syncPresetFromConfig()` — linha 135. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — linha 144. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `UpscalingManager.clamp(int value, int min, int max)` — linha 149. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/ff56b56088ba/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/rendering/ff63671771e6/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/28066533e3af/main/java/nvvisionboost/NVVisionBoostUniformSnapshot.java


## modules/mod/services/32b1ee9bd074/main/java/nvvisionboost/NVVisionBoostContentManager.java

- `NVVisionBoostContentManager.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.shaderpacksDir()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.resourcepacksDir()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.ensureFolders(Path game)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.openFolder(Path p)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.importShader(Path source)` — linha 36. Installs a shaderpack file or directory into .minecraft/shaderpacks. ZIP/JAR shaderpacks are copied as-is; directories are copied recursively.
- `NVVisionBoostContentManager.importResourcePack(Path source)` — linha 42. Installs a resource pack file or directory into .minecraft/resourcepacks.
- `NVVisionBoostContentManager.activateResourcePack(String name)` — linha 51. Activates a resource pack through Minecraft's native repository. This method only changes the selected pack list; it never edits pack data.
- `NVVisionBoostContentManager.mergeSelection(java.util.List<String> previous, String target)` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.importContent(Path source, Path destination, String label)` — linha 107. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.copyDirectory(Path source, Path target)` — linha 133. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostContentManager.stripExtension(String value)` — linha 145. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/3c165c338f7f/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.registerKeys(RegisterKeyMappingsEvent event)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostClient.<init>()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/40c12afdf5ad/main/java/nvvisionboost/NVVisionBoostImageQuality.java

- `NVVisionBoostImageQuality.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostImageQuality.label(NVVisionBoostCore.Config config)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostImageQuality.cycle(NVVisionBoostCore.Config config)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostImageQuality.configure(NVVisionBoostCore.Config config, int scale)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/40ecfc6e085b/main/java/nvvisionboost/NVVisionBoostResolutionPolicy.java

- `NVVisionBoostResolutionPolicy.Sample.valid()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.Sample.gpuLikely()` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.targetFps(int requested, int gameLimit, boolean vsync, int refreshRate)` — linha 33. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.configure(int requestedCeiling, int requestedMinimum, int fps, long now)` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.reset(long now)` — linha 57. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.suspend(long now)` — linha 66. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.scale()` — linha 74. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.reason()` — linha 78. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.observe(Sample sample, long now)` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResolutionPolicy.startTrial(int wanted, boolean decrease, Sample sample, long now)` — linha 138. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/436bd8af5d7e/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setMessage(Component message)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.mouseClicked(net.minecraft.client.input.MouseButtonEvent event, boolean doubleClick)` — linha 84. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/4f40a7c669e0/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — linha 126. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — linha 223. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — linha 248. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — linha 314. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — linha 332. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — linha 343. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/4fa71012b9e9/main/java/nvvisionboost/NVVisionBoostIO.java

- `NVVisionBoostIO.appendLog(Path target, String message)` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.<init>()` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.writeUtf8(Path target, String content)` — linha 47. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.readUtf8(Path file, String fallback)` — linha 72. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.jsonString(String value)` — linha 80. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.normalizeToken(String value)` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.clamp(int value, int min, int max)` — linha 96. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.clamp(double value, double min, double max)` — linha 100. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIO.openFolder(Path folder)` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/5b47c4375880/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencies.blocked()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/622eaa72433e/main/java/nvvisionboost/NVVisionBoostIrisDepthSafety.java

- `NVVisionBoostIrisDepthSafety.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/67a0d93cc41c/main/java/nvvisionboost/NVVisionVramManager.java

- `NVVisionVramManager.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVramManager.getDetectedVramMb()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVramManager.getAllocatedVramMb()` — linha 14. API legada: orçamento consultivo, sem reserva de VRAM. -1 significa desconhecido.
- `NVVisionVramManager.setManualVramAllocation(long value)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionVramManager.analyzeAndAllocateVram()` — linha 24. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/757ef23f7167/main/java/nvvisionboost/NVVisionBoostResourceReload.java

- `NVVisionBoostResourceReload.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResourceReload.active()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResourceReload.begin()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResourceReload.track(CompletableFuture<Void> future)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostResourceReload.finish(Throwable error)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/7bc491b5dfcb/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.resetWorldTracking()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — linha 45. Chamado uma vez por segundo pelo monitor central, nunca por frame.
- `NVVisionBoostRenderController.<init>()` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — linha 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.restorePlayerOptions()` — linha 219. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — linha 237. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — linha 317. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — linha 335. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — linha 339. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — linha 347. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — linha 378. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — linha 382. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — linha 386. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — linha 403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — linha 428. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — linha 443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — linha 453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — linha 461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — linha 465. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — linha 476. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — linha 482. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/8cb94c628cff/main/java/nvvisionboost/NVVisionBoostCacheMaintenance.java

- `NVVisionBoostCacheMaintenance.<init>()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCacheMaintenance.update(Path directory, String version)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCacheMaintenance..preVisitDirectory(Path folder, BasicFileAttributes attributes)` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCacheMaintenance..visitFile(Path file, BasicFileAttributes attributes)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCacheMaintenance..postVisitDirectory(Path folder, IOException error)` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/9f4f7403f842/main/java/nvvisionboost/NVVisionBoostVisualPolicy.java

- `NVVisionBoostVisualPolicy.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVisualPolicy.screenEffectScale(NVVisionBoostCore.Config config, double original)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVisualPolicy.simulationDistance(NVVisionBoostCore.Config config, int original)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/a3346679114a/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — linha 5. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencies.blocked()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/acc462b9c91c/main/java/nvvisionboost/NVVisionBoostPipeline.java

- `NVVisionBoostPipeline.Report.<init>(String name, int shaderFiles, int postPasses, boolean hasGbuffers, boolean hasShadow, List<String> stages)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.<init>()` — linha 36. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.status()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.analyze(Path source)` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.write(Path target, Report report)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.isShader(String n)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.isPostPass(String n)` — linha 117. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.classify(String n, List<String> stages)` — linha 121. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostPipeline.findNestedRoot(Path source)` — linha 132. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/af336f65a301/main/java/nvvisionboost/NVVisionBoostLogger.java

- `NVVisionBoostLogger.logSuccess(String actionName)` — linha 10. Registra uma ação que foi ativada com sucesso.
- `NVVisionBoostLogger.logFailure(String actionName, String reason)` — linha 15. Registra uma tentativa de ativação que falhou ou não funcionou (ex: incompatibilidade).
- `NVVisionBoostLogger.logError(String actionName, Throwable throwable)` — linha 23. Registra erros críticos ocorridos durante a execução.

## modules/mod/services/b95e068ff2ca/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.resetWorldTracking()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — linha 45. Chamado uma vez por segundo pelo monitor central, nunca por frame.
- `NVVisionBoostRenderController.<init>()` — linha 104. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — linha 106. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — linha 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.restorePlayerOptions()` — linha 219. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — linha 233. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — linha 237. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — linha 317. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — linha 335. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — linha 339. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — linha 347. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — linha 378. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — linha 382. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — linha 386. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — linha 403. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — linha 428. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — linha 443. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — linha 453. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — linha 457. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — linha 461. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — linha 465. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — linha 476. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — linha 482. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/bc75245bb9d8/main/java/nvvisionboost/NVVisionBoostUniformSnapshot.java


## modules/mod/services/c3be5f5b3d76/main/java/nvvisionboost/NVVisionBoostFileFingerprint.java

- `NVVisionBoostFileFingerprint.<init>()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFileFingerprint.stamp(Path source)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/d3e181851b4f/main/java/nvvisionboost/NVVisionBoostFrameStatistics.java

- `NVVisionBoostFrameStatistics.add(double milliseconds)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameStatistics.count()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameStatistics.meanMs()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameStatistics.percentile95Ms()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostFrameStatistics.reset()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/d6ea68e88ad7/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.<init>()` — linha 32. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — linha 79. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — linha 87. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/d7759ee9966d/main/java/nvvisionboost/NVVisionBoostNvidiaBackend.java

- `NVVisionBoostNvidiaBackend.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.dlssLibraryPresent()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.frameGenerationAvailable()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNvidiaBackend.status()` — linha 31. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/ddc27b630a01/test/java/nvvisionboost/NVVisionBoostIrisBridgeTest.java

- `NVVisionBoostIrisBridgeTest.require(boolean value, String message)` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostIrisBridgeTest.main(String[] args)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/e0313fb3a43d/main/java/nvvisionboost/NVVisionBoostMemoryMonitor.java

- `NVVisionBoostMemoryMonitor.<init>()` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMemoryMonitor.underPressure()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMemoryMonitor.tick(NVVisionBoostCore.Config cfg)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/f0992ebc9619/test/java/nvvisionboost/NVVisionBoostNeoForgeIrisSchemaTest.java

- `NVVisionBoostNeoForgeIrisSchemaTest.main(String[] args)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/f29820f284b8/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setMessage(Component message)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.mouseClicked(net.minecraft.client.input.MouseButtonEvent event, boolean doubleClick)` — linha 83. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/f5990f44ec46/main/java/nvvisionboost/NVVisionBoostVulkanBridge.java

- `NVVisionBoostVulkanBridge.<init>()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.present()` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.resolve()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.decode(Object value)` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.status()` — linha 54. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.summary()` — linha 71. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.requestBackend(String backend)` — linha 79. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.requestDescriptors(String mode)` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.cpuControl(String key)` — linha 101. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.cycleCpuControl(String key)` — linha 113. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.cpuProfile()` — linha 125. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostVulkanBridge.cycleCpuProfile()` — linha 137. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/services/f96e9a8867fe/main/java/nvvisionboost/NVVisionBoostHardwareBudget.java

- `NVVisionBoostHardwareBudget.Snapshot.summary()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.<init>()` — linha 28. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.detect()` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostHardwareBudget.constrain(NVVisionBoostCore.Config config)` — linha 56. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/0f2deb61e8e6/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.timestampRendererReliable(String renderer)` — linha 21. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.supported()` — linha 27. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.available()` — linha 34. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.samples()` — linha 38. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — linha 42. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.gpuMs()` — linha 46. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.upscaleMs()` — linha 50. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.cpuMs()` — linha 54. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.begin()` — linha 58. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.markUpscale()` — linha 83. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.end()` — linha 89. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.poll()` — linha 98. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — linha 119. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.invalidate()` — linha 123. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuTimer.close()` — linha 130. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/18931593c7e1/main/java/nvvisionboost/NVVisionBoostNativeShaderPackRuntime.java

- `NVVisionBoostNativeShaderPackRuntime.<init>()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.clear()` — linha 23. Kept for binary/source compatibility.  ,<p>,This method MUST NOT manipulate Oculus.
- `NVVisionBoostNativeShaderPackRuntime.activate(Path pack)` — linha 37. Legacy compatibility method.  ,<p>,It deliberately does not activate anything.
- `NVVisionBoostNativeShaderPackRuntime.isActive()` — linha 47. NVVisionBoost must never report its old shader renderer as active.
- `NVVisionBoostNativeShaderPackRuntime.activeName()` — linha 56. The active shader belongs to Oculus.  ,<p>,Do not maintain a second active shader state here.
- `NVVisionBoostNativeShaderPackRuntime.status()` — linha 60. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.capabilitySummary()` — linha 71. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNativeShaderPackRuntime.render(int inputTexture, int depthTexture, int width, int height)` — linha 81. Legacy renderer hook.  ,<p>,Returning false prevents the NVVisionBoost render pipeline from treating this class as an active shaderpack renderer.
- `NVVisionBoostNativeShaderPackRuntime.resultTexture()` — linha 87. No native shader output texture exists anymore.

## modules/mod/shared/3e0c60185c35/test/java/nvvisionboost/NVVisionBoostShaderStartupPolicyTest.java

- `NVVisionBoostShaderStartupPolicyTest.run()` — linha 4. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostShaderStartupPolicyTest.require(boolean valid, String description)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/61f43577008b/test/java/nvvisionboost/NVVisionBoostRenderingPolicyTest.java

- `NVVisionBoostRenderingPolicyTest.check(boolean result, String name)` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderingPolicyTest.run()` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostRenderingPolicyTest.policy(int ceiling, int floor)` — linha 132. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/738a59f6543d/main/java/nvvisionboost/NVVisionBoostGpuCatalog.java

- `NVVisionBoostGpuCatalog.Type.<init>(String label)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.<init>()` — linha 29. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.hardwareRenderer(String renderer)` — linha 32. Extract the hardware label from Zink, retaining unknown/ordinary driver labels.
- `NVVisionBoostGpuCatalog.classify(String vendor, String renderer)` — linha 41. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.brand(String text)` — linha 70. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.lower(String text)` — linha 79. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.additionalPresets()` — linha 84. Suggested starting points, not benchmarks or detected memory capacities.
- `NVVisionBoostGpuCatalog.group(List<NVVisionBoostGPU.Preset> result, String prefix, String architecture, String family, int tier, String[] names)` — linha 161. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.fallback(String name, Identity identity)` — linha 171. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalog.recommendation(String name, String architecture, String family, int tier)` — linha 179. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/892115233543/main/java/nvvisionboost/NVVisionBoostTargetBindings.java

- `NVVisionBoostTargetBindings.<init>()` — linha 8. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTargetBindings.texture(int bound, int oldColor, int oldDepth, int newColor, int newDepth)` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostTargetBindings.framebuffer(int bound, int oldTarget, int newTarget)` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/8a56edab19c8/test/java/nvvisionboost/NVVisionBoostStabilityTest.java

- `NVVisionBoostStabilityTest.check(boolean result, String message)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostStabilityTest.run(Path testRoot)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/914d3ebb0b04/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — linha 37. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — linha 128. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — linha 176. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — linha 204. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — linha 222. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.tickClient()` — linha 257. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — linha 304. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.detectFps()` — linha 346. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — linha 360. Único ponto recomendado para alterar a escala interna.  ,<p>,A troca de escala invalida completamente o framebuffer anterior.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — linha 391. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — linha 420. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.resetUpscaler()` — linha 431. Utilizado quando múltiplas opções gráficas mudam de uma vez.
- `NVVisionBoostCore.saveConfig()` — linha 439. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.gameRoot()` — linha 459. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.saveStatus()` — linha 471. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.writeReadme()` — linha 575. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.log(String message)` — linha 599. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — linha 606. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.unescapeJson(String value)` — linha 618. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.isEnabled()` — linha 632. Estado mestre do mod, independente da escala interna selecionada.
- `NVVisionBoostCore.Config.normalize()` — linha 736. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.load(Path path)` — linha 801. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCore.Config.save(Path path)` — linha 852. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/98722f7acf4c/main/java/nvvisionboost/mixin/NVVisionBoostWeatherParticlesMixin.java

- `NVVisionBoostWeatherParticlesMixin.nvvb$rainParticle(ClientLevel level, ParticleOptions type, double x, double y, double z, double dx, double dy, double dz)` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/b18a424cad21/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — linha 7. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencies.accepts(boolean embeddium, boolean sodium)` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencies.verify()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostDependencies.blocked()` — linha 18. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/b297292cc049/test/java/nvvisionboost/NVVisionBoostCreatePresetTest.java

- `NVVisionBoostCreatePresetTest.Value.<init>(double value)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresetTest.Value.get()` — linha 15. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresetTest.Value.set(Object input)` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresetTest.run(Path root)` — linha 30. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostCreatePresetTest.require(boolean valid, String name)` — linha 93. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/b32f89b492de/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftAccessor.java

- `NVVisionBoostMinecraftAccessor.nvvb$getFramerateLimit()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftAccessor.nvvb$getMainRenderTarget()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostMinecraftAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — linha 22. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/b4a4f2982ad5/main/java/nvvisionboost/mixin/NVVisionBoostBufferSourceAccessor.java

- `NVVisionBoostBufferSourceAccessor.nvvb$getBuilder()` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferSourceAccessor.nvvb$getFixedBuffers()` — linha 17. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferSourceAccessor.nvvb$getLastState()` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferSourceAccessor.nvvb$getStartedBuffers()` — linha 23. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/c3286c1e18a6/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — linha 26. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — linha 45. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.Preset.summary()` — linha 82. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.<init>()` — linha 90. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detect()` — linha 92. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.detectFresh()` — linha 158. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectNonOpenGL(Info i)` — linha 165. Native Minecraft device metadata; never call OpenGL for a non-GL render target.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — linha 195. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presetFor(String gpuName)` — linha 213. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.genericPreset(String name)` — linha 262. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.presets()` — linha 379. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — linha 2009. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — linha 2033. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — linha 2061. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — linha 2086. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — linha 2115. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — linha 2197. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.memoryDiagnostics()` — linha 2204. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — linha 2224. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.pl(String s)` — linha 2266. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGPU.norm(String s)` — linha 2275. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/c4fad481dc1a/main/java/nvvisionboost/mixin/NVVisionBoostBufferBuilderAccessor.java

- `NVVisionBoostBufferBuilderAccessor.nvvb$getRenderedPointer()` — linha 10. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferBuilderAccessor.nvvb$getWritePointer()` — linha 13. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferBuilderAccessor.nvvb$getRenderedCount()` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostBufferBuilderAccessor.nvvb$isBuilding()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/c526284a5717/main/java/nvvisionboost/mixin/NVVisionBoostBlockEntityDistanceMixin.java

- `NVVisionBoostBlockEntityDistanceMixin.nvvb$distance(E entity, float partialTick, PoseStack poseStack, MultiBufferSource buffers, CallbackInfo ci)` — linha 20. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/c6db7f161757/main/java/nvvisionboost/minecraft/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — linha 9. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `VersionAdapter.accessNotice(Component title, Component description)` — linha 14. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/dcb25f48bd75/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(net.neoforged.fml.ModContainer container)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostNeoForge.tick()` — linha 19. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/df112b132c53/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setMessage(Component message)` — linha 40. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — linha 49. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — linha 53. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostOptionButton.mouseClicked(double mouseX, double mouseY, int button)` — linha 83. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/e4b8954b96b7/test/java/nvvisionboost/NVVisionBoostGpuCatalogTest.java

- `NVVisionBoostGpuCatalogTest.check(boolean value, String message)` — linha 11. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalogTest.identity(String vendor, String name, NVVisionBoostGpuCatalog.Brand brand, NVVisionBoostGpuCatalog.Type type)` — linha 16. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.
- `NVVisionBoostGpuCatalogTest.run(Path root)` — linha 25. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

## modules/mod/shared/f4cc1a00dd0b/main/java/nvvisionboost/mixin/NVVisionBoostBackgroundFpsMixin.java

- `NVVisionBoostBackgroundFpsMixin.nvvb$backgroundLimit(CallbackInfoReturnable<Integer> ci)` — linha 12. Contrato não documentado individualmente; consulte a responsabilidade do módulo e o corpo da função.

