package com.revature.character;

public abstract class Human {

	public void speak() {
		System.out.print("Hello. ");
	}
	
	public abstract int physicalAttack() throws Exception;
	
	public abstract int magicalAttack() throws Exception;
}
