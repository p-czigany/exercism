import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

  /** any length of dashes, undescores and whitespace */
  private static final String REGEX_DELINEATING_WORDS = "[-_ ]+";

  private final String phrase;
  private String abbreviation;

  Acronym(String phrase) {
    this.phrase = phrase;
  }

  private void createAcronym() {
    abbreviation =
        Arrays.stream(phrase.split(REGEX_DELINEATING_WORDS))
            .map(word -> String.valueOf(word.charAt(0)))
            .collect(Collectors.joining())
            .toUpperCase();
  }

  String get() {
    if (abbreviation == null) {
      createAcronym();
    }
    return abbreviation;
  }
}
