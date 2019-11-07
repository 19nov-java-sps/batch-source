package com.thebestzoo.animals;

public class Bird implements Animal {
	
	private int health;
	private int happiness;
	private int tireness;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getTireness() {
		return tireness;
	}

	public void setTireness(int tireness) {
		this.tireness = tireness;
	}

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
