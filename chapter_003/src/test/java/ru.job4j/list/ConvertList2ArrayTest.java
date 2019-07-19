package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 0, 4, -1, 6), 3);
        int[][] expect = {
                {1, 2},
                {0, 4},
                {-1, 6}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElementsThen10() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 0, 4, -1, 6), 5);
        int[][] expect = {
                {1, 2},
                {0, 4},
                {-1, 6},
                {0, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ArraysMergedInto1First() {
        ConvertList2Array list = new ConvertList2Array();
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5};
        List<Integer> result = list.convert(
                new ArrayList<>() { {
                    add(array1);
                    add(array2);
                } });
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(result, is(expect));
    }

    @Test
    public void when2ArraysMergedInto1Second() {
        ConvertList2Array list = new ConvertList2Array();
        int[] array1 = {1, 2};
        int[] array2 = {3, 4, 5, 6};
        List<Integer> result = list.convert(
                new ArrayList<>() { {
                    add(array1);
                    add(array2);
                } });
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

}
