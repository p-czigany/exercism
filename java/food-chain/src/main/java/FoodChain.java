import java.util.ArrayList;
import java.util.List;

class FoodChain {

  private static final List<List<String>> POSSIBLE_LINES =
      List.of(
          List.of("fly", "I don't know why she swallowed the fly. Perhaps she'll die."),
          List.of(
              "spider that wriggled and jiggled and tickled inside her",
              "It wriggled and jiggled and tickled inside her."),
          List.of("bird", "How absurd to swallow a bird!"),
          List.of("cat", "Imagine that, to swallow a cat!"),
          List.of("dog", "What a hog, to swallow a dog!"),
          List.of("goat", "Just opened her throat and swallowed a goat!"),
          List.of("cow", "I don't know how she swallowed a cow!"),
          List.of("horse", "She's dead, of course!"));

  private static final String FIRST_LINE_OF_VERSE = "I know an old lady who swallowed a %s.";
  private static final String CAUSE = "She swallowed the %s to catch the %s.";

  String verse(int verse) {
    List<String> lines = new ArrayList<>();
    addFirstLineOfVerse(lines, verse);
    addSecondLineOfVerse(lines, verse);
    if (verse != 8) {
      addCauseLinesOfVerse(lines, verse);
      addLastCauseLineOfVerse(lines);
    }
    return String.join("\n", lines);
  }

  private void addFirstLineOfVerse(List<String> verseLines, int verse) {
    verseLines.add(
        String.format(FIRST_LINE_OF_VERSE, POSSIBLE_LINES.get(verse - 1).get(0).split(" ", 2)[0]));
  }

  private void addSecondLineOfVerse(List<String> verseLines, int verse) {
    if (verse > 1) {
      verseLines.add(POSSIBLE_LINES.get(verse - 1).get(1));
    }
  }

  private void addCauseLinesOfVerse(List<String> verseLines, int verse) {
    for (int i = verse; i > 1; i--) {
      verseLines.add(
          String.format(
              CAUSE,
              POSSIBLE_LINES.get(i - 1).get(0).split(" ", 2)[0],
              POSSIBLE_LINES.get(i - 2).get(0)));
    }
  }

  private void addLastCauseLineOfVerse(List<String> verseLines) {
    verseLines.add(POSSIBLE_LINES.get(0).get(1));
  }

  String verses(int startVerse, int endVerse) {
    List<String> verses = new ArrayList<>();
    for (int verse = startVerse; verse <= endVerse; verse++) {
      verses.add(verse(verse));
    }
    return String.join("\n\n", verses);
  }
}
