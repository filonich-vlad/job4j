package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
*
*@author Vladdislav Filonich
*@version $id$
*@since 15.12.2018
*/

public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void inputNameReturnThreeEchoPlusName(){
	String input = "John Connor";
	String expect = "Echo, echo, echo: John Connor";
	Calculate calc = new Calculate();
	String result = calc.echo(input);
	assertThat(result,is(expect));
	}
	
	
}
	