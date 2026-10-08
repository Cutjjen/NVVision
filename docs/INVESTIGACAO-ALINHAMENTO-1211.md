# Alinhamento do upscaling no NeoForge 1.21.1

## Evidências recebidas

O teste do usuário reproduziu duas luas e texturas/partículas deslocadas na versão
0.8.7, com escala de 85%. Com o mesmo shader em 100%, a duplicação desaparece.
O defeito foi relatado somente na linha 1.21.1 e permanece com o shader do Iris
desligado, segundo o teste do usuário. Isso localiza o problema no caminho de
renderização reduzida dessa combinação, mas não identifica sozinho o passe responsável.
Não é correto atribuir a causa somente à composição do BSL ou ao Iris ativo.

## Conjunto inspecionado

- Minecraft 1.21.1, NeoForge, NVVision e addon 0.8.7.
- Sodium 0.8.13+mc1.21.1.
- Iris 1.8.14-beta.1+mc1.21.1.
- Sodium Extra 0.9.4+mc1.21.1.
- Colorwheel 1.3.0-beta3 e Colorwheel Patcher 1.0.5.
- Shader BSL v10.1.1 com patch Clrwl 1.0.5.

Os dados foram obtidos dos logs e dos arquivos reais da instância, sem modificar
mods, mundo ou configurações do usuário.

## Compatibilidade declarada e comportamento observado

O manifesto do Sodium Extra exige Sodium a partir de 0.8.13+mc1.21.1; o arquivo
presente satisfaz esse requisito. O Sodium declara Minecraft 1.21.1. A opção
Panini do Sodium Extra estava desligada. Seu mixin de sol/lua troca a textura
conforme a opção selecionada; o trecho inspecionado não duplica a chamada de desenho.
Isso não exclui outras interações entre os mods.

O manifesto do Iris presente declara Minecraft `[1.21,1.21.1)`, uma faixa que
exclui 1.21.1, apesar do nome do arquivo. É uma inconsistência a verificar na
distribuição dessa build; não é prova de que ela causa o defeito visual. O jogo
carregou o Iris nessa sessão. Nenhum arquivo de terceiro foi alterado.

O log antigo `Mundo: 1920x1009 | Shaders: 1632x858` foi registrado depois de devolver
os attachments nativos. Portanto, não demonstrava que o mundo foi desenhado em
1920x1009. A observação foi movida para antes dessa devolução.

## Versão 0.8.8: diagnóstico limitado

O upscaling continua disponível, inclusive na 1.21.1. As outras linhas não foram
alteradas nesta investigação. Não foi adicionada uma desativação automática.

O log `[NVVB Alinhamento]` registra somente três frames após a criação do target:
início do mundo, fim do mundo antes do upscale e fim do upscale. Registra viewport,
framebuffer de desenho, textura de cor anexada e tamanho real dessa textura em
OpenGL 4.5, além das identidades e dimensões dos dois targets. As consultas não
trocam bindings nem leem pixels. Não há glFinish, captura contínua ou medição de FPS.

O log `[NVVB Compatibilidade render]` registra as versões carregadas de Sodium,
Iris, Sodium Extra e Colorwheel para que testes futuros possam ser comparados.

## Próxima validação no mundo

Comparar, no mesmo lugar e olhando na mesma direção:

1. Shader atual, escala 100% e depois 85%.
2. Escala 85% com shader desligado, capturando agora as novas medições (o usuário
   já confirmou que o defeito continua nessa condição).
3. Escala 85% com BSL original, sem o patch Clrwl, quando disponível.
4. Em uma cópia da instância, repetir sem Sodium Extra para separar sua participação.

Não remover Colorwheel de um mundo existente nem concluir que outro mod é culpado
sem comparar o resultado. O defeito visual permanece sem correção confirmada.
Os testes automatizados de filtros, targets e mixins não substituem essa validação.
