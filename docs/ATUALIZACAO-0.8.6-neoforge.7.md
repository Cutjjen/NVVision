# NeoForge 1.21.1 — correção do passe reduzido

Conjunto: NVVision 0.8.6-neoforge.7 + addon 0.2.5-neoforge.6. Autoria: Cutjjen.

Os logs enviados mostram resolução interna de 672×353 e saída de 1920×1009, com Iris instalado e shader inativo. O sintoma visual não aparece como exceção nesses logs.

## Correções

O renderer substituía a referência ao framebuffer principal durante o mundo. Referências ao objeto anterior, conservadas por outro renderer, podiam continuar usando dimensões e attachments nativos. Agora a identidade do objeto principal permanece constante: dimensões, FBO, texturas, filtro e stencil são emprestados como um conjunto e restaurados depois do mundo. Uma recriação dos attachments feita por um mod no passe reduzido permanece pertencendo ao alvo interno após a restauração.

O upscale anterior transferia somente cor. Agora também transfere profundidade e stencil, quando compatível, com filtragem NEAREST. Isso permite que passes posteriores comparem sua geometria à profundidade do mundo recém-renderizado em resolução nativa. A cópia preserva bindings de FBO e o estado de scissor. Targets multisample não seguem esse caminho reduzido.

## Validação

- 66 verificações de identidade, propriedade dos attachments, restauração e profundidade/stencil alinhados, em OpenGL real com janela invisível, nas escalas 85%, 75%, 50%, 35%, 25% e 10%.
- 102 verificações OpenGL anteriores aprovadas.
- Layout, posicionamento do botão e 385 verificações de idioma aprovados.
- Mod e addon compilados para Java 21; 21 verificações dos seletores, accessors e chamadas de mixins aprovadas contra as classes do NeoForge 21.1.251.

Não foi reproduzida a cena do ATM10 dentro do Minecraft nesta revisão. As correções tratam problemas concretos do passe; ainda é necessário confirmar no modpack se existe algum renderer adicional com buffers próprios ou callbacks fora desse passe. Não houve medição comparativa de FPS.

## Entrega

Use os dois artefatos da pasta `Modloaders/NeoForge/1.21.1/NVVision-0.8.6-neoforge.7-Addon-0.2.5-neoforge.6`. As versões anteriores permanecem em suas pastas. Não instale simultaneamente duas versões do mesmo mod ou addon.
