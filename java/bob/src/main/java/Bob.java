import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Bob {

    private static final Pattern shoutingPattern = Pattern.compile("^[^a-z]*[A-Z][^a-z]*$");
    private static final Pattern askingPattern = Pattern.compile("^.+\\?\\s*$");
    private static final Predicate<String> shouting = hello -> shoutingPattern.matcher(hello).find();
    private static final Predicate<String> asking = hello -> askingPattern.matcher(hello).find();
    private static final Predicate<String> silent = String::isBlank;

    public String hey(String hello) {
        boolean isSilent = silent.test(hello);
        if (isSilent) {
            return "Fine. Be that way!";
        }
        boolean isAsking = asking.test(hello);
        boolean isShouting = shouting.test(hello);
        if (isAsking) {
            if (isShouting) {
                return "Calm down, I know what I'm doing!";
            }
            return "Sure.";
        }
        if (isShouting) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }

}
