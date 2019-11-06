package com.revature.vehicles;

public class Cars extends Vehicles implements InterfaceA {
	//extends is inheritance
	public void Type() {
		System.out.println("Im a car!");
	}
	public void modeOfTransportation() {
		System.out.println("Ground");
	}
	public void myConcreteMethod() {
		System.out.println("We transport passengers");
	}
	//we are redefining or overriding our concrete method which is polymorphism
}
