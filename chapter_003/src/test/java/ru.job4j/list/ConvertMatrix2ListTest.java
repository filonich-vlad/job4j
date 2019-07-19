package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 4},
                {3, 4, -2}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 4, 3, 4, -2
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when4on4ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 0, 0},
                {3, 4, -9, 23},
                {3, 2, -3, -5},
                {-4, 6, -2, 0}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 0, 0, 3, 4, -9, 23, 3, 2, -3, -5, -4, 6, -2, 0
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}