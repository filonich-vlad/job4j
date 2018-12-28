package ru.job4j.loop;


/**
 * Считает 2+4+6+8+10.
 */
public class Counter {
    public int add(int start, int finish) {
        int count = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                count += i;
                }
            }
        return count;
        }
    }
