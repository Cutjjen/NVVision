import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import net.minecraftforge.renamer.relocated.net.minecraftforge.srgutils.IMappingFile;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.tree.*;

/**
 * Legacy mapping boundary: read-only archives and explicit hierarchy lookup, no Java ZipFS writes.
 */
public final class LegacyJarMappings {
  public static void main(String[] args) throws Exception {
    var mapping = IMappingFile.load(Path.of(args[2]).toFile());
    var nodes = new HashMap<String, ClassNode>();
    for (int i = 3; i < args.length; i++)
      try (var jar = new JarFile(args[i])) {
        for (var entry : Collections.list(jar.entries()))
          if (entry.getName().endsWith(".class")) {
            var node = new ClassNode();
            new ClassReader(jar.getInputStream(entry))
                .accept(
                    node, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
            nodes.put(node.name, node);
          }
      }
    Remapper remapper =
        new Remapper() {
          @Override
          public String map(String name) {
            return mapping.remapClass(name);
          }

          String member(String owner, String name, String desc, boolean method, Set<String> seen) {
            if (!seen.add(owner)) return name;
            var c = mapping.getClass(owner);
            if (c != null) {
              if (method) {
                for (var m : c.getMethods())
                  if (m.getOriginal().equals(name) && m.getDescriptor().equals(desc))
                    return m.getMapped();
              } else {
                for (var f : c.getFields()) if (f.getOriginal().equals(name)) return f.getMapped();
              }
            }
            var node = nodes.get(owner);
            if (node != null) {
              if (node.superName != null) {
                String n = member(node.superName, name, desc, method, seen);
                if (!n.equals(name)) return n;
              }
              for (String iface : node.interfaces) {
                String n = member(iface, name, desc, method, seen);
                if (!n.equals(name)) return n;
              }
            }
            return name;
          }

          @Override
          public String mapMethodName(String owner, String name, String desc) {
            return name.startsWith("<") ? name : member(owner, name, desc, true, new HashSet<>());
          }

          @Override
          public String mapFieldName(String owner, String name, String desc) {
            return member(owner, name, desc, false, new HashSet<>());
          }
        };
    try (var input = new JarFile(args[0]);
        var output = new JarOutputStream(Files.newOutputStream(Path.of(args[1])))) {
      for (var entry : Collections.list(input.entries())) {
        String name = entry.getName();
        String upper = name.toUpperCase(Locale.ROOT);
        if (upper.startsWith("META-INF/")
            && (upper.endsWith(".SF") || upper.endsWith(".RSA") || upper.endsWith(".DSA")))
          continue;
        byte[] bytes = input.getInputStream(entry).readAllBytes();
        if (name.endsWith(".class")) {
          var reader = new ClassReader(bytes);
          var writer = new ClassWriter(0);
          reader.accept(new ClassRemapper(writer, remapper), 0);
          name = mapping.remapClass(reader.getClassName()) + ".class";
          bytes = writer.toByteArray();
        }
        output.putNextEntry(new JarEntry(name));
        output.write(bytes);
        output.closeEntry();
      }
    }
    System.out.println("PASS legacy class and member mappings");
  }
}
