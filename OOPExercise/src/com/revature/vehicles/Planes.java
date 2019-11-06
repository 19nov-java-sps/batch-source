package com.revature.vehicles;

public class Planes extends Vehicles {
	//extends is inheritance
	public void Type() {
		System.out.println("Im a plane!");
	}
	public void modeOfTransportation() {
		System.out.println("Air");
	}
	public void myConcreteMethod() {
		System.out.println("We transport passengers");
	}
	//we are redefining or overriding our concrete method which is polymorphism
}
