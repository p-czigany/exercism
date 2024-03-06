import java.util.stream.IntStream;

public class PangramChecker {

  private static final int N_OF_LETTERS_IN_ALPHABET = 26;
  private static final char FIRST_LETTER = 'a';

  public boolean isPangram(String input) {
    boolean[] lettersPresent =
        input
            .toLowerCase()
            .chars()
            .filter(Character::isLetter)
            .collect(
                () -> new boolean[N_OF_LETTERS_IN_ALPHABET],
                (arr, c) -> arr[c - FIRST_LETTER] = true,
                (arr1, arr2) -> {});

    return IntStream.range(0, lettersPresent.length)
        .mapToObj(i -> lettersPresent[i])
        .allMatch(b -> b);
  }
}
