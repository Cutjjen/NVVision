# NVVision — Cutjjen

Mod de otimização do cliente e addon de controles de CPU. O código compartilhado contém políticas, configuração e interface; os adapters ligam esse código ao ciclo de vida de cada loader e às APIs de cada Minecraft.

Consulte `docs/VALIDACAO.md`: a migração Gradle completa ainda tem uma limitação de acesso ao cache neste ambiente. Os artefatos entregues usam o compilador e remapeador validados do projeto.

## Compilação

Use um JDK completo para executar o Gradle Wrapper. O Gradle seleciona as ferramentas Java de cada destino, sem caminhos pessoais no projeto.

```powershell
./gradlew.bat "-Ploader=forge" build
./gradlew.bat "-Ploader=neoforge" "-Pminecraft=1.21.1" build
./gradlew.bat "-Ploader=fabric" "-Pminecraft=26.2" build
```

As versões disponíveis e dependências ficam em `config/versions.json`. Somente combinações registradas são aceitas. O adapter facilita portas e manutenção; não transforma um artefato em um mod universal.

O plugin de cada plataforma prepara o Minecraft e gera o artefato correspondente. Forge exige a saída remapeada do plugin, nunca a saída de desenvolvimento. Fabric antigo usa Loom com remapeamento; as linhas sem ofuscação usam Loom sem esse passo. NeoForge usa ModDevGradle.

## Organização

- `source/modules/mod`: configuração, interface, renderização, integrações, políticas de desempenho e serviços.
- `source/modules/addon`: políticas de CPU, aplicação das opções e testes.
- `source/adapters`: pontos de entrada, eventos e diferenças das APIs de cada versão.
- `config/sources.json`: relação explícita entre fontes e destinos; fontes históricas não entram automaticamente na compilação.
- `gradle/target.gradle`: preparação comum, dependências, ferramentas Java e regras de empacotamento.
- `docs/FUNCOES.md`: índice de funções gerado pelo analisador sintático Java.

Os nomes de pastas com identificadores distinguem variantes preservadas de arquivos. Não representam módulos carregados em execução. Uma fonte compartilhada pode atender vários destinos sem duplicação física.

## Limites e preservação

O addon controla opções locais, restaura escolhas que possui e aplica mudanças na thread do cliente. Partículas de outros mods podem usar renderizadores próprios. Os callbacks vazios de fundo da interface impedem desfoque adicional e são necessários.

Não há DLSS nem geração de quadros implementados. Ganhos de FPS dependem da cena, dos mods e do hardware e precisam de medição no jogo. O build não altera instalações, mundos ou configurações do jogador.


