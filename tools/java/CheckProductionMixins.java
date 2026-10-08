import com.google.gson.*;
import java.util.*;
import java.util.jar.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public final class CheckProductionMixins {
  static final List<JarFile> jars = new ArrayList<>();
  static int checks;
  static JsonObject refs = new JsonObject();

  static String mapped(String name) {
    return refs.has(name) ? refs.get(name).getAsString() : name;
  }

  static ClassNode read(String name) throws Exception {
    for (var jar : jars) {
      var entry = jar.getJarEntry(name + ".class");
      if (entry != null) {
        var node = new ClassNode();
        try (var in = jar.getInputStream(entry)) {
          new ClassReader(in).accept(node, 0);
        }
        return node;
      }
    }
    throw new AssertionError("Missing class: " + name);
  }

  static Object value(AnnotationNode a, String key) {
    if (a.values != null)
      for (int i = 0; i < a.values.size(); i += 2)
        if (key.equals(a.values.get(i))) return a.values.get(i + 1);
    return null;
  }

  static List<AnnotationNode> anns(List<AnnotationNode> a, List<AnnotationNode> b) {
    var result = new ArrayList<AnnotationNode>();
    if (a != null) result.addAll(a);
    if (b != null) result.addAll(b);
    return result;
  }

  static void check(boolean ok, String message) {
    if (!ok) throw new AssertionError(message);
    checks++;
  }

  static void invocation(Object v, List<MethodNode> methods, boolean optional) {
    if (v instanceof List<?> list) {
      for (var item : list) invocation(item, methods, optional);
      return;
    }
    if (!(v instanceof AnnotationNode a)
        || !(value(a, "target") instanceof String s)
        || !s.contains("(")) return;
    s = mapped(s);
    int semi = s.indexOf(';'), paren = s.indexOf('(', semi);
    if (semi < 0) return;
    String owner = s.substring(1, semi),
        name = s.substring(semi + 1, paren),
        desc = s.substring(paren);
    boolean found = false;
    for (var method : methods)
      for (var ins : method.instructions)
        if (ins instanceof MethodInsnNode call
            && call.owner.equals(owner)
            && call.name.equals(name)
            && call.desc.equals(desc)) found = true;
    check(found || optional, "Missing invocation: " + s);
  }

  public static void main(String[] args) throws Exception {
    for (var path : args) jars.add(new JarFile(path));
    for (int index = 0; index < 2; index++) {
      var jar = jars.get(index);
      var entry =
          jar.getJarEntry(index == 0 ? "nvvisionboost.mixins.json" : "nvvisionbridge.mixins.json");
      if (entry == null) continue;
      JsonObject config;
      try (var reader = new java.io.InputStreamReader(jar.getInputStream(entry))) {
        config = JsonParser.parseReader(reader).getAsJsonObject();
      }
      JsonObject mappings = new JsonObject();
      if (config.has("refmap")) {
        var rm = jar.getJarEntry(config.get("refmap").getAsString());
        check(rm != null, "Production refmap present");
        try (var reader = new java.io.InputStreamReader(jar.getInputStream(rm))) {
          mappings = JsonParser.parseReader(reader).getAsJsonObject().getAsJsonObject("mappings");
        }
      }
      String pkg = config.get("package").getAsString().replace('.', '/');
      for (var item : config.getAsJsonArray("client")) {
        var mixin = read(pkg + "/" + item.getAsString());
        refs = mappings.has(mixin.name) ? mappings.getAsJsonObject(mixin.name) : new JsonObject();
        var annotation =
            anns(mixin.visibleAnnotations, mixin.invisibleAnnotations).stream()
                .filter(a -> a.desc.endsWith("/Mixin;"))
                .findFirst()
                .orElseThrow();
        var types = (List<?>) value(annotation, "value");
        String targetName;
        if (types != null && !types.isEmpty()) {
          targetName = ((Type) types.get(0)).getInternalName();
        } else {
          var named = (List<?>) value(annotation, "targets");
          if (named == null || named.isEmpty())
            throw new AssertionError("Mixin target missing: " + mixin.name);
          targetName = named.get(0).toString().replace('.', '/');
        }
        var target = read(targetName);
        for (var field : mixin.fields)
          for (var a : anns(field.visibleAnnotations, field.invisibleAnnotations))
            if (a.desc.endsWith("/Shadow;")) {
              String name = mapped(field.name).split(":")[0];
              check(
                  target.fields.stream()
                      .anyMatch(f -> f.name.equals(name) && f.desc.equals(field.desc)),
                  "Shadow: " + name);
            }
        for (var method : mixin.methods)
          for (var a : anns(method.visibleAnnotations, method.invisibleAnnotations)) {
            if (a.desc.endsWith("/Accessor;")) {
              String original = (String) value(a, "value");
              String name =
                  Boolean.FALSE.equals(value(a, "remap"))
                      ? original
                      : mapped(original).split(":")[0];
              var returns = Type.getReturnType(method.desc);
              var parameters = Type.getArgumentTypes(method.desc);
              String desc =
                  returns.getSort() == Type.VOID
                      ? parameters[0].getDescriptor()
                      : returns.getDescriptor();
              check(
                  target.fields.stream().anyMatch(f -> f.name.equals(name) && f.desc.equals(desc)),
                  "Accessor: " + name + desc);
            }
            if (a.desc.endsWith("/Invoker;")) {
              String reference = mapped((String) value(a, "value"));
              if (reference.startsWith("L"))
                reference = reference.substring(reference.indexOf(';') + 1);
              int paren = reference.indexOf('(');
              String name = paren < 0 ? reference : reference.substring(0, paren);
              check(
                  target.methods.stream()
                      .anyMatch(m -> m.name.equals(name) && m.desc.equals(method.desc)),
                  "Invoker: " + name + method.desc);
            }
            if (!(value(a, "method") instanceof List<?> selectors)) continue;
            boolean optional = Integer.valueOf(0).equals(value(a, "require"));
            for (var selector : selectors) {
              String s = mapped(selector.toString());
              if (s.startsWith("L")) s = s.substring(s.indexOf(';') + 1);
              int paren = s.indexOf('(');
              String name = paren < 0 ? s : s.substring(0, paren),
                  desc = paren < 0 ? null : s.substring(paren);
              var methods =
                  target.methods.stream()
                      .filter(m -> m.name.equals(name) && (desc == null || desc.equals(m.desc)))
                      .toList();
              check(!methods.isEmpty() || optional, "Selector: " + target.name + "." + s);
              invocation(value(a, "at"), methods, optional);
            }
          }
      }
    }
    for (var jar : jars) jar.close();
    System.out.println(
        "PASS production mixin selectors/accessors/invocations: " + checks + " checks");
  }
}
