import java.util.stream.IntStream;

class NaturalNumber {
  private final Classification classification;

  NaturalNumber(int number) {
    this.classification = classify(number);
  }

  private int aliquotSum(int number) {
    return IntStream.range(1, number / 2 + 1).filter(i -> number % i == 0).sum();
  }

  private Classification classify(int number) {
    if (number <= 0) {
      return Classification.ILLEGAL_ARGUMENT;
    }

    var aliquotSum = aliquotSum(number);
    if (number < aliquotSum) {
      return Classification.ABUNDANT;
    } else if (number > aliquotSum) {
      return Classification.DEFICIENT;
    } else {
      return Classification.PERFECT;
    }
  }

  Classification getClassification() throws IllegalArgumentException {
    if (classification == Classification.ILLEGAL_ARGUMENT) {
      throw new IllegalArgumentException("You must supply a natural number (positive integer)");
    }
    return classification;
  }
}
