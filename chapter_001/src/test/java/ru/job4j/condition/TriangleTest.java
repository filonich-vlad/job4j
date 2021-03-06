package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

    public class TriangleTest {
        @Test
        public void whenAreaSetThreePointsThenTriangleArea() {
            // создаем три объекта класса Point.
            Point a = new Point(0, 0);
            Point b = new Point(0, 2);
            Point c = new Point(2, 0);
            // Создаем объект треугольник и передаем в него объекты точек.
            Triangle triangle = new Triangle(a, b, c);
            // Вычисляем площадь.
            double result = triangle.area();
            // Задаем ожидаемый результат.
            double expected = 2D;
            //Проверяем результат и ожидаемое значение.
            assertThat(result, closeTo(expected, 0.1));
        }

        @Test
        public void whenAnotherThreePointsThenTriangleArea() {
            // Вершины треугольника.
            Point a = new Point(0, 0);
            Point b = new Point(6, 0);
            Point c = new Point(3, 8);
            // Создаем треугольник по его вершинам.
            Triangle triangle = new Triangle(a, b, c);

            double result = triangle.area();

            double expected = 24D;

            assertThat(result, closeTo(expected, 0.1));
        }

        @Test
        public void whenWeCantCalculateAreaThenMinusOne() {
            // Вершины треугольника.
            Point a = new Point(0, 0);
            Point b = new Point(0, 3);
            Point c = new Point(0, 8);
            // Создаем треугольник по его вершинам.
            Triangle triangle = new Triangle(a, b, c);

            double result = triangle.area();

            double expected = -1;

            assertThat(result, closeTo(expected, 0.1));
        }
    }
