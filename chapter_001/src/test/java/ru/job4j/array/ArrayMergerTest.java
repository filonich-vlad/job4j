package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayMergerTest {

    ArrayMerger merger = new ArrayMerger();

    @Test
    public void whenEvenLengthThenSuccess() {
        int[] first = new int[]{1, 2, 5, 5};
        int[] second = new int[]{1, 2, 5, 5};
        int[] expected = new int[]{1, 1, 2, 2, 5, 5, 5, 5};
        int[] result = merger.mergeTwo(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFirstLongerThenSuccess() {
        int[] first = new int[]{-10, 70, 500, 999};
        int[] second = new int[]{0};
        int[] result = merger.mergeTwo(first, second);
        int[] expected = {-10, 0, 70, 500, 999};
        assertThat(result, is(expected));
    }

    @Test
    public void whenFirstLessThanSecondThenSuccess() {
        int[] first = new int[]{1, 7};
        int[] second = new int[]{8, 9, 100};
        int[] result = merger.mergeTwo(first, second);
        int[] expected = {1, 7, 8, 9, 100};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondLessThanFirstThenSuccess() {
        int[] first = new int[]{10, 78};
        int[] second = new int[]{-82, -8, 10};
        int[] result = merger.mergeTwo(first, second);
        int[] expected = {-82, -8, 10, 10, 78};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondLongerThenSucces() {
        int[] first = new int[]{10, 78};
        int[] second = new int[]{82, 89, 100};
        int[] result = merger.mergeTwo(first, second);
        int[] expected = {10, 78, 82, 89, 100};
        assertThat(result, is(expected));
    }
}