package nvvisionboost;

import java.util.Locale;

<<<<<<< HEAD
/** Describe potential hardware costs rather than measured FPS gains. */
=======
/** Descrições de custo potencial; não representam medições de FPS. */
>>>>>>> origin/master
public final class NVVisionBoostHelp {
  public static String help(String label, boolean reverse) {
    String value = label.toLowerCase(Locale.ROOT);
    String description;
    if (value.equals("nvvisionboost"))
      return text(
          "Abre as configurações do NVVision. Também pode ser acessado por F8. Sem impacto no"
              + " hardware.");
    if (value.equals("br"))
      return text(
          "Português (Brasil). Altera apenas o idioma do NVVision. Sem impacto no hardware.");
    if (value.equals("en"))
      return text(
          "Inglês (Estados Unidos). Altera apenas o idioma do NVVision. Sem impacto no hardware.");
    if (value.startsWith("● ") || value.startsWith("○ "))
      description =
          "Seleciona um pacote para análise. Use Preparar shader selecionado para o preparo; a"
              + " seleção e execução final continuam no Iris/Oculus. Clique direito seleciona o"
              + " pacote anterior.";
    else if (value.matches("(nvidia|amd|intel|rtx|gtx|radeon|geforce|arc).*"))
      description =
          "Seleciona uma predefinição de GPU para consulta. Use Aplicar para alterar os ajustes."
              + " Escolher na lista não muda sua placa de vídeo.";
    else if (value.matches(
        "gpu|shaders|visual|imagem|image|mundo|world|início|home|avançado|advanced|integrações|integrations"))
      description = "Navega pelo menu. Não altera o desempenho.";
    else if (value.equals("i")
        || value.contains("sobre as tecnologias")
        || value.contains("about the technologies")
        || value.contains("recursos da gpu")
        || value.contains("gpu features"))
      description =
          "Mostra informações da opção ou da GPU. Não altera a qualidade nem as configurações do"
              + " jogo.";
    else if (value.contains("import")
        || value.contains("export")
        || value.contains("pasta")
        || value.contains("folder")
        || value.contains("reanalis")
        || value.contains("reanalys"))
      description =
          "Abre, importa, exporta ou analisa o recurso indicado. Pode usar disco e CPU"
              + " temporariamente; não aumenta FPS por si só.";
    else if (value.matches(
        ".*(voltar|back|anterior|previous|próxima|next|↑|↓|início|home|avançado|advanced|integrações|integrations).*"))
      description = "Navega pelo menu. Não altera o desempenho.";
    else if (value.startsWith("cpu:"))
      description =
          "Perfil equilibrado: entidades até 75% e partículas reduzidas. Econômico: entidades até"
              + " 50% e partículas mínimas. Personalizado usa os controles abaixo; desativado"
              + " restaura os valores anteriores quando possível.";
    else if ((value.contains("partícul") || value.contains("particle"))
        && (value.contains("cpu") || value.contains("custom") || value.contains("personalizado")))
      description =
          "Escolhe a quantidade de partículas: desativado preserva o jogo; reduzidas diminui"
              + " efeitos; mínimas deixa menos partículas. CPU/GPU podem trabalhar menos em cenas"
              + " com muitos efeitos; não altera ticks.";
    else if ((value.contains("entidad") || value.contains("entit"))
        && (value.contains("cpu") || value.contains("custom") || value.contains("personalizado")))
      description =
          "Define um teto de distância para entidades: desativado preserva o jogo; 75% reduz pouco"
              + " e 50% reduz mais; valores inferiores não são aplicados. Não aumenta a distância"
              + " original.";
    else if (value.contains("cpu") || value.contains("entidad") || value.contains("entit"))
      description =
          "Controla a distância visual de entidades e os efeitos locais. Desativado preserva o"
              + " jogo; equilibrado reduz detalhes distantes; econômico reduz mais. Não muda"
              + " máquinas ou ticks do servidor.";
    else if (value.contains("ferrite")
        || value.contains("ram")
        || value.contains("heap")
        || value.contains("memória")
        || value.contains("memory"))
      description =
          "Controla a proteção de memória ou abre as opções do FerriteCore. Economia de RAM pode"
              + " aumentar o trabalho da CPU. Alterações do FerriteCore exigem reinício.";
    else if (value.contains("create"))
      description =
          "Reduz detalhes visuais do Create quando ele está instalado. Original preserva o visual;"
              + " perfis mais econômicos reduzem partículas e detalhes distantes. Não muda o"
              + " funcionamento das máquinas.";
    else if (value.contains("fsr")
        || value.contains("filtro")
        || value.contains("filter")
        || value.contains("nitidez")
        || value.contains("sharp"))
      description =
          "Escolhe a reconstrução da imagem. Linear tem menor custo; nitidez usa mais amostras;"
              + " bicúbico e FSR 1 fazem mais trabalho na GPU. Mais nitidez pode criar halos.";
    else if (value.contains("upscal")
        || value.contains("escala")
        || value.contains("scale")
        || value.contains("resolução")
        || value.contains("resolution"))
      description =
          "Controla a resolução interna. 100% preserva a imagem nativa; valores menores reduzem"
              + " pixels e carga da GPU, mas podem borrar detalhes. O modo dinâmico ajusta a escala"
              + " dentro dos limites escolhidos.";
    else if (value.contains("partícul")
        || value.contains("particle")
        || value.contains("chuva")
        || value.contains("rain"))
      description =
          "Reduz efeitos visuais. Desativado preserva os efeitos; níveis maiores reduzem a"
              + " quantidade ou distância de partículas. Não muda clima ou regras do mundo.";
    else if (value.contains("simula") || value.contains("simulation"))
      description =
          "Limita a área que recebe ticks no mundo local. Valores menores podem aliviar CPU, mas"
              + " reduzem o alcance da simulação. Servidores mantêm suas próprias regras; suspenso"
              + " com Create/Flywheel.";
    else if (value.contains("distância")
        || value.contains("distance")
        || value.contains("alcance")
        || value.contains("range"))
      description =
          "Controla o alcance de desenho ou carregamento. Valores menores reduzem trabalho e"
              + " detalhes distantes; valores maiores exigem mais CPU, GPU e memória. Proteções de"
              + " compatibilidade continuam ativas.";
    else if (value.contains("fps")
        || value.contains("segundo plano")
        || value.contains("background"))
      description =
          "Define uma meta ou limite de quadros. Limites menores reduzem trabalho de CPU e GPU;"
              + " metas maiores podem aumentar consumo. O limite em segundo plano atua somente com"
              + " a janela sem foco.";
    else if (value.contains("mipmap") || value.contains("textur") || value.contains("resource"))
      description =
          "Controla texturas e mipmaps. Níveis maiores suavizam texturas distantes e usam mais"
              + " memória da GPU. Aplicar recarrega recursos e pode causar uma pausa temporária;"
              + " importar adiciona o pacote escolhido.";
    else if (value.contains("shader")
        || value.contains("sombra")
        || value.contains("shadow")
        || value.contains("nuv")
        || value.contains("cloud")
        || value.contains("oclus")
        || value.contains("ambient"))
      description =
          "Controla qualidade visual ou preparação de shaders. Qualidade maior exige mais GPU;"
              + " reduzir sombras, nuvens e efeitos pode aliviar renderização. Preparar ou aplicar"
              + " pode causar uma pausa de recarga.";
    else if (value.contains("câmera")
        || value.contains("camera")
        || value.contains("balanço")
        || value.contains("bob"))
      description =
          "Reduz movimento e efeitos da câmera. É uma preferência visual; o efeito no desempenho"
              + " costuma ser pequeno e depende do shader.";
    else if (value.contains("medição") || value.contains("measurement") || value.contains("query"))
      description =
          "Mede o tempo de renderização da GPU sem esperar por ela. Ajuda o controlador dinâmico;"
              + " não mede porcentagem de uso e não garante mais FPS.";
    else if (value.contains("restaur") || value.contains("restore"))
      description =
          "Restaura os valores indicados. Confira as opções antes de aplicar: a configuração"
              + " anterior pode usar mais ou menos recursos.";
    else if (value.contains("import")
        || value.contains("export")
        || value.contains("pasta")
        || value.contains("folder")
        || value.contains("reanalis")
        || value.contains("reanalys"))
      description =
          "Abre, importa, exporta ou analisa o recurso indicado. Pode usar disco e CPU"
              + " temporariamente; não aumenta FPS por si só.";
    else if (value.contains("predefini")
        || value.contains("preset")
        || value.contains("perfil")
        || value.contains("profile")
        || value.contains("automática")
        || value.contains("automatic"))
      description =
          "Escolhe ou aplica um conjunto de ajustes. Desativado preserva os valores; econômico"
              + " prioriza redução de detalhes; equilibrado combina custo e qualidade; qualidade"
              + " preserva mais detalhes. Revise os controles individuais.";
    else if (value.contains("aplicar") || value.contains("apply") || value.contains("reaplic"))
      description =
          "Aplica os valores selecionados. A carga depende das opções escolhidas; recargas podem"
              + " provocar uma pausa temporária.";
    else if (value.contains("nv vision boost:"))
      description =
          "Liga ou desliga os ajustes do NVVision. Ligado permite as funções selecionadas;"
              + " desligado preserva a renderização nativa conforme as proteções de"
              + " compatibilidade.";
    else
      description =
          "Abre ou alterna a opção indicada. Desativado preserva o comportamento original; valores"
              + " maiores podem aumentar os detalhes ou a redução visual, conforme o controle.";
    return text(
        description
            + "\n"
            + impact(label)
            + (reverse ? "\nClique direito: valor anterior. Enter/Espaço: próximo." : ""));
  }

