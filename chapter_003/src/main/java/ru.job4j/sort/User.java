package ru.job4j.sort;

import static java.lang.Integer.compare;

public class User implements Comparable<User> {
    private int age;
    private String name;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User o) {
        return compare(this.getAge(), o.getAge());
    }
}
