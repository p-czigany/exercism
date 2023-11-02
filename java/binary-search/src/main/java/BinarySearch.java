import java.util.List;

class BinarySearch {

    private final Integer[] sortedList;

    BinarySearch(List<Integer> sortedList) {
        this.sortedList = sortedList.toArray(new Integer[0]);
    }

    int indexOf(int a) throws ValueNotFoundException {

        if (sortedList.length == 0) {
            throw new ValueNotFoundException("Value not in array");
        }

        return binarySearch(a, 0, sortedList.length - 1);
    }

    private int binarySearch(int a, int bottomIndex, int topIndex) throws ValueNotFoundException {
        validateForValueNotFound(a, bottomIndex, topIndex);

        int middle = getMiddle(bottomIndex, topIndex);

        if (a == middle) {
            return getMiddleKey(bottomIndex, topIndex);
        } else if (a > middle) {
            return binarySearch(a, bottomIndexOfUpperHalf(bottomIndex, topIndex), topIndex);
        } else {
            return binarySearch(a, bottomIndex, topIndexOfLowerHalf(bottomIndex, topIndex));
        }
    }

    private void validateForValueNotFound(int a, int bottomIndex, int topIndex) throws ValueNotFoundException {
        if (isNotThere(a, bottomIndex, topIndex)) {
            throw new ValueNotFoundException("Value not in array");
        }
    }

    private boolean isNotThere(int a, int bottomIndex, int topIndex) {
        return (a < sortedList[bottomIndex] || a > sortedList[topIndex]);
    }

    private int getMiddle(int bottomIndex, int topIndex) {
        return sortedList[getMiddleKey(bottomIndex, topIndex)];
    }

    private Integer getMiddleKey(int bottomIndex, int topIndex) {
        return (bottomIndex + topIndex) / 2;
    }

    private int bottomIndexOfUpperHalf(int bottomIndex, int topIndex) {
        return (bottomIndex + topIndex) / 2 + 1;
    }

    private int topIndexOfLowerHalf(int bottomIndex, int topIndex) {
        return (bottomIndex + topIndex - 1) / 2;
    }
}
