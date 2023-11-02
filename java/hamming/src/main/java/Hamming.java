

public class Hamming {
    String leftStrand;
    String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (!rightStrand.isBlank() && leftStrand.equals("")) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (!leftStrand.isBlank() && rightStrand.equals("")) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (!this.leftStrand.substring(i, i + 1).equals(this.rightStrand.substring(i, i + 1))) {
                distance++;
            }
        }
        return distance;
    }
}
