package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopWayTest {

    @Test
    public void whenMoveB1H7ThenGetCorrectStepsArray() {
        Cell source = Cell.B1;
        Cell dest = Cell.H7;
        BishopBlack bishop = new BishopBlack(source);
        Cell[] expectedWay = {Cell.C2, Cell.D3, Cell.E4,
                Cell.F5, Cell.G6, Cell.H7};

        assertThat(bishop.way(source, dest), is(expectedWay));
    }

    @Test
    public void whenMoveD4A1ThenGetCorrectStepsArray() {
        Cell source = Cell.D4;
        Cell dest = Cell.A1;
        BishopBlack bishop = new BishopBlack(source);
        Cell[] expectedWay = {Cell.C3, Cell.B2, Cell.A1};

        assertThat(bishop.way(source, dest), is(expectedWay));
    }

    @Test
    public void whenMoveD4C5ThenGetCorrectStepsArray() {
        Cell source = Cell.D4;
        Cell dest = Cell.C5;
        BishopBlack bishop = new BishopBlack(source);
        Cell[] expectedWay = {Cell.C5};

        assertThat(bishop.way(source, dest), is(expectedWay));
    }
}
