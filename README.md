<<<<<<< HEAD
# NVVision — Cutjjen

Projeto de otimização visual e controle de desempenho para Minecraft, com uma parte principal do mod e um addon complementar para políticas de CPU e ajustes visuais. O objetivo é manter a experiência do jogo mais responsiva sem quebrar o comportamento original do cliente ou do carregador.

Pressione **F8** ou use **Opções → NVVisionBoost** para abrir a interface. O menu possui suporte para inglês e português, presets orientados a hardware, controles individuais e explicações por tooltip.

## Visão geral do projeto

Este repositório reúne:

- o código do mod principal em `source/`
- os adaptadores por loader e versão do Minecraft em `source/adapters/`
- a parte de CPU/addon em `source/modules/addon/`
- a lógica compartilhada de UI, políticas e renderização em `source/modules/mod/`
- os arquivos de configuração e versão em `config/`
- os artefatos de pacote e plataforma em `targets/` e `Modloaders/`
- documentação técnica e validação em `docs/` e `verification/`

A estrutura foi criada para permitir um único código base servir vários loaders e versões do jogo, mantendo as diferenças específicas de cada plataforma em pontos isolados chamados adaptadores.

## Estrutura principal do repositório

```text
NVVision-Organizado-Fontes/
├─ README.md                              # Página principal do GitHub
├─ build.gradle                           # Build principal do Gradle
├─ settings.gradle                        # Configuração dos módulos
├─ gradlew / gradlew.bat                  # Wrapper do Gradle
├─ COPYRIGHT.md                           # Direitos autorais e limites de uso
├─ config/                                # Registro de fontes, versões e políticas
│  ├─ sources.json
│  ├─ versions.json
│  ├─ release-policy.json
│  └─ ...
├─ docs/                                  # Documentação do projeto
│  ├─ ARCHITECTURE.md
│  ├─ ESTRUTURA-DO-PROJETO.md
│  ├─ FUNCOES.md
│  ├─ SOURCE-MAP.md
│  ├─ VALIDACAO.md
│  └─ ...
├─ source/                                # Código-fonte do mod
│  ├─ modules/
│  │  ├─ mod/
│  │  └─ addon/
│  ├─ adapters/
│  └─ ...
├─ targets/                               # Diretórios dos artefatos por loader/version
├─ Modloaders/                            # Build final e pares de loader/minecraft
├─ tools/                                 # Geradores de índice, mapas e porting tools
├─ verification/                          # Validação e registros de compatibilidade
├─ third-party/                           # Dependências e materiais externos
├─ build/                                 # Saídas e arquivos temporários do Gradle
└─ gradle/                                # Configuração do gradle e targets
```

## O que cada etapa faz

### 1) `source/modules/mod`
Responsável pela parte compartilhada do mod: interface gráfica, políticas de renderização, carregamento de configuração e integração com o cliente. Aqui ficam os componentes que devem funcionar de forma igual entre várias versões do jogo.

### 2) `source/modules/addon`
Contém a lógica do addon complementar, principalmente controles de CPU, limites visuais e políticas de otimização relacionadas a partículas, entidades e uso do cliente. É a camada de ajuste de desempenho e compatibilidade.

### 3) `source/adapters`
É o ponto de diferenciação entre versões e loaders. Cada adapter cuida das diferenças reais de API, eventos, classes e estrutura do jogo. Essa separação evita que o código principal fique acoplado a uma única versão do Minecraft.

Exemplos:

- `fabric-*`
- `forge-*`
- `neoforge-*`
- `minecraft/`
- `platform/`

### 4) `config/`
Armazena os metadados do projeto:

- quais fontes pertencem a cada alvo
- quais versões do Minecraft e loaders são registradas
- regras de publicação e compatibilidade
- políticas de release e integração

Esses arquivos servem como mapa de identidade para compilar e validar o projeto corretamente.

### 5) `targets/`
Diretório dos alvos gerados para cada combinação de loader e versão. Aqui ficam as entradas de build para cada plataforma, como Fabric, Forge e NeoForge.

### 6) `Modloaders/`
Concentra os artefatos finais e os pares de mod+addon por loader e versão. É a área de distribuição da compilação pronta para uso por plataforma.

### 7) `tools/`
Armazena ferramentas de geração e automação: índice de funções, mapeamento de portas, geração de compatibilidade e análise de fontes. Esses scripts ajudam a manter o projeto consistente e rastreável.

### 8) `docs/`
Documentação técnica, arquitetura, validação, compatibilidade e histórico de alterações. É a base de explicação para quem precisa entender o projeto e manter o código.

