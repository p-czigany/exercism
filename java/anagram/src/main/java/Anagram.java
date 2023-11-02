import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    private final String baseWord;
    private final char[] sortedBaseLetters;

    public Anagram(String baseWord) {
        this.baseWord = baseWord.toLowerCase();
        this.sortedBaseLetters = toSortedCharArray(baseWord);
    }

    public List<String> match(List<String> list) {

        return list.stream()
                .filter(word -> !baseWord.equalsIgnoreCase(word))
                .filter(word -> Arrays.equals(sortedBaseLetters, toSortedCharArray(word)))
                .collect(Collectors.toList());
    }

    private char[] toSortedCharArray(String word) {
        char[] letters = word.toLowerCase().toCharArray();
        Arrays.sort(letters);
        return letters;
    }

}
