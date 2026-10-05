<<<<<<< HEAD
# Architecture and responsibility map

## Startup and platform boundary

Loader entry points load local configuration, register client events and connect the menu. PlatformAdapter isolates mod detection and directories. Minecraft adapters isolate changing game APIs. Only registered targets and sources participate in builds.

## World rendering

The resolution controller chooses an internal pixel budget. Menus, reloads and incompatible pipeline states retain native resolution. RenderTargetAdapter captures and applies attachment state. WorldTargetLease exchanges ownership while preserving main-target identity. Restore ownership after the world pass and before final presentation/GUI rendering.

MinecraftGlStateAdapter reconciles actual OpenGL bindings with Minecraft's tracked state. NVVisionBoostDepthTransfer transfers depth/stencil with NEAREST filtering and restores bindings/scissor state. Each version retains its specific hooks, resource types and backend constraints. See RENDERING-ADAPTERS.md.

Iris/Oculus own shader execution. Preparation services read/index resources rather than replacing the backend. Create/Flywheel and Distant Horizons detection restricts unsafe interventions. Optional integrations must fail conservatively when supported APIs or schemas are absent.

## UI and persistence

Screens present localized controls and tooltips. Shared layout policies calculate usable bounds; Options placement respects other mods' widgets. Empty background overrides intentionally prevent native blur from obscuring text.

Configuration services preserve preferences and unknown properties. Cache refreshes invalidate generated resources rather than deleting preferences. Hardware catalogs guide presets; GPU identification does not establish support for unimplemented vendor technologies.

## CPU addon

- CpuPolicy: validate profiles, normalize values, calculate ceilings and cycle choices without game-state access.
- BridgeCpuOptimizer: load/save choices, schedule client-thread application and reevaluate at most once per second.
- CpuOptionLease: track temporary ownership; external edits stop overriding until release.
- CpuMinecraftAdapter: isolate changes such as particle-option enum packages.
- Loader bridge classes: register lifecycle callbacks and expose local integration state.

Presets affect visual entity distance and native particles, not server ticks or machine simulation. Workload-dependent savings require measurement.

## Maintenance

Share identical behavior through the registry; retain real API differences in adapters. Preserve entry points, reflection targets, mixin accessors and intentional no-op overrides unless reachability analysis proves them unnecessary.

For a port, verify actual signatures, adapt affected boundaries, register dependencies and sources, run regressions and production-mapping checks, then test visually. The generated method index identifies source locations; it is not proof of an individual audit of every method.
=======
# Responsabilidades e fluxo

## Inicialização

O ponto de entrada do loader inicializa a configuração, registra eventos do cliente e conecta o menu. `PlatformAdapter` encapsula identificação de mods e diretórios. O adapter de Minecraft encapsula chamadas que mudam entre versões. Essas camadas não dependem de renderizar o mundo.

## Renderização

O controlador de escala decide se pode reduzir a resolução interna. Menus, recargas de recursos e estados incompatíveis mantêm a resolução nativa. O renderer executa o passe de reconstrução e deve preservar o estado OpenGL que pertence ao Minecraft, ao shader e à interface. Os mixins conectam esses passos aos pontos específicos de cada versão; não são intercambiáveis entre versões.

As integrações de shaders consultam o backend ativo e o estado do pipeline. Os perfis de qualidade alteram somente controles conhecidos. A detecção de Create/Flywheel e Distant Horizons restringe intervenções que poderiam prejudicar seus renderizadores.

## Interface e configuração

As telas apresentam controles e traduções. O cálculo de layout determina posição e área útil; o posicionamento do botão nas opções respeita widgets de outros mods. Os overrides vazios de `renderBackground` evitam que a implementação nativa desenhe desfoque sobre textos já renderizados.

Os serviços de configuração preservam preferências do usuário. A atualização dos caches gerados não equivale a apagar configurações. Catálogos de hardware orientam presets, sem transformar detecção de marca em suporte a tecnologias que não foram implementadas.

## Addon de CPU

`CpuPolicy` é a política pura: valida perfis, normaliza valores, calcula tetos e percorre escolhas. `BridgeCpuOptimizer` lê e grava a configuração, agenda aplicação na thread do cliente e reavalia limites no máximo uma vez por segundo. `CpuOptionLease` conserva a propriedade temporária de cada opção: se usuário ou outro mod mudar o valor, o addon deixa de sobrescrevê-lo. `CpuMinecraftAdapter` isola a mudança de pacote do enum de partículas.

Os presets atuam em distância visual de entidades e partículas nativas. Não alteram a simulação do servidor nem representam uma reescrita do loader. O efeito no FPS precisa ser medido em cada cenário.

## Manutenção

Cada entrada de `config/sources.json` associa fonte, componente e destino. Arquivos com mesmo conteúdo, componente e caminho compartilham uma fonte. Diferenças reais de APIs permanecem em adapters ou variantes explícitas. Fontes antigas que não constam do registro ficam fora do build.

Para uma nova versão, confirme o contrato do loader e as assinaturas do Minecraft, adapte os pontos de integração, registre dependências e execute compilação, regressão e teste no jogo. O Gradle e o adapter facilitam essa tarefa, mas não dispensam essa validação.
>>>>>>> origin/master
