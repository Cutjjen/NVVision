import java.util.*;
import java.util.jar.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/** Validates production SRG references, including inherited members. */
public class CheckVersionLinks {
  static JarFile minecraft;
  static List<JarFile> libraries = new ArrayList<>();
  static Map<String, ClassNode> cache = new HashMap<>();
  static ClassNode read(String name) throws Exception {
    if (cache.containsKey(name)) return cache.get(name);
    var archive = minecraft;
    var entry = archive.getJarEntry(name + ".class");
    if (entry == null) for (var library : libraries) {
      entry = library.getJarEntry(name + ".class");
      if (entry != null) { archive = library; break; }
    }
    if (entry == null) {
      if (!name.startsWith("java/")) return null;
      try (var stream = ClassLoader.getSystemResourceAsStream(name + ".class")) {
        if (stream == null) return null;
        var node = new ClassNode();
        new ClassReader(stream).accept(node, ClassReader.SKIP_DEBUG);
        cache.put(name, node);
        return node;
      }
    }
    var node = new ClassNode();
    try (var stream = archive.getInputStream(entry)) {
      new ClassReader(stream).accept(node, ClassReader.SKIP_DEBUG);
    }
    cache.put(name, node);
    return node;
  }
  static boolean member(String owner, String name, String desc, boolean field, Set<String> visited) throws Exception {
    if (!visited.add(owner)) return false;
    var node = read(owner);
    if (node == null) return false;
    if (field) {
      if (node.fields.stream().anyMatch(f -> f.name.equals(name) && f.desc.equals(desc))) return true;
    } else if (node.methods.stream().anyMatch(m -> m.name.equals(name) && m.desc.equals(desc))) return true;
    if (name.equals("<init>")) return false;
    if (node.superName != null && member(node.superName, name, desc, field, visited)) return true;
    for (String type : node.interfaces) if (member(type, name, desc, field, visited)) return true;
    return false;
  }
  public static void main(String[] args) throws Exception {
    int checks = 0;
    try (var mc = new JarFile(args[0])) {
      minecraft = mc;
      for (int i = 1; i < args.length - 2; i++) libraries.add(new JarFile(args[i]));
      for (int i = args.length - 2; i < args.length; i++) try (var mod = new JarFile(args[i])) {
        for (var entry : Collections.list(mod.entries())) {
          if (!entry.getName().endsWith(".class")) continue;
          var node = new ClassNode();
          try (var stream = mod.getInputStream(entry)) { new ClassReader(stream).accept(node, 0); }
          for (var method : node.methods) for (var instruction : method.instructions) {
            String owner, name, desc; boolean field;
            if (instruction instanceof MethodInsnNode call) { owner = call.owner; name = call.name; desc = call.desc; field = false; }
            else if (instruction instanceof FieldInsnNode access) { owner = access.owner; name = access.name; desc = access.desc; field = true; }
            else continue;
            if (!owner.startsWith("net/minecraft/") && !owner.startsWith("com/mojang/blaze3d/") && !owner.startsWith("net/minecraftforge/") && !owner.startsWith("net/neoforged/")) continue;
            if (read(owner) == null || !member(owner, name, desc, field, new HashSet<>()))
              throw new AssertionError(node.name + " -> " + owner + ";" + name + desc);
            checks++;
          }
        }
      }
      for (var library : libraries) library.close();
    }
    System.out.println("PASS production Minecraft links: " + checks + " references");
  }
}

