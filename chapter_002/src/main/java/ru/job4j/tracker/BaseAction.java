package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {

    int key;
    String name;

    public BaseAction(String name, int key) {
        this.key = key;
        this.name = name;
    }

    public int key() {
        return this.key;
    }

    public String info() {
        return String.format("%s - %s", this.key(), this.name);
    }
}
