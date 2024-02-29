# frozen_string_literal: true

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
end
