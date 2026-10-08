# Estrutura do projeto NVVision

Este documento funciona como a navegação de estrutura do projeto no GitHub. Ele detalha o papel de cada parte do repositório e explica como o código principal, os adaptadores e os artefatos de build se conectam.

## Visão geral

O projeto foi organizado para separar:

- lógica compartilhada
- lógica específica de cada loader/version
- configuração e metadados
- documentação e validação
- artefatos finais para distribuição

A arquitetura central mantém um código-base comum e desloca os detalhes de compatibilidade para módulos e adapters específicos.

## Topo do repositório

```text
NVVision-Organizado-Fontes/
├─ README.md
├─ build.gradle
├─ settings.gradle
├─ gradlew / gradlew.bat
├─ .gitignore
├─ .gitattributes
├─ COPYRIGHT.md
├─ config/
├─ docs/
├─ source/
├─ targets/
├─ Modloaders/
├─ tools/
├─ verification/
├─ third-party/
├─ build/
├─ gradle/
└─ ...
```

## Diretórios principais

### `source/`
Diretório principal do código-fonte do mod.

- `source/modules/mod`: base comum do comportamento do mod, UI, controle de renderização e integração com o cliente.
- `source/modules/addon`: addon de otimização e regras de CPU, visual e políticas de performance.
- `source/adapters`: adaptações específicas por Minecraft/loader, responsável por isolar diferenças entre versões e plataformas.

### `source/modules/mod`
Aqui fica a parte mais estável e reutilizável.

Funções principais:

- políticas de renderização
- painéis e interface de configuração
- integração com o cliente
- controle compartilhado de opções e estado
- regras de compatibilidade e fallback

### `source/modules/addon`
Responsável por um componente complementar que trabalha com CPU, visual e limites gráficos.

Funções principais:

- gerenciamento de presets
- regras de otimização por hardware
- limites de partículas e distância visual
- persistência de escolhas do usuário
- integração com o cliente e componentes externos

### `source/adapters`
Aqui está o coração da compatibilidade.

Cada adapter fica responsável por um alvo específico, como:

- Fabric
- Forge
- NeoForge
- versões do Minecraft
- diferenças de plataforma e API

Essa separação evita que a lógica principal fique acoplada às peculiaridades de uma versão do jogo.

## Configuração e metadados

### `config/`
Contém o registro de todos os alvos e fontes válidas.

Arquivos típicos:

- `sources.json`: lista de fontes e dependências
- `versions.json`: versão, compatibilidade e estrutura do projeto
- `release-policy.json`: regras de publicação e release

Esses arquivos funcionam como mapa do projeto e ajudam no build e na manutenção.

## Build e distribuição

### `targets/`
Diz respeito aos alvos de build gerados para cada loader e versão do Minecraft.

Esses diretórios são o ponto de entrada para compilar cada variação do projeto.

### `Modloaders/`
Contém os artefatos finais do projeto já organizados por loader e versão.

Exemplo:

- Fabric + 1.21.1
- Forge + 1.20.1
- NeoForge + 1.21.1

Isso torna a distribuição por plataforma clara e rastreável.

## Ferramentas e automação

### `tools/`
Contém geradores e utilitários.

Algumas funções comuns:

- geração de índice de funções
- mapeamento de ports/versões
- análise de compatibilidade
- geração de documentação técnica e rastreio de implementação

### `verification/`
Armazena provas de validação e registros de compatibilidade.

Também contém arquivos usados para verificar se um build está seguro de ser entregue, ou se a compatibilidade está dentro do que foi previsto pelo projeto.

## Documentação

### `docs/`
É a área de explicação para o projeto.

Documentos importantes:

- `ARCHITECTURE.md`: visão geral da arquitetura e responsabilidades.
- `FUNCOES.md`: índice de funções e rotas principais.
- `SOURCE-MAP.md`: inventário de fontes e módulos.
- `VALIDACAO.md`: registros de testes e validação.
- `COMPATIBILITY-NOTICE.md`: compatibilidade e limitações.

Esses arquivos servem como documentação viva do projeto e ajudam a manter o código sustentável.

## Fluxo típico

1. A lógica central é escrita em `source/modules/mod`.
2. O addon e os controles de desempenho ficam em `source/modules/addon`.
3. As diferenças por loader ou versão são isoladas em `source/adapters`.
4. O Gradle monta cada alvo conforme `config/` e `gradle/`.
5. Os artefatos finais são exportados em `targets/` e `Modloaders/`.
6. A validação e a documentação ficam em `verification/` e `docs/`.

## Resumo prático

A estrutura do projeto foi pensada para:

- manter um código base unificado
- reduzir duplicações
- separar compatibilidade por versão
- facilitar manutenção e portabilidade
- tornar o processo de build e release previsível

Se você quer entender o projeto de um ponto de vista de manutenção, a chave está em: `source/modules` para lógica compartilhada, `source/adapters` para diferenças específicas e `config`/`tools` para orquestração e validação.
