package com.revature.types;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		
		System.out.println("with equals " +string1.equals(string2));
		System.out.println(("with == " + (string1==string2)));
		
		String alsoString1 = string1;
		string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		

		System.out.println("with equals " +string1.equals(alsoString1));
		System.out.println(("with == " + (string1==alsoString1)));
	
		
		StringBuilder sb1 = new StringBuilder("I'm an object");
		StringBuilder sb2 = new StringBuilder("I'm an object");
		
		System.out.println(("with == " + (sb1==sb2)));
		
		StringBuilder alsosb1 = sb1;
		System.out.println("before changing sb1: " + (sb1==alsosb1));
		
		
	}
	
}
