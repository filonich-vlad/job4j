package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new ArrayList<>() { { add(1); } });
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите корректные данные: %n")
                )
        );
    }

    @Test
    public void whenNANInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-2", "1"})
        );
        input.ask("Enter", new ArrayList<>() { { add(1); } });
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите число из верного диапазона: %n")
                )
        );
    }
}
