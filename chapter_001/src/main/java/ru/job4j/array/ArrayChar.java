package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] value = prefix.toCharArray();
        boolean ans;
        if (value.length > data.length) {
            ans = false;
        } else if (value.length == 0) {
            ans = true;
        } else {
        ans = true;
        for (int j = 0; j < value.length; j++) {
            if (data[j] != value[j]) {
                ans = false;
            }
        }
    }
        return ans;}
}