import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private static final String[] days = new String[]{
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"
    };
    private static final String[] gifts = new String[]{
            "a Partridge in a Pear Tree.",
            "two Turtle Doves,",
            "three French Hens,",
            "four Calling Birds,",
            "five Gold Rings,",
            "six Geese-a-Laying,",
            "seven Swans-a-Swimming,",
            "eight Maids-a-Milking,",
            "nine Ladies Dancing,",
            "ten Lords-a-Leaping,",
            "eleven Pipers Piping,",
            "twelve Drummers Drumming,"
    };
    private static final String VERSE_TEMPLATE = "On the %s day of Christmas my true love gave to me: %s%n";

    String verse(int verseNumber) {
        return String.format(VERSE_TEMPLATE, days[verseNumber - 1], verseGifts(verseNumber));
    }

    private String verseGifts(int verseNumber) {
        StringBuilder result = new StringBuilder();
        for (int i = verseNumber - 1; i >= 0; i--) {
            result.append(gifts[i]);
            if (i > 1) {
                result.append(" ");
            } else if (i == 1) {
                result.append(" and ");
            }
        }
        return result.toString();
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse).mapToObj(this::verse).collect(Collectors.joining("\n"));
    }

    String sing() {
        return verses(1, 12);
    }
}
