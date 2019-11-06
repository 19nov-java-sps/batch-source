package com.revature.exercise1;

public abstract class PublicTransportation extends Transportation {
	
	private int speed;
	
	public PublicTransportation() {
		super();
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
		}
		this.speed = speed;
	}
	
	// abstract methods
	public abstract void speedIncrease();
	public abstract void speedDecrease();

}