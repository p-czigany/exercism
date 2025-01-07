import java.util.Arrays;
import java.util.function.BiPredicate;

public class Anagrams implements BiPredicate<String, String> {
    @Override
    public boolean test(final String s, final String s2) {
        char[] c = s.toLowerCase().toCharArray();
        char[] c2 = s2.toLowerCase().toCharArray();
        Arrays.sort(c);
        Arrays.sort(c2);
        return Arrays.equals(c, c2);
    }
}
