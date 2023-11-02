import java.util.AbstractMap;
import java.util.Map;

public class CarsAssemble {
    private static int SPEED_RATIO = 221;
    private static int MINUTES_PER_HOUR = 60;
    private static Map<Integer, Double> SUCCESS_RATES = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(0, 1.00),
            new AbstractMap.SimpleEntry<>(1, 1.00),
            new AbstractMap.SimpleEntry<>(2, 1.00),
            new AbstractMap.SimpleEntry<>(3, 1.00),
            new AbstractMap.SimpleEntry<>(4, 1.00),
            new AbstractMap.SimpleEntry<>(5, 0.90),
            new AbstractMap.SimpleEntry<>(6, 0.90),
            new AbstractMap.SimpleEntry<>(7, 0.90),
            new AbstractMap.SimpleEntry<>(8, 0.90),
            new AbstractMap.SimpleEntry<>(9, 0.80),
            new AbstractMap.SimpleEntry<>(10, 0.77)
    );

    public double productionRatePerHour(int speed) {
        return speed * SPEED_RATIO * SUCCESS_RATES.get(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / MINUTES_PER_HOUR;
    }
}
