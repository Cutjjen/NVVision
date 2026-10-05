package nvvisionboost;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import nvvisionboost.mixin.NVVisionBoostMinecraftAccessor;
<<<<<<< HEAD
import nvvisionboost.rendering.MinecraftGlStateAdapter;
=======
>>>>>>> origin/master
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

/**
<<<<<<< HEAD
 * Internal-resolution world renderer for Minecraft 1.21.1 / NeoForge / Java 21. Preserve native
 * window and UI dimensions; the external shader backend owns shader execution. No temporal history
 * or frame generation is implemented.
=======
 * NVVisionBoost 0.6.6 — correção dos passes de resolução interna
 *
 * <p>Stable internal-resolution renderer.
 *
 * <p>Minecraft 1.20.1 Forge 47.2.0 Java 17
 *
 * <p>OBJETIVO:
 *
 * <p>- reduzir somente a resolução do mundo 3D; - manter janela/HUD/GUI na resolução nativa; -
 * evitar resizeDisplay(); - evitar histórico temporal inválido; - evitar resíduos de entidades; -
 * evitar tela preta ao trocar escala; - não executar shaderpacks; - deixar Oculus responsável pelos
 * shaders.
 *
 * <p>Esta versão usa um upscale espacial estável através de framebuffer blit.
 *
 * <p>Frame Generation permanece fora deste renderer até existir implementação temporal segura com
 * motion vectors.
>>>>>>> origin/master
 */
public final class NVVisionBoostNativeRenderer {
  private static TextureTarget lowTarget;

  private static RenderTarget originalTarget;
<<<<<<< HEAD
  private static final NVVisionBoostTargetLease TARGET_LEASE = new NVVisionBoostTargetLease();
=======
>>>>>>> origin/master

  private static boolean worldPassActive = false;
  private static boolean processingBlocked;
  private static boolean checkPipelineAfterResize;
  private static boolean shaderDepthBridgeFailed;

  public static boolean isProcessingBlocked() {
    return processingBlocked;
  }

  private static void checkTarget(RenderTarget target, String label) {
    int previous = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    try {
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, target.frameBufferId);
=======
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, target.frameBufferId);
>>>>>>> origin/master
      int status = GL30.glCheckFramebufferStatus(GL30.GL_DRAW_FRAMEBUFFER);
      if (status != GL30.GL_FRAMEBUFFER_COMPLETE)
        throw new IllegalStateException(
            label + ": framebuffer incompleto 0x" + Integer.toHexString(status));
<<<<<<< HEAD
      if (GL11.glGetInteger(GL13.GL_SAMPLES) > 0)
        throw new IllegalStateException(label + ": target multisample requer resoluÃ§Ã£o nativa");
    } finally {
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, previous);
=======
    } finally {
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, previous);
>>>>>>> origin/master
    }
  }

  /** Check world depth FBOs, not just the color-only final pass left bound by Oculus. */
  private static void checkShaderTargets() throws ReflectiveOperationException {
    if (!NVVisionBoostCompatibility.externalShaderBackendAvailable()) return;
    Object pipeline = NVVisionBoostCompatibility.shaderPipeline();
    if (pipeline == null) return;
    java.lang.reflect.Field targetsField = findField(pipeline.getClass(), "renderTargets");
    if (targetsField == null) return; // VanillaRenderingPipeline has no shader FBOs.
    targetsField.setAccessible(true);
    Object targets = targetsField.get(pipeline);
    java.lang.reflect.Field owned = findField(targets.getClass(), "ownedFramebuffers");
    if (owned == null) return;
    owned.setAccessible(true);
    if (!(owned.get(targets) instanceof Iterable<?> framebuffers)) return;
    int previous = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    try {
      for (Object framebuffer : framebuffers) {
        if (!Boolean.TRUE.equals(
            framebuffer.getClass().getMethod("hasDepthAttachment").invoke(framebuffer))) continue;
        int id =
            ((Number) framebuffer.getClass().getMethod("getId").invoke(framebuffer)).intValue();
<<<<<<< HEAD
        MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, id);
=======
        GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, id);
>>>>>>> origin/master
        int status = GL30.glCheckFramebufferStatus(GL30.GL_DRAW_FRAMEBUFFER);
        if (status != GL30.GL_FRAMEBUFFER_COMPLETE)
          throw new IllegalStateException(
              "Framebuffer de shaders " + id + " incompleto: 0x" + Integer.toHexString(status));
      }
    } finally {
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, previous);
=======
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, previous);
>>>>>>> origin/master
    }
  }

  private static int auxiliaryWidth = -1;
  private static int auxiliaryHeight = -1;
  private static Class<?> diagnosticBackend;
  private static boolean diagnosticBackendResolved;
  private static Class<?> depthPipelineType, depthTargetsType;
  private static java.lang.reflect.Field depthTargetsField, depthVersionField;
  private static java.lang.reflect.Method depthTextureMethod;
  private static long lastDiagnosticNanos;
  private static String measuredResolution = "Nenhum passe observado.";
<<<<<<< HEAD
  // Trace only three frames after target creation/reset, without pixel readback or glFinish.
  private static int alignmentDiagnosticFrames = 3;

  private static void traceAlignment(String stage) {
    if (alignmentDiagnosticFrames <= 0 || originalTarget == null || lowTarget == null) return;
    try {
      int[] viewport = new int[4];
      GL11.glGetIntegerv(GL11.GL_VIEWPORT, viewport);
      int draw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
      int color =
          draw == 0
              ? 0
              : GL30.glGetFramebufferAttachmentParameteri(
                  GL30.GL_DRAW_FRAMEBUFFER,
                  GL30.GL_COLOR_ATTACHMENT0,
                  GL30.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME);
      String textureSize = "nÃ£o consultado (OpenGL < 4.5 ou attachment ausente)";
      if (color > 0 && org.lwjgl.opengl.GL.getCapabilities().OpenGL45 && GL11.glIsTexture(color)) {
        textureSize =
            org.lwjgl.opengl.GL45.glGetTextureLevelParameteri(color, 0, GL11.GL_TEXTURE_WIDTH)
                + "x"
                + org.lwjgl.opengl.GL45.glGetTextureLevelParameteri(
                    color, 0, GL11.GL_TEXTURE_HEIGHT);
      }
      NVVisionBoostCore.log(
          "[NVVB Alinhamento] "
              + stage
              + " | viewport="
              + java.util.Arrays.toString(viewport)
              + " | drawFBO="
              + draw
              + " | color="
              + color
              + " ("
              + textureSize
              + ")"
              + " | principal="
              + originalTarget.frameBufferId
              + ":"
              + originalTarget.width
              + "x"
              + originalTarget.height
              + "/tex="
              + originalTarget.getColorTextureId()
              + " | auxiliar="
              + lowTarget.frameBufferId
              + ":"
              + lowTarget.width
              + "x"
              + lowTarget.height
              + "/tex="
              + lowTarget.getColorTextureId());
    } catch (RuntimeException error) {
      NVVisionBoostCore.log("[NVVB Alinhamento] Consulta indisponÃ­vel: " + describe(error));
      alignmentDiagnosticFrames = 0;
    }
  }

