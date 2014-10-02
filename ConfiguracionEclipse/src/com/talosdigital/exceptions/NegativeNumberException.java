package com.talosdigital.exceptions;

public class NegativeNumberException extends Exception {

	/**
	 * 
	 */
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
