package com.revature.fourpillars;

public class Bat extends Mammal implements Movable {

	// ENCAPSULATION: PRIVATE METHOD ONLY ACCESSED WITHIN THE CLASS
	private int wings;
	private int speed;

	// INHERITANCE: SUPER() SHARES PARENT CLASS VARS AND METHODS WITH CHILD CLASS
	public Bat() {
		super();
		this.speed = 0;
		setEyes(2);
	}

	// POLYMORPHISM: METHOD OVERRIDING
	@Override
	public void move() {
		fly(speed);
	}

	// ENCAPSULATION: PRIVATE METHOD ONLY ACCESSED WITHIN THE CLASS
	private void fly(int speed) {
		this.speed = speed;
		System.out.println("The bat is flying " + speed + "mph");
	}

	@Override
	protected double getWeight() {
		System.out.println("Bats weight is " + weight);
		return super.getWeight();
	}

	@Override
	protected void setWeight(double weight) throws InvalidWeightException {
		if (weight < 0)
			throw new InvalidWeightException("not a valid weight");
		else
			this.weight = weight;

	}

	// ENCAPSULATION: PROTECTED MODIFIER ACCESS WITHIN PACKAGE AND OUTSIDE PACKAGE
	// VIA CHILD CLASS
	protected int getWings() {
		return wings;
	}

	protected void setWings(int wings) {
		this.wings = wings;
	}

	protected int getSpeed() {
		return speed;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + speed;
		result = prime * result + wings;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Bat)) {
			return false;
		}
		Bat other = (Bat) obj;
		if (speed != other.speed) {
			return false;
		}
		if (wings != other.wings) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bat has " + wings + " wings, ";
	}

}
