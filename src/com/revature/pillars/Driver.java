package com.revature.pillars;

public class Driver {

	public static void main(String args[]) {
		Bike b = new Bike();
		b.setSpeed(15);
		b.speedUp();
		b.speedUp();
		System.out.println(b + " The Vehicle has " + b.getNumSeats() + " and it has " + b.getNumWheels());
	}
}
