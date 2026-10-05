package net.minecraft.client;

public final class Minecraft {
  public static final Minecraft INSTANCE = new Minecraft();
  public final Options options = new Options();
  public Object level = new Object();

  public static Minecraft getInstance() {
    return INSTANCE;
  }

  public boolean sameThread = true;
  public Runnable pending;

  public boolean isSameThread() {
    return sameThread;
  }

  public void execute(Runnable r) {
    pending = r;
  }

  public void drain() {
    sameThread = true;
    var task = pending;
    pending = null;
    task.run();
  }

  public static final class Value<T> {
    private T value;

    Value(T v) {
      value = v;
    }

    public T get() {
      return value;
    }

    public void set(T v) {
      if (v instanceof Double d && (d < .5 || d > 5))
        throw new AssertionError("Invalid Minecraft option " + d);
      value = v;
    }
  }

  public static final class Options {
    private final Value<Double> distance = new Value<>(1.0);
    private final Value<ParticleStatus> particles = new Value<>(ParticleStatus.ALL);

    public Value<Double> entityDistanceScaling() {
      return distance;
    }

    public Value<ParticleStatus> particles() {
      return particles;
    }

    public int saves;

    public void save() {
      saves++;
    }
  }
}
