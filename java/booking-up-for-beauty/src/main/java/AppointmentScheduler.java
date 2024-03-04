import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {

  private static final int HOUR_AFTERNOON_BEGINS = 12;
  private static final int HOUR_AFTERNOON_ENDS = 18;
  private static final String SCHEDULE_MESSAGE_FORMAT = "MM/dd/yyyy HH:mm:ss";
  private static final String APPOINTMENT_MESSAGE_FORMAT =
      "'You have an appointment on 'EEEE, MMMM d, uuuu, 'at' h:mm a'.'";

  private static final DateTimeFormatter SCHEDULE_FORMATTER =
      DateTimeFormatter.ofPattern(SCHEDULE_MESSAGE_FORMAT);
  private static final DateTimeFormatter APPOINTMENT_FORMATTER =
      DateTimeFormatter.ofPattern(APPOINTMENT_MESSAGE_FORMAT, Locale.ENGLISH);

  public LocalDateTime schedule(String appointmentDateDescription) {
    return LocalDateTime.parse(appointmentDateDescription, SCHEDULE_FORMATTER);
  }

  public boolean hasPassed(LocalDateTime appointmentDate) {
    return appointmentDate.isBefore(LocalDateTime.now());
  }

  public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
    var hour = appointmentDate.getHour();
    return hour >= HOUR_AFTERNOON_BEGINS && hour < HOUR_AFTERNOON_ENDS;
  }

  public String getDescription(LocalDateTime appointmentDate) {
    return appointmentDate.format(APPOINTMENT_FORMATTER);
  }

  public LocalDate getAnniversaryDate() {
    return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
  }
}
