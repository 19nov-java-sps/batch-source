package com.revature.exceptions;

public class NegativeLegsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NegativeLegsException() {
		super();
	}

	public NegativeLegsException(String message) {
		super(message);
	}
	
}

