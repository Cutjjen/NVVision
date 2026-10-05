import java.io.File;
import java.nio.file.Path;
import net.minecraftforge.renamer.relocated.net.minecraftforge.srgutils.IMappingFile;

/** Convert official named-to-obfuscated Mojang mappings for the read-only remapper workflow. */
public final class OfficialMinecraftMappings {
  public static void main(String[] args) throws Exception {
    IMappingFile.load(new File(args[0]))
        .reverse()
        .write(Path.of(args[1]), IMappingFile.Format.TSRG, false);
    System.out.println("PASS official obfuscated-to-named mapping conversion");
  }
}
