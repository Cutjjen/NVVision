# Function index

Generated from Java syntax trees. Contracts come from source comments; an entry without a contract is not an individual function audit. Minecraft variants retain their API differences. See ARCHITECTURE.md for module responsibilities.

## adapters/fabric-1192/mod/main/java/nvvisionboost/legacy/Button.java

- `Button.<init>(int x, int y, int w, int h, Component message, OnPress press, OnTooltip narration)` — line 12. No individual contract; refer to the module responsibility and method body.
- `Button.getX()` — line 16. No individual contract; refer to the module responsibility and method body.
- `Button.getY()` — line 20. No individual contract; refer to the module responsibility and method body.
- `Button.setX(int v)` — line 24. No individual contract; refer to the module responsibility and method body.
- `Button.setY(int v)` — line 28. No individual contract; refer to the module responsibility and method body.
- `Button.setTooltip(Tooltip value)` — line 32. No individual contract; refer to the module responsibility and method body.
- `Button.renderButton(PoseStack pose, int x, int y, float dt)` — line 36. No individual contract; refer to the module responsibility and method body.
- `Button.renderWidget(GuiGraphics g, int x, int y, float dt)` — line 41. No individual contract; refer to the module responsibility and method body.
- `Button.renderToolTip(PoseStack pose, int x, int y)` — line 45. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/legacy/GuiGraphics.java

- `GuiGraphics.<init>(PoseStack pose)` — line 12. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.fill(int x, int y, int r, int b, int c)` — line 16. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.fillGradient(int x, int y, int r, int b, int top, int bottom)` — line 20. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawString(Font f, String s, int x, int y, int c)` — line 24. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawString(Font f, Component s, int x, int y, int c)` — line 28. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawString(Font f, net.minecraft.util.FormattedCharSequence s, int x, int y, int c)` — line 32. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawString(Font f, net.minecraft.util.FormattedCharSequence s, int x, int y, int c, boolean shadow)` — line 36. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawWordWrap(Font f, Component s, int x, int y, int w, int c)` — line 42. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawCenteredString(Font f, String s, int x, int y, int c)` — line 49. No individual contract; refer to the module responsibility and method body.
- `GuiGraphics.drawCenteredString(Font f, Component s, int x, int y, int c)` — line 53. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/legacy/LegacyScreen.java

- `LegacyScreen.<init>(Component title)` — line 8. No individual contract; refer to the module responsibility and method body.
- `LegacyScreen.render(PoseStack pose, int x, int y, float dt)` — line 12. No individual contract; refer to the module responsibility and method body.
- `LegacyScreen.render(GuiGraphics g, int x, int y, float dt)` — line 17. No individual contract; refer to the module responsibility and method body.
- `LegacyScreen.renderBackground(GuiGraphics g)` — line 21. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/legacy/Tooltip.java

- `Tooltip.create(Component message)` — line 7. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/mixin/MinecraftFpsAccessor.java

- `MinecraftFpsAccessor.nvvb$getFps()` — line 10. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/mixin/NVVisionBoostBlockEntityDistanceMixin.java

- `NVVisionBoostBlockEntityDistanceMixin.nvvb$distance(E entity, float partialTick, PoseStack poseStack, MultiBufferSource buffers, CallbackInfo ci)` — line 20. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — line 35. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 635. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 758. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 837. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 933. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 951. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 958. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 982. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 986. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 994. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1018. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1046. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1067. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1085. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1115. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1140. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1172. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1214. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1295. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1321. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1334. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1338. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1342. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1350. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1391. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1404. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1408. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1412. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1416. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1420. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1424. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1433. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1438. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1442. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1454. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1462. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1466. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1470. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1474. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1478. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1483. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1493. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1502. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 183. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 229. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 264. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 311. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 353. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 366. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 392. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 428. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 436. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 456. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 572. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 596. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 603. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 615. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 629. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 733. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 789. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 840. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostDependencyScreen.java

- `NVVisionBoostDependencyScreen.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.init()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.shouldCloseOnEsc()` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.onClose()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 43. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostMenuButton.java

- `NVVisionBoostMenuButton.builder(Component message, Button.OnPress press)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.<init>(Component message, Button.OnPress press)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.bounds(int x, int y, int width, int height)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.tooltip(Tooltip tooltip)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.build()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.<init>()` — line 44. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — line 57. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.shaderPipelineReady()` — line 100. Do not lend attachments to pipelines being destroyed or recompiled.
- `NVVisionBoostNativeRenderer.<init>()` — line 148. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.renderWorld(GameRenderer renderer, float partialTick, long finishTimeNano, PoseStack poseStack)` — line 156. Wrap the complete world pass, including shader hooks and the hand.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — line 167. Dimensions exposed to 3D passes; the physical window remains unchanged.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — line 171. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — line 175. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — line 184. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — line 212. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — line 218. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.requestCpuTransition()` — line 229. Schedule recovery at the start of a frame without reloading the user's shader.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — line 274. Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow maps may have independent dimensions.
- `NVVisionBoostNativeRenderer.renderLevel(LevelRenderer renderer, PoseStack poseStack, float partialTick, long finishTimeNano, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projection)` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrame()` — line 377. Compatibility entry point for earlier mixin versions.
- `NVVisionBoostNativeRenderer.endFrame()` — line 382. Compatibility entry point for earlier callers.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 388. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — line 398. Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the version counter before beginLevelRendering so the backend reattaches depth and recalculates pack-defined sizes, including when returning to native resolution.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 463. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — line 722. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — line 793. Spatial reconstruction into the main framebuffer, without temporal history, frame generation or a native shaderpack backend.
- `NVVisionBoostNativeRenderer.transferWorldDepth()` — line 863. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — line 876. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — line 957. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — line 981. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 1024. Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or graphics-setting changes.
- `NVVisionBoostNativeRenderer.invalidate()` — line 1058. Request another diagnostic sample; resize buffers only when dimensions change.
- `NVVisionBoostNativeRenderer.isActive()` — line 1069. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 1073. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 1088. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalWidth()` — line 1100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalHeight()` — line 1104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 1108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 1112. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.skippedFrames()` — line 1116. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 1120. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.currentFps()` — line 1124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostForge.Config cfg)` — line 1142. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — line 1155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — line 1159. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setMessage(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.mouseClicked(double mouseX, double mouseY, int button)` — line 83. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostOptionsScreenAdapter.java

- `NVVisionBoostOptionsScreenAdapter.place(Screen screen, Button entry)` — line 14. Align only NVVision's button to the current visible layout after other mods initialize it.
- `NVVisionBoostOptionsScreenAdapter.<init>()` — line 32. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 277. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 283. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — line 288. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.resetWorldTracking()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostForge.Config config, int fps)` — line 45. Called by the central monitor once per second, never every frame.
- `NVVisionBoostRenderController.<init>()` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.tick(NVVisionBoostForge.Config config)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostForge.Config config)` — line 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostForge.Config config, int fps)` — line 123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.restorePlayerOptions()` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, int ignoredTier)` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, boolean automaticReapply)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostForge.Config config)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostForge.Config config)` — line 335. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — line 339. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.signature(NVVisionBoostForge.Config c)` — line 347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — line 378. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — line 382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — line 386. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, net.minecraft.client.AmbientOcclusionStatus ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — line 403. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — line 443. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — line 457. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — line 461. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — line 465. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — line 476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — line 482. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.init()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.onClose()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 67. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostUi.java

- `NVVisionBoostUi.preference()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.ensure()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.text(String value)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.component(String value)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tooltip(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.infoTooltip(Component message)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.enrich(Tooltip original, String label)` — line 51. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.help(String label, boolean reverse)` — line 58. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.impact(String label)` — line 63. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.languages(int width, Runnable rebuild, Consumer<Button> add)` — line 67. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.flag(GuiGraphics g, int x, int y, boolean us)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tick()` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.<init>()` — line 124. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionBoostVulkanBridgeScreen.java

- `NVVisionBoostVulkanBridgeScreen.<init>(Screen parent)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.init()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.lines()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.mouseScrolled(double x, double y, double delta)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.render(GuiGraphics g, int x, int y, float tick)` — line 98. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.onClose()` — line 115. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1192/mod/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.averageFps()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.lowFpsSamples()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.stableFpsSamples()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.tickDynamicPerformance()` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.checkShaderState()` — line 68. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.resetTracking()` — line 87. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — line 36. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.tick()` — line 8. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 183. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 229. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 264. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 311. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 353. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 366. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 392. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 428. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 436. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 456. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 572. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 596. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 603. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 615. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 629. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 733. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 789. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 840. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.configuration()` — line 51. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.<init>()` — line 57. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostForge.java

- `NVVisionBoostForge.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — line 57. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.shaderPipelineReady()` — line 100. Do not lend attachments to pipelines being destroyed or recompiled.
- `NVVisionBoostNativeRenderer.<init>()` — line 148. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.renderWorld(GameRenderer renderer, float partialTick, long finishTimeNano, PoseStack poseStack)` — line 156. Wrap the complete world pass, including shader hooks and the hand.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — line 167. Dimensions exposed to 3D passes; the physical window remains unchanged.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — line 171. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — line 175. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — line 184. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — line 212. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — line 218. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.requestCpuTransition()` — line 229. Schedule recovery at the start of a frame without reloading the user's shader.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — line 274. Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow maps may have independent dimensions.
- `NVVisionBoostNativeRenderer.renderLevel(LevelRenderer renderer, PoseStack poseStack, float partialTick, long finishTimeNano, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projection)` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrame()` — line 377. Compatibility entry point for earlier mixin versions.
- `NVVisionBoostNativeRenderer.endFrame()` — line 382. Compatibility entry point for earlier callers.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 388. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — line 398. Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the version counter before beginLevelRendering so the backend reattaches depth and recalculates pack-defined sizes, including when returning to native resolution.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 463. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — line 722. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — line 793. Spatial reconstruction into the main framebuffer, without temporal history, frame generation or a native shaderpack backend.
- `NVVisionBoostNativeRenderer.transferWorldDepth()` — line 863. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — line 876. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — line 957. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — line 981. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 1024. Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or graphics-setting changes.
- `NVVisionBoostNativeRenderer.invalidate()` — line 1058. Request another diagnostic sample; resize buffers only when dimensions change.
- `NVVisionBoostNativeRenderer.isActive()` — line 1069. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 1073. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 1088. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalWidth()` — line 1100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalHeight()` — line 1104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 1108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 1112. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.skippedFrames()` — line 1116. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 1120. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.currentFps()` — line 1124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostForge.Config cfg)` — line 1142. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — line 1155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — line 1159. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1201/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 18. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — line 77. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 134. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 144. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceOculusPerformanceState()` — line 174. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 214. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — line 232. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 254. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 263. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 267. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 275. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 279. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.nativeBackend()` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 47. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 51. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 55. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 59. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 63. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 105. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 119. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 130. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/FabricBridge.java

- `FabricBridge.onInitializeClient()` — line 12. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.beforeFrame()` — line 16. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.afterFrame()` — line 44. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeRenderMixin.java

- `BridgeRenderMixin.nvvbridge$before(CallbackInfo ci)` — line 11. No individual contract; refer to the module responsibility and method body.
- `BridgeRenderMixin.nvvbridge$after(CallbackInfo ci)` — line 16. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeShutdownMixin.java

- `BridgeShutdownMixin.nvvision$restoreOptions(CallbackInfo ci)` — line 11. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 634. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 757. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 857. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 953. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 971. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 978. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 1002. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 1006. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 1014. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1038. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1066. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1087. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1105. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1192. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1288. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1315. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1341. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1354. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1358. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1362. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1370. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1384. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1402. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1411. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1424. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1432. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1436. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1440. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1444. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1448. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1462. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1466. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1474. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1482. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1486. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1490. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1498. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1503. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1508. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1513. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1522. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1608. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 301. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 356. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 382. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 407. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 418. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 426. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 562. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 586. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 593. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 605. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 619. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 723. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 779. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 830. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostFabric.java

- `NVVisionBoostFabric.onInitializeClient()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFabric.tick()` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-12110/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — line 58. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 98. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — line 195. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restore()` — line 210. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — line 216. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.release()` — line 224. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.invalidate()` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.disposeTargets()` — line 235. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 247. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/addon/main/java/nvvisionboost/vulkanbridge/FabricBridge.java

- `FabricBridge.onInitializeClient()` — line 9. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.tick()` — line 13. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.shutdown()` — line 32. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/addon/main/java/nvvisionboost/vulkanbridge/mixin/FabricCpuLifecycleMixin.java

- `FabricCpuLifecycleMixin.nvvision$tick(CallbackInfo ci)` — line 13. No individual contract; refer to the module responsibility and method body.
- `FabricCpuLifecycleMixin.nvvision$close(CallbackInfo ci)` — line 18. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java

- `NVVisionBoostMinecraftMixin.nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$tick(CallbackInfo ci)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$close(CallbackInfo ci)` — line 37. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$resizeMenu(CallbackInfo ci)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — line 41. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostRenderTargetAccessor.java

- `NVVisionBoostRenderTargetAccessor.nvvb$getColorTexture()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setColorTexture(int value)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getDepthTexture()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setDepthTexture(int value)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getStencilEnabled()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setStencilEnabled(boolean value)` — line 27. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.tick()` — line 8. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 149. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 197. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 225. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 278. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 325. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 367. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 380. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 406. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 431. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 442. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 450. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 470. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 482. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 586. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 610. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 617. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 629. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 643. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 747. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 803. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 854. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostFabric.java

- `NVVisionBoostFabric.onInitializeClient()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFabric.tick()` — line 16. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.configuration()` — line 51. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.<init>()` — line 57. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — line 50. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.traceAlignment(String stage)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.<init>()` — line 171. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — line 180. Dimensions exposed to 3D passes; the physical window remains unchanged.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — line 184. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — line 188. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — line 197. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — line 225. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 239. Recover a target after an interrupted frame without switching framebuffers, clearing buffers or recompiling shaders here.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 263. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — line 271. Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow maps may have independent dimensions.
- `NVVisionBoostNativeRenderer.beginFrame()` — line 345. Compatibility entry point for earlier mixin versions.
- `NVVisionBoostNativeRenderer.endFrame()` — line 350. Compatibility entry point for earlier callers.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 356. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — line 366. Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the version counter before beginLevelRendering so the backend reattaches depth and recalculates pack-defined sizes, including when returning to native resolution.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — line 418. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — line 436. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — line 685. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — line 764. Spatial reconstruction into the main framebuffer, without temporal history, frame generation or a native shaderpack backend.
- `NVVisionBoostNativeRenderer.transferWorldDepth()` — line 834. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — line 847. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — line 924. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — line 948. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 991. Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or graphics-setting changes.
- `NVVisionBoostNativeRenderer.invalidate()` — line 1024. Request another diagnostic sample; resize buffers only when dimensions change.
- `NVVisionBoostNativeRenderer.isActive()` — line 1035. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 1039. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 1053. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalWidth()` — line 1065. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalHeight()` — line 1069. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 1073. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 1077. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.skippedFrames()` — line 1081. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 1085. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.currentFps()` — line 1089. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostCore.Config cfg)` — line 1107. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — line 1120. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — line 1124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.isReducedMainBound()` — line 1139. Only the leased main framebuffer participates in this pixel contract.
- `NVVisionBoostNativeRenderer.adaptNativeViewport(int x, int y, int width, int height)` — line 1150. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/rendering/FabricStencilAdapter.java

- `FabricStencilAdapter.enabled(RenderTarget target)` — line 13. No individual contract; refer to the module responsibility and method body.
- `FabricStencilAdapter.request(RenderTarget target)` — line 30. No individual contract; refer to the module responsibility and method body.
- `FabricStencilAdapter.<init>()` — line 42. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-1211/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 18. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — line 77. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 134. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 144. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceOculusPerformanceState()` — line 174. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 214. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — line 232. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 254. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 263. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 267. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 275. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 279. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.nativeBackend()` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 47. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 51. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 55. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 59. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 63. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 105. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 119. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 130. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/FabricBridge.java

- `FabricBridge.onInitializeClient()` — line 12. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.beforeFrame()` — line 16. No individual contract; refer to the module responsibility and method body.
- `FabricBridge.afterFrame()` — line 44. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeRenderMixin.java

- `BridgeRenderMixin.nvvbridge$before(CallbackInfo ci)` — line 11. No individual contract; refer to the module responsibility and method body.
- `BridgeRenderMixin.nvvbridge$after(CallbackInfo ci)` — line 16. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/addon/main/java/nvvisionboost/vulkanbridge/mixin/BridgeShutdownMixin.java

- `BridgeShutdownMixin.nvvision$restoreOptions(CallbackInfo ci)` — line 11. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 634. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 757. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 857. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 953. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 971. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 978. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 1002. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 1006. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 1014. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1038. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1066. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1087. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1105. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1192. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1288. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1315. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1341. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1354. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1358. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1362. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1370. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1384. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1402. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1411. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1424. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1432. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1436. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1440. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1444. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1448. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1462. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1466. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1474. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1482. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1486. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1490. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1498. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1503. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1508. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1513. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 1522. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 301. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 356. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 382. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 407. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 418. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 426. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 562. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 586. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 593. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 605. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 619. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 723. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 779. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 830. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostFabric.java

- `NVVisionBoostFabric.onInitializeClient()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFabric.tick()` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 102. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restore()` — line 226. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.release()` — line 245. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.invalidate()` — line 252. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.disposeTargets()` — line 256. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 268. No individual contract; refer to the module responsibility and method body.

