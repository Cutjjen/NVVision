# NVVision Boost

Latest hardware-control port: [0.8.27 adapters and verification](docs/HARDWARE-ADAPTERS-0.8.27.md).

Technical source documentation: [execution stages](docs/EXECUTION-STAGES.md), [architecture](docs/ARCHITECTURE.md), [source map](docs/SOURCE-MAP.md), [function index](docs/FUNCOES.md), [refinement 0.8.22](docs/REFINEMENT-0.8.22.md).

<div align="left">
  <a href="#nvvision-boost">README</a>
  <a href="./LICENSE">MIT license</a>
  <a href="./Exportacao-TXT/NVVision-Codigo-Completo-0.8.23.txt">NVVision-Codigo-Completo-0.8.23.txt</a>
  <a href="./Exportacao-TXT/NVVision-Estrutura-0.8.23.txt">NVVision-Estrutura-0.8.23.txt</a>
  <a href="./Exportacao-TXT/NVVision-Manifesto-Fontes-0.8.23.txt">NVVision-Manifesto-Fontes-0.8.23.txt</a>
</div>

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

## Estrutura do projeto

Este repositório reúne o código completo do mod, incluindo:

- a lógica principal em `source/modules/mod`
- os ajustes de CPU e addon em `source/modules/addon`
- os adaptadores por loader e versão em `source/adapters`
- as configurações de build em `config/` e `gradle/`
- a documentação técnica em `docs/`
- os artefatos finais em `targets/` e `Modloaders/`

A arquitetura foi organizada para permitir um único código-base servir vários loaders e versões do Minecraft, mantendo as diferenças específicas de cada plataforma em adapters isolados.

## O que cada parte faz

### `source/modules/mod`
Responsável pela base compartilhada do mod: interface, políticas de renderização, integração com o cliente e configurações gerais.

### `source/modules/addon`
Contém a lógica do addon de CPU, incluindo limites visuais, otimização de desempenho e ajustes complementares do cliente.

### `source/adapters`
Cuida das diferenças específicas entre Fabric, Forge e NeoForge, além das variações de API entre versões do Minecraft.

### `config/`
Registra fontes, compatibilidade e políticas de release, funcionando como mapa de configuração do projeto.

### `docs/`
Armazena a documentação técnica, arquitetura e valiações do projeto.

### `targets/` e `Modloaders/`
Guardam os alvos de build e os artefatos prontos para cada loader e versão suportada.

### `tools/` e `verification/`
Contêm utilitários de geração, validação e acompanhamento da compatibilidade.

### Características Técnicas

O mod oferece políticas de desempenho, renderização otimizada, integrações com componentes e interface de configuração intuitiva. O código é estruturado em adapters que ligam a funcionalidade ao ciclo de vida de cada loader e às APIs de cada versão do Minecraft.

---

**Desenvolvido por Cutjjen**

Licença: [MIT](./LICENSE)

## Guias de exportação TXT

A pasta [Exportacao-TXT](./Exportacao-TXT) reúne os arquivos brutos exportados do projeto para consulta e publicação. Todos seguem a licença padrão do projeto, em conformidade com o MIT.

### Arquivos disponíveis

1. [NVVision-Codigo-Completo-0.8.23.txt](./Exportacao-TXT/NVVision-Codigo-Completo-0.8.23.txt)  
   Guia completa do código-fonte exportado em uma única referência.

2. [NVVision-Estrutura-0.8.23.txt](./Exportacao-TXT/NVVision-Estrutura-0.8.23.txt)  
   Estrutura de diretórios, módulos e organização do projeto.

3. [NVVision-Manifesto-Fontes-0.8.23.txt](./Exportacao-TXT/NVVision-Manifesto-Fontes-0.8.23.txt)  
   Relatório dos arquivos e metadados usados para consolidar a base de fontes.

Consulte também a [guia detalhada da pasta de exportação](./Exportacao-TXT/README.md).


## Accessor compatibility patch 0.8.17

Five targets sharing the legacy RenderTarget accessor now use a pure accessor Mixin and the reusable framebuffer-attachments adapter. See docs/FRAMEBUFFER-ACCESSOR-ADAPTER.md and Modloaders/LEIA-ME.md. Other maintained pairs remain unchanged at 0.8.16. Automated regression and production linkage checks passed; full game startup and in-world validation are pending.

Latest targeted fix: [Fabric 1.19.2 / 0.8.23](docs/FABRIC-1192-0.8.23.md). Other loader targets retain 0.8.22.

Opt-in test release: [Forge 1.20.1 CPU budgets / 0.8.24](docs/FORGE-1201-CPU-TEST-0.8.24.md). Published stable versions remain in Modloaders/ATUAIS.json; test builds are listed separately in Modloaders/TESTES.json.

Opt-in test release: [Forge 1.20.1 CPU budgets / 0.8.25](docs/FORGE-1201-CPU-TEST-0.8.25.md). Published stable versions remain in Modloaders/ATUAIS.json; test builds are listed separately in Modloaders/TESTES.json.
