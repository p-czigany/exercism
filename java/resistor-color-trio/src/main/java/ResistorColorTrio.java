import static java.lang.String.format;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

class ResistorColorTrio {

  private static final LinkedHashMap<String, Integer> COLOR_CODES = new LinkedHashMap<>();

  static {
    COLOR_CODES.put("black", 0);
    COLOR_CODES.put("brown", 1);
    COLOR_CODES.put("red", 2);
    COLOR_CODES.put("orange", 3);
    COLOR_CODES.put("yellow", 4);
    COLOR_CODES.put("green", 5);
    COLOR_CODES.put("blue", 6);
    COLOR_CODES.put("violet", 7);
    COLOR_CODES.put("grey", 8);
    COLOR_CODES.put("white", 9);
  }

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
    return format("%sohms", convertToNotation(value(colors)));
  }
}
