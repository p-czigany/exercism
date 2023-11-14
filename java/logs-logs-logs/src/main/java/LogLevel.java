import java.util.Arrays;

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
    return Arrays.stream(LogLevel.values())
        .filter(logLevel -> key.equals(logLevel.key))
        .findFirst()
        .orElse(LogLevel.UNKNOWN);
  }

  public int getNum() {
    return this.num;
  }
}
