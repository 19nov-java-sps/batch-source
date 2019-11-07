package com.revature.shapes;

public class Driver {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(4,7);
		System.out.println(r);
		r.draw();
		
		Square s = new Square(5);
		System.out.println(s);
		s.draw();
		
		Rectangle s2 = new Square(5);
		System.out.println(s2);
		s2.draw();
	}

}
