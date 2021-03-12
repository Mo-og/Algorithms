package test;

import education.BinarySearch;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    final int numTests = 100;

    @RepeatedTest(numTests)
    void getIndex() {
        int length = 1000;
        int[] array = new int[length];
        int num = 0;
        int randIndex = ThreadLocalRandom.current().nextInt(0, length);
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-length + 1, length);
            if (i == randIndex)
                num = array[i];
        }
        Arrays.sort(array);
        int index = BinarySearch.getIndex(array, num);

        System.out.println("Num: " + num + "\nIndex: " + index);
        System.out.println(Arrays.toString(array));

        assertEquals(Arrays.binarySearch(array, num), index);
    }

    @Test
    void getIndexOfNotPresent() {
        int length = 10000;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-length + 1, length);
        }
        Arrays.sort(array);
        int index = BinarySearch.getIndex(array, length * 10);

        System.out.println("Num: 1000\nIndex: " + index);
        System.out.println(Arrays.toString(array));

        assertEquals(-1, index);
    }
}