=======
>>>>>>> origin/master
  private static String lastMeasurementKey = "";

  private static int mainWidth = 0;

  private static int mainHeight = 0;

  private static int lowWidth = 0;

  private static int lowHeight = 0;

  private static int allocatedWidth = -1;

  private static int allocatedHeight = -1;

  private static long processedFrames = 0;

  private static long failedFrames = 0;

  private static long skippedFrames = 0;

  private static String lastError = "";

  private static boolean diagnosticLogged = false;

  private NVVisionBoostNativeRenderer() {}

  // ============================================================
  // LEVEL RENDER
  // ============================================================

<<<<<<< HEAD
  /** Render the world through the internal target; HUD and menus retain the native target. */
  /** Wrap the complete world pass, including shader hooks and the hand. */
  /** Dimensions exposed to 3D passes; the physical window remains unchanged. */
=======
  /**
   * Executa somente o LevelRenderer dentro do framebuffer interno reduzido.
   *
   * <p>HUD, menus e GUI permanecem no framebuffer principal.
   */
  /** Envolve todo o mundo, incluindo os hooks de shaders e a mão. */
  /** Dimensões vistas pelos passes 3D; a janela física permanece intacta. */
>>>>>>> origin/master
  public static int worldWidth(int nativeWidth) {
    return worldPassActive && RenderSystem.isOnRenderThread() ? lowWidth : nativeWidth;
  }

  public static int worldHeight(int nativeHeight) {
    return worldPassActive && RenderSystem.isOnRenderThread() ? lowHeight : nativeHeight;
  }

  private static void resizeAuxiliaryTargets(Minecraft mc, int width, int height) {
    if (auxiliaryWidth != width || auxiliaryHeight != height) {
      mc.levelRenderer.resize(width, height);
      auxiliaryWidth = width;
      auxiliaryHeight = height;
    }
  }

  /** A stencil request made while redirected must also survive a return to 100%. */
  private static void preserveStencilRequirement(RenderTarget target) {
    if (target == null
        || target == lowTarget
        || lowTarget == null
        || !lowTarget.isStencilEnabled()
        || target.isStencilEnabled()) return;
    int oldFbo = target.frameBufferId;
    int oldColor = target.getColorTextureId(), oldDepth = target.getDepthTextureId();
    int active = GL11.glGetInteger(GL13.GL_ACTIVE_TEXTURE);
    int bound = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
    int read = GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING);
    int draw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    RenderSystem.activeTexture(GL13.GL_TEXTURE0);
    int boundZero = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
    try {
      target.enableStencil();
    } finally {
      RenderSystem.activeTexture(GL13.GL_TEXTURE0);
      RenderSystem.bindTexture(remapTargetTexture(boundZero, oldColor, oldDepth, target));
      RenderSystem.activeTexture(active);
      RenderSystem.bindTexture(remapTargetTexture(bound, oldColor, oldDepth, target));
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(
          GL30.GL_READ_FRAMEBUFFER, read == oldFbo ? target.frameBufferId : read);
      MinecraftGlStateAdapter.bindFramebuffer(
=======
      GL30.glBindFramebuffer(
          GL30.GL_READ_FRAMEBUFFER, read == oldFbo ? target.frameBufferId : read);
      GL30.glBindFramebuffer(
>>>>>>> origin/master
          GL30.GL_DRAW_FRAMEBUFFER, draw == oldFbo ? target.frameBufferId : draw);
    }
  }

  private static int remapTargetTexture(
      int texture, int oldColor, int oldDepth, RenderTarget target) {
    return NVVisionBoostTargetBindings.texture(
        texture, oldColor, oldDepth, target.getColorTextureId(), target.getDepthTextureId());
  }

  private static int validTexture(int texture) {
    return NVVisionBoostTargetBindings.texture(texture, -1, -1, -1, -1);
  }

  /**
<<<<<<< HEAD
   * Recover a target after an interrupted frame without switching framebuffers, clearing buffers or
   * recompiling shaders here.
=======
   * Recupera o target se um mod interrompeu o frame anterior com exceção. Não troca framebuffer,
   * não limpa buffers e não recompila shaders aqui.
>>>>>>> origin/master
   */
  public static void prepareFrame() {
    if (!RenderSystem.isOnRenderThread()) return;
    if (worldPassActive) endFrameInternal();
    Minecraft client = Minecraft.getInstance();
    // Run before native-mode early returns too. A mod can first request stencil
    // on lowTarget, then the player can immediately choose 100% or disable scaling.
    if (client != null) preserveStencilRequirement(client.getMainRenderTarget());
    if (client != null && client.level == null) {
      if (lowTarget != null) releaseLowTarget();
      auxiliaryWidth = auxiliaryHeight = -1;
      return;
    }
    if (processingBlocked) {
      Minecraft mc = Minecraft.getInstance();
      if (mc != null
          && mc.levelRenderer != null
          && mc.getWindow() != null
          && auxiliaryWidth > 0
          && auxiliaryHeight > 0) {
        resizeAuxiliaryTargets(mc, mc.getWindow().getWidth(), mc.getWindow().getHeight());
      }
    }
  }

  public static String measuredResolutionInfo() {
    return measuredResolution;
  }

  /**
<<<<<<< HEAD
   * Sample pipeline dimensions infrequently after the backend frame. Special buffers and shadow
   * maps may have independent dimensions.
=======
   * Diagnóstico de baixa frequência, após o backend terminar seu frame. getCurrentWidth/Height
   * refletem a base dos buffers do pipeline; buffers especiais e mapas de sombras podem ter
   * resoluções próprias.
>>>>>>> origin/master
   */
  private static void observePipelineResolution() {
    long now = System.nanoTime();
    if (now - lastDiagnosticNanos < 2_000_000_000L) return;
    lastDiagnosticNanos = now;
    String backendSize = "sem pipeline de shaders observado";
    try {
      if (!diagnosticBackendResolved) {
        diagnosticBackendResolved = true;
        for (String name : new String[] {"net.irisshaders.iris.Iris", "net.coderbot.iris.Iris"}) {
          try {
            diagnosticBackend = Class.forName(name);
            break;
          } catch (ClassNotFoundException ignored) {
          }
        }
      }
      if (diagnosticBackend != null) {
        Object manager = diagnosticBackend.getMethod("getPipelineManager").invoke(null);
        Object pipeline = manager.getClass().getMethod("getPipeline").invoke(manager);
        if (pipeline instanceof java.util.Optional<?> optional) pipeline = optional.orElse(null);
        if (pipeline != null) {
          java.lang.reflect.Field field = null;
          for (Class<?> type = pipeline.getClass(); type != null; type = type.getSuperclass()) {
            try {
              field = type.getDeclaredField("renderTargets");
              break;
            } catch (NoSuchFieldException ignored) {
            }
          }
          if (field != null) {
            field.setAccessible(true);
            Object targets = field.get(pipeline);
            int width =
                ((Number) targets.getClass().getMethod("getCurrentWidth").invoke(targets))
                    .intValue();
            int height =
                ((Number) targets.getClass().getMethod("getCurrentHeight").invoke(targets))
                    .intValue();
            backendSize =
                width
                    + "x"
                    + height
                    + (width == lowWidth && height == lowHeight
                        ? " (base reduzida confirmada)"
                        : " (base diferente do target NVVision)");
          }
        }
      }
    } catch (ReflectiveOperationException | RuntimeException error) {
<<<<<<< HEAD
      backendSize = "dimensÃµes do backend nÃ£o verificadas";
=======
      backendSize = "dimensões do backend não verificadas";
>>>>>>> origin/master
    }
    RenderTarget active =
        ((NVVisionBoostMinecraftAccessor) Minecraft.getInstance()).nvvb$getMainRenderTarget();
    String targetSize = active == null ? "ausente" : active.viewWidth + "x" + active.viewHeight;
    measuredResolution =
        "Mundo: "
            + targetSize
<<<<<<< HEAD
            + " | SaÃ­da: "
=======
            + " | Saída: "
>>>>>>> origin/master
            + mainWidth
            + "x"
            + mainHeight
            + " | Shaders: "
            + backendSize;
    if (!measuredResolution.equals(lastMeasurementKey)) {
      lastMeasurementKey = measuredResolution;
      NVVisionBoostCore.log("[NVVB Escala observada] " + measuredResolution);
    }
  }

  // ============================================================
  // OLD API COMPATIBILITY
  // ============================================================

