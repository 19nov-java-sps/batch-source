package com.thebestzoo.animals;

public class Driver {

	public static void main(String[] args) {
		
		
		
		//when the application starts, the system generates random number for health, happiness, and sleepiness
		int max = 10; 
	    int min = 1; 
	    int range = max - min + 1; 
	    //prevents values less than zero
		final int randomHealth = (int)(Math.random() * range) + min; 
		final int randomTireness = (int)(Math.random() * range) + min;
		final int randomHappiness = (int)(Math.random() * range) + min;


		System.out.println("==================================================");
		Feline lion = new Feline(randomHealth, randomHappiness, randomTireness);
		
		int x = lion.getHappiness();
		System.out.println(x);
		
		
//		if  (lion.getHappiness()  0) {
//			System.out.println("blah");
//		}
//		
		System.out.println("==========");
		lion.getHealth();

		System.out.println("==========");
		lion.getTireness();
		
		
		
		// set time interval to lower values 
		
		// if happiness || sleepiness || health < 4 
		//set alert on console 
		
		// client can feed, play and make them to sleep
		
		
		
		
	}

}