## adapters/fabric-262/mod/main/java/nvvisionboost/NVVisionBoostTargetLease.java

- `NVVisionBoostTargetLease.begin(RenderTarget main, RenderTarget internal)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.restore()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.active()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.validate(RenderTarget main, RenderTarget internal)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.capture(RenderTarget target)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.apply(RenderTarget target, State state)` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.read(RenderTarget target)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.write(RenderTarget target)` — line 65. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/addon/main/java/nvvisionboost/legacy/addon/LegacyCpuAdapter.java

- `LegacyCpuAdapter.initialize()` — line 19. No individual contract; refer to the module responsibility and method body.
- `LegacyCpuAdapter.tick(TickEvent.ClientTickEvent event)` — line 23. No individual contract; refer to the module responsibility and method body.
- `LegacyCpuAdapter.render(RenderLivingEvent.Pre<?> event)` — line 32. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/addon/main/java/nvvisionboost/legacy/addon/LegacyIntegerLease.java

- `LegacyIntegerLease.apply(Object optionOwner, int current, int reduction)` — line 10. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/addon/main/java/nvvisionboost/legacy/addon/NVVisionLegacyAddon.java

- `NVVisionLegacyAddon.initialize(FMLInitializationEvent event)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionLegacyAddon.remoteCompatible(Map<String, String> mods, Side side)` — line 23. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/addon/test/java/nvvisionboost/legacy/addon/LegacyLeaseTest.java

- `LegacyLeaseTest.check(int actual, int expected)` — line 7. No individual contract; refer to the module responsibility and method body.
- `LegacyLeaseTest.main(String[] args)` — line 12. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/main/java/nvvisionboost/legacy/LegacyClient.java

- `LegacyClient.addon()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LegacyClient.initialize()` — line 26. No individual contract; refer to the module responsibility and method body.
- `LegacyClient.tick(TickEvent.ClientTickEvent event)` — line 34. No individual contract; refer to the module responsibility and method body.
- `LegacyClient.options(GuiScreenEvent.InitGuiEvent.Post event)` — line 48. No individual contract; refer to the module responsibility and method body.
- `LegacyClient.height(GuiButton button)` — line 76. No individual contract; refer to the module responsibility and method body.
- `LegacyClient.click(GuiScreenEvent.ActionPerformedEvent.Post event)` — line 88. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/main/java/nvvisionboost/legacy/LegacyConfig.java

- `LegacyConfig.load(Path game)` — line 13. No individual contract; refer to the module responsibility and method body.
- `LegacyConfig.value(Properties p, String key, int max)` — line 30. No individual contract; refer to the module responsibility and method body.
- `LegacyConfig.save()` — line 38. No individual contract; refer to the module responsibility and method body.
- `LegacyConfig.text(String pt, String en)` — line 63. No individual contract; refer to the module responsibility and method body.
- `LegacyConfig.cpuPreset(int preset)` — line 67. No individual contract; refer to the module responsibility and method body.
- `LegacyConfig.<init>()` — line 73. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/main/java/nvvisionboost/legacy/LegacyMenu.java

- `LegacyMenu.<init>(GuiScreen parent)` — line 15. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.t(String pt, String en)` — line 19. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.initGui()` — line 23. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.preset(int p)` — line 94. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.actionPerformed(GuiButton button)` — line 100. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.drawScreen(int x, int y, float dt)` — line 137. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.flag(int x, int y, boolean us)` — line 155. No individual contract; refer to the module responsibility and method body.
- `LegacyMenu.help(int id)` — line 170. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/main/java/nvvisionboost/legacy/LegacyMinecraftAdapter.java

- `LegacyMinecraftAdapter.applyGraphics()` — line 16. No individual contract; refer to the module responsibility and method body.
- `LegacyMinecraftAdapter.restore()` — line 44. No individual contract; refer to the module responsibility and method body.
- `LegacyMinecraftAdapter.supportsSpatialUpscaling()` — line 53. Legacy backend has no verified world/HUD target lease; expose native rendering honestly.
- `LegacyMinecraftAdapter.<init>()` — line 57. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/main/java/nvvisionboost/legacy/NVVisionLegacy.java

- `NVVisionLegacy.initialize(FMLInitializationEvent event)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionLegacy.remoteCompatible(Map<String, String> mods, Side side)` — line 22. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1122/mod/test/java/nvvisionboost/legacy/LegacyConfigTest.java

- `LegacyConfigTest.main(String[] args)` — line 11. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1192/mod/main/java/nvvisionboost/NVVisionBoostForge.java

- `NVVisionBoostForge.<init>()` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 138. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.load(Path path)` — line 186. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 214. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.save(Path path)` — line 232. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.tickClient()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.updateClientMetrics(Config config)` — line 314. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.detectFps()` — line 356. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.setRenderScalePercent(int percent)` — line 369. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostForge.setUpscalingEnabled(boolean enabled)` — line 395. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostForge.toggleUpscaling()` — line 420. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.resetUpscaler()` — line 431. Apply multiple graphics-option changes together.
- `NVVisionBoostForge.saveConfig()` — line 439. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.gameRoot()` — line 459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.saveStatus()` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.writeReadme()` — line 575. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.log(String message)` — line 599. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.stringValue(String json, String key, String fallback)` — line 606. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.unescapeJson(String value)` — line 618. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.isEnabled()` — line 632. Master enable state, independent of the selected internal scale.
- `NVVisionBoostForge.Config.normalize()` — line 736. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.load(Path path)` — line 792. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.save(Path path)` — line 843. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1192/mod/main/java/nvvisionboost/NVVisionBoostScreenEvents.java

- `NVVisionBoostScreenEvents.<init>()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenOpening(ScreenEvent.Opening event)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenInit(ScreenEvent.Init.Post event)` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.beforeScreenRender(ScreenEvent.Render.Pre event)` — line 78. Refresh after other mods change the Options layout; never move their widgets.
- `NVVisionBoostScreenEvents.onClientTick(TickEvent.ClientTickEvent event)` — line 85. F8.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 32. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 36. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 40. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 44. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 86. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 100. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 111. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeBenchmark.java

- `BridgeBenchmark.seconds(String property, int fallback)` — line 26. No individual contract; refer to the module responsibility and method body.
- `BridgeBenchmark.frame(TickEvent.RenderTickEvent event)` — line 30. No individual contract; refer to the module responsibility and method body.
- `BridgeBenchmark.save(Minecraft mc)` — line 74. No individual contract; refer to the module responsibility and method body.
- `BridgeBenchmark.percentile(double[] sorted, double fraction)` — line 128. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeCpuOptimizer.java

- `BridgeCpuOptimizer.<init>()` — line 23. No individual contract; refer to the module responsibility and method body.
- `BridgeCpuOptimizer.initialized()` — line 26. Report whether the addon has read its local configuration.
- `BridgeCpuOptimizer.mode()` — line 31. Return the active in-memory CPU profile for the configuration screen.
- `BridgeCpuOptimizer.control(String key)` — line 36. Read an individual saved control; unknown controls are unavailable.
- `BridgeCpuOptimizer.initialize(Path directory)` — line 45. Load local controls once; unreadable configuration leaves optimization disabled.
- `BridgeCpuOptimizer.read()` — line 62. Read all properties, including unknown user keys that must be preserved.
- `BridgeCpuOptimizer.save(String mode, String distance, String particles)` — line 72. Atomically persist CPU choices while retaining unrelated properties.
- `BridgeCpuOptimizer.request(String value)` — line 83. Request a known profile; change state only after successful persistence.
- `BridgeCpuOptimizer.cycleControl(String key)` — line 89. Cycle an individual control and select the custom profile.
- `BridgeCpuOptimizer.change(String mode, String distance, String particles)` — line 100. Save the choice and schedule application on the client thread when required.
- `BridgeCpuOptimizer.notifyRenderer()` — line 127. Reevaluate limits at most once per second, without rewriting options every frame.
- `BridgeCpuOptimizer.tick()` — line 137. No individual contract; refer to the module responsibility and method body.
- `BridgeCpuOptimizer.applyOptions(Minecraft client)` — line 151. Apply reversible limits in a world and respect changes made by the user or other mods.
- `BridgeCpuOptimizer.logApplied(Minecraft client)` — line 183. Log effective settings after a choice, rather than every frame.
- `BridgeCpuOptimizer.release(Minecraft client)` — line 194. Restore only values still owned by the addon.
- `BridgeCpuOptimizer.shutdown()` — line 206. Release temporary values and save restored settings before client shutdown.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgePresentation.java

- `BridgePresentation.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `BridgePresentation.end(TickEvent.RenderTickEvent event)` — line 19. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/BridgeTestSession.java

- `BridgeTestSession.<init>()` — line 18. No individual contract; refer to the module responsibility and method body.
- `BridgeTestSession.tick(TickEvent.ClientTickEvent event)` — line 20. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/addon/main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java

- `NVVisionVulkanBridge.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionVulkanBridge.Client.shutdown(net.minecraftforge.event.GameShuttingDownEvent event)` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionVulkanBridge.Client.tick(TickEvent.ClientTickEvent event)` — line 30. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$guardBuffers(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$prepareWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$beginWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$endWorld(float partialTick, long finishTimeNano, boolean renderLevel, CallbackInfo ci)` — line 51. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/mixin/NVVisionBoostRenderTargetAccessor.java

- `NVVisionBoostRenderTargetAccessor.nvvb$getColorTexture()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setColorTexture(int value)` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getDepthTexture()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setDepthTexture(int value)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getStencilEnabled()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setStencilEnabled(boolean value)` — line 25. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.<init>()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.openResourceZip(Path file)` — line 82. Older ZIP names may use CP437 without the UTF-8 flag; retry only for this decoding error.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — line 100. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostClient.registerKeyMappings(RegisterKeyMappingsEvent event)` — line 29. Register only the key mapping. Registering a key mapping is not manual EventBus registration.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.onClientTick(TickEvent.ClientTickEvent event)` — line 13. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.loaded(String id)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.oculus()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.iris()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.embeddium()` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.sodium()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.modMenu()` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.resolve()` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderPipeline()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersInUse()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — line 100. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — line 114. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — line 129. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.disableExternalShaders()` — line 134. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.renderer()` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderBackend()` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.summary()` — line 147. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.integrationSummary()` — line 160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — line 164. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 635. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 758. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 837. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 933. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 951. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 958. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 982. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 986. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 994. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1018. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1046. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1067. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1085. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1115. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1140. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1172. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1214. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1295. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1321. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1334. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1338. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1342. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1350. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1391. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1404. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1408. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1412. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1416. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1420. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1424. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1433. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1438. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1442. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1454. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1462. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1466. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1470. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1474. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1478. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1483. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1493. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1502. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostContentManager.java

- `NVVisionBoostContentManager.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.shaderpacksDir()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.resourcepacksDir()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.ensureFolders(Path game)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.openFolder(Path p)` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.importShader(Path source)` — line 36. Installs a shaderpack file or directory into .minecraft/shaderpacks. ZIP/JAR shaderpacks are copied as-is; directories are copied recursively.
- `NVVisionBoostContentManager.importResourcePack(Path source)` — line 42. Installs a resource pack file or directory into .minecraft/resourcepacks.
- `NVVisionBoostContentManager.activateResourcePack(String name)` — line 51. Activates a resource pack through Minecraft's native repository. This method only changes the selected pack list; it never edits pack data.
- `NVVisionBoostContentManager.mergeSelection(java.util.List<String> previous, String target)` — line 101. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.importContent(Path source, Path destination, String label)` — line 107. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.copyDirectory(Path source, Path target)` — line 133. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.stripExtension(String value)` — line 145. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.modeName(int mode)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.integrations()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostForge.Config cfg)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — line 70. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — line 130. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.status()` — line 148. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostDependencyScreen.java

- `NVVisionBoostDependencyScreen.<init>()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.init()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.shouldCloseOnEsc()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.onClose()` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 44. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostDistantHorizonsCompatibility.java

- `NVVisionBoostDistantHorizonsCompatibility.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.loaded()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.allowsAutomaticDistanceChanges()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.report()` — line 21. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostEntityBufferGuard.java

- `NVVisionBoostEntityBufferGuard.<init>()` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.reclaimable(boolean building, int outstanding, long used, boolean ready, boolean ownerEmpty, boolean segmentEmpty)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.field(Class<?> type, String name)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.afterFrame()` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.inspectVanilla(MultiBufferSource.BufferSource source)` — line 77. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.reclaim(BufferBuilder buffer, boolean empty)` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.inspect(Object source)` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferGuard.status()` — line 138. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.configuration()` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.<init>()` — line 59. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostForge.java

- `NVVisionBoostForge.<init>()` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 138. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.load(Path path)` — line 186. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 214. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.save(Path path)` — line 232. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.tickClient()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.updateClientMetrics(Config config)` — line 314. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.detectFps()` — line 356. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.setRenderScalePercent(int percent)` — line 369. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostForge.setUpscalingEnabled(boolean enabled)` — line 395. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostForge.toggleUpscaling()` — line 420. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.resetUpscaler()` — line 431. Apply multiple graphics-option changes together.
- `NVVisionBoostForge.saveConfig()` — line 439. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.gameRoot()` — line 459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.saveStatus()` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.writeReadme()` — line 575. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.log(String message)` — line 599. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.stringValue(String json, String key, String fallback)` — line 606. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.unescapeJson(String value)` — line 618. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.isEnabled()` — line 632. Master enable state, independent of the selected internal scale.
- `NVVisionBoostForge.Config.normalize()` — line 736. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.load(Path path)` — line 792. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.save(Path path)` — line 843. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameStart()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostForge.Config config)` — line 94. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostForge.Config config)` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostForge.Config config)` — line 122. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.beginWorld()` — line 131. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.markUpscale()` — line 135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.endWorld()` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.invalidateWorld()` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameMs()` — line 147. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.p95Ms()` — line 151. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuMs()` — line 155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.upscaleMs()` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — line 163. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuLikely()` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.status()` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.resolutionStatus()` — line 188. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostFsr1Upscaler.java

- `NVVisionBoostFsr1Upscaler.<init>()` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.status()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.supported()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.render(int texture, int destination, int width, int height, int outputWidth, int outputHeight, int sharpnessPercent)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.initialize()` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.link(String fragmentSource)` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.configureEasu(int width, int height, int outputWidth, int outputHeight)` — line 171. Compute FsrEasuCon constants on the CPU only when dimensions change.
- `NVVisionBoostFsr1Upscaler.uniform(int location, float x, float y, float z, float w)` — line 188. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.ensureTarget(int width, int height)` — line 197. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.releaseTarget()` — line 230. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.close()` — line 236. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.summary()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.<init>()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detect()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detectFresh()` — line 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presetFor(String gpuName)` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.genericPreset(String name)` — line 227. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presets()` — line 344. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — line 1974. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostForge.Config c, Preset p)` — line 1998. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostForge.Config c, Preset p)` — line 2026. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.tailor(NVVisionBoostForge.Config config, Preset preset)` — line 2051. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — line 2080. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — line 2162. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryDiagnostics()` — line 2169. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — line 2189. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.pl(String s)` — line 2231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.norm(String s)` — line 2240. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostHardwareBudget.java

- `NVVisionBoostHardwareBudget.Snapshot.summary()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.<init>()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.detect()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.constrain(NVVisionBoostForge.Config config)` — line 56. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostIO.java

- `NVVisionBoostIO.appendLog(Path target, String message)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.<init>()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.writeUtf8(Path target, String content)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.readUtf8(Path file, String fallback)` — line 72. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.jsonString(String value)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.normalizeToken(String value)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.clamp(int value, int min, int max)` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.clamp(double value, double min, double max)` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.openFolder(Path folder)` — line 104. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostMemoryMonitor.java

