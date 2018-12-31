package ru.job4j.loop;

public class Paint {
    public String pyramid(int h) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна 2 * (h - 1), учитывая нулевую позицию.
        int width = 2 * (h - 1);
        // внешний цикл двигается по строкам.
        for (int row = 0; row < h; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column <=  width; column++) {
                // если строка равна ячейки, то рисуем галку.
                // в данном случае строка определяем, сколько галок будет на строке
                if (column >= (width / 2 - row) && column <= (width / 2 + row)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
}
