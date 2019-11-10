package com.revature.oop;

public class MyCustomException extends RuntimeException {
	public  MyCustomException (String errorMessage, Throwable err) {
		super (errorMessage, err);
	}
}