- `NVVisionBoostMemoryMonitor.<init>()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMemoryMonitor.underPressure()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMemoryMonitor.tick(NVVisionBoostForge.Config cfg)` — line 17. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — line 56. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.shaderPipelineReady()` — line 99. Do not lend attachments to pipelines being destroyed or recompiled.
- `NVVisionBoostNativeRenderer.<init>()` — line 147. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.renderWorld(GameRenderer renderer, float partialTick, long finishTimeNano, PoseStack poseStack)` — line 155. Wrap the complete world pass, including shader hooks and the hand.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — line 166. Dimensions exposed to 3D passes; the physical window remains unchanged.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — line 170. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — line 174. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — line 183. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — line 217. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.requestCpuTransition()` — line 228. Schedule recovery at the start of a frame without reloading the user's shader.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 232. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 265. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — line 273. Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow maps may have independent dimensions.
- `NVVisionBoostNativeRenderer.renderLevel(LevelRenderer renderer, PoseStack poseStack, float partialTick, long finishTimeNano, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projection)` — line 342. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrame()` — line 376. Compatibility entry point for earlier mixin versions.
- `NVVisionBoostNativeRenderer.endFrame()` — line 381. Compatibility entry point for earlier callers.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 387. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — line 397. Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the version counter before beginLevelRendering so the backend reattaches depth and recalculates pack-defined sizes, including when returning to native resolution.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — line 452. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 462. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — line 470. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — line 720. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — line 791. Spatial reconstruction into the main framebuffer, without temporal history, frame generation or a native shaderpack backend.
- `NVVisionBoostNativeRenderer.transferWorldDepth()` — line 861. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — line 874. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — line 955. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — line 979. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 1022. Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or graphics-setting changes.
- `NVVisionBoostNativeRenderer.invalidate()` — line 1056. Request another diagnostic sample; resize buffers only when dimensions change.
- `NVVisionBoostNativeRenderer.isActive()` — line 1067. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 1071. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 1086. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalWidth()` — line 1098. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalHeight()` — line 1102. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 1106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 1110. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.skippedFrames()` — line 1114. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 1118. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.currentFps()` — line 1122. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostForge.Config cfg)` — line 1140. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — line 1153. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — line 1157. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostNvidiaBackend.java

- `NVVisionBoostNvidiaBackend.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.dlssLibraryPresent()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.frameGenerationAvailable()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.status()` — line 31. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostOculusShaderCache.java

- `NVVisionBoostOculusShaderCache.<init>()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.Result.summary()` — line 79. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.EntryData.<init>(String name, byte[] bytes)` — line 97. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.detectOculusShaderPack(Path gameDir)` — line 108. Discover the configured Oculus shaderpack through reflection without a mandatory compile-time dependency.
- `NVVisionBoostOculusShaderCache.compileOculusActive(Path gameDir)` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.compileSelected(Path gameDir, Path shaderPack)` — line 213. Analyze and prepare shaderpack resources without enabling the shader.
- `NVVisionBoostOculusShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 370. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 422. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isMetadata(String name)` — line 485. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — line 489. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.readBounded(InputStream input, long max)` — line 501. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isShader(String name)` — line 523. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isTexture(String name)` — line 533. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.invokeBoolean(Object target, String methodName)` — line 541. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.invokeString(Object target, String methodName)` — line 560. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.longBytes(long value)` — line 579. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.hex(byte[] bytes)` — line 592. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.safeMessage(Throwable throwable)` — line 602. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostPerformance.java

- `NVVisionBoostPerformance.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.tick(NVVisionBoostForge.Config config)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.limitBlockEntities()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.blockEntityDistance()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.reduceWeatherParticles()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.framerateLimit(int currentLimit)` — line 45. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 277. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 283. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — line 288. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostPipelineGate.java

- `NVVisionBoostPipelineGate.ready(boolean selected, Object current)` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipelineGate.reset()` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.resetWorldTracking()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostForge.Config config, int fps)` — line 45. Called by the central monitor once per second, never every frame.
- `NVVisionBoostRenderController.<init>()` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.tick(NVVisionBoostForge.Config config)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostForge.Config config)` — line 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostForge.Config config, int fps)` — line 123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.restorePlayerOptions()` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, int ignoredTier)` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostForge.Config config, boolean automaticReapply)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostForge.Config config)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostForge.Config config)` — line 335. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — line 339. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.signature(NVVisionBoostForge.Config c)` — line 347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — line 378. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — line 382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — line 386. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — line 403. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — line 443. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — line 457. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — line 461. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — line 465. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — line 476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — line 482. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostScreenEvents.java

- `NVVisionBoostScreenEvents.<init>()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenOpening(ScreenEvent.Opening event)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenInit(ScreenEvent.Init.Post event)` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.beforeScreenRender(ScreenEvent.Render.Pre event)` — line 78. Refresh after other mods change the Options layout; never move their widgets.
- `NVVisionBoostScreenEvents.onClientTick(TickEvent.ClientTickEvent event)` — line 85. F8.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShader.java

- `NVVisionBoostShader.Pack.<init>(String name, Path path)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.Pack.<init>(String name, Path path, boolean derivative, int score, int shaderFiles, int sourceLines, int animationCost, int transparencyCost, int shadowCost, int volumetricCost, int postCost, String recommendedProfile, List<String> issues)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.cachedAnalysis(Path source)` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.invalidateAnalysisCache()` — line 81. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.<init>()` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.scan(Path dir, Path cache)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.selected(Path root)` — line 107. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.select(Path root, String name)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.isPack(Path p)` — line 132. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.containsShaderDirectory(Path p)` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.readLimitedSource(java.io.InputStream input)` — line 148. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.analyzePack(Path pack)` — line 155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.findNestedRoot(Path pack)` — line 244. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.isShaderFile(Path p)` — line 252. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.countLines(String source)` — line 263. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.metrics(String path, String source)` — line 270. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.count(String source, String token)` — line 291. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — line 30. Read on a worker; change profiles and pipelines only on the client thread.
- `NVVisionBoostShaderEngine.disableExternal()` — line 100. Only an explicit manual UI action may disable the backend.
- `NVVisionBoostShaderEngine.loadStatus()` — line 127. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.<init>()` — line 133. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostForge.Config cfg)` — line 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — line 235. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.lastCompile()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.findByName(String name)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostForge.Config cfg, NVVisionBoostShader.Pack pack)` — line 270. Generic profile based on estimated shaderpack cost.
- `NVVisionBoostShaderEngine.activateWithOculus(Path game, String shaderName)` — line 301. Legacy entry point: prepare resources and request loading through the available backend.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — line 310. Legacy alias using the available backend; does not create a native shader renderer.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — line 318. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — line 324. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — line 423. Prepares the selected shaderpack for Oculus.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileOculusActive(Path game)` — line 482. Prepares the shader currently being used by Oculus.
- `NVVisionBoostShaderEngine.disableNative()` — line 503. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Oculus shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — line 513. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.forceOculusArchitecture(NVVisionBoostForge.Config cfg)` — line 529. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — line 547. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostForge.Config cfg)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — line 58. Manual preparation also satisfies preparation for this session.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.label(int value)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.status()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostForge.Config config)` — line 21. Retained API entry point without unsafe generic option mappings.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.beforeRender()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.synchronizeFlywheel(Minecraft mc, Object pipeline)` — line 124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.status()` — line 161. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.status()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.initialize()` — line 131. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — line 182. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.close()` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.capture()` — line 213. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.restore()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — line 271. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — line 275. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.isBusy()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.status()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.label(int level)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostForge.Config config)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — line 97. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.init()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.onClose()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 67. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostVisualPolicy.java

- `NVVisionBoostVisualPolicy.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVisualPolicy.screenEffectScale(NVVisionBoostForge.Config config, double original)` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVisualPolicy.simulationDistance(NVVisionBoostForge.Config config, int original)` — line 15. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionBoostVulkanBridgeScreen.java

- `NVVisionBoostVulkanBridgeScreen.<init>(Screen parent)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.init()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.lines()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.mouseScrolled(double x, double y, double delta)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.render(GuiGraphics g, int x, int y, float tick)` — line 98. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.onClose()` — line 115. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.averageFps()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.lowFpsSamples()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.stableFpsSamples()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.tickDynamicPerformance()` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.checkShaderState()` — line 68. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.resetTracking()` — line 87. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — line 17. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getDisplayName()` — line 22. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — line 26. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.<init>()` — line 33. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.setPreset(UpscalePreset preset)` — line 35. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getCurrentPreset()` — line 54. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getActiveResolutionInfo()` — line 60. Return calculated internal dimensions without modifying the window.
- `UpscalingManager.applyCurrentResolution()` — line 73. Apply logical upscaler state without resizeDisplay or window changes; the renderer prepares the internal target at world-pass entry.
- `UpscalingManager.getScalePercent()` — line 104. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getScaleFactor()` — line 114. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalWidth(int windowWidth)` — line 118. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalHeight(int windowHeight)` — line 122. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.syncPresetFromConfig()` — line 126. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — line 135. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.clamp(int value, int min, int max)` — line 140. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 19. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostForge.Config cfg)` — line 78. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 135. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 145. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceOculusPerformanceState()` — line 175. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 215. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostForge.Config cfg)` — line 233. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 255. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 266. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 270. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 278. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 282. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostEntityBufferSmokeTest.java

- `NVVisionBoostEntityBufferSmokeTest.field(String name)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.value(Field f)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getRenderedPointer()` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getWritePointer()` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$getRenderedCount()` — line 57. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.AccountingBuffer.nvvb$isBuilding()` — line 61. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.<init>(AccountingBuffer buffer)` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getBuilder()` — line 89. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getFixedBuffers()` — line 93. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getLastState()` — line 97. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.FixtureSource.nvvb$getStartedBuffers()` — line 101. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostEntityBufferSmokeTest.run()` — line 106. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runTargetBindings()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — line 141. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — line 207. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — line 304. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — line 329. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runTimers()` — line 394. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runPackedDepthTransitions()` — line 458. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.depthTexture(int size, boolean packed)` — line 539. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — line 557. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — line 575. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — line 586. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostPipelineGateTest.java

- `NVVisionBoostPipelineGateTest.main(String[] args)` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipelineGateTest.check(boolean value)` — line 25. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostRegressionTest.java

- `NVVisionBoostRegressionTest.check(boolean result, String name)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.main(String[] args)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testBridgeApi()` — line 43. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testLegacyZip(Path root)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testConfig(Path root)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testVisualPolicies()` — line 157. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testResourceSelection()` — line 186. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testPacks(Path root)` — line 198. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testImport(Path root)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testAtomicWrites(Path root)` — line 268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testResources(Path root)` — line 301. No individual contract; refer to the module responsibility and method body.

## adapters/forge-1201/mod/test/java/nvvisionboost/NVVisionBoostTargetLeaseTest.java

- `NVVisionBoostTargetLeaseTest.check(boolean condition, String message)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.main(String[] args)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runOwnership()` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runDepth(int percent)` — line 94. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.target(int width, int height)` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.<init>(int width, int height, int fbo, int color, int depth)` — line 184. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorTexture()` — line 193. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorTexture(int value)` — line 197. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthTexture()` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthTexture(int value)` — line 205. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getStencilEnabled()` — line 209. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setStencilEnabled(boolean value)` — line 213. No individual contract; refer to the module responsibility and method body.

## adapters/minecraft/1.20.1/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — line 9. No individual contract; refer to the module responsibility and method body.
- `VersionAdapter.accessNotice(Component title, Component description)` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/minecraft/1.21.1/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — line 9. No individual contract; refer to the module responsibility and method body.
- `VersionAdapter.accessNotice(Component title, Component description)` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/minecraft/26.2/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — line 9. No individual contract; refer to the module responsibility and method body.
- `VersionAdapter.accessNotice(Component title, Component description)` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1201/addon/main/java/nvvisionboost/vulkanbridge/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1201/mod/main/java/nvvisionboost/NVVisionBoostForge.java

- `NVVisionBoostForge.<init>()` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 138. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.load(Path path)` — line 186. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 214. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.MachineProfile.save(Path path)` — line 232. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.tickClient()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.updateClientMetrics(Config config)` — line 314. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.detectFps()` — line 356. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.setRenderScalePercent(int percent)` — line 369. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostForge.setUpscalingEnabled(boolean enabled)` — line 395. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostForge.toggleUpscaling()` — line 420. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.resetUpscaler()` — line 431. Apply multiple graphics-option changes together.
- `NVVisionBoostForge.saveConfig()` — line 439. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.gameRoot()` — line 459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.saveStatus()` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.writeReadme()` — line 575. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.log(String message)` — line 599. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.stringValue(String json, String key, String fallback)` — line 606. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.unescapeJson(String value)` — line 618. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.isEnabled()` — line 632. Master enable state, independent of the selected internal scale.
- `NVVisionBoostForge.Config.normalize()` — line 736. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.load(Path path)` — line 792. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostForge.Config.save(Path path)` — line 843. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1201/mod/main/java/nvvisionboost/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.nativeBackend()` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 47. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 51. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 55. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 59. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 63. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 105. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 119. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 130. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.beforeFrame()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.afterFrame()` — line 55. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.registerKeys(RegisterKeyMappingsEvent event)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostClient.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 634. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 757. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 863. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 959. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 977. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 984. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 1008. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 1012. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 1020. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1044. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1072. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1093. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1141. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1149. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1166. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1198. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1240. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1260. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1294. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1321. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1360. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1368. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1376. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1390. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1408. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1430. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1434. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1438. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1442. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1450. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1454. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1464. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1472. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1480. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1492. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1496. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1500. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1504. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1509. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1514. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1519. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1528. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1614. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 301. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 356. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 382. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 407. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 418. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 426. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 562. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 586. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 593. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 605. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 619. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 723. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 779. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 830. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 208. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-12110/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — line 58. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 78. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 105. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 146. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — line 202. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restore()` — line 217. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — line 223. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.release()` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.invalidate()` — line 238. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.disposeTargets()` — line 242. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 254. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 32. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 36. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 40. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 44. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 86. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 100. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 111. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/CpuOptionLease.java

- `CpuOptionLease.update(T current, T desired)` — line 8. No individual contract; refer to the module responsibility and method body.
- `CpuOptionLease.release(T current)` — line 21. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/NVVisionVulkanBridge.java

- `NVVisionVulkanBridge.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionVulkanBridge.Client.shutdown(net.neoforged.neoforge.event.GameShuttingDownEvent event)` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionVulkanBridge.Client.tick(ClientTickEvent.Post event)` — line 30. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/addon/main/java/nvvisionboost/vulkanbridge/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$prepareWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$beginWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$endWorld(net.minecraft.client.DeltaTracker frame, boolean renderLevel, CallbackInfo ci)` — line 46. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostRenderTargetAccessor.java

