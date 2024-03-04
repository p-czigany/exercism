class ArmstrongNumbers {

  boolean isArmstrongNumber(int numberToCheck) {
    return numberToCheck
        == String.valueOf(numberToCheck)
            .chars()
            .map(Character::getNumericValue)
            .map(digit -> (int) Math.pow(digit, String.valueOf(numberToCheck).toCharArray().length))
            .sum();
  }
}
