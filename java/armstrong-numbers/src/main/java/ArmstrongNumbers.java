class ArmstrongNumbers {

  boolean isArmstrongNumber(int numberToCheck) {
    var digits = String.valueOf(numberToCheck).toCharArray();
    var numberOfDigits = digits.length;
    var sum = 0;
    for (char digit : digits) {
      sum += digit ^ numberOfDigits;
    }
    return numberToCheck == sum;
  }
}