- `NVVisionBoostRenderTargetAccessor.nvvb$getColorTexture()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setColorTexture(int value)` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getDepthTexture()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setDepthTexture(int value)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getStencilEnabled()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setStencilEnabled(boolean value)` — line 25. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostScreenSizeMixin.java

- `NVVisionBoostScreenSizeMixin.nvvision$screenSize(VertexFormat.Mode mode, Matrix4f view, Matrix4f projection, Window window, CallbackInfo ci)` — line 16. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/mixin/NVVisionBoostViewportMixin.java

- `NVVisionBoostViewportMixin.nvvision$viewport(int x, int y, int width, int height, CallbackInfo ci)` — line 15. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.<init>()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.openResourceZip(Path file)` — line 82. Older ZIP names may use CP437 without the UTF-8 flag; retry only for this decoding error.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — line 100. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.<init>()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostClient.registerKeyMappings(RegisterKeyMappingsEvent event)` — line 31. Register only the key mapping. Registering a key mapping is not manual EventBus registration.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostClientEvents.java

- `NVVisionBoostClientEvents.onClientTick(ClientTickEvent.Post event)` — line 12. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.loaded(String id)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.oculus()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.iris()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.embeddium()` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.sodium()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.modMenu()` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.resolve()` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderPipeline()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersInUse()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — line 100. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — line 114. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — line 129. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.disableExternalShaders()` — line 134. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.renderer()` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderBackend()` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.summary()` — line 147. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.integrationSummary()` — line 160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — line 164. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 635. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 758. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 837. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 933. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 951. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 958. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 982. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 986. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 994. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1019. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1047. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1068. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1086. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1116. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1141. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1174. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1216. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1236. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1270. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1297. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1323. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1336. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1340. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1344. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1352. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1366. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1384. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1393. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1406. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1410. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1414. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1418. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1422. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1426. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1430. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1435. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1440. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1444. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1448. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1456. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1464. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1472. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1480. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1485. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1490. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1495. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1507. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 1510. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 146. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 222. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 240. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 275. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 322. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 377. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 403. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 439. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 447. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 467. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 479. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 583. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 607. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 614. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 626. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 640. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 744. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 800. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 851. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostDependencyScreen.java

- `NVVisionBoostDependencyScreen.<init>()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.init()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.shouldCloseOnEsc()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.onClose()` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencyScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 61. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.configuration()` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.<init>()` — line 59. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.render(GuiGraphics g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 208. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostForge.java


## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameStart()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — line 94. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — line 122. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.beginWorld()` — line 131. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.markUpscale()` — line 135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.endWorld()` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.invalidateWorld()` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameMs()` — line 147. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.p95Ms()` — line 151. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuMs()` — line 155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.upscaleMs()` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — line 163. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuLikely()` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.status()` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.resolutionStatus()` — line 188. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.summary()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.<init>()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detect()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detectFresh()` — line 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presetFor(String gpuName)` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.genericPreset(String name)` — line 227. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presets()` — line 344. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — line 1974. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — line 1998. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — line 2026. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — line 2051. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — line 2080. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — line 2162. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryDiagnostics()` — line 2169. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — line 2189. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.pl(String s)` — line 2231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.norm(String s)` — line 2240. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkTarget(RenderTarget target, String label)` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.checkShaderTargets()` — line 49. Check world depth FBOs, not just the color-only final pass left bound by Oculus.
- `NVVisionBoostNativeRenderer.traceAlignment(String stage)` — line 91. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.<init>()` — line 170. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int nativeWidth)` — line 179. Dimensions exposed to 3D passes; the physical window remains unchanged.
- `NVVisionBoostNativeRenderer.worldHeight(int nativeHeight)` — line 183. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.resizeAuxiliaryTargets(Minecraft mc, int width, int height)` — line 187. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.preserveStencilRequirement(RenderTarget target)` — line 196. A stencil request made while redirected must also survive a return to 100%.
- `NVVisionBoostNativeRenderer.remapTargetTexture(int texture, int oldColor, int oldDepth, RenderTarget target)` — line 224. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.validTexture(int texture)` — line 230. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 238. Recover a target after an interrupted frame without switching framebuffers, clearing buffers or recompiling shaders here.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 262. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.observePipelineResolution()` — line 270. Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow maps may have independent dimensions.
- `NVVisionBoostNativeRenderer.beginFrame()` — line 344. Compatibility entry point for earlier mixin versions.
- `NVVisionBoostNativeRenderer.endFrame()` — line 349. Compatibility entry point for earlier callers.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 355. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.synchronizeShaderDepthTarget()` — line 365. Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the version counter before beginLevelRendering so the backend reattaches depth and recalculates pack-defined sizes, including when returning to native resolution.
- `NVVisionBoostNativeRenderer.findField(Class<?> type, String name)` — line 417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 427. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginFrameInternal()` — line 435. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endFrameInternal()` — line 683. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.blitToOriginal()` — line 762. Spatial reconstruction into the main framebuffer, without temporal history, frame generation or a native shaderpack backend.
- `NVVisionBoostNativeRenderer.transferWorldDepth()` — line 832. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.recreateTarget(int width, int height)` — line 845. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.releaseLowTarget()` — line 922. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restoreOriginalTarget()` — line 946. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 989. Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or graphics-setting changes.
- `NVVisionBoostNativeRenderer.invalidate()` — line 1022. Request another diagnostic sample; resize buffers only when dimensions change.
- `NVVisionBoostNativeRenderer.isActive()` — line 1033. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 1037. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 1051. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalWidth()` — line 1063. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalHeight()` — line 1067. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 1071. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 1075. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.skippedFrames()` — line 1079. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 1083. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.currentFps()` — line 1087. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.wantsProcessing(NVVisionBoostCore.Config cfg)` — line 1105. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.clamp(int value, int min, int max)` — line 1118. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.describe(Throwable throwable)` — line 1122. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.isReducedMainBound()` — line 1137. Only the leased main framebuffer participates in this pixel contract.
- `NVVisionBoostNativeRenderer.adaptNativeViewport(int x, int y, int width, int height)` — line 1148. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(ModContainer container)` — line 9. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostOculusShaderCache.java

- `NVVisionBoostOculusShaderCache.<init>()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.Result.summary()` — line 79. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.EntryData.<init>(String name, byte[] bytes)` — line 97. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.detectOculusShaderPack(Path gameDir)` — line 108. Discover the configured Oculus shaderpack through reflection without a mandatory compile-time dependency.
- `NVVisionBoostOculusShaderCache.compileOculusActive(Path gameDir)` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.compileSelected(Path gameDir, Path shaderPack)` — line 213. Analyze and prepare shaderpack resources without enabling the shader.
- `NVVisionBoostOculusShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 370. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 422. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isMetadata(String name)` — line 485. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — line 489. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.readBounded(InputStream input, long max)` — line 501. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isShader(String name)` — line 523. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.isTexture(String name)` — line 533. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.invokeBoolean(Object target, String methodName)` — line 541. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.invokeString(Object target, String methodName)` — line 560. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.longBytes(long value)` — line 579. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.hex(byte[] bytes)` — line 592. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOculusShaderCache.safeMessage(Throwable throwable)` — line 602. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 277. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 283. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — line 288. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 316. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.resetWorldTracking()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — line 45. Called by the central monitor once per second, never every frame.
- `NVVisionBoostRenderController.<init>()` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — line 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — line 123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.restorePlayerOptions()` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — line 335. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — line 339. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — line 347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — line 378. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — line 382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — line 386. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — line 403. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — line 443. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — line 457. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — line 461. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — line 465. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — line 476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — line 482. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostScreenEvents.java

- `NVVisionBoostScreenEvents.<init>()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenOpening(ScreenEvent.Opening event)` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onScreenInit(ScreenEvent.Init.Post event)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.beforeScreenRender(ScreenEvent.Render.Pre event)` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.placeEntry(Screen screen)` — line 81. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostScreenEvents.onClientTick(ClientTickEvent.Post event)` — line 86. F8.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — line 30. Read on a worker; change profiles and pipelines only on the client thread.
- `NVVisionBoostShaderEngine.disableExternal()` — line 100. Only an explicit manual UI action may disable the backend.
- `NVVisionBoostShaderEngine.loadStatus()` — line 127. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.<init>()` — line 133. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostCore.Config cfg)` — line 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — line 235. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.lastCompile()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.findByName(String name)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostCore.Config cfg, NVVisionBoostShader.Pack pack)` — line 270. Generic profile based on estimated shaderpack cost.
- `NVVisionBoostShaderEngine.activateWithOculus(Path game, String shaderName)` — line 300. Legacy entry point: prepare resources and request loading through the available backend.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — line 309. Legacy alias using the available backend; does not create a native shader renderer.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — line 323. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — line 422. Prepares the selected shaderpack for Oculus.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileOculusActive(Path game)` — line 481. Prepares the shader currently being used by Oculus.
- `NVVisionBoostShaderEngine.disableNative()` — line 502. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Oculus shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — line 512. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.forceOculusArchitecture(NVVisionBoostCore.Config cfg)` — line 528. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — line 546. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — line 58. Manual preparation also satisfies preparation for this session.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.label(int value)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.status()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — line 21. Retained API entry point without unsafe generic option mappings.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.beforeRender()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.synchronizeFlywheel(Minecraft mc, Object pipeline)` — line 124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.status()` — line 161. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostSodiumExtraAdapter.java

- `NVVisionBoostSodiumExtraAdapter.<init>()` — line 6. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSodiumExtraAdapter.describe()` — line 8. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.status()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.initialize()` — line 131. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — line 182. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.close()` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.capture()` — line 213. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.restore()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — line 271. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — line 275. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/NVVisionBoostVulkanBridgeScreen.java

- `NVVisionBoostVulkanBridgeScreen.<init>(Screen parent)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.init()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.lines()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.render(GuiGraphics g, int x, int y, float tick)` — line 98. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.onClose()` — line 115. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridgeScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 121. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/platform/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — line 17. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getDisplayName()` — line 22. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — line 26. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.<init>()` — line 33. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.setPreset(UpscalePreset preset)` — line 35. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getCurrentPreset()` — line 54. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getActiveResolutionInfo()` — line 60. Return calculated internal dimensions without modifying the window.
- `UpscalingManager.applyCurrentResolution()` — line 73. Apply logical upscaler state without resizeDisplay or window changes; the renderer prepares the internal target at world-pass entry.
- `UpscalingManager.getScalePercent()` — line 104. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getScaleFactor()` — line 114. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalWidth(int windowWidth)` — line 118. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalHeight(int windowHeight)` — line 122. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.syncPresetFromConfig()` — line 126. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — line 135. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.clamp(int value, int min, int max)` — line 140. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 19. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — line 78. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 135. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 145. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceOculusPerformanceState()` — line 175. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 215. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — line 233. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 255. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 266. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 270. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 278. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 282. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runTargetBindings()` — line 91. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — line 142. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — line 208. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — line 305. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — line 330. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runTimers()` — line 395. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runPackedDepthTransitions()` — line 459. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.depthTexture(int size, boolean packed)` — line 540. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — line 558. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — line 576. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — line 587. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostPixelAdapterTest.java

- `NVVisionBoostPixelAdapterTest.main(String[] args)` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPixelAdapterTest.check(boolean expected, int x, int y, int w, int h, int tw, int th)` — line 18. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostRegressionTest.java

- `NVVisionBoostRegressionTest.check(boolean result, String name)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.main(String[] args)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testBridgeApi()` — line 43. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testLegacyZip(Path root)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testConfig(Path root)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testVisualPolicies()` — line 157. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testResourceSelection()` — line 186. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testPacks(Path root)` — line 198. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testImport(Path root)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testAtomicWrites(Path root)` — line 268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRegressionTest.testResources(Path root)` — line 301. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostStabilityTest.java

- `NVVisionBoostStabilityTest.check(boolean result, String message)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostStabilityTest.run(Path testRoot)` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-1211/mod/test/java/nvvisionboost/NVVisionBoostTargetLeaseTest.java

- `NVVisionBoostTargetLeaseTest.check(boolean condition, String message)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.main(String[] args)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runPixelOwnership()` — line 47. The same main-target object exchanges attachments; object identity alone does not delimit the world pass.
- `NVVisionBoostTargetLeaseTest.setRenderer(String name, Object value)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runOwnership()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runDepth(int percent)` — line 142. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.target(int width, int height)` — line 191. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.<init>(int width, int height, int fbo, int color, int depth)` — line 232. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorTexture()` — line 241. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorTexture(int value)` — line 245. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthTexture()` — line 249. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthTexture(int value)` — line 253. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getStencilEnabled()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setStencilEnabled(boolean value)` — line 261. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.beforeFrame()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.afterFrame()` — line 53. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererAccessor.nvvb$getGameRenderState()` — line 14. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — line 93. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftAccessor.java

- `NVVisionBoostMinecraftAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — line 11. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 634. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 757. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 863. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 959. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 977. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 984. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 1008. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 1012. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 1020. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1044. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1072. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1093. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1141. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1149. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1166. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1198. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1240. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1260. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1294. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1321. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1360. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1368. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1376. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1390. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1408. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1430. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1434. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1438. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1442. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1450. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1454. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1464. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1472. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1480. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1492. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1496. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1500. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1504. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1509. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1514. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1519. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 1528. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.extractRenderState(GuiGraphicsExtractor g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 109. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — line 221. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restore()` — line 240. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — line 251. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.release()` — line 259. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.invalidate()` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.disposeTargets()` — line 270. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 282. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 280. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 286. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.extractRenderState(GuiGraphicsExtractor graphics, int x, int y, float partialTick)` — line 291. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-2612/mod/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.init()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.onClose()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 67. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/addon/main/java/nvvisionboost/vulkanbridge/NeoForgeBridge.java

- `NeoForgeBridge.<init>()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.beforeFrame()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NeoForgeBridge.afterFrame()` — line 55. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostConfigScreen.java

- `NVVisionBoostConfigScreen.<init>(Screen parent)` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.init()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelLeft()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.panelRight()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentLeft()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentRight()` — line 88. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.contentWidth()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.colWidth()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.col2()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.rebuildInternal()` — line 108. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyScroll()` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.mouseScrolled(double x, double y, double horizontal, double delta)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.onClose()` — line 257. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGeneral(int l, int r, int w)` — line 266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildGpu(int l, int r, int w)` — line 363. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildShaders(int l, int r, int w)` — line 494. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildPerformance(int l, int r, int w)` — line 634. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildCompatibility(int l, int r, int w)` — line 757. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.buildAdvanced(int l, int r, int w)` — line 863. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addShaderButton(NVVisionBoostShader.Pack pack, int x, int y, int w, boolean selected)` — line 959. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addButton(String text, int x, int y, int w, Runnable action)` — line 977. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.addCycle(String text, int x, int y, int w, Runnable next, Runnable previous)` — line 984. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cfg()` — line 1008. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshAfterChange()` — line 1012. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.restoreDefaults()` — line 1020. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggle(String field)` — line 1044. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.toggleUpscaling()` — line 1072. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.filterGpu(String query)` — line 1093. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.refreshGpuButtons()` — line 1111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectGpu(int localIndex)` — line 1141. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyDetected()` — line 1149. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.applyPreset(NVVisionBoostGPU.Preset p)` — line 1166. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.selectShader(NVVisionBoostShader.Pack pack, int direction)` — line 1198. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.compilePendingShader()` — line 1240. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importShader()` — line 1260. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.importResourcePack()` — line 1294. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openChooser(String title, Consumer<Path> callback)` — line 1321. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.openFolder(Path path, String label)` — line 1347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.detect(boolean present)` — line 1360. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.on(boolean value)` — line 1364. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.fit(String text, int max)` — line 1368. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(int value, int[] values, int dir)` — line 1376. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.next(String value, String[] values, int dir)` — line 1390. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScaleNext()` — line 1408. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleScalePrev()` — line 1417. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsNext()` — line 1430. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleFpsPrev()` — line 1434. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationNext()` — line 1438. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleAnimationPrev()` — line 1442. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyNext()` — line 1446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleTransparencyPrev()` — line 1450. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistanceNext()` — line 1454. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleEntityDistancePrev()` — line 1459. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfileNext()` — line 1464. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleProfilePrev()` — line 1468. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistanceNext()` — line 1472. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleRenderDistancePrev()` — line 1480. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistanceNext()` — line 1488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMinRenderDistancePrev()` — line 1492. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistanceNext()` — line 1496. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleMaxRenderDistancePrev()` — line 1500. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikeNext()` — line 1504. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleSpikePrev()` — line 1509. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownNext()` — line 1514. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.cycleCooldownPrev()` — line 1519. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostConfigScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 1528. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostFerriteScreen.java

- `NVVisionBoostFerriteScreen.<init>(Screen parent)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.refresh()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.button(String text, int x, int y, int w, Runnable action, boolean enabled, String help)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.operation(boolean restore)` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.init()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.onClose()` — line 176. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.extractRenderState(GuiGraphicsExtractor g, int x, int y, float tick)` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteScreen.clip(String text)` — line 201. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.summary()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.<init>()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detect()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detectFresh()` — line 158. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectNonOpenGL(Info i)` — line 165. Native Minecraft device metadata; never call OpenGL for a non-GL render target.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — line 199. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presetFor(String gpuName)` — line 222. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.genericPreset(String name)` — line 271. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presets()` — line 388. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — line 2018. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — line 2042. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — line 2070. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — line 2095. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — line 2124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — line 2206. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryDiagnostics()` — line 2213. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — line 2233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.pl(String s)` — line 2275. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.norm(String s)` — line 2284. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostNativeRenderer.java

- `NVVisionBoostNativeRenderer.isProcessingBlocked()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.processedFrames()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.failedFrames()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.lastError()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.effectActive()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.internalResolution()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.measuredResolutionInfo()` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldWidth(int width)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.worldHeight(int height)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.framebufferScalingAllowed()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.scalingRestriction()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.finishInterruptedPass()` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.availablePassStatus()` — line 74. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.prepareFrame()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.beginLevelRender()` — line 109. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.endLevelRender()` — line 164. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.attach(int fbo, RenderTarget target)` — line 226. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.restore()` — line 245. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.fail(RuntimeException e)` — line 256. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.release()` — line 264. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.invalidate()` — line 271. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.disposeTargets()` — line 275. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeRenderer.reset()` — line 287. No individual contract; refer to the module responsibility and method body.

## adapters/neoforge-262/mod/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(net.neoforged.fml.ModContainer container)` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNeoForge.tick()` — line 19. No individual contract; refer to the module responsibility and method body.

## adapters/platform/Fabric/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 8. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 12. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 16. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 20. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 24. No individual contract; refer to the module responsibility and method body.

## adapters/platform/Fabric/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 8. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 12. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 16. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 20. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 24. No individual contract; refer to the module responsibility and method body.

## adapters/platform/Forge/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/platform/Forge/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/platform/NeoForge/addon/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## adapters/platform/NeoForge/mod/LoaderAdapter.java

- `LoaderAdapter.loader()` — line 10. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.gameDirectory()` — line 14. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.configDirectory()` — line 18. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.client()` — line 22. No individual contract; refer to the module responsibility and method body.
- `LoaderAdapter.modLoaded(String id)` — line 26. No individual contract; refer to the module responsibility and method body.

## modules/addon/adapters/addon/main/java/nvvisionboost/vulkanbridge/platform/Platform.java

- `Platform.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `Platform.get()` — line 9. No individual contract; refer to the module responsibility and method body.

## modules/addon/adapters/addon/main/java/nvvisionboost/vulkanbridge/platform/PlatformAdapter.java

- `PlatformAdapter.loader()` — line 7. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.gameDirectory()` — line 9. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.configDirectory()` — line 11. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.client()` — line 13. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.modLoaded(String id)` — line 15. No individual contract; refer to the module responsibility and method body.

## modules/addon/cpu/main/java/nvvisionboost/vulkanbridge/CpuPolicy.java

