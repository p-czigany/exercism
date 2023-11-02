import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        return IntStream.rangeClosed(1, words.length)
                .mapToObj(this::line)
                .collect(Collectors.joining());
    }

    private String line(int n) {
        return (n < words.length) ? middleLine(n) : lastLine();
    }

    private String lastLine() {
        return (this.words.length > 0) ? String.format("And all for the want of a %s.", this.words[0]) : "";
    }

    private String middleLine(int n) {
        return (this.words.length > n) ? String.format("For want of a %s the %s was lost.%n", this.words[n - 1], this.words[n]) : "";
    }

}
