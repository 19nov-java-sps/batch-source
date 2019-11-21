package com.revature.animals;

public class ZooKeeper {

	public static void main(String[] args) {
		
		// Abstraction via Interfaces
		// The class Eagle implements both BirdInterface & AnimalInterface
		// The eat() & sound() methods come from the AnimalInterface 
		// While fly() comes from the BirdInterface
		
		Eagle myEagle = new Eagle();
		
		System.out.println("Name: " + myEagle.name);
		myEagle.eat();
		myEagle.sound();
		myEagle.fly();
		
		System.out.println("Number of legs: " + BirdInterface.numberOfLegs);
		
		
		System.out.println();
		System.out.println();
		
		
		// Encapsulation via access modifiers and Setter & Getter methods
		// Access only available by using Getter & Setter methods
		// Both Getter & Setter = Write & Read
		// Only Getter = Read only
		// Only Setter = Write only
		
		AnimalInfo myAnimalInfo = new AnimalInfo();
		
		myAnimalInfo.setName("Chimapanzee");
		myAnimalInfo.setAverageWeight(130.0);
		myAnimalInfo.setNumberOfLegs(2);
		
		System.out.println("Name: " + myAnimalInfo.getName());
		System.out.println("Average weight: " + myAnimalInfo.getAverageWeight());
		System.out.println("Number of legs: " + myAnimalInfo.getNumberOfLegs());
		
		
		System.out.println();
		System.out.println();
		
		
		// Inheritance 
		// An Eagle is a child class of its parent class Bird
		// Eagle subclass inherits all of Bird superclass' methods
		// and qualities
		
		System.out.println("Name: " + myEagle.name);
		System.out.println("Lifespan: " + myEagle.lifespan + " years");
		myEagle.flyUp();
		myEagle.flyDown();
		
		
		System.out.println();
		System.out.println();
		
		// Polymorphism
		// Bird & Bat extend the Animal class
		// Bird & Bat inherits its parent's eat() method
		// and define their own eat() 
		// Bird & Bat use their own polymorphic eat() methods
		
		
		Bird myBird = new Bird();
		System.out.println("A bird... ");
		myBird.eat();
		
		Bat myBat = new Bat();
		System.out.println("A bat... ");
		myBat.eat();
		
	
		System.out.println();
		System.out.println();
		
		
		
	}

}
