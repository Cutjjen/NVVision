# Contribuições

O projeto é criado e mantido por Cutjjen. Preserve o objetivo de otimização visual local e as preferências existentes.

Antes de alterar uma fonte compartilhada, consulte docs/INDICE-FONTES.md para identificar todos os alvos afetados. Edite a fonte canônica, nunca build/generated. Documente o gatilho do problema, a alteração, o alvo e os testes realizados.

Atualize os hashes revisados em config/sources.json e rode scripts/Validate.ps1. Configure dependências locais, compile e execute os testes do alvo. Para mudanças em fontes comuns, amplie a validação a todos os alvos afetados. Teste manualmente reload de recursos, troca de shaders, entrada/saída do mundo e resolução da interface quando houver alteração gráfica.

Não introduzir canais de rede ou exigência de instalação remota para os controles locais. Não ativar tecnologias indisponíveis nem declarar ganhos de FPS sem comparação medida. Preserve avisos e licenças de terceiros.
