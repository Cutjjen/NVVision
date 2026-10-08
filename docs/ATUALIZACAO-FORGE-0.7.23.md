# Forge 1.20.1 — mod e addon 0.7.23

Cutjjen. Correção da coordenação entre controles CPU e renderer.

O usuário confirmou: trocar o preset CPU provoca tela cinza; desligar e ligar shaders recupera a imagem. Esse gatilho é aceito como resultado do teste, embora o log não identifique a chamada gráfica responsável.

Os controles salvam e mostram a escolha imediatamente, mas agora aplicam as opções no próximo tick do cliente, fora do callback de tela. O addon avisa o renderer principal por uma API opcional; o início do próximo frame restaura os alvos auxiliares nativos e reinicia o gate de estabilização antes de retomar o upscaling. O shaderpack não é recompilado automaticamente. A integração é específica da base Forge 1.20.1; outras linhas não foram alteradas nesta atualização.

Registro esperado: [NVVB CPU] Opções aplicadas no tick; transição nativa do pipeline. Perfis CPU mantêm opções independentes e reversíveis.

Compilação, remapeamento Forge, verificações de referências/mixins e testes automatizados acompanham VALIDACAO.json. Esses testes não reproduzem a instância terror inteira; a eliminação da tela cinza precisa ser confirmada ao trocar os presets no mundo.
