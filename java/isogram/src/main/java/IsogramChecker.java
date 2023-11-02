import java.util.ArrayList;
import java.util.List;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        List<String> charactersPresent = new ArrayList<>();
        for (String letter : phrase.split("")) {
            if (letter.equals(" ") || letter.equals("-")) continue;
            if (charactersPresent.contains(letter.toLowerCase())) return false;
            charactersPresent.add(letter.toLowerCase());
        }
        return true;
    }

}
