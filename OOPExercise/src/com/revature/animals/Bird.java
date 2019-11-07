package com.revature.animals;

public class Bird extends Animal {
	
	public int speed = 20;
	public int wings = 2;
	
	public void flyUp() {
		System.out.println("Flying up...");
	}
	
	public void flyDown() {
		System.out.println("Flying down...");
	}
	
	@Override
	void eat() {
		System.out.println("Eats worms.");
	}

	@Override
	void move() {
		System.out.println("Moves by flying.");
		
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
		if (!(obj instanceof Bird)) {
			return false;
		}
		Bird other = (Bird) obj;
		if (wings != other.wings) {
			return false;
		}
		if (speed != other.speed) {
			return false;
		}
		return true;
	}
}



// Polymorphism

// The ability for objects & methods to behave differently 
// depending on the context they're in

// Above is an example of Dynamic Polymorphism by using method overriding
// Bird class is a child of Animal class and inherits its parent's eat() 
// and move() methods but defines its own version of eat() and move()
