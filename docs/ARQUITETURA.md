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