- `CpuPolicy.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `CpuPolicy.validProfile(String value)` — line 10. Accept only known profiles; missing or invalid configuration cannot enable features.
- `CpuPolicy.distance(String value)` — line 15. Normalize distance and migrate unsupported 25% values to Minecraft's valid 50% minimum.
- `CpuPolicy.particles(String value)` — line 21. Normalize particle policy without changing game state.
- `CpuPolicy.nextDistance(String value)` — line 26. Cycle supported distance-control choices.
- `CpuPolicy.nextParticles(String value)` — line 35. Cycle supported particle-control choices.
- `CpuPolicy.distanceCeiling(String profile, String custom)` — line 44. Return the profile's distance ceiling; -1 means the addon does not own this option.
- `CpuPolicy.particleLimit(String profile, String custom)` — line 60. Resolve the particle limit; off preserves the original choice.
- `CpuPolicy.validDistance(double current, double ceiling)` — line 73. Apply a ceiling without increasing an already valid distance, respecting the game's minimum.

## modules/addon/cpu/runtime/common/main/java/nvvisionboost/vulkanbridge/BridgeCpuOptimizer.java

- `BridgeCpuOptimizer.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeCpuOptimizer.initialized()` — line 25. Report whether the addon has read its local configuration.
- `BridgeCpuOptimizer.mode()` — line 30. Return the active in-memory CPU profile for the configuration screen.
- `BridgeCpuOptimizer.control(String key)` — line 35. Read an individual saved control; unknown controls are unavailable.
- `BridgeCpuOptimizer.initialize(Path directory)` — line 44. Load local controls once; unreadable configuration leaves optimization disabled.
- `BridgeCpuOptimizer.read()` — line 61. Read all properties, including unknown user keys that must be preserved.
- `BridgeCpuOptimizer.save(String mode, String distance, String particles)` — line 71. Atomically persist CPU choices while retaining unrelated properties.
- `BridgeCpuOptimizer.request(String value)` — line 82. Request a known profile; change state only after successful persistence.
- `BridgeCpuOptimizer.cycleControl(String key)` — line 88. Cycle an individual control and select the custom profile.
- `BridgeCpuOptimizer.change(String mode, String distance, String particles)` — line 99. Save the choice and schedule application on the client thread when required.
- `BridgeCpuOptimizer.tick()` — line 123. Reevaluate limits at most once per second, without rewriting options every frame.
- `BridgeCpuOptimizer.applyOptions(Minecraft client)` — line 132. Apply reversible limits in a world and respect changes made by the user or other mods.
- `BridgeCpuOptimizer.logApplied(Minecraft client)` — line 164. Log effective settings after a choice, rather than every frame.
- `BridgeCpuOptimizer.release(Minecraft client)` — line 175. Restore only values still owned by the addon.
- `BridgeCpuOptimizer.shutdown()` — line 187. Release temporary values and save restored settings before client shutdown.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuConfigurationTest.java

- `CpuConfigurationTest.check(boolean value, String message)` — line 9. No individual contract; refer to the module responsibility and method body.
- `CpuConfigurationTest.main(String[] args)` — line 14. No individual contract; refer to the module responsibility and method body.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuOptionLeaseTest.java

- `CpuOptionLeaseTest.check(boolean value)` — line 6. No individual contract; refer to the module responsibility and method body.
- `CpuOptionLeaseTest.main(String[] args)` — line 11. No individual contract; refer to the module responsibility and method body.

## modules/addon/cpu/test/java/nvvisionboost/vulkanbridge/CpuPolicyTest.java

- `CpuPolicyTest.check(boolean value, String label)` — line 6. No individual contract; refer to the module responsibility and method body.
- `CpuPolicyTest.main(String[] args)` — line 11. No individual contract; refer to the module responsibility and method body.

## modules/addon/performance/08a14d4bdd78/main/java/nvvisionboost/vulkanbridge/CpuOptionLease.java

- `CpuOptionLease.update(T current, T desired)` — line 9. Acquire an option and propose a value; external edits end ownership until release.
- `CpuOptionLease.release(T current)` — line 25. Restore the original value only if the current value still matches the addon's applied value.

## modules/addon/services/20686c3ceade/main/java/nvvisionboost/vulkanbridge/BridgeOpaquePresent.java

- `BridgeOpaquePresent.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `BridgeOpaquePresent.normalize(int target)` — line 18. No individual contract; refer to the module responsibility and method body.

## modules/addon/services/41f5167213b6/main/java/nvvisionboost/vulkanbridge/BridgeFiles.java

- `BridgeFiles.<init>()` — line 9. No individual contract; refer to the module responsibility and method body.
- `BridgeFiles.atomic(Path file, String value)` — line 11. No individual contract; refer to the module responsibility and method body.
- `BridgeFiles.profile(Path home)` — line 27. No individual contract; refer to the module responsibility and method body.
- `BridgeFiles.descriptors(Path home, String value)` — line 39. No individual contract; refer to the module responsibility and method body.
- `BridgeFiles.backend(Path home, String backend)` — line 49. No individual contract; refer to the module responsibility and method body.

## modules/addon/services/8fbf9c2bdb2a/main/java/nvvisionboost/vulkanbridge/BridgePolicy.java

- `BridgePolicy.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `BridgePolicy.classify(String renderer, String version)` — line 9. No individual contract; refer to the module responsibility and method body.
- `BridgePolicy.translated(String renderer, String version, boolean framebuffer, boolean shaders)` — line 19. No individual contract; refer to the module responsibility and method body.

## modules/addon/services/b1e163f5cbfe/main/java/nvvisionboost/vulkanbridge/BridgeApi.java

- `BridgeApi.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.snapshot()` — line 24. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.nativeBackend()` — line 28. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuControl(String key)` — line 47. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cycleCpuControl(String key)` — line 51. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.cpuProfile()` — line 55. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestCpuProfile(String value)` — line 59. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.inspect()` — line 63. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestBackend(String backend)` — line 105. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.requestDescriptors(String value)` — line 119. No individual contract; refer to the module responsibility and method body.
- `BridgeApi.report(Path root)` — line 130. No individual contract; refer to the module responsibility and method body.

## modules/addon/services/f90459b3561e/test/java/nvvisionboost/vulkanbridge/BridgeRegressionTest.java

- `BridgeRegressionTest.check(boolean result)` — line 8. No individual contract; refer to the module responsibility and method body.
- `BridgeRegressionTest.main(String[] args)` — line 13. No individual contract; refer to the module responsibility and method body.

## modules/addon/shared/1a092bfe87c2/main/java/nvvisionboost/vulkanbridge/BridgePreflight.java

- `BridgePreflight.compile(int type, String source)` — line 12. No individual contract; refer to the module responsibility and method body.
- `BridgePreflight.main(String[] args)` — line 24. No individual contract; refer to the module responsibility and method body.

## modules/addon/shared/1e2274031a9b/main/java/nvvisionboost/vulkanbridge/CpuMinecraftAdapter.java

- `CpuMinecraftAdapter.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `CpuMinecraftAdapter.particles(Minecraft client)` — line 11. Reads the native particle budget: 0=all, 1=decreased, 2=minimal.
- `CpuMinecraftAdapter.particles(Minecraft client, int budget)` — line 16. Writes a valid native particle budget on the client thread.

## modules/addon/shared/2c8eaf364f2f/test/java/nvvisionboost/vulkanbridge/BridgeRegressionTest.java

- `BridgeRegressionTest.check(boolean result)` — line 8. No individual contract; refer to the module responsibility and method body.
- `BridgeRegressionTest.main(String[] args)` — line 13. No individual contract; refer to the module responsibility and method body.

## modules/addon/shared/8cd8856f3ee6/main/java/nvvisionboost/vulkanbridge/BridgeBenchmarkPolicy.java

- `BridgeBenchmarkPolicy.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `BridgeBenchmarkPolicy.valid(int frames, int capacity, double sampledMs, double requiredMs, String requested, String actual)` — line 7. No individual contract; refer to the module responsibility and method body.

## modules/addon/shared/907bc6d9773f/main/java/nvvisionboost/vulkanbridge/CpuMinecraftAdapter.java

- `CpuMinecraftAdapter.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `CpuMinecraftAdapter.particles(Minecraft client)` — line 11. Reads the native particle budget: 0=all, 1=decreased, 2=minimal.
- `CpuMinecraftAdapter.particles(Minecraft client, int budget)` — line 16. Writes a valid native particle budget on the client thread.

## modules/mod/adapters/MinecraftAccess.java/main/java/nvvisionboost/minecraft/MinecraftAccess.java

- `MinecraftAccess.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `MinecraftAccess.get()` — line 9. No individual contract; refer to the module responsibility and method body.

## modules/mod/adapters/MinecraftVersionAdapter.java/main/java/nvvisionboost/minecraft/MinecraftVersionAdapter.java

- `MinecraftVersionAdapter.mainRenderTarget()` — line 8. No individual contract; refer to the module responsibility and method body.
- `MinecraftVersionAdapter.accessNotice(Component title, Component description)` — line 10. No individual contract; refer to the module responsibility and method body.

## modules/mod/adapters/mod/main/java/nvvisionboost/platform/Platform.java

- `Platform.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `Platform.get()` — line 9. No individual contract; refer to the module responsibility and method body.

## modules/mod/adapters/mod/main/java/nvvisionboost/platform/PlatformAdapter.java

- `PlatformAdapter.loader()` — line 7. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.gameDirectory()` — line 9. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.configDirectory()` — line 11. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.client()` — line 13. No individual contract; refer to the module responsibility and method body.
- `PlatformAdapter.modLoaded(String id)` — line 15. No individual contract; refer to the module responsibility and method body.

## modules/mod/configuration/25d7d409d61f/test/java/nvvisionboost/NVVisionBoostNeoForgeConfigTest.java

- `NVVisionBoostNeoForgeConfigTest.main(String[] args)` — line 6. No individual contract; refer to the module responsibility and method body.

## modules/mod/configuration/5c17043943ca/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.available()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.samples()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.gpuMs()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.upscaleMs()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.cpuMs()` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.begin()` — line 46. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.markUpscale()` — line 84. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.end()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.poll()` — line 99. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — line 120. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.invalidate()` — line 124. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.close()` — line 131. No individual contract; refer to the module responsibility and method body.

## modules/mod/configuration/5fcbaf1fef14/main/java/nvvisionboost/NVVisionBoostGpuCatalog.java

- `NVVisionBoostGpuCatalog.Type.<init>(String label)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.<init>()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.classify(String vendor, String renderer)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.brand(String text)` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.lower(String text)` — line 69. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.additionalPresets()` — line 74. Suggested starting points, not benchmarks or detected memory capacities.
- `NVVisionBoostGpuCatalog.group(List<NVVisionBoostGPU.Preset> result, String prefix, String architecture, String family, int tier, String[] names)` — line 151. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.fallback(String name, Identity identity)` — line 161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.recommendation(String name, String architecture, String family, int tier)` — line 169. No individual contract; refer to the module responsibility and method body.

## modules/mod/configuration/71b50cf51d28/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.available()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.samples()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.gpuMs()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.upscaleMs()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.cpuMs()` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.begin()` — line 46. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.markUpscale()` — line 81. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.end()` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.poll()` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.invalidate()` — line 121. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.close()` — line 128. No individual contract; refer to the module responsibility and method body.

## modules/mod/configuration/8bbd7b8ceece/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.summary()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.<init>()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detect()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detectFresh()` — line 153. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presetFor(String gpuName)` — line 177. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.genericPreset(String name)` — line 226. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presets()` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — line 1973. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — line 1997. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — line 2025. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — line 2050. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — line 2079. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — line 2161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryDiagnostics()` — line 2168. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — line 2188. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.pl(String s)` — line 2230. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.norm(String s)` — line 2239. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/0386b2d3638f/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — line 58. Manual preparation also satisfies preparation for this session.

## modules/mod/integrations/1367072ff8f6/main/java/nvvisionboost/NVVisionBoostShader.java

- `NVVisionBoostShader.Pack.<init>(String name, Path path)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.Pack.<init>(String name, Path path, boolean derivative, int score, int shaderFiles, int sourceLines, int animationCost, int transparencyCost, int shadowCost, int volumetricCost, int postCost, String recommendedProfile, List<String> issues)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.cachedAnalysis(Path source)` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.invalidateAnalysisCache()` — line 81. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.<init>()` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.scan(Path dir, Path cache)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.selected(Path root)` — line 107. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.select(Path root, String name)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.isPack(Path p)` — line 132. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.containsShaderDirectory(Path p)` — line 139. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.readLimitedSource(java.io.InputStream input)` — line 148. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.analyzePack(Path pack)` — line 155. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.findNestedRoot(Path pack)` — line 244. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.isShaderFile(Path p)` — line 252. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.countLines(String source)` — line 263. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.metrics(String path, String source)` — line 270. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShader.count(String source, String token)` — line 291. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/179aef91735a/main/java/nvvisionboost/NVVisionBoostShaderStartupPolicy.java

- `NVVisionBoostShaderStartupPolicy.begin(Object currentWorld, String currentPack, Object currentPipeline)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartupPolicy.complete(Object preparedPipeline)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartupPolicy.reset()` — line 25. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/27cdd1e1aa69/main/java/nvvisionboost/NVVisionBoostFerriteConfig.java

- `NVVisionBoostFerriteConfig.<init>(Path file, Path directory)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.safe(Path path)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.read(Path p)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.hash(String text)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.parse(String text)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.load()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.rewrite(String text, Map<String, Boolean> values)` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.apply(Map<String, Boolean> values, Map<String, Boolean> expected)` — line 111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.verify(Properties state)` — line 136. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteConfig.restore()` — line 145. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/2ae2612ac43a/main/java/nvvisionboost/NVVisionBoostShaderStartup.java

- `NVVisionBoostShaderStartup.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.beforeRender()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartup.status()` — line 13. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/3c81bd7661db/main/java/nvvisionboost/NVVisionBoostNeoForgeIntegrations.java

- `NVVisionBoostNeoForgeIntegrations.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNeoForgeIntegrations.report()` — line 10. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/42fc1bc9f4f5/main/java/nvvisionboost/NVVisionBoostShaderEngine.java

- `NVVisionBoostShaderEngine.isPreparing()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.prepareAsync(Path game, String name, boolean activate)` — line 30. Read on a worker; change profiles and pipelines only on the client thread.
- `NVVisionBoostShaderEngine.disableExternal()` — line 100. Only an explicit manual UI action may disable the backend.
- `NVVisionBoostShaderEngine.loadStatus()` — line 127. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.<init>()` — line 133. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.refresh(Path game, NVVisionBoostCore.Config cfg)` — line 140. Re-scans shaderpacks and updates analysis/cache.  ,<p>,This method never activates a shaderpack.
- `NVVisionBoostShaderEngine.selected()` — line 231. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.setSelected(NVVisionBoostShader.Pack pack)` — line 235. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.lastCompile()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.findByName(String name)` — line 243. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.applyRecommended(NVVisionBoostCore.Config cfg, NVVisionBoostShader.Pack pack)` — line 270. Generic profile based on estimated shaderpack cost.
- `NVVisionBoostShaderEngine.activateWithIris(Path game, String shaderName)` — line 300. Legacy entry point: prepare resources and request loading through the available backend.
- `NVVisionBoostShaderEngine.activateNative(Path game, String shaderName)` — line 309. Legacy alias using the available backend; does not create a native shader renderer.
- `NVVisionBoostShaderEngine.canReusePipeline(boolean enabled, String current, String requested, boolean loaded)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.loadShaderPipeline(String shaderName)` — line 323. Carrega o pipeline real, com includes/macros/texturas tratados pelo backend.
- `NVVisionBoostShaderEngine.compileSelectedByName(Path game, String shaderName)` — line 422. Prepares the selected shaderpack for Iris.  ,<p>,Does not activate it.
- `NVVisionBoostShaderEngine.compileIrisActive(Path game)` — line 481. Prepares the shader currently being used by Iris.
- `NVVisionBoostShaderEngine.disableNative()` — line 502. Old method retained for compatibility.  ,<p>,It only guarantees that NV native shader rendering remains disabled.  ,<p>,It MUST NOT disable Iris shaders.
- `NVVisionBoostShaderEngine.samePack(NVVisionBoostShader.Pack pack, String name)` — line 512. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderEngine.forceIrisArchitecture(NVVisionBoostCore.Config cfg)` — line 528. Central protection against old presets/configurations enabling the removed NV native shader renderer.
- `NVVisionBoostShaderEngine.writeReport(Path game, NVVisionBoostShader.Pack pack)` — line 546. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/5c34cd25146f/main/java/nvvisionboost/NVVisionBoostFerriteCore.java

- `NVVisionBoostFerriteCore.detect()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.configuration()` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCore.<init>()` — line 58. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/610dd92b16f6/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.loaded(String id)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.oculus()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.iris()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.embeddium()` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.sodium()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.modMenu()` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.resolve()` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderPipeline()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersInUse()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.framebufferScalingRestriction()` — line 100. Fail closed if Iris state cannot be read; never guess during a shader reload.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — line 122. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — line 136. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — line 151. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.disableExternalShaders()` — line 156. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.renderer()` — line 161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderBackend()` — line 165. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.summary()` — line 169. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.integrationSummary()` — line 180. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — line 190. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/633ea0eedd8e/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.label(int value)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.status()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — line 21. Retained API entry point without unsafe generic option mappings.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — line 26. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/6bc5adbbfe2f/main/java/nvvisionboost/NVVisionBoostCompatibility.java

- `NVVisionBoostCompatibility.<init>()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.loaded(String id)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.oculus()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.iris()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.embeddium()` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.sodium()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.modMenu()` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShaderBackendAvailable()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.resolve()` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderPipeline()` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.externalShadersInUse()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.framebufferScalingRestriction()` — line 100. Fail closed if Iris state cannot be read; never guess during a shader reload.
- `NVVisionBoostCompatibility.externalShadersEnabled()` — line 120. Persisted choice is available in the menu, before a world pipeline exists.
- `NVVisionBoostCompatibility.externalShaderPackName()` — line 134. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.applyExternalShaderPack(String name)` — line 149. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.disableExternalShaders()` — line 154. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.renderer()` — line 159. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.shaderBackend()` — line 163. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.summary()` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.integrationSummary()` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCompatibility.isShaderScreen(Object screen)` — line 182. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/6f829c69dce9/main/java/nvvisionboost/NVVisionBoostFerriteOptions.java

