package com.revature.exceptions;

public class NegSpeedException extends Exception{

	private static final long serialVersionUID = 1L;

	public NegSpeedException() {
		super();
	}
	
	public NegSpeedException(String message) {
		super(message);
	}
}
