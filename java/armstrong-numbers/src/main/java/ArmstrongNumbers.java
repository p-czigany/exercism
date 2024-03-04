class ArmstrongNumbers {

  boolean isArmstrongNumber(int numberToCheck) {
    var numberString = String.valueOf(numberToCheck).toCharArray();
    var power = numberString.length;
    var sum = 0;
    for (char number : numberString) {
      sum += number ^ power;
    }
    return numberToCheck == sum;
  }
}
