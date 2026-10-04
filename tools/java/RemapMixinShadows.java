import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import com.google.gson.*;

/** Shadow declarations must use runtime names; a refmap alone does not rename them. */
public class RemapMixinShadows {
  static Object value(AnnotationNode a, String key) {
    if (a.values != null) for (int i=0;i<a.values.size();i+=2)
      if (key.equals(a.values.get(i))) return a.values.get(i+1);
    return null;
  }
  public static void main(String[] args) throws Exception {
    int count=0;
    try (var input=new JarFile(args[0]); var output=new JarOutputStream(Files.newOutputStream(Path.of(args[1])))) {
      var refs=JsonParser.parseReader(new java.io.InputStreamReader(input.getInputStream(input.getJarEntry(args.length>2?args[2]:"nvvision.refmap.json")))).getAsJsonObject().getAsJsonObject("mappings");
      for (var entry:Collections.list(input.entries())) {
        byte[] bytes;
        try(var stream=input.getInputStream(entry)){bytes=stream.readAllBytes();}
        if(entry.getName().endsWith(".class")) {
          var node=new ClassNode(); new ClassReader(bytes).accept(node,0);
          if(refs.has(node.name)) {
            var fields=new HashMap<String,String>(); var mappings=refs.getAsJsonObject(node.name);
            for(var field:node.fields) {
              var annotations=new ArrayList<AnnotationNode>();
              if(field.visibleAnnotations!=null)annotations.addAll(field.visibleAnnotations);
              if(field.invisibleAnnotations!=null)annotations.addAll(field.invisibleAnnotations);
              for(var annotation:annotations) if(annotation.desc.endsWith("/Shadow;")&&!Boolean.FALSE.equals(value(annotation,"remap"))) {
                if(!mappings.has(field.name))throw new IllegalStateException("Unmapped shadow "+node.name+"."+field.name);
                String reference=mappings.get(field.name).getAsString(); int colon=reference.indexOf(':');
                if(colon<0||!field.desc.equals(reference.substring(colon+1)))throw new IllegalStateException("Shadow descriptor mismatch");
                fields.put(field.name,reference.substring(0,colon)); field.name=reference.substring(0,colon);count++;
              }
            }
            for(var method:node.methods)for(var instruction:method.instructions)
              if(instruction instanceof FieldInsnNode access && access.owner.equals(node.name) && fields.containsKey(access.name))access.name=fields.get(access.name);
            if(!fields.isEmpty()){var writer=new ClassWriter(0);node.accept(writer);bytes=writer.toByteArray();}
          }
        }
        var target=new JarEntry(entry.getName());target.setTime(0);output.putNextEntry(target);output.write(bytes);output.closeEntry();
      }
    }
    System.out.println("PASS: "+count+" mixin shadow declarations and references remapped");
  }
}
