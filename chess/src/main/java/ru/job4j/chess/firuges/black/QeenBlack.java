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
public class QeenBlack implements Figure {
    private final Cell position;

    Cell[] allCells = Cell.values();

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[Cell.stepsSize(source, dest)];
        if (isDiagonal(source, dest)) {
            int deltaX = source.x < dest.x ? 1 : -1;
            int deltaY = source.y < dest.y ? 1 : -1;
            for (int i = 1; i <= steps.length; i++) {
                steps[i - 1] = allCells[source.ordinal() + 8 * deltaX * i + deltaY * i];
            }
        } else if (isHorizontal(source, dest)) {
            int deltaY = source.y < dest.y ? 1 : -1;
            for (int i = 1; i <= steps.length; i++) {
                steps[i - 1] = allCells[source.ordinal() + deltaY * i];
            }
        } else if (isVertical(source, dest)) {
            int deltaX = source.x < dest.x ? 1 : -1;
            for (int i = 1; i <= steps.length; i++) {
                steps[i - 1] = allCells[source.ordinal() + 8 * deltaX * i];
            }
        } else {
            throw new ImpossibleMoveException("Invalid move for the queen.");
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x);
    }

    private boolean isHorizontal(Cell source, Cell dest) {
        return source.x == dest.x;
    }

    private boolean isVertical(Cell source, Cell dest) {
        return source.y == dest.y;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
