package com.revature.vehicles;
//abstract public superclass that all concrete class inherit from
public abstract class Vehicle implements Expectations {
	//example of encapsulation
	private String TypeOfVehicles;
	
	public Vehicle() {
		super();
	}
	//get and setter
	public String getTypeOfVehicle() {
		return TypeOfVehicles;
	
	}
		
	public void setTypeOfVehicle(String TypeOfVehicles){
		this.TypeOfVehicles = TypeOfVehicles;
	}
	// an example of abstraction because it took the riding method from the interface
	@Override
	public void riding() {
		System.out.println("Riding a Vehicle");
		
	}
}
