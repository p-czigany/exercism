import static java.lang.String.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

  private static final int HOUR_AFTERNOON_BEGINS = 12;
  private static final int HOUR_AFTERNOON_ENDS = 18;

  public LocalDateTime schedule(String appointmentDateDescription) {
    var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    return LocalDateTime.parse(appointmentDateDescription, formatter);
  }

  public boolean hasPassed(LocalDateTime appointmentDate) {
    return appointmentDate.isBefore(LocalDateTime.now());
  }

  public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
    var hour = appointmentDate.getHour();
    return hour >= HOUR_AFTERNOON_BEGINS && hour < HOUR_AFTERNOON_ENDS;
  }

  public String getDescription(LocalDateTime appointmentDate) {
    var formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, uuuu, 'at' h:mm a", Locale.ENGLISH);
    return format("You have an appointment on %s.", appointmentDate.format(formatter));
  }

  public LocalDate getAnniversaryDate() {
    return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
  }
}
