package ru.job4j.array;

import java.util.Arrays;


public class ArrayDuplicate {

    /**
     * Method removes duplicates from a string array.
     * @param array - input in which we want to get rid of duplicates.
     * @return an array with only unique values left.
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}