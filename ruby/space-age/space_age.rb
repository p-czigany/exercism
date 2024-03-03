class SpaceAge
  SECONDS_IN_A_MINUTE = 60
  MINUTES_IN_AN_HOUR = 60
  HOURS_IN_A_DAY = 24
  DAYS_IN_AN_EARTH_YEAR = 365.25
  SECONDS_IN_EARTH_YEAR = SECONDS_IN_A_MINUTE * MINUTES_IN_AN_HOUR * HOURS_IN_A_DAY * DAYS_IN_AN_EARTH_YEAR
  ORBITAL_PERIOD_IN_EARTH_YEAR = {
    'Earth' => 1,
    'Mercury' => 0.2408467,
    'Venus' => 0.61519726,
    'Mars' => 1.8808158,
    'Jupiter' => 11.862615,
    'Saturn' => 29.447498,
    'Uranus' => 84.016846,
    'Neptune' => 164.79132
  }.freeze

  private

  attr_reader :seconds

  def initialize(seconds)
    @seconds = seconds
  end

  def on_planet(planet)
    seconds / SECONDS_IN_EARTH_YEAR / ORBITAL_PERIOD_IN_EARTH_YEAR[planet]
  end

  public

  ORBITAL_PERIOD_IN_EARTH_YEAR.each do |planet, _period|
    define_method("on_#{planet.downcase}") { on_planet planet }
  end
end
