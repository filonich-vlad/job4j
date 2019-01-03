package ru.job4j.array;

public class Check {
    /**
     * Метод mono - проверяет, состоит ли массив data из одинаковых булеанов.
     * @param data - тот самый массив булеанов.
     * @return true, если состоит.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}