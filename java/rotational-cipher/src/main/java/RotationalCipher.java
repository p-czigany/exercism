import java.util.stream.Collector;

class RotationalCipher {
    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars().mapToObj(c -> encodeCharacter((char) c)).collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    private char encodeCharacter(char character) {
        if (!Character.isLetter(character)) return character;
        return getCharValueOfInt((getCipherSequence(character) + shiftKey) % 26, character);
    }

    private int getCipherSequence(char character) {
        return character - firstLetterOfAlphabet(character);
    }

    private char getCharValueOfInt(int integer, char character) {
        return (char) (integer + firstLetterOfAlphabet(character));
    }

    private int firstLetterOfAlphabet(char character) {
        return Character.isLowerCase(character) ? 'a' : 'A';
    }

}
