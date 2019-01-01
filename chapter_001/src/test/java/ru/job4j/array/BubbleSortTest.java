package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
       BubbleSort sorter = new BubbleSort();
       int[] nums = new int[] {1, 6, 6, 2, 9, 12, 74, 90, -100, 43, 1, -60, -4};
       int[] result = sorter.sort(nums);
       int[] expected = new int[] {-100, -60, -4, 1, 1, 2, 6, 6, 9, 12, 43, 74, 90};
       assertThat(result, is(expected));
    }
}

