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
	public void testOneNumber() {
		try {
			assertEquals("1 =1",1, calc.add("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTwoNumbers() {
		try {
			assertEquals("1,3=4", 4, calc.add("1,3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testZeroElements(){
		try {
			assertEquals(" '' = 0",0, calc.add(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test()
	public void testManyElements(){
		try {
			assertEquals("1,1,1,1= 4", 4, calc.add("1,1,1,1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testManyElementsAndNewLine(){
		try {
			assertEquals("elements with break line", 5, calc.add("1,1\n3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelimiter(){
		try {
			assertEquals("//;\n1;2", 3, calc.add("//;\n1;2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//this test is for check if the negative number exception is working
	@Test(expected = NegativeNumberException.class)
	public void testNegativeWithDelimiter() throws NegativeNumberException{
			assertEquals("//;\n1;2", 1, calc.add("//;\n-1;-2"));
	}
	@Test
	public void testBigNumberIgnored(){
		try {
			assertEquals("//;\n1001;2", 2, calc.add("//;\n1001;2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBigSizeDelimiter(){
		try {
			assertEquals( 6, calc.add("//[***]\n1***2***3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}