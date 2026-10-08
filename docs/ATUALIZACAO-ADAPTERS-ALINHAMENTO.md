# Atualização de alinhamento do upscaling

Criação: Cutjjen. Data: 2026-10-04.

## Problema e comportamento atualizado

A versão anterior NeoForge 1.21.1 (.7) continuou apresentando duas luas, partículas e texturas deslocadas no teste informado pelo usuário com Iris/BSL no ATM10. O log também continha uma textura inválida em OpenGL. A mensagem isolada não identifica com certeza qual mod originou esse erro.

As novas builds preservam a identidade do target principal, transferem profundidade/stencil para a resolução de saída e utilizam os adapters de bindings do Minecraft. Os renderers modernos trocam texturas e views juntas; mantêm o formato e a capacidade de stencil compatíveis. Dimensões vistas pelo mundo vêm do target emprestado, não do objeto interno que guarda temporariamente os recursos nativos.

A camada comum e as regras de Gradle são descritas em ADAPTERS-RENDERIZACAO.md.

## Novos conjuntos

| Loader | Minecraft | Mod e addon |
|---|---|---|
| Forge | 1.20.1 | 0.7.21 |
| Fabric | 26.2 | 0.8.2 |
| Fabric | 1.21.10 | 0.8.3 |
| NeoForge | 26.1.2 | 0.8.4 |
| NeoForge | 26.2 | 0.8.4 |
| NeoForge | 1.21.10 | 0.8.5 |
| NeoForge | 1.21.1 | 0.8.7 |

Cada pasta nova contém exatamente os dois compilados do conjunto, metadados, checksums e resultados dos testes. As pastas anteriores foram preservadas; nenhum ZIP foi gerado. Instale somente o conjunto correspondente ao Minecraft e loader. Não mantenha dois JARs do mesmo mod instalados simultaneamente.

## Validação executada

- Compilação dos 14 JARs, com Java 17, 21 ou 25 conforme o alvo.
- 472 verificações de identidade/propriedade e alinhamento de profundidade/stencil em contextos OpenGL reais.
- 70 verificações de bindings do Minecraft após alterações externas do estado OpenGL.
- 465 verificações dos filtros/GPU em OpenGL, incluindo FSR 1.
- Regressões de layout, idiomas, políticas CPU, propriedade das opções e persistência das configurações em cada linha.
- 211 verificações de mixins nos artefatos de produção.
- 3.967 referências de produção conferidas contra as bibliotecas Minecraft/loader reais.
- Gradle: integridade de 850 bindings, formatação, contratos de adapters, índice de funções e 24 verificações independentes da política CPU.

A fixture Fabric 1.21.10 usada na validação de produção foi gerada com Tiny Remapper oficial, preservando a propagação de mappings de métodos herdados. O ambiente continua apresentando AccessDeniedException no ZipFS do Java: a compilação completa pelos plugins Gradle não foi declarada aprovada. Os JARs foram compilados pelas ferramentas Java locais preservadas, com remapeamento e conferência de referências/mixins. Os checks Gradle acima passaram.

## Limites e reteste necessário

Ainda não houve execução visual das novas builds no mundo ATM10. Não foi medido ganho de FPS, nem confirmado que o defeito visual foi eliminado naquele cenário. O sucesso automatizado valida os componentes corrigidos, sem provar compatibilidade universal com todos os passes de mods.

No reteste do NeoForge 1.21.1, confirme no log a versão 0.8.7, compare 100%, 85% e 50%, com Iris desligado e ligado, e observe céu, blocos, partículas, animações, HUD e retorno à escala nativa. Preserve o mesmo shader/configuração para permitir comparação. Essa recomendação não altera os mundos/configs do usuário.

