package com.revature.oopexercise;

public class Bus extends Transportation {	// Since Bus extended Transportation which implemented Drivable, Bus will have to
											// define Drivable's methods.
	private int numOfWheels;
	
	public Bus() {
		super();
		setMaxCapacity(85);
		setNumOfWheels(10);
	}
	
	public Bus(int numOfWheels) {	// (Polymorphism) This is method overloading where you have two methods with the same name but have different
		this.numOfWheels = numOfWheels;	// parameters.
	}
	
	public int getNumOfWheels() {
		return numOfWheels;
	}

	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}
	
	// Drivable's Methods.
	@Override
	public void startMoving() {
		System.out.println("Bus started moving.");
	}
	
	@Override
	public void stopMoving() {
		System.out.println("Bus stopped moving.");
	}

	@Override
	public String toString() {
		return "Bus [numOfWheels=" + numOfWheels + ", getMaxCapacity()=" + getMaxCapacity() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfWheels;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		if (numOfWheels != other.numOfWheels)
			return false;
		return true;
	}

}
