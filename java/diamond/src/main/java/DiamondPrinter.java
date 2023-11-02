import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class DiamondPrinter {

    private static final Character STARTING_CHARACTER = 'A';
    private static final String DOT = " ";

    List<String> printToList(char a) {
        List<String> result = new ArrayList<>();
        IntStream middleRows = IntStream.concat(IntStream.range(0, value(a)), IntStream.iterate(value(a), i -> i >= 0, i -> i - 1));
        middleRows.forEach(i -> addRow(a, i, result));
        return result;
    }

    private void addRow(char a, int i, List<String> result) {
        if (i == 0) {
            result.add(firstAndLastRow(a));
        } else {
            result.add(middleRow(a, i));
        }
    }

    private String middleRow(char a, int i) {
        return String.format("%s%s%s%s%s",
                DOT.repeat(value(a) - i),
                letter(i),
                DOT.repeat(i * 2 - 1),
                letter(i),
                DOT.repeat(value(a) - i));
    }

    private String firstAndLastRow(char a) {
        return String.format("%s%s%s",
                DOT.repeat(value(a)),
                STARTING_CHARACTER,
                DOT.repeat(value(a)));
    }

    private int value(char ch) {
        return ch - STARTING_CHARACTER;
    }

    private char letter(int number) {
        return (char) (number + 'A');
    }

}
