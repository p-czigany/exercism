import java.util.function.BiPredicate;

public class NotEqualsIgnoreCase implements BiPredicate<String, String> {
    @Override
    public boolean test(final String s, final String s2) {
        return !s.equalsIgnoreCase(s2);
    }
}
