import java.util.*;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        List<String> words = new ArrayList<>(Arrays.asList(input.toLowerCase().split("[^a-zA-Z0-9']+")));
        words.removeIf(String::isEmpty);
        words.replaceAll(word -> (word.startsWith("'") && word.endsWith("'")) ? word.substring(1, word.length() - 1) : word);
        Map<String, Integer> result = new HashMap<>();
        words.forEach(word -> result.put(word, result.containsKey(word) ? result.get(word) + 1 : 1));
        return result;
    }
}
