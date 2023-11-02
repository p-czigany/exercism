import java.util.Arrays;

class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        String[] lines = matrixAsString.split(System.lineSeparator());
        this.matrix = new int[lines.length][lines.length];
        for (int i = 0; i < lines.length; i++) {
            this.matrix[i] = Arrays.stream(lines[i].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            column[i] = this.matrix[i][columnNumber - 1];
        }
        return column;
    }
}
