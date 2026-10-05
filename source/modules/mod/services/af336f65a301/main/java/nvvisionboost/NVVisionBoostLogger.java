package nvvisionboost;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NVVisionBoostLogger {
  private static final Logger LOGGER = LogManager.getLogger("NVVisionBoost");

  /** Log a successfully activated action. */
  public static void logSuccess(String actionName) {
    LOGGER.info("[NVVisionBoost] [SUCESSO] Ação ativada com sucesso: {}", actionName);
  }

  /** Log an unsuccessful activation attempt, including incompatibility. */
  public static void logFailure(String actionName, String reason) {
    LOGGER.warn(
        "[NVVisionBoost] [FALHA/TENTATIVA] A ação '{}' não pôde ser ativada. Motivo: {}",
        actionName,
        reason);
  }

  /** Log critical runtime errors. */
  public static void logError(String actionName, Throwable throwable) {
    LOGGER.error("[NVVisionBoost] [ERRO] Ocorreu um erro crítico em: " + actionName, throwable);
  }
}
