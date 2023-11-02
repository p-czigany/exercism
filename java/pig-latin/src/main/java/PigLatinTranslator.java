import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    private static final String TEMPLATE = "$2$1ay";

    private static final String REGEXP = "^(?i:((?:[bcdfghjklmnprstvwz]|qu|q|y(?!t)(?!$)|x(?!r))*)(.*))";

    public String translate(String englishPhrase) {
        return Arrays.stream(englishPhrase.split(" "))
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String englishWord) {
        return englishWord.replaceAll(REGEXP, TEMPLATE);
    }
}
