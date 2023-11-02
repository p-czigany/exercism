public class Lasagna {
    private static final int COOKING_TIME_IN_MINUTES = 40;
    private static final int PREPARATION_TIME_OF_ONE_LAYER_IN_MINUTES = 2;

    public int expectedMinutesInOven() {
        return COOKING_TIME_IN_MINUTES;
    }

    public int remainingMinutesInOven(int actualMinutes) {
        return COOKING_TIME_IN_MINUTES - actualMinutes;
    }

    public int preparationTimeInMinutes(int amountLayers) {
        return amountLayers * PREPARATION_TIME_OF_ONE_LAYER_IN_MINUTES;
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        return preparationTimeInMinutes(amountLayers) + actualMinutes;
    }
}
