package ru.job4j.sort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SortUserTest {

    @Test
    public void whenUsersNotSorted() {
        SortUser sorter = new SortUser();
        ArrayList<User> users = new ArrayList<>() {{
            add(new User("Ivan", 23));
            add(new User("Alexandra", 28));
            add(new User("Nikita", 21));
            add(new User("David", 30));
            add(new User("Tamara", 19));
        }};
        Set<User> result = sorter.sort(users);
        Iterator<User> it = result.iterator();
        assertThat(it.next().getName(), is("Tamara"));
        assertThat(it.next().getName(), is("Nikita"));
        assertThat(it.next().getName(), is("Ivan"));
        assertThat(it.next().getName(), is("Alexandra"));
        assertThat(it.next().getName(), is("David"));
    }
}
