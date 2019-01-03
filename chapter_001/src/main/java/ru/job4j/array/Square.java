package ru.job4j.array;

public class Square {
    /**
     * Создаёт массив из квадратов чисел от единицы до bound.
     * @param bound - последнее число, до которого надо сделать массив.
     * @return массив с квадратами чисел.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}
