package com.revature.exceptions;

public class NegativeSpeedExceptions extends RuntimeException {
	
	private static final long serialVersionUID = 1;
	
	public NegativeSpeedExceptions() {
		super();
	}
	
	public NegativeSpeedExceptions(String message) {
		super(message);
	}
}