class AssemblyLine
  SPEED_RATIO = 221
  MINUTES_PER_HOUR = 60
  SUCCESS_RATES = {
    "0": 1.00,
    "1": 1.00,
    "2": 1.00,
    "3": 1.00,
    "4": 1.00,
    "5": 0.90,
    "6": 0.90,
    "7": 0.90,
    "8": 0.90,
    "9": 0.80,
    "10": 0.77
  }

  def initialize(speed)
    @speed = speed
  end

  def production_rate_per_hour
    @speed * SPEED_RATIO * success_rate(@speed)
  end

  def working_items_per_minute
    (production_rate_per_hour / MINUTES_PER_HOUR).floor
  end

  def success_rate(speed)
    SUCCESS_RATES[speed.to_s.to_sym]
  end
end
