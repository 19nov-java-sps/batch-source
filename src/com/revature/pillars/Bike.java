package com.revature.pillars;

public class Bike extends Vehicle implements Speed{

	int speed = 0;
	
	public Bike() {
		super();
		setNumSeats(1);
		setNumWheels(2);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public int speedUp() {
		speed = speed + 5;
		return speed;
	}
	@Override
	public int speedDown() {
		speed = speed -5;
		return speed;
	}
	
	@Override
	public String toString() {
		return "The speed is " + speed;
	}
}
