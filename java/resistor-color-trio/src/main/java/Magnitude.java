import java.util.stream.Stream;

public enum Magnitude {
  BASE(0, ""),
  KILO(1, "kilo"),
  MEGA(2, "mega"),
  GIGA(3, "giga");

  private final int powerOfOneThousand;
  private final String metricPrefix;
  private static final int ONE_THOUSAND = 1000;

  Magnitude(int powerOfOneThousand, String metricPrefix) {
    this.powerOfOneThousand = powerOfOneThousand;
    this.metricPrefix = metricPrefix;
  }

  public int getPowerOfOneThousand() {
    return this.powerOfOneThousand;
  }

  public String getMetricPrefix() {
    return this.metricPrefix;
  }

  private static Magnitude getByPowerOfOneThousand(int powerOfOneThousand) {
    for (Magnitude magnitude : Magnitude.values()) {
      if (magnitude.getPowerOfOneThousand() == powerOfOneThousand) {
        return magnitude;
      }
    }
    throw new IllegalArgumentException("No enum constant with value " + powerOfOneThousand);
  }

  private static int maxPowerOfOneThousand() {
    return Stream.of(Magnitude.values())
        .mapToInt(Magnitude::getPowerOfOneThousand)
        .max()
        .orElse(Integer.MIN_VALUE);
  }

  public static Magnitude getMagnitude(long number) {
    return getByPowerOfOneThousand(
        Math.min(
            (int) Stream.iterate(number, n -> n >= ONE_THOUSAND, n -> n / ONE_THOUSAND).count(),
            maxPowerOfOneThousand()));
  }

  public static String convertToNotation(long number) {
    var magnitude = getMagnitude(number);
    return String.format(
        "%d %s",
        number / (int) Math.pow(ONE_THOUSAND, magnitude.getPowerOfOneThousand()),
        magnitude.getMetricPrefix());
  }
}
