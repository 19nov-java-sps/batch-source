package com.revature.exercise1;

// inheritance from subway class
public class NTrain extends Subway {
	
	public static void main(String[] args) {
		Subway n1 = new Subway();
		System.out.println(n1.getType());
		n1.setSpeed(10);
		n1.speedIncrease();
		System.out.println(n1.getSpeed());
		n1.setDestination("34 ST");
		System.out.println(n1.getDestination());
		System.out.println(SubwayInterface.PRICE);
	}
}