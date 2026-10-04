# NVVision — Cutjjen

Mod de otimização visual e addon de controles locais, criados e mantidos por **Cutjjen**. Mantém controles de CPU, qualidade gráfica, escala de renderização e integração com os renderizadores e shaders previstos para cada versão.

## Instalação

Baixe os JARs da Release correspondente ao seu Minecraft e loader. Instale somente o mod e addon da mesma pasta. As dependências são declaradas nos metadados de cada build; Sodium/Iris e Embeddium/Oculus precisam ser da versão e loader corretos. Acesse as configurações com **F8** ou pelo botão NVVision em Opções. Interface em português brasileiro ou inglês.

O funcionamento é local ao cliente: não exige que todos os jogadores instalem o mod/addon. Não há canais de rede próprios. DLSS, geração de quadros e tradução automática de OpenGL para Vulkan não estão implementados.

## Leitura do projeto

- [Versões e resultados registrados](docs/VERSOES.md)
- [Arquitetura e adaptadores](docs/ARQUITETURA.md)
- [Fluxo de execução e etapas](docs/FLUXO.md)
- [Índice de todos os arquivos](docs/INDICE-FONTES.md)
- [Compilação e dependências](docs/COMPILACAO.md)
- [Como atualizar uma versão](docs/ATUALIZACAO.md)
- [Como preparar uma publicação](docs/PUBLICACAO.md)
- [Autoria e licenças preservadas](COPYRIGHT.md)

`src/common` contém fontes compartilhadas. `src/adapters` contém diferenças de versão e loader. O registro `config/sources.json` materializa a combinação correta, sem manter cópias editáveis divergentes. `config/versions.json` registra versões de Java e dos artefatos.

Os testes automatizados não equivalem a validação em todos os modpacks nem comprovam ganho de FPS. A linha NeoForge 1.21.1 r2 foi confirmada pelo usuário. As referências históricas foram preservadas no projeto de origem.
