package com.revature.pillars;

public abstract class Vehicle {

	private int numWheels;
	private int numSeats;
	
	public Vehicle() {
		super();
	}
	
	public abstract void push();
	
	public int getNumWheels() {
		return numWheels;
	}
	
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	
	public int getNumSeats() {
		return numSeats;
	}
	
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
}
