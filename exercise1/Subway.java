package com.revature.exercise1;

public class Subway extends PublicTransportation implements SubwayInterface {
	
	private String destination;
	
	public Subway() {
		super();
		setType("Subway");
	}
	
	public void speedIncrease() {
		this.setSpeed(this.getSpeed() + 2);
	}
	
	public void speedDecrease() {
		this.setSpeed(this.getSpeed() - 3);
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	// polymorphism, method overloading
	public void setDestination() {
		this.destination = "No destination";
	}
	
	// polymorphism, method overriding
	@Override
	public void getNextStop() {
		System.out.println("The next stop is ...");
	}
}