package com.revature.character;

public class NotAliveException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotAliveException() {
		super();
	}
	
	public NotAliveException(String message) {
		super(message);
	}

}
