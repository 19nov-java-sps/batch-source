package com.revature.pillars;

import com.revature.exceptions.NegSpeedException;

public class Driver {

	public static void main(String args[]) {
		Bike b = new Bike();
		b.setSpeed(15);

		try {
			b.speedDown();
			b.speedDown();
			b.speedDown();
			b.speedDown();
			b.speedDown();
		} catch (NegSpeedException e) {
			System.out.println("Cannot speed down anymore");
		}
		System.out.println(b + " The Vehicle has " + b.getNumSeats() + " and it has " + b.getNumWheels());
	}
}
