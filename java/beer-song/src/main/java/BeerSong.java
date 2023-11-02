import java.util.stream.IntStream;

public class BeerSong {

    private static final String VERSE_99_TO_2_TEMPLATE = "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottle%s of beer on the wall.\n\n";
    private static final String VERSE_ONE = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n\n";
    private static final String VERSE_ZERO = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n";

    public String sing(int startingVerse, int numberOfVerses) {
        return IntStream.range(startingVerse - numberOfVerses, startingVerse).mapToObj(i -> verse(2 * startingVerse - (i + numberOfVerses))).reduce("", (a, b) -> a + b);
    }

    private String verse(int verseNumber) {
        if (verseNumber > 1) {
            return String.format(VERSE_99_TO_2_TEMPLATE, verseNumber, verseNumber, verseNumber - 1, (verseNumber != 2) ? "s" : "");
        } else if (verseNumber == 1) {
            return VERSE_ONE;
        }
        return VERSE_ZERO;
    }

    public String singSong() {
        return sing(99, 100);
    }

}
