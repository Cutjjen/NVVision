# Forge 1.20.1 — NVVision e addon 0.7.24

Cutjjen. Correção do caminho de redimensionamento do framebuffer.

Reteste terror da 0.7.23: o usuário informa tela cinza ao mudar a escala interna. O log registra trocas 75→67→50→35→25→35 e posterior recarga manual do shader. Há erros de programas OpenGL inválidos durante essa recarga; eles não identificam a chamada que originou a tela cinza.

A alocação do target preservava somente as texturas da unidade zero e da unidade ativa, restauradas por RenderSystem. Excluir/redimensionar as texturas pode desligar outras unidades; caches externos podem divergir do estado real. A 0.7.24 captura as ligações 2D de até 32 unidades suportadas antes da alocação, remapeia ligações dos antigos attachments para os novos e restaura pelo adapter que atualiza o driver e o cache rastreado do Minecraft. O custo dessas consultas ocorre na alocação, não em todo frame.

Reset de opções reinicia o gate de estabilização do pipeline, passando brevemente pela resolução nativa. A integração CPU da 0.7.23 é preservada; addon acompanha a versão. Upscaling não removido. Configs e shaderpack do usuário não alterados.

Compilação e testes automatizados não demonstram por si só a eliminação da tela cinza. Reteste necessário: alternar escalas com Oculus ativo e confirmar recuperação sem recarregar shader. Nenhum ganho de FPS medido.
