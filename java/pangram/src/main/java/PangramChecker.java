public class PangramChecker {

  private static final int NO_OF_LETTERS_IN_ALPHABET = 26;

  public boolean isPangram(String input) {
    boolean[] letterPresent = new boolean[NO_OF_LETTERS_IN_ALPHABET];
    var inputLower = input.toLowerCase();

    for (int i = 0; i < inputLower.length(); i++) {
      char c = inputLower.charAt(i);

      if (Character.isLetter(c) && c >= 'a' && c <= 'z') {
        letterPresent[c - 'a'] = true;
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
