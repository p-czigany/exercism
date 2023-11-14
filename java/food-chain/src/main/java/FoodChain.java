import java.util.ArrayList;
import java.util.List;

class FoodChain {

  private static final List<List<String>> ANIMALS_AND_OUTCRIES =
      List.of(
          List.of("fly"),
          List.of(
              "spider that wriggled and jiggled and tickled inside her",
              "It wriggled and jiggled and tickled inside her."),
          List.of("bird", "How absurd to swallow a bird!"),
          List.of("cat", "Imagine that, to swallow a cat!"),
          List.of("dog", "What a hog, to swallow a dog!"),
          List.of("goat", "Just opened her throat and swallowed a goat!"),
          List.of("cow", "I don't know how she swallowed a cow!"),
          List.of("horse"));

  String verse(int verse) {
    List<String> lines = new ArrayList<>();
    addFirstLineOfVerse(lines, verse);
    if (isLongVerse(verse)) {
      addOutcryLineOfVerse(lines, verse);
      addCauseLinesOfVerse(lines, verse);
    }
    addLastLineOfVerse(lines, verse);
    return String.join("\n", lines);
  }

  private boolean isLongVerse(int verse) {
    return ANIMALS_AND_OUTCRIES.get(verse - 1).size() == 2;
  }

  private void addFirstLineOfVerse(List<String> verseLines, int verse) {
    verseLines.add(String.format("I know an old lady who swallowed a %s.", currentAnimal(verse)));
  }

  private void addOutcryLineOfVerse(List<String> verseLines, int verse) {
    verseLines.add(outcry(verse));
  }

  private String outcry(int index) {
    return ANIMALS_AND_OUTCRIES.get(index - 1).get(1);
  }

  private void addCauseLinesOfVerse(List<String> verseLines, int verse) {
    for (int i = verse; i > 1; i--) {
      verseLines.add(
          String.format(
              "She swallowed the %s to catch the %s.", currentAnimal(i), previousAnimal(i)));
    }
  }

  private void addLastLineOfVerse(List<String> verseLines, int verse) {
    if (verse == 8) {
      verseLines.add("She's dead, of course!");
    } else {
      verseLines.add("I don't know why she swallowed the fly. Perhaps she'll die.");
    }
  }

  private String currentAnimal(int index) {
    return ANIMALS_AND_OUTCRIES.get(index - 1).get(0).split(" ", 2)[0];
  }

  private String previousAnimal(int index) {
    return ANIMALS_AND_OUTCRIES.get(index - 2).get(0);
  }

  String verses(int startVerse, int endVerse) {
    List<String> verses = new ArrayList<>();
    for (int verse = startVerse; verse <= endVerse; verse++) {
      verses.add(verse(verse));
    }
    return String.join("\n\n", verses);
  }
}
