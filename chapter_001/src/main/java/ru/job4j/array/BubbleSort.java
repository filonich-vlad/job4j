package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = 1; j < array.length - i; j++) {
               if (array[j - 1] > array[j]) {
                   array[j - 1] = array[j] + array[j - 1];
                   array[j] = array[j - 1] - array[j];
                   array[j - 1] =  array[j - 1] - array[j];
               }
            }
        }
        return array;
    }
}