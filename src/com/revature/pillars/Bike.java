package com.revature.pillars;

import com.revature.exceptions.NegSpeedException;
import com.revature.exceptions.StartSpeedException;

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
		if (speed>0) {
			this.speed = speed;
		} else {
			throw new StartSpeedException("Speed cannot be lower than 0");
		}
	}
	@Override
	public int speedUp() {
		speed = speed + 5;
		return speed;
	}
	@Override
	public int speedDown() throws NegSpeedException {
		if (speed>0) {
			speed = speed -5;
		}
		else {
			throw new NegSpeedException("Cannot decrease speed");
		}
		return speed;
	}
	
	@Override
	public String toString() {
		return "The speed is " + speed;
	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		System.out.println("I am pushing");
	}
}
