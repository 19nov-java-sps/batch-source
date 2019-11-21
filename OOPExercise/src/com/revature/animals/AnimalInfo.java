package com.revature.animals;

import com.revature.exceptions.NegativeLegsException;

public class AnimalInfo {

	private String name;
	private double averageWeight;
	private int numberOfLegs;
	
	// Getter methods
	public String getName() {
		return name;
	}
	public double getAverageWeight() {
		return averageWeight;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	// Setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setAverageWeight(double averageWeight) {
		this.averageWeight = averageWeight;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		//this.numberOfLegs = numberOfLegs;
		if(numberOfLegs>0) {
			this.numberOfLegs = numberOfLegs;
		} else {
			throw new NegativeLegsException("Cannot have an animal with a negative number of legs; "+numberOfLegs+" is invalid");
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfLegs;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AnimalInfo)) {
			return false;
		}
		AnimalInfo other = (AnimalInfo) obj;
		if (name == null) {
			if (other.name!= null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (numberOfLegs != other.numberOfLegs) {
			return false;
		}
		return true;
	}
}

// Encapsulation

// With encapsulation, you can protect the fields of a class. To do 
// so, declare the fields as private and providing access to them with getter and setter methods.

// The AnimalInfo class above is fully encapsulated. 
// It has three private fields and each of them has its own set of getter and setter methods.