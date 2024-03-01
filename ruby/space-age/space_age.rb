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

  def initialize(seconds)
    @seconds = seconds
  end

  def on_earth
    @seconds / SECONDS_IN_A_MINUTE / MINUTES_IN_AN_HOUR / HOURS_IN_A_DAY / DAYS_IN_AN_EARTH_YEAR
  end

  def on_mercury
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Mercury']
  end

  def on_venus
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Venus']
  end

  def on_mars
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Mars']
  end

  def on_jupiter
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Jupiter']
  end

  def on_saturn
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Saturn']
  end

  def on_uranus
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Uranus']
  end

  def on_neptune
    on_earth / ORBITAL_PERIOD_IN_EARTH_YEAR['Neptune']
  end
end
