package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    Set<User> sort(List<User> users) {
        TreeSet<User> out = new TreeSet<>();
        out.addAll(users);
        return out;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int x = o1.getName().compareTo(o2.getName());
                        return x != 0 ? x : o1.getAge() - o2.getAge();
                    }
                });
        return users;
    }
}
