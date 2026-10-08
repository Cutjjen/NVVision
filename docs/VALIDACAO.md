# Validação desta revisão

## Alterações revisadas

- Formatação com google-java-format 1.37.0, compatível com o JDK usado para manutenção.
- Remoção de um callback de mixin sem operação e de campos privados sem uso confirmado.
- Controlador de CPU compartilhado entre sete destinos; diferença do enum de partículas isolada em adapters.
- Consolidação de arquivos realmente idênticos por SHA-256, componente e caminho de destino: 443 fontes físicas ativas reduzidas a 319 por consolidação e a 316 após excluir três fontes inativas de bootstrap. Fontes históricas preservadas fora do build.
- Perfil de CPU nulo ou inválido deixa controles desligados; a configuração corrompida não causa aplicação parcial nem é sobrescrita.
- Restauração das opções temporárias antes do encerramento, respeitando alterações externas.
- Gradle Wrapper 9.5.1 com checksum oficial do wrapper e da distribuição; plugins ModDevGradle e Loom por plataforma.

## Evidências e limites

A rodada anterior à consolidação do controlador passou nas 14 compilações, sete conjuntos de regressão e 56 verificações de artefatos. A rodada final do controlador compartilhado também passou nas 14 compilações, sete conjuntos de regressão e 56 verificações de artefatos. Uma recompilação adicional usa diretórios novos de classes para impedir sobras de builds anteriores. Os testes incluem layout, localização, configuração, propriedade das opções e passes OpenGL em contexto isolado.

O teste isolado de aplicação do controlador passou em 15 verificações, incluindo mudanças sem tick ou reinício, agendamento na thread do cliente e respeito a alterações do usuário. Um processo separado validou configuração malformada e preservação do arquivo original. Outro teste confirmou restauração, gravação, idempotência e respeito a mudanças externas no encerramento.

A verificação Gradle das 794 referências de fonte e os 24 testes da política de CPU passaram. A preparação completa do Minecraft por ModDevGradle/Loom encontrou `AccessDeniedException` nos arquivos de cache neste ambiente. Portanto a migração Gradle completa não está declarada como validada. A compilação do módulo isolado de testes do controlador pelo Gradle encontrou o mesmo bloqueio de acesso ao JAR de SLF4J no cache; seus três testes passaram com o compilador Java usado pelo projeto. Os artefatos distribuídos foram produzidos pelo compilador e remapeador já usados no projeto, e não devem ser atribuídos a uma compilação Gradle concluída.

Não foi realizado um novo teste de mundo/modpack nem medição comparativa de FPS nesta revisão. Os testes automatizados não comprovam compatibilidade universal. O índice de funções documenta navegação e contratos existentes; não equivale a revisão semântica individual de todas as funções.




## Paired release 0.8.16

Thirteen official loader/Minecraft targets and 26 production JARs were compiled and validated. Exact files and SHA-256 hashes are recorded in verification/DELIVERY-0.8.16.json. Artifact names include the component, numeric version, loader and Minecraft version.

Gradle checkSources, checkRendererAdapters, generateFunctionIndex and generateSourceMap passed: 1,618 source bindings, 13 adapter contracts and 3,274 indexed functions in 359 registered Java files. Applicable policy/UI/OpenGL/Java 8 tests and production Minecraft references passed. The full all-platform Gradle build still encounters the recorded Fabric Loom client-jar cache/ZipFS limitation in this environment; delivery uses the validated compilation and production-remapping workflow.

In-world visual checks and FPS measurements remain pending. Forge 1.12.2 has explicit native-rendering capability limits. See PORTS-0.8.16.md and each pair's VALIDACAO.json.

## Fabric 1.20.1 — GUI mapping correction 0.8.18

Independent official-client-to-Tiny fixture: 37 mixin selector checks, 615 Minecraft links, 2654 inherited project calls, 8 mixin superclasses. Previous 0.8.17 fails the OptionsScreen b() selector, reproducing the startup log. Automated GL/UI/CPU/bridge tests passed. Full game validation pending. Fabric 1.19.2 0.8.18 was reported functional by the user.

## Fabric 1.21.1 — GUI mapping correction 0.8.18

Independent official-client-to-Tiny fixture: See verification/FABRIC1211-GUI-FIX-0.8.18.json for exact check counts. Previous 0.8.17 fails the OptionsScreen aT_() selector, reproducing the startup log. Automated GL/UI/CPU/bridge tests passed. Full game validation pending. Fabric 1.19.2 0.8.18 was reported functional by the user.
