import java.util.ArrayList;
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

  public String say(long number) {
    validate(number);
    if (isInRange(0, 0, number)) return "zero";
    if (isInRange(11, 19, number)) return TEENS.get((int) number);
    if (isInRange(1, 9, number) || isInRange(20, 99, number)) return fromOneToNinetyNine(number);
    return "";
  }
}
