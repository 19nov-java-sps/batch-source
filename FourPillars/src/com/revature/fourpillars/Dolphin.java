package com.revature.fourpillars;

public class Dolphin extends Mammal implements Movable {

	// ENCAPSULATION: PRIVATE VARIABLES ONLY ACCESSED WITHIN THE CLASS
	private int fins;
	private int speed;

	// INHERITANCE: SUPER() SHARES PARENT CLASS VARS AND METHODS WITH CHILD CLASS
	public Dolphin() {
		super();
		setEyes(2);
	}

	// POLYMORPHISM: METHOD OVERRIDING
	@Override
	public void move() {
		swim(speed);
	}

	// ENCAPSULATION: PRIVATE METHOD ONLY ACCESSED WITHIN THE CLASS
	private void swim(int speed) {
		this.speed = speed;
		System.out.println("The dolphin is swimming " + speed + "mph");
	}

	@Override
	protected double getWeight() {
		System.out.println("Dolphins weight is " + weight);
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
	protected int getFins() {
		return fins;
	}

	protected void setFins(int fins) {
		this.fins = fins;
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
		result = prime * result + fins;
		result = prime * result + speed;
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
		if (!(obj instanceof Dolphin)) {
			return false;
		}
		Dolphin other = (Dolphin) obj;
		if (fins != other.fins) {
			return false;
		}
		if (speed != other.speed) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Dolphin has " + fins + " fins, ";
	}

}
