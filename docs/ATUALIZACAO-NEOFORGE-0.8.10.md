# NeoForge 1.21.1 — NVVision e addon 0.8.10

Autoria Cutjjen. Correção do limite do adapter de pixels da 0.8.9.

Nos testes ATM10 com 0.8.9, o diagnóstico fim-upscale mostrou framebuffer principal nativo 1920x1009, mas viewport 1728x908 a 90% e 1632x858 a 85%. O adapter interceptava a saída final porque worldPassActive só era desligado no finally e o mesmo objeto principal já havia recuperado os attachments nativos. Portanto a identidade do objeto e a ligação do framebuffer não bastavam para distinguir o passe reduzido.

A 0.8.10 encerra worldPassActive logo após restaurar o empréstimo dos attachments, antes do upscale final. O adapter exige também dimensões do alvo iguais às dimensões reduzidas. Assim o passe final, os uniformes da saída e a interface permanecem nativos.

Um teste OpenGL de regressão verifica quatro situações: alvo reduzido ligado; mesmo objeto com dimensões nativas restauradas; mundo encerrado; outro framebuffer ligado. Isso detecta o erro específico observado na 0.8.9, mas não substitui o reteste visual do modpack.

Os logs recebidos confirmam descoberta de Sodium Extra, Panini=false, controles CPU aplicados e shaders alternados. Não foram encontradas mensagens GL_INVALID/OpenGL debug nessa sessão. Houve pressão de heap (6984–7006 MiB de 8200 MiB) e pausas de GC que podem contribuir para travamentos momentâneos, sem comprovar a causa dos deslocamentos. Outros erros de configs e recursos do modpack não foram atribuídos ao NVVision.

No próximo teste, fim-upscale deve registrar viewport 1920x1009 com saída 1920x1009, enquanto inicio-mundo deve registrar o tamanho reduzido. Upscaling mantido. Nenhum ganho de FPS medido; defeito visual original ainda depende de confirmação.
