# NeoForge 1.21.1 — NVVision e addon 0.8.11

Cutjjen. Extensão do adapter de viewport ao caminho comum do Minecraft.

Reteste 0.8.10 ATM10: viewport e framebuffer principal estão reduzidos a 1632x858 durante o mundo e nativos a 1920x1009 no fim-upscale. O usuário confirma que texturas continuam deslocadas e normalizam com upscaling desligado. Portanto o erro da saída final foi corrigido, mas não a causa original dos passes desalinhados.

A inspeção do bytecode 1.21.1 confirma que GlStateManager._viewport atualiza seu registro Viewport e chama OpenGL; RenderSystem.viewport encaminha para essa API, mas framebuffers podem chamá-la diretamente. A 0.8.11 move o hook para _viewport, cobrindo ambos. A correção reentra uma vez com proteção contra recursão, mantendo o registro interno e o driver sincronizados. O contrato continua restrito a pedidos de viewport integral nativa sobre o framebuffer principal reduzido; não normaliza sombras, offsets ou outros framebuffers.

Até três solicitações corrigidas registram a cadeia de origem via StackWalker. Essa captura só ocorre quando uma divergência real é detectada, não em cada quadro. Ela permitirá localizar o chamador que usa dimensões nativas durante o mundo. Se o deslocamento continuar sem correção registrada, investigar outras causas, como uniformes, textura amostrada e buffers intermediários; não atribuir automaticamente a Sodium Extra ou CPU.

Upscaling preservado; configurações não alteradas; fontes e addon versionados juntos. Validação visual do modpack pendente; não há ganho de FPS medido. Testes de framebuffer da 0.8.10 permanecem para impedir regressão da saída final.
