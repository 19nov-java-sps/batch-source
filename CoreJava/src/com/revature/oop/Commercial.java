package com.revature.oop;

public abstract  class Commercial extends RealEstate implements RentCalculation{
	
	double investment;
	double rentRatePerSquareFeet; 
	double totalArea;
	
	public Commercial(){
		super();
	}
	
	public double totalRent(double totalArea, double rentRatePerSquareFeet) {
		return this.totalArea*this.rentRatePerSquareFeet;
	}

	public double ROI(double totalRent, double investment) {
		return totalRent/investment;
		
	}
}
