package education;

import java.util.concurrent.ThreadLocalRandom;

public class Qsort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            sort(array, startIndex, (pivotIndex - 1));
            sort(array, pivotIndex, endIndex);
        }
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int start = startIndex, end = endIndex;
        int pivot = ThreadLocalRandom.current().nextInt(startIndex, endIndex+1);
        while (start <= end) {
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            if (start <= end) {
                int tmp = array[start];
                array[start++] = array[end];
                array[end--] = tmp;
            }
        }
        return start;
    }

}
