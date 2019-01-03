package ru.job4j.array;

public class FindLoop {
    /**
     * Ищет element в data.
     * @param data - массив, в котором ищем.
     * @param element - ищем его.
     * @return позицию элемента или -1, если не нашли.
     */
    public int indexOf(int[] data, int element) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == element) {
                result = index;
                break;
            }
        }
        return result;
    }
}