- `NVVisionBoostFerriteOptions.preset(int preset)` — line 78. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteOptions.toggle(Map<String, Boolean> values, Option option)` — line 86. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteOptions.validate(Map<String, Boolean> values)` — line 94. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteOptions.<init>()` — line 103. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/7da95f6767ba/main/java/nvvisionboost/NVVisionBoostCreateCompatibility.java

- `NVVisionBoostCreateCompatibility.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.createLoaded()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.flywheelLoaded()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.protectsMachineRendering()` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.allowsFramebufferScaling()` — line 20. Allow manual scale without changing Flywheel backend or culling.
- `NVVisionBoostCreateCompatibility.scalingReason()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.allowsAutomaticScaleChanges()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreateCompatibility.summary()` — line 34. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/a486f5165257/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.modeName(int mode)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.integrations()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostCore.Config cfg)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — line 75. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — line 135. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — line 148. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.status()` — line 153. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/a805fda9a17e/main/java/nvvisionboost/NVVisionBoostShaderLifecycle.java

- `NVVisionBoostShaderLifecycle.<init>()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.tick(NVVisionBoostCore.Config cfg)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderLifecycle.markPrepared(String pack)` — line 58. Manual preparation also satisfies preparation for this session.

## modules/mod/integrations/ab92d061ca7e/main/java/nvvisionboost/NVVisionBoostShaderQuality.java

- `NVVisionBoostShaderQuality.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.label(int value)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.status()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderQuality.apply(NVVisionBoostCore.Config config)` — line 21. Retained API entry point without unsafe generic option mappings.
- `NVVisionBoostShaderQuality.openOptions(Screen parent)` — line 26. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/cf33e4ddf816/main/java/nvvisionboost/NVVisionBoostNativeShaderPackRuntime.java

- `NVVisionBoostNativeShaderPackRuntime.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.clear()` — line 23. Kept for binary/source compatibility.  ,<p>,This method MUST NOT manipulate Iris.
- `NVVisionBoostNativeShaderPackRuntime.activate(Path pack)` — line 37. Legacy compatibility method.  ,<p>,It deliberately does not activate anything.
- `NVVisionBoostNativeShaderPackRuntime.isActive()` — line 47. NVVisionBoost must never report its old shader renderer as active.
- `NVVisionBoostNativeShaderPackRuntime.activeName()` — line 56. The active shader belongs to Iris.  ,<p>,Do not maintain a second active shader state here.
- `NVVisionBoostNativeShaderPackRuntime.status()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.capabilitySummary()` — line 71. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.render(int inputTexture, int depthTexture, int width, int height)` — line 81. Legacy renderer hook.  ,<p>,Returning false prevents the NVVisionBoost render pipeline from treating this class as an active shaderpack renderer.
- `NVVisionBoostNativeShaderPackRuntime.resultTexture()` — line 87. No native shader output texture exists anymore.

## modules/mod/integrations/d33931712eb1/main/java/nvvisionboost/NVVisionBoostIrisShaderCache.java

