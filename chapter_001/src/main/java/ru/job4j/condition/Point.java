package ru.job4j.condition;

import java.lang.Math.*;
/**
 * @author Vladislav Filonich
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("CanBeFinal")
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
}