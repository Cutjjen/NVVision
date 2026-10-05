package nvvisionboost;

import java.util.*;

/** Schema verified for FerriteCore Forge 6.0.0/6.0.1; do not alter active mixins. */
public final class NVVisionBoostFerriteOptions {
  public record Option(String key, String label, String help, boolean initial, String dependency) {}

  public static final List<Option> ALL =
      List.of(
          new Option(
              "replaceNeighborLookup",
              "Tabela de estados",
              "Substitui a tabela de vizinhos dos estados por uma estrutura menor.",
              true,
              null),
          new Option(
              "replacePropertyMap",
              "Mapa de propriedades",
              "Compartilha propriedades. Exige a tabela de estados otimizada.",
              true,
              "replaceNeighborLookup"),
          new Option(
              "cacheMultipartPredicates",
              "Cache de predicados",
              "Reutiliza predicados dos modelos multipartes.",
              true,
              null),
          new Option(
              "modelResourceLocations",
              "Nomes dos modelos",
              "Reduz alocações de strings para os modelos.",
              true,
              null),
          new Option(
              "multipartDeduplication",
              "Modelos multipartes",
              "Deduplica modelos. Exige o cache de predicados.",
              true,
              "cacheMultipartPredicates"),
          new Option(
              "blockstateCacheDeduplication",
              "Cache de estados",
              "Deduplica formas de colisão e dados de estados.",
              true,
              null),
          new Option(
              "bakedQuadDeduplication",
              "Vértices compartilhados",
              "Deduplica dados dos vértices dos modelos básicos.",
              true,
              null),
          new Option(
              "modelSides",
              "Faces dos modelos",
              "Usa estruturas menores para modelos simples.",
              true,
              null),
          new Option(
              "useSmallThreadingDetector",
              "Detector experimental",
              "EXPERIMENTAL: o autor relata crashes raros. Desligado em todos os presets.",
              false,
              null),
          new Option(
              "compactFastMap",
              "Mapa compacto",
              "Economiza mais RAM, mas pode aumentar o custo de CPU.",
              false,
              null),
          new Option(
              "populateNeighborTable",
              "Tabela vanilla compatível",
              "Ajuda mods que acessam a tabela vanilla diretamente; aumenta o uso de RAM.",
              false,
              null));

  public static Map<String, Boolean> preset(int preset) {
    Map<String, Boolean> values = new LinkedHashMap<>();
    for (Option o : ALL) values.put(o.key(), preset == 3 ? false : o.initial());
    if (preset == 1) values.put("populateNeighborTable", true);
    if (preset == 2) values.put("compactFastMap", true);
    return values;
  }

  public static void toggle(Map<String, Boolean> values, Option option) {
    boolean value = !values.get(option.key());
    values.put(option.key(), value);
    if (value && option.dependency() != null) values.put(option.dependency(), true);
    if (!value)
      for (Option o : ALL) if (option.key().equals(o.dependency())) values.put(o.key(), false);
  }

  public static void validate(Map<String, Boolean> values) {
    for (Option o : ALL) {
      if (values.get(o.key()) == null)
        throw new IllegalArgumentException("Opção ausente: " + o.key());
      if (values.get(o.key()) && o.dependency() != null && !values.get(o.dependency()))
        throw new IllegalArgumentException("Dependência: " + o.dependency());
    }
  }

  private NVVisionBoostFerriteOptions() {}
}
