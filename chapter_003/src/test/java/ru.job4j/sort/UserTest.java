package ru.job4j.sort;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserTest {
    @Test
    public void whenLeftisOlder() {
        User o1 = new User("Mohammed", 34);
        User o2 = new User("Ahmed", 33);
        int result = o1.compareTo(o2);
        assertThat(result, is(1));
    }

    @Test
    public void whenRightisOlder() {
        User o1 = new User("Mohammed", 34);
        User o2 = new User("Earth", 450000000);
        int result = o1.compareTo(o2);
        assertThat(result, is(-1));
    }

    @Test
    public void whenEqual() {
        User o1 = new User("Mohammed", 34);
        User o2 = new User("Ahmed", 34);
        int result = o1.compareTo(o2);
        assertThat(result, is(0));
    }
}