- `NVVisionBoostIrisShaderCache.<init>()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.Result.<init>(boolean success, String shaderName, String cacheId, Path cacheDir, int shaderFiles, int textures, int validated, int validationFailures, String message)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.Result.summary()` — line 78. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.EntryData.<init>(String name, byte[] bytes)` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.detectIrisShaderPack(Path gameDir)` — line 107. Discover the configured Iris shaderpack reflectively without a mandatory compile-time dependency.
- `NVVisionBoostIrisShaderCache.compileIrisActive(Path gameDir)` — line 193. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.compileSelected(Path gameDir, Path shaderPack)` — line 212. Analyze and prepare shaderpack resources without enabling the shader.
- `NVVisionBoostIrisShaderCache.readDirectory(Path root, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 369. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.readZip(Path zipPath, List<EntryData> shaders, List<String> textures, MessageDigest packDigest)` — line 421. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.isMetadata(String name)` — line 484. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.hashResource(InputStream input, long limit, MessageDigest digest)` — line 488. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.readBounded(InputStream input, long max)` — line 500. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.isShader(String name)` — line 522. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.isTexture(String name)` — line 532. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.invokeBoolean(Object target, String methodName)` — line 540. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.invokeString(Object target, String methodName)` — line 559. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.longBytes(long value)` — line 578. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.hex(byte[] bytes)` — line 591. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisShaderCache.safeMessage(Throwable throwable)` — line 601. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/e34cb0886619/main/java/nvvisionboost/NVVisionBoostCreatePresets.java

- `NVVisionBoostCreatePresets.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.modeName(int mode)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.integrations()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.tick(NVVisionBoostCore.Config cfg)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.apply(Object client, int mode, Path backup)` — line 70. Also used with config fixtures to test backup/recovery across application sessions.
- `NVVisionBoostCreatePresets.writeBackup(Properties saved, Path backup)` — line 130. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.set(Object configValue, double number)` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresets.status()` — line 148. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/f3150819ccd2/test/java/nvvisionboost/NVVisionBoostFerriteCoreTest.java

- `NVVisionBoostFerriteCoreTest.check(boolean value, String text)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCoreTest.rejected(RunnableIO action, String text)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCoreTest.RunnableIO.run()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFerriteCoreTest.run(Path root)` — line 28. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/f32c6ecb467b/test/java/nvvisionboost/NVVisionBoostQualityAndCreateTest.java

- `NVVisionBoostQualityAndCreateTest.check(boolean value)` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostQualityAndCreateTest.Value.<init>(double value)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostQualityAndCreateTest.Value.get()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostQualityAndCreateTest.Value.set(Object input)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostQualityAndCreateTest.main(String[] args)` — line 34. No individual contract; refer to the module responsibility and method body.

## modules/mod/integrations/f43ab4555597/main/java/nvvisionboost/NVVisionBoostDistantHorizonsCompatibility.java

- `NVVisionBoostDistantHorizonsCompatibility.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.loaded()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.allowsAutomaticDistanceChanges()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.allowsFramebufferScaling()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDistantHorizonsCompatibility.report()` — line 21. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/286ded9c089b/test/java/nvvisionboost/NVVisionBoostMenuLayoutTest.java

- `NVVisionBoostMenuLayoutTest.check(boolean value, String message)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayoutTest.overlap(NVVisionBoostMenuLayout.Rect a, NVVisionBoostMenuLayout.Rect b)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayoutTest.run()` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayoutTest.main(String[] args)` — line 85. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/3c07115c426c/main/java/nvvisionboost/NVVisionBoostMenuLayout.java

- `NVVisionBoostMenuLayout.Layout.tabWidth()` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.Layout.tab(int index)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.of(int width, int height)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.arrange(Layout layout, List<Rect> original)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.maxScroll(Layout layout, List<Rect> rectangles)` — line 71. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.clampScroll(int value, int maximum)` — line 78. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.visible(Layout layout, Rect rect, int scroll)` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuLayout.<init>()` — line 87. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/5d14756fbc7a/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 280. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 286. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.extractRenderState(GuiGraphicsExtractor graphics, int x, int y, float partialTick)` — line 291. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/5e5c78cdae96/main/java/nvvisionboost/NVVisionBoostGpuTheme.java

- `NVVisionBoostGpuTheme.surface()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.raised()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.hover()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.border()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.muted()` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.blend(int a, int b, float mix)` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTheme.forBrand(NVVisionBoostGpuCatalog.Brand brand)` — line 32. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/638cc0f9fe13/main/java/nvvisionboost/NVVisionBoostMenuButton.java

- `NVVisionBoostMenuButton.builder(Component message, Button.OnPress press)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.<init>(Component message, Button.OnPress press)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.bounds(int x, int y, int width, int height)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.tooltip(Tooltip tooltip)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.Builder.build()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMenuButton.<init>()` — line 44. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/6d742ff587f3/main/java/nvvisionboost/NVVisionBoostLanguage.java

- `NVVisionBoostLanguage.reverse()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.phrase(String value)` — line 33. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.english()` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.select(boolean value)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.loadPreference(Path file)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.savePreference(Path file)` — line 57. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.load()` — line 67. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.text(String input)` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguage.<init>()` — line 119. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/783fda83db15/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.init()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.onClose()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 67. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 89. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/898099464d7a/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$resizeMenu(CallbackInfo ci)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — line 41. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/a709e778ccff/main/java/nvvisionboost/NVVisionBoostUi.java

- `NVVisionBoostUi.preference()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.ensure()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.text(String value)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.component(String value)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tooltip(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.infoTooltip(Component message)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.enrich(Tooltip original, String label)` — line 51. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.help(String label, boolean reverse)` — line 58. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.impact(String label)` — line 63. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.languages(int width, Runnable rebuild, Consumer<Button> add)` — line 67. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.flag(GuiGraphicsExtractor g, int x, int y, boolean us)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tick()` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.<init>()` — line 124. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/b85e37d6f61d/test/java/nvvisionboost/NVVisionBoostLanguageTest.java

- `NVVisionBoostLanguageTest.check(boolean value, String message)` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostLanguageTest.main(String[] args)` — line 15. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/c65ef44b1af0/main/java/nvvisionboost/mixin/NVVisionBoostOptionsScreenMixin.java

- `NVVisionBoostOptionsScreenMixin.<init>(Component title)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$addMenu(CallbackInfo ci)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$resizeMenu(CallbackInfo ci)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsScreenMixin.nvvb$placeMenu()` — line 41. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/common/main/java/nvvisionboost/NVVisionBoostCompatibilityNotice.java

- `NVVisionBoostCompatibilityNotice.lines()` — line 12. Short footer lines; the information button exposes the complete guidance.
- `NVVisionBoostCompatibilityNotice.<init>()` — line 20. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/dee3a934c82f/main/java/nvvisionboost/NVVisionBoostUi.java

- `NVVisionBoostUi.preference()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.ensure()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.text(String value)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.component(String value)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tooltip(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.infoTooltip(Component message)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.enrich(Tooltip original, String label)` — line 51. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.help(String label, boolean reverse)` — line 58. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.impact(String label)` — line 63. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.languages(int width, Runnable rebuild, Consumer<Button> add)` — line 67. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.flag(GuiGraphics g, int x, int y, boolean us)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.tick()` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUi.<init>()` — line 124. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/e737801cd808/main/java/nvvisionboost/NVVisionBoostPerformanceScreen.java

- `NVVisionBoostPerformanceScreen.<init>(Screen parent)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cfg()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.on(boolean enabled)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.add(int category, Supplier<String> label, Runnable action, String help)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.init()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.cycle(int value, int[] values)` — line 280. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.onClose()` — line 286. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.render(GuiGraphics graphics, int x, int y, float partialTick)` — line 291. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformanceScreen.renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 319. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/f0c13a90ead4/main/java/nvvisionboost/NVVisionBoostHelp.java

- `NVVisionBoostHelp.help(String label, boolean reverse)` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHelp.impact(String label)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHelp.text(String value)` — line 258. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHelp.<init>()` — line 262. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/f40aa5f947ca/main/java/nvvisionboost/NVVisionBoostTextureScreen.java

- `NVVisionBoostTextureScreen.<init>(Screen parent)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.init()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.onClose()` — line 62. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureScreen.extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 67. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/options-adapter/main/java/nvvisionboost/NVVisionBoostOptionsPlacement.java

- `NVVisionBoostOptionsPlacement.Rect.overlaps(Rect other)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsPlacement.free(Rect candidate, int width, int height, List<Rect> occupied)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsPlacement.place(int width, int height, List<Rect> occupied)` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionsPlacement.columnPartner(Rect left, List<Rect> occupied)` — line 65. Derive column spacing from another actual row, including vanilla's ten-pixel gap.
- `NVVisionBoostOptionsPlacement.<init>()` — line 78. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/options-adapter/main/java/nvvisionboost/NVVisionBoostOptionsScreenAdapter.java

- `NVVisionBoostOptionsScreenAdapter.place(Screen screen, Button entry)` — line 14. Align only NVVision's button to the current visible layout after other mods initialize it.
- `NVVisionBoostOptionsScreenAdapter.<init>()` — line 32. No individual contract; refer to the module responsibility and method body.

## modules/mod/interface/options-adapter/test/java/nvvisionboost/NVVisionBoostOptionsPlacementTest.java

- `NVVisionBoostOptionsPlacementTest.main(String[] args)` — line 6. No individual contract; refer to the module responsibility and method body.

## modules/mod/performance/418fb7ce0be4/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 19. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — line 78. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 135. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 145. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceIrisPerformanceState()` — line 175. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 215. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — line 233. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 255. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 264. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 268. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 276. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 280. No individual contract; refer to the module responsibility and method body.

## modules/mod/performance/57c2f34dc94f/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.isBusy()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.status()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.label(int level)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostCore.Config config)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — line 97. No individual contract; refer to the module responsibility and method body.

## modules/mod/performance/5bd31cc25eed/main/java/nvvisionboost/NVVisionBoostTextureOptimizer.java

- `NVVisionBoostTextureOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.isBusy()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.status()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.label(int level)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.next(int level, int direction)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.apply(NVVisionBoostCore.Config config)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTextureOptimizer.rollback(Minecraft mc, Options options, int previous, Throwable error)` — line 97. No individual contract; refer to the module responsibility and method body.

## modules/mod/performance/c9979b6fdbd1/main/java/nvvisionboost/NVVisionBoostPerformance.java

- `NVVisionBoostPerformance.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.tick(NVVisionBoostCore.Config config)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.limitBlockEntities()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.blockEntityDistance()` — line 35. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.reduceWeatherParticles()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPerformance.framerateLimit(int currentLimit)` — line 45. No individual contract; refer to the module responsibility and method body.

## modules/mod/performance/f7207da07d7e/main/java/nvvisionboost/VisionOptimizer.java

- `VisionOptimizer.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.applySettings(int profile, boolean status)` — line 19. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configurePerformanceProfile(NVVisionBoostCore.Config cfg)` — line 78. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.analyzeHardwareResources()` — line 135. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.optimizeSodiumEmbeddiumPipeline()` — line 145. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.forceIrisPerformanceState()` — line 175. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.configureCreateCompatibility()` — line 215. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.disableOptimizations(NVVisionBoostCore.Config cfg)` — line 233. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isModLoaded(String modId)` — line 255. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.normalizeProfile(int profile)` — line 264. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.profileName(int profile)` — line 268. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.getPerformanceProfile()` — line 276. No individual contract; refer to the module responsibility and method body.
- `VisionOptimizer.isEnabled()` — line 280. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/028dc9d06bce/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java

- `NVVisionBoostMinecraftMixin.nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$tick(CallbackInfo ci)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$close(CallbackInfo ci)` — line 37. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/39f070837386/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameStart()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — line 126. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — line 144. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.beginWorld()` — line 153. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.markUpscale()` — line 157. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.endWorld()` — line 161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.invalidateWorld()` — line 165. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameMs()` — line 169. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.p95Ms()` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuMs()` — line 177. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.upscaleMs()` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — line 185. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuLikely()` — line 189. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.status()` — line 195. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.resolutionStatus()` — line 210. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/5e9eda0afbdc/main/java/nvvisionboost/NVVisionBoostSpatialUpscaler.java

- `NVVisionBoostSpatialUpscaler.<init>()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.modeName(int mode)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.status()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.render(int texture, int framebuffer, int inputWidth, int inputHeight, int outputWidth, int outputHeight, int requestedMode, int sharpnessPercent, int targetFps)` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.initialize()` — line 131. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.shaderSource(String name)` — line 167. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compile(int type, String name)` — line 178. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.compileSource(int type, String source)` — line 182. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.close()` — line 194. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.capture()` — line 213. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.restore()` — line 239. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disableClipPlanes()` — line 267. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.disablePixelUnpack()` — line 271. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostSpatialUpscaler.State.set(int flag, boolean enabled)` — line 275. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/69c601071211/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.averageFps()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.lowFpsSamples()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.stableFpsSamples()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.tickDynamicPerformance()` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.checkShaderState()` — line 68. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.resetTracking()` — line 87. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/88fa452490e1/main/java/nvvisionboost/mixin/NVVisionBoostIrisDepthMixin.java

- `NVVisionBoostIrisDepthMixin.nvvb$depthIdentity(int version, GpuTexture incoming, int width, int height, DepthBufferFormat format, PackDirectives directives, CallbackInfoReturnable<Boolean> ci)` — line 21. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/92912aedf880/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftTargetAccessor.java

- `NVVisionBoostMinecraftTargetAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — line 11. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/9306a63f710b/main/java/nvvisionboost/mixin/NVVisionBoostOptionsMixin.java

- `NVVisionBoostOptionsMixin.nvvb$key(CallbackInfo ci)` — line 15. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/93f1dd3f9862/main/java/nvvisionboost/mixin/NVVisionBoostIrisDepthMixin.java

- `NVVisionBoostIrisDepthMixin.nvvb$depthIdentity(int version, GpuTexture incoming, int width, int height, DepthBufferFormat format, PackDirectives directives, CallbackInfoReturnable<Boolean> ci)` — line 23. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/9909ab575c1e/main/java/nvvisionboost/NVVisionDynamicController.java

- `NVVisionDynamicController.<init>()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.averageFps()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.lowFpsSamples()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.stableFpsSamples()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.tickDynamicPerformance()` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.checkShaderState()` — line 68. No individual contract; refer to the module responsibility and method body.
- `NVVisionDynamicController.resetTracking()` — line 87. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/a050a520c7e8/main/java/nvvisionboost/NVVisionBoostFrameTiming.java

- `NVVisionBoostFrameTiming.<init>()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameStart()` — line 25. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.adaptive(NVVisionBoostCore.Config config)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.performanceTarget(NVVisionBoostCore.Config config)` — line 126. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.effectiveScale(NVVisionBoostCore.Config config)` — line 144. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.beginWorld()` — line 153. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.markUpscale()` — line 157. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.endWorld()` — line 161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.invalidateWorld()` — line 165. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.frameMs()` — line 169. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.p95Ms()` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuMs()` — line 177. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.upscaleMs()` — line 181. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuSampleFresh()` — line 185. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.gpuLikely()` — line 189. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.status()` — line 195. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameTiming.resolutionStatus()` — line 210. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/a31c4f4f0988/main/java/nvvisionboost/NVVisionBoostFsr1Upscaler.java

- `NVVisionBoostFsr1Upscaler.<init>()` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.status()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.supported()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.render(int texture, int destination, int width, int height, int outputWidth, int outputHeight, int sharpnessPercent)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.initialize()` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.link(String fragmentSource)` — line 143. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.configureEasu(int width, int height, int outputWidth, int outputHeight)` — line 171. Compute FsrEasuCon constants on the CPU only when dimensions change.
- `NVVisionBoostFsr1Upscaler.uniform(int location, float x, float y, float z, float w)` — line 188. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.ensureTarget(int width, int height)` — line 197. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.releaseTarget()` — line 230. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFsr1Upscaler.close()` — line 236. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/b4c250accbc1/main/java/nvvisionboost/compat/NVVisionBoostMixinPlugin.java

- `NVVisionBoostMixinPlugin.compatible(ClassNode target)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.shouldApplyMixin(String targetName, String mixinName)` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.onLoad(String packageName)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.getRefMapperConfig()` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.acceptTargets(Set<String> mine, Set<String> other)` — line 46. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.getMixins()` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.preApply(String name, ClassNode target, String mixin, IMixinInfo info)` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMixinPlugin.postApply(String name, ClassNode target, String mixin, IMixinInfo info)` — line 54. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/bf59c94e0a6d/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftMixin.java

- `NVVisionBoostMinecraftMixin.nvvb$reloadStart(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$reloadEnd(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.concurrent.CompletableFuture<Void>> ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$tick(CallbackInfo ci)` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftMixin.nvvb$close(CallbackInfo ci)` — line 37. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/d32f48026afa/main/java/nvvisionboost/NVVisionBoostUpscaleBudget.java

- `NVVisionBoostUpscaleBudget.mode()` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUpscaleBudget.observe(double filterMs, double gpuMs, double frameMs, int targetFps, long now)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostUpscaleBudget.reset()` — line 40. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/d515f9d544d6/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererAccessor.nvvb$getGameRenderState()` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererAccessor.nvvb$getMainRenderTarget()` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — line 21. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/depth-transfer/main/java/nvvisionboost/NVVisionBoostDepthTransfer.java

- `NVVisionBoostDepthTransfer.<init>()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDepthTransfer.copy(int source, int destination, int width, int height, int outputWidth, int outputHeight, boolean stencil)` — line 14. Depth/stencil scaling requires NEAREST; preserves the caller's FBO bindings and scissor state.

## modules/mod/rendering/fa5a22498ede/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — line 73. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — line 86. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/fc70a72bc018/main/java/nvvisionboost/mixin/NVVisionBoostWindowMixin.java

- `NVVisionBoostWindowMixin.nvvb$worldWidth(CallbackInfoReturnable<Integer> ci)` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostWindowMixin.nvvb$worldHeight(CallbackInfoReturnable<Integer> ci)` — line 18. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/ff198b08c0c0/main/java/nvvisionboost/UpscalingManager.java

- `UpscalingManager.UpscalePreset.<init>(String displayName, float scaleFactor)` — line 17. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getDisplayName()` — line 22. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.UpscalePreset.getScaleFactor()` — line 26. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.<init>()` — line 33. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.setPreset(UpscalePreset preset)` — line 35. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getCurrentPreset()` — line 54. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getActiveResolutionInfo()` — line 60. Return calculated internal dimensions without modifying the window.
- `UpscalingManager.applyCurrentResolution()` — line 75. Apply logical upscaler state without resizeDisplay or window changes; the renderer prepares the internal target at world-pass entry.
- `UpscalingManager.getScalePercent()` — line 107. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getScaleFactor()` — line 118. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalWidth(int windowWidth)` — line 122. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.getInternalHeight(int windowHeight)` — line 126. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.syncPresetFromConfig()` — line 130. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.scaledDimension(int original, int percent, int minimum)` — line 139. No individual contract; refer to the module responsibility and method body.
- `UpscalingManager.clamp(int value, int min, int max)` — line 144. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/ff56b56088ba/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererMixin.java

- `NVVisionBoostGameRendererMixin.nvvb$start(CallbackInfo ci)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldUniforms(Args args, DeltaTracker delta, boolean renderLevel)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$worldPass(GameRenderer renderer, DeltaTracker delta)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreGuiUniforms(CallbackInfo ci)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGameRendererMixin.nvvb$restoreNativeUniforms()` — line 92. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/ff63671771e6/main/java/nvvisionboost/mixin/NVVisionBoostGameRendererAccessor.java

- `NVVisionBoostGameRendererAccessor.nvvb$getGlobalSettingsUniform()` — line 10. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/legacy-gl/main/java/nvvisionboost/rendering/MinecraftGlStateAdapter.java

- `MinecraftGlStateAdapter.<init>()` — line 15. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.bindFramebuffer(int target, int framebuffer)` — line 17. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.deleteFramebuffer(int framebuffer)` — line 22. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.useProgram(int program)` — line 26. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.activeTexture(int unit)` — line 31. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.bindTexture(int target, int texture)` — line 36. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.deleteTexture(int texture)` — line 43. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/legacy-gl/test/java/nvvisionboost/NVVisionBoostGlAdapterTest.java

- `NVVisionBoostGlAdapterTest.check(boolean value, String message)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGlAdapterTest.main(String[] args)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGlAdapterTest.run()` — line 42. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/modern-gl/main/java/nvvisionboost/rendering/MinecraftGlStateAdapter.java

- `MinecraftGlStateAdapter.<init>()` — line 15. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.bindFramebuffer(int target, int framebuffer)` — line 17. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.deleteFramebuffer(int framebuffer)` — line 22. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.useProgram(int program)` — line 26. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.activeTexture(int unit)` — line 31. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.bindTexture(int target, int texture)` — line 36. No individual contract; refer to the module responsibility and method body.
- `MinecraftGlStateAdapter.deleteTexture(int texture)` — line 43. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/modern-gl/test/java/nvvisionboost/NVVisionBoostGlAdapterTest.java

- `NVVisionBoostGlAdapterTest.check(boolean value, String message)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGlAdapterTest.main(String[] args)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGlAdapterTest.run()` — line 42. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/pixel-adapter/main/java/nvvisionboost/NVVisionBoostPixelAdapter.java

- `NVVisionBoostPixelAdapter.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPixelAdapter.nativeViewportOnReducedTarget(int x, int y, int width, int height, int nativeWidth, int nativeHeight, int targetWidth, int targetHeight)` — line 7. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/target-adapter/main/java/nvvisionboost/rendering/RenderTargetAdapter.java

- `RenderTargetAdapter.validate(T main, T internal)` — line 9. No individual contract; refer to the module responsibility and method body.
- `RenderTargetAdapter.capture(T target)` — line 11. No individual contract; refer to the module responsibility and method body.
- `RenderTargetAdapter.apply(T target, S state)` — line 13. No individual contract; refer to the module responsibility and method body.

## modules/mod/rendering/target-adapter/main/java/nvvisionboost/rendering/WorldTargetLease.java

- `WorldTargetLease.<init>(RenderTargetAdapter<T, S> adapter)` — line 12. No individual contract; refer to the module responsibility and method body.
- `WorldTargetLease.begin(T main, T internal)` — line 16. No individual contract; refer to the module responsibility and method body.
- `WorldTargetLease.restore()` — line 33. Uses the current states so replacement attachments created by another mod retain correct ownership.
- `WorldTargetLease.active()` — line 41. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/28066533e3af/main/java/nvvisionboost/NVVisionBoostUniformSnapshot.java


## modules/mod/services/32b1ee9bd074/main/java/nvvisionboost/NVVisionBoostContentManager.java

- `NVVisionBoostContentManager.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.shaderpacksDir()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.resourcepacksDir()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.ensureFolders(Path game)` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.openFolder(Path p)` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.importShader(Path source)` — line 36. Installs a shaderpack file or directory into .minecraft/shaderpacks. ZIP/JAR shaderpacks are copied as-is; directories are copied recursively.
- `NVVisionBoostContentManager.importResourcePack(Path source)` — line 42. Installs a resource pack file or directory into .minecraft/resourcepacks.
- `NVVisionBoostContentManager.activateResourcePack(String name)` — line 51. Activates a resource pack through Minecraft's native repository. This method only changes the selected pack list; it never edits pack data.
- `NVVisionBoostContentManager.mergeSelection(java.util.List<String> previous, String target)` — line 101. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.importContent(Path source, Path destination, String label)` — line 107. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.copyDirectory(Path source, Path target)` — line 133. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostContentManager.stripExtension(String value)` — line 145. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/3c165c338f7f/main/java/nvvisionboost/NVVisionBoostClient.java

- `NVVisionBoostClient.registerKeys(RegisterKeyMappingsEvent event)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostClient.<init>()` — line 27. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/40c12afdf5ad/main/java/nvvisionboost/NVVisionBoostImageQuality.java

- `NVVisionBoostImageQuality.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostImageQuality.label(NVVisionBoostCore.Config config)` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostImageQuality.cycle(NVVisionBoostCore.Config config)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostImageQuality.configure(NVVisionBoostCore.Config config, int scale)` — line 30. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/40ecfc6e085b/main/java/nvvisionboost/NVVisionBoostResolutionPolicy.java

- `NVVisionBoostResolutionPolicy.Sample.valid()` — line 6. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.Sample.gpuLikely()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.targetFps(int requested, int gameLimit, boolean vsync, int refreshRate)` — line 31. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.configure(int requestedCeiling, int requestedMinimum, int fps, long now)` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.reset(long now)` — line 55. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.suspend(long now)` — line 64. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.scale()` — line 72. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.reason()` — line 76. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.observe(Sample sample, long now)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResolutionPolicy.startTrial(int wanted, boolean decrease, Sample sample, long now)` — line 136. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/436bd8af5d7e/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setMessage(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.mouseClicked(net.minecraft.client.input.MouseButtonEvent event, boolean doubleClick)` — line 84. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/4f40a7c669e0/test/java/nvvisionboost/NVVisionBoostOpenGLSmokeTest.java

- `NVVisionBoostOpenGLSmokeTest.check(boolean condition, String name)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.main(String[] args)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFilters()` — line 66. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.stateIsolation(int input, int framebuffer, int inputSize, int mode)` — line 132. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.foreignProgram()` — line 229. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.runFsr()` — line 254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.texture(int width, int height, boolean floating)` — line 320. Reproduces the Oculus packed-stencil -> depth-only transition from the modpack.
- `NVVisionBoostOpenGLSmokeTest.framebuffer(int texture)` — line 338. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOpenGLSmokeTest.read(int framebuffer)` — line 349. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/4fa71012b9e9/main/java/nvvisionboost/NVVisionBoostIO.java

- `NVVisionBoostIO.appendLog(Path target, String message)` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.<init>()` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.writeUtf8(Path target, String content)` — line 47. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.readUtf8(Path file, String fallback)` — line 72. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.jsonString(String value)` — line 80. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.normalizeToken(String value)` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.clamp(int value, int min, int max)` — line 96. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.clamp(double value, double min, double max)` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIO.openFolder(Path folder)` — line 104. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/5b47c4375880/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencies.blocked()` — line 7. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/622eaa72433e/main/java/nvvisionboost/NVVisionBoostIrisDepthSafety.java

- `NVVisionBoostIrisDepthSafety.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/67a0d93cc41c/main/java/nvvisionboost/NVVisionVramManager.java

- `NVVisionVramManager.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionVramManager.getDetectedVramMb()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionVramManager.getAllocatedVramMb()` — line 14. Legacy advisory budget API without VRAM reservation; -1 means unknown.
- `NVVisionVramManager.setManualVramAllocation(long value)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionVramManager.analyzeAndAllocateVram()` — line 24. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/757ef23f7167/main/java/nvvisionboost/NVVisionBoostResourceReload.java

- `NVVisionBoostResourceReload.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResourceReload.active()` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResourceReload.begin()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResourceReload.track(CompletableFuture<Void> future)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostResourceReload.finish(Throwable error)` — line 30. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/7bc491b5dfcb/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.resetWorldTracking()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — line 45. Called by the central monitor once per second, never every frame.
- `NVVisionBoostRenderController.<init>()` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — line 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — line 123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.restorePlayerOptions()` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — line 335. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — line 339. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — line 347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — line 378. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — line 382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — line 386. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — line 403. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — line 443. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — line 457. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — line 461. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — line 465. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — line 476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — line 482. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/8cb94c628cff/main/java/nvvisionboost/NVVisionBoostCacheMaintenance.java

- `NVVisionBoostCacheMaintenance.<init>()` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCacheMaintenance.update(Path directory, String version)` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCacheMaintenance..preVisitDirectory(Path folder, BasicFileAttributes attributes)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCacheMaintenance..visitFile(Path file, BasicFileAttributes attributes)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCacheMaintenance..postVisitDirectory(Path folder, IOException error)` — line 56. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/9f4f7403f842/main/java/nvvisionboost/NVVisionBoostVisualPolicy.java

- `NVVisionBoostVisualPolicy.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVisualPolicy.screenEffectScale(NVVisionBoostCore.Config config, double original)` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVisualPolicy.simulationDistance(NVVisionBoostCore.Config config, int original)` — line 15. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/a3346679114a/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — line 5. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencies.blocked()` — line 7. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/acc462b9c91c/main/java/nvvisionboost/NVVisionBoostPipeline.java

- `NVVisionBoostPipeline.Report.<init>(String name, int shaderFiles, int postPasses, boolean hasGbuffers, boolean hasShadow, List<String> stages)` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.<init>()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.status()` — line 38. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.analyze(Path source)` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.write(Path target, Report report)` — line 87. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.isShader(String n)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.isPostPass(String n)` — line 117. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.classify(String n, List<String> stages)` — line 121. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostPipeline.findNestedRoot(Path source)` — line 132. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/af336f65a301/main/java/nvvisionboost/NVVisionBoostLogger.java

- `NVVisionBoostLogger.logSuccess(String actionName)` — line 10. Log a successfully activated action.
- `NVVisionBoostLogger.logFailure(String actionName, String reason)` — line 15. Log an unsuccessful activation attempt, including incompatibility.
- `NVVisionBoostLogger.logError(String actionName, Throwable throwable)` — line 23. Log critical runtime errors.

## modules/mod/services/b95e068ff2ca/main/java/nvvisionboost/NVVisionBoostRenderController.java

- `NVVisionBoostRenderController.adaptationAllowed()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.resetWorldTracking()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.pauseAdaptation(long durationMs)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.observePerformance(NVVisionBoostCore.Config config, int fps)` — line 45. Called by the central monitor once per second, never every frame.
- `NVVisionBoostRenderController.<init>()` — line 104. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.tick(NVVisionBoostCore.Config config)` — line 106. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyNow(NVVisionBoostCore.Config config)` — line 116. Immediate application used by every UI mutation.
- `NVVisionBoostRenderController.adapt(NVVisionBoostCore.Config config, int fps)` — line 123. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.restorePlayerOptions()` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, int ignoredTier)` — line 233. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.apply(NVVisionBoostCore.Config config, boolean automaticReapply)` — line 237. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.applyAnimationLevel(Options options, NVVisionBoostCore.Config config)` — line 317. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.effectiveRenderDistance(NVVisionBoostCore.Config config)` — line 335. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.nextLowerScale(int value)` — line 339. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.signature(NVVisionBoostCore.Config c)` — line 347. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.set(OptionInstance<T> option, T value)` — line 378. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(int value, int min, int max)` — line 382. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.clamp(double value, double min, double max)` — line 386. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.<init>(int renderDistance, int simulationDistance, double entityDistanceScaling, ParticleStatus particles, CloudStatus clouds, boolean entityShadows, boolean ambientOcclusion, double screenEffectScale, double fovEffectScale, double darknessEffectScale, boolean bobView)` — line 403. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.capture(Options o)` — line 428. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restore(Options o)` — line 443. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreSimulationOnly(Options o)` — line 453. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityDistance(Options o)` — line 457. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreEntityShadows(Options o)` — line 461. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreAnimation(Options o)` — line 465. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreTransparency(Options o)` — line 471. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreShaderEffects(Options o)` — line 476. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderController.Snapshot.restoreViewBob(Options o)` — line 482. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/bc75245bb9d8/main/java/nvvisionboost/NVVisionBoostUniformSnapshot.java


## modules/mod/services/c3be5f5b3d76/main/java/nvvisionboost/NVVisionBoostFileFingerprint.java

- `NVVisionBoostFileFingerprint.<init>()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFileFingerprint.stamp(Path source)` — line 12. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/d3e181851b4f/main/java/nvvisionboost/NVVisionBoostFrameStatistics.java

- `NVVisionBoostFrameStatistics.add(double milliseconds)` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameStatistics.count()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameStatistics.meanMs()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameStatistics.percentile95Ms()` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostFrameStatistics.reset()` — line 38. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/d6ea68e88ad7/main/java/nvvisionboost/NVVisionBoostAssetAnalyzer.java

- `NVVisionBoostAssetAnalyzer.Report.summary()` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.<init>()` — line 32. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyze(Path source)` — line 34. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.analyzeFile(Path file, Report report)` — line 50. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.count(String name, long size, Report report)` — line 79. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostAssetAnalyzer.animated(InputStream input)` — line 87. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/d7759ee9966d/main/java/nvvisionboost/NVVisionBoostNvidiaBackend.java

- `NVVisionBoostNvidiaBackend.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.dlssLibraryPresent()` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.frameGenerationAvailable()` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNvidiaBackend.status()` — line 31. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/ddc27b630a01/test/java/nvvisionboost/NVVisionBoostIrisBridgeTest.java

- `NVVisionBoostIrisBridgeTest.require(boolean value, String message)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostIrisBridgeTest.main(String[] args)` — line 20. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/e0313fb3a43d/main/java/nvvisionboost/NVVisionBoostMemoryMonitor.java

- `NVVisionBoostMemoryMonitor.<init>()` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMemoryMonitor.underPressure()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMemoryMonitor.tick(NVVisionBoostCore.Config cfg)` — line 17. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/f0992ebc9619/test/java/nvvisionboost/NVVisionBoostNeoForgeIrisSchemaTest.java

- `NVVisionBoostNeoForgeIrisSchemaTest.main(String[] args)` — line 9. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/f29820f284b8/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setMessage(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.mouseClicked(net.minecraft.client.input.MouseButtonEvent event, boolean doubleClick)` — line 83. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/f5990f44ec46/main/java/nvvisionboost/NVVisionBoostVulkanBridge.java

- `NVVisionBoostVulkanBridge.<init>()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.present()` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.resolve()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.decode(Object value)` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.status()` — line 54. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.summary()` — line 71. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.requestBackend(String backend)` — line 79. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.requestDescriptors(String mode)` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.cpuControl(String key)` — line 101. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.cycleCpuControl(String key)` — line 113. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.cpuProfile()` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostVulkanBridge.cycleCpuProfile()` — line 137. No individual contract; refer to the module responsibility and method body.

## modules/mod/services/f96e9a8867fe/main/java/nvvisionboost/NVVisionBoostHardwareBudget.java

- `NVVisionBoostHardwareBudget.Snapshot.summary()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.<init>()` — line 28. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.detect()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostHardwareBudget.constrain(NVVisionBoostCore.Config config)` — line 56. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/0f2deb61e8e6/main/java/nvvisionboost/NVVisionBoostGpuTimer.java

- `NVVisionBoostGpuTimer.timestampRendererReliable(String renderer)` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.supported()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.available()` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.samples()` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.lastSampleNanos()` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.gpuMs()` — line 48. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.upscaleMs()` — line 52. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.cpuMs()` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.begin()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.markUpscale()` — line 85. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.end()` — line 91. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.poll()` — line 100. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.average(double previous, double current)` — line 121. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.invalidate()` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuTimer.close()` — line 132. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/18931593c7e1/main/java/nvvisionboost/NVVisionBoostNativeShaderPackRuntime.java

- `NVVisionBoostNativeShaderPackRuntime.<init>()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.clear()` — line 23. Kept for binary/source compatibility.  ,<p>,This method MUST NOT manipulate Oculus.
- `NVVisionBoostNativeShaderPackRuntime.activate(Path pack)` — line 37. Legacy compatibility method.  ,<p>,It deliberately does not activate anything.
- `NVVisionBoostNativeShaderPackRuntime.isActive()` — line 47. NVVisionBoost must never report its old shader renderer as active.
- `NVVisionBoostNativeShaderPackRuntime.activeName()` — line 56. The active shader belongs to Oculus.  ,<p>,Do not maintain a second active shader state here.
- `NVVisionBoostNativeShaderPackRuntime.status()` — line 60. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.capabilitySummary()` — line 71. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNativeShaderPackRuntime.render(int inputTexture, int depthTexture, int width, int height)` — line 81. Legacy renderer hook.  ,<p>,Returning false prevents the NVVisionBoost render pipeline from treating this class as an active shaderpack renderer.
- `NVVisionBoostNativeShaderPackRuntime.resultTexture()` — line 87. No native shader output texture exists anymore.

## modules/mod/shared/222f8b15dc67/main/java/nvvisionboost/mixin/NVVisionBoostRenderTargetAccessor.java

- `NVVisionBoostRenderTargetAccessor.nvvb$getColorTexture()` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setColorTexture(GpuTexture texture)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getDepthTexture()` — line 18. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setDepthTexture(GpuTexture texture)` — line 21. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getColorView()` — line 24. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setColorView(GpuTextureView view)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$getDepthView()` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderTargetAccessor.nvvb$setDepthView(GpuTextureView view)` — line 33. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/3e0c60185c35/test/java/nvvisionboost/NVVisionBoostShaderStartupPolicyTest.java

- `NVVisionBoostShaderStartupPolicyTest.run()` — line 4. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostShaderStartupPolicyTest.require(boolean valid, String description)` — line 45. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/48009f770029/main/java/nvvisionboost/NVVisionBoostTargetLease.java

- `NVVisionBoostTargetLease.begin(RenderTarget main, RenderTarget internal)` — line 18. Borrows internal attachments without replacing Minecraft's main target reference.
- `NVVisionBoostTargetLease.restore()` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.active()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.validate(RenderTarget main, RenderTarget internal)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.capture(RenderTarget target)` — line 36. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.apply(RenderTarget target, State state)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.read(RenderTarget target)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.write(RenderTarget target)` — line 70. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/5086a480e4b9/test/java/nvvisionboost/NVVisionBoostTargetLeaseTest.java

- `NVVisionBoostTargetLeaseTest.check(boolean value, String message)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.main(String[] args)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runOwnership()` — line 43. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runDepth(int percent)` — line 111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.target(int width, int height)` — line 160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.<init>(int width, int height)` — line 200. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.close()` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.isClosed()` — line 216. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.<init>(GpuTexture texture)` — line 225. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.close()` — line 229. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.isClosed()` — line 234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.<init>(int width, int height)` — line 242. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.replace(int width, int height)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorTexture()` — line 256. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorTexture(GpuTexture texture)` — line 260. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthTexture()` — line 264. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthTexture(GpuTexture texture)` — line 268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorView()` — line 272. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorView(GpuTextureView view)` — line 276. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthView()` — line 280. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthView(GpuTextureView view)` — line 284. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/61f43577008b/test/java/nvvisionboost/NVVisionBoostRenderingPolicyTest.java

- `NVVisionBoostRenderingPolicyTest.check(boolean result, String name)` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderingPolicyTest.run()` — line 12. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostRenderingPolicyTest.policy(int ceiling, int floor)` — line 132. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/738a59f6543d/main/java/nvvisionboost/NVVisionBoostGpuCatalog.java

- `NVVisionBoostGpuCatalog.Type.<init>(String label)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.<init>()` — line 29. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.hardwareRenderer(String renderer)` — line 32. Extract the hardware label from Zink, retaining unknown/ordinary driver labels.
- `NVVisionBoostGpuCatalog.classify(String vendor, String renderer)` — line 41. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.brand(String text)` — line 70. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.lower(String text)` — line 79. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.additionalPresets()` — line 84. Suggested starting points, not benchmarks or detected memory capacities.
- `NVVisionBoostGpuCatalog.group(List<NVVisionBoostGPU.Preset> result, String prefix, String architecture, String family, int tier, String[] names)` — line 161. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.fallback(String name, Identity identity)` — line 171. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalog.recommendation(String name, String architecture, String family, int tier)` — line 179. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/892115233543/main/java/nvvisionboost/NVVisionBoostTargetBindings.java

- `NVVisionBoostTargetBindings.<init>()` — line 8. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetBindings.texture(int bound, int oldColor, int oldDepth, int newColor, int newDepth)` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetBindings.framebuffer(int bound, int oldTarget, int newTarget)` — line 18. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/8a56edab19c8/test/java/nvvisionboost/NVVisionBoostStabilityTest.java

- `NVVisionBoostStabilityTest.check(boolean result, String message)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostStabilityTest.run(Path testRoot)` — line 14. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/8f32ac596c52/main/java/nvvisionboost/NVVisionBoostTargetLease.java

- `NVVisionBoostTargetLease.begin(RenderTarget main, RenderTarget internal)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.restore()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.active()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.validate(RenderTarget main, RenderTarget internal)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.capture(RenderTarget target)` — line 39. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.apply(RenderTarget target, State state)` — line 44. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.read(RenderTarget target)` — line 56. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.write(RenderTarget target)` — line 67. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/98722f7acf4c/main/java/nvvisionboost/mixin/NVVisionBoostWeatherParticlesMixin.java

- `NVVisionBoostWeatherParticlesMixin.nvvb$rainParticle(ClientLevel level, ParticleOptions type, double x, double y, double z, double dx, double dy, double dz)` — line 17. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/b18a424cad21/main/java/nvvisionboost/NVVisionBoostDependencies.java

- `NVVisionBoostDependencies.<init>()` — line 7. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencies.accepts(boolean embeddium, boolean sodium)` — line 9. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencies.verify()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostDependencies.blocked()` — line 18. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/b297292cc049/test/java/nvvisionboost/NVVisionBoostCreatePresetTest.java

- `NVVisionBoostCreatePresetTest.Value.<init>(double value)` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresetTest.Value.get()` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresetTest.Value.set(Object input)` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresetTest.run(Path root)` — line 30. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCreatePresetTest.require(boolean valid, String name)` — line 93. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/b32f89b492de/main/java/nvvisionboost/mixin/NVVisionBoostMinecraftAccessor.java

- `NVVisionBoostMinecraftAccessor.nvvb$getFramerateLimit()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftAccessor.nvvb$getMainRenderTarget()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostMinecraftAccessor.nvvb$setMainRenderTarget(RenderTarget target)` — line 19. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/b4a4f2982ad5/main/java/nvvisionboost/mixin/NVVisionBoostBufferSourceAccessor.java

- `NVVisionBoostBufferSourceAccessor.nvvb$getBuilder()` — line 14. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferSourceAccessor.nvvb$getFixedBuffers()` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferSourceAccessor.nvvb$getLastState()` — line 20. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferSourceAccessor.nvvb$getStartedBuffers()` — line 23. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/c3286c1e18a6/main/java/nvvisionboost/NVVisionBoostGPU.java

- `NVVisionBoostGPU.Info.technologySummary()` — line 26. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.<init>(String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String p)` — line 45. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.Preset.summary()` — line 82. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.<init>()` — line 90. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detect()` — line 92. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.detectFresh()` — line 158. Forces the next detection call to query the current GPU again.
- `NVVisionBoostGPU.detectNonOpenGL(Info i)` — line 165. Native Minecraft device metadata; never call OpenGL for a non-GL render target.
- `NVVisionBoostGPU.detectFromOpenGL(Info i)` — line 195. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presetFor(String gpuName)` — line 213. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.genericPreset(String name)` — line 262. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.presets()` — line 379. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.add(List<Preset> p, String n, String a, String f, int g, int v, int fps, int rd, int ed, int rs, int al, int tl, boolean part, boolean clouds, boolean shadows, boolean effects, boolean dyn, String prof)` — line 2009. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPresetSafe(NVVisionBoostCore.Config c, Preset p)` — line 2033. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.applyPreset(NVVisionBoostCore.Config c, Preset p)` — line 2061. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.tailor(NVVisionBoostCore.Config config, Preset preset)` — line 2086. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.writePresetDatabase(Path root)` — line 2115. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryExtensionAllowed(NVVisionBoostGpuCatalog.Brand brand, boolean nvx, boolean ati)` — line 2197. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.memoryDiagnostics()` — line 2204. User-requested diagnostics; no polling, allocations or driver calls in the frame loop.
- `NVVisionBoostGPU.run(String activeName)` — line 2224. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.pl(String s)` — line 2266. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGPU.norm(String s)` — line 2275. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/c4fad481dc1a/main/java/nvvisionboost/mixin/NVVisionBoostBufferBuilderAccessor.java

- `NVVisionBoostBufferBuilderAccessor.nvvb$getRenderedPointer()` — line 10. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferBuilderAccessor.nvvb$getWritePointer()` — line 13. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferBuilderAccessor.nvvb$getRenderedCount()` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostBufferBuilderAccessor.nvvb$isBuilding()` — line 19. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/c526284a5717/main/java/nvvisionboost/mixin/NVVisionBoostBlockEntityDistanceMixin.java

- `NVVisionBoostBlockEntityDistanceMixin.nvvb$distance(E entity, float partialTick, PoseStack poseStack, MultiBufferSource buffers, CallbackInfo ci)` — line 20. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/c6db7f161757/main/java/nvvisionboost/minecraft/VersionAdapter.java

- `VersionAdapter.mainRenderTarget()` — line 9. No individual contract; refer to the module responsibility and method body.
- `VersionAdapter.accessNotice(Component title, Component description)` — line 14. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/cce15fb8316e/test/java/nvvisionboost/NVVisionBoostTargetLeaseTest.java

- `NVVisionBoostTargetLeaseTest.check(boolean value, String message)` — line 17. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.main(String[] args)` — line 22. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runOwnership()` — line 43. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.runDepth(int percent)` — line 111. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.target(int width, int height)` — line 160. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.<init>(int width, int height)` — line 200. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.close()` — line 211. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTexture.isClosed()` — line 216. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.<init>(GpuTexture texture)` — line 225. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.close()` — line 229. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureView.isClosed()` — line 234. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.<init>(int width, int height)` — line 242. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.replace(int width, int height)` — line 247. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorTexture()` — line 256. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorTexture(GpuTexture texture)` — line 260. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthTexture()` — line 264. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthTexture(GpuTexture texture)` — line 268. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getColorView()` — line 272. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setColorView(GpuTextureView view)` — line 276. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$getDepthView()` — line 280. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLeaseTest.FixtureTarget.nvvb$setDepthView(GpuTextureView view)` — line 284. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/dcb25f48bd75/main/java/nvvisionboost/NVVisionBoostNeoForge.java

- `NVVisionBoostNeoForge.<init>(net.neoforged.fml.ModContainer container)` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostNeoForge.tick()` — line 19. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/df112b132c53/main/java/nvvisionboost/NVVisionBoostOptionButton.java

- `NVVisionBoostOptionButton.<init>(int x, int y, int width, int height, Component message, OnPress leftPress, OnPress rightPress)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setMessage(Component message)` — line 40. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.setSelectedStyle(boolean selected)` — line 49. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick)` — line 53. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostOptionButton.mouseClicked(double mouseX, double mouseY, int button)` — line 83. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/dfb8d3454c87/main/java/nvvisionboost/NVVisionBoostTargetLease.java

- `NVVisionBoostTargetLease.begin(RenderTarget main, RenderTarget internal)` — line 15. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.restore()` — line 19. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.active()` — line 23. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.validate(RenderTarget main, RenderTarget internal)` — line 27. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.capture(RenderTarget target)` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.apply(RenderTarget target, State state)` — line 42. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.read(RenderTarget target)` — line 55. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostTargetLease.State.write(RenderTarget target)` — line 67. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/e4b8954b96b7/test/java/nvvisionboost/NVVisionBoostGpuCatalogTest.java

- `NVVisionBoostGpuCatalogTest.check(boolean value, String message)` — line 11. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalogTest.identity(String vendor, String name, NVVisionBoostGpuCatalog.Brand brand, NVVisionBoostGpuCatalog.Type type)` — line 16. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostGpuCatalogTest.run(Path root)` — line 25. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/e7484e8a3072/main/java/nvvisionboost/NVVisionBoostCore.java

- `NVVisionBoostCore.<init>()` — line 37. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.machineFingerprint(NVVisionBoostGPU.Info gpu)` — line 125. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.load(Path path)` — line 173. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.capture(NVVisionBoostGPU.Info gpu, String fingerprint, Config config)` — line 201. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.MachineProfile.save(Path path)` — line 219. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.tickClient()` — line 254. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.updateClientMetrics(Config config)` — line 301. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.detectFps()` — line 343. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.setRenderScalePercent(int percent)` — line 356. Change internal scale through this entry point; invalidate the previous rendering configuration.
- `NVVisionBoostCore.setUpscalingEnabled(boolean enabled)` — line 382. Liga/desliga o upscaling com reset completo do framebuffer interno.
- `NVVisionBoostCore.toggleUpscaling()` — line 407. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.resetUpscaler()` — line 418. Apply multiple graphics-option changes together.
- `NVVisionBoostCore.saveConfig()` — line 426. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.gameRoot()` — line 446. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.saveStatus()` — line 458. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.writeReadme()` — line 562. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.log(String message)` — line 586. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.stringValue(String json, String key, String fallback)` — line 593. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.unescapeJson(String value)` — line 605. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.isEnabled()` — line 619. Master enable state, independent of the selected internal scale.
- `NVVisionBoostCore.Config.normalize()` — line 723. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.load(Path path)` — line 779. No individual contract; refer to the module responsibility and method body.
- `NVVisionBoostCore.Config.save(Path path)` — line 830. No individual contract; refer to the module responsibility and method body.

## modules/mod/shared/f4cc1a00dd0b/main/java/nvvisionboost/mixin/NVVisionBoostBackgroundFpsMixin.java

- `NVVisionBoostBackgroundFpsMixin.nvvb$backgroundLimit(CallbackInfoReturnable<Integer> ci)` — line 12. No individual contract; refer to the module responsibility and method body.

