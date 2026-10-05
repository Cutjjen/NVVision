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

