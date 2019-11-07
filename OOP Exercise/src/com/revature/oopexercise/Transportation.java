package com.revature.oopexercise;
import com.revature.exceptions.NegativeCapacityException;

// (Abstraction) This abstract class doesn't show the other methods which are implemented from Drivable.

public abstract class Transportation implements Drivable {	// Since Transportation is abstract, we don't have to define the methods
															// from Drivable.
	private int maxCapacity;  // max passenger capacity
	
	public Transportation() {
		super();
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		if(maxCapacity >= 0) {
			this.maxCapacity = maxCapacity;
		} else {
			throw new NegativeCapacityException("Capacity cannot be below zero!");
		}
	}
	
}
