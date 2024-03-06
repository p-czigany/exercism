import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

  private static final Map<Character, Character> TRANSCRIPTIONS =
      Map.of(
          'G', 'C',
          'C', 'G',
          'T', 'A',
          'A', 'U');

  String transcribe(String dnaStrand) {
    return dnaStrand
        .chars()
        .mapToObj(c -> (char) c)
        .map(this::transcribe)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  private Character transcribe(Character nucleotid) {
    return TRANSCRIPTIONS.get(nucleotid);
  }
}
