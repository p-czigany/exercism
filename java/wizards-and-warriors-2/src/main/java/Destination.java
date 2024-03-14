public class Destination {
  private String name;
  private int inhabitants;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getInhabitants() {
    return inhabitants;
  }

  public void setInhabitants(int inhabitants) {
    this.inhabitants = inhabitants;
  }

//  @Override
//  public String toString() {
//    return "%s, which has %d inhabitants".formatted(this.getName(), this.getInhabitants());
//  }
}
