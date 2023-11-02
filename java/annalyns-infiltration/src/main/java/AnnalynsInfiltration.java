class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return !archerIsAwake && prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        return canFight(archerIsAwake, petDogIsPresent) || canSneak(knightIsAwake, archerIsAwake, prisonerIsAwake);
    }

    private static boolean canFight(boolean archerIsAwake, boolean petDogIsPresent) {
        return !archerIsAwake && petDogIsPresent;
    }

    private static boolean canSneak(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return canSignalPrisoner(archerIsAwake, prisonerIsAwake) && canFastAttack(knightIsAwake);
    }
}
