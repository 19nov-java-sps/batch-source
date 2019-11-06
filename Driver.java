package com.revature.character;

public class Driver {
	
	public static void main(String[] args) {
		
		Warrior Artorius = new Warrior("Artorius", 100);
		Magician Odin = new Magician("Odin", 100);
		
		Odin.speak();
		Artorius.speak();
		
		System.out.println("==================Stats===================");
		System.out.println(Odin.toString());
		System.out.println(Artorius.toString());
		
		//the characters engage in turn based combat
		int turn = 0;
		while(Odin.isAlive() && Artorius.isAlive()) {
			turn += 1;
			System.out.println("==================Turn " + turn+"===================");
			try {
				Odin.takeDamage(Artorius.physicalAttack());
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				Artorius.takeDamage(Odin.magicalAttack());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println("==================Results===================");
		System.out.println(Odin.toString());
		System.out.println(Artorius.toString());	
		
		try {
			Odin.takeDamage(Artorius.physicalAttack());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
