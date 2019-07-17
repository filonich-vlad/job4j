package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.OccupiedWayException;
import ru.job4j.chess.firuges.black.*;


public class LogicTests {
    Logic logic = new Logic();


    @Test(expected = OccupiedWayException.class)
    public void pawnOnB1CanNotMoveToB2WhereBishopStays() {
        logic.clean();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new PawnBlack(Cell.C2));
        logic.move(Cell.B1, Cell.C2);
    }

    @Test(expected = OccupiedWayException.class)
    public void queenOnD4CanNotMoveThroughPawnOnE4() {
        logic.clean();
        logic.add(new QeenBlack(Cell.D4));
        logic.add(new PawnBlack(Cell.E4));
        logic.move(Cell.D4, Cell.F4);

    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnImpossibleMove() {
        logic.clean();
        logic.add(new PawnBlack(Cell.A2));
        logic.move(Cell.A2, Cell.A4);
    }

    @Test
    public void knightJumpsOverPawns() {
        logic.clean();
        logic.add(new PawnBlack(Cell.B2));
        logic.add(new PawnBlack(Cell.C2));
        logic.add(new PawnBlack(Cell.D2));
        logic.add(new KnightBlack(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.D3), is(true));
    }
}
