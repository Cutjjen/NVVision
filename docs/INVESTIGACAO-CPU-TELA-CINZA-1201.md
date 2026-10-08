# Forge 1.20.1: tela cinza após mudar o preset de CPU

Relato de 4 de outubro de 2026: o mundo ficou cinza após mudar o preset de CPU;
a recarga dos shaders recuperou a imagem.

O log enviado reúne sessões antigas. A última inicialização registrada é 0.7.18,
com Oculus ativo, shader Complementary e escala interna de 35% (672x353 para
uma saída 1920x1009). Não há registro do instante exato da troca do preset nem
uma exceção que identifique sua causa. O log não permite confirmar qual versão
do addon estava instalada nessa sessão.

O conjunto atual neste projeto é NVVision e addon 0.7.21. Foram conferidos os
checksums dos dois arquivos publicados. Os testes automatizados de CPU, OpenGL
e mixins dessa build passaram; o incidente relatado não foi reproduzido no jogo.

No código atual, o botão chama BridgeApi.requestCpuProfile, que encaminha para
BridgeCpuOptimizer.request. O runtime salva a escolha, aplica o orçamento visual
de entidades e partículas na thread do cliente e registra os valores efetivos.
Esse caminho não chama reset do renderer, resize de targets, recarga de shaders
ou alteração de escala. Na implementação vanilla 1.20.1 inspecionada, o callback
da opção de partículas é vazio; callbacks adicionados por terceiros não foram
validados em uma execução real do modpack.

## Atualização: latest.log da sessão 19:46–19:56

O novo log confirma mod e addon 0.7.21 carregados. Portanto, a indicação anterior
de testar a build atual não descarta este incidente. O arquivo nvvisionboost.log
enviado anteriormente continha inicializações históricas; não era suficiente
para determinar a versão efetivamente carregada nessa sessão.

Às 19:48:56–19:49:01, o logger NVVisionCPU confirma aplicação dos perfis balanced,
economy e custom, com distâncias 0.75/0.5 e partículas 1/2. A aplicação de opções
funciona; isso não demonstra que ela seja independente de efeitos adicionados
por outros mods ao renderizador.

A partir de 19:49:25, após mensagens de alteração do shader Complementary com
EuphoriaPatches e avisos GLSL, aparecem 19.149 mensagens de `program texture usage`
inválido ao longo da sessão. Há também referências inválidas a programas/shaders
e nomes de texturas. A quantidade foi contada no arquivo enviado, não por medição
de chamadas de desenho. Essas mensagens demonstram uma falha real de estado de
renderização; não identificam qual mod ou chamada iniciou o problema.

Às 19:52:54, o usuário muda para Complementary original e o pipeline é preparado
novamente. Ainda há um erro de textura inválida às 19:53:30. O encerramento final
salva os mundos normalmente, sem evidência de crash nessa sessão.

Próxima comparação: repetir a troca dos presets com os dois arquivos 0.7.21,
mantendo shader, mundo e escala; se ocorrer novamente, comparar em 100% e coletar
latest.log além do nvvisionboost.log. O primeiro contém os registros do logger
NVVisionCPU. Não declarar o defeito corrigido apenas por usar uma versão posterior.

## Reteste terror — Forge 0.7.22, 04/10/2026, 20:15–20:20

Fontes: latest.log e nvvisionboost.log da instância terror. Mod e addon 0.7.22 reconhecidos. Embeddium/Oculus e ComplementaryReimagined_r5.9.3.zip.

20:18:58 perfil CPU off: distância de entidades 1.0, partículas 1. Às 20:18:59 perfil balanced: distância 0.75, partículas continuam 1. Nenhum erro OpenGL registrado naquele instante. O runtime CPU e os callbacks da interface alteram opções nativas, sem chamar OpenGL, resize, recarga de shaders ou reset do renderer. Isso não descarta uma interação indireta com outros mods; não há evidência suficiente para culpar o addon.

O renderer já usava 35% antes da troca de perfil, depois foram testados 25%, 10%, 100%, 90%, 85%, 80% e 75%. Os logs de dimensões indicam a base reduzida do Oculus, mas não validam todos os passes intermediários nem a imagem.

Às 20:19:36 há 16 mensagens OpenGL de programas/shaders inválidos junto à desativação dos shaders por Oculus. Na reativação aparecem Unknown variable BIOME_PALE_GARDEN, BIOME_SULFUR_CAVES e endFlashIntensity dentro da construção de uniforms do Oculus. Esses erros mostram incompatibilidade de expressões do shaderpack com o backend disponível; o log não comprova que expliquem a tela cinza ou os deslocamentos.

O gate da 0.7.22 aguarda pipeline estável, mas não resolve automaticamente erros durante a destruição interna do pipeline. Nenhuma correção visual definitiva confirmada por este reteste. Não alterar automaticamente opções do shaderpack ou remover recursos CPU sem evidência.

Próximo isolamento: manter mesma cena e shader, testar escala 100% com CPU off/balanced, depois 85% com CPU off/balanced. Se possível comparar uma inicialização sem addon, preservando configs. Precisamos distinguir tela cinza de partículas/texturas deslocadas e anotar o momento da falha para correlacionar logs.
