import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.DocTrees;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.tools.ToolProvider;

/** Generates a navigable inventory from Java syntax trees, without loading Minecraft. */
public final class FunctionIndex {
  public static void main(String[] args) throws Exception {
    Path root = Path.of(args[0]).toAbsolutePath().normalize();
    List<Path> sources;
    if (args.length > 2) {
      sources =
          Files.readAllLines(Path.of(args[2]), StandardCharsets.UTF_8).stream()
              .filter(line -> !line.isBlank())
              .map(root::resolve)
              .distinct()
              .sorted()
              .toList();
    } else {
      try (var walk = Files.walk(root)) {
        sources =
            walk.filter(p -> Files.isRegularFile(p) && p.toString().endsWith(".java"))
                .sorted()
                .toList();
      }
    }
    var compiler = ToolProvider.getSystemJavaCompiler();
    if (compiler == null) throw new IllegalStateException("A full JDK is required.");
    var output =
        new StringBuilder(
            "# Function index\n\n"
                + "Generated from Java syntax trees. Contracts come from source comments; an entry"
                + " without a contract is not an individual function audit. Minecraft variants retain"
                + " their API differences. See ARCHITECTURE.md for module responsibilities.\n\n");
    int[] count = {0};
    try (var manager = compiler.getStandardFileManager(null, null, StandardCharsets.UTF_8)) {
      var units = manager.getJavaFileObjectsFromPaths(sources);
      var task =
          (JavacTask) compiler.getTask(null, manager, null, List.of("-proc:none"), null, units);
      var trees = Trees.instance(task);
      var docs = DocTrees.instance(task);
      for (CompilationUnitTree unit : task.parse()) {
        Path path = Path.of(unit.getSourceFile().toUri());
        String relative = root.relativize(path).toString().replace('\\', '/');
        output.append("## ").append(relative).append("\n\n");
        new TreePathScanner<Void, Void>() {
          final List<String> classes = new ArrayList<>();

          @Override
          public Void visitClass(ClassTree tree, Void unused) {
            classes.add(tree.getSimpleName().toString());
            super.visitClass(tree, unused);
            classes.remove(classes.size() - 1);
            return null;
          }

          @Override
          public Void visitMethod(MethodTree method, Void unused) {
            long offset = trees.getSourcePositions().getStartPosition(unit, method);
            long line = unit.getLineMap().getLineNumber(offset);
            var doc = docs.getDocCommentTree(getCurrentPath());
            String signature =
                String.join(".", classes)
                    + "."
                    + method.getName()
                    + "("
                    + String.join(
                        ", ",
                        method.getParameters().stream()
                            .map(p -> p.getType() + " " + p.getName())
                            .toList())
                    + ")";
            output.append("- `").append(signature).append("` — line ").append(line).append(". ");
            output.append(
                doc == null
                    ? "No individual contract; refer to the module responsibility and method body."
                    : doc.getFullBody().toString().replace('\n', ' '));
            output.append('\n');
            count[0]++;
            return super.visitMethod(method, unused);
          }
        }.scan(unit, null);
        output.append('\n');
      }
    }
    Files.writeString(Path.of(args[1]), output, StandardCharsets.UTF_8);
    System.out.println(
        "Indexed " + count[0] + " functions in " + sources.size() + " registered Java files.");
  }
}
