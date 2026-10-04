/* NVVision — criação e manutenção: Cutjjen.
 * Etapa: Inicialização, configuração ou serviços do núcleo.
 * Arquivo lógico: main/java/nvvisionboost/NVVisionBoostLogger.java. Veja docs/FLUXO.md e docs/INDICE-FONTES.md.
 * Avisos e licenças existentes abaixo permanecem preservados.
 */
package nvvisionboost;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NVVisionBoostLogger {
  private static final Logger LOGGER = LogManager.getLogger("NVVisionBoost");

  /** Registra uma ação que foi ativada com sucesso. */
  public static void logSuccess(String actionName) {
    LOGGER.info("[NVVisionBoost] [SUCESSO] Ação ativada com sucesso: {}", actionName);
  }

  /** Registra uma tentativa de ativação que falhou ou não funcionou (ex: incompatibilidade). */
  public static void logFailure(String actionName, String reason) {
    LOGGER.warn(
        "[NVVisionBoost] [FALHA/TENTATIVA] A ação '{}' não pôde ser ativada. Motivo: {}",
        actionName,
        reason);
  }

  /** Registra erros críticos ocorridos durante a execução. */
  public static void logError(String actionName, Throwable throwable) {
    LOGGER.error("[NVVisionBoost] [ERRO] Ocorreu um erro crítico em: " + actionName, throwable);
  }
}

