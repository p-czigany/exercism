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
    var day = wordInTitleCase(appointmentDate.getDayOfWeek().toString());
    var month = wordInTitleCase(appointmentDate.getMonth().toString());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
    return format(
        "You have an appointment on %s, %s %d, %d, at %s.",
        day,
        month,
        appointmentDate.getDayOfMonth(),
        appointmentDate.getYear(),
        appointmentDate.format(formatter));
  }

  private String wordInTitleCase(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }

  public LocalDate getAnniversaryDate() {
    return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
  }
}
