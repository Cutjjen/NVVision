package nvvisionboost;

/** Shared, advisory UI text; never changes another optimizer's configuration. */
public final class NVVisionBoostCompatibilityNotice {
  public static final String MESSAGE =
      "Se houver perda de FPS ou conflito, teste desativar Persistent Mapping, quando disponível, e"
          + " opções avançadas de integração do Sodium, Embeddium ou outros otimizadores, uma por"
          + " vez. Compare o FPS no mesmo local e restaure as opções que não ajudarem. Não"
          + " desinstale as dependências do NVVision.";

  /** Short footer lines; the information button exposes the complete guidance. */
  public static String[] lines() {
    return new String[] {
      "Queda de FPS? Teste desativar",
      "Persistent Mapping (se disponível).",
      "Sodium/Embeddium e outros: veja 'i'."
    };
  }

  private NVVisionBoostCompatibilityNotice() {}
}
