package com.revature.shapes;

public class Driver {
	public static void main(String[] args ) {
		Rectangle r = new Rectangle(4,7);
		System.out.println(r);
		r.drow();
		
		Squere s = new Squere(5);
		System.out.println(s);
		s.drow();
		
		Rectangle s2 = new Squere(5);
		System.out.println(s.toString());
		s2.drow();
		

		s2.setNumOfSides(-4);
		System.out.println(s2.getNumOfSides());
	}

}
