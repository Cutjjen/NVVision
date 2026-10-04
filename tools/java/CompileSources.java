import java.util.*;
import javax.tools.*;
public class CompileSources {
 public static void main(String[] args) {
  JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
  StandardJavaFileManager manager=compiler.getStandardFileManager(null,null,java.nio.charset.StandardCharsets.UTF_8);
  List<String> files=Arrays.asList(args).subList(2,args.length);
  List<JavaFileObject> sources=new ArrayList<>();
  for(String name:files){java.nio.file.Path path=java.nio.file.Path.of(name); sources.add(new SimpleJavaFileObject(path.toUri(),JavaFileObject.Kind.SOURCE){public CharSequence getCharContent(boolean ignore)throws java.io.IOException{return java.nio.file.Files.readString(path);}});}
  String cp=args[0]; if(cp.startsWith("@")) { try { cp=java.nio.file.Files.readString(java.nio.file.Path.of(cp.substring(1))); } catch(Exception e) { throw new RuntimeException(e); } } if(cp.endsWith("/*")){try(var paths=java.nio.file.Files.list(java.nio.file.Path.of(cp.substring(0,cp.length()-2)))){cp=paths.filter(p->p.toString().endsWith(".jar")).map(Object::toString).collect(java.util.stream.Collectors.joining(";"));}catch(Exception e){throw new RuntimeException(e);}}
  boolean ok=compiler.getTask(null,manager,null,List.of("-proc:none","--release",System.getProperty("compile.release","17"),"-encoding","UTF-8","-classpath",cp,"-d",args[1]),null,sources).call();
  System.out.println("Compilation result: "+ok);System.exit(ok?0:1);
 }
}
