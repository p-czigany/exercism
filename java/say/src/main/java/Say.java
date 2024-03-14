import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Say {

  private static final Map<Integer, String> ONE_TO_NINE =
      Map.of(
          1, "one",
          2, "two",
          3, "three",
          4, "four",
          5, "five",
          6, "six",
          7, "seven",
          8, "eight",
          9, "nine");

  private static final Map<Integer, String> TEENS =
      Map.of(
          11, "eleven",
          12, "twelve",
          13, "thirteen",
          14, "fourteen",
          15, "fifteen",
          16, "sixteen",
          17, "seventeen",
          18, "eighteen",
          19, "nineteen");

  private static final Map<Integer, String> TWENTY_TO_NINETY =
      Map.of(
          20, "twenty",
          30, "thirty",
          40, "forty",
          50, "fifty",
          60, "sixty",
          70, "seventy",
          80, "eighty",
          90, "ninety");

  private static final Map<Integer, String> SCALE_WORDS =
      Map.of(
          1, "thousand",
          2, "million",
          3, "billion");

  private void validate(long number) {
    if (number < 0 || number >= 1_000_000_000_000L) throw new IllegalArgumentException();
  }

  private boolean isInRange(int lowerLimit, int upperLimit, long number) {
    return IntStream.rangeClosed(lowerLimit, upperLimit).anyMatch(x -> x == number);
  }

  private String fromOneToNinetyNine(long number) {
    var digits = new ArrayList<String>();
    var tens = number / 10;
    if (tens != 0) {
      digits.add(TWENTY_TO_NINETY.get((int) number / 10 * 10));
    }
    var ones = number % 10;
    if (ones != 0) {
      digits.add(ONE_TO_NINE.get((int) ones));
    }
    return String.join("-", digits);
  }

  private String fromOneHundredToNineHundredNinetyNine(long number) {
    StringBuilder result = new StringBuilder();
    var hundreds = number / 100;
    var remainder = number % 100;
    result.append("%s hundred".formatted(fromOneToNinetyNine(hundreds)));
    if (remainder != 0) {
      result.append(" ").append(fromOneToNinetyNine(remainder));
    }
    return result.toString();
  }

  private String fromOneToNineHundredNinetyNine(long number) {
    if (isInRange(11, 19, number)) return TEENS.get((int) number);
    if (isInRange(1, 9, number) || isInRange(20, 99, number)) return fromOneToNinetyNine(number);
    if (isInRange(100, 999, number)) return fromOneHundredToNineHundredNinetyNine(number);
    return "";
  }

  public String say(long number) {
    validate(number);
    if (number == 0) return "zero";

    return insertScaleWords(breakUpIntoChunksOfThousands(number));
  }

  private List<Long> breakUpIntoChunksOfThousands(long number) {
    List<Long> chunks = new LinkedList<>();

    while (number > 0) {
      chunks.addFirst(number % 1000);
      number /= 1000;
    }

    return chunks;
  }

  private String insertScaleWords(List<Long> chunksOfThousands) {
    StringBuilder result = new StringBuilder();
    int magnitude = chunksOfThousands.size() - 1;
    var isFirstChunk = true;
    for (Long chunk : chunksOfThousands) {
      if (chunk == 0) {
        magnitude--;
        continue;
      }

      var chunkText = fromOneToNineHundredNinetyNine(chunk);

      if (!isFirstChunk) {
        result.append(" ");
      }

      result.append(chunkText);

      if (magnitude != 0) result.append(" ").append(SCALE_WORDS.get(magnitude));

      isFirstChunk = false;
      magnitude--;
    }

    return result.toString();
  }
}
