package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	@Test
	public void when1Plus1ThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	
	@Test
	public void when8Over2Then4() {
		Calculator calc = new Calculator();
		calc.divide(8D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
	
	@Test
	public void when6Times7Then42() {
		Calculator calc = new Calculator();
		calc.multiply(6D, 7D);
		double result = calc.getResult();
		double expected = 42D;
		assertThat(result, is(expected));
	}
	
	@Test
	public void when10minus7Then3() {
		Calculator calc = new Calculator();
		calc.subtract(10D, 7D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}
}
