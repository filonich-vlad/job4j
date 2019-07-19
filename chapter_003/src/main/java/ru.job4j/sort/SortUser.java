package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    Set<User> sort (List<User> users) {
        TreeSet<User> out = new TreeSet<>();
        out.addAll(users);
        return out;
    }
}
