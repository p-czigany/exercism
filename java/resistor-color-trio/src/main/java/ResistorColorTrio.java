import java.util.Map;
import java.util.stream.Stream;

class ResistorColorTrio {

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

  private String convertToNotation(long number) {
    var suffixes = new String[] {"", "kilo", "mega", "giga"};

    var magnitude = (int) Stream.iterate(number, n -> n >= 1000, n -> n / 1000).count();

    return number / (int) Math.pow(1000, magnitude) + " " + suffixes[magnitude];
  }

  String label(String[] colors) {
    return String.format("%sohms", convertToNotation(value(colors)));
  }
}
