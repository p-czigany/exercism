import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;
    private final int[] lastWeek = new int[]{0, 2, 5, 3, 7, 8, 4};

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return lastWeek;
    }

    public int getToday() {
        return birdsPerDay.length > 0 ? birdsPerDay[birdsPerDay.length - 1] : 0;
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] = getToday() + 1;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).anyMatch(n -> n == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(Arrays.copyOfRange(birdsPerDay, 0, numberOfDays)).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay).filter(n -> n >= 5).count();
    }
}
