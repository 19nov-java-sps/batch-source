package com.revature.vehicles;

public class Driver{

	public static void main(String[] args) {
		
	
		Car c = new Car(2000,2);
		c.riding();
		System.out.println(c);
		
		Bicycle b = new Bicycle(2010,0);
		b.riding();
		System.out.println(b);
		
		Ford s =  new Ford("Turbo");
		s.riding();
		System.out.println(s);
		
		RacingBicycle r = new RacingBicycle("Extreme");
		r.riding();
		System.out.println(r);
		
		
	}
}
