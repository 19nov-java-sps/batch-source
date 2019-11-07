package com.revature.exceptions;

public class NegativeSidesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NegativeSidesException() {
		super();
	}
	
	public NegativeSidesException(String message) {
		super(message);
	}

}