<<<<<<< HEAD
  /** Compatibility entry point for earlier mixin versions. */
=======
  /** Compatibilidade com versões anteriores do mixin. */
>>>>>>> origin/master
  public static void beginFrame() {
    beginFrameInternal();
  }

<<<<<<< HEAD
  /** Compatibility entry point for earlier callers. */
=======
  /** Compatibilidade com versões anteriores. */
>>>>>>> origin/master
  public static void endFrame() {
    if (worldPassActive) {
      endFrameInternal();
    }
  }

  public static void beginLevelRender() {
    beginFrame();
    synchronizeShaderDepthTarget();
  }

  /**
<<<<<<< HEAD
   * Oculus 1.8.0 compares depth versions rather than texture identities. Invalidate only the
   * version counter before beginLevelRendering so the backend reattaches depth and recalculates
   * pack-defined sizes, including when returning to native resolution.
=======
   * Oculus 1.8.0 compara a versão do depth, mas não a identidade da textura. Dois RenderTargets
   * podem ter a mesma versão e IDs diferentes. Invalide somente esse contador antes do
   * beginLevelRendering do backend: ele próprio reanexa o depth e recalcula os tamanhos conforme as
   * diretivas do pack. Também executa ao voltar à resolução nativa, sem recarregar shaders.
>>>>>>> origin/master
   */
  private static void synchronizeShaderDepthTarget() {
    // A selected pipeline can exist before IrisApi reports a shader pack in use.
    // Inspect the actual pipeline; do not gate depth identity on that transient flag.
    if (shaderDepthBridgeFailed || !NVVisionBoostCompatibility.externalShaderBackendAvailable())
      return;
    try {
      Object pipeline = NVVisionBoostCompatibility.shaderPipeline();
      if (pipeline == null) return;
      if (depthPipelineType != pipeline.getClass()) {
        depthPipelineType = pipeline.getClass();
        depthTargetsField = findField(depthPipelineType, "renderTargets");
        if (depthTargetsField != null) depthTargetsField.setAccessible(true);
      }
      if (depthTargetsField == null) return;
      Object targets = depthTargetsField.get(pipeline);
      if (depthTargetsType != targets.getClass()) {
        depthTargetsType = targets.getClass();
        depthTextureMethod = depthTargetsType.getMethod("getDepthTexture");
        depthVersionField = findField(depthTargetsType, "cachedDepthBufferVersion");
        if (depthVersionField != null) depthVersionField.setAccessible(true);
      }
      RenderTarget current = Minecraft.getInstance().getMainRenderTarget();
      int attachedDepth = ((Number) depthTextureMethod.invoke(targets)).intValue();
      if (attachedDepth == current.getDepthTextureId()) return;
      if (depthVersionField == null)
<<<<<<< HEAD
        throw new IllegalStateException("Backend sem contador de depth compatÃ­vel");
=======
        throw new IllegalStateException("Backend sem contador de depth compatível");
>>>>>>> origin/master
      int version =
          ((Number) current.getClass().getMethod("iris$getDepthBufferVersion").invoke(current))
              .intValue();
      depthVersionField.setInt(targets, ~version);
    } catch (ReflectiveOperationException | RuntimeException error) {
<<<<<<< HEAD
      // Do not continue with depth owned by another framebuffer.
      failedFrames++;
      processingBlocked = true;
      shaderDepthBridgeFailed = true;
      lastError = "IntegraÃ§Ã£o de depth com shaders: " + describe(error);
=======
      // Não continue com um depth que pertence a outro framebuffer.
      failedFrames++;
      processingBlocked = true;
      shaderDepthBridgeFailed = true;
      lastError = "Integração de depth com shaders: " + describe(error);
>>>>>>> origin/master
      NVVisionBoostCore.log("[NVVB Upscaler] " + lastError);
      worldPassActive = false;
      restoreOriginalTarget();
      Minecraft mc = Minecraft.getInstance();
      if (originalTarget != null) {
        try {
          resizeAuxiliaryTargets(mc, mainWidth, mainHeight);
          originalTarget.bindWrite(true);
        } catch (RuntimeException recovery) {
<<<<<<< HEAD
          NVVisionBoostCore.log("[NVVB Upscaler] RecuperaÃ§Ã£o de targets: " + describe(recovery));
=======
          NVVisionBoostCore.log("[NVVB Upscaler] Recuperação de targets: " + describe(recovery));
>>>>>>> origin/master
        }
      }
      originalTarget = null;
    }
  }

  private static java.lang.reflect.Field findField(Class<?> type, String name) {
    for (; type != null; type = type.getSuperclass()) {
      try {
        return type.getDeclaredField(name);
      } catch (NoSuchFieldException ignored) {
      }
    }
    return null;
  }

  public static void endLevelRender() {
    endFrame();
  }

  // ============================================================
  // BEGIN
  // ============================================================

  private static boolean beginFrameInternal() {
    if (!RenderSystem.isOnRenderThread()) {
      return false;
    }

    if (worldPassActive) {
      return false;
    }
    if (processingBlocked) {
      skippedFrames++;
      return false;
    }

    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

    Minecraft client = Minecraft.getInstance();
    if (client != null
        && client.levelRenderer != null
        && client.getWindow() != null
        && (cfg == null
            || !cfg.enabled
            || !cfg.upscalingEnabled
            || NVVisionBoostFrameTiming.effectiveScale(cfg) >= 100
            || !NVVisionBoostCreateCompatibility.allowsFramebufferScaling()
            || client.gameRenderer.currentEffect() != null)) {
      int width = client.getWindow().getWidth();
      int height = client.getWindow().getHeight();
      mainWidth = lowWidth = width;
      mainHeight = lowHeight = height;
      // No modo nativo, o backend possui o framebuffer do passe.
<<<<<<< HEAD
      // Restore only auxiliary targets previously resized by this renderer.
      // Do not bind the main target at every HEAD hook; another pass may be active.
=======
      // Só restaure targets auxiliares que este renderer já redimensionou.
      // Não vincule o target principal em cada HEAD: isso pode substituir
>>>>>>> origin/master
      // o framebuffer escolhido por Oculus/Flywheel ou por outro mixin.
      if (auxiliaryWidth > 0 && auxiliaryHeight > 0) {
        resizeAuxiliaryTargets(client, width, height);
      }
    }
    if (!NVVisionBoostCreateCompatibility.allowsFramebufferScaling()) {
      if (client != null && client.getWindow() != null) {
        mainWidth = lowWidth = client.getWindow().getWidth();
        mainHeight = lowHeight = client.getWindow().getHeight();
        measuredResolution =
            mainWidth + "x" + mainHeight + " | " + NVVisionBoostCreateCompatibility.scalingReason();
        if (!measuredResolution.equals(lastMeasurementKey)) {
          lastMeasurementKey = measuredResolution;
          NVVisionBoostCore.log("[NVVB Compatibilidade] " + measuredResolution);
        }
      }
      skippedFrames++;
      return false;
    }
<<<<<<< HEAD
    // Vanilla PostChain runs outside the wrapped world pass. Preserve native resolution.
=======
    // PostChain vanilla roda fora do passe encapsulado. Preserve a resolução
>>>>>>> origin/master
    // nativa nesse caso em vez de misturar targets de tamanhos distintos.
    if (client != null && client.gameRenderer.currentEffect() != null) {
      skippedFrames++;
      return false;
    }

    if (cfg == null) {
      skippedFrames++;

      return false;
    }

    if (!cfg.enabled) {
      skippedFrames++;

      return false;
    }

    if (!wantsProcessing(cfg)) {
      skippedFrames++;

      return false;
    }

<<<<<<< HEAD
    /* Only spatial upscaling runs here; unrelated options must not replace targets at 100% scale. */
=======
    /*
     * Somente upscaling espacial é executado neste renderer.
     *
     * Sharpness/frame generation não devem forçar troca de
     * framebuffer quando a escala está em 100%.
     */
>>>>>>> origin/master
    if (!cfg.upscalingEnabled) {
      skippedFrames++;

      return false;
    }

    Minecraft mc = Minecraft.getInstance();

    if (mc == null || mc.options == null) {
      skippedFrames++;

      return false;
    }

    try {
      NVVisionBoostMinecraftAccessor accessor = (NVVisionBoostMinecraftAccessor) mc;

      RenderTarget current = accessor.nvvb$getMainRenderTarget();

      if (current == null) {
        skippedFrames++;

        return false;
      }

      if (current.viewWidth <= 0 || current.viewHeight <= 0) {
        skippedFrames++;

        return false;
      }

      /*
       * Nunca utilizar um lowTarget antigo como target original.
       */
      if (current == lowTarget) {
        restoreOriginalTarget();

        current = accessor.nvvb$getMainRenderTarget();

        if (current == null || current == lowTarget) {
          failedFrames++;

          lastError = "mainRenderTarget permaneceu apontando " + "para o framebuffer interno.";

          return false;
        }
      }

      originalTarget = current;
      if (!diagnosticLogged) checkTarget(originalTarget, "Target principal");

      mainWidth = current.viewWidth;

      mainHeight = current.viewHeight;

<<<<<<< HEAD
      /* Scale multiplies both dimensions: 100% native, 75% three quarters, 50% half, 25% one quarter, 10% minimum. */
=======
      /*
       * Escala real permitida:
       *
       * 100% = resolução nativa
       * 75%  = 0.75 da largura/altura
       * 50%  = metade
       * 25%  = quarto
       * 10%  = mínimo experimental
       */
>>>>>>> origin/master
      int scale = clamp(NVVisionBoostFrameTiming.effectiveScale(cfg), 10, 100);

      if (scale >= 100) {
        originalTarget = null;

        lowWidth = mainWidth;

        lowHeight = mainHeight;

        skippedFrames++;

        return false;
      }

      int requestedWidth = Math.max(1, Math.round(mainWidth * scale / 100.0f));

      int requestedHeight = Math.max(1, Math.round(mainHeight * scale / 100.0f));

<<<<<<< HEAD
      /* Resize internal attachments when dimensions change and avoid retaining pixels from previous frames. */
=======
      /*
       * Alteração de escala/resolução:
       *
       * descartar completamente o framebuffer antigo.
       *
       * Isto é fundamental para impedir imagens antigas
       * de entidades aparecendo no próximo frame.
       */
>>>>>>> origin/master
      if (lowTarget == null
          || requestedWidth != allocatedWidth
          || requestedHeight != allocatedHeight
          || (originalTarget.isStencilEnabled() && !lowTarget.isStencilEnabled())) {
        recreateTarget(requestedWidth, requestedHeight);
        NVVisionBoostFrameTiming.invalidateWorld();

        diagnosticLogged = false;
      }

      if (lowTarget == null) {
<<<<<<< HEAD
        throw new IllegalStateException("Framebuffer interno nÃ£o foi criado.");
=======
        throw new IllegalStateException("Framebuffer interno não foi criado.");
>>>>>>> origin/master
      }

      lowWidth = requestedWidth;

      lowHeight = requestedHeight;

<<<<<<< HEAD
      /* Clear color and depth each frame so unwritten pixels cannot retain previous entities or chunks. */
=======
      /*
       * Limpa COLOR + DEPTH antes de cada frame.
       *
       * Isto evita que fragmentos do frame anterior
       * sobrevivam quando chunks/entidades deixam de
       * escrever determinados pixels.
       */
>>>>>>> origin/master
      lowTarget.bindWrite(true);

      lowTarget.setClearColor(0.0f, 0.0f, 0.0f, 1.0f);

      lowTarget.clear(Minecraft.ON_OSX);

      RenderSystem.viewport(0, 0, lowWidth, lowHeight);

<<<<<<< HEAD
      /* Lend world attachments while preserving main-target identity for references retained by other mods. */
      TARGET_LEASE.begin(originalTarget, lowTarget);

      originalTarget.bindWrite(true);
=======
      /*
       * A troca acontece somente durante a chamada
       * LevelRenderer.renderLevel().
       */
      accessor.nvvb$setMainRenderTarget(lowTarget);

      lowTarget.bindWrite(true);
>>>>>>> origin/master

      RenderSystem.viewport(0, 0, lowWidth, lowHeight);

      worldPassActive = true;
<<<<<<< HEAD
      // Outlines and transparency use the world resolution.
      resizeAuxiliaryTargets(mc, lowWidth, lowHeight);
      // reload pode trocar o FBO vinculado: reafirme o destino reduzido.
      originalTarget.bindWrite(true);
      RenderSystem.viewport(0, 0, lowWidth, lowHeight);
      traceAlignment("inicio-mundo");
=======
      // Outline e transparência usam a mesma resolução do mundo.
      resizeAuxiliaryTargets(mc, lowWidth, lowHeight);
      // reload pode trocar o FBO vinculado: reafirme o destino reduzido.
      lowTarget.bindWrite(true);
      RenderSystem.viewport(0, 0, lowWidth, lowHeight);
>>>>>>> origin/master

      lastError = "";

      if (!diagnosticLogged) {
        checkPipelineAfterResize = true;

        NVVisionBoostCore.log("[NVVB Upscaler] Display: " + mainWidth + "x" + mainHeight);

        NVVisionBoostCore.log("[NVVB Upscaler] Internal: " + lowWidth + "x" + lowHeight);

        NVVisionBoostCore.log("[NVVB Upscaler] Scale: " + scale + "%");

        NVVisionBoostCore.log(
            "[NVVB Upscaler] Backend: "
                + NVVisionBoostCompatibility.shaderBackend()
                + " | ShaderAtivo="
                + NVVisionBoostCompatibility.externalShadersInUse());

        NVVisionBoostCore.log(
            "[NVVB Upscaler] Filtro: " + NVVisionBoostSpatialUpscaler.modeName(cfg.upscalerMode));

        NVVisionBoostCore.log("[NVVB Upscaler] Native shader renderer: disabled");

        diagnosticLogged = true;
      }

      return true;
    } catch (Throwable t) {
      failedFrames++;
      processingBlocked = true;

      lastError = "beginFrame: " + describe(t);

      NVVisionBoostCore.log("[NVVB Upscaler] " + lastError);

      worldPassActive = false;

      restoreOriginalTarget();
<<<<<<< HEAD
      // Recovery must not leave the native world using a reduced pipeline.
=======
      // Uma falha não pode deixar o mundo nativo com pipeline reduzido.
>>>>>>> origin/master
      try {
        resizeAuxiliaryTargets(mc, mainWidth, mainHeight);
        if (originalTarget != null) originalTarget.bindWrite(true);
      } catch (Throwable recovery) {
<<<<<<< HEAD
        NVVisionBoostCore.log("[NVVB Upscaler] RecuperaÃ§Ã£o de shaders: " + describe(recovery));
=======
        NVVisionBoostCore.log("[NVVB Upscaler] Recuperação de shaders: " + describe(recovery));
>>>>>>> origin/master
      }
      originalTarget = null;

      return false;
    }
  }

  // ============================================================
  // END
  // ============================================================

  private static void endFrameInternal() {
    if (!worldPassActive) {
      return;
    }

    try {
      if (lowTarget == null) {
<<<<<<< HEAD
        throw new IllegalStateException("lowTarget desapareceu durante renderizaÃ§Ã£o.");
      }

      if (originalTarget == null) {
        throw new IllegalStateException("originalTarget nÃ£o estÃ¡ disponÃ­vel.");
=======
        throw new IllegalStateException("lowTarget desapareceu durante renderização.");
      }

      if (originalTarget == null) {
        throw new IllegalStateException("originalTarget não está disponível.");
>>>>>>> origin/master
      }

      /*
       * O LevelRenderer terminou.
       *
       * Restauramos primeiro o target real do Minecraft.
       */
<<<<<<< HEAD
      // Observe the world while the main target still owns reduced attachments.
      observePipelineResolution();
      traceAlignment("fim-mundo/antes-upscale");
      // Return ownership before inspecting or reconstructing the two targets.
      TARGET_LEASE.restore();
      // The world pass has ended; window adapters must expose native pixels for final
      // reconstruction.
      worldPassActive = false;
      preserveStencilRequirement(originalTarget);
=======
>>>>>>> origin/master
      if (checkPipelineAfterResize) {
        checkPipelineAfterResize = false;
        int status = GL30.glCheckFramebufferStatus(GL30.GL_DRAW_FRAMEBUFFER);
        if (status != GL30.GL_FRAMEBUFFER_COMPLETE)
          throw new IllegalStateException(
              "Pipeline externo terminou com framebuffer incompleto: 0x"
                  + Integer.toHexString(status));
<<<<<<< HEAD
        checkTarget(lowTarget, "Target interno apÃ³s pipeline");
        checkShaderTargets();
      }
      restoreOriginalTarget();

      /* Reconstruct the reduced image into the main framebuffer. */
      blitToOriginal();

      /* Restore native resolution before subsequent rendering outside the world pass. */
=======
        checkTarget(lowTarget, "Target interno após pipeline");
        checkShaderTargets();
      }
      observePipelineResolution();
      restoreOriginalTarget();

      /*
       * Depois copiamos a imagem reduzida para o framebuffer
       * principal utilizando upscale espacial.
       */
      blitToOriginal();

      /*
       * Garante que qualquer renderização posterior
       * (mão/HUD/GUI/etc.) continue na resolução nativa.
       */
>>>>>>> origin/master
      if (originalTarget != null) {
        originalTarget.bindWrite(true);
      }

      RenderSystem.viewport(0, 0, mainWidth, mainHeight);
<<<<<<< HEAD
      traceAlignment("fim-upscale");
      if (alignmentDiagnosticFrames > 0) alignmentDiagnosticFrames--;
=======
>>>>>>> origin/master

      processedFrames++;

      lastError = "";
    } catch (Throwable t) {
      failedFrames++;
      processingBlocked = true;

      lastError = "endFrame: " + describe(t);

      NVVisionBoostCore.log("[NVVB Upscaler] " + lastError);
    } finally {
      worldPassActive = false;

      restoreOriginalTarget();

      originalTarget = null;
    }
  }

  // ============================================================
  // UPSCALE
  // ============================================================

  /**
<<<<<<< HEAD
   * Spatial reconstruction into the main framebuffer, without temporal history, frame generation or
   * a native shaderpack backend.
=======
   * Upscale espacial do framebuffer interno para o framebuffer principal.
   *
   * <p>GL_LINEAR é utilizado para evitar pixelização extrema.
   *
   * <p>Não há history buffer. Não há frame generation. Não há shaderpack NV nativo.
>>>>>>> origin/master
   */
  private static void blitToOriginal() {
    if (lowTarget == null || originalTarget == null) {
      return;
    }

    if (lowWidth <= 0 || lowHeight <= 0 || mainWidth <= 0 || mainHeight <= 0) {
      return;
    }

    NVVisionBoostFrameTiming.markUpscale();
    var config = NVVisionBoostCore.cfg;
    if (config != null
        && NVVisionBoostSpatialUpscaler.render(
            lowTarget.getColorTextureId(),
            originalTarget.frameBufferId,
            lowWidth,
            lowHeight,
            mainWidth,
            mainHeight,
            config.upscalerMode,
            config.upscalerSharpnessPercent,
            NVVisionBoostFrameTiming.performanceTarget(config))) {
<<<<<<< HEAD
      transferWorldDepth();
=======
>>>>>>> origin/master
      originalTarget.bindWrite(true);
      RenderSystem.viewport(0, 0, mainWidth, mainHeight);
      return;
    }

    boolean scissor = GL11.glIsEnabled(GL11.GL_SCISSOR_TEST);
    GL11.glDisable(GL11.GL_SCISSOR_TEST);
    try {
      /*
       * Source = framebuffer reduzido.
       */
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, lowTarget.frameBufferId);
=======
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, lowTarget.frameBufferId);
>>>>>>> origin/master

      /*
       * Destination = framebuffer principal.
       */
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(
          GL30.GL_DRAW_FRAMEBUFFER, originalTarget.frameBufferId);

      /* Reconstruct color; transfer depth separately with NEAREST filtering. */
