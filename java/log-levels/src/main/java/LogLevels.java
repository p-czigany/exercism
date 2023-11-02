public class LogLevels {

    public static String message(String logLine) {
        String[] logParts = logLine.split("]: ");
        logParts[0] = "";
        return String.join("", logParts).trim();
    }

    public static String logLevel(String logLine) {
        String[] logParts = logLine.split("]: ");
        String levelPart = logParts[0];
        return levelPart.substring(1).toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
