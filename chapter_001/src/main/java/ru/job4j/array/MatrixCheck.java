package ru.job4j.array;

public class MatrixCheck {
    /**
     * Проверяет, стоял ли на диагонали одинаковые булеаны.
     * @param data - квадратная матрица из булеанов.
     * @return true, если диагональ из одного и того же булеана.
     */
        public boolean mono(boolean[][] data) {
            boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1][i - 1] != data[i][i]) {
                result = false;
                break;
            }
        }
            return result;
        }
    }
