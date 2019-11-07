package com.revature.exercise1;

// inheritance from subway class
public class Driver extends Subway {
	
	public static void main(String[] args) {
		
		Subway s = new Subway("D");
		System.out.println(s.getType());
		
		s.setSpeed(29);
		s.speedIncrease();
		System.out.println(s.getSpeed());
		
		System.out.println(s.getSubwayLine());
		
		s.setDestination("Norwood - 205 St");
		System.out.println(s.getDestination());
		
		System.out.println(Interface.PRICE);
		
		Transportation t = new Transportation();
		System.out.println(s.equals(t));
		
	}
}