### 9) `verification/`
Contém registros de validação, testes de compatibilidade, análise de ajustes e avaliações de release. É a camada de evidência que mostra o que foi testado e qual estado final foi validado.

### 10) `third-party/`
Guarda recursos, bibliotecas ou materiais externos que são utilizados ou referenciados pelo projeto.

### 11) `gradle/` e `build.gradle`
Definem a infraestrutura do build, toolchains Java e regras de compilação. Eles conectam o código com cada loader e versão suportada.

## Fluxo de trabalho do projeto

1. O código principal define comportamento compartilhado.
2. Os adaptadores isolam diferenças por plataforma.
3. A configuração registra os alvos válidos.
4. O build monta cada versão para os loaders suportados.
5. A validação compara compatibilidade, regras e portas.
6. O projeto gera artefatos prontos para uso em `Modloaders/` e `targets/`.

## Build e validação

Use o wrapper do Gradle com JDK completo:

```powershell
./gradlew.bat "-Ploader=forge" build
./gradlew.bat "-Ploader=neoforge" "-Pminecraft=1.21.1" build
./gradlew.bat "-Ploader=fabric" "-Pminecraft=26.2" build
```

Os checks de formatação, registro, adaptadores e compatibilidade devem ser executados antes de publicar uma release. A validação visual também é importante, porque a otimização de renderização e o comportamento do cliente dependem do ambiente real do jogo.

## Documentação complementar

- [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- [docs/ESTRUTURA-DO-PROJETO.md](docs/ESTRUTURA-DO-PROJETO.md)
- [docs/FUNCOES.md](docs/FUNCOES.md)
- [docs/SOURCE-MAP.md](docs/SOURCE-MAP.md)
- [docs/VALIDACAO.md](docs/VALIDACAO.md)
- [docs/COMPATIBILITY-NOTICE.md](docs/COMPATIBILITY-NOTICE.md)

## Observações finais

Este projeto foi organizado para manter uma base comum e separar as variações por plataforma. Isso reduz duplicação, facilita manutenção e torna a portabilidade entre versões e loaders muito mais controlada.

A arquitetura favorece:

- reutilização do código principal
- isolamento de diferenças de API
- compatibilidade por alvo
- análise de performance e renderização
- documentação gerada e validação contínua
=======
# NVVision Boost
Oi, pessoal, aqui é o Cutjjen. Tudo bem?
Estou passando aqui para falar um pouco sobre esse projeto. A ideia real dele surgiu do nada: eu queria otimizar o meu Minecraft ao máximo possível, para que funcionasse com vários mods e shaders extremamente pesados. Funcionou até, porém, como podem ver ali no código, sou um desastre na programação. Não sou nada além de um usuário de IA.

Eu vou estudar de verdade para, no futuro, entregar outro projeto que mude o rumo das coisas. Vou me esforçar muito. Então, aqueles que tiverem interesse em criar um mod de otimização, o código está ali: fiquem à vontade para melhorar, desenvolver e criar seu próprio mod de otimização.

Falo isso não só por mim, mas por todos que desejam o mesmo: um jogo mais leve e com uma taxa de quadros maior, para se divertir mais. Conheço várias pessoas que gostariam de jogar Minecraft sem ter que fazer otimizações mirabolantes no computador para poder funcionar.

Quem estiver lendo isso, obrigado por ter chegado até aqui e divirta-se com o pouco que consegui desenvolver nesse código. No futuro, certamente voltarei melhor e com ideias absurdas de melhorias, hahaha.

![NVVision Boost](./NvvisionBoost.png)

## Sobre

**NVVision Boost** é um mod de otimização do cliente Minecraft e um addon de controles avançados de CPU.

### Funcionalidades

- 🚀 **Otimização de Cliente**: Melhora o desempenho e reduz o consumo de recursos
- ⚙️ **Controles de CPU**: Gerenciamento inteligente de processamento
- 🎮 **Compatível**: Suporta Forge, Fabric, e NeoForge
- 🔧 **Personalizável**: Configuração flexível de opções

### Características Técnicas

O mod oferece políticas de desempenho, renderização otimizada, integrações com componentes, e interface de configuração intuitiva. O código é estruturado em adapters que ligam a funcionalidade ao ciclo de vida de cada loader e às APIs de cada versão do Minecraft.

---

**Desenvolvido por Cutjjen**

Licença: [MIT](./LICENSE)

>>>>>>> origin/master

