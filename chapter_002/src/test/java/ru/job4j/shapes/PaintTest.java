package ru.job4j.shapes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class PaintTest {
    @Test
    public void whenPaint() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw((new Square()));
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append("+++++++\n")
                        .append("+     +\n")
                        .append("+     +\n")
                        .append("+++++++\n")
                        .append(System.lineSeparator())
                        .toString()
                ));
        System.setOut(stdout);
    }
}
