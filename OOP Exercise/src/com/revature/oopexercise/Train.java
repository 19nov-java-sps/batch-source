package com.revature.oopexercise;
// (Encapsulation) Here we add getters and setters in order to "encapsulate" data that you wouldn't want to be accessed directly.
public class Train extends Transportation {
	
	private int numOfWagons;
	
	public Train() {
		super();
		setMaxCapacity(500);
		setNumOfWagons(10);
	}
	
	public Train(int numOfWagons) {
		this();
		this.numOfWagons = numOfWagons;
	}

	public int getNumOfWagons() {
		return numOfWagons;
	}

	public void setNumOfWagons(int numOfWagons) {
		this.numOfWagons = numOfWagons;
	}
	
	@Override
	public void startMoving() {
		System.out.println("Train started moving.");
	}
	
	@Override
	public void stopMoving() {
		System.out.println("Train stopped moving.");
	}

	@Override
	public String toString() {
		return "Train [numOfWagons=" + numOfWagons + ", getMaxCapacity()=" + getMaxCapacity() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfWagons;
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
		Train other = (Train) obj;
		if (numOfWagons != other.numOfWagons)
			return false;
		return true;
	}

	
}
