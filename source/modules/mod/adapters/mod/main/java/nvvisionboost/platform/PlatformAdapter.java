package nvvisionboost.platform;

import java.nio.file.Path;

/** Loader contract. No Minecraft/rendering classes or network registration. */
public interface PlatformAdapter {
  String loader();

  Path gameDirectory();

  Path configDirectory();

  boolean client();

  boolean modLoaded(String id);
}
