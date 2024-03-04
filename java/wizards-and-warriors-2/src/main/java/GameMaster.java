import static java.lang.String.format;
import static java.lang.String.join;

public class GameMaster {

  private static final TravelMethod DEFAULT_TRAVEL_METHOD = TravelMethod.WALKING;

  public String describe(Character character) {
    return format("You're %s.", character);
  }

  public String describe(Destination destination) {
    return format("You've arrived at %s.", destination);
  }

  public String describe(TravelMethod travelMethod) {
    return format("You're traveling to your destination %s.", travelMethod);
  }

  public String describe(Character character, Destination destination, TravelMethod travelMethod) {
    return join(" ", describe(character), describe(travelMethod), describe(destination));
  }

  public String describe(Character character, Destination destination) {
    return describe(character, destination, DEFAULT_TRAVEL_METHOD);
  }
}
