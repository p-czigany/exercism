import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Anagram {
    private final BiPredicate<String, String> anagrams;
    private final BiPredicate<String, String> notSimilar;
    private final String baseWord;

    public Anagram(final String baseWord,
                   final BiPredicate<String, String> anagrams,
                   final BiPredicate<String, String> notSimilar) {
        this.baseWord = baseWord;
        this.anagrams = anagrams;
        this.notSimilar = notSimilar;
    }

    public Anagram(final String baseWord) {
        this(baseWord, new Anagrams(), new NotEqualsIgnoreCase());
    }

    public List<String> match(final List<String> list) {

        return list.stream()
                .filter(candidate -> notSimilar.test(baseWord, candidate))
                .filter(candidate -> anagrams.test(baseWord, candidate))
                .collect(Collectors.toList());
    }
}
