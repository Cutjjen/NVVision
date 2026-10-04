# Compilação

Requisitos: PowerShell 7; JDKs compatíveis com as versões da matriz; bibliotecas de Minecraft/loader/mods para o alvo; ASM, Gson e Forge Auto Renaming Tool para os auxiliares de remapeamento. Bibliotecas, JARs de Minecraft, runtimes nativos e SDKs de terceiros não são redistribuídos nas fontes.

1. Copie `config/toolchain.example.json` para `.local/toolchain.json` e informe os executáveis Java, classpath dos auxiliares e caminhos dos mapas.
2. Crie `.local/<alvo>-mod.classpath.txt` e `.local/<alvo>-addon.classpath.txt`, contendo uma única linha com bibliotecas locais separadas por `;`. Use os jars correspondentes à versão alvo, nunca o classpath de outra versão.
3. Materialize as fontes: `pwsh scripts/Prepare.ps1 -Target neoforge-1211`.
4. Compile: `pwsh scripts/Build.ps1 -Target neoforge-1211`.
5. Configure `java21` e `natives17/21/25` no toolchain e execute `pwsh scripts/Test.ps1 -Target neoforge-1211` para os testes disponíveis do alvo.

O pipeline executa: seleção de fontes → compilação Java → empacotamento → remapeamento Forge/Fabric quando exigido → JAR final em `build/generated/<alvo>-<componente>`. Para versões named, o empacotamento não altera os nomes do runtime.

As ferramentas usam JarFile para evitar o problema de ZipFS observado no ambiente original. O script funciona com dependências explicitamente configuradas; não instala loaders, altera modpacks ou baixa bibliotecas automaticamente. Sem essas dependências, uma clonagem limpa não compila o jogo por si só.

Os testes Java estão nos caminhos lógicos `test/java` do registro. Os validadores CheckNamedMixins e CheckVersionLinks requerem os JARs reais do runtime alvo. Testes OpenGL requerem contexto gráfico e bibliotecas nativas LWJGL correspondentes. A CI incluída verifica a integridade do repositório, não executa Minecraft nem anuncia validação gráfica automática.

