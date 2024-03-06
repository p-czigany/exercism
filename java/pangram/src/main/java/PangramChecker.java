public class PangramChecker {

  private static final int N_OF_LETTERS_IN_ALPHABET = 26;

  public boolean isPangram(String input) {
    return input.toLowerCase().chars().filter(Character::isLetter).distinct().count()
        == N_OF_LETTERS_IN_ALPHABET;
  }
}
