package com.revature.exercise1;

public class Subway extends PublicTransportation {
	
	private String subwayLine;
	private String destination;
	
	public Subway() {
		super();
		setType("Subway");
	}
	
	// Constructor overloading
	public Subway(String subwayLine) {
		this();
		this.subwayLine = subwayLine;
	}
	
	public void speedIncrease() {
		int speed = this.getSpeed() + 2;
		if (speed <= 30) {
			this.setSpeed(speed);
		} else {
			this.setSpeed(30);
		}
	}
	
	public void speedDecrease() {
		int speed = this.getSpeed() - 3;
		if (speed >= 0) {
			this.setSpeed(speed);
		} else {
			this.setSpeed(0);
		}
	}
	
	public String getSubwayLine() {
		return subwayLine;
	}
	
	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	// polymorphism, method overloading
	public void setDestination() {
		this.destination = "Not In Service";
	}
	

	// hashcode and equals methods
	public int hashcode() {
		final int hash = 8;
		int res = hash * this.destination.hashCode() + this.subwayLine.hashCode() * 6;
		return res;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj.getClass() == Subway.class) {
			Subway subwayObj = (Subway) obj;
			return subwayObj.getSubwayLine() == this.getSubwayLine() && subwayObj.getDestination() == this.getDestination();
		}
		
		return false;
	}
	
}