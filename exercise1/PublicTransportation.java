package com.revature.exercise1;

import com.revature.exceptions.NegativeSpeedExceptions;

// abstract class
public abstract class PublicTransportation extends Transportation implements Interface {
	
	private int speed;
	
	public PublicTransportation() {
		super();
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		// custom exception
		if (speed < 0) {
			throw new NegativeSpeedExceptions("Speed Cannot Be NEGATIVE");
		}
		this.speed = speed;
	}
	
	// polymorphism, method overriding
	@Override
	public void getNextStop() {
		System.out.println("The Next Stop Is ...");
	}
	
	// abstract methods
	public abstract void speedIncrease();
	public abstract void speedDecrease();

}