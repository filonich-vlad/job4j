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
        System.setOut(stdout);
    }
}
