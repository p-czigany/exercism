class SimpleCalculator
  ALLOWED_OPERATIONS = ['+', '/', '*'].freeze

  def self.calculate(first_operand, second_operand, operation)
    unless ALLOWED_OPERATIONS.include? operation
      raise UnsupportedOperation
    end
    begin
      "#{first_operand} #{operation} #{second_operand} = #{operate(first_operand, second_operand, operation)}"
    rescue ZeroDivisionError
      "Division by zero is not allowed."
    rescue TypeError
      raise ArgumentError
    end
  end

  def self.operate(first_operand, second_operand, operation)
    first_operand.method(operation).(second_operand)
  end

  class UnsupportedOperation < StandardError
  end
end
