package com.revature.vehicles;

//extending is an application of inheritance
public class InvalidYearException  extends RuntimeException{
	
	//creates a runtime exception that returns a string
	public InvalidYearException(String message) {
		super(message);		
	}

}
