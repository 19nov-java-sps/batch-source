package com.revature.fourpillars;

public class Dog extends Mammal implements Movable {

	// ENCAPSULATION: PRIVATE VARIABLES ONLY ACCESSED WITHIN THE CLASS
	private int legs;
	private int speed;

	// INHERITANCE: SUPER() SHARES PARENT CLASS VARS AND METHODS WITH CHILD CLASS
	public Dog() {
		super();
		setEyes(2);
	}

	// POLYMORPHISM: METHOD OVERRIDING
	@Override
	public void move() {
		run(speed);
	}

	// ENCAPSULATION: PRIVATE METHOD ONLY ACCESSED WITHIN THE CLASS
	private void run(int speed) {
		this.speed = speed;
		System.out.println("The dog is running " + speed + "mph");
	}

	@Override
	protected double getWeight() {
		System.out.println("Dogs weight is " + weight);
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
	protected int getLegs() {
		return legs;
	}

	protected void setLegs(int legs) {
		this.legs = legs;
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
		result = prime * result + legs;
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
		if (!(obj instanceof Dog)) {
			return false;
		}
		Dog other = (Dog) obj;
		if (legs != other.legs) {
			return false;
		}
		if (speed != other.speed) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Dog has " + legs + " legs, ";
	}

}
