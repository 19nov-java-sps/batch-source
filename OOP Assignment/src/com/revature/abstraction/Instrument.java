package com.revature.abstraction;

public abstract class Instrument implements Strummable {

	//ENCAPSULATION - setting the data/variable to private so that their values cannot be
	//accessed outside of the class
	private int numOfNotes;
	private int intrumentWeight;
	private String instrumentType;
	
	//call to super to inherit from the object class
	public Instrument() {
		super();
	}
	
	//Abstraction - creating the abstract method (which implies that this instrument does some type of action)
	public abstract void myAbstractMethod(); 
	
	
	//ENCAPSULATION (again) - Creating 'getter' and 'setter' 
	//methods to access the private data them from outside of this particular class 
	public int getNumOfNotes() {
		return numOfNotes;
	}

	public void setNumOfNotes(int numOfNotes) {
		this.numOfNotes = numOfNotes;
	}
	
}
