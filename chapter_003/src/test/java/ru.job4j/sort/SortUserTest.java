package ru.job4j.sort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SortUserTest {

    @Test
    public void whenUsersNotSorted() {
        SortUser sorter = new SortUser();
        ArrayList<User> users = new ArrayList<>() { {
            add(new User("Ivan", 23));
            add(new User("Alexandra", 28));
            add(new User("Nikita", 21));
            add(new User("David", 30));
            add(new User("Tamara", 19));
        } };
        Set<User> result = sorter.sort(users);
        Iterator<User> it = result.iterator();
        assertThat(it.next().getName(), is("Tamara"));
        assertThat(it.next().getName(), is("Nikita"));
        assertThat(it.next().getName(), is("Ivan"));
        assertThat(it.next().getName(), is("Alexandra"));
        assertThat(it.next().getName(), is("David"));
    }

    @Test
    public void whenSortNameLength() {
        SortUser sorter = new SortUser();
        ArrayList<User> users = new ArrayList<>() { {
            add(new User("Ivan", 23));
            add(new User("Alexandra", 28));
            add(new User("Nikita", 21));
            add(new User("David", 30));
            add(new User("Tamara", 19));
        } };
        List<User> result = sorter.sortNameLength(users);
        Iterator<User> it = result.iterator();
        assertThat(it.next().getName(), is("Ivan"));
        assertThat(it.next().getName(), is("David"));
        assertThat(it.next().getName(), is("Nikita"));
        assertThat(it.next().getName(), is("Tamara"));
        assertThat(it.next().getName(), is("Alexandra"));
    }

    @Test
    public void whenSortByAllFields() {
        SortUser sorter = new SortUser();
        ArrayList<User> users = new ArrayList<>() { {
            add(new User("Sergey", 25));
            add(new User("Ivan", 30));
            add(new User("Sergey", 20));
            add(new User("Ivan", 25));
            add(new User("Tamara", 19));
        } };
        List<User> result = sorter.sortByAllFields(users);
        String[] names = {"Ivan", "Ivan", "Sergey", "Sergey", "Tamara"};
        int[] ages = {25, 30, 20, 25, 19};
        int i = 0;
        for (User user : result) {
            assertThat(user.getName(), is(names[i]));
            assertThat(user.getAge(), is(ages[i]));
            i++;
        }
    }
}
