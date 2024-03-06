import java.util.Map;
import java.util.stream.Stream;

class ResistorColorTrio {

  private enum Magnitude {
    BASE(0, ""),
    KILO(1, "kilo"),
    MEGA(2, "mega"),
    GIGA(3, "giga");

    private final int powerOfOneThousand;
    private final String metricPrefix;
    private static final int ONE_MAGNITUDE = 1000;

    Magnitude(int powerOfOneThousand, String metricPrefix) {
      this.powerOfOneThousand = powerOfOneThousand;
      this.metricPrefix = metricPrefix;
    }

    private int getPowerOfOneThousand() {
      return this.powerOfOneThousand;
    }

    private String getMetricPrefix() {
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

    private static Magnitude getMagnitude(long number) {
      return getByPowerOfOneThousand(
          Math.min(
              (int) Stream.iterate(number, n -> n >= ONE_MAGNITUDE, n -> n / ONE_MAGNITUDE).count(),
              maxPowerOfOneThousand()));
    }

    private static String convertToNotation(long number) {
      var magnitude = getMagnitude(number);
      return String.format(
          "%d %s",
          number / (int) Math.pow(ONE_MAGNITUDE, magnitude.getPowerOfOneThousand()),
          magnitude.getMetricPrefix());
    }
  }

  private static final Map<String, Integer> COLOR_CODES =
      Map.of(
          "black", 0,
          "brown", 1,
          "red", 2,
          "orange", 3,
          "yellow", 4,
          "green", 5,
          "blue", 6,
          "violet", 7,
          "grey", 8,
          "white", 9);

  private int colorCode(String color) {
    return COLOR_CODES.get(color);
  }

  private int valueOfFirstTwo(String[] colors) {
    return 10 * colorCode(colors[0]) + colorCode(colors[1]);
  }

  private long value(String[] colors) {
    return valueOfFirstTwo(colors) * (long) Math.pow(10, colorCode(colors[2]));
  }

  String label(String[] colors) {
    return String.format("%sohms", Magnitude.convertToNotation(value(colors)));
  }
}
