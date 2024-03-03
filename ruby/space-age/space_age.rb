class SpaceAge
  SECONDS_IN_A_MINUTE = 60
  MINUTES_IN_AN_HOUR = 60
  HOURS_IN_A_DAY = 24
  DAYS_IN_AN_EARTH_YEAR = 365.25
  ORBITAL_PERIOD_IN_EARTH_YEAR = {
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
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR[planet]
  end

  public

  def on_earth
    seconds / SECONDS_IN_A_MINUTE / MINUTES_IN_AN_HOUR / HOURS_IN_A_DAY / DAYS_IN_AN_EARTH_YEAR
  end

  def on_mercury
    on_planet 'Mercury'
  end

  def on_venus
    on_planet 'Venus'
  end

  def on_mars
    on_planet 'Mars'
  end

  def on_jupiter
    on_planet 'Jupiter'
  end

  def on_saturn
    on_planet 'Saturn'
  end

  def on_uranus
    on_planet 'Uranus'
  end

  def on_neptune
    on_planet 'Neptune'
  end
end
