# Auditoria de alinhamento do upscaling

Data: 2026-10-04. Escopo: comparação estática dos sete adapters ativos registrados em config/versions.json. Nenhum novo teste visual em mundos/modpacks foi realizado nesta auditoria.

| Linha | Troca a identidade do target principal | Transfere profundidade após upscale | Conclusão |
|---|---|---|---|
| Forge 1.20.1 | Sim | Não; passe espacial retorna cedo e fallback copia somente cor | Repete os dois padrões corrigidos no NeoForge 1.21.1. |
| Fabric 1.21.10 | Sim | Sim, NEAREST | Risco de referências de outros mods para o target antigo; não repete a omissão de profundidade. |
| NeoForge 1.21.10 | Sim | Sim, NEAREST | Mesmo risco de identidade; não repete a omissão de profundidade. |
| Fabric 26.2 | Sim | Sim, NEAREST | Mesmo risco de identidade; atualiza também WindowRenderState. |
| NeoForge 26.1.2 | Sim | Sim, NEAREST | Mesmo risco de identidade; atualiza também WindowRenderState. |
| NeoForge 26.2 | Sim | Sim, NEAREST | Mesmo risco de identidade; atualiza também WindowRenderState. |
| NeoForge 1.21.1, 0.8.6-neoforge.7 | Não, usa TargetLease | Sim, com stencil quando necessário | Os dois padrões foram corrigidos; verificação visual no ATM10 permanece pendente. |

Evidências: NVVisionBoostNativeRenderer.java específico de cada adapter em source/adapters/<linha>/mod/main/java/nvvisionboost. Forge 1.20.1: troca em linha 647 e composição nas linhas 789–854. Linhas modernas: beginLevelRender troca o target, endLevelRender copia GL_DEPTH_BUFFER_BIT com GL_NEAREST. NeoForge 1.21.1 usa NVVisionBoostTargetLease e NVVisionBoostDepthTransfer.

Trocar o target é um risco de compatibilidade quando outro mod conserva a referência anterior, não prova de que toda instalação apresentará texturas deslocadas. A causa visual exata ainda depende do modpack e da fase em que cada mod desenha. As APIs RenderTarget modernas usam GpuTexture, enquanto a linha antiga usa IDs OpenGL; a correção de campos da 1.21.1 não deve ser copiada diretamente para as demais.

Nenhuma build alterada ou renumerada por esta auditoria. O addon não executa esse passe de framebuffer; a evidência identificada está no renderer do mod principal.