  public static String impact(String label) {
    String value = label.toLowerCase(Locale.ROOT);
    if (value.matches("gpu|shaders|visual|imagem|image|mundo|world|i")
        || value.contains("sobre as tecnologias")
        || value.contains("about the technologies")
        || value.contains("recursos da gpu")
        || value.contains("gpu features")) return "Impacto: nenhum; apenas navegação.";
    if (value.matches(
        ".*(voltar|back|anterior|previous|próxima|next|↑|↓|rolar|scroll|início|home|avançado|advanced|integrações|integrations).*"))
      return "Impacto: nenhum; apenas navegação.";
    if (value.startsWith("● ") || value.startsWith("○ "))
      return "Impacto: CPU/disco temporários; pode pausar durante recargas.";
    if (value.matches("(nvidia|amd|intel|rtx|gtx|radeon|geforce|arc).*"))
      return "Impacto: nenhum; apenas navegação.";
    if (value.contains("mipmap") || value.contains("textur"))
      return "Impacto: GPU/VRAM variável; baixo a médio. Recarga: CPU/disco temporários.";
    if (value.contains("ferrite")
        || value.contains("ram")
        || value.contains("memória")
        || value.contains("memory")
        || value.contains("heap"))
      return "Impacto: RAM pode diminuir; custo de CPU variável. Reinício quando indicado.";
    if (value.contains("simula") || value.contains("simulation"))
      return "Impacto: CPU potencialmente médio/alto no mundo local; altera alcance de ticks.";
    if (value.contains("cpu")
        || value.contains("entidad")
        || value.contains("entit")
        || value.contains("partícul")
        || value.contains("particle")
        || value.contains("create"))
      return "Impacto: CPU/GPU baixo a médio, conforme a cena; reduz detalhes visuais.";
    if (value.contains("distância")
        || value.contains("distance")
        || value.contains("alcance")
        || value.contains("range"))
      return "Impacto: CPU, GPU e RAM de baixo a alto, conforme distância e mundo.";
    if (value.contains("upscal")
        || value.contains("escala")
        || value.contains("scale")
        || value.contains("resolução")
        || value.contains("resolution")
        || value.contains("fsr")
        || value.contains("filtro")
        || value.contains("filter")
        || value.contains("shader")
        || value.contains("fps"))
      return "Impacto: GPU de baixo a alto; CPU e FPS dependem do gargalo. Não há ganho garantido.";
    if (value.contains("import")
        || value.contains("export")
        || value.contains("pasta")
        || value.contains("folder")
        || value.contains("prepar")
        || value.contains("recarg"))
      return "Impacto: CPU/disco temporários; pode pausar durante recargas.";
    return "Impacto variável conforme a opção e o hardware; não há ganho de FPS garantido.";
  }

  private static String text(String value) {
    return NVVisionBoostLanguage.text(value);
  }

  private NVVisionBoostHelp() {}
}
