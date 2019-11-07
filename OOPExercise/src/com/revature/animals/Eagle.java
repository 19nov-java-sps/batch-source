package com.revature.animals;

public class Eagle extends Bird implements AnimalInterface, BirdInterface {
	
	public String name = "Eagle";
	public int lifespan = 15;
	
	
	public void eat() {
		System.out.println("Eats reptiles and amphibians.");
	}
	
	public void sound() {
		System.out.println("Has a high-pitched whistling sound.");
	}
	
	public void fly() {
		System.out.println("Flies up to 10,000 feet in the air.");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + lifespan;
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
		if (!(obj instanceof Eagle)) {
			return false;
		}
		Eagle other = (Eagle) obj;
		if (name == null) {
			if (other.name!= null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (lifespan != other.lifespan) {
			return false;
		}
		return true;
	}
}



// Inheritance

// Inheritance allows our classes to share qualities through parent/child relationships
// Eagle and Bird have an "IS-A" relationship

// Here the Eagle class extends the Bird parent class and inherits all of its fields
// As well ass defines two extra fields that belong only to Eagle