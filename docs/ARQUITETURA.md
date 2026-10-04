# Arquitetura

1. **Núcleo compartilhado:** configuração, perfis de hardware, regras de desempenho, localização, políticas de segurança e propriedade de opções. Fontes idênticas são reutilizadas via registro.
2. **PlatformAdapter:** liga detecção de mods, diretórios e ambiente cliente às APIs reais de Forge, Fabric ou NeoForge. O addon usa um pacote distinto para evitar classes duplicadas entre JARs.
3. **MinecraftVersionAdapter:** isola propriedade do framebuffer e avisos nativos da interface. As diferenças restantes de API, hooks de recarga e renderização ficam nos arquivos específicos registrados para cada alvo.
4. **Mixins/eventos:** são pontos de entrada específicos. Seus seletores, campos e descritores devem corresponder exatamente à versão real do Minecraft/loader. Não usar intervalos irrestritos para contornar incompatibilidades.
5. **Addon:** aplica opções visuais de CPU com propriedade e restauração controladas. A presença do addon é consultada localmente; não representa suporte a DLSS/Vulkan nativo.

Os grupos em `src/common` mantêm IDs estáveis da consolidação original. Consulte `INDICE-FONTES.md` pelo nome lógico da classe para localizar o arquivo e todas as versões afetadas. As pastas geradas em `build` são descartáveis; nunca editá-las como fonte principal.

Uma atualização simples pode ficar restrita ao registro e adaptadores. Mudanças grandes na API do jogo podem exigir novos limites no contrato ou alterações no núcleo.
