package com.revature.oopexercise;

public class Car extends Bus {	// extending Bus in order to use numOfWheels
								// Since Bus already implemented the Drivable methods, Car doesnt need to implement them.
								// (Inheritance) Here we extend Bus in order to "inherit" all of its attributes in order to re use them.
	private int numOfDoors;
	
	public Car() {
		super();
		setNumOfWheels(4);
		setNumOfDoors(4);
		setMaxCapacity(4);
		//setMaxCapacity(-1);  if we do this then it will throw the custom exception we created.
	}
	
	public Car(int numOfDoors) {	// This is used if you want to change number of doors.
		this();
		this.numOfDoors = numOfDoors;
	}

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	
	
	@Override					// (Polymorphism) This is method overriding since the Car class is redefining the method that was
	public void startMoving() {	// defined by the Bus class.
		System.out.println("Car started moving.");
	}
	
	@Override
	public void stopMoving() {
		System.out.println("Car stopped moving.");
	}

	@Override
	public String toString() {
		return "Car [numOfDoors=" + numOfDoors + ", getNumOfWheels()=" + getNumOfWheels() + ", getMaxCapacity()="
				+ getMaxCapacity() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numOfDoors;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (numOfDoors != other.numOfDoors)
			return false;
		return true;
	}
	
}
