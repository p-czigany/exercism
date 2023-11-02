public class ElonsToyCar {
    private int totalDistance = 0;
    private int remainingBattery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", totalDistance);
    }

    public String batteryDisplay() {
        return remainingBattery > 0 ? String.format("Battery at %d%%", remainingBattery) : "Battery empty";
    }

    public void drive() {
        if (remainingBattery > 0) {
            totalDistance += 20;
            remainingBattery -= 1;
        }
    }
}
