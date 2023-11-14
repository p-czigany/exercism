
public enum LogLevel {
  TRACE(1, "TRC"),
  DEBUG(2, "DBG"),
  INFO(4, "INF"),
  WARNING(5, "WRN"),
  ERROR(6, "ERR"),
  FATAL(42, "FTL"),
  UNKNOWN(0, null);

  private final int num;
  private final String key;

  LogLevel(int num, String key) {
    this.num = num;
    this.key = key;
  }

  public static LogLevel findByKey(String key) {
    LogLevel[] logLevels = LogLevel.values();
    for (LogLevel logLevel : logLevels) {
      if (key.equals(logLevel.key)) {
        return logLevel;
      }
    }
    return LogLevel.UNKNOWN;
  }

  public int getNum() {
    return this.num;
  }
}
