class ReverseString {

    String reverse(String inputString) {

        return inputString.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
    }
}
