package test;

import education.Qsort;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class QsortTest {
    final int numTests = 100;

    @RepeatedTest(numTests)
    void sort() {
        final int length = 10;

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-999, 1000);
        }
        int[] expected = array.clone();
        Arrays.sort(expected);
        Qsort.sort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    void sortUniform() {
        final int length = 100;
        int[] array = new int[length];
        Arrays.fill(array,2);
        int[] expected = array.clone();
        Qsort.sort(array);
        assertArrayEquals(expected, array);
    }
}