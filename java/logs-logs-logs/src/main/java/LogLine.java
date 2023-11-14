public class LogLine {

  private final String message;
  private final LogLevel logLevel;

  public LogLine(String logLine) {
    this.message = message(logLine);
    this.logLevel = LogLevel.findByKey(logLevel(logLine));
  }

  private static String logLevel(String logLine) {
    String[] logParts = logLine.split("]: ");
    String levelPart = logParts[0];
    return levelPart.substring(1);
  }

  private static String message(String logLine) {
    String[] logParts = logLine.split("]: ");
    logParts[0] = "";
    return String.join("", logParts).trim();
  }

  public LogLevel getLogLevel() {
    return this.logLevel;
  }

  public String getOutputForShortLog() {
    return String.format("%d:%s", this.logLevel.getNum(), this.message);
  }
}
