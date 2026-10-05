package nvvisionboost;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NVVisionBoostLogger {
  private static final Logger LOGGER = LogManager.getLogger("NVVisionBoost");

<<<<<<< HEAD
  /** Log a successfully activated action. */
=======
  /** Registra uma ação que foi ativada com sucesso. */
>>>>>>> origin/master
  public static void logSuccess(String actionName) {
    LOGGER.info("[NVVisionBoost] [SUCESSO] Ação ativada com sucesso: {}", actionName);
  }

<<<<<<< HEAD
  /** Log an unsuccessful activation attempt, including incompatibility. */
=======
  /** Registra uma tentativa de ativação que falhou ou não funcionou (ex: incompatibilidade). */
>>>>>>> origin/master
  public static void logFailure(String actionName, String reason) {
    LOGGER.warn(
        "[NVVisionBoost] [FALHA/TENTATIVA] A ação '{}' não pôde ser ativada. Motivo: {}",
        actionName,
        reason);
  }

<<<<<<< HEAD
  /** Log critical runtime errors. */
=======
  /** Registra erros críticos ocorridos durante a execução. */
>>>>>>> origin/master
  public static void logError(String actionName, Throwable throwable) {
    LOGGER.error("[NVVisionBoost] [ERRO] Ocorreu um erro crítico em: " + actionName, throwable);
  }
}
