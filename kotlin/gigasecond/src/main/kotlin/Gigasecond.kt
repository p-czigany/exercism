import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Gigasecond(localDateTime: LocalDateTime) {

    private val secondsInAGigasecond = 1_000_000_000L

    constructor(localDate: LocalDate, localTime: LocalTime = LocalTime.MIN) : this(
        LocalDateTime.of(
            localDate.year,
            localDate.month,
            localDate.dayOfMonth,
            localTime.hour,
            localTime.minute,
            localTime.second,
            localTime.nano
        )
    )

    val date: LocalDateTime = localDateTime.plusSeconds(secondsInAGigasecond)
}
