import java.util.ArrayList;
import java.util.List;

class FoodChain {

  private static final List<List<String>> POSSIBLE_LINES =
      List.of(
          List.of(
              "fly",
              "I know an old lady who swallowed a %s.",
              "I don't know why she swallowed the fly. Perhaps she'll die."),
          List.of(
              "spider",
              "It wriggled and jiggled and tickled inside her.",
              "She swallowed the spider to catch the fly."),
          List.of(
              "bird",
              "How absurd to swallow a bird!",
              "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her."),
          List.of(
              "cat",
              "Imagine that, to swallow a cat!",
              "She swallowed the cat to catch the bird."));

  String verse(int verse) {
    List<String> lines = new ArrayList<>();
    addFirstLineOfVerse(lines, verse);
    addSecondLineOfVerse(lines, verse);
    addCauseLinesOfVerse(lines, verse);
    return String.join("\n", lines);
  }

  private void addFirstLineOfVerse(List<String> verseLines, int verse) {
    verseLines.add(
        String.format(POSSIBLE_LINES.get(0).get(1), POSSIBLE_LINES.get(verse - 1).get(0)));
  }

  private void addSecondLineOfVerse(List<String> verseLines, int verse) {
    if (verse > 1) {
      verseLines.add(POSSIBLE_LINES.get(verse - 1).get(1));
    }
  }

  private void addCauseLinesOfVerse(List<String> verseLines, int verse) {
    for (int i = verse; i > 0; i--) {
      verseLines.add(POSSIBLE_LINES.get(i - 1).get(2));
    }
  }

  String verses(int startVerse, int endVerse) {
    throw new UnsupportedOperationException(
        "Delete this statement and write your own implementation.");
  }
}
