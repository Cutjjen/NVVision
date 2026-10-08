import com.google.gson.GsonBuilder;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import net.minecraftforge.renamer.relocated.net.minecraftforge.srgutils.IMappingFile;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class BuildPortMappings {
  static IMappingFile mapping;

  static Object value(AnnotationNode a, String key) {
    if (a.values != null)
      for (int i = 0; i < a.values.size(); i += 2)
        if (key.equals(a.values.get(i))) return a.values.get(i + 1);
    return null;
  }

  static List<AnnotationNode> annotations(List<AnnotationNode> a, List<AnnotationNode> b) {
    var r = new ArrayList<AnnotationNode>();
    if (a != null) r.addAll(a);
    if (b != null) r.addAll(b);
    return r;
  }

  static String method(String owner, String reference) {
    int p = reference.indexOf('(');
    String name = p < 0 ? reference : reference.substring(0, p),
        desc = p < 0 ? null : reference.substring(p);
    var c = mapping.getClass(owner);
    if (c == null) return reference;
    var found =
        c.getMethods().stream()
            .filter(
                m ->
                    m.getOriginal().equals(name)
                        && (desc == null || m.getDescriptor().equals(desc)))
            .toList();
    if (found.size() != 1)
      throw new IllegalStateException(
          "Ambiguous or absent mixin selector: " + owner + " " + reference);
    var m = found.get(0);
    return "L" + c.getMapped() + ";" + m.getMapped() + mapping.remapDescriptor(m.getDescriptor());
  }

  static String field(String owner, String name) {
    var c = mapping.getClass(owner);
    var found =
        c.getFields().stream().filter(f -> f.getOriginal().equals(name)).findFirst().orElseThrow();
    return found.getMapped() + ":" + mapping.remapDescriptor(found.getDescriptor());
  }

  static void at(Object v, Map<String, String> refs) {
    if (v instanceof List<?> list) {
      for (Object x : list) at(x, refs);
      return;
    }
    if (!(v instanceof AnnotationNode a)) return;
    Object t = value(a, "target");
    if (t instanceof String s && s.startsWith("L") && s.contains("(")) {
      int semi = s.indexOf(';');
      refs.put(s, method(s.substring(1, semi), s.substring(semi + 1)));
    }
  }

  static String inherited(IMappingFile tiny, Map<String, ClassNode> nodes, String owner,
      String name, String descriptor, boolean method, Set<String> visited) {
    if (!visited.add(owner)) return name;
    var entry = tiny.getClass(owner);
    if (entry != null) {
      if (method) {
        for (var member : entry.getMethods())
          if (member.getOriginal().equals(name) && member.getDescriptor().equals(descriptor))
            return member.getMapped();
      } else {
        for (var member : entry.getFields())
          if (member.getOriginal().equals(name)) return member.getMapped();
      }
    }
    var node = nodes.get(owner);
    if (node != null) {
      if (node.superName != null) {
        String mapped = inherited(tiny, nodes, node.superName, name, descriptor, method, visited);
        if (!mapped.equals(name)) return mapped;
      }
      for (String parent : node.interfaces) {
        String mapped = inherited(tiny, nodes, parent, name, descriptor, method, visited);
        if (!mapped.equals(name)) return mapped;
      }
    }
    return name;
  }

  public static void main(String[] a) throws Exception {
    var official = IMappingFile.load(Path.of(a[0]).toFile());
    var intermediary = IMappingFile.load(Path.of(a[1]).toFile());
    mapping = official.chain(intermediary);
    // Tiny mappings name inherited methods at their declaring ancestor, while Mojang may
    // repeat them on a subclass. Resolve against the real official class hierarchy.
    var hierarchy = new HashMap<String, ClassNode>();
    try (var client = new JarFile(Path.of(a[5]).getParent().resolve("client.jar").toFile())) {
      for (var entry : Collections.list(client.entries())) {
        if (!entry.getName().endsWith(".class")) continue;
        var node = new ClassNode();
        new ClassReader(client.getInputStream(entry)).accept(node, ClassReader.SKIP_CODE);
        hierarchy.put(node.name, node);
      }
    }
    var text = new StringBuilder("tsrg2 named intermediary\n");
    for (var c : mapping.getClasses()) {
      var source = official.getClass(c.getOriginal());
      text.append(c.getOriginal()).append(' ').append(c.getMapped()).append('\n');
      for (var f : c.getFields()) {
        var original = source.getFields().stream().filter(x -> x.getOriginal().equals(f.getOriginal())).findFirst().orElseThrow();
        String mapped = inherited(intermediary, hierarchy, source.getMapped(), original.getMapped(), null, false, new HashSet<>());
        text.append('\t').append(f.getOriginal()).append(' ').append(f.getDescriptor()).append(' ').append(mapped).append('\n');
      }
      for (var m : c.getMethods()) {
        var original = source.getMethods().stream().filter(x -> x.getOriginal().equals(m.getOriginal()) && x.getDescriptor().equals(m.getDescriptor())).findFirst().orElseThrow();
        String mapped = m.getOriginal().startsWith("<") ? m.getMapped() : inherited(intermediary, hierarchy, source.getMapped(), original.getMapped(), official.remapDescriptor(m.getDescriptor()), true, new HashSet<>());
        text.append('\t').append(m.getOriginal()).append(' ').append(m.getDescriptor()).append(' ').append(mapped).append('\n');
      }
    }
    Files.writeString(Path.of(a[2]), text);
    mapping = IMappingFile.load(Path.of(a[2]).toFile());
    var all = new LinkedHashMap<String, Map<String, String>>();
    try (var jar = new JarFile(a[3])) {
      for (var e : Collections.list(jar.entries())) {
        if (!e.getName().endsWith(".class")) continue;
        var c = new ClassNode();
        new ClassReader(jar.getInputStream(e)).accept(c, 0);
        var mix =
            annotations(c.visibleAnnotations, c.invisibleAnnotations).stream()
                .filter(x -> x.desc.endsWith("/Mixin;"))
                .findFirst();
        if (mix.isEmpty() || Boolean.FALSE.equals(value(mix.get(), "remap"))) continue;
        Object targets = value(mix.get(), "value");
        if (!(targets instanceof List<?> list) || list.size() != 1)
          throw new IllegalStateException("Use class literals for mapped mixin " + c.name);
        String owner = ((Type) list.get(0)).getInternalName();
        var refs = new LinkedHashMap<String, String>();
        for (var f : c.fields)
          for (var an : annotations(f.visibleAnnotations, f.invisibleAnnotations))
            if (an.desc.endsWith("/Shadow;") && !Boolean.FALSE.equals(value(an, "remap")))
              refs.put(f.name, field(owner, f.name));
        for (var m : c.methods)
          for (var an : annotations(m.visibleAnnotations, m.invisibleAnnotations)) {
            if (Boolean.FALSE.equals(value(an, "remap"))) continue;
            if (an.desc.endsWith("/Accessor;")) {
              String target = (String) value(an, "value");
              refs.put(target, field(owner, target));
            }
            if (an.desc.endsWith("/Invoker;")) {
              String target = (String) value(an, "value");
              if (target == null || target.isBlank())
                throw new IllegalStateException(
                    "Explicit invoker target required: " + c.name + " " + m.name);
              refs.put(target, method(owner, target + m.desc));
            }
            Object selectors = value(an, "method");
            if (selectors instanceof List<?> methods)
              for (Object x : methods) refs.put(x.toString(), method(owner, x.toString()));
            at(value(an, "at"), refs);
          }
        all.put(c.name, refs);
      }
    }
    var refmap = Map.of("mappings", all, "data", Map.of("named:intermediary", all));
    Files.writeString(Path.of(a[4]), new GsonBuilder().setPrettyPrinting().create().toJson(refmap));
    System.out.println("Generated mappings for " + all.size() + " mixins");
  }
}
