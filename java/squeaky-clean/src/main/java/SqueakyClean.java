import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SqueakyClean {
    private static final String EMPTY_STRING = "";

    static String clean(String identifier) {
        return fromKebabToCamelCase(identifier
                .replace(' ', '_')
                .replaceAll("\\p{Cc}", "CTRL")
                .replaceAll("[\\p{S}\\dα-ω]", EMPTY_STRING));
    }

    public static String fromKebabToCamelCase(String line) {
        Pattern pattern = Pattern.compile(".*(-\\p{L}).*");
        Matcher matcher = pattern.matcher(line);
        while (matcher.matches()) {
            String substitute = matcher.group(1).replace("-", EMPTY_STRING).toUpperCase();
            line = replaceSubstring(line, substitute, matcher.start(1));
            matcher = pattern.matcher(line);
        }
        return line;
    }

    private static String replaceSubstring(String str, String substring, int index) {
        return str.substring(0, index) + substring + str.substring(index + 2);
    }
}
