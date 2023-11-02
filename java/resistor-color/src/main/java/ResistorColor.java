import java.util.LinkedHashMap;

class ResistorColor {

    private static final LinkedHashMap<String, Integer> resistances = new LinkedHashMap<>();

    static {
        resistances.put("black", 0);
        resistances.put("brown", 1);
        resistances.put("red", 2);
        resistances.put("orange", 3);
        resistances.put("yellow", 4);
        resistances.put("green", 5);
        resistances.put("blue", 6);
        resistances.put("violet", 7);
        resistances.put("grey", 8);
        resistances.put("white", 9);
    }

    int colorCode(String color) {
        return resistances.get(color);
    }

    String[] colors() {
        return resistances.keySet().toArray(String[]::new);
    }
}
