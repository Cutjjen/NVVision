# NeoForge 1.21.1 — NVVision e addon 0.8.9

Autoria: Cutjjen. Upscaling preservado. Validação visual no modpack pendente.

## Inspeção do código instalado

Sodium 0.8.13+mc1.21.1 possui seu renderer em um JAR interno. GLRenderDevice limpa o estado de buffers e vertex arrays; o cache de ShaderInstance guarda localizações dos samplers. Esses trechos não demonstram deslocamento de texturas.

Iris 1.8.14-beta.1+mc1.21.1 dimensiona renderTargets a partir do framebuffer principal e reconecta profundidade quando sua versão muda. Os viewports dos passes compostos podem ter escalas e offsets próprios; não devem ser normalizados indiscriminadamente.

Sodium Extra 0.9.4+mc1.21.1 encaminha o framebuffer principal à projeção Panini. As opções de sol e lua trocam recursos; não foi encontrado um segundo renderer de lua nesse caminho. Panini estava desligado no arquivo analisado. Não há comprovação de que Sodium Extra cause o defeito.

## Adapter implementado

O contrato reutilizável PixelAdapter reconhece pedidos de viewport integral nativa feitos sobre um alvo principal reduzido. A ligação 1.21.1 aplica a correção somente durante o mundo, na thread gráfica e quando o framebuffer principal emprestado está ligado. Viewports parciais, offsets, sombras e outros framebuffers são preservados.

SCREEN_SIZE dos shaders vanilla acompanha as dimensões reais do alvo principal, sem alterar as matrizes de projeção. O adapter opcional do Sodium Extra descobre sua API por capacidades e registra Panini; não grava opções e continua sem o mod ou com API diferente. A aplicação do contrato de pixels não depende da presença do Sodium Extra.

No log, até três mensagens [NVVB Pixel Adapter] indicam que uma solicitação nativa foi corrigida. Ausência da mensagem significa que esse caminho não foi observado; não significa resolução do defeito.

Para outra versão, reutilize o módulo pixel-adapter e adapte os hooks RenderSystem.viewport e ShaderInstance.setDefaultUniforms ao mapeamento correspondente. Verifique as assinaturas, os testes e o renderer real antes de registrar o módulo naquele alvo. Isso facilita ports, mas não torna um mesmo JAR universal.

## Teste necessário

Comparar 100% e 85% na mesma cena com shader ligado e desligado; observar lua, partículas e texturas. Repetir com Sodium Extra presente e ausente, se possível. A compilação e os testes automatizados não substituem essa validação. Nenhum ganho de FPS foi medido nesta atualização.
