# Auditoria de compatibilidade — NeoForge 1.21.1 / NVVision 0.8.11

Autoria do mod: Cutjjen. Auditoria realizada em 04/10/2026. Não confirma estabilidade visual.

## Evidência da sessão ATM10

Logs confirmam NVVision e addon 0.8.11. Mundo e Iris: 1632x858 em 85%; saída: 1920x1009. Nenhum GL_INVALID, OpenGL debug ou falha de aplicação de mixin do NVVision encontrado. Nenhuma mensagem de correção/origem do Pixel Adapter foi registrada nessa sessão. O usuário informa desalinhamento persistente ao ativar o upscaling; a imagem não é validada pelas dimensões dos registros.

O único overwrite conflict localizado no log envolve getActiveRecipe do tesseract_api, fora dos hooks gráficos do NVVision. Não atribuir esse conflito ao defeito visual.

## Revisão dos pontos de integração

| Componente instalado | Resultado da revisão | Limite |
| --- | --- | --- |
| Sodium 0.8.13 | Núcleo localizado no JAR interno; cache de localizações de samplers e gestão de buffers/VAOs inspecionados | Ausência de conflito de mixin não valida a imagem |
| Iris 1.8.14-beta.1 | RenderTargets recebem dimensões reduzidas e depth é sincronizado por identidade; final output nativo confirmado | Buffers/passes intermediários e uniforms por material ainda não foram capturados por draw |
| Sodium Extra 0.9.4 | API reconhecida, Panini desligado; callback de Panini usa target principal | Nenhuma prova de causalidade; adapter não precisou corrigir viewport nesta sessão |
| Colorwheel 1.3.0-beta3 + patcher 1.0.5 | Mixins inspecionados: cria framebuffers gbuffers por Iris, adiciona contexto de translucência e integra Flywheel | Esses caminhos ampliam os passes envolvidos; interação de escala não validada por teste isolado |
| Create 6.0.10 / Flywheel | Preset Original/restaurar, escala automática suspensa; sincronização Ocuwheel não roda sem Ocuwheel instalado | Renderização instanciada de Create/Colorwheel exige validação separada |
| ImmediatelyFast 1.6.14 | MixinWindow inicializa recursos/fecha frame, sem substituir getters de tamanho; MixinFramebuffer força flush de HUD quando batching ativo | Batching e hooks de GameRenderer não foram validados em execução isolada com NVVision |
| FerriteCore 7.0.3 | O port NVVision limita detect() a 6.0.0/6.0.1; versão 7.0.3 fica não validada e seus controles indisponíveis | Limitação concreta do port, não conflito de textura comprovado |
| Fusion 1.3.15b | Inventário de mixins inclui modelos, atlas, quad lighting e TerrainParticle | Inventário não prova incompatibilidade; não foi decompilado o motor completo |
| ModernFix 5.27.24 | Presença confirmada, sem falha atribuída ao NVVision no log | Sem teste isolado de todos os recursos |
| Distant Horizons | Não localizado como JAR nesta instância | Não pode ser validado em execução nessa sessão |
| Addon CPU | Código altera opções nativas de distância/partículas, não gera ou transforma coordenadas/texturas | Possíveis interações indiretas não são excluídas por inspeção |

## Código NVVision revisado

Contratos de framebuffer e lease, começo/fim de mundo, Window getters, viewport e ScreenSize, upscaler espacial, sincronização de depth, preparo de shader, descoberta de integrações, presets Create, detecção FerriteCore e runtime CPU. Inventário de fontes e contratos de adapters verificados pelas tarefas Gradle. Foram utilizados também resultados de compilação, checks de 23 mixins e 682 referências da build 0.8.11.

Não foi feita uma revisão manual de cada linha de todos os mods externos nem reproduzida a instância inteira sob debugger. Essa revisão não autoriza declarar compatibilidade total ou atribuir a causa a um mod específico.

## Conclusão e isolamento necessário

Não há conflito gráfico nominal comprovado no log. A ativação do upscaling continua sendo o gatilho confirmado pelo usuário. A hipótese mais ampla é falta de coerência entre recursos/amostragem/uniformes de passes intermediários, sem localização da chamada responsável. Não continuar a corrigir viewport sem evidência de que ela diverge.

Próxima validação útil em uma cópia da instância: NVVision+addon+Sodium, primeiro sem Iris e outros complementos; depois Iris; depois Sodium Extra; depois Colorwheel/Create e ImmediatelyFast em grupos separados. Manter mesma cena e escala. Preservar a instância original, mundos e configs. Se o problema ocorrer no primeiro cenário, a causa está no NVVision ou em sua integração base, sem precisar culpar outros complementos. Não houve alteração ou remoção de mods do usuário nesta auditoria.
