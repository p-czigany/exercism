import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class HighScores {

  private final List<Integer> highScores;

  public HighScores(List<Integer> highScores) {
    this.highScores = highScores;
  }

  List<Integer> scores() {
    return this.highScores;
  }

  Integer latest() {
    return scores().get(scores().size() - 1);
  }

  Integer personalBest() {
    return scores().stream().max(Comparator.naturalOrder()).orElse(null);
  }

  List<Integer> personalTopThree() {
    var sortedHighScores = new ArrayList<>(scores());
    sortedHighScores.sort(Comparator.reverseOrder());
    return sortedHighScores.subList(0, Math.min(3, sortedHighScores.size()));
  }
}
