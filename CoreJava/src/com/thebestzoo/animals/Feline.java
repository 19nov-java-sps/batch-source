package com.thebestzoo.animals;

public class Feline implements Animal {
	
	private int health;
	private int happiness;
	private int tireness;
	
	@Override
	public void eat() {
		System.out.println("the animal is eating");
		health = health + 1;
		happiness = happiness + 1;
	}
	
	@Override 
	public void play() {
		System.out.println("the animal is playing");
		happiness = happiness + 1;
		tireness = tireness + 2;
	}
	
	@Override
	public void sleep() {
		System.out.println("the animal is sleeping");
		happiness = happiness + 2;
		health = health + 1;
		
	}

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
	

}
