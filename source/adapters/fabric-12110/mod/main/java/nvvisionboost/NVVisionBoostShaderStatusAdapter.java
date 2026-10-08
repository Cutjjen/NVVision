package nvvisionboost;

/** Distinguishes backend availability, configured selection and the actual live shader pipeline. */
final class NVVisionBoostShaderStatusAdapter {
  private NVVisionBoostShaderStatusAdapter() {}

  static String describe(boolean backend, boolean enabled, boolean active) {
    if (backend && active) return "Iris com shaders ativos; passe disponível.";
    if (backend && enabled) return "Iris habilitado; aguardando pipeline de shaders ativo.";
    return "OpenGL sem shaders; passe disponível.";
  }
}
