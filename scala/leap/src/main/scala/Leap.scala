object Leap {
  implicit class MyInt(val i: Int) {
    def %%(x: Int): Boolean = i % x == 0
  }

  def leapYear(year: Int): Boolean =
    year %% 4 && !(year %% 100) || year %% 400
}
