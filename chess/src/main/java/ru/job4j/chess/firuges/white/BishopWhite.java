package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;


/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Bishop has to move diagonally.");
        }
        Cell[] steps = new Cell[Cell.stepsSize(source, dest)];
        Cell[] allCells = Cell.values();
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = allCells[source.ordinal() + 8*deltaX*i + deltaY*i];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x);
    }
}
