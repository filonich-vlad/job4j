package ru.job4j.comparator;

import java.util.Comparator;

public class StringsCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int stop = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < stop; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            if (i == stop - 1) {
                if (left.length() > right.length()) {
                    result = 1;
                }
                if (left.length() < right.length()) {
                    result = -1;
                }
            }
        }
        return result;
    }
}
