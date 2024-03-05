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

  public static Magnitude getMagnitude(long number) {
    return getByPowerOfOneThousand(
        Math.min(
            (int) Stream.iterate(number, n -> n >= ONE_THOUSAND, n -> n / ONE_THOUSAND).count(),
            maxPowerOfOneThousand()));
  }

  private static int maxPowerOfOneThousand() {
    return maxMagnitude().getPowerOfOneThousand();
  }

  private static Magnitude maxMagnitude() {
    Magnitude maxEnum = null;
    int maxValue = Integer.MIN_VALUE;

    for (Magnitude enumValue : Magnitude.values()) {
      if (enumValue.getPowerOfOneThousand() > maxValue) {
        maxValue = enumValue.getPowerOfOneThousand();
        maxEnum = enumValue;
      }
    }

    return maxEnum;
  }

  private static Magnitude getByPowerOfOneThousand(int powerOfOneThousand) {
    for (Magnitude magnitude : Magnitude.values()) {
      if (magnitude.getPowerOfOneThousand() == powerOfOneThousand) {
        return magnitude;
      }
    }
    throw new IllegalArgumentException("No enum constant with value " + powerOfOneThousand);
  }

  public int getPowerOfOneThousand() {
    return this.powerOfOneThousand;
  }

  public String getMetricPrefix() {
    return this.metricPrefix;
  }
}
