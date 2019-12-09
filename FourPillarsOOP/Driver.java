package com.revature.fourpillars;

public class Driver {

	public static void main(String[] args) throws InvalidWeightException {

		Bat bat = new Bat();
		bat.setWings(2);
		bat.setColor("black");
		System.out.println(bat.toString() + bat.getEyes() + " eyes, " + "and its color is " + bat.getColor());
		bat.setSpeed(99);
		bat.move();
		bat.setWeight(2.5);
		bat.getWeight();

		System.out.println("----------------------------------------------------------");

		Dog dog = new Dog();
		dog.setLegs(4);
		dog.setColor("dark brown");
		System.out.println(dog.toString() + dog.getEyes() + " eyes, " + "and its color is " + dog.getColor());
		dog.setSpeed(20);
		dog.move();
		dog.setWeight(25.6);
		dog.getWeight();

		System.out.println("----------------------------------------------------------");

		Dolphin d = new Dolphin();
		d.setFins(5);
		d.setColor("light blue");
		System.out.println(d.toString() + d.getEyes() + " eyes, " + "and its color is " + d.getColor());
		d.setSpeed(10);
		d.move();
		d.setWeight(-350);
		d.getWeight();

	}

}
