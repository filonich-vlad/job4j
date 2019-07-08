package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Bishop moves diagonally.");
        }
        Cell[] steps = new Cell[Cell.stepsSize(source, dest)];
        steps[0] = source;
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 1; i < steps.length; i++) {
            steps[i] = new Cell();
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * @param source cell.
     * @param dest cell.
     * @return true if the move of a bishop from source cell to dest cell is diagonal.
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x);
    }
}
