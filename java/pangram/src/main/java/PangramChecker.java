public class PangramChecker {

  private static final int NO_OF_LETTERS_IN_ALPHABET = 26;
  private static final char FIRST_LETTER = 'a';
  private static final char LAST_LETTER = 'z';

  public boolean isPangram(String input) {
    boolean[] letterPresent = new boolean[NO_OF_LETTERS_IN_ALPHABET];
    var inputLower = input.toLowerCase();

    for (int i = 0; i < inputLower.length(); i++) {
      char c = inputLower.charAt(i);

      if (Character.isLetter(c) && c >= FIRST_LETTER && c <= LAST_LETTER) {
        letterPresent[c - FIRST_LETTER] = true;
      }
    }

    for (int i = 0; i < NO_OF_LETTERS_IN_ALPHABET; i++) {
      if (!letterPresent[i]) {
        return false;
      }
    }

    return true;
  }
}
