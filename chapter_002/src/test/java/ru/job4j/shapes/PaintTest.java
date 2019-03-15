package ru.job4j.shapes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class PaintTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        // System.out.println("Execute before each test...");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        // System.out.println("Execute after each test...");
    }

    @Test
    public void whenPaintSquare() {
        new Paint().draw((new Square()));
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("+++++++")
                        .append(System.getProperty("line.separator"))
                        .append("+     +")
                        .append(System.getProperty("line.separator"))
                        .append("+     +")
                        .append(System.getProperty("line.separator"))
                        .append("+++++++")
                        .append(System.getProperty("line.separator"))
                        .append(System.getProperty("line.separator"))
                        .toString()
                ));
    }

    @Test
    public void whenPaintTriangle() {
        new Paint().draw((new Triangle()));
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append(System.getProperty("line.separator"))
                                .append("  + +  ")
                                .append(System.getProperty("line.separator"))
                                .append(" +   + ")
                                .append(System.getProperty("line.separator"))
                                .append("+++++++")
                                .append(System.getProperty("line.separator"))
                                .append(System.getProperty("line.separator"))
                                .toString()
                ));
    }
}
