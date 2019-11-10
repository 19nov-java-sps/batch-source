package com.revature.oop;

public interface RentCalculation {
	
	//Abstract method
	public double totalRent();
	
	
	
	//Concrete method the same as in AreaCalculation interface
	public static double totalArea(double length, double width) {
		 double totalArea=length*width*3;
		 return totalArea;
	}
}

