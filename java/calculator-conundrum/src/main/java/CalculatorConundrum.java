import java.util.Map;
import java.util.function.BiFunction;

class CalculatorConundrum {

  private static final String CALCULATION_RESULT_TEMPLATE = "%d %s %d = %d";

  private static final Map<String, BiFunction<Integer, Integer, Integer>> calculationFunctions =
      Map.of(
          "+", CalculatorConundrum::add,
          "*", CalculatorConundrum::multiply,
          "/", CalculatorConundrum::divide);

  public String calculate(int operand1, int operand2, String operation) {
    validate(operation);
    int result = calculationFunctions.get(operation).apply(operand1, operand2);

    return String.format(CALCULATION_RESULT_TEMPLATE, operand1, operation, operand2, result);
  }

  private static void validate(String operation) {
    if (operation == null) {
      throw new IllegalArgumentException("Operation cannot be null");
    }
    if (operation.isEmpty()) {
      throw new IllegalArgumentException("Operation cannot be empty");
    }
    if (!calculationFunctions.containsKey(operation)) {
      throw new IllegalOperationException(
          String.format("Operation '%s' does not exist", operation));
    }
  }

  private static int add(int operand1, int operand2) {
    return operand1 + operand2;
  }

  private static int multiply(int operand1, int operand2) {
    return operand1 * operand2;
  }

  private static int divide(int operand1, int operand2) {
    if (operand2 == 0) {
      throw new IllegalOperationException(
          "Division by zero is not allowed", new ArithmeticException());
    }
    return operand1 / operand2;
  }
}
