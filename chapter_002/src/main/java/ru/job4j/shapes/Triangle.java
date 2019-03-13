package ru.job4j.shapes;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append(System.getProperty("line.separator"));
        pic.append("  + +  ");
        pic.append(System.getProperty("line.separator"));
        pic.append(" +   + ");
        pic.append(System.getProperty("line.separator"));
        pic.append("+++++++");
        pic.append(System.getProperty("line.separator"));
        return pic.toString();
    }
}
