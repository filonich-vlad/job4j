package ru.job4j.condition;

/**
 * Вычисчляет максимум из first и second.
 */

public class Max {
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
}
