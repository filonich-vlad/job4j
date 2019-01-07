package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckSortTest {

    CheckSort checker = new CheckSort();

    @Test
    public void whenSortedAscendThenTrue() {
        int[] input = new int[] {1, 2, 5, 5};
        boolean result = checker.checkIfSorted(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenSortedDescendThenTrue() {
        int[] input = new int[] {10, 7, 5, 1, 0, 0, 0, -68};
        boolean result = checker.checkIfSorted(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotSortedThenFalse() {
        int[] input = new int[] {10, 7, 8, 1, 900, 0, 0, -68};
        boolean result = checker.checkIfSorted(input);
        assertThat(result, is(false));
    }
}