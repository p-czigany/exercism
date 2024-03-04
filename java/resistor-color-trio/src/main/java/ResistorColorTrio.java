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

  String label(String[] colors) {
    var value = value(colors);
    if (value == 0) return format("%d ohms", value);
    if (value % (int) Math.pow(10, 9) == 0) {
      return format("%d gigaohms", value / (int) Math.pow(10, 9));
    }
    if (value % (int) Math.pow(10, 6) == 0) {
      return format("%d megaohms", value / (int) Math.pow(10, 6));
    }
    if (value % (int) Math.pow(10, 3) == 0) {
      return format("%d kiloohms", value / (int) Math.pow(10, 3));
    }
    if (value % (int) Math.pow(10, 0) == 0) {
      return format("%d ohms", value / (int) Math.pow(10, 0));
    }
    return format("%d ohms", value);
  }
}
