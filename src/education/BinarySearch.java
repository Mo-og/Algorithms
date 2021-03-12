package education;

public class BinarySearch {
    private static int getIndex(int[] array, int num, int start, int stop) {
        if (start > stop) return -1;

        int pivot = (start + stop) / 2;
        if (pivot > array.length-1) return -1;
        if (num > array[pivot]) {
            start = pivot + 1;
        } else if (num < array[pivot]) {
            stop = pivot - 1;
        } else return array[pivot] == num ? pivot : -1;
        return getIndex(array, num, start, stop);
    }

    public static int getIndex(int[] array, int num) {
        return getIndex(array, num, 0, array.length);
    }
}
