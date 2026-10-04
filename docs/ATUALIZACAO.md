# Atualização por versão

1. Escolha o alvo mais próximo e registre uma nova chave em `config/versions.json`; configure Java, versões do mod/addon e modo de remapeamento.
2. Reutilize arquivos compatíveis de `src/common` por meio de `config/sources.json`. Coloque alterações de API em `src/adapters` e ajuste o registro do novo alvo.
3. Atualize contratos/implementações de loader e Minecraft somente onde a API mudou. Preserve as configurações, IDs públicos e comportamento cliente.
4. Confirme os metadados: jogo exato, loader mínimo correto, dependências e authors=Cutjjen. NeoForge 1.21.1 exige as declarações javafml/loaderVersion antigas.
5. Confira seletores de mixins e métodos herdados contra os JARs reais. Para Fabric, mantenha refmaps separados para mod e addon; valide Shadows após remapear.
6. Compile e teste recarga de recursos, mudanças de shader, resolução nativa/reduzida, interface, saída do mundo e restauração de opções.
7. Atualize o SHA-256 dos arquivos alterados no registro. Registre os resultados e publique somente os artefatos correspondentes ao alvo.

Não transformar um JAR de outra versão em port editando somente seus metadados. Não declarar compatibilidade universal nem ganho de FPS sem medição comparável.
