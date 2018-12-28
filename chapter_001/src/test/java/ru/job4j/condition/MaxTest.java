package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(4, 0);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstIsTheGrestest() {
        Max maxim = new Max();
        int result = maxim.max(100, 75, 50);
        assertThat(result, is(100));
    }

    @Test
    public void whenSecondIsTheGrestest() {
        Max maxim = new Max();
        int result = maxim.max(100, 175, 50);
        assertThat(result, is(175));
    }

    @Test
    public void whenThirdIsTheGrestest() {
        Max maxim = new Max();
        int result = maxim.max(100, 75, 650);
        assertThat(result, is(650));
    }
}