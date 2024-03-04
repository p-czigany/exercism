public enum TravelMethod {
  WALKING("by walking"),
  HORSEBACK("on horseback");

  private final String value;

  TravelMethod(String value) {
    this.value = value;
  }

  public String toString() {
    return value.toLowerCase();
  }
}
