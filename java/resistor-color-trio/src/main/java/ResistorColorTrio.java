import static java.lang.String.format;

import java.util.LinkedHashMap;

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

  private String convertToEngineeringNotation(long number) {
    if (number < 1000) {
      return number + " ";
    } else if (number < 1000000) {
      return number / 1000 + " kilo";
    } else if (number < 1000000000) {
      return number / 1000000 + " mega";
    } else {
      return number / 1000000000 + " giga";
    }
  }

  String label(String[] colors) {
    return format("%sohms", convertToEngineeringNotation(value(colors)));
  }
}
