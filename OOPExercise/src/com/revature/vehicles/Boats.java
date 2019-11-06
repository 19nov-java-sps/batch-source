package com.revature.vehicles;

public class Boats extends Vehicles {
	//extends is inheritance
	public void Type() {
		System.out.println("Im a Boat!");
	}
	public void modeOfTransportation() {
		System.out.println("Water");
	}
	public void myConcreteMethod() {
		System.out.println("We transport passengers");
	}
	//we are redefining or overriding our concrete method which is polymorphism
}