=======
      GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, originalTarget.frameBufferId);

      /*
       * Upscale somente COLOR.
       *
       * Não copiamos DEPTH em dimensões diferentes.
       */
>>>>>>> origin/master
      GL30.glBlitFramebuffer(
          0,
          0,
          lowWidth,
          lowHeight,
          0,
          0,
          mainWidth,
          mainHeight,
          GL11.GL_COLOR_BUFFER_BIT,
          GL11.GL_LINEAR);
<<<<<<< HEAD
      transferWorldDepth();
=======
>>>>>>> origin/master
    } finally {
      if (scissor) GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }

<<<<<<< HEAD
    /* Return to the main framebuffer. */
    MinecraftGlStateAdapter.bindFramebuffer(GL30.GL_READ_FRAMEBUFFER, originalTarget.frameBufferId);
=======
    /*
     * Volta para o framebuffer principal.
     */
    GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, originalTarget.frameBufferId);
>>>>>>> origin/master
    originalTarget.bindWrite(true);

    RenderSystem.viewport(0, 0, mainWidth, mainHeight);
  }

  // ============================================================
  // TARGET MANAGEMENT
  // ============================================================

<<<<<<< HEAD
  private static void transferWorldDepth() {
    if (lowTarget.useDepth && originalTarget.useDepth) {
      NVVisionBoostDepthTransfer.copy(
          lowTarget.frameBufferId,
          originalTarget.frameBufferId,
          lowWidth,
          lowHeight,
          mainWidth,
          mainHeight,
          lowTarget.isStencilEnabled() && originalTarget.isStencilEnabled());
    }
  }

  private static void recreateTarget(int width, int height) {
    alignmentDiagnosticFrames = 3;
    NVVisionBoostCore.log("[NVVB Upscaler] Recriando framebuffer interno: " + width + "x" + height);

    /* Allocate valid depth for blocks, entities and transparency. */
=======
  private static void recreateTarget(int width, int height) {
    NVVisionBoostCore.log("[NVVB Upscaler] Recriando framebuffer interno: " + width + "x" + height);

    /*
     * useDepth = true
     *
     * O LevelRenderer precisa de depth buffer válido para
     * blocos, entidades e transparências.
     */
>>>>>>> origin/master
    int oldFramebuffer = lowTarget == null ? -1 : lowTarget.frameBufferId;
    int oldColor = lowTarget == null ? -1 : lowTarget.getColorTextureId();
    int oldDepth = lowTarget == null ? -1 : lowTarget.getDepthTextureId();
    int activeTexture = GL11.glGetInteger(GL13.GL_ACTIVE_TEXTURE);
    int boundTexture = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
    int previousRead = GL11.glGetInteger(GL30.GL_READ_FRAMEBUFFER_BINDING);
    int previousDraw = GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING);
    RenderSystem.activeTexture(GL13.GL_TEXTURE0);
    int unitZeroTexture = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
    try {
      if (lowTarget == null) {
        lowTarget = new TextureTarget(width, height, true, Minecraft.ON_OSX);
      } else {
<<<<<<< HEAD
        // Preserve the target object referenced by external hooks.
=======
        // Mantenha o objeto que os hooks externos já conhecem.
>>>>>>> origin/master
        lowTarget.resize(width, height, Minecraft.ON_OSX);
      }
      // Forge mods such as Immersive Engineering enable packed depth/stencil
      // on the main target. Oculus changes only the depth attachment for a
      // depth-only replacement, leaving its old stencil image attached. That
      // split pair is unsupported on affected drivers. Keep both targets packed.
      if (originalTarget != null
          && originalTarget.isStencilEnabled()
          && !lowTarget.isStencilEnabled()) {
        lowTarget.enableStencil();
      }
      lastDiagnosticNanos = 0L;
<<<<<<< HEAD
      // The shader backend tracks attachment identities and dimensions at world-pass entry.
=======
      // Oculus acompanha depth/color IDs e dimensões em beginLevelRendering().
>>>>>>> origin/master

      lowTarget.setClearColor(0.0f, 0.0f, 0.0f, 1.0f);

      lowTarget.clear(true);
<<<<<<< HEAD
      checkTarget(lowTarget, "Target interno recÃ©m-alocado");
      checkPipelineAfterResize = true;
    } finally {
      // Allocation must not leave the atlas or shader texture unit unbound.
=======
      checkTarget(lowTarget, "Target interno recém-alocado");
      checkPipelineAfterResize = true;
    } finally {
      // A alocação não pode deixar a unidade usada pelo atlas/shader sem textura.
>>>>>>> origin/master
      RenderSystem.activeTexture(GL13.GL_TEXTURE0);
      RenderSystem.bindTexture(
          lowTarget == null
              ? validTexture(unitZeroTexture)
              : remapTargetTexture(unitZeroTexture, oldColor, oldDepth, lowTarget));
      RenderSystem.activeTexture(activeTexture);
      RenderSystem.bindTexture(
          lowTarget == null
              ? validTexture(boundTexture)
              : remapTargetTexture(boundTexture, oldColor, oldDepth, lowTarget));
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(
          GL30.GL_READ_FRAMEBUFFER,
          NVVisionBoostTargetBindings.framebuffer(
              previousRead, oldFramebuffer, lowTarget == null ? 0 : lowTarget.frameBufferId));
      MinecraftGlStateAdapter.bindFramebuffer(
=======
      GL30.glBindFramebuffer(
          GL30.GL_READ_FRAMEBUFFER,
          NVVisionBoostTargetBindings.framebuffer(
              previousRead, oldFramebuffer, lowTarget == null ? 0 : lowTarget.frameBufferId));
      GL30.glBindFramebuffer(
>>>>>>> origin/master
          GL30.GL_DRAW_FRAMEBUFFER,
          NVVisionBoostTargetBindings.framebuffer(
              previousDraw, oldFramebuffer, lowTarget == null ? 0 : lowTarget.frameBufferId));
    }

    allocatedWidth = width;

    allocatedHeight = height;

    lowWidth = width;

    lowHeight = height;

<<<<<<< HEAD
    /* A newly allocated target has no temporal history. */
=======
    /*
     * Um target recém-criado não possui qualquer histórico.
     *
     * A implementação temporal antiga foi propositalmente
     * removida.
     */
>>>>>>> origin/master
    NVVisionBoostCore.log("[NVVB Upscaler] Framebuffer interno criado.");
    NVVisionBoostCore.log(
        "[NVVB Upscaler] Depth/stencil: principal="
            + (originalTarget != null && originalTarget.isStencilEnabled())
            + " | interno="
            + lowTarget.isStencilEnabled());
  }

  private static void releaseLowTarget() {
    if (lowTarget != null) {
      try {
        lowTarget.destroyBuffers();
      } catch (Throwable t) {
        NVVisionBoostCore.log("[NVVB Upscaler] destroyBuffers: " + describe(t));
      }

      lowTarget = null;
    }

    allocatedWidth = -1;

    allocatedHeight = -1;

    lowWidth = 0;

    lowHeight = 0;
  }

  // ============================================================
  // RESTORE
  // ============================================================

  private static void restoreOriginalTarget() {
    try {
<<<<<<< HEAD
      TARGET_LEASE.restore();
=======
>>>>>>> origin/master
      Minecraft mc = Minecraft.getInstance();

      if (mc == null) {
        return;
      }

      if (originalTarget == null) {
        return;
      }

      NVVisionBoostMinecraftAccessor accessor = (NVVisionBoostMinecraftAccessor) mc;

      RenderTarget current = accessor.nvvb$getMainRenderTarget();

      if (current != originalTarget) {
        accessor.nvvb$setMainRenderTarget(originalTarget);
      }

      originalTarget.bindWrite(true);
<<<<<<< HEAD
      MinecraftGlStateAdapter.bindFramebuffer(
          GL30.GL_READ_FRAMEBUFFER, originalTarget.frameBufferId);
=======
      GL30.glBindFramebuffer(GL30.GL_READ_FRAMEBUFFER, originalTarget.frameBufferId);
>>>>>>> origin/master

      if (mainWidth > 0 && mainHeight > 0) {
        RenderSystem.viewport(0, 0, mainWidth, mainHeight);
      }
    } catch (Throwable t) {
      lastError = "restore target: " + describe(t);

      NVVisionBoostCore.log("[NVVB Upscaler] " + lastError);
    }
  }

  // ============================================================
  // RESET
  // ============================================================

  /**
<<<<<<< HEAD
   * Invalidate rendering configuration after scale, enable-state, resolution, fullscreen or
   * graphics-setting changes.
=======
   * Deve ser chamado quando:
   *
   * <p>- upscaling é ativado/desativado; - escala muda; - resolução muda; - fullscreen muda; -
   * configuração gráfica é recarregada.
>>>>>>> origin/master
   */
  public static void reset() {
    Minecraft mc = Minecraft.getInstance();

    if (!RenderSystem.isOnRenderThread()) {
      if (mc != null) {
        mc.execute(NVVisionBoostNativeRenderer::reset);
      }

      return;
    }

    try {
      restoreOriginalTarget();
    } catch (Throwable ignored) {
    }

    worldPassActive = false;

    originalTarget = null;
    processingBlocked = false;
    shaderDepthBridgeFailed = false;
    checkPipelineAfterResize = false;

<<<<<<< HEAD
    // An option change does not invalidate same-sized GPU textures.
    // Preparation compares target identity, dimensions and shader selection.
=======
    // Uma alteração de opção não invalida texturas GPU de mesmo tamanho.
    // A preparação compara identidade, dimensões e seleção do shader.
>>>>>>> origin/master
    diagnosticLogged = false;

    lastError = "";

    NVVisionBoostCore.log("[NVVB Upscaler] Renderer resetado.");
  }

<<<<<<< HEAD
  /** Request another diagnostic sample; resize buffers only when dimensions change. */
=======
  /** Solicita novo diagnóstico; buffers só mudam quando suas dimensões mudam. */
>>>>>>> origin/master
  public static void invalidate() {
    NVVisionBoostFrameTiming.invalidateWorld();
    lastDiagnosticNanos = 0L;

    diagnosticLogged = false;
  }

  // ============================================================
  // STATUS
  // ============================================================

  public static boolean isActive() {
    return worldPassActive;
  }

  public static boolean effectActive() {
    NVVisionBoostCore.Config cfg = NVVisionBoostCore.cfg;

    Minecraft mc = Minecraft.getInstance();
    return !processingBlocked
        && NVVisionBoostCreateCompatibility.allowsFramebufferScaling()
        && cfg != null
        && (mc == null || mc.gameRenderer.currentEffect() == null)
        && cfg.enabled
        && cfg.upscalingEnabled
        && NVVisionBoostFrameTiming.effectiveScale(cfg) < 100
        && lastError.isBlank();
  }

  public static String internalResolution() {
    if (mainWidth <= 0 || mainHeight <= 0) {
      return "n/a";
    }

    if (lowWidth <= 0 || lowHeight <= 0) {
      return mainWidth + "x" + mainHeight + " (native)";
    }

    return lowWidth + "x" + lowHeight + " -> " + mainWidth + "x" + mainHeight;
  }

  public static int internalWidth() {
    return lowWidth;
  }

  public static int internalHeight() {
    return lowHeight;
  }

  public static long processedFrames() {
    return processedFrames;
  }

  public static long failedFrames() {
    return failedFrames;
  }

  public static long skippedFrames() {
    return skippedFrames;
  }

  public static String lastError() {
    return lastError;
  }

  public static int currentFps() {
    try {
      Minecraft mc = Minecraft.getInstance();

      if (mc == null) {
        return 0;
      }

      return Math.max(0, mc.getFps());
    } catch (Throwable ignored) {
      return 0;
    }
  }

  // ============================================================
  // PROCESSING RULES
  // ============================================================

  private static boolean wantsProcessing(NVVisionBoostCore.Config cfg) {
    if (cfg == null) {
      return false;
    }

<<<<<<< HEAD
    /* Keep independent features outside the internal world renderer to avoid unnecessary framebuffer replacement. */
=======
    /*
     * O renderer interno NÃO é mais responsável por:
     *
     * nativeShaderRenderer
     * frame generation
     * sharpening em resolução nativa
     *
     * Isso impede que recursos independentes provoquem
     * substituição desnecessária do framebuffer.
     */
>>>>>>> origin/master
    return cfg.upscalingEnabled && NVVisionBoostFrameTiming.effectiveScale(cfg) < 100;
  }

  // ============================================================
  // UTILITIES
  // ============================================================

  private static int clamp(int value, int min, int max) {
    return Math.max(min, Math.min(max, value));
  }

  private static String describe(Throwable throwable) {
    if (throwable == null) {
      return "unknown";
    }

    String message = throwable.getMessage();

    if (message == null || message.isBlank()) {
      return throwable.getClass().getSimpleName();
    }

    return throwable.getClass().getSimpleName() + ": " + message;
  }
<<<<<<< HEAD

  /** Only the leased main framebuffer participates in this pixel contract. */
  public static boolean isReducedMainBound() {
    return worldPassActive
        && RenderSystem.isOnRenderThread()
        && originalTarget != null
        && originalTarget.viewWidth == lowWidth
        && originalTarget.viewHeight == lowHeight
        && GL11.glGetInteger(GL30.GL_DRAW_FRAMEBUFFER_BINDING) == originalTarget.frameBufferId;
  }

  private static int repairedViewportReports;

  public static boolean adaptNativeViewport(int x, int y, int width, int height) {
    boolean repair =
        isReducedMainBound()
            && NVVisionBoostPixelAdapter.nativeViewportOnReducedTarget(
                x, y, width, height, mainWidth, mainHeight, lowWidth, lowHeight);
    if (repair && repairedViewportReports < 3) {
      repairedViewportReports++;
      String origin =
          StackWalker.getInstance()
              .walk(
                  frames ->
                      frames
                          .filter(frame -> !frame.getClassName().startsWith("nvvisionboost."))
                          .limit(6)
                          .map(frame -> frame.getClassName() + "." + frame.getMethodName())
                          .collect(java.util.stream.Collectors.joining(" <- ")));
      NVVisionBoostCore.log("[NVVB Pixel Adapter] Origem: " + origin);
      NVVisionBoostCore.log(
          "[NVVB Pixel Adapter] Viewport nativa corrigida no mundo: "
              + width
              + "x"
              + height
              + " -> "
              + lowWidth
              + "x"
              + lowHeight);
    }
    return repair;
  }
=======
>>>>>>> origin/master
}
