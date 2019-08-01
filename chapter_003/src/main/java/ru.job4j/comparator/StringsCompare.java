package ru.job4j.comparator;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int stop = Math.min(left.length(), right.length());
        int result = 0;
        boolean done = false;
        for (int i = 0; i < stop; i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                done = true;
                break;
            }

        }
        if (!done) {
            if (left.length() > right.length()) {
                result = 1;
            }
            if (left.length() < right.length()) {
                result = -1;
            }
        }
        return result;
    }
}
