import java.io.File;
import java.util.jar.JarFile;
import net.minecraftforge.renamer.api.ClassProvider;
import net.minecraftforge.renamer.api.Renamer;
/** Uses the official renamer API with a read-only JarFile class provider.
 * Avoids the Windows ZipFS cleanup failure without changing mapping behavior. */
public class MemoryRemap {
 public static void main(String[] args)throws Exception{
  var classes=ClassProvider.builder();
  try(var jar=new JarFile(args[3])){
   var entries=jar.entries();while(entries.hasMoreElements()){
    var e=entries.nextElement();if(!e.getName().endsWith(".class"))continue;
    try(var in=jar.getInputStream(e)){classes.addClass(e.getName().substring(0,e.getName().length()-6),in.readAllBytes());}
   }
  }
  try(var renamer=Renamer.builder().addClassProvider(classes.build()).withJvmClasspath().map(new File(args[2])).threads(4).build()){
   renamer.run(new File(args[0]),new File(args[1]));
  }
  System.out.println("PASS: bytecode remapped with in-memory inheritance provider");
 }
}
