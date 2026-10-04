# Atualizações e mods

Esta pasta é a área dedicada para controlar versões, builds e arquivos de distribuição do projeto.

## Estrutura

- `mods/` — arquivos `.jar`, mods compilados e dependências distribuídas
- `releases/` — notas, changelog e registros de versões publicadas
- `history/` — histórico de versões antigas, se necessário

## Fluxo recomendado

1. Coloque cada build em `updates/mods/`
2. Nomeie o arquivo com a versão e o loader, por exemplo:
   - `nvvision-1.1.0-forge-1.20.1.jar`
   - `nvvision-1.1.0-fabric-1.21.1.jar`
3. Registre a mudança em `updates/releases/` ou em um changelog da versão
4. Atualize a documentação principal do projeto quando houver nova release

## Regras

- manter uma pasta por versão ajuda a controlar o histórico
- não misturar fontes de desenvolvimento com artefatos prontos
- usar nomes consistentes para facilitar a distribuição

## Uso responsável

Os arquivos aqui podem ser compartilhados, testados e reutilizados conforme a licença do projeto. Sempre respeite os requisitos dos loaders, versões do Minecraft e dependências oficiais.
