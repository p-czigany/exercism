import java.util.*;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>(Collections.emptySet());
        for (int i = 0; i < values.size(); i++) {
            List<Integer> row = values.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) >= Collections.max(row) && row.get(j) <= Collections.min(this.getColumn(j))) {
                    saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
        return saddlePoints;
    }

    List<Integer> getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>(Collections.emptyList());
        for (List<Integer> row :
                values) {
            column.add(row.get(columnNumber));
        }
        return column;
    }
}
