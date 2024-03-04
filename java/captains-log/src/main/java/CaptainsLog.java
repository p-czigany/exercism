import java.util.Random;

class CaptainsLog {

  private static final char[] PLANET_CLASSES =
      new char[] {'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

  private Random random;

  CaptainsLog(Random random) {
    this.random = random;
  }

  char randomPlanetClass() {
    return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
  }

  String randomShipRegistryNumber() {
    throw new UnsupportedOperationException(
        "Please implement the CaptainsLog.randomShipRegistryNumber() method");
  }

  double randomStardate() {
    throw new UnsupportedOperationException(
        "Please implement the CaptainsLog.randomStardate() method");
  }
}
