import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

class ResistorColorTrio {

  enum ResistanceUnit {
    OHM(1, "ohms"),
    KILO_OHM(1000, "kiloohms"),
    MEGA_OHM(1000_000, "megaohms"),
    GIGA_OHM(1000_000_000, "gigaohms");

    private final long multiplier;
    private final String unit;

    ResistanceUnit(int multiplier, String unit) {
      this.multiplier = multiplier;
      this.unit = unit;
    }

    private static ResistanceUnit forValue(long value) {
      return Arrays.stream(ResistanceUnit.values())
          .sorted(Comparator.reverseOrder())
          .filter(u -> value > u.multiplier)
          .findFirst()
          .orElse(ResistanceUnit.OHM);
    }

    private String format(long value) {
      return "%d %s".formatted((value / multiplier), unit);
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
    long value = value(colors);
    return ResistanceUnit.forValue(value).format(value);
  }
}
