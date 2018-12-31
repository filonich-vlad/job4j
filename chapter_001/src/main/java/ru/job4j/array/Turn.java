package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int temp ;
        int len = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        return array;
    }
}
