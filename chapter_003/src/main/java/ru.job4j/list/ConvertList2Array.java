package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + ((list.size() % rows == 0) ? 0 : 1);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int item : list) {
            array[i][j] = item;
            j++;
            if (j == cells) {
                i++;
                j = 0;
            }
        }
        return array;
    }
}
