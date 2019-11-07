package com.thebestzoo.animals;

public class Feline implements Animal {
	
	private int health;
	private int happiness;
	private int tireness;
	
	public Feline(int health, int happiness, int tireness) {
		this();
		this.health = health;
		this.happiness = happiness;
		this.tireness = tireness;
		
		
	}
	
	public Feline() {
		// TODO Auto-generated constructor stub
	}

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

	public void getHealth() {
		System.out.println(health);
	}


	public void getHappiness() {
		System.out.println(happiness);
	}



	public void getTireness() {
		System.out.println(tireness);
	}

	

}
