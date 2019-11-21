package com.revature.animals;

public abstract class Animal {
	
	//abstract methods
	abstract void move();
	abstract void eat();
	
	//concrete method
	void label() {
		System.out.println("Animal's data:");
	}
	
}

// Abstraction

// With abstraction, you can hide the internal workings of 
// an object and only show the features the user needs to know about

// Java provides two ways to implement abstraction: abstract
// classes and interfaces

// With abstract classes, you can achieve partial abstraction, 
// while interfaces make total (100%) abstraction possible