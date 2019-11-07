package com.thebestzoo.animals;

public class Driver {

	public static void main(String[] args) {
		
		
		//when the application starts, the system generates random number for health, happiness, and sleepiness
		int max = 10; 
	    int min = 1; 
	    int range = max - min + 1; 
		int randomNumber = (int)(Math.random() * range) + min; 

		System.out.println(randomNumber);
		
		//create animal tomogatchi either feline or bird type
		
		if (randomNumber % 2 == 0) {
			Animal[] myPetAnimal = new Animal[1];
			myPetAnimal[0] = new Feline();
			//set happiness, tireness, sleepiness
		} else {
			Animal[] myPetAnimal = new Animal[1];
			myPetAnimal[0] = new Bird();
			//set happiness, tireness, sleepiness
		}
		
		// set time interval to lower values 
		
		// if happiness || sleepiness || health < 4 
		//set alert on console 
		
		// client can feed, play and make them to sleep
		
		
		
		
	}

}


