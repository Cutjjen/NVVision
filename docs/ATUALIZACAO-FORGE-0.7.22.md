# NVVision e addon 0.7.22 — Forge 1.20.1

## Correções

O renderer iniciava o passe reduzido sem verificar se o pipeline selecionado do
Oculus ainda existia e estava estável. O latest.log enviado mostra essa ausência
durante uma sequência de erros OpenGL de uso de texturas e programas inválidos.
A 0.7.22 mantém o passe nativo durante a ausência/substituição do pipeline e
retoma a redução após três frames consecutivos com a mesma instância ativa.
Não recarrega shaders automaticamente nem desativa o upscaling permanentemente.
A reanexação do depth nativo permanece disponível quando o pipeline já está ativo.

O identificador interno da build ainda era 0.7.18, embora o manifesto do JAR
declarasse 0.7.21. A versão interna, o manifesto e o addon agora indicam 0.7.22.
Isso também corrige a chave de atualização dos caches gerados. As configurações
do jogador são preservadas pela manutenção de caches existente.

Os presets de CPU continuam aplicando somente o orçamento visual de entidades e
partículas. Seu comportamento não foi alterado nesta correção. As outras linhas
do Minecraft não receberam alterações nesta entrega.

## Validação e limites

O teste de ciclo de vida cobre 13 verificações: ausência, criação, substituição,
desaparecimento durante recarga e retorno ao modo sem shaders. Os demais testes
de OpenGL, attachments, interface, CPU, mixins e referências de produção são
registrados em VALIDACAO.json.

Essa proteção corrige um caminho inseguro identificado no NVVision. Ela não
comprova que todos os erros OpenGL do modpack têm a mesma causa. A eliminação da
tela cinza ainda precisa ser confirmada repetindo a troca dos presets com o mesmo
shader e escala. Não foi feita medição de ganho de FPS nem validação visual no mundo.
