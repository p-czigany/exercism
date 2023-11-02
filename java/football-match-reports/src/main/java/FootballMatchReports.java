import java.util.AbstractMap;
import java.util.Map;

public class FootballMatchReports {
    private static final Map<Integer, String> SHIRT_NUMBER_ROLES = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(1, "goalie"),
            new AbstractMap.SimpleEntry<>(2, "left back"),
            new AbstractMap.SimpleEntry<>(3, "center back"),
            new AbstractMap.SimpleEntry<>(4, "center back"),
            new AbstractMap.SimpleEntry<>(5, "right back"),
            new AbstractMap.SimpleEntry<>(6, "midfielder"),
            new AbstractMap.SimpleEntry<>(7, "midfielder"),
            new AbstractMap.SimpleEntry<>(8, "midfielder"),
            new AbstractMap.SimpleEntry<>(9, "left wing"),
            new AbstractMap.SimpleEntry<>(10, "striker"),
            new AbstractMap.SimpleEntry<>(11, "right wing")
    );

    public static String onField(int shirtNum) {
        if (!SHIRT_NUMBER_ROLES.containsKey(shirtNum)) throw new IllegalArgumentException();
        return SHIRT_NUMBER_ROLES.get(shirtNum);
    }
}
