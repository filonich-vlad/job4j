package ru.job4j.tracker;

import java.util.ArrayList;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, ArrayList<Integer> range) {
                int key = Integer.valueOf(this.ask(question));
                boolean exists = false;
                for (int value : range) {
                    if (value == key) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    throw new MenuOutException("Out of menu range.");
                }
                return key;
    }
}
