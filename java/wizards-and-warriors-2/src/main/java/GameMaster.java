public class GameMaster {
  private static final TravelMethod DEFAULT_TRAVEL_METHOD = TravelMethod.WALKING;

  public String describe(Character character) {
    return "You're %s.".formatted(character);
  }

  public String describe(Destination destination) {
    return "You've arrived at %s.".formatted(destination);
  }

  public String describe(TravelMethod travelMethod) {
    return "You're traveling to your destination %s.".formatted(travelMethod);
  }

  public String describe(Character character, Destination destination, TravelMethod travelMethod) {
    return String.join(" ", describe(character), describe(travelMethod), describe(destination));
  }

  public String describe(Character character, Destination destination) {
    return describe(character, destination, DEFAULT_TRAVEL_METHOD);
  }
}
