package ru.job4j.shapes;


public class Execute {
    public static void main(String[] args) {
        Paint drawer = new Paint();

        drawer.draw(new Square());

        drawer.draw(new Triangle());
        }
}
