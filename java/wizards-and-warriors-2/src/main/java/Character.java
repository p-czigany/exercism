public class Character {
  private String characterClass;
  private int level;
  private int hitPoints;

  public String getCharacterClass() {
    return characterClass;
  }

  public void setCharacterClass(String characterClass) {
    this.characterClass = characterClass;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public String toString() {
    return String.format(
        "a level %d %s with %d hit points",
        this.getLevel(), this.getCharacterClass(), this.getHitPoints());
  }
}
