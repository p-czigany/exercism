import static java.lang.String.format;

public class GameMaster {

  public String describe(Character character) {
    return format(
        "You're a level %d %s with %d hit points.",
        character.getLevel(), character.getCharacterClass(), character.getHitPoints());
  }

  public String describe(Destination destination) {
    return format(
        "You've arrived at %s, which has %d inhabitants.",
        destination.getName(), destination.getInhabitants());
  }

  // TODO: define a 'describe' method that returns a description of a TravelMethod

  // TODO: define a 'describe' method that returns a description of a Character, Destination and
  // TravelMethod

  // TODO: define a 'describe' method that returns a description of a Character and Destination
}
