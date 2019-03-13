package ru.job4j.shapes;

public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++");
        pic.append(System.getProperty("line.separator"));
        pic.append("+     +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+     +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+++++++");
        pic.append(System.getProperty("line.separator"));
        return pic.toString();
    }
}
