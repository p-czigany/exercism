import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

  /** any length of dashes, undescores and whitespace */
  private static final String REGEX_DELINEATING_WORDS = "[-_ ]+";

  private final String abbreviation;

  Acronym(String phrase) {
    this.abbreviation = abbreviate(phrase);
  }

  private String abbreviate(String phrase) {
    return Arrays.stream(phrase.split(REGEX_DELINEATING_WORDS))
        .map(word -> String.valueOf(word.charAt(0)))
        .collect(Collectors.joining())
        .toUpperCase();
  }

  String get() {
    return abbreviation;
  }
}
