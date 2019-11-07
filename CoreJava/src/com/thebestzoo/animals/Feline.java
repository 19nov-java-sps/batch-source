package com.thebestzoo.animals;

public class Feline implements Animal {
	
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
	

}
