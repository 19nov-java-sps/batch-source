package com.revature.fourpillars;

public class Mammal {

	// ENCAPSULATION: PRIVATE VARIABLES ONLY ACCESSED WITHIN THE CLASS
	private int eyes;
	private String color;
	protected double weight;

	public Mammal() {
		super();
	}

	// ENCAPSULATION: GETTERS & SETTERS
	// PROTECTED MODIFIER ACCESS WITHIN PACKAGE AND OUTSIDE PACKAGE VIA CHILD CLASS
	protected int getEyes() {
		return eyes;
	}

	// ENCAPSULATION: PROTECTED MODIFIER ACCESS WITHIN PACKAGE AND OUTSIDE PACKAGE
	// VIA CHILD CLASS
	protected void setEyes(int eyes) {
		this.eyes = eyes;
	}

	protected String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
	}

	protected double getWeight() {
		return weight;
	}

	protected void setWeight(double weight) throws InvalidWeightException {
		if (weight < 0)
			throw new InvalidWeightException("not valid weight");
		else
			this.weight = weight;
		System.out.println("Mammals weight is " + weight);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + eyes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mammal)) {
			return false;
		}
		Mammal other = (Mammal) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (eyes != other.eyes) {
			return false;
		}
		return true;
	}

}
