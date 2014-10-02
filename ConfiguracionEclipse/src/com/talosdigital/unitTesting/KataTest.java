package com.talosdigital.unitTesting;
import static org.junit.Assert.*;

import org.junit.Test;

import com.talosdigital.Calculator.Calculator;

/**
 * this is unit testing class for the KATA calculator
 * @author jhenaoz
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
	@Test
	public void testNegativeWithDelimiter(){
		try {
			assertEquals("//;\n1;2", 1, calc.add("//;\n-1;-2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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