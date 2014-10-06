package com.talosdigital.unitTesting;
import static org.junit.Assert.*;

import org.junit.Test;

import com.talosdigital.Calculator.Calculator;
import com.talosdigital.exceptions.NegativeNumberException;

/**
 * this is unit testing class for the Kata calculator
 * @author jhenaoz
 * @version 02/10/2014
 */
public class KataTest {
	Calculator calc = new Calculator();

	@Test
	public void testOneNumber() throws NegativeNumberException {
			assertEquals("1 =1",1, calc.add("1"));
	}
	
	@Test
	public void testTwoNumbers() throws NegativeNumberException {
			assertEquals("1,3=4", 4, calc.add("1,3"));
	}
	
	@Test
	public void testZeroElements() throws NegativeNumberException{
			assertEquals(" '' = 0",0, calc.add(""));
	}
	
	@Test()
	public void testManyElements() throws NegativeNumberException{
		assertEquals("1,1,1,1= 4", 4, calc.add("1,1,1,1"));
	}
	
	@Test
	public void testManyElementsAndNewLine() throws NegativeNumberException{
		assertEquals("elements with break line", 5, calc.add("1,1\n3"));
	}

	@Test
	public void testDelimiter() throws NegativeNumberException{
		assertEquals("//;\n1;2", 3, calc.add("//;\n1;2"));
	}
	//this test is for check if the negative number exception is working
	@Test(expected = NegativeNumberException.class)
	public void testNegativeWithDelimiter() throws NegativeNumberException{
			assertEquals("//;\n1;2", 1, calc.add("//;\n-1;-2"));
	}
	@Test
	public void testBigNumberIgnored() throws NegativeNumberException{
		assertEquals("//;\n1001;2", 2, calc.add("//;\n1001;2"));
	}
	
	@Test
	public void testBigSizeDelimiter() throws NegativeNumberException{
		assertEquals( 6, calc.add("//[***]\n1***2***3"));
	}
}