package education;

import java.util.concurrent.ThreadLocalRandom;

public class Qsort {
    private static int counter = 0;
    public static int getCounter() {
        return counter;
    }

    private static boolean printLog = false;
    public static boolean isPrintLog() {
        return printLog;
    }
    public static void setPrintLog(boolean printLog) {
        Qsort.printLog = printLog;
    }

    public static void sort(int[] array) {
        counter = 0;
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        counter++;
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            sort(array, startIndex, (pivotIndex - 1));
            sort(array, pivotIndex, endIndex);
        }
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(startIndex, endIndex + 1);
        int pivot = array[pivotIndex];
        if (printLog) System.out.print("Pivot: " + pivot + " (" + pivotIndex + ")");
        while (startIndex <= endIndex) {
            while (array[startIndex] < pivot) startIndex++;
            if (printLog) System.out.print("    Start: " + array[startIndex] + " (" + startIndex + ")");
            while (array[endIndex] > pivot) endIndex--;
            if (printLog) {
                System.out.println("    End: " + array[endIndex] + " (" + endIndex + ")");
                StringBuilder s = new StringBuilder("[");
                for (int i = startIndex; i <= endIndex; i++) {
                    s.append(array[i]);
                    if (i == startIndex) s.append("[s]");
                    if (i == pivotIndex) s.append("[p]");
                    if (i == endIndex) s.append("[e]");
                    s.append(", ");
                }
                s.delete(s.length() - 2, s.length());
                s.append("]");
                System.out.println(s);
            }
            if (startIndex <= endIndex) {
                int tmp = array[startIndex];
                array[startIndex++] = array[endIndex];
                array[endIndex--] = tmp;
                counter++;
                if (printLog)
                    System.out.println("switched " + startIndex + "(" + array[startIndex - 1] + ")" + " with " + endIndex + "(" + array[endIndex + 1] + ")");
            }
        }
        return startIndex;
    }

}
