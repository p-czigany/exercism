class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(getSum(0, 1, input), 2);
    }

    private int getSum(int sum, int i, int b) {
        if (i > b) {
            return sum;
        }
        return i + getSum(sum, i + 1, b);
    }

    int computeSumOfSquaresTo(int input) {
        return getSquareSum(0, 1, input);
    }

    private int getSquareSum(int sum, int i, int b) {
        if (i > b) {
            return sum;
        }
        return (int) Math.pow(i, 2) + getSquareSum(sum, i + 1, b);
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
