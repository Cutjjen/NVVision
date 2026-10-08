import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarFile;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/** Validates mixin superclass contracts and calls inherited through NVVision GUI adapters. */
public final class CheckGuiInheritance {
  static final Map<String, ClassNode> nodes = new HashMap<>();
  static int resolve(String owner, String name, String desc, Set<String> seen) {
    if (!seen.add(owner)) return 0;
    ClassNode node = nodes.get(owner);
    if (node == null && owner.startsWith("java/")) {
      try (var input = ClassLoader.getSystemResourceAsStream(owner + ".class")) {
        if (input != null) {
          node = new ClassNode();
          new ClassReader(input).accept(node, ClassReader.SKIP_CODE);
          nodes.put(owner, node);
        }
      } catch (java.io.IOException error) {
        throw new IllegalStateException(error);
      }
    }
    if (node == null) return -1;
    for (var method : node.methods)
      if (method.name.equals(name) && method.desc.equals(desc)) return 1;
    int unknown = 0;
    if (node.superName != null && !name.equals("<init>")) {
      int result = resolve(node.superName, name, desc, seen);
      if (result == 1) return 1;
      if (result == -1 && !node.superName.startsWith("java/")) unknown = -1;
    }
    for (String parent : node.interfaces) {
      int result = resolve(parent, name, desc, seen);
      if (result == 1) return 1;
      if (result == -1) unknown = -1;
    }
    return unknown;
  }
  static boolean ancestor(String target, String parent) {
    Set<String> seen = new HashSet<>();
    while (target != null && seen.add(target)) {
      if (target.equals(parent)) return true;
      var node = nodes.get(target);
      target = node == null ? null : node.superName;
    }
    return false;
  }
  public static void main(String[] args) throws Exception {
    List<ClassNode> project = new ArrayList<>();
    for (int i = 0; i < args.length; i++) {
      try (var jar = new JarFile(Path.of(args[i]).toFile())) {
        for (var entry : Collections.list(jar.entries())) {
          if (!entry.getName().endsWith(".class")) continue;
          var node = new ClassNode();
          new ClassReader(jar.getInputStream(entry)).accept(node, 0);
          nodes.putIfAbsent(node.name, node);
          if (i < 2) project.add(node);
        }
      }
    }
    int calls = 0, supers = 0;
    for (var node : project) {
      List<AnnotationNode> annotations = new ArrayList<>();
      if (node.visibleAnnotations != null) annotations.addAll(node.visibleAnnotations);
      if (node.invisibleAnnotations != null) annotations.addAll(node.invisibleAnnotations);
      for (var annotation : annotations) {
        if (!annotation.desc.endsWith("/Mixin;") || (node.access & Opcodes.ACC_INTERFACE) != 0) continue;
        for (int i = 0; annotation.values != null && i < annotation.values.size(); i += 2) {
          if (!annotation.values.get(i).equals("value")) continue;
          for (Object value : (List<?>) annotation.values.get(i + 1)) {
            String target = ((Type) value).getInternalName();
            if (nodes.containsKey(target) && !ancestor(target, node.superName))
              throw new IllegalStateException("Invalid Mixin superclass: " + node.name + " extends " + node.superName + " targeting " + target);
            supers++;
          }
        }
      }
      for (var method : node.methods) {
        for (var instruction : method.instructions) {
          if (!(instruction instanceof MethodInsnNode call) || !call.owner.startsWith("nvvisionboost/") || call.name.startsWith("nvvb$")) continue;
          int result = resolve(call.owner, call.name, call.desc, new HashSet<>());
          if (result == 0 && !call.owner.contains("/mixin/"))
            throw new IllegalStateException("Unresolved inherited call: " + node.name + "." + method.name + " -> " + call.owner + "." + call.name + call.desc);
          if (result == 1) calls++;
        }
      }
    }
    System.out.println("PASS GUI inheritance: " + calls + " calls and " + supers + " mixin superclasses");
  }
}
