package ru.job4j.tracker;

public interface UserAction {
    /**
     * Returns key of the option.
     * @return key.
     */
    int key();

    /**
     * Execute method.
     * @param input Input type object.
     * @param tracker Tracker type object.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Returns info about the option.
     * @return Menu string.
     */
    String info();
}
