# Etapas de execução

## 01 — Descoberta pelo loader
Os metadados registram ID, autoria Cutjjen, versão, dependências e mixins. O entrypoint de cada plataforma evita inicialização gráfica no servidor e reserva a preparação gráfica para o contexto cliente.

## 02 — Configuração e atualização
O núcleo resolve os diretórios pelo PlatformAdapter, lê preferências e perfis, e faz manutenção somente dos caches próprios. A atualização preserva as escolhas do usuário.

## 03 — Detecção de ambiente
São detectados GPU, backend gráfico e mods integrados. Proteções para Create, Distant Horizons e outras integrações dependem da presença efetiva do mod. Não alterar arquivos/configurações de terceiros arbitrariamente.

## 04 — Interface
As telas exibem perfis, controles individuais e descrições. NVVisionBoostUi/Language cuidam de português/inglês e bandeiras; o adapter escolhe o aviso nativo apropriado. No 1.21.1, OptionsPlacement ocupa espaços livres e preserva os widgets do FancyMenu/Minecraft.

## 05 — Renderização do mundo
Mixins/eventos capturam os limites do passe do mundo. NativeRenderer controla framebuffer, escala e restauração de estado. HUD e menus devem permanecer na resolução nativa. O controlador dinâmico respeita as proteções do backend e as escolhas do usuário.

## 06 — Addon e controles de CPU
BridgeCpuOptimizer aplica opções permitidas. CpuOptionLease acompanha propriedade/restauração para não sobrescrever mudanças posteriores do jogador ou de outros componentes. Não há alterações na simulação remota do servidor.

## 07 — Recarga, saída do mundo e encerramento
Os hooks específicos de versão coordenam a recarga com Minecraft/Iris; os recursos próprios são invalidados/restaurados. O encerramento libera recursos e devolve opções sob controle do addon.

## 08 — Validação e publicação
Compilar, remapear quando necessário, conferir metadados, testar layout/idiomas/CPU/OpenGL e os seletores de mixins. Registrar separadamente testes automáticos, teste em mundo e medições de FPS.
