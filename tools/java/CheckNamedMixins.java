import java.util.*;
import java.util.jar.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import com.google.gson.*;
public final class CheckNamedMixins {
 static final List<JarFile> jars=new ArrayList<>(); static int checks;
 static ClassNode read(String name)throws Exception {
  for(var jar:jars){var entry=jar.getJarEntry(name+".class");if(entry!=null){var node=new ClassNode();try(var in=jar.getInputStream(entry)){new ClassReader(in).accept(node,0);}return node;}}
  throw new AssertionError("Missing class: "+name);
 }
 static Object value(AnnotationNode a,String key){if(a.values!=null)for(int i=0;i<a.values.size();i+=2)if(key.equals(a.values.get(i)))return a.values.get(i+1);return null;}
 static List<AnnotationNode> anns(List<AnnotationNode>a,List<AnnotationNode>b){var result=new ArrayList<AnnotationNode>();if(a!=null)result.addAll(a);if(b!=null)result.addAll(b);return result;}
 static void check(boolean ok,String message){if(!ok)throw new AssertionError(message);checks++;}
 static void invocation(Object v,List<MethodNode> methods,boolean optional){
  if(v instanceof List<?> list){for(var item:list)invocation(item,methods,optional);return;}
  if(!(v instanceof AnnotationNode a)||!(value(a,"target") instanceof String s)||!s.contains("("))return;
  int semi=s.indexOf(';'),paren=s.indexOf('(',semi);if(semi<0)return;
  String owner=s.substring(1,semi),name=s.substring(semi+1,paren),desc=s.substring(paren);boolean found=false;
  for(var method:methods)for(var ins:method.instructions)if(ins instanceof MethodInsnNode call&&call.owner.equals(owner)&&call.name.equals(name)&&call.desc.equals(desc))found=true;
  check(found||optional,"Missing invocation: "+s);
 }
 public static void main(String[] args)throws Exception {
  for(var path:args)jars.add(new JarFile(path));
  for(int index=0;index<2;index++){
   var jar=jars.get(index);var entry=jar.getJarEntry(index==0?"nvvisionboost.mixins.json":"nvvisionbridge.mixins.json");if(entry==null)continue;
   JsonObject config;try(var reader=new java.io.InputStreamReader(jar.getInputStream(entry))){config=JsonParser.parseReader(reader).getAsJsonObject();}
   String pkg=config.get("package").getAsString().replace('.','/');
   for(var item:config.getAsJsonArray("client")){
    var mixin=read(pkg+"/"+item.getAsString());
    var annotation=anns(mixin.visibleAnnotations,mixin.invisibleAnnotations).stream().filter(a->a.desc.endsWith("/Mixin;")).findFirst().orElseThrow();
    var types=(List<?>)value(annotation,"value");var target=read(((Type)types.get(0)).getInternalName());
    for(var field:mixin.fields)for(var a:anns(field.visibleAnnotations,field.invisibleAnnotations))if(a.desc.endsWith("/Shadow;"))check(target.fields.stream().anyMatch(f->f.name.equals(field.name)&&f.desc.equals(field.desc)),"Shadow: "+field.name);
    for(var method:mixin.methods)for(var a:anns(method.visibleAnnotations,method.invisibleAnnotations)){
     if(a.desc.endsWith("/Accessor;")){
      String name=(String)value(a,"value");var returns=Type.getReturnType(method.desc);var parameters=Type.getArgumentTypes(method.desc);String desc=returns.getSort()==Type.VOID?parameters[0].getDescriptor():returns.getDescriptor();
      check(target.fields.stream().anyMatch(f->f.name.equals(name)&&f.desc.equals(desc)),"Accessor: "+name+desc);
     }
     if(a.desc.endsWith("/Invoker;")){String name=(String)value(a,"value");check(target.methods.stream().anyMatch(m->m.name.equals(name)&&m.desc.equals(method.desc)),"Invoker: "+name+method.desc);}
     if(!(value(a,"method") instanceof List<?> selectors))continue;
     boolean optional=Integer.valueOf(0).equals(value(a,"require"));
     for(var selector:selectors){String s=selector.toString();int paren=s.indexOf('(');String name=paren<0?s:s.substring(0,paren),desc=paren<0?null:s.substring(paren);
      var methods=target.methods.stream().filter(m->m.name.equals(name)&&(desc==null||desc.equals(m.desc))).toList();
      check(!methods.isEmpty()||optional,"Selector: "+target.name+"."+s);invocation(value(a,"at"),methods,optional);
     }
    }
   }
  }
  for(var jar:jars)jar.close();System.out.println("PASS named mixin selectors/accessors/invocations: "+checks+" checks");
 }
}
