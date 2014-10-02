package com.talosdigital.exceptions;

/**
 * This class is the exception that the program throw if there is a negative
 * number in the input
 * @author jhenaoz
 * @version 02/10/2014
 */
public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = -2701180203529877900L;
	String message;
	public NegativeNumberException(String message){
		this.message = message;
		System.err.print(message);
	}
	
	public String getMessage(){
		return this.message;
	}
}
