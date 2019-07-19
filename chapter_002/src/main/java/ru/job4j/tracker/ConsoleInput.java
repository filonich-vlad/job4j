package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {

    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
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