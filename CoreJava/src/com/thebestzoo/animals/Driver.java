package com.thebestzoo.animals;

public class Driver {

	public static void main(String[] args) {
		Animal[] myAnimalCollection = new Animal[1];
		myAnimalCollection[0] = new Feline();
		myAnimalCollection[0].eat();
		
	}

}


