package ru.job4j.calculator;

/**
 *Class Calculator решение задачи части 3.1. Элементарный калькулятор.
 *@author filonich
 *@since 26.12.2018
 */

public class Calculator {
    private double result;

	/**
	Adds two numbers.
	 */
    public void add(double first, double second) {
        this.result = first + second;
    }
	
	/**
	Subtracts second from first.
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	
	/**
	Divides first by second.
	*/
	public void divide(double first, double second) {
		this.result = first / second;
	}
	
	/**
	Multiplies first by second.
	*/
	public void multiply(double first, double second) {
		this.result = first * second;
	}
	
    /**
	Getter.
	*/
    public double getResult() {
        return this.result;
    }
}
