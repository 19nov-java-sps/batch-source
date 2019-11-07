package com.thebestzoo.animals;

public class Bird implements Animal, FlightCapable {
	
	
	@Override
	public void eat() {
		System.out.println("the animal is eating");
		
	}
	
	@Override 
	public void play() {
		System.out.println("the animal is playing");
	}
	
	@Override
	public void sleep() {
		System.out.println("the animal is sleeping");
	}
	
	public void fly() {
		
	}
	
}
