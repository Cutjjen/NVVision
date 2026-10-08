import java.nio.file.Path;
import java.util.jar.JarFile;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/** Rejects interface mixins with concrete/default methods targeting Minecraft classes. */
public final class CheckAccessorMixins {
  public static void main(String[] args) throws Exception {
    int checks = 0;
    for (String argument : args) {
      try (JarFile jar = new JarFile(Path.of(argument).toFile())) {
        var entries = jar.entries();
        while (entries.hasMoreElements()) {
          var entry = entries.nextElement();
          if (!entry.getName().endsWith(".class")) continue;
          var node = new ClassNode();
          try (var input = jar.getInputStream(entry)) {
            new ClassReader(input).accept(node, ClassReader.SKIP_CODE);
          }
          if ((node.access & Opcodes.ACC_INTERFACE) == 0) continue;
          if (node.invisibleAnnotations == null || node.invisibleAnnotations.stream()
              .noneMatch(a -> a.desc.equals("Lorg/spongepowered/asm/mixin/Mixin;"))) continue;
          for (var method : node.methods) {
            if (method.name.equals("<clinit>")) continue;
            boolean accessor = method.visibleAnnotations != null && method.visibleAnnotations.stream()
                .anyMatch(a -> a.desc.equals("Lorg/spongepowered/asm/mixin/gen/Accessor;")
                    || a.desc.equals("Lorg/spongepowered/asm/mixin/gen/Invoker;"));
            if (!accessor || (method.access & (Opcodes.ACC_ABSTRACT | Opcodes.ACC_STATIC)) == 0)
              throw new IllegalStateException("Interface mixin requires target-interface review: "
                  + node.name + "." + method.name + method.desc);
            checks++;
          }
        }
      }
    }
    System.out.println("PASS pure accessor mixin contracts: " + checks + " methods");
  }
}

