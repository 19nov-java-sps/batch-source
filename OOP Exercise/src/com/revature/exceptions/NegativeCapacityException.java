package com.revature.exceptions;

public class NegativeCapacityException extends RuntimeException {	// Inheriting RuntimeException class in order to use "throw" keyword.

	private static final long serialVersionUID = 1L;
	
	public NegativeCapacityException() {
		super();
	}
	
	public NegativeCapacityException(String msg) {	// Overloading constructor just in case if we want to add a message.
		super(msg);
	}

}
