package calc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	private final Calculator calculator = new Calculator();
	private double a;
	private double b;
	private double result;
	private static final double DELTA = 1e-15;
	
	@Test
	public void testAdd() {
		a = 10;
		b = 5;
		result = calculator.Add(a, b);
		double expectedResult = 15;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testSubstract() {
		a = 10;
		b = 50;
		result = calculator.Substract(a, b);
		double expectedResult = -40;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testMultiply() {
		a = 15;
		b = 10;
		result = calculator.Multiply(a, b);
		double expectedResult = 150;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testDivide() {
		a = 100;
		b = 5;
		result = calculator.Divide(a, b);
		double expectedResult = 20;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testDivideWithRemainder() {
		a = 9;
		b = 2;
		result = calculator.Remainder(a, b);
		double expectedResult = 1;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testPower() {
		a = 2;
		b = 3;
		result = calculator.Power(a, b);
		double expectedResult = 8;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testSquareRoot() {
		a = 100;
		result = calculator.Sqrt(a);
		double expectedResult = 10;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testFactorial() {
		a = 5;
		result = calculator.Factorial(a);
		double expectedResult = 120;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	@Test
	public void testDivideByZero() {
		a = 10;
		b = 0;
		
		Assert.assertThrows(ArithmeticException.class, () -> {
			result = calculator.Divide(a, b);
		});
	}
	
	@Test
	public void testDivideByZeroWithRemainder() {
		a = 10;
		b = 0;
		
		Assert.assertThrows(ArithmeticException.class, () -> {
			result = calculator.Divide(a, b);
		});
	}
	
	@Test
	public void testNegativeNumberUnderSquareRoot() {
		a = -9;
		
		Assert.assertThrows(ArithmeticException.class, () -> {
			result = calculator.Divide(a, b);
		});
	}
	
	@Test
	public void testBackspace() {
		String txt = "1110";
		Assert.assertEquals("111", calculator.Backspace(txt));
	}
	
		
		
}
