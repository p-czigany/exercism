import java.util.Map;

public class GameMaster {

  private static final Map<TravelMethod, String> TRAVELLING_WORDS =
      Map.of(
          TravelMethod.WALKING, "by walking",
          TravelMethod.HORSEBACK, "on horseback");

  private static final TravelMethod DEFAULT_TRAVEL_METHOD = TravelMethod.WALKING;

  public String describe(Character character) {
    return "You're a level %d %s with %d hit points."
        .formatted(character.getLevel(), character.getCharacterClass(), character.getHitPoints());
  }

  public String describe(Destination destination) {
    return "You've arrived at %s, which has %d inhabitants."
        .formatted(destination.getName(), destination.getInhabitants());
  }

  public String describe(TravelMethod travelMethod) {
    return "You're traveling to your destination %s.".formatted(TRAVELLING_WORDS.get(travelMethod));
  }

  public String describe(Character character, Destination destination, TravelMethod travelMethod) {
    return String.join(" ", describe(character), describe(travelMethod), describe(destination));
  }

  public String describe(Character character, Destination destination) {
    return describe(character, destination, DEFAULT_TRAVEL_METHOD);
  }
}
