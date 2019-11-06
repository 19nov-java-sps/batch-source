package com.revature.exceptions;

public class StartSpeedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public StartSpeedException() {
		super();
	}
	
	public StartSpeedException(String message) {
		super(message);
	}
}
