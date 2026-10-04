# NVVision

NVVision é um projeto de otimização visual para Minecraft, com suporte a diferentes loaders e versões. O foco é melhorar a experiência gráfica e o desempenho do cliente, mantendo o uso simples e responsável.

## Licença

Este projeto está disponível sob a licença MIT. Você pode usar, copiar, modificar, distribuir e adaptar o código, desde que mantenha o aviso de licença e a atribuição adequada. O uso deve ser responsável e respeitar as regras dos modpacks, servidores e plataformas envolvidas.

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
- [Atualizações e mods](updates/README.md)
- [Releases](releases/README.md)
- [Licença e uso responsável](COPYRIGHT.md)

`src/common` contém fontes compartilhadas. `src/adapters` contém diferenças de versão e loader. O registro `config/sources.json` materializa a combinação correta, sem manter cópias editáveis divergentes. `config/versions.json` registra versões de Java e dos artefatos.
