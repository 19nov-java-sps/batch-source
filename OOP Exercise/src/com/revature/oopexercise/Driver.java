package com.revature.oopexercise;

public class Driver {
	
	public static void main(String[] args) {
		Bus B = new Bus();
		System.out.println("B: " + B.toString());	// Showing what toString prints out.
		B.startMoving();
		
		Car C = new Car();
		System.out.println("\nC has " + C.getNumOfDoors() + " doors, " + C.getNumOfWheels() + 
							" wheels and has a max capacity of " + C.getMaxCapacity() + ".");
		
		Train T = new Train();
		System.out.println("\nT has " + T.getNumOfWagons() + " wagons and has a max capacity of " 
							+ T.getMaxCapacity() + ".");
		T.startMoving();
		
		Car C2 = new Car(2);	// This Car object uses the overloaded constructor to assign "2" to numOfDoors.
		System.out.println("\nC2 has " + C2.getNumOfDoors() + " doors, " + C2.getNumOfWheels() + 
				" wheels and has a max capacity of " + C2.getMaxCapacity() + ".\n");

		T.stopMoving();
		B.stopMoving();
		
	}